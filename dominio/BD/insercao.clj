(ns ils.models.dominio.BD.insercao
    (:use [ils.models.dominio.BD.persistence]
          [ils.models.dominio.BD.busca])
    (:require [clojure.xml :as xml]
  		[clojure.zip :as zip] 
			[clojure.contrib.zip-filter.xml :as zf]
			[clojure.java.jdbc :as sql]))


(defn next-val-conteudo 
  "Executa o comando SQL nextval('sequencia') para a sequencia seqconteudo."
  []
  (sql/with-connection ILS-DB
   (sql/with-query-results res
        ["SELECT NEXTVAL('seqconteudo');"]
          (doall res))))

(defn next-val-exercicio
  "Executa o comando SQL nextval('sequencia') para a sequencia seqexercicio."
  []
  (sql/with-connection ILS-DB
   (sql/with-query-results res
        ["SELECT NEXTVAL('seqexercicio');"]
          (doall res))))

(defn next-val-bug
  "Executa o comando SQL nextval('sequencia') para a sequencia seqexercicio."
  []
  (sql/with-connection ILS-DB
   (sql/with-query-results res
        ["SELECT NEXTVAL('seqbug');"]
          (doall res))))

(defn next-val-apresentacao
  "Executa o comando SQL nextval('sequencia') para a sequencia seqapresentacao."
  []
  (sql/with-connection ILS-DB
   (sql/with-query-results res
        ["SELECT NEXTVAL('seqapresentacao');"]
          (doall res))))

(defn next-val-estilo
  "Executa o comando SQL nextval('sequencia') para a sequencia seqestilo."
  []
  (sql/with-connection ILS-DB
   (sql/with-query-results res
        ["SELECT NEXTVAL('seqestilo');"]
          (doall res))))

(defn next-val-log
  "Executa o comando SQL nextval('sequencia') para a sequencia seqlog."
  []
  (sql/with-connection ILS-DB
   (sql/with-query-results res
        ["SELECT NEXTVAL('seqlog');"]
          (doall res))))

(defn get-value [xml & tags]
 "Pega o xml de um arquivo e o guarda em uma estrutura."
  (apply zf/xml1-> (zip/xml-zip (xml/parse xml)) (conj (vec tags) zf/text)))


(defn inserir-aluno
  "Insere um novo aluno no banco."
   [matricula nome sobrenome curso email usuario senha disciplina]
   (sql/with-connection ILS-DB
    (sql/insert-records :aluno
      {:matricula matricula :nome nome :sobrenome sobrenome :curso curso :email email 
       :usuario usuario :senha senha :disciplina disciplina} ;precisa de algoritmo SHA1 ou MD5 para senha
    ))) 
    
(defn inserir-professor
  "Insere um novo professor no banco."
   [matricula nome sobrenome titulo email usuario senha]
   (sql/with-connection ILS-DB
    (sql/insert-records :professor
      {:matricula matricula :nome nome :sobrenome sobrenome :titulo titulo :email email :usuario usuario :senha senha} ;precisa de algoritmo SHA1 ou MD5 para senha
    )))   
    
(defn inserir-disciplina
  "Insere uma nova disciplina no banco."
   ([xml]
    (sql/with-connection ILS-DB
    (sql/insert-records :disciplina
      {:sigla (get-value xml :sigla)
       :nome (get-value xml :nome)
       :xmlhierarquia (slurp xml)})))
   ([sigla nome xml]
   (sql/with-connection ILS-DB
    (sql/insert-records :disciplina
      {:sigla sigla :nome nome :xmlhierarquia (slurp xml)}
    ))))   
    
(defn inserir-conteudo
  "Insere um novo conteudo de alguma disciplina no banco."
   [sigla conteudo]
   (sql/with-connection ILS-DB
    (sql/insert-records :conteudo
      {:idCont (str "cont"(first (vals (first (next-val-conteudo)))))
       :sigla sigla 
       :conteudo conteudo}
    )))  
    
(defn inserir-ministra
  "Insere uma nova tupla em ministra, que indica quais professores ministram quais disciplinas."
   [sigla matricula]
   (sql/with-connection ILS-DB
    (sql/insert-records :ministra
      {:matricula matricula :sigla sigla}
    )))  

(defn inserir-exercicio
  "Funcao para inserir os xml prontos de exercicio no banco. 
   A função é usada juntamente com a função slurp, que lê um arquivo em Clojure."
   [xml]
   (sql/with-connection ILS-DB
    (sql/insert-records :exercicio
      {:idEx (get-value xml :idEx) 
       :idCont (first (vals (first (buscar-conteudo "idCont" "conteudo" (get-value xml :conteudo))))) 
       :nivel (get-value xml :nivel) 
       :tipo (get-value xml :tipo) 
       :xmlexercicio (slurp xml)}
    )))
      
(defn inserir-apresentacao
  "Funcao para inserir os xml prontos de apresentacao no banco. 
   A função é usada juntamente com a função slurp, que lê um arquivo em Clojure."
   [xml]
   (sql/with-connection ILS-DB
    (sql/insert-records :apresentacao
      {:idAp (get-value xml :idAp) 
       :idCont (first (vals (first (buscar-conteudo "idCont" "conteudo" (get-value xml :conteudo))))) 
       :tipo (get-value xml :tipo)
       :idEst (first (vals (first (buscar-estilo "idEst" (get-value xml :selecao) (get-value xml :organizacao) (get-value xml :utilizacao)))))
       :xmlapresentacao (slurp xml)}
    )))

(defn inserir-conteudoAluno 
  "Insere um novo aproveitamento de um aluno em determinado conteudo."
   [matricula sigla conteudo qbom qmedio qruim]
   (sql/with-connection ILS-DB
    (sql/insert-records :conteudoAluno
      {:matricula matricula 
       :idCont (first (vals (first (buscar-conteudo "idCont" "sigla" sigla "conteudo" conteudo))))  
       :bom qbom 
       :medio qmedio 
       :ruim qruim}
    )))	

(defn inserir-exercicioAluno
  "Insere um novo aproveitamento de um aluno em determinado exercicio."
   [matricula sigla conteudo idEx qbom qmedio qruim]
   (sql/with-connection ILS-DB
    (sql/insert-records :exercicioAluno
      {:matricula matricula 
       :idCont (first (vals (first (buscar-conteudo "idCont" "sigla" sigla "conteudo" conteudo))))  
       :idEx idEx 
       :bom qbom 
       :medio qmedio 
       :ruim qruim}
    )))  
  
(defn inserir-estilo
  "Insere um novo estilo de aprendizadgem de um aluno, para um curso, no banco. Determinado pelo módulo pedagógico, e pode ser alterado."
   [selecao organizacao utilizacao]
   (sql/with-connection ILS-DB
    (sql/insert-records :estilo
      {:idEst (str "est"(first (vals (first (next-val-estilo)))))
       :selecao selecao 
       :organizacao organizacao 
       :utilizacao utilizacao}
    )))    
    
(defn inserir-estiloEstudante
  "Insere um novo estilo de aprendizadgem de um aluno, para um curso, no banco. Determinado pelo módulo pedagógico, e pode ser alterado."
   [matricula sigla selecao organizacao utilizacao]
   (sql/with-connection ILS-DB
    (sql/insert-records :estiloEstudante
      {:matricula matricula 
       :sigla sigla 
       :idEst (first (vals (first (buscar-estilo "idEst" selecao organizacao utilizacao))))
       }
    )))  
    
(defn inserir-catalogoBug
  "Insere um novo erro cometido por um estudante em determinado exercicio pelo estudante. O xml de erro também é armazenado
   para possíveis análises do módulo pedagógico e do estudante."
   [xml]
   (sql/with-connection ILS-DB
    (sql/insert-records :catalogoBug
      {:idBug (get-value xml :idBug)
       :matricula (get-value xml :matricula)
       :idCont (first (vals (first (buscar-conteudo "idCont" "conteudo" (get-value xml :conteudo)))))  
       :idEx (get-value xml :idEx) 
       :xmlbug (slurp xml)}
    ))) 
    
(defn inserir-logAluno
  "Insere um novo log de aluno no banco. Este log serve para que seja armazenada a disciplina, o conteúdo e o exercício
   onde o estudante parou em sua última sessão no sistema."
   [matricula sigla idCont idEx]
   (sql/with-connection ILS-DB
    (sql/insert-records :logAluno
      {:idLog (str "log"(first (vals (first (next-val-log)))))
       :matricula matricula
       :sigla sigla
       :idCont idCont ;idCont foi preservado ao invés da busca por ter desempenho melhor
       :idEx idEx}
    )))

(defn inserir-matricula
  "Matricula um aluno em algum disciplina."
   [matricula sigla]
   (sql/with-connection ILS-DB
    (sql/insert-records :matricula
      {:matricula matricula
       :sigla sigla}
    )))