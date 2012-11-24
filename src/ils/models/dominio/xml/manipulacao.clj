(ns dominio.xml.manipulacao
	(:use [clojure.data.xml]
	      [clojure.contrib.zip-filter.xml] 
	      [dominio.BD.busca])
	(:require [clojure.xml :as xml]
  			  [clojure.zip :as zip] 
			  [clojure.contrib.zip-filter.xml :as zf]
			  [clojure.java.jdbc :as sql]))


(defn zip-str [s]
  "Pega uma string em xml e realiza o parsing."
  (zip/xml-zip (xml/parse (java.io.ByteArrayInputStream. (.getBytes s)))))

                           
(defn carregar-exercicio [id]
  "Carrega o xml do exercício para a memória. A definição de uma estrutura para tal deixa as operações muito mais rápidas."
	(def xmlEx (zip-str (buscar-exercicio id))))

	
(defn carregar-apresentacao [id]
  "Carrega o xml da apresentacao para a memória. A definição de uma estrutura para tal deixa as operações muito mais rápidas."
	(def xmlAp (zip-str (buscar-apresentacao id)))) 
	
(defn carregar-catalogoBug [id]
  "Carrega o xml da apresentacao para a memória. A definição de uma estrutura para tal deixa as operações muito mais rápidas."
	(def xmlBug (zip-str (buscar-catalogoBug id))))   
	
(defn carregar-disciplina [id]
  "Carrega o xml da apresentacao para a memória. A definição de uma estrutura para tal deixa as operações muito mais rápidas."
	(def xmlHie (zip-str (buscar-disciplina id))))  

   		
(defn get-tag-exercicio
   "Pega o conteudo da tag de um exercicio a partir do seu nome de tag."
     ([tag]
          (first (xml-> xmlEx tag text)))
     ([tag tag2]
          (if-not (number? tag2) (first (xml-> xmlEx tag tag2 text)) (nth (xml-> xmlEx tag text) tag2)))
     ([tag tag2 pos]
          (if-not (number? pos) (first (xml-> xmlEx tag tag2 pos text)) (nth (xml-> xmlEx tag tag2 text) pos)))
     ([tag tag2 tag3 pos]
          (if-not (number? pos) (first (xml-> xmlEx tag tag2 tag3 pos text)) (nth (xml-> xmlEx tag tag2 tag3 text) pos) )))
   
   
(defn get-attr-exercicio
 "Esta função é específica para pegar atributos de tags. É muito útil para saber se uma questão é correta (retorna true) ou incorreta (false)
  ou para V ou F (que também retorna true ou false)."
 ([tag atrib]
 		(first (xml-> xmlEx tag (attr atrib))))
 ([tag atrib pos]
 		(if-not (number? pos) (first (xml-> xmlEx tag atrib (attr pos))) (nth (xml-> xmlEx tag (attr atrib)) pos)))
 ([tag tag2 atrib pos] 
 		(if-not (number? pos) (first (xml-> xmlEx tag tag2 atrib (attr pos))) (nth (xml-> xmlEx tag tag2 (attr atrib)) pos)))
 ([tag tag2 tag3 atrib pos] 
 		(nth (xml-> xmlEx tag tag2 tag3 (attr atrib)) pos)))

(defn get-tag-apresentacao
   "Pega o conteudo da tag de uma apresentacao a partir do seu nome de tag."
     ([tag]
          (first (xml-> xmlAp tag text)))
     ([tag tag2]
          (if-not (number? tag2) (first (xml-> xmlAp tag tag2 text)) (nth (xml-> xmlAp tag text) tag2)))
     ([tag tag2 pos]
          (if-not (number? pos) (first (xml-> xmlAp tag tag2 pos text)) (nth (xml-> xmlAp tag tag2 text) pos))))
 

(defn get-tag-catalogoBug
   "Pega o conteudo da tag de erro a partir do seu nome de tag."
     ([tag]
          (first (xml-> xmlBug tag text)))
     ([tag tag2]
          (if-not (number? tag2) (first (xml-> xmlBug tag tag2 text)) (nth (xml-> xmlBug tag text) tag2)))
     ([tag tag2 pos]
          (if-not (number? pos) (first (xml-> xmlBug tag tag2 pos text)) (nth (xml-> xmlBug tag tag2 text) pos))))
          
          
(defn get-tag-disciplina
   "Pega o conteudo da tag de uma disciplina."
     ([tag]
          (first (xml-> xmlHie tag text)))
     ([tag tag2 tag3]
          (first (:content (first (zip/children (first (xml-> xmlHie tag tag2))))))) 
     ([tag tag2 tag3 pos]
         (if-not (number? pos) (first (:content (first (zip/children (nth (xml-> xmlHie tag tag2) tag3)))))  
                 (first (:content (nth (zip/children (xml1-> xmlHie tag tag2)) pos)))))
      ([tag tag2 pos1 tag3 pos] 
         (first (:content (nth (zip/children (nth (xml-> xmlHie tag tag2) pos1)) pos))))) 
         
(defn get-attr-disciplina
   "Pega atributos de disciplina."
     ([tag tag2 atrib]
          (first (xml-> xmlHie tag tag2 (attr atrib))))
     ([tag tag2 atrib pos]
          (nth (xml-> xmlHie tag tag2 (attr atrib)) pos))) 

  
