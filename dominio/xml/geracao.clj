(ns ils.models.dominio.xml.geracao
	(:use [clojure.data.xml]
	      [ils.models.dominio.BD.insercao]))


(defmacro criar-alternativas [i tipo alternativas tipoalt respostas]
  "Macro usada para definir alternativas em questoes de vf, me ou aa."
  `(if (or (= ~tipo "vf") (= ~tipo "me") (= ~tipo "aa")) 
        (for [~i (range (count ~alternativas))] 
                (element :alternativa {:valor (nth ~respostas ~i)} (element (nth ~tipoalt ~i) {} (nth ~alternativas ~i))))
        (throw (Exception. "tipo de alternativa passado incorretamente"))))

(defmacro criar-enunciado [i tipo entradas tipoentry]
  "Macro usada para definir enunciados."
  `(element :enunciado {} 
          (for [~i (range (count ~entradas))] 
              (element (nth ~tipoentry ~i) {} (nth ~entradas ~i)))))
   

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


(defn gerar-exercicio
 "Gera um arquivo xml de exercicio e grava no banco."
    ([nomearq conteudo idEx nivel tipo preReq enunciado tipoenunciado resposta]
      (let [tags (element :exercicio {:xmlns "exercicio" :xmlns:xsi "exercicio" :xsi:schemaLocation "src/dominio/exercicio.xsd"}
                 (element :conteudo conteudo)
                 (element :idEx {} idEx)
                 (element :nivel {} nivel)
                 (element :tipo {} tipo)
                 (element :preReq {} 
                    (for [i (range (count preReq))]
                        (element :req {} (nth preReq i))))
                 (let [i (count enunciado)] (criar-enunciado i tipo enunciado tipoenunciado))
                 (if (= tipo "programacao") (element :entradacodigo {}) (print "tipo de exercicio ou dados passados de maneira incorreta!"))
                 (element :resposta {} resposta))]
       (with-open [out-file (java.io.FileWriter. nomearq)]
       (emit tags out-file)))
       (inserir-exercicio nomearq)
       )
    ([nomearq conteudo idEx nivel tipo preReq enunciado tipoenunciado alternativa tipoalt resposta]
      (let [tags (element :exercicio {:xmlns "exercicio" :xmlns:xsi "exercicio" :xsi:schemaLocation "src/dominio/exercicio.xsd"}
                 (element :conteudo conteudo)
                 (element :idEx {} idEx)
                 (element :nivel {} nivel)
                 (element :tipo {} tipo)
                 (element :preReq {} 
                    (for [i (range (count preReq))]
                        (element :req {} (nth preReq i))))
                 (let [i (count enunciado)] (criar-enunciado i tipo enunciado tipoenunciado))
                 (let [i (count alternativa)] (criar-alternativas i tipo alternativa tipoalt resposta)))]
       (with-open [out-file (java.io.FileWriter. nomearq)]
       (emit tags out-file)))
      (inserir-exercicio nomearq)))

   