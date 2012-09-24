(ns ils.models.dominio.dominio
  (:require [clojure.xml :as xml]
  	[clojure.zip :as zip] 
	[clojure.contrib.zip-filter.xml :as zf]
	[clojure.java.jdbc :as sql])
  (:use [clojure.data.xml])
)
  
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




  ;CRIAÇÃO DE TABELAS. Apenas para eventuais manutenções e testes, não é para ser usado.  
  


(defn criar-tabela-exercicio-dominio
"Funcao para testes. Não use diretamente!" 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :exerciciodominio
           [:id "VARCHAR(20) NOT NULL"]
           [:conteudo "VARCHAR(50) NOT NULL"]
           [:nivel "VARCHAR(20) NOT NULL"]
           [:tipo "VARCHAR(20) NOT NULL"]
           [:xmlexercicio "CLOB(10000) NOT NULL"]
           ["CONSTRAINT PK_EXERCICIODOMINIO PRIMARY KEY(id)"]
)))

(defn criar-tabela-apresentacao
"Funcao para testes. Não use diretamente!" 
[]
  (sql/with-connection ILS-DB
    (sql/create-table :apresentacao
           [:id "VARCHAR(20) NOT NULL"]
           [:conteudo "VARCHAR(50) NOT NULL"]
           [:xmlapresentacao "CLOB(10000) NOT NULL"]
           ["CONSTRAINT PK_APRESENTACAO PRIMARY KEY(id)"]
)))

(defn criar-tabela-multimidia
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


(defn- destroi-tabelas-dominio 
"Não use isto. É so pra testes iniciais! Ou vai ter que repovoar o banco inteiro."
[]
   (sql/with-connection ILS-DB
    (sql/drop-table :exerciciodominio))
   (sql/with-connection ILS-DB
    (sql/drop-table :apresentacao))
   (sql/with-connection ILS-DB
    (sql/drop-table :multimidia)))
    

;INSERCAO

(defn inserir-exercicios
  "Funcao para inserir os xml prontos de exercicio no banco. 
   A função é usada juntamente com a função slurp, que lê um arquivo em Clojure."
   [id conteudo nivel tipo xml]
   (sql/with-connection ILS-DB
    (sql/insert-records :exerciciodominio
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

(defn remover-exercicio
  "Funcao para remover algum exercicio do banco, pelo id."
   [id]
   (sql/with-connection ILS-DB
    (sql/delete-rows :exerciciodominio
      [(str "exercicio.id = '"id"'")]
    )))
    
    
(defn remover-apresentacao
  "Funcao para remover algum exercicio do banco, pelo id."
   [id]
   (sql/with-connection ILS-DB
    (sql/delete-rows :apresentacao
      [(str "apresentacao.id = '"id"'")]
    )))
    
(defn remover-multimidia
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
        [(str "SELECT exerciciodominio.xmlexercicio FROM exerciciodominio WHERE exerciciodominio.id = '"id"'")]
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
    [(str "SELECT exerciciodominio.id FROM exerciciodominio WHERE exerciciodominio."condicao" = '"rotulo"'")]
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
    
    
 (defn neoparse [xml]
  "Pega um xml em formato de string, advindo de entrada ou banco de dados e o guarda em uma estrutura."
   (let [input-xml (java.io.StringReader. xml)]
                           (parse input-xml)))
                           
 (defn carregar-xml [id]
  "Carrega o xml para a memória. A definição de uma estrutura para tal deixa as operações muito mais rápidas."
	(def xml (neoparse (buscar-exercicio id)))) 
 
 (defn get-value-exercicio 
 "A forma mais facil que encontrei. Faz o que get-value fazia, mas para o banco. É bem prática, seguindo o modelo :)
  Especifica para exercicio. "
 ;([id pos]
  ;(nth (last (nth (vec (neoparse (buscar-exercicio id)))0))pos)) ;use para ver toda a tag (o que inclui atributos no caso de alternativas)
  ([pos]
   (first (:content (nth (last (nth (vec xml)0))pos)))) ;use para tags simples.
   ;use esta para aquelas que possuem tags internas (enunciados, me ou v/f). escreva "true" no penultimo argumento e indique 
   ;a posicao da tag interna. Esta pega o primeiro nivel de tag interna, ou seja, nao pega a tag enum, em enunciado, por exemplo.
  ([pos pos1]
   (first (:content (nth (:content (nth (last (nth (vec xml )0))pos))pos1))))
  ([pos pos1 pos2] ;especial para pegar afirmacoes em exercicios do tipo aa (enum)
   (first (:content (nth (vec (:content (nth (:content (nth (last (nth (vec xml )0))pos))pos1)))pos2)))))
   
   
(defn get-attr-exercicio
 "Esta função é específica para pegar atributos de tags. É muito útil para saber se uma questão é correta (retorna true) ou incorreta (nil)
  ou para V ou F (que retorna true ou false). A partir do id e da posição."
 ([pos] ;para pegar valores de alternativas
 (:valor (first (rest (first (rest (get-value-exercicio pos)))))))
 ([id pos  pos1 pos2] ;especial para pegar os id's de item em exercicios do tipo aa Ex: (get-attr-exercicio "f010" 5 3 0)  
    (nth (first (:attrs (nth (vec (:content (nth (:content (nth (last (nth (vec xml )0))pos))pos1)))pos2)))1)))
 

(defn get-value-apresentacao 
 "A forma mais facil que encontrei. Faz o que get-value fazia, mas para o banco. É bem prática, seguindo o modelo :)
  Especifica para apresentacao. "
 ;([id pos] ;use para ver toda a tag
  ;(nth (last (nth (vec (neoparse (buscar-apresentacao id )))2))pos)) 
 ([id pos] ;use para pegar conteudos de tags.
  (first (:content (nth (last (nth (vec xml )2))pos))))) 
     
  
(defn get-value-multimidia 
 "A forma mais facil que encontrei. Faz o que get-value fazia, mas para o banco. É bem prática, seguindo o modelo :)
  Especifica para multimidia. "
 ;([id pos] ;use para ver toda a tag 
 ; (nth (last (nth (vec (neoparse (buscar-multimidia id )))1))pos)) 
 ([pos] ;use para pegar conteudos de tags simples.
  (first (:content (nth (last (nth (vec xml )1))pos))))
 ([pos alt] ;use esta para pegar url, diretorio, embedded de figuras, videos ou animacoes. Escreva "true" no ultimo argumento.
   (first (:content (last (:content (nth (last (nth (vec xml )1))pos))))))) 
  
  
  
  
