(ns dominio.dominiox
  (:require [clojure.xml :as xml]
  	[clojure.zip :as zip] 
	[clojure.contrib.zip-filter.xml :as zf]
	[clojure.java.jdbc :as sql])
  (:use clojure.data.xml)
  (:use clojure.contrib.zip-filter.xml)
)
  
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
  
(defn- criar-tabela-exercicio
"Funcao para testes. Não use diretamente!" 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :exercicio
           [:id "VARCHAR(20) NOT NULL"]
           [:conteudo "VARCHAR(50) NOT NULL"]
           [:nivel "VARCHAR(20) NOT NULL"]
           [:tipo "VARCHAR(20) NOT NULL"]
           [:xmlexercicio "CLOB(10000) NOT NULL"]
           ["CONSTRAINT PK_EXERCICIO PRIMARY KEY(id)"]
)))

(defn- criar-tabela-apresentacao
"Funcao para testes. Não use diretamente!" 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :apresentacao
           [:id "VARCHAR(20) NOT NULL"]
           [:conteudo "VARCHAR(50) NOT NULL"]
           [:xmlapresentacao "CLOB(10000) NOT NULL"]
           ["CONSTRAINT PK_APRESENTACAO PRIMARY KEY(id)"]
)))

(defn- criar-tabela-multimidia
"Funcao para testes. Não use diretamente!" 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :multimidia
           [:id "VARCHAR(20) NOT NULL"]
           [:conteudo "VARCHAR(50) NOT NULL"]
           [:tipo "VARCHAR(20) NOT NULL"]
           [:xmlmultimidia "CLOB(10000) NOT NULL"]
           ["CONSTRAINT PK_MULTIMIDIA PRIMARY KEY(id)"]
)))


(defn- destroi-tabelas 
"Não use isto. É so pra testes iniciais! Ou vai ter que repovoar o banco inteiro."
[]
   (sql/with-connection ILS-DB
    (sql/drop-table :exercicio))
   (sql/with-connection ILS-DB
    (sql/drop-table :apresentacao))
   (sql/with-connection ILS-DB
    (sql/drop-table :multimidia))
 )
    

;INSERCAO

(defn- inserir-exercicio
  "Funcao para inserir os xml prontos de exercicio no banco. 
   A função é usada juntamente com a função slurp, que lê um arquivo em Clojure."
   [id conteudo nivel tipo xml]
   (sql/with-connection ILS-DB
    (sql/insert-records :exercicio
      {:id id :conteudo conteudo :nivel nivel :tipo tipo :xmlexercicio xml}
    )))
    
    
(defn- inserir-apresentacao
  "Funcao para inserir os xml prontos de apresentacao no banco. 
   A função é usada juntamente com a função slurp, que lê um arquivo em Clojure."
   [id conteudo xml]
   (sql/with-connection ILS-DB
    (sql/insert-records :apresentacao
      {:id id :conteudo conteudo :xmlapresentacao xml}
    )))
    
(defn- inserir-multimidia
  "Funcao para inserir os xml prontos de multimidia no banco. 
   A função é usada juntamente com a função slurp, que lê um arquivo em Clojure."
   [id conteudo tipo xml]
   (sql/with-connection ILS-DB
    (sql/insert-records :multimidia
      {:id id :conteudo conteudo :tipo tipo :xmlmultimidia xml}
    )))
    
    
;REMOCAO

(defn- remover-exercicio
  "Funcao para remover algum exercicio do banco, pelo id."
   [id]
   (sql/with-connection ILS-DB
    (sql/delete-rows :exercicio
      [(str "exercicio.id = '"id"'")]
    )))
    
    
(defn- remover-apresentacao
  "Funcao para remover algum exercicio do banco, pelo id."
   [id]
   (sql/with-connection ILS-DB
    (sql/delete-rows :apresentacao
      [(str "apresentacao.id = '"id"'")]
    )))
    
(defn- remover-multimidia
  "Funcao para remover algum exercicio do banco, pelo id."
   [id]
   (sql/with-connection ILS-DB
    (sql/delete-rows :multimidia
      [(str "multimidia.id = '"id"'")]
    )))

;Uma funcao auxiliar de descompressão de CLOBS, usada nas buscas...
(defn clob-to-string [clob]
"Executa a descompressão de um CLOB."
  (with-open [rdr (java.io.BufferedReader. (.getCharacterStream clob))]
    (apply str (line-seq rdr))))
    
;BUSCA

;Parte 1: retornar os XML a partir do id.

(defn buscar-exercicio [id]
  "Esta função busca um exercicio em xml do banco, e é capaz de ler o CLOB já descompresso."
  (sql/with-connection ILS-DB
    (sql/transaction ;precisa ser dentro de uma transação para funcionar.
      (sql/with-query-results rs 
        [(str "SELECT exercicio.xmlexercicio FROM exercicio WHERE exercicio.id = '"id"'")]
        (clob-to-string (:xmlexercicio (first rs))) ))))
        
(defn buscar-apresentacao [id]
  "Esta função busca uma apresentacao em xml do banco, e é capaz de ler o CLOB já descompresso."
  (sql/with-connection ILS-DB
    (sql/transaction ;precisa ser dentro de uma transação para funcionar.
      (sql/with-query-results rs 
        [(str "SELECT apresentacao.xmlapresentacao FROM apresentacao WHERE apresentacao.id = '"id"'")]
        (clob-to-string (:xmlapresentacao (first rs))) ))))
        
(defn buscar-multimidia [id]
  "Esta função busca uma multimidia em xml do banco, e é capaz de ler o CLOB já descompresso."
  (sql/with-connection ILS-DB
    (sql/transaction ;precisa ser dentro de uma transação para funcionar.
      (sql/with-query-results rs 
        [(str "SELECT multimidia.xmlmultimidia FROM multimidia WHERE multimidia.id = '"id"'")]
        (clob-to-string (:xmlmultimidia (first rs))) ))))


;Parte 2: retornar os ids a partir de alguma condicao.
        
(defn buscar-id-exercicio [condicao rotulo]
	"Esta função busca os ids de exercicios dada uma propriedade (tipo, nivel, conteudo).
   	 Exemplo: conteudo vetor (tudo entre aspas), tipo facil (nao ponha acento)"
(sql/with-connection ILS-DB
  (sql/with-query-results res 
    [(str "SELECT exercicio.id FROM exercicio WHERE exercicio."condicao" = '"rotulo"'")]
    (doall res))))
    
(defn buscar-id-apresentacao [condicao rotulo]
	"Esta função busca os ids de apresentacoes dada uma propriedade (no caso é só conteudo, mas nao deixa de facilitar 
   	 e deixa mais padronizado).
   	 Exemplo: conteudo vetor  (tudo entre aspas)"
(sql/with-connection ILS-DB
  (sql/with-query-results res 
    [(str "SELECT apresentacao.id FROM apresentacao WHERE apresentacao."condicao" = '"rotulo"'")]
    (doall res))))
    
(defn buscar-id-multimidia [condicao rotulo]
	"Esta função busca os ids de multimidia dada uma propriedade (tipo, conteudo).
   	 Exemplo: conteudo vetor (tudo entre aspas), tipo facil (nao ponha acento)"
(sql/with-connection ILS-DB
  (sql/with-query-results res 
    [(str "SELECT multimidia.id FROM multimidia WHERE multimidia."condicao" = '"rotulo"'")]
    (doall res))))
        

; MANIPULAÇÃO DE XML

(defn get-value [xml & tags]
 "Pega o xml de um arquivo e o guarda em uma estrutura."
  (apply zf/xml1-> (zip/xml-zip (xml/parse xml)) (conj (vec tags) zf/text)))
  
 (defn zip-str [s]
  "Pega uma string em xml e realiza o parsing."
  (zip/xml-zip (xml/parse (java.io.ByteArrayInputStream. (.getBytes s)))))
                           
 (defn carregar-exercicio [id]
  "Carrega o xml do exercício para a memória. A definição de uma estrutura para tal deixa as operações muito mais rápidas."
	(def xmlEx (zip-str (buscar-exercicio id))))
	
 (defn carregar-apresentacao [id]
  "Carrega o xml da apresentacao para a memória. A definição de uma estrutura para tal deixa as operações muito mais rápidas."
	(def xmlAp (zip-str (buscar-apresentacao id))))  
	
 (defn carregar-multimidia [id]
  "Carrega o xml da multimidia para a memória. A definição de uma estrutura para tal deixa as operações muito mais rápidas."
	(def xmlMult (zip-str (buscar-multimidia id)))) 
 
 (defn get-value-exercicio 
 "Pega o conteudo da tag de um exercicio a partir do seu nome de tag. Para alternativas, é necessário passar a posição."
  ([tag]
   (cond 
   		(= tag "conteudo") (first (xml-> xmlEx :conteudo text))
   		(= tag "idEx") (first (xml-> xmlEx :idEx text))
   		(= tag "nivel") (first (xml-> xmlEx :nivel text))
   		(= tag "tipo") (first (xml-> xmlEx :tipo text))
   		(= tag "preReq") (first (xml-> xmlEx :preReq text))	
   		(= tag "enunciado") (first (xml-> xmlEx :enunciado :texto text))
   		(= tag "resposta") (first (xml-> xmlEx :resposta :codigo text))	
    	:else "tag inválida ou entrada incorreta!" ))
   ([tag pos]
   	(cond
   		(and (= tag "enunciado") (= pos "codigo")) (first (xml-> xmlEx :enunciado :codigo text))
   		(and (= tag "enunciado") (= pos "texto")) (first (xml-> xmlEx :enunciado :texto text))
   		(and (= tag "resposta") (= pos "texto")) (first (xml-> xmlEx :resposta :texto text))
   		(and (= tag "resposta") (= pos "codigo")) (first (xml-> xmlEx :resposta :codigo text))
   		(= tag "alternativa") (nth (xml-> xmlEx :alternativa text) pos)
   		:else "tag inválida ou entrada incorreta!"))
   ([tag tag2 pos]
   	(cond
   		(and (= tag "enunciado") (= tag2 "codigo")) (nth (xml-> xmlEx :enunciado :codigo text) pos)
   		(and (= tag "enunciado") (= tag2 "texto")) (nth (xml-> xmlEx :enunciado :texto text) pos)
   		(and (= tag "enunciado" ) (= tag2 "enum")) (nth (xml-> xmlEx :enunciado :enum :item text) pos)
   		(and (= tag "resposta") (= tag2 "texto")) (nth (xml-> xmlEx :resposta :texto text) pos)
   		(and (= tag "resposta") (= tag2 "codigo")) (nth (xml-> xmlEx :resposta :codigo text) pos)
   		:else "tag inválida ou entrada incorreta!")))
   
   
(defn get-attr-exercicio
 "Esta função é específica para pegar atributos de tags. É muito útil para saber se uma questão é correta (retorna true) ou incorreta (false)
  ou para V ou F (que também retorna true ou false)."
 ([tag pos]
 	(cond 
 		(= tag "alternativa") (nth (xml-> xmlEx :alternativa (attr :valor))pos)
 		:else "tag inválida ou entrada incorreta!"))
 ([tag tag2 pos] 
 	(cond
 		(and (= tag "enunciado") (= tag2 "enum")) (nth (xml-> xmlEx :enunciado :enum :item (attr :id))pos)
 		:else "tag inválida ou entrada incorreta!")))

 

(defn get-value-apresentacao 
 "Pega o conteudo da tag de uma apresencao a partir do nome de tag."
 ([tag] ;use para pegar conteudos de tags.
  (cond 
      	(= tag "idAp") (first (xml-> xmlAp :idAp text))
      	(= tag "conteudo") (first (xml-> xmlAp :conteudo text))
      	(= tag "texto") (first (xml-> xmlAp :texto text))
      	(= tag "codigo") (first (xml-> xmlAp :codigo text))
      	:else "tag inválida ou entrada incorreta!" ))) 
     
  
(defn get-value-multimidia 
 "Pega o conteudo da tag de um recurso multimidia a partir do(s) seu(s) nome(s) de tag(s)."
 ([tag]
   (cond 
      	(= tag "idMult") (first (xml-> xmlMult :idMult text))
      	(= tag "conteudo") (first (xml-> xmlMult :conteudo text))
      	(= tag "legenda") (first (xml-> xmlMult :legenda text))
      	:else "tag inválida ou entrada incorreta!" ))
 ([tag tag2]
 	(cond 
 		(and (= tag "figura") (= tag2 "url"))  (first (xml-> xmlMult :figura :url text))
 		(and (= tag "figura") (= tag2 "diretorio"))  (first (xml-> xmlMult :figura :diretorio text)) 
 		(and (= tag "animacao") (= tag2 "url"))  (first (xml-> xmlMult :animacao :url text))
 		(and (= tag "animacao") (= tag2 "diretorio"))  (first (xml-> xmlMult :animacao :diretorio text))
 		(and (= tag "video") (= tag2 "url"))  (first (xml-> xmlMult :video :url text))
 		(and (= tag "video") (= tag2 "diretorio"))  (first (xml-> xmlMult :video :diretorio text)) 
 		(and (= tag "video") (= tag2 "embedded"))  (first (xml-> xmlMult :video :embedded text))
 		:else "tag inválida ou entrada incorreta!" )))
  

  
;GERAÇÃO DE XML  
(defn gerar-xml [nomearq]
	"Gera um xml. Passa o arquivo como parametro."
	(let [tags (element :foo {:foo-attr "foo value"}
                     (element :bar {:bar-attr "bar value"}
                       (element :baz {} "The baz value1")
                       (element :baz {} "The baz value2")
                       (element :baz {} "The baz value3")))]
  (with-open [out-file (java.io.FileWriter. nomearq)]
    (emit tags out-file))))
  
  
