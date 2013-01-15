(ns ils.models.dominio.BD.insercao
    (:use [ils.models.dominio.BD persistence]
          [ils.models.dominio.BD busca])
    (:require [clojure.xml :as xml]
  			[clojure.zip :as zip] 
			[clojure.contrib.zip-filter.xml :as zf]
			[clojure.java.jdbc :as sql]))


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
      {:sigla sigla :conteudo conteudo}
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
       :conteudo (get-value xml :conteudo) 
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
       :conteudo (get-value xml :conteudo) 
       :tipo (get-value xml :tipo)
       :idEst (first (vals (first (buscar-estilo "idEst" (get-value xml :selecao) (get-value xml :organizacao) (get-value xml :utilizacao)))))
       :xmlapresentacao (slurp xml)}
    )))

(defn inserir-conteudoAluno 
  "Insere um novo aproveitamento de um aluno em determinado conteudo."
   [matricula nconteudo qbom qmedio qruim]
   (sql/with-connection ILS-DB
    (sql/insert-records :conteudoAluno
      {:matricula matricula :conteudo nconteudo :bom qbom :medio qmedio :ruim qruim}
    )))	

(defn inserir-exercicioAluno
  "Insere um novo aproveitamento de um aluno em determinado exercicio."
   [matricula conteudo idEx qbom qmedio qruim]
   (sql/with-connection ILS-DB
    (sql/insert-records :exercicioAluno
      {:matricula matricula :conteudo conteudo :idEx idEx :bom qbom :medio qmedio :ruim qruim}
    )))  
  
(defn inserir-estilo
  "Insere um novo estilo de aprendizadgem de um aluno, para um curso, no banco. Determinado pelo módulo pedagógico, e pode ser alterado."
   [idEst selecao organizacao utilizacao]
   (sql/with-connection ILS-DB
    (sql/insert-records :estilo
      {:idEst idEst :selecao selecao :organizacao organizacao :utilizacao utilizacao}
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
       :conteudo (get-value xml :conteudo) 
       :idEx (get-value xml :idEx) 
       :xmlbug (slurp xml)}
    ))) 
    

   

