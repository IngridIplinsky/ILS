(ns ils.Dominio.dominio
 (:use [ils.models connection]
       [ils.Dominio.factor-graph]
       [ils.Dominio.factor-graph.bayes]))  
  
;Modelo do domínio adaptado do artigo:
;Ambientes Inteligentes de Aprendizagem: Uma proposta baseada em hipermídia adaptativa e redes bayesianas. Nunes
(def dominio
	  (bayes-net
	    {
	        ;:conteudo [bom medio ruim]
	        :recursao [0.49 0.24 0.27]
                :alocacao-dinamica [0.25 0.17 0.58]
		:vetor [0.29 0.30 0.41]
		:matriz [0.33 0.33 0.34]
                :arvore 3
		:pilha 3
		:fila 3
		:lista 3
		:grafo 3
		:compressao-dados 3
	    }
	    {
	     [:lista :alocacao-dinamica :vetor :matriz] 
	       [0.0 	0.0 	1.0
		0.0 	0.0 	0.0 
		0.0 	0.0 	0.0 
		0.0 	0.5 	0.5
		1.0 	0.0 	0.0
		0.0 	0.0 	0.0 
		0.0 	0.0 	1.0
		0.5 	0.0 	0.5
		0.0 	0.0 	0.0 
		0.0 	0.0 	1.0
		0.3333 	0.3334 	0.3333
		0.0 	0.0 	0.0 
		0.2 	0.0 	0.8
		0.125 	0.375 	0.5
		0.3333 	0.3334 	0.3333
		0.0 	0.0 	1.0
		0.0 	0.0 	1.0
		0.0 	1.0 	0.0
		0.0 	0.0 	1.0
		0.17 	0.33 	0.5
		1.0 	0.0 	0.0
		0.0 	0.0 	1.0
		0.445 	0.445 	0.11
		0.625 	0.25 	0.125
		0.0 	0.0 	1.0
		0.19 	0.12 	0.69
		0.52 	0.4 	0.08] 

	     [:fila :lista] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 
 		
	     [:pilha :lista] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 
 	     
	     [:grafo :lista] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:arvore :grafo :recursao] 
	     [	0.0 	0.0 	1.0
		0.22 	0.33 	0.45
		1.0 	0.0 	0.0
		0.09 	0.09 	0.82
		0.315 	0.37 	0.315
		0.545 	0.23 	0.182
		0.0 	0.0 	1.0
		0.21 	0.11 	0.68
		0.5 	0.42 	0.08	]
     
	     [:compressao-dados :arvore] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 
     
 	}))

(def introducao
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.33 0.33 0.34]
		:ex6 [0.33 0.33 0.34]
		:ex7 [0.33 0.33 0.34]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})
	
(def vetor
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.33 0.33 0.34]
		:ex6 [0.33 0.33 0.34]
		:ex7 [0.33 0.33 0.34]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})
		
(def matriz
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.33 0.33 0.34]
		:ex6 [0.33 0.33 0.34]
		:ex7 [0.33 0.33 0.34]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})
		
(def registro
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.33 0.33 0.34]
		:ex6 [0.33 0.33 0.34]
		:ex7 [0.66 0.10 0.24]
		:ex8 [0.10 0.63 0.27]
		:ex9 [0.10 0.53 0.37]
		:ex10 [0.33 0.33 0.34]
	})

(def estruturas-dinamicas
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.33 0.33 0.34]
		:ex6 [0.33 0.33 0.34]
		:ex7 [0.33 0.33 0.34]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})
		
(def pilha
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.33 0.33 0.34]
		:ex6 [0.33 0.33 0.34]
		:ex7 [0.33 0.33 0.34]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})
		
(def fila
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.33 0.33 0.34]
		:ex6 [0.33 0.33 0.34]
		:ex7 [0.33 0.33 0.34]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})
		
(def compressao-dados
    {		:ex1 [0.33 0.33 0.34]
		:ex2 [0.33 0.33 0.34]
		:ex3 [0.33 0.33 0.34]
		:ex4 [0.33 0.33 0.34]
		:ex5 [0.03 0.33 0.64]
		:ex6 [0.13 0.53 0.34]
		:ex7 [0.20 0.43 0.37]
		:ex8 [0.33 0.33 0.34]
		:ex9 [0.33 0.33 0.34]
		:ex10 [0.33 0.33 0.34]
	})


;OPERACÕES sobre a rede no banco:
(defn map-function-on-map-vals 
	"Uma funcao map modificada para maps"
    [m f]
  (reduce (fn [altered-map [k v]] (assoc altered-map k (f v))) {} m))

(defn second-map 
	"Pega o segundo item de uma sequencia." 
    [ m ]
   (nth m 1))

(defn calc-prob-conteudo [alunoChave nome conteudo]
  "Dados a chave do aluno, o nome do conteudo, e dados os exercicios, calcula as probabilidades bom, médio e ruim para cada conteúdo e altera no banco."
  (atualizar-probs-conteudo 
    alunoChave nome 
      (/ (reduce + (vals (map-function-on-map-vals conteudo  first))) 10) ;a media de bom para todos os exercicios do conteudo
 (/ (reduce + (vals (map-function-on-map-vals conteudo  second-map))) 10) ;a media de médio para todos os exercicios do conteudo
      (/ (reduce + (vals (map-function-on-map-vals conteudo  last))) 10) ;a media de ruim para todos os exercicios do conteudo
))

