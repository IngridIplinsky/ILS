(ns dominio.xml.geracao
	(:use [clojure.data.xml]
	      [dominio.BD.insercao]))


(defn gerar-bug 
 "Gera um arquivo xml de erro e o grava no banco."
    ([nomearq idBug matricula conteudo idEx tipo dado]
	  (let [tags (element :erro {:xmlns "bug" :xmlns:xsi "bug" :xsi:schemaLocation "src/dominio/bug.xsd"}
                 (element :idBug {} idBug)
                 (element :matricula {} matricula)
                 (element :conteudo {} conteudo)
                 (element :idEx {} idEx)
                 (element :tipo {} tipo)
                 (cond
                    (= tipo "programacao") (element :codigo {} dado)
                    (= tipo "vf") (element :vf {}  dado)                     
                    :else "tipo de exercicio ou dados passados de maneira incorreta!"
                 ))]
       (with-open [out-file (java.io.FileWriter. nomearq)]
       (emit tags out-file)))
       (inserir-catalogoBug nomearq))
    ([nomearq idBug matricula conteudo idEx tipo correta marcada]
	   (let [tags (element :erro {:xmlns "bug" :xmlns:xsi "bug" :xsi:schemaLocation "src/dominio/bug.xsd"}
                 (element :idBug {} idBug)
                 (element :matricula {} matricula)
                 (element :conteudo {} conteudo)
                 (element :idEx {} idEx)
                 (element :tipo {} tipo)
                 (cond
                    (or (= tipo "me") (= tipo "aa")) (element :alternativa {} (element :correta {} correta) (element :marcada {} marcada))
                    :else "tipo de exercicio ou dados passados de maneira incorreta!"
                 ))]
         (with-open [out-file (java.io.FileWriter. nomearq)]
          (emit tags out-file)))
          (inserir-catalogoBug nomearq)))


