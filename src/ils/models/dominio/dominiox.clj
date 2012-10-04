(ns dominio.dominiox
  (:require [clojure.xml :as xml]
  	[clojure.zip :as zip] 
	[clojure.contrib.zip-filter.xml :as zf]
	[clojure.java.jdbc :as sql])
  (:use clojure.data.xml)
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
   ;(sql/with-connection ILS-DB
   ; (sql/drop-table :apresentacao))
  ; (sql/with-connection ILS-DB
   ; (sql/drop-table :multimidia))
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
    
    
 (defn neoparse [xml]
  "Pega um xml em formato de string, advindo de entrada ou banco de dados e o guarda em uma estrutura."
   (let [input-xml (java.io.StringReader. xml)]
                           (parse input-xml)))
                           
 (defn carregar-exercicio [id]
  "Carrega o xml do exercício para a memória. A definição de uma estrutura para tal deixa as operações muito mais rápidas."
	(def xml (neoparse (buscar-exercicio id))))
	
 (defn carregar-apresentacao [id]
  "Carrega o xml da apresentacao para a memória. A definição de uma estrutura para tal deixa as operações muito mais rápidas."
	(def xml (neoparse (buscar-apresentacao id))))  
	
 (defn carregar-multimidia [id]
  "Carrega o xml da multimidia para a memória. A definição de uma estrutura para tal deixa as operações muito mais rápidas."
	(def xml (neoparse (buscar-multimidia id)))) 
 
 (defn get-value-exercicio 
 "A forma mais facil que encontrei. Faz o que get-value fazia, mas para o banco. É bem prática, seguindo o modelo :)
  Especifica para exercicio. "
  ([tag]
   (cond 
   		(= tag "conteudo") (first (:content (nth (last (last (vec xml)))0)))
   		(= tag "idEx") (first (:content (nth (last (last (vec xml)))1)))
   		(= tag "nivel") (first (:content (nth (last (last (vec xml)))2)))
   		(= tag "tipo") (first (:content (nth (last (last (vec xml)))3)))
   		(= tag "preReq") (first (:content (nth (last (last (vec xml)))4)))	
   		(= tag "enunciado") (first (:content (nth (:content (nth (last (last (vec xml )))5))0)))
   		(= tag "resposta") (first (:content (nth (:content (nth (last (last (vec xml )))6))0)))
    	:else "tag inválida ou entrada incorreta!" ))
   ([tag pos]
   	(cond
   		(= tag "enunciado") (first (:content (nth (:content (nth (last (last (vec xml )))5))pos)))
   		(= tag "resposta") (first (:content (nth (:content (nth (last (last (vec xml )))6))pos)))
   		(= tag "alternativa") (first (:content (nth (:content (nth (last (last (vec xml )))(+ pos 7)))0)))
   		:else "tag inválida ou entrada incorreta!"))
   ([tag pos pos1]
   	(cond
   		(= tag "alternativa") (first (:content (nth (:content (nth (last (last (vec xml )))(+ pos 7)))pos1)))
   		(= tag "enunciado") (first (:content (nth (vec (:content (nth (:content (nth (last (last (vec xml )))5))pos)))pos1)))
   		:else "tag inválida ou entrada incorreta!")))
   
   
(defn get-attr-exercicio
 "Esta função é específica para pegar atributos de tags. É muito útil para saber se uma questão é correta (retorna true) ou incorreta (nil)
  ou para V ou F (que retorna true ou false). A partir do id e da posição."
 ([tag pos] ;para pegar valores de alternativas
 (cond 
 	(= tag "alternativa") (first (vals (:attrs (nth (last (last (vec xml )))(+ pos 7)))))
 	:else "tag inválida ou entrada incorreta!"))
 ([tag pos1 pos2] ;especial para pegar os id's de item em exercicios do tipo aa Ex: (get-attr-exercicio "f010" 5 3 0) 
 (cond
 	(= tag "enunciado")	(first (vals (:attrs (nth (vec (:content (nth (:content (nth (last (last (vec xml )))5))pos1)))pos2))))
 	:else "tag inválida ou entrada incorreta!")))

 

(defn get-value-apresentacao 
 "A forma mais facil que encontrei. Faz o que get-value fazia, mas para o banco. É bem prática, seguindo o modelo :)
  Especifica para apresentacao. "
 ([tag] ;use para pegar conteudos de tags.
  (cond 
      	(= tag "idAp") (first (:content (nth (last (nth (vec xml )2))0)))
      	(= tag "conteudo") (first (:content (nth (last (nth (vec xml )2))1)))
      	(= tag "texto") (first (:content (nth (last (nth (vec xml )2))2)))
      	(= tag "codigo") (first (:content (nth (last (nth (vec xml )2))3)))
      	:else "tag inválida ou entrada incorreta!" 
  ))) 
     
  
(defn get-value-multimidia 
 "A forma mais facil que encontrei. Faz o que get-value fazia, mas para o banco. É bem prática, seguindo o modelo :)
  Especifica para multimidia. "
 ([tag]
   (cond 
      	(= tag "idMult") (first (:content (nth (last (nth (vec xml )1))0)))
      	(= tag "conteudo") (first (:content (nth (last (nth (vec xml )1))1)))
      	(= tag "figura")  (first (:content (last (:content (nth (last (nth (vec xml )1))2))))) 
      	(= tag "video") (first (:content (last (:content (nth (last (nth (vec xml )1))2)))))
      	(= tag "animacao") (first (:content (last (:content (nth (last (nth (vec xml )1))2)))))
      	:else "tag inválida ou entrada incorreta!" 
  )))
  
  
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
  
  
(defn- reload-banco []
 "Uma funcao para restaurar o banco de dados, e fazer eventuais alterações que envolvam todos os arquivos .xml"
 	(destroi-tabelas)
 	(criar-tabela-exercicio)
; 	(criar-tabela-multimidia)
; 	(criar-tabela-apresentacao)
	(inserir-exercicio "v001" "vetor" "facil" "me" (slurp "src/dominio/vetor/exercicios/v001.xml"))
	(inserir-exercicio "v002" "vetor" "facil" "me" (slurp "src/dominio/vetor/exercicios/v002.xml"))
	(inserir-exercicio "v003" "vetor" "facil" "me" (slurp "src/dominio/vetor/exercicios/v003.xml"))
	(inserir-exercicio "v004" "vetor" "facil" "me" (slurp "src/dominio/vetor/exercicios/v004.xml"))
	(inserir-exercicio "v005" "vetor" "facil" "me" (slurp "src/dominio/vetor/exercicios/v005.xml"))
	(inserir-exercicio "v006" "vetor" "facil" "me" (slurp "src/dominio/vetor/exercicios/v006.xml"))
	(inserir-exercicio "v007" "vetor" "facil" "me" (slurp "src/dominio/vetor/exercicios/v007.xml"))
	(inserir-exercicio "v008" "vetor" "facil" "me" (slurp "src/dominio/vetor/exercicios/v008.xml"))
	(inserir-exercicio "v009" "vetor" "facil" "me" (slurp "src/dominio/vetor/exercicios/v009.xml"))
	(inserir-exercicio "v010" "vetor" "facil" "me" (slurp "src/dominio/vetor/exercicios/v010.xml"))
	(inserir-exercicio "v011" "vetor" "medio" "programacao" (slurp "src/dominio/vetor/exercicios/v011.xml"))
	(inserir-exercicio "v012" "vetor" "dificil" "programacao" (slurp "src/dominio/vetor/exercicios/v012.xml"))
	
	(inserir-exercicio "r001" "recursividade" "facil" "me" (slurp "src/dominio/recursiv/exercicios/r001.xml"))
	(inserir-exercicio "r002" "recursividade" "medio" "programacao" (slurp "src/dominio/recursiv/exercicios/r002.xml"))
	
	(inserir-exercicio "l001" "lista" "facil" "me" (slurp "src/dominio/lista/exercicios/l001.xml"))
	(inserir-exercicio "l002" "lista" "facil" "me" (slurp "src/dominio/lista/exercicios/l002.xml"))
	(inserir-exercicio "l003" "lista" "facil" "me" (slurp "src/dominio/lista/exercicios/l003.xml"))
	(inserir-exercicio "l004" "lista" "facil" "me" (slurp "src/dominio/lista/exercicios/l004.xml"))
	(inserir-exercicio "l005" "lista" "facil" "me" (slurp "src/dominio/lista/exercicios/l005.xml"))
	(inserir-exercicio "l006" "lista" "facil" "me" (slurp "src/dominio/lista/exercicios/l006.xml"))
	(inserir-exercicio "l007" "lista" "facil" "me" (slurp "src/dominio/lista/exercicios/l007.xml"))
	(inserir-exercicio "l008" "lista" "facil" "me" (slurp "src/dominio/lista/exercicios/l008.xml"))
	(inserir-exercicio "l009" "lista" "facil" "me" (slurp "src/dominio/lista/exercicios/l009.xml"))
	(inserir-exercicio "l010" "lista" "facil" "me" (slurp "src/dominio/lista/exercicios/l010.xml"))
	(inserir-exercicio "l011" "lista" "medio" "programacao" (slurp "src/dominio/lista/exercicios/l011.xml"))
	(inserir-exercicio "l012" "lista" "medio" "programacao" (slurp "src/dominio/lista/exercicios/l012.xml"))
	(inserir-exercicio "l013" "lista" "facil" "programacao" (slurp "src/dominio/lista/exercicios/l013.xml"))
	(inserir-exercicio "l014" "lista" "dificil" "programacao" (slurp "src/dominio/lista/exercicios/l014.xml"))
	
	(inserir-exercicio "f001" "fila" "facil" "me" (slurp "src/dominio/fila/exercicios/f001.xml"))
	(inserir-exercicio "f002" "fila" "facil" "me" (slurp "src/dominio/fila/exercicios/f002.xml"))
	(inserir-exercicio "f003" "fila" "facil" "me" (slurp "src/dominio/fila/exercicios/f003.xml"))
	(inserir-exercicio "f004" "fila" "facil" "me" (slurp "src/dominio/fila/exercicios/f004.xml"))
	(inserir-exercicio "f005" "fila" "facil" "vf" (slurp "src/dominio/fila/exercicios/f005.xml"))
	(inserir-exercicio "f006" "fila" "facil" "me" (slurp "src/dominio/fila/exercicios/f006.xml"))
	(inserir-exercicio "f007" "fila" "facil" "me" (slurp "src/dominio/fila/exercicios/f007.xml"))
	(inserir-exercicio "f008" "fila" "facil" "me" (slurp "src/dominio/fila/exercicios/f008.xml"))
	(inserir-exercicio "f009" "fila" "facil" "me" (slurp "src/dominio/fila/exercicios/f009.xml"))
	(inserir-exercicio "f010" "fila" "facil" "aa" (slurp "src/dominio/fila/exercicios/f010.xml"))
	
	(inserir-exercicio "ad001" "alocacao dinamica" "facil" "me" (slurp "src/dominio/alocDin/exercicios/ad001.xml"))
	(inserir-exercicio "ad002" "alocacao dinamica" "facil" "me" (slurp "src/dominio/alocDin/exercicios/ad002.xml"))
	(inserir-exercicio "ad003" "alocacao dinamica" "facil" "me" (slurp "src/dominio/alocDin/exercicios/ad003.xml"))
	(inserir-exercicio "ad004" "alocacao dinamica" "facil" "me" (slurp "src/dominio/alocDin/exercicios/ad004.xml"))
	(inserir-exercicio "ad005" "alocacao dinamica" "facil" "me" (slurp "src/dominio/alocDin/exercicios/ad005.xml"))
	(inserir-exercicio "ad006" "alocacao dinamica" "facil" "me" (slurp "src/dominio/alocDin/exercicios/ad006.xml"))
	(inserir-exercicio "ad007" "alocacao dinamica" "facil" "me" (slurp "src/dominio/alocDin/exercicios/ad007.xml"))
	(inserir-exercicio "ad008" "alocacao dinamica" "facil" "me" (slurp "src/dominio/alocDin/exercicios/ad008.xml"))
	(inserir-exercicio "ad009" "alocacao dinamica" "facil" "me" (slurp "src/dominio/alocDin/exercicios/ad009.xml"))
	(inserir-exercicio "ad010" "alocacao dinamica" "facil" "me" (slurp "src/dominio/alocDin/exercicios/ad010.xml"))
  ) 
  
