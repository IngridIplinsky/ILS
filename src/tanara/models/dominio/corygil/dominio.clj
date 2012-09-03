(ns tanara.models.dominio.corygil.dominio
  (:use
   tanara.models.dominio.corygil.factor-graph)
  (:use
   tanara.models.dominio.corygil.factor-graph.bayes)
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
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.03 0.33 0.64]
		:ex6 [0.13 0.53 0.34]
		:ex7 [0.20 0.43 0.37]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})


(def alocDin
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.03 0.33 0.64]
		:ex6 [0.13 0.53 0.34]
		:ex7 [0.20 0.43 0.37]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})

(def vetor
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.03 0.33 0.64]
		:ex6 [0.13 0.53 0.34]
		:ex7 [0.20 0.43 0.37]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})

(def recursiv
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.03 0.33 0.64]
		:ex6 [0.13 0.53 0.34]
		:ex7 [0.20 0.43 0.37]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})

(def lista
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.03 0.33 0.64]
		:ex6 [0.13 0.53 0.34]
		:ex7 [0.20 0.43 0.37]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})

(def arvore
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.03 0.33 0.64]
		:ex6 [0.13 0.53 0.34]
		:ex7 [0.20 0.43 0.37]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})

(def fila
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.03 0.33 0.64]
		:ex6 [0.13 0.53 0.34]
		:ex7 [0.20 0.43 0.37]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})

(def pilha
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.03 0.33 0.64]
		:ex6 [0.13 0.53 0.34]
		:ex7 [0.20 0.43 0.37]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})


(def metOrd
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.03 0.33 0.64]
		:ex6 [0.13 0.53 0.34]
		:ex7 [0.20 0.43 0.37]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})

(def metPesq
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.03 0.33 0.64]
		:ex6 [0.13 0.53 0.34]
		:ex7 [0.20 0.43 0.37]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})


;BANCO DE DADOS -*- BANCO DE DADOS -*- BANCO DE DADOS -*- BANCO DE DADOS -*- BANCO DE DADOS -*- BANCO DE DADOS -*- BANCO DE DADOS
(def ILS-DB 
   {
    :classname   "org.h2.Driver"
    :subprotocol "h2:file"
    :subname     (str (System/getProperty "user.dir") "/" "demo")
    :user        "sa"
    :password    ""
   }
  )

(defn cria-tabela-aluno
"Cria a tabela usada para armazenar os resultados inferidos pela rede bayesiana." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :ALUNOS
           [:alunoKey "integer NOT NULL"]
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
  (cond (>= aux (count list-aux)) (do 0))
       (cond (not(>= aux (count list-aux)))
        (do
           [:tr [:td [:h6 (get (nth list-aux aux) :nome)]]
           [:td [:h6 (get (nth list-aux aux) :alunokey)]]
           [:td [:h6 (get (nth list-aux aux) :sobrenome)]]
           [:td [:h6 (get (nth list-aux aux) :curso)]]
           [:td [:h6 (get (nth list-aux aux) :email)]]
           [:td [:h6 (get (nth list-aux aux) :usuario)]]
           [:td [:h6 (get (nth list-aux aux) :senha)]]]))) 



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


(def var-aux (count(mostra-alunos)))


(defn testes [st]
   (str st))
           
(defn id-aluno-senha [senha]
 (sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT ALUNOS.alunokey FROM ALUNOS WHERE ALUNOS.senha = " senha)]
    (doall res))))
   
(defn id-aluno-usuario-senha [usu senha]
 (sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT ALUNOS.alunokey FROM ALUNOS WHERE ALUNOS.usuario ='" usu "' AND ALUNOS.senha = " senha)]
    (doall res))))


(defn compara-usuario [usuario senha]
(cond (= nil (id-aluno-usuario-senha usuario senha)) 0
  :else 1))


(defn recupera-id [senha]
   (get (nth (id-aluno-senha senha) 0) :alunokey))


(defn retorna-exercicio-certos [alunokey conteudo]
  (sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT EXERCICIO.exercicio FROM EXERCICIO WHERE EXERCICIO.alunoKey = " alunokey " AND EXERCICIO.bom = 1.0 " " AND EXERCICIO.conteudo ='" conteudo "'")]
    (doall res))))
  
(defn retorna-exercicio-certos-dominio [alunokey conteudo]
  (sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT DOMINIO.bom FROM DOMINIO WHERE DOMINIO.alunoKey = " alunokey " AND DOMINIO.conteudo = '" conteudo"'")]
    (doall res))))




(defn teste [aux]
    (cond (>= aux (count list-aux)) (do 0))
       (cond (not(>= aux (count list-aux))) 
         (do
           (println (get (nth list-aux aux) :nome))
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
           [:alunoKey "integer NOT NULL"]
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
           [:alunoKey "integer NOT NULL"]
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
      	{:alunoKey chave :exercicio "ex1" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "estrutura-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex1" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "alocDin" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex1" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex1" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "recursiv" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex1" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex1" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex1" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex1" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex1" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "metOrd" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex1" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "metPesq" :bom 0.33 :medio 0.33 :ruim 0.33}

    )))      		

(defn mostrar-dominio 
"Mostra o dominio referente a um aluno."
[chave]
(sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT DOMINIO.conteudo, DOMINIO.bom, DOMINIO.MEDIO, DOMINIO.ruim FROM DOMINIO WHERE DOMINIO.alunoKey = " chave)]
    (doall res))))

(defn mostrar-exercicios 
"Mostra o dominio referente a um aluno."
[chave conteudo]
(sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT EXERCICIO.exercicio, EXERCICIO.bom, EXERCICIO.medio, EXERCICIO.ruim FROM EXERCICIO WHERE EXERCICIO.alunoKey = " chave" AND EXERCICIO.conteudo = '" conteudo "'")]
    (doall res))))




(defn atualizar-probs-conteudo 
"Dada a chave de um aluno e o conteudo, atualiza as probabilidades deste conteudo."
[chave nconteudo qbom qmedio qruim]
    (sql/with-connection ILS-DB
      (sql/update-values :dominio
       [(str "DOMINIO.alunoKey =" chave " AND DOMINIO.conteudo = '" nconteudo "'")]
       {:alunoKey chave :conteudo nconteudo :bom qbom :medio qmedio :ruim qruim})))

(defn atualizar-probs-exercicio 
"Dada a chave de um aluno, o conteudo e o exercício, atualiza as probabilidades deste exercicio."
[chave nconteudo ex qbom qmedio qruim]
    (sql/with-connection ILS-DB
      (sql/update-values :exercicio
       [(str "EXERCICIO.alunoKey =" chave " AND EXERCICIO.conteudo = '" nconteudo "' AND EXERCICIO.exercicio = '" ex"'")]
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
"Atualiza as probabilidades de um exercicio de algum conteudo (nao use aspas!). Ex: (atualizar-exercicio estrutura-dados :ex1 1.0 0.0 0.0)"
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
                                        (assoc estrutura-dados :ex1 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 0))3)]
                                                :ex2 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 2))3)]
						:ex3 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 3))3)]
						:ex4 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 4))3)]
						:ex5 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 5))3)]
						:ex6 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 6))3)]
						:ex7 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 7))3)]
						:ex8 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 8))3)]
						:ex9 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 9))3)]
						:ex10 [(nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "estrutura-dados") 1))3)] ))
	   (= conteudo "alocDin") (def alocDin
                                (assoc alocDin :ex1 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 0))3)]
                                                :ex2 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 2))3)]
						:ex3 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 3))3)]
						:ex4 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 4))3)]
						:ex5 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 5))3)]
						:ex6 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 6))3)]
						:ex7 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 7))3)]
						:ex8 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 8))3)]
						:ex9 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 9))3)]
						:ex10 [(nth (vals (nth (mostrar-exercicios chave "alocDin") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "alocDin") 1))3)] ))
	   (= conteudo "vetor") (def vetor
                               (assoc vetor :ex1 [(nth (vals (nth (mostrar-exercicios chave "vetor") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 0))3)]
                                                :ex2 [(nth (vals (nth (mostrar-exercicios chave "vetor") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 2))3)]
						:ex3 [(nth (vals (nth (mostrar-exercicios chave "vetor") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 3))3)]
						:ex4 [(nth (vals (nth (mostrar-exercicios chave "vetor") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 4))3)]
						:ex5 [(nth (vals (nth (mostrar-exercicios chave "vetor") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 5))3)]
						:ex6 [(nth (vals (nth (mostrar-exercicios chave "vetor") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 6))3)]
						:ex7 [(nth (vals (nth (mostrar-exercicios chave "vetor") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 7))3)]
						:ex8 [(nth (vals (nth (mostrar-exercicios chave "vetor") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 8))3)]
						:ex9 [(nth (vals (nth (mostrar-exercicios chave "vetor") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 9))3)]
						:ex10 [(nth (vals (nth (mostrar-exercicios chave "vetor") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "vetor") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "vetor") 1))3)] ))
           (= conteudo "recursiv") (def recursiv
                                 (assoc recursiv :ex1 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 0))3)]
                                                :ex2 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 2))3)]
						:ex3 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 3))3)]
						:ex4 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 4))3)]
						:ex5 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 5))3)]
						:ex6 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 6))3)]
						:ex7 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 7))3)]
						:ex8 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 8))3)]
						:ex9 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 9))3)]
						:ex10 [(nth (vals (nth (mostrar-exercicios chave "recursiv") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "recursiv") 1))3)] ))
           (= conteudo "lista") (def lista
                               (assoc lista :ex1 [(nth (vals (nth (mostrar-exercicios chave "lista") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 0))3)]
                                                :ex2 [(nth (vals (nth (mostrar-exercicios chave "lista") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 2))3)]
						:ex3 [(nth (vals (nth (mostrar-exercicios chave "lista") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 3))3)]
						:ex4 [(nth (vals (nth (mostrar-exercicios chave "lista") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 4))3)]
						:ex5 [(nth (vals (nth (mostrar-exercicios chave "lista") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 5))3)]
						:ex6 [(nth (vals (nth (mostrar-exercicios chave "lista") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 6))3)]
						:ex7 [(nth (vals (nth (mostrar-exercicios chave "lista") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 7))3)]
						:ex8 [(nth (vals (nth (mostrar-exercicios chave "lista") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 8))3)]
						:ex9 [(nth (vals (nth (mostrar-exercicios chave "lista") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 9))3)]
						:ex10 [(nth (vals (nth (mostrar-exercicios chave "lista") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "lista") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "lista") 1))3)] ))
           (= conteudo "arvore") (def arvore
                               (assoc arvore :ex1 [(nth (vals (nth (mostrar-exercicios chave "arvore") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 0))3)]
                                                :ex2 [(nth (vals (nth (mostrar-exercicios chave "arvore") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 2))3)]
						:ex3 [(nth (vals (nth (mostrar-exercicios chave "arvore") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 3))3)]
						:ex4 [(nth (vals (nth (mostrar-exercicios chave "arvore") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 4))3)]
						:ex5 [(nth (vals (nth (mostrar-exercicios chave "arvore") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 5))3)]
						:ex6 [(nth (vals (nth (mostrar-exercicios chave "arvore") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 6))3)]
						:ex7 [(nth (vals (nth (mostrar-exercicios chave "arvore") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 7))3)]
						:ex8 [(nth (vals (nth (mostrar-exercicios chave "arvore") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 8))3)]
						:ex9 [(nth (vals (nth (mostrar-exercicios chave "arvore") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 9))3)]
						:ex10 [(nth (vals (nth (mostrar-exercicios chave "arvore") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "arvore") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "arvore") 1))3)] ))
           (= conteudo "fila") (def fila
                             (assoc fila :ex1 [(nth (vals (nth (mostrar-exercicios chave "fila") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 0))3)]
                                                :ex2 [(nth (vals (nth (mostrar-exercicios chave "fila") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 2))3)]
						:ex3 [(nth (vals (nth (mostrar-exercicios chave "fila") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 3))3)]
						:ex4 [(nth (vals (nth (mostrar-exercicios chave "fila") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 4))3)]
						:ex5 [(nth (vals (nth (mostrar-exercicios chave "fila") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 5))3)]
						:ex6 [(nth (vals (nth (mostrar-exercicios chave "fila") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 6))3)]
						:ex7 [(nth (vals (nth (mostrar-exercicios chave "fila") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 7))3)]
						:ex8 [(nth (vals (nth (mostrar-exercicios chave "fila") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 8))3)]
						:ex9 [(nth (vals (nth (mostrar-exercicios chave "fila") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 9))3)]
						:ex10 [(nth (vals (nth (mostrar-exercicios chave "fila") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "fila") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "fila") 1))3)] ))
           (= conteudo "pilha") (def pilha
                               (assoc pilha :ex1 [(nth (vals (nth (mostrar-exercicios chave "pilha") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 0))3)]
                                                :ex2 [(nth (vals (nth (mostrar-exercicios chave "pilha") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 2))3)]
						:ex3 [(nth (vals (nth (mostrar-exercicios chave "pilha") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 3))3)]
						:ex4 [(nth (vals (nth (mostrar-exercicios chave "pilha") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 4))3)]
						:ex5 [(nth (vals (nth (mostrar-exercicios chave "pilha") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 5))3)]
						:ex6 [(nth (vals (nth (mostrar-exercicios chave "pilha") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 6))3)]
						:ex7 [(nth (vals (nth (mostrar-exercicios chave "pilha") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 7))3)]
						:ex8 [(nth (vals (nth (mostrar-exercicios chave "pilha") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 8))3)]
						:ex9 [(nth (vals (nth (mostrar-exercicios chave "pilha") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 9))3)]
						:ex10 [(nth (vals (nth (mostrar-exercicios chave "pilha") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "pilha") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "pilha") 1))3)] ))
           (= conteudo "metOrd") (def metOrd
                               (assoc metOrd :ex1 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 0))3)]
                                                :ex2 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 2))3)]
						:ex3 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 3))3)]
						:ex4 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 4))3)]
						:ex5 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 5))3)]
						:ex6 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 6))3)]
						:ex7 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 7))3)]
						:ex8 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 8))3)]
						:ex9 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 9))3)]
						:ex10 [(nth (vals (nth (mostrar-exercicios chave "metOrd") 1))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 1))2)
						      (nth (vals (nth (mostrar-exercicios chave "metOrd") 1))3)] ))
	   (= conteudo "metPesq") (def metPesq
                               (assoc metPesq :ex1 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 0))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 0))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 0))3)]
                                                :ex2 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 2))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 2))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 2))3)]
						:ex3 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 3))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 3))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 3))3)]
						:ex4 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 4))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 4))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 4))3)]
						:ex5 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 5))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 5))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 5))3)]
						:ex6 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 6))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 6))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 6))3)]
						:ex7 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 7))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 7))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 7))3)]
						:ex8 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 8))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 8))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 8))3)]
						:ex9 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 9))1)
 						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 9))2)
						      (nth (vals (nth (mostrar-exercicios chave "metPesq") 9))3)]
						:ex10 [(nth (vals (nth (mostrar-exercicios chave "metPesq") 1))1)
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


