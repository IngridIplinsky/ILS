(ns ils.models.connection
  (:require [clojure.java.jdbc :as sql]))


;banco de dados
(def ILS-DB 
   {
    :classname   "org.h2.Driver"
    :subprotocol "h2:file"
    :subname     (str (System/getProperty "user.dir") "/" "demo")
    :user        "sa"
    :password    ""
   }
  )


;user=>((nth retorna 1):m_date)
;   "01/01/2012"

;user=>(get (nth retorna 1):m_date)
;   "01/01/2012"


;user=>(get {:name "joao"}:name)
;    "joao"

;user=>(nth retorna 1)
;   {:m_label "lab2", :m_date "01/01/2012", :m_comment "com2"}



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

(defn tet []
(for [i (range 0 (count list-aux))
       :when (inc i)]
     (imprime-dados-alunos i)))

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


    

(defn imprime []
       (do
           [:tr
           [:td [:h6 (get (nth list-aux 0) :nome)]]
           [:td [:h6 (get (nth list-aux 0) :alunokey)]]
           [:td [:h6 (get (nth list-aux 0) :sobrenome)]]
           [:td [:h6 (get (nth list-aux 0) :curso)]]
           [:td [:h6 (get (nth list-aux 0) :email)]]
           [:td [:h6 (get (nth list-aux 0) :usuario)]]
           [:td [:h6 (get (nth list-aux 0) :senha)]]]))


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
    (sql/drop-table :ALUNOS)))

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
      	{:alunoKey chave :conteudo "vetor" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "matriz" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "alocacao-dinamica" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "lista" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "pilha" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "fila" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "grafo" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "recursao" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "arvore" :bom 0.33 :medio 0.33 :ruim 0.34}
	{:alunoKey chave :conteudo "compressao-dados" :bom 0.33 :medio 0.33 :ruim 0.34}
    ))	
   (sql/with-connection ILS-DB
    (sql/insert-records :exercicio
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
	{:alunoKey chave :exercicio "ex1" :conteudo "matriz" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "matriz" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "matriz" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "matriz" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "matriz" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "matriz" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "matriz" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "matriz" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "matriz" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "matriz" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex1" :conteudo "alocacao-dinamica" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "alocacao-dinamica" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "alocacao-dinamica" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "alocacao-dinamica" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "alocacao-dinamica" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "alocacao-dinamica" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "alocacao-dinamica" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "alocacao-dinamica" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "alocacao-dinamica" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "alocacao-dinamica" :bom 0.33 :medio 0.33 :ruim 0.33}
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
	{:alunoKey chave :exercicio "ex1" :conteudo "grafo" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "grafo" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "grafo" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "grafo" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "grafo" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "grafo" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "grafo" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "grafo" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "grafo" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "grafo" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex1" :conteudo "recursao" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "recursao" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "recursao" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "recursao" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "recursao" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "recursao" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "recursao" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "recursao" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "recursao" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "recursao" :bom 0.33 :medio 0.33 :ruim 0.33}
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
	{:alunoKey chave :exercicio "ex1" :conteudo "compressao-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex2" :conteudo "compressao-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex3" :conteudo "compressao-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex4" :conteudo "compressao-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
      	{:alunoKey chave :exercicio "ex5" :conteudo "compressao-dados" :bom 0.33 :medio 0.33 :ruim 0.33}	
	{:alunoKey chave :exercicio "ex6" :conteudo "compressao-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex7" :conteudo "compressao-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex8" :conteudo "compressao-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex9" :conteudo "compressao-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	{:alunoKey chave :exercicio "ex10" :conteudo "compressao-dados" :bom 0.33 :medio 0.33 :ruim 0.33}
	
    )))      		

(defn mostrar-dominio 
"Mostra o dominio referente a um aluno."
[chave]
(sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT DOMINIO.* FROM DOMINIO WHERE DOMINIO.alunoKey = " chave)]
    (doall res))))

(defn mostrar-exercicios 
"Mostra o dominio referente a um aluno."
[chave conteudo]
(sql/with-connection ILS-DB
  (sql/with-query-results res [(str "SELECT EXERCICIO.* FROM EXERCICIO WHERE EXERCICIO.alunoKey = " chave" AND EXERCICIO.conteudo = '" conteudo "'")]
    (doall res))))

(defn atualizar-probs-conteudo 
"Dada a chave de um aluno e o conteudo, atualiza as probabilidades deste conteudo."
[chave nconteudo qbom qmedio qruim]
    (sql/with-connection ILS-DB
      (sql/update-or-insert-values :dominio
       [(str "DOMINIO.alunoKey =" chave " AND DOMINIO.conteudo = '" nconteudo "'")]
       {:alunoKey chave :conteudo nconteudo :bom qbom :medio qmedio :ruim qruim})))

(defn atualizar-probs-exercicio 
"Dada a chave de um aluno e o conteudo, atualiza as probabilidades deste conteudo."
[chave nconteudo ex qbom qmedio qruim]
    (sql/with-connection ILS-DB
      (sql/update-or-insert-values :exercicio
       [(str "EXERCICIO.alunoKey =" chave " AND EXERCICIO.conteudo = '" nconteudo "' AND EXERCICIO.exercicio = '" ex"'")]
       {:alunoKey chave :conteudo nconteudo :exercicio ex :bom qbom :medio qmedio :ruim qruim})))

