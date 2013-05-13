(ns ils.models.estudante.conhecimento.gsi002
	(:use ils.models.estudante.createbayes))

;Rede bayesiana para medir o conhecimento de um aluno 
;de introdução à programação de computadores (gsi002)
;da faculdade de computação - sistemas de informação - UFU.

(defnode introducao "introducao" ["bom" "medio" "ruim"])
(defnode estruturasCond "estruturasCond" ["bom" "medio" "ruim"])
(defnode laco "laco" ["bom" "medio" "ruim"])
(defnode vetor "vetor" ["bom" "medio" "ruim"])
(defnode introducao "introducao" ["bom" "medio" "ruim"])
(defnode funcao "funcao" ["bom" "medio" "ruim"])
(defnode recursao "recursao" ["bom" "medio" "ruim"])
(defnode alocDin "alocDin" ["bom" "medio" "ruim"])
(defnode strings "strings" ["bom" "medio" "ruim"])
(defnode estruturas "estruturas" ["bom" "medio" "ruim"])
(defnode arquivo "arquivo" ["bom" "medio" "ruim"])


(defedge p1 [] [introducao] [0.33 0.34 0.33])
(defedge p2 [introducao] [estruturasCond] [0.80 	0.15 	0.05 
		  								   0.50  	0.30  	0.20 
		  								   0.10  	0.40  	0.50])

(defedge p3 [introducao] [laco] [0.80 	0.15 	0.05 
		  						 0.50  	0.30  	0.20 
		  						 0.10  	0.40  	0.50])

(defedge p4 [introducao] [vetor] [0.80 	0.15 	0.05 
		  						  0.50  0.30  	0.20 
		  						  0.10  0.40  	0.50])

(defedge p5 [laco estruturasCond] [funcao] [ 0.85 	0.10 	0.05 
											 0.75 	0.15 	0.10 
											 0.65 	0.20 	0.15 
											 0.75 	0.15 	0.10 
											 0.35 	0.50 	0.15 
											 0.15 	0.45 	0.40
											 0.65 	0.20 	0.15 
											 0.15 	0.45 	0.40 
											 0.05 	0.15 	0.80])

(defedge p6 [funcao] [recursao] [0.85  0.10 	0.05 
		  						 0.40  0.40  	0.20 
		  						 0.10  0.40  	0.50])


(defedge p7 [vetor] [alocDin] [0.85  0.10 	0.05 
		  					   0.40  0.40  	0.20 
		  					   0.10  0.40  	0.50])

(defedge p8 [alocDin] [strings] [0.80 	0.15 	0.05 
		  						 0.50  	0.30  	0.20 
		  						 0.10  	0.40  	0.50])

(defedge p9 [strings] [arquivo] [0.80 	0.15 	0.05 
		  						 0.50  	0.30  	0.20 
		  						 0.10  	0.40  	0.50])

(defedge p10 [alocDin vetor] [estruturas] [ 0.80 	0.15 	0.05 
											0.75 	0.15 	0.10 
											0.65 	0.20 	0.15 
											0.75 	0.15 	0.10 
											0.35 	0.50 	0.15 
											0.15 	0.45 	0.40
											0.65 	0.20 	0.15 
											0.15 	0.45 	0.40 
											0.05 	0.15 	0.80])

(defbayes gsi002)

(setbayes gsi002 "gsi002" [introducao estruturasCond laco vetor funcao recursao alocDin estruturas strings arquivo] 
						  [p1 p2 p3 p4 p5 p6 p7 p8 p9 p10])




