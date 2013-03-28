(ns estudante.conhecimento.conteudo
	(:use estudante.createbayes))

;Rede bayesiana para medir o conhecimento em um conteúdo.
;Baseado em uma tecnologia do Khan-academy.
;Disponivel em: http://derandomized.com/post/20009997725/bayes-net-example-with-python-and-khanacademy


;TODO ainda não foi testado. 
	

(defnode conteudo "conteudo" ["bom" "medio" "ruim"])
(defedge p1 [] [conteudo] [0.33 0.33 0.34])

(defnode ex1 "ex1" ["bom" "medio" "ruim"])
(defnode ex2 "ex2" ["bom" "medio" "ruim"])
(defnode ex3 "ex3" ["bom" "medio" "ruim"])
(defnode ex4 "ex4" ["bom" "medio" "ruim"])
(defnode ex5 "ex5" ["bom" "medio" "ruim"])
(defnode ex6 "ex6" ["bom" "medio" "ruim"])
(defnode ex7 "ex7" ["bom" "medio" "ruim"])
(defnode ex8 "ex8" ["bom" "medio" "ruim"])
(defnode ex9 "ex9" ["bom" "medio" "ruim"])
(defnode ex10 "ex10" ["bom" "medio" "ruim"])

(defedge  pex1 [conteudo] [ex1] [0.80  0.15 	0.05 
 								 0.50  0.30  	0.20 
  								 0.10  0.40  	0.50])

(defedge  pex2 [conteudo] [ex2] [0.80  0.15 	0.05 
 								 0.50  0.30  	0.20 
  								 0.10  0.40  	0.50])

(defedge  pex3 [conteudo] [ex3] [0.80  0.15 	0.05 
 								 0.50  0.30  	0.20 
  								 0.10  0.40  	0.50])

(defedge  pex4 [conteudo] [ex4] [0.80  0.15 	0.05 
 								 0.50  0.30  	0.20 
  								 0.10  0.40  	0.50])

(defedge  pex5 [conteudo] [ex5] [0.80  0.15 	0.05 
 								 0.50  0.30  	0.20 
  								 0.10  0.40  	0.50])


(defedge  pex6 [conteudo] [ex6] [0.80  0.15 	0.05 
 								 0.50  0.30  	0.20 
  								 0.10  0.40  	0.50])

(defedge  pex7 [conteudo] [ex7] [0.80  0.15 	0.05 
 								 0.50  0.30  	0.20 
  								 0.10  0.40  	0.50])

(defedge  pex8 [conteudo] [ex8] [0.80  0.15 	0.05 
 								 0.50  0.30  	0.20 
  								 0.10  0.40  	0.50])

(defedge  pex9 [conteudo] [ex9] [0.80  0.15 	0.05 
 								 0.50  0.30  	0.20 
  								 0.10  0.40  	0.50])

(defedge  pex10 [conteudo] [ex10] [0.80  0.15 	0.05 
 								 0.50  0.30  	0.20 
  								 0.10  0.40  	0.50])


(defbayes conteudo)
(setbayes conteudo "conteudo" [ex1 ex2 ex3 ex4 ex5 ex6 ex7 ex8 ex9 ex10] [pex1 pex2 pex3 pex4 pex5 pex6 pex7 pex8 pex9 pex10])



