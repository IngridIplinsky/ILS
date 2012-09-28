(ns ils.models.estudante.corygil.estudante
  (:use
   ils.models.estudante.corygil.factor-graph)
  (:use
   ils.models.estudante.corygil.factor-graph.bayes)
  (:use 
    ils.models.dominio.dominio)
  (:require 
   [clojure.java.jdbc :as sql]))

;Árvore de junção do modelo do domínio do artigo:
;Ambientes Inteligentes de Aprendizagem: Uma proposta baseada em hipermídia adaptativa e redes bayesianas. Nunes
;Esta árvore de junção tem fins de propagação, sendo uma ferramenta auxiliar na propagação através de distribuição marginal, sendo feita.
(def dominio
	  (bayes-net
	    {
	    :ABE [0.33 0.33 0.34]
		:DBE 3
		:BAD 3
		:BDC 3
		:EAD 3
		:BDF 3
		:BHF 3
		:CBF 3
		:CDF 3
		:FDH 3
		:FJH 3
		:HJD 3
		:HIJ 3
		:HDI 3
		:IJD 3
		:IJG 3
		:IEG 3
		:GJE [0.33 0.33 0.34]
		:EHI 3
		:EDH 3
		:EDI 3
	    }
	    {
	     

	     [:DBE :ABE] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 
 	
	     [:BAD :DBE] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:BDC :BAD] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 
		
	     [:EAD :BDC] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:BDF :EAD] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

 	     [:BHF :BDF] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:CBF :BHF] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:CDF :CBF] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:FDH :CDF] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:FJH :FDH] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:HJD :FJH] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:HIJ :HJD] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

		
	     [:HDI :HIJ] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:IJD :HDI] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:IJG :IJD] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03]  


	     [:IEG :IJG :GJE] 
	     [	1.0 	0.0 	0.0
		0.45 	0.33 	0.22
		0.0 	0.0 	1.0
		0.82 	0.09 	0.09
		0.315 	0.37 	0.315
		0.182 	0.23 	0.545
		1.0 	0.0 	0.0
		0.68 	0.11 	0.21
		0.08 	0.42 	0.5]

	     [:EHI :IEG] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:EDH :EHI] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

     	     [:EDI :EDH] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

 	}))


(def tanara {
	:estrutura-dados [0.33 0.33 0.34]
	:alocDin [0.33 0.33 0.34]
	:vetor [0.33 0.33 0.34]
	:recursiv [0.33 0.33 0.34]
	:lista [0.33 0.33 0.34]
	:arvore [0.33 0.33 0.34]
        :fila [0.33 0.33 0.34]
     	:pilha [0.33 0.33 0.34]
	:metOrd [0.33 0.33 0.34]
	:metPesq [0.33 0.33 0.34]
})

		
(def estrutura-dados
    {		:ed001 [0.33 0.33 0.34]
		:ed002 [0.33 0.33 0.34]
		:ed003 [0.33 0.33 0.34]
		:ed004 [0.33 0.33 0.34]
		:ed005 [0.03 0.33 0.64]
		:ed006 [0.13 0.53 0.34]
		:ed007 [0.20 0.43 0.37]
		:ed008 [0.33 0.33 0.34]
		:ed009 [0.33 0.33 0.34]
		:ed010 [0.33 0.33 0.34]
	})


(def alocDin
    {		:ad001 [0.33 0.33 0.34]
		:ad002 [0.33 0.33 0.34]
		:ad003 [0.33 0.33 0.34]
		:ad004 [0.33 0.33 0.34]
		:ad005 [0.03 0.33 0.64]
		:ad006 [0.13 0.53 0.34]
		:ad007 [0.20 0.43 0.37]
		:ad008 [0.33 0.33 0.34]
		:ad009 [0.33 0.33 0.34]
		:ad010 [0.33 0.33 0.34]
	})

(def vetor
    {		:v001 [0.33 0.33 0.34]
		:v002 [0.33 0.33 0.34]
		:v003 [0.33 0.33 0.34]
		:v004 [0.33 0.33 0.34]
		:v005 [0.03 0.33 0.64]
		:v006 [0.13 0.53 0.34]
		:v007 [0.20 0.43 0.37]
		:v008 [0.33 0.33 0.34]
		:v009 [0.33 0.33 0.34]
		:v010 [0.33 0.33 0.34]
	})

(def recursiv
    {		:r001 [0.33 0.33 0.34]
		:r002 [0.33 0.33 0.34]
		:r003 [0.33 0.33 0.34]
		:r004 [0.33 0.33 0.34]
		:r005 [0.03 0.33 0.64]
		:r006 [0.13 0.53 0.34]
		:r007 [0.20 0.43 0.37]
		:r008 [0.33 0.33 0.34]
		:r009 [0.33 0.33 0.34]
		:r010 [0.33 0.33 0.34]
	})

(def lista
    {		:l001 [0.33 0.33 0.34]
		:l002 [0.33 0.33 0.34]
		:l003 [0.33 0.33 0.34]
		:l004 [0.33 0.33 0.34]
		:l005 [0.03 0.33 0.64]
		:l006 [0.13 0.53 0.34]
		:l007 [0.20 0.43 0.37]
		:l008 [0.33 0.33 0.34]
		:l009 [0.33 0.33 0.34]
		:l010 [0.33 0.33 0.34]
	})

(def arvore
    {		:a001 [0.33 0.33 0.34]
		:a002 [0.33 0.33 0.34]
		:a003 [0.33 0.33 0.34]
		:a004 [0.33 0.33 0.34]
		:a005 [0.03 0.33 0.64]
		:a006 [0.13 0.53 0.34]
		:a007 [0.20 0.43 0.37]
		:a008 [0.33 0.33 0.34]
		:a009 [0.33 0.33 0.34]
		:a010 [0.33 0.33 0.34]
	})

(def fila
    {		:f001 [0.33 0.33 0.34]
		:f002 [0.33 0.33 0.34]
		:f003 [0.33 0.33 0.34]
		:f004 [0.33 0.33 0.34]
		:f005 [0.03 0.33 0.64]
		:f006 [0.13 0.53 0.34]
		:f007 [0.20 0.43 0.37]
		:f008 [0.33 0.33 0.34]
		:f009 [0.33 0.33 0.34]
		:f010 [0.33 0.33 0.34]
	})

(def pilha
    {		:p001 [0.33 0.33 0.34]
		:p002 [0.33 0.33 0.34]
		:p003 [0.33 0.33 0.34]
		:p004 [0.33 0.33 0.34]
		:p005 [0.03 0.33 0.64]
		:p006 [0.13 0.53 0.34]
		:p007 [0.20 0.43 0.37]
		:p008 [0.33 0.33 0.34]
		:p009 [0.33 0.33 0.34]
		:p010 [0.33 0.33 0.34]
	})


(def metOrd
    {		:mo001 [0.33 0.33 0.34]
		:mo002 [0.33 0.33 0.34]
		:mo003 [0.33 0.33 0.34]
		:mo004 [0.33 0.33 0.34]
		:mo005 [0.03 0.33 0.64]
		:mo006 [0.13 0.53 0.34]
		:mo007 [0.20 0.43 0.37]
		:mo008 [0.33 0.33 0.34]
		:mo009 [0.33 0.33 0.34]
		:mo010 [0.33 0.33 0.34]
	})

(def metPesq
    {		:mp001 [0.33 0.33 0.34]
		:mp002 [0.33 0.33 0.34]
		:mp003 [0.33 0.33 0.34]
		:mp004 [0.33 0.33 0.34]
		:mp005 [0.03 0.33 0.64]
		:mp006 [0.13 0.53 0.34]
		:mp007 [0.20 0.43 0.37]
		:mp008 [0.33 0.33 0.34]
		:mp009 [0.33 0.33 0.34]
		:mp010 [0.33 0.33 0.34]
	})



(defn cria-tabela-aluno
"Cria a tabela usada para armazenar os resultados inferidos pela rede bayesiana." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :ALUNOS
           [:alunoKey "varchar(30) NOT NULL"]
           [:nome "varchar(50) NOT NULL"]
           [:sobrenome "varchar(50) NOT NULL"]
	   [:curso "varchar(50) NOT NULL"]
	   [:email "varchar(50)"]
	   [:usuario "varchar(50) NOT NULL"]
           [:senha "varchar(50) NOT NULL"]          
           ["CONSTRAINT PK_ALUNO PRIMARY KEY(alunoKey)"]
)))


(defn insere-tabela-aluno [alunoKey nome sobrenome curso email usuario senha]
(sql/with-connection ILS-DB
    (sql/insert-records :ALUNOS
      {:alunoKey alunoKey :NOME nome :SOBRENOME sobrenome :CURSO curso
       :EMAIL email :USUARIO usuario :SENHA senha})))


(defn mostra-alunos []
(sql/with-connection ILS-DB
 (sql/with-query-results res ["SELECT * FROM ALUNOS"]
  (doall res))))

(defn mostra-alunos-nomes []
(sql/with-connection ILS-DB
 (sql/with-query-results res ["SELECT NOME FROM ALUNOS"]
  (doall res))))

(defn mostra-alunos-alunoKey []
(sql/with-connection ILS-DB
 (sql/with-query-results res ["SELECT alunoKey FROM ALUNOS"]
  (doall res))))

(defn mostra-alunos-sobrenome []
(sql/with-connection ILS-DB
 (sql/with-query-results res ["SELECT SOBRENOME FROM ALUNOS"]
  (doall res))))

(defn mostra-alunos-curso []
(sql/with-connection ILS-DB
 (sql/with-query-results res ["SELECT CURSO FROM ALUNOS"]
  (doall res))))

(defn mostra-alunos-email []
(sql/with-connection ILS-DB
 (sql/with-query-results res ["SELECT EMAIL FROM ALUNOS"]
  (doall res))))

(defn mostra-alunos-usuario []
(sql/with-connection ILS-DB
 (sql/with-query-results res ["SELECT USUARIO FROM ALUNOS"]
  (doall res))))

(defn mostra-alunos-senha []
(sql/with-connection ILS-DB
 (sql/with-query-results res ["SELECT SENHA FROM ALUNOS"]
  (doall res))))


(def list-aux (mostra-alunos))



(defn imprime []
           [:tr
           [:td [:h6 (get (nth list-aux 0) :nome)]]
           [:td [:h6 (get (nth list-aux 0) :alunokey)]]
           [:td [:h6 (get (nth list-aux 0) :sobrenome)]]
           [:td [:h6 (get (nth list-aux 0) :curso)]]
           [:td [:h6 (get (nth list-aux 0) :email)]]
           [:td [:h6 (get (nth list-aux 0) :usuario)]]
           [:td [:h6 (get (nth list-aux 0) :senha)]]])





(defn imprime-dados-alunos [aux]
  (cond (>= aux (count (mostra-alunos))) (do 0))
       (cond (not(>= aux (count (mostra-alunos))))
        (do
           [:tr [:td [:h6 (get (nth (mostra-alunos) aux) :nome)]]
           [:td [:h6 (get (nth (mostra-alunos) aux) :alunokey)]]
           [:td [:h6 (get (nth (mostra-alunos) aux) :sobrenome)]]
           [:td [:h6 (get (nth (mostra-alunos) aux) :curso)]]
           [:td [:h6 (get (nth (mostra-alunos) aux) :email)]]
           [:td [:h6 (get (nth (mostra-alunos) aux) :usuario)]]
           [:td [:h6 (get (nth (mostra-alunos) aux) :senha)]]]))) 



(defn retorna-usuario [aux]
  (cond (>= aux (count (mostra-alunos))) (do 0))
       (cond (not(>= aux (count (mostra-alunos))))
        (do
           (get (nth (mostra-alunos) aux) :usuario)))) 

(defn retorna-senha [aux]
  (cond (>= aux (count (mostra-alunos))) (do 0))
       (cond (not(>= aux (count (mostra-alunos))))
        (do
           (get (nth (mostra-alunos) aux) :senha)))) 




(defn tet []
(for [i (range 0 (count (mostra-alunos)))
       :when (inc i)]
     (imprime-dados-alunos i)))


;(def var-aux (count(mostra-alunos)))


(defn testes [st]
   (str st))
           
(defn id-aluno-senha [senha]
 (sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT ALUNOS.alunokey FROM ALUNOS WHERE ALUNOS.senha = '" senha"'")]
    (doall res))))
   
(defn id-aluno-usuario-senha [usu senha]
 (sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT ALUNOS.alunokey FROM ALUNOS WHERE ALUNOS.usuario ='" usu "' AND ALUNOS.senha = '" senha"'")]
    (doall res))))

(defn id-aluno-usario [usuario]
 (sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT ALUNOS.alunokey FROM ALUNOS WHERE ALUNOS.usuario = '" usuario"'")]
    (doall res))))


(defn chave-usuario-cadastro [chave]
 (sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT ALUNOS.nome FROM ALUNOS WHERE ALUNOS.alunoKey = '" chave"'")]
    (doall res))))



(defn compara-usuario [usuario senha]
(cond (= nil (id-aluno-usuario-senha usuario senha)) 0
  :else 1))


(defn comparar-id-aluno [chave]
 (cond (= nil (chave-usuario-cadastro chave)) 1
  :else 0))


(defn recupera-id [senha]
  (get (nth (id-aluno-senha senha) 0) :alunokey))


(defn retorna-exercicio-certos [alunokey conteudo]
  (sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT EXERCICIO.exercicio FROM EXERCICIO WHERE EXERCICIO.alunoKey = '" alunokey "' AND EXERCICIO.bom = 1.0 " " AND EXERCICIO.conteudo ='" conteudo "'")]
    (doall res))))
  
(defn retorna-exercicio-certos-dominio [alunokey conteudo]
  (sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT DOMINIO.bom FROM DOMINIO WHERE DOMINIO.alunoKey = '" alunokey "' AND DOMINIO.conteudo = '" conteudo"'")]
    (doall res))))




(defn teste [aux]
    (cond (>= aux (count list-aux)) (do 0))
       (cond (not(>= aux (count list-aux))) 
         (do
           (println (get (nth list-aux aux) :nome));
           (println (get (nth list-aux aux) :alunokey))
           (println (get (nth list-aux aux) :sobrenome))
           (println (get (nth list-aux aux) :curso))
           (println (get (nth list-aux aux) :email))
           (println (get (nth list-aux aux) :usuario))
           (println (get (nth list-aux aux) :senha))
           (teste (+ aux 1))))) 




(defn cria-tabela-dominio
"Cria a tabela usada para armazenar os resultados inferidos pela rede bayesiana." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :dominio
           [:alunoKey "varchar(30) NOT NULL"]
           [:conteudo "varchar(20) NOT NULL"]
           [:bom "float NOT NULL"]
	   [:medio "float NOT NULL"]
	   [:ruim "float NOT NULL"]
           ["CONSTRAINT PK_DOMINIO PRIMARY KEY(alunoKey, conteudo)"]
           ["CONSTRAINT FK_DOMINIO 
  	    FOREIGN KEY (alunoKey) REFERENCES ALUNOS (alunoKey) ON UPDATE NO ACTION ON DELETE NO ACTION"]
)))

(defn cria-tabela-exercicio
"Cria a tabela usada para armazenar os resultados inferidos pela rede bayesiana." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :exercicio
           [:alunoKey "varchar(30) NOT NULL"]
           [:exercicio "varchar(20) NOT NULL"]
           [:conteudo "varchar(20) NOT NULL"]
           [:bom "float NOT NULL"]
	   [:medio "float NOT NULL"]
	   [:ruim "float NOT NULL"]
           ["CONSTRAINT PK_exercicio PRIMARY KEY(alunoKey, conteudo, exercicio)"]
	   ["CONSTRAINT FK_exercicio 
  	    FOREIGN KEY (alunoKey, conteudo) REFERENCES DOMINIO (alunoKey, conteudo) ON UPDATE NO ACTION ON DELETE NO ACTION"]
))) 
 

(defn destroi-tabelas 
"Destrói a tabela usada para armazenar os resultados inferidos pela rede bayesiana."
[]
   (sql/with-connection ILS-DB
    (sql/drop-table :dominio))
   (sql/with-connection ILS-DB
    (sql/drop-table :exercicio))
   (sql/with-connection ILS-DB
    (sql/drop-table :alunos))
   )

(defn inserir-conteudo 
  "Insere um novo conteudo no banco."
   [chave nconteudo qbom qmedio qruim]
   (sql/with-connection ILS-DB
    (sql/insert-records :dominio
      {:alunoKey chave :conteudo nconteudo :bom qbom :medio qmedio :ruim qruim}
    )))	

(defn inserir-exercicio
  "Insere um novo exercicio no banco."
   [chave ex nconteudo qbom qmedio qruim]
   (sql/with-connection ILS-DB
    (sql/insert-records :exercicio
      {:alunoKey chave :exercicio ex :conteudo nconteudo :bom qbom :medio qmedio :ruim qruim}
    )))


(defn povoar-tabelas 
"Povoa a tabela de acordo com a chave do aluno."
  [chave]
   (sql/with-connection ILS-DB
    (sql/insert-records :dominio
	{:alunoKey chave :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.34}
      	{:alunoKey chave :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.34}
    ))	
   (sql/with-connection ILS-DB
    (sql/insert-records :exercicio
      	{:alunoKey chave :exercicio "ed001" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ed002" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ed003" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ed004" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ed005" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ed006" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ed007" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ed008" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ed009" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ed010" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ad001" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ad002" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ad003" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ad004" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ad005" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ad006" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ad007" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ad008" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ad009" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ad010" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "v001" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "v002" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "v003" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "v004" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "v005" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "v006" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "v007" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "v008" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "v009" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "v010" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "r001" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "r002" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "r003" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "r004" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "r005" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "r006" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "r007" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "r008" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "r009" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "r010" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "l001" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "l002" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "l003" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "l004" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "l005" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "l006" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "l007" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "l008" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "l009" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "l010" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "a001" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "a002" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "a003" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "a004" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "a005" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "a006" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "a007" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "a008" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "a009" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "a010" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "f001" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "f002" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "f003" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "f004" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "f005" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "f006" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "f007" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "f008" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "f009" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "f010" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "p001" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "p002" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "p003" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "p004" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "p005" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "p006" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "p007" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "p008" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "p009" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "p010" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "mo001" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "mo002" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "mo003" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "mo004" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "mo005" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "mo006" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "mo007" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "mo008" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "mo009" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "mo010" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "mp001" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "mp002" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "mp003" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "mp004" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "mp005" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "mp006" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "mp007" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "mp008" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "mp009" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "mp010" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}

    )))      		

(defn mostrar-dominio 
"Mostra o dominio referente a um aluno."
[chave]
(sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT DOMINIO.conteudo, DOMINIO.bom, DOMINIO.MEDIO, DOMINIO.ruim FROM DOMINIO WHERE DOMINIO.alunoKey = '" chave "'")]
    (doall res))))

(defn mostrar-exercicios 
"Mostra o dominio referente a um aluno."
[chave conteudo]
(sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT EXERCICIO.exercicio, EXERCICIO.bom, EXERCICIO.medio, EXERCICIO.ruim FROM EXERCICIO WHERE EXERCICIO.alunoKey = '" chave"' AND EXERCICIO.conteudo = '" conteudo "'")]
    (doall res))))




(defn atualizar-probs-conteudo 
"Dada a chave de um aluno e o conteudo, atualiza as probabilidades deste conteudo."
[chave nconteudo qbom qmedio qruim]
    (sql/with-connection ILS-DB
      (sql/update-values :dominio
       [(str "DOMINIO.alunoKey ='" chave "' AND DOMINIO.conteudo = '" nconteudo "'")]
       {:alunoKey chave :conteudo nconteudo :bom qbom :medio qmedio :ruim qruim})))

(defn atualizar-probs-exercicio 
"Dada a chave de um aluno, o conteudo e o exercício, atualiza as probabilidades deste exercicio."
[chave nconteudo ex qbom qmedio qruim]
    (sql/with-connection ILS-DB
      (sql/update-values :exercicio
       [(str "EXERCICIO.alunoKey ='" chave "' AND EXERCICIO.conteudo = '" nconteudo "' AND EXERCICIO.exercicio = '" ex"'")]
       {:alunoKey chave :conteudo nconteudo :exercicio ex :bom qbom :medio qmedio :ruim qruim})))


(defn atualiza-todo-dominio [alunokey conteudo]
    (cond (> ( / (count(retorna-exercicio-certos alunokey conteudo)) 10) 1/2) (atualizar-probs-conteudo alunokey conteudo 1.0 0.0 0.0)
     :else (atualizar-probs-conteudo alunokey conteudo 0.0 0.0 1.0))) 



;BANCO DE DADOS -*- BANCO DE DADOS -*- BANCO DE DADOS -*- BANCO DE DADOS -*- BANCO DE DADOS -*- BANCO DE DADOS -*- BANCO DE DADOS

(defn map-function-on-map-vals 
	"Uma funcao map modificada para maps"
    [m f]
  (reduce (fn [altered-map [k v]] (assoc altered-map k (f v))) {} m))

(defn second-map 
	"Pega o segundo item de uma sequencia." 
    [ m ]
   (nth m 1))

(defn calc-prob-conteudo [alunoChave nome conteudo]
  "Dados a chave do aluno, o nome do conteudo, e dados os exercicios, calcula as probabilidades bom, médio e ruim para cada conteúdo e altera no banco."
  (atualizar-probs-conteudo 
    alunoChave nome 
      (/ (reduce + (vals (map-function-on-map-vals conteudo  first))) 10) ;a media de bom para todos os exercicios do conteudo
 (/ (reduce + (vals (map-function-on-map-vals conteudo  second-map))) 10) ;a media de médio para todos os exercicios do conteudo
      (/ (reduce + (vals (map-function-on-map-vals conteudo  last))) 10) ;a media de ruim para todos os exercicios do conteudo
))


;Nas próximas 600 linhas, a nova funcao de progagação! :D
(defn propagar-persistente
"Uma funcao capaz de propagar e salvar no banco de dados do aluno. Esta funcao utiliza marginalização de uma arvore de juncao,
 que é usada como uma 'máscara' de progragação."
 ([chave]
       	(def tanara 
                   (assoc tanara :alocDin [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))5))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))9))0)
						(nth (vec (nth (vals (run-propagation dominio))12))0)
                                                                                         )3)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))5))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))9))1)
						(nth (vec (nth (vals (run-propagation dominio))12))1)
                                                                                         )3)
 					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))5))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))9))2)
						(nth (vec (nth (vals (run-propagation dominio))12))2)
                                                                                         )3)]
		      :vetor [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))2))0)
						(nth (vec (nth (vals (run-propagation dominio))7))0)
						(nth (vec (nth (vals (run-propagation dominio))8))0)
						(nth (vec (nth (vals (run-propagation dominio))9))0)
						(nth (vec (nth (vals (run-propagation dominio))12))0)
						(nth (vec (nth (vals (run-propagation dominio))16))0)
                                                                                         )7)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))2))1)
						(nth (vec (nth (vals (run-propagation dominio))7))1)
						(nth (vec (nth (vals (run-propagation dominio))8))1)
						(nth (vec (nth (vals (run-propagation dominio))9))1)
						(nth (vec (nth (vals (run-propagation dominio))12))1)
						(nth (vec (nth (vals (run-propagation dominio))16))1)
                                                                                         )7)
 					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))2))2)
						(nth (vec (nth (vals (run-propagation dominio))7))2)
						(nth (vec (nth (vals (run-propagation dominio))8))2)
						(nth (vec (nth (vals (run-propagation dominio))9))2)
						(nth (vec (nth (vals (run-propagation dominio))12))2)
						(nth (vec (nth (vals (run-propagation dominio))16))2)
                                                                                         )7)]

			:recursiv [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))7))0)
						(nth (vec (nth (vals (run-propagation dominio))18))0)
                                                                                         )3)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))7))1)
						(nth (vec (nth (vals (run-propagation dominio))18))1)
                                                                                         )3)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))7))2)
						(nth (vec (nth (vals (run-propagation dominio))18))2)
                                                                                         )3)]

			:arvore [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))3))0)
						(nth (vec (nth (vals (run-propagation dominio))5))0)
						(nth (vec (nth (vals (run-propagation dominio))8))0)
						(nth (vec (nth (vals (run-propagation dominio))10))0)
						(nth (vec (nth (vals (run-propagation dominio))11))0)
						(nth (vec (nth (vals (run-propagation dominio))12))0)
						(nth (vec (nth (vals (run-propagation dominio))14))0)
						(nth (vec (nth (vals (run-propagation dominio))16))0)
						(nth (vec (nth (vals (run-propagation dominio))18))0)
						(nth (vec (nth (vals (run-propagation dominio))19))0)
						(nth (vec (nth (vals (run-propagation dominio))20))0)
                                                                                         )12)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))3))1)
						(nth (vec (nth (vals (run-propagation dominio))5))1)
						(nth (vec (nth (vals (run-propagation dominio))8))1)
						(nth (vec (nth (vals (run-propagation dominio))10))1)
						(nth (vec (nth (vals (run-propagation dominio))11))1)
						(nth (vec (nth (vals (run-propagation dominio))12))1)
						(nth (vec (nth (vals (run-propagation dominio))14))1)
						(nth (vec (nth (vals (run-propagation dominio))16))1)
						(nth (vec (nth (vals (run-propagation dominio))18))1)
						(nth (vec (nth (vals (run-propagation dominio))19))1)
						(nth (vec (nth (vals (run-propagation dominio))20))1)
                                                                                         )12)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))3))2)
						(nth (vec (nth (vals (run-propagation dominio))5))2)
						(nth (vec (nth (vals (run-propagation dominio))8))2)
						(nth (vec (nth (vals (run-propagation dominio))10))2)
						(nth (vec (nth (vals (run-propagation dominio))11))2)
						(nth (vec (nth (vals (run-propagation dominio))12))2)
						(nth (vec (nth (vals (run-propagation dominio))14))2)
						(nth (vec (nth (vals (run-propagation dominio))16))2)
						(nth (vec (nth (vals (run-propagation dominio))18))2)
						(nth (vec (nth (vals (run-propagation dominio))19))2)
						(nth (vec (nth (vals (run-propagation dominio))20))2)
                                                                                         )12)]

			:lista [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))0)
						(nth (vec (nth (vals (run-propagation dominio))5))0)
						(nth (vec (nth (vals (run-propagation dominio))9))0)
						(nth (vec (nth (vals (run-propagation dominio))10))0)
						(nth (vec (nth (vals (run-propagation dominio))11))0)
						(nth (vec (nth (vals (run-propagation dominio))15))0)
						(nth (vec (nth (vals (run-propagation dominio))16))0)
                                                                                         )8)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))1)
						(nth (vec (nth (vals (run-propagation dominio))5))1)
						(nth (vec (nth (vals (run-propagation dominio))9))1)
						(nth (vec (nth (vals (run-propagation dominio))10))1)
						(nth (vec (nth (vals (run-propagation dominio))11))1)
						(nth (vec (nth (vals (run-propagation dominio))15))1)
						(nth (vec (nth (vals (run-propagation dominio))16))1)
                                                                                         )8)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))2)
						(nth (vec (nth (vals (run-propagation dominio))5))2)
						(nth (vec (nth (vals (run-propagation dominio))9))2)
						(nth (vec (nth (vals (run-propagation dominio))10))2)
						(nth (vec (nth (vals (run-propagation dominio))11))2)
						(nth (vec (nth (vals (run-propagation dominio))15))2)
						(nth (vec (nth (vals (run-propagation dominio))16))2)
                                                                                         )8)]

			:metOrd [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))2))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))7))0)
						(nth (vec (nth (vals (run-propagation dominio))8))0)
						(nth (vec (nth (vals (run-propagation dominio))17))0)
						(nth (vec (nth (vals (run-propagation dominio))18))0)
						(nth (vec (nth (vals (run-propagation dominio))19))0)
                                                                                         )6)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))2))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))7))1)
						(nth (vec (nth (vals (run-propagation dominio))8))1)
						(nth (vec (nth (vals (run-propagation dominio))17))1)
						(nth (vec (nth (vals (run-propagation dominio))18))1)
						(nth (vec (nth (vals (run-propagation dominio))19))1)
                                                                                         )6)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))2))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))7))2)
						(nth (vec (nth (vals (run-propagation dominio))8))2)
						(nth (vec (nth (vals (run-propagation dominio))17))2)
						(nth (vec (nth (vals (run-propagation dominio))18))2)
						(nth (vec (nth (vals (run-propagation dominio))19))2)
                                                                                         )6)]

			:fila [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))0)
						(nth (vec (nth (vals (run-propagation dominio))6))0)
                                                                                         )3)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))1)
						(nth (vec (nth (vals (run-propagation dominio))6))1)
                                                                                         )3)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))2)
						(nth (vec (nth (vals (run-propagation dominio))6))2)
                                                                                         )3)]

			:metPesq [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))2))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))11))0)
						(nth (vec (nth (vals (run-propagation dominio))13))0)
						(nth (vec (nth (vals (run-propagation dominio))14))0)
						(nth (vec (nth (vals (run-propagation dominio))15))0)
						(nth (vec (nth (vals (run-propagation dominio))17))0)
						(nth (vec (nth (vals (run-propagation dominio))19))0)
						(nth (vec (nth (vals (run-propagation dominio))20))0)
                                                                                         )8)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))2))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))11))1)
						(nth (vec (nth (vals (run-propagation dominio))13))1)
						(nth (vec (nth (vals (run-propagation dominio))14))1)
						(nth (vec (nth (vals (run-propagation dominio))15))1)
						(nth (vec (nth (vals (run-propagation dominio))17))1)
						(nth (vec (nth (vals (run-propagation dominio))19))1)
						(nth (vec (nth (vals (run-propagation dominio))20))1)
                                                                                         )8)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))2))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))11))2)
						(nth (vec (nth (vals (run-propagation dominio))13))2)
						(nth (vec (nth (vals (run-propagation dominio))14))2)
						(nth (vec (nth (vals (run-propagation dominio))15))2)
						(nth (vec (nth (vals (run-propagation dominio))17))2)
						(nth (vec (nth (vals (run-propagation dominio))19))2)
						(nth (vec (nth (vals (run-propagation dominio))20))2)
                                                                                         )8)]

			:pilha [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))3))0)
						(nth (vec (nth (vals (run-propagation dominio))6))0)
						(nth (vec (nth (vals (run-propagation dominio))10))0)
						(nth (vec (nth (vals (run-propagation dominio))13))0)
						(nth (vec (nth (vals (run-propagation dominio))15))0)
						(nth (vec (nth (vals (run-propagation dominio))20))0)
                                                                                         )7)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))3))1)
						(nth (vec (nth (vals (run-propagation dominio))6))1)
						(nth (vec (nth (vals (run-propagation dominio))10))1)
						(nth (vec (nth (vals (run-propagation dominio))13))1)
						(nth (vec (nth (vals (run-propagation dominio))15))1)
						(nth (vec (nth (vals (run-propagation dominio))20))1)
                                                                                         )7)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))3))2)
						(nth (vec (nth (vals (run-propagation dominio))6))2)
						(nth (vec (nth (vals (run-propagation dominio))10))2)
						(nth (vec (nth (vals (run-propagation dominio))13))2)
						(nth (vec (nth (vals (run-propagation dominio))15))2)
						(nth (vec (nth (vals (run-propagation dominio))20))2)
                                                                                         )7)]

			
			:estrutura-dados [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))3))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))0)
						(nth (vec (nth (vals (run-propagation dominio))6))0)
						(nth (vec (nth (vals (run-propagation dominio))13))0)
						(nth (vec (nth (vals (run-propagation dominio))14))0)
						(nth (vec (nth (vals (run-propagation dominio))17))0)
                                                                                         )6)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))3))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))1)
						(nth (vec (nth (vals (run-propagation dominio))6))1)
						(nth (vec (nth (vals (run-propagation dominio))13))1)
						(nth (vec (nth (vals (run-propagation dominio))14))1)
						(nth (vec (nth (vals (run-propagation dominio))17))1)
                                                                                         )6)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))3))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))2)
						(nth (vec (nth (vals (run-propagation dominio))6))2)
						(nth (vec (nth (vals (run-propagation dominio))13))2)
						(nth (vec (nth (vals (run-propagation dominio))14))2)
						(nth (vec (nth (vals (run-propagation dominio))17))2)
                                                                                         )6)]
	))      
     (atualizar-probs-conteudo chave "estrutura-dados" 	(nth (vec (nth (vals tanara)0))0)  
							(nth (vec (nth (vals tanara)0))1)
							(nth (vec (nth (vals tanara)0))2))
     (atualizar-probs-conteudo chave "arvore" 		(nth (vec (nth (vals tanara)1))0)  
							(nth (vec (nth (vals tanara)1))1)
							(nth (vec (nth (vals tanara)1))2))
     (atualizar-probs-conteudo chave "recursiv" 	(nth (vec (nth (vals tanara)2))0)  
							(nth (vec (nth (vals tanara)2))1)
							(nth (vec (nth (vals tanara)2))2))
     (atualizar-probs-conteudo chave "fila" 		(nth (vec (nth (vals tanara)3))0)  
							(nth (vec (nth (vals tanara)3))1)
							(nth (vec (nth (vals tanara)3))2))
     (atualizar-probs-conteudo chave "metPesq" 		(nth (vec (nth (vals tanara)4))0)  
							(nth (vec (nth (vals tanara)4))1)
							(nth (vec (nth (vals tanara)4))2))
     (atualizar-probs-conteudo chave "metOrd" 		(nth (vec (nth (vals tanara)5))0)  
							(nth (vec (nth (vals tanara)5))1)
							(nth (vec (nth (vals tanara)5))2))
     (atualizar-probs-conteudo chave "lista" 		(nth (vec (nth (vals tanara)6))0)  
							(nth (vec (nth (vals tanara)6))1)
							(nth (vec (nth (vals tanara)6))2))
     (atualizar-probs-conteudo chave "pilha" 		(nth (vec (nth (vals tanara)7))0)  
							(nth (vec (nth (vals tanara)7))1)
							(nth (vec (nth (vals tanara)7))2))
     (atualizar-probs-conteudo chave "alocDin" 		(nth (vec (nth (vals tanara)8))0)  
							(nth (vec (nth (vals tanara)8))1)
							(nth (vec (nth (vals tanara)8))2))
     (atualizar-probs-conteudo chave "vetor" 		(nth (vec (nth (vals tanara)9))0)  
							(nth (vec (nth (vals tanara)9))1)
							(nth (vec (nth (vals tanara)9))2))
	
  )
  ([chave evidencias]
          (def tanara          
		   (assoc tanara :alocDin [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))5))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))9))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))0)
                                                                                         )3)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))5))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))9))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))1)
                                                                                         )3)
 					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))5))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))9))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))2)
                                                                                         )3)]
		      :vetor [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))7))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))9))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))0)
                                                                                         )7)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))7))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))9))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))1)
                                                                                         )7)
 					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))7))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))9))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))2)
                                                                                         )7)]

			:recursiv [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))7))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))0)
                                                                                         )3)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))7))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))1)
                                                                                         )3)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))7))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))2)
                                                                                         )3)]

			:arvore [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))5))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))11))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))0)
                                                                                         )12)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))5))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))11))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))1)
                                                                                         )12)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))5))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))11))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))2)
                                                                                         )12)]

			:lista [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))5))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))9))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))11))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))0)
                                                                                         )8)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))5))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))9))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))11))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))1)
                                                                                         )8)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))5))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))9))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))11))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))2)
                                                                                         )8)]

			:metOrd [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))7))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))0)
                                                                                         )6)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))7))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))1)
                                                                                         )6)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))7))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))2)
                                                                                         )6)]

			:fila [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))0)
                                                                                         )3)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))1)
                                                                                         )3)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))2)
                                                                                         )3)]

			:metPesq [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))11))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))0)
                                                                                         )8)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))11))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))1)
                                                                                         )8)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))11))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))2)
                                                                                         )8)]

			:pilha [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))0)
                                                                                         )7)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))1)
                                                                                         )7)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))2)
                                                                                         )7)]

			
			:estrutura-dados [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))0)
                                                                                         )6)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))1)
                                                                                         )6)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))2)
                                                                                         )6)]
	))
     (atualizar-probs-conteudo chave "estrutura-dados" 	(nth (vec (nth (vals tanara)0))0)  
							(nth (vec (nth (vals tanara)0))1)
							(nth (vec (nth (vals tanara)0))2))
     (atualizar-probs-conteudo chave "arvore" 		(nth (vec (nth (vals tanara)1))0)  
							(nth (vec (nth (vals tanara)1))1)
							(nth (vec (nth (vals tanara)1))2))
     (atualizar-probs-conteudo chave "recursiv" 	(nth (vec (nth (vals tanara)2))0)  
							(nth (vec (nth (vals tanara)2))1)
							(nth (vec (nth (vals tanara)2))2))
     (atualizar-probs-conteudo chave "fila" 		(nth (vec (nth (vals tanara)3))0)  
							(nth (vec (nth (vals tanara)3))1)
							(nth (vec (nth (vals tanara)3))2))
     (atualizar-probs-conteudo chave "metPesq" 		(nth (vec (nth (vals tanara)4))0)  
							(nth (vec (nth (vals tanara)4))1)
							(nth (vec (nth (vals tanara)4))2))
     (atualizar-probs-conteudo chave "metOrd" 		(nth (vec (nth (vals tanara)5))0)  
							(nth (vec (nth (vals tanara)5))1)
							(nth (vec (nth (vals tanara)5))2))
     (atualizar-probs-conteudo chave "lista" 		(nth (vec (nth (vals tanara)6))0)  
							(nth (vec (nth (vals tanara)6))1)
							(nth (vec (nth (vals tanara)6))2))
     (atualizar-probs-conteudo chave "pilha" 		(nth (vec (nth (vals tanara)7))0)  
							(nth (vec (nth (vals tanara)7))1)
							(nth (vec (nth (vals tanara)7))2))
     (atualizar-probs-conteudo chave "alocDin" 		(nth (vec (nth (vals tanara)8))0)  
							(nth (vec (nth (vals tanara)8))1)
							(nth (vec (nth (vals tanara)8))2))
     (atualizar-probs-conteudo chave "vetor" 		(nth (vec (nth (vals tanara)9))0)  
							(nth (vec (nth (vals tanara)9))1)
							(nth (vec (nth (vals tanara)9))2))
  )
)

;ATENCAO! esta funcao nao atualiza no banco. Use as duas quando mudar de exercicio! (esta é util para mudar os valores da estrutura,
;utilizada para calcular o conhecimento geral do estudante. Para alterar no banco, use: atualizar-probs-exercicio  (linha 502)
(defn atualizar-exercicio 
"Atualiza as probabilidades de um exercicio de algum conteudo (nao use aspas!). Ex: (atualizar-exercicio estrutura-dados :v001 1.0 0.0 0.0)"
[conteudo exercicio bom medio ruim]
        (cond 	   
	   (= conteudo estrutura-dados) (def estrutura-dados
                               (assoc conteudo exercicio [bom medio ruim]))
	   (= conteudo alocDin) (def alocDin
                               (assoc conteudo exercicio [bom medio ruim]))
	   (= conteudo vetor) (def vetor
                               (assoc conteudo exercicio [bom medio ruim]))
           (= conteudo recursiv) (def recursiv
                               (assoc conteudo exercicio [bom medio ruim]))
           (= conteudo lista) (def lista
                               (assoc conteudo exercicio [bom medio ruim]))
           (= conteudo arvore) (def arvore
                               (assoc conteudo exercicio [bom medio ruim]))
           (= conteudo fila) (def fila
                               (assoc conteudo exercicio [bom medio ruim]))
           (= conteudo pilha) (def pilha
                               (assoc conteudo exercicio [bom medio ruim]))
           (= conteudo metOrd) (def metOrd
                               (assoc conteudo exercicio [bom medio ruim]))
	   (= conteudo metPesq) (def metPesq
                               (assoc conteudo exercicio [bom medio ruim]))
         :else "Este conteudo nao eh valido!")
)

(defn carregar-exercicios 
"Carrega os exercicios de um conteudo de um aluno do banco na estrutura."
	[chave conteudo]
   (cond 	   
	   (= conteudo "estrutura-dados") (def estrutura-dados
                                        (assoc estrutura-dados :ed001 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 0))3)]
                                                :ed002 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 2))3)]
						:ed003 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 3))3)]
						:ed004 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 4))3)]
						:ed005 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 5))3)]
						:ed006 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 6))3)]
						:ed007 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 7))3)]
						:ed008 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 8))3)]
						:ed009 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 9))3)]
						:ed010 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 1))3)] ))
	   (= conteudo "alocDin") (def alocDin
                                (assoc alocDin :ad001 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 0))3)]
                                                :ad002 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 2))3)]
						:ad003 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 3))3)]
						:ad004 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 4))3)]
						:ad005 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 5))3)]
						:ad006 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 6))3)]
						:ad007 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 7))3)]
						:ad008 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 8))3)]
						:ad009 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 9))3)]
						:ad010 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 1))3)] ))
	   (= conteudo "vetor") (def vetor
                               (assoc vetor :v001 [(nth (vals (nth (mostrar-exercicios chave "vetor") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 0))3)]
                                                :v002 [(nth (vals (nth (mostrar-exercicios chave "vetor") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 2))3)]
						:v003 [(nth (vals (nth (mostrar-exercicios chave "vetor") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 3))3)]
						:v004 [(nth (vals (nth (mostrar-exercicios chave "vetor") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 4))3)]
						:v005 [(nth (vals (nth (mostrar-exercicios chave "vetor") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 5))3)]
						:v006 [(nth (vals (nth (mostrar-exercicios chave "vetor") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 6))3)]
						:v007 [(nth (vals (nth (mostrar-exercicios chave "vetor") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 7))3)]
						:v008 [(nth (vals (nth (mostrar-exercicios chave "vetor") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 8))3)]
						:v009 [(nth (vals (nth (mostrar-exercicios chave "vetor") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 9))3)]
						:v010 [(nth (vals (nth (mostrar-exercicios chave "vetor") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 1))3)] ))
           (= conteudo "recursiv") (def recursiv
                                 (assoc recursiv :r001 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 0))3)]
                                                :r002 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 2))3)]
						:r003 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 3))3)]
						:r004 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 4))3)]
						:r005 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 5))3)]
						:r006 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 6))3)]
						:r007 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 7))3)]
						:r008 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 8))3)]
						:r009 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 9))3)]
						:r010 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 1))3)] ))
           (= conteudo "lista") (def lista
                               (assoc lista :l001 [(nth (vals (nth (mostrar-exercicios chave "lista") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 0))3)]
                                                :l002 [(nth (vals (nth (mostrar-exercicios chave "lista") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 2))3)]
						:l003 [(nth (vals (nth (mostrar-exercicios chave "lista") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 3))3)]
						:l004 [(nth (vals (nth (mostrar-exercicios chave "lista") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 4))3)]
						:l005 [(nth (vals (nth (mostrar-exercicios chave "lista") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 5))3)]
						:l006 [(nth (vals (nth (mostrar-exercicios chave "lista") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 6))3)]
						:l007 [(nth (vals (nth (mostrar-exercicios chave "lista") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 7))3)]
						:l008 [(nth (vals (nth (mostrar-exercicios chave "lista") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 8))3)]
						:l009 [(nth (vals (nth (mostrar-exercicios chave "lista") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 9))3)]
						:l010 [(nth (vals (nth (mostrar-exercicios chave "lista") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 1))3)] ))
           (= conteudo "arvore") (def arvore
                               (assoc arvore :a001 [(nth (vals (nth (mostrar-exercicios chave "arvore") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 0))3)]
                                                :a002 [(nth (vals (nth (mostrar-exercicios chave "arvore") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 2))3)]
						:a003 [(nth (vals (nth (mostrar-exercicios chave "arvore") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 3))3)]
						:a004 [(nth (vals (nth (mostrar-exercicios chave "arvore") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 4))3)]
						:a005 [(nth (vals (nth (mostrar-exercicios chave "arvore") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 5))3)]
						:a006 [(nth (vals (nth (mostrar-exercicios chave "arvore") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 6))3)]
						:a007 [(nth (vals (nth (mostrar-exercicios chave "arvore") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 7))3)]
						:a008 [(nth (vals (nth (mostrar-exercicios chave "arvore") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 8))3)]
						:a009 [(nth (vals (nth (mostrar-exercicios chave "arvore") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 9))3)]
						:a010 [(nth (vals (nth (mostrar-exercicios chave "arvore") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 1))3)] ))
           (= conteudo "fila") (def fila
                             (assoc fila :f001 [(nth (vals (nth (mostrar-exercicios chave "fila") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 0))3)]
                                                :f002 [(nth (vals (nth (mostrar-exercicios chave "fila") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 2))3)]
						:f003 [(nth (vals (nth (mostrar-exercicios chave "fila") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 3))3)]
						:f004 [(nth (vals (nth (mostrar-exercicios chave "fila") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 4))3)]
						:f005 [(nth (vals (nth (mostrar-exercicios chave "fila") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 5))3)]
						:f006 [(nth (vals (nth (mostrar-exercicios chave "fila") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 6))3)]
						:f007 [(nth (vals (nth (mostrar-exercicios chave "fila") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 7))3)]
						:f008 [(nth (vals (nth (mostrar-exercicios chave "fila") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 8))3)]
						:f009 [(nth (vals (nth (mostrar-exercicios chave "fila") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 9))3)]
						:f010 [(nth (vals (nth (mostrar-exercicios chave "fila") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 1))3)] ))
           (= conteudo "pilha") (def pilha
                               (assoc pilha :p001 [(nth (vals (nth (mostrar-exercicios chave "pilha") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 0))3)]
                                                :p002 [(nth (vals (nth (mostrar-exercicios chave "pilha") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 2))3)]
						:p003 [(nth (vals (nth (mostrar-exercicios chave "pilha") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 3))3)]
						:p004 [(nth (vals (nth (mostrar-exercicios chave "pilha") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 4))3)]
						:p005 [(nth (vals (nth (mostrar-exercicios chave "pilha") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 5))3)]
						:p006 [(nth (vals (nth (mostrar-exercicios chave "pilha") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 6))3)]
						:p007 [(nth (vals (nth (mostrar-exercicios chave "pilha") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 7))3)]
						:p008 [(nth (vals (nth (mostrar-exercicios chave "pilha") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 8))3)]
						:p009 [(nth (vals (nth (mostrar-exercicios chave "pilha") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 9))3)]
						:p010 [(nth (vals (nth (mostrar-exercicios chave "pilha") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 1))3)] ))
           (= conteudo "metOrd") (def metOrd
                               (assoc metOrd :mo001 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 0))3)]
                                                :mo002 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 2))3)]
						:mo003 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 3))3)]
						:mo004 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 4))3)]
						:mo005 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 5))3)]
						:mo006 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 6))3)]
						:mo007 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 7))3)]
						:mo008 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 8))3)]
						:mo009 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 9))3)]
						:mo010 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 1))3)] ))
	   (= conteudo "metPesq") (def metPesq
                               (assoc metPesq :mp001 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 0))3)]
                                                :mp002 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 2))3)]
						:mp003 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 3))3)]
						:mp004 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 4))3)]
						:mp005 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 5))3)]
						:mp006 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 6))3)]
						:mp007 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 7))3)]
						:mp008 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 8))3)]
						:mp009 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 9))3)]
						:mp010 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 1))3)] ))
         :else "Este conteudo nao eh valido!")

)

(defn evidencias [conteudo bom medio ruim]
"Funcao que insere de forma automatizada as evidencias da arvore de propagacao"
      (cond 	   
	   (= conteudo "estrutura-dados") {:FJH [bom medio ruim] :HJD [bom medio ruim] :HIJ [bom medio ruim] :IJD [bom medio ruim] :IJG [bom medio ruim] :GJE [bom medio ruim]} 
                                         
	   (= conteudo "alocDin") {:ABE [bom medio ruim] :BAD [bom medio ruim] :EAD [bom medio ruim] } 

	   (= conteudo "vetor") {:ABE [bom medio ruim] :DBE [bom medio ruim] :BAD[bom medio ruim] :BDC[bom medio ruim] :BDF [bom medio ruim] :BHF [bom medio ruim] :CBF [bom medio ruim] }
           
	   (= conteudo "recursiv") {:BDC [bom medio ruim] :CBF [bom medio ruim] :CDF [bom medio ruim] }
           
	   (= conteudo "lista") {:ABE [bom medio ruim] :DBE [bom medio ruim] :EAD [bom medio ruim] :GJE [bom medio ruim] :IEG [bom medio ruim] :EHI [bom medio ruim] :EDH [bom medio ruim] :EDI [bom medio ruim]}

           (= conteudo "arvore") {:DBE [bom medio ruim] :BAD [bom medio ruim] :BDC [bom medio ruim] :EAD [bom medio ruim] :BDF [bom medio ruim] :CDF [bom medio ruim] :FDH [bom medio ruim] :HJD [bom medio ruim] :HDI [bom medio ruim] :IJD [bom medio ruim] :EDH [bom medio ruim] :EDI [bom medio ruim]}

           (= conteudo "fila") {:IJG [bom medio ruim] :GJE [bom medio ruim] :IEG [bom medio ruim]}

           (= conteudo "pilha") {:HIJ [bom medio ruim] :HDI [bom medio ruim] :IJD [bom medio ruim] :IJG [bom medio ruim] :EHI [bom medio ruim] :EDI [bom medio ruim]}

           (= conteudo "metOrd") {:BDF [bom medio ruim] :BHF [bom medio ruim] :CBF [bom medio ruim] :CDF [bom medio ruim] :FDH [bom medio ruim] :FJH [bom medio ruim] }

	   (= conteudo "metPesq") {:BHF [bom medio ruim] :FDH [bom medio ruim] :FJH [bom medio ruim] :HJD [bom medio ruim] :HIJ [bom medio ruim] :HDI [bom medio ruim] :EHI [bom medio ruim] :EDH [bom medio ruim] }
         :else "Este conteudo nao eh valido!")

)


