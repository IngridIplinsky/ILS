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
          
          
(defn gerar-apresentacao
 "Gera um arquivo xml de apresentacao e o grava no banco."
     ([nomearq idAp conteudo tipo selecao organizacao utilizacao dado]
	  (let [tags (element :apresentacao {:xmlns "apresentacao" :xmlns:xsi "apresentacao" :xsi:schemaLocation "src/dominio/apresentacao.xsd"}
                 (element :idAp {} idAp)
                 (element :conteudo {} conteudo)
                 (element :tipo {} tipo)
                 (element :selecao {} selecao)
                 (element :organizacao {} organizacao)
                 (element :utilizacao {} utilizacao)
                 (cond
                    (= tipo "texto") (element :texto {} dado)
                    (= tipo "codigo") (element :codigo {}  dado)                     
                    :else "tipo de apresentacao ou dados passados de maneira incorreta!"
                 ))]
       (with-open [out-file (java.io.FileWriter. nomearq)]
       (emit tags out-file)))
       (inserir-apresentacao nomearq))
     ([nomearq idAp conteudo tipo selecao organizacao utilizacao tipod dado legenda]
	  (let [tags (element :apresentacao {:xmlns "apresentacao" :xmlns:xsi "apresentacao" :xsi:schemaLocation "src/dominio/apresentacao.xsd"}
                 (element :idAp {} idAp)
                 (element :conteudo {} conteudo)
                 (element :tipo {} tipo)
                 (element :selecao {} selecao)
                 (element :organizacao {} organizacao)
                 (element :utilizacao {} utilizacao)
                 (cond
                    (and (= tipo "video") (= tipod "diretorio")) (element :video {} (element :diretorio {} dado) (element :legenda {} legenda))
                    (and (= tipo "video") (= tipod "url")) (element :video {} (element :url {} dado) (element :legenda {} legenda))
                    (and (= tipo "video") (= tipod "embedded")) (element :video {} (element :embedded {} dado) (element :legenda {} legenda))
                    (and (= tipo "figura") (= tipod "diretorio")) (element :figura {} (element :diretorio {} dado) (element :legenda {} legenda))
                    (and (= tipo "figura") (= tipod "url")) (element :figura {} (element :url {} dado) (element :legenda {} legenda))
                    (and (= tipo "animacao") (= tipod "diretorio")) (element :animacao {} (element :diretorio {} dado) (element :legenda {} legenda))
                    (and (= tipo "animacao") (= tipod "url")) (element :animacao {} (element :url {} dado) (element :legenda {} legenda))                  
                    :else "tipo de apresentacao ou dados passados de maneira incorreta!"
                 ))]
       (with-open [out-file (java.io.FileWriter. nomearq)]
       (emit tags out-file)))
       (inserir-apresentacao nomearq)))


