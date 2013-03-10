(ns ils.models.dominio.BD.persistence
 (:require [clojure.java.jdbc :as sql])
)
 
;CONEXAO DO BANCO
(def ILS-DB 
   {
    :classname   "org.h2.Driver"
    :subprotocol "h2:file"
    :subname     (str (System/getProperty "user.dir") "/" "demo")
    :user        "sa"
    :password    ""
   }
)
 
;CRIAÇÃO DE TABELAS. Apenas para eventuais manutenções e testes, não é para ser usado.  

(defn criar-tabela-professor
"Cria a tabela professor." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :professor
    	[:matricula "VARCHAR(20) NOT NULL"]
    	[:nome "VARCHAR(50) NOT NULL"]
    	[:sobrenome "VARCHAR(100) NOT NULL"]
    	[:titulo "VARCHAR(20) NOT NULL"]
    	[:email "VARCHAR(50) NOT NULL"]
    	[:usuario "VARCHAR(30) NOT NULL"]
    	[:senha "VARCHAR(30) NOT NULL"]
    	["CONSTRAINT PK_PROFESSOR PRIMARY KEY(matricula)"])))
    	
(defn criar-tabela-aluno
"Cria a tabela aluno." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :aluno
       	[:matricula "varchar(20) NOT NULL"]
       	[:nome "varchar(50) NOT NULL"]
        [:sobrenome "varchar(100) NOT NULL"]
	      [:curso "varchar(50) NOT NULL"]
	      [:email "varchar(50)"]
	      [:usuario "varchar(30) NOT NULL"]
        [:senha "varchar(30) NOT NULL"]
        [:disciplina "varchar(30) NOT NULL"]          
        ["CONSTRAINT PK_ALUNO PRIMARY KEY(matricula)"])))

(defn criar-tabela-disciplina
"Cria a tabela disciplina." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :disciplina
    	[:sigla "VARCHAR(20) NOT NULL"]
    	[:nome "VARCHAR(50) NOT NULL"]
    	[:xmlhierarquia "CLOB(10000) NOT NULL"]
    	["CONSTRAINT PK_DISCIPLINA PRIMARY KEY(sigla)"])))
    	
(defn criar-tabela-conteudo
"Cria a tabela conteudo" 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :conteudo
        [:idCont "VARCHAR(20) NOT NULL"]
    	[:sigla "VARCHAR(20) NOT NULL"]
    	[:conteudo "VARCHAR(50) NOT NULL"]
    	["CONSTRAINT PK_CONTEUDO PRIMARY KEY(idCont)"]
    	["CONSTRAINT FK_CONTEUDO FOREIGN KEY(sigla)
    	  REFERENCES disciplina(sigla)"])))
    	
(defn criar-tabela-ministra
"Cria a tabela ministra." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :ministra
    	[:sigla "VARCHAR(20) NOT NULL"]
    	[:matricula "VARCHAR(50) NOT NULL"]
    	["CONSTRAINT PK_MINISTRA PRIMARY KEY(sigla, matricula)"]
    	["CONSTRAINT FK_MIN_DISC FOREIGN KEY(sigla)
             REFERENCES disciplina(sigla)"]
        ["CONSTRAINT FK_MIN_PROF FOREIGN KEY(matricula)
             REFERENCES professor(matricula)"])))
 
(defn criar-tabela-exercicio
"Cria a tabela exercicio." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :exercicio
           [:idEx "VARCHAR(20) NOT NULL"]
           [:idCont "VARCHAR(50) NOT NULL"]
           [:nivel "VARCHAR(20) NOT NULL"]
           [:tipo "VARCHAR(20) NOT NULL"]
           [:xmlexercicio "CLOB(10000) NOT NULL"]
           ["CONSTRAINT PK_EXERCICIO PRIMARY KEY(idEx)"]
           ["CONSTRAINT FK_EXERCICIO FOREIGN KEY(idCont)
             REFERENCES conteudo(idCont)"])))
             
(defn criar-tabela-estiloEstudante
"Cria a tabela estiloEstudante." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :estiloEstudante
           [:matricula "VARCHAR(20) NOT NULL"]
           [:sigla "VARCHAR(20) NOT NULL"]
           [:idEst "VARCHAR(20) NOT NULL"]
           ["CONSTRAINT PK_ESTEST PRIMARY KEY(matricula, sigla)"]
           ["CONSTRAINT FK_ESTEST_APRE FOREIGN KEY(idEst)
             REFERENCES estilo(idEst)"]
           )))

(defn criar-tabela-estilo
"Cria a tabela estilo." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :estilo
    	     [:idEst "VARCHAR(20) NOT NULL"]
           [:selecao "VARCHAR(20) NOT NULL"]
           [:organizacao "VARCHAR(20) NOT NULL"]
           [:utilizacao "VARCHAR(20) NOT NULL"]
           ["UNIQUE(selecao, organizacao, utilizacao)"]
           ["CONSTRAINT PK_ESTILO PRIMARY KEY(idEst)"]
           )))

(defn criar-tabela-apresentacao
"Cria a tabela apresentacao." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :apresentacao
           [:idAp "VARCHAR(20) NOT NULL"]
           [:idCont "VARCHAR(50) NOT NULL"]
           [:tipo "VARCHAR(20) NOT NULL"]
           [:idEst "VARCHAR(20) NOT NULL"]
           [:xmlapresentacao "CLOB(10000) NOT NULL"]
           ["CONSTRAINT PK_APRESENTACAO PRIMARY KEY(idAp)"]
           ["CONSTRAINT FK_APRESENTACAOEST FOREIGN KEY(idEst)
             REFERENCES estilo(idEst)"]
		   ["CONSTRAINT FK_APRESENTACAOCONT FOREIGN KEY(idCont)
             REFERENCES conteudo(idCont)"]
           )))

(defn criar-tabela-conteudoAluno
"Cria a tabela conteudoAluno." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :conteudoAluno
           [:matricula "varchar(20) NOT NULL"]
           [:idCont "varchar(50) NOT NULL"]
           [:bom "float NOT NULL"]
	         [:medio "float NOT NULL"]
	         [:ruim "float NOT NULL"]
           ["CONSTRAINT PK_CONTEUDO_ALUNO PRIMARY KEY(matricula, idCont)"]
           ["CONSTRAINT FK_CONTAL_AL 
  	    FOREIGN KEY (matricula) REFERENCES aluno(matricula)"]
  	       ["CONSTRAINT FK_CONTAL_CONT 
  	    FOREIGN KEY(idCont) REFERENCES conteudo(idCont)"])))

(defn criar-tabela-exercicioAluno
"Cria a tabela exercicioAluno." 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :exercicioAluno
     	[:matricula "varchar(20) NOT NULL"]
      [:idCont "varchar(50) NOT NULL"]
     	[:idEx "varchar(20) NOT NULL"]
      [:bom "float NOT NULL"]
	   	[:medio "float NOT NULL"]
	   	[:ruim "float NOT NULL"]
      ["CONSTRAINT PK_EXALUNO PRIMARY KEY(matricula, idCont, idEx)"]
	   	["CONSTRAINT FK_EXALUNO_A 
  	    FOREIGN KEY (matricula) REFERENCES aluno(matricula)"]
  	  ["CONSTRAINT FK_EXALUNO_C 
  	    FOREIGN KEY (idCont, idEx) REFERENCES exercicio(idCont, idEx)"]))) 
  	    
  	    
(defn criar-tabela-catalogoBug
"Cria a tabela catalogoBug."
[]
  (sql/with-connection ILS-DB
    (sql/create-table :catalogoBug
    	[:idBug "VARCHAR(20) NOT NULL"]
    	[:matricula "VARCHAR(20) NOT NULL"]
    	[:idCont "VARCHAR(50) NOT NULL"]
    	[:idEx "VARCHAR(20) NOT NULL"]
    	[:xmlbug "CLOB(10000) NOT NULL"]
    	["CONSTRAINT PK_CATALOGOBUG PRIMARY KEY(idBug)"]
	   	["CONSTRAINT FK_CB_A 
  	    FOREIGN KEY (matricula) REFERENCES aluno(matricula)"]
  	    ["CONSTRAINT FK_CB_C 
  	    FOREIGN KEY (idCont, idEx) REFERENCES exercicio(idCont, idEx)"])))
  	    
(defn criar-tabela-logAluno
"Cria a tabela logAluno."
[]
  (sql/with-connection ILS-DB
    (sql/create-table :logAluno
       [:idLog "VARCHAR(20) NOT NULL"]
	   [:matricula "VARCHAR(20) NOT NULL"]
	   [:sigla "VARCHAR(20) NOT NULL"]
	   [:idCont "VARCHAR(20) NOT NULL"]
	   [:idEx "VARCHAR(20) NOT NULL"]
	   ["CONSTRAINT PK_LOGALUNO PRIMARY KEY(idLog, matricula)"]
;	   ["CONSTRAINT FK_LOGALUNO FOREIGN KEY(matricula)
;	     REFERENCES aluno(matricula)"]
;	   ["CONSTRAINT FK_LOGALUNOSigla FOREIGN KEY(sigla)
;	     REFERENCES disciplina(sigla)"]
;	   ["CONSTRAINT FK_LOGALUNOCont FOREIGN KEY(idCont)
;             REFERENCES conteudo(idCont)"]
;	   ["CONSTRAINT FK_LOGALUNOEx FOREIGN KEY(idEx)
;	     REFERENCES exercicio(idEx)"]
	   )))

(defn criar-tabela-redeBayes
"Cria a tabela redeBayes."
[]
  (sql/with-connection ILS-DB
    (sql/create-table :redeBayes
       [:idBayes "VARCHAR(20) NOT NULL"]
       [:sigla "VARCHAR(20) NOT NULL"]
       [:xmlBayes "CLOB(10000) NOT NULL"]
       ["CONSTRAINT PK_REDEBAYES PRIMARY KEY(idBayes,sigla)"]
       ["CONSTRAINT FK_REDEBAYES_SIGLA FOREIGN KEY(sigla)
         REFERENCES disciplina(sigla)"]))) 

(defn criar-tabela-matricula
  "Cria a tabela matricula."
[]
  (sql/with-connection ILS-DB
    (sql/create-table :matricula
       [:matricula "VARCHAR(20) NOT NULL"]
       [:sigla "VARCHAR(20) NOT NULL"]
       ["CONSTRAINT PK_MATRICULA PRIMARY KEY(matricula,sigla)"]
       ["CONSTRAINT FK_MATRICULAEST FOREIGN KEY(matricula)
         REFERENCES aluno(matricula)"]
       ["CONSTRAINT FK_MATRICULADISC FOREIGN KEY(sigla)
         REFERENCES disciplina(sigla)"])))

(defn destroi-tabelas 
"Destroi todas as tabelas do banco. (Não use isto)"
[]
   (sql/with-connection ILS-DB
    (sql/drop-table :apresentacao))
   (sql/with-connection ILS-DB
    (sql/drop-table :exercicio))
   (sql/with-connection ILS-DB
    (sql/drop-table :catalogoBug))
   (sql/with-connection ILS-DB
    (sql/drop-table :disciplina))
   (sql/with-connection ILS-DB
    (sql/drop-table :conteudoAluno))
   (sql/with-connection ILS-DB
    (sql/drop-table :exercicioAluno))
   (sql/with-connection ILS-DB
    (sql/drop-table :professor))
   (sql/with-connection ILS-DB
    (sql/drop-table :ministra))
   (sql/with-connection ILS-DB
    (sql/drop-table :conteudo))
   (sql/with-connection ILS-DB
    (sql/drop-table :estiloEstudante))
   (sql/with-connection ILS-DB
    (sql/drop-table :aluno))
   (sql/with-connection ILS-DB
    (sql/drop-table :estilo))
   (sql/with-connection ILS-DB
    (sql/drop-table :logAluno))
   (sql/with-connection ILS-DB
    (sql/drop-table :redeBayes))
   (sql/with-connection ILS-DB
    (sql/drop-table :matricula))
 )

