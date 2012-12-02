(ns ils.models.estudante.corygil.estudante
  (:use
      [ils.models.estudante.corygil.factor-graph]
      [ils.models.estudante.corygil.factor-graph.bayes]
      [ils.models.dominio.BD.atualizacao]
      [ils.models.dominio.BD.busca]
      ))

;Árvore de junção do modelo do domínio do artigo:
;Ambientes Inteligentes de Aprendizagem: Uma proposta baseada em hipermídia adaptativa e redes bayesianas. Nunes
;Esta árvore de junção tem fins de propagação, sendo uma ferramenta auxiliar na propagação através de distribuição marginal, sendo feita.
(def dominio
	  (bayes-net
	    {
	        :ABE [0.33 0.33 0.34]
		:DBE 3
		:BAD 3
		:BDC 3
		:EAD 3
		:BDF 3
		:BHF 3
		:CBF 3
		:CDF 3
		:FDH 3
		:FJH 3
		:HJD 3
		:HIJ 3
		:HDI 3
		:IJD 3
		:IJG 3
		:IEG 3
		:GJE [0.33 0.33 0.34]
		:EHI 3
		:EDH 3
		:EDI 3
	    }
	    {
	     

	     [:DBE :ABE] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 
 	
	     [:BAD :DBE] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:BDC :BAD] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 
		
	     [:EAD :BDC] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:BDF :EAD] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

 	     [:BHF :BDF] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:CBF :BHF] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:CDF :CBF] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:FDH :CDF] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:FJH :FDH] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:HJD :FJH] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:HIJ :HJD] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

		
	     [:HDI :HIJ] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:IJD :HDI] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:IJG :IJD] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03]  


	     [:IEG :IJG :GJE] 
	     [	1.0 	0.0 	0.0
		0.45 	0.33 	0.22
		0.0 	0.0 	1.0
		0.82 	0.09 	0.09
		0.315 	0.37 	0.315
		0.182 	0.23 	0.545
		1.0 	0.0 	0.0
		0.68 	0.11 	0.21
		0.08 	0.42 	0.5]

	     [:EHI :IEG] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

	     [:EDH :EHI] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

     	     [:EDI :EDH] 
	     [0.07 	0.16 	0.77 
	      0.46  	0.41  	0.13 
	      0.84  	0.13  	0.03] 

 	}))


(def tanara {
	:estrutura-dados [0.33 0.33 0.34]
	:alocDin [0.33 0.33 0.34]
	:vetor [0.33 0.33 0.34]
	:recursiv [0.33 0.33 0.34]
	:lista [0.33 0.33 0.34]
	:arvore [0.33 0.33 0.34]
        :fila [0.33 0.33 0.34]
     	:pilha [0.33 0.33 0.34]
	:metOrd [0.33 0.33 0.34]
	:metPesq [0.33 0.33 0.34]
})

		
(def estrutura-dados
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


(def alocDin
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

(def vetor
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

(def recursiv
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

(def lista
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

(def arvore
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

(def fila
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

(def pilha
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


(def metOrd
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

(def metPesq
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


(defn map-function-on-map-vals 
	"Uma funcao map modificada para maps"
    [m f]
  (reduce (fn [altered-map [k v]] (assoc altered-map k (f v))) {} m))

(defn second-map 
	"Pega o segundo item de uma sequencia." 
    [ m ]
   (nth m 1))

(defn calc-prob-conteudo [matricula conteudo]
  "Dados a chave do aluno, o nome do conteudo, e dados os exercicios, calcula as probabilidades bom, médio e ruim para cada conteúdo e altera no banco."
  (atualizar-conteudoAluno 
    matricula conteudo 
      (/ (reduce + (vals (map-function-on-map-vals conteudo  first))) 10) ;a media de bom para todos os exercicios do conteudo
 (/ (reduce + (vals (map-function-on-map-vals conteudo  second-map))) 10) ;a media de médio para todos os exercicios do conteudo
      (/ (reduce + (vals (map-function-on-map-vals conteudo  last))) 10) ;a media de ruim para todos os exercicios do conteudo
))


;Nas próximas 600 linhas, a nova funcao de progagação! :D
(defn propagar-persistente
"Uma funcao capaz de propagar e salvar no banco de dados do aluno. Esta funcao utiliza marginalização de uma arvore de juncao,
 que é usada como uma 'máscara' de progragação."
 ([chave]
       	(def tanara 
                   (assoc tanara :alocDin [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))5))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))9))0)
						(nth (vec (nth (vals (run-propagation dominio))12))0)
                                                                                         )3)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))5))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))9))1)
						(nth (vec (nth (vals (run-propagation dominio))12))1)
                                                                                         )3)
 					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))5))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))9))2)
						(nth (vec (nth (vals (run-propagation dominio))12))2)
                                                                                         )3)]
		      :vetor [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))2))0)
						(nth (vec (nth (vals (run-propagation dominio))7))0)
						(nth (vec (nth (vals (run-propagation dominio))8))0)
						(nth (vec (nth (vals (run-propagation dominio))9))0)
						(nth (vec (nth (vals (run-propagation dominio))12))0)
						(nth (vec (nth (vals (run-propagation dominio))16))0)
                                                                                         )7)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))2))1)
						(nth (vec (nth (vals (run-propagation dominio))7))1)
						(nth (vec (nth (vals (run-propagation dominio))8))1)
						(nth (vec (nth (vals (run-propagation dominio))9))1)
						(nth (vec (nth (vals (run-propagation dominio))12))1)
						(nth (vec (nth (vals (run-propagation dominio))16))1)
                                                                                         )7)
 					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))2))2)
						(nth (vec (nth (vals (run-propagation dominio))7))2)
						(nth (vec (nth (vals (run-propagation dominio))8))2)
						(nth (vec (nth (vals (run-propagation dominio))9))2)
						(nth (vec (nth (vals (run-propagation dominio))12))2)
						(nth (vec (nth (vals (run-propagation dominio))16))2)
                                                                                         )7)]

			:recursiv [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))7))0)
						(nth (vec (nth (vals (run-propagation dominio))18))0)
                                                                                         )3)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))7))1)
						(nth (vec (nth (vals (run-propagation dominio))18))1)
                                                                                         )3)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))7))2)
						(nth (vec (nth (vals (run-propagation dominio))18))2)
                                                                                         )3)]

			:arvore [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))3))0)
						(nth (vec (nth (vals (run-propagation dominio))5))0)
						(nth (vec (nth (vals (run-propagation dominio))8))0)
						(nth (vec (nth (vals (run-propagation dominio))10))0)
						(nth (vec (nth (vals (run-propagation dominio))11))0)
						(nth (vec (nth (vals (run-propagation dominio))12))0)
						(nth (vec (nth (vals (run-propagation dominio))14))0)
						(nth (vec (nth (vals (run-propagation dominio))16))0)
						(nth (vec (nth (vals (run-propagation dominio))18))0)
						(nth (vec (nth (vals (run-propagation dominio))19))0)
						(nth (vec (nth (vals (run-propagation dominio))20))0)
                                                                                         )12)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))3))1)
						(nth (vec (nth (vals (run-propagation dominio))5))1)
						(nth (vec (nth (vals (run-propagation dominio))8))1)
						(nth (vec (nth (vals (run-propagation dominio))10))1)
						(nth (vec (nth (vals (run-propagation dominio))11))1)
						(nth (vec (nth (vals (run-propagation dominio))12))1)
						(nth (vec (nth (vals (run-propagation dominio))14))1)
						(nth (vec (nth (vals (run-propagation dominio))16))1)
						(nth (vec (nth (vals (run-propagation dominio))18))1)
						(nth (vec (nth (vals (run-propagation dominio))19))1)
						(nth (vec (nth (vals (run-propagation dominio))20))1)
                                                                                         )12)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))0))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))3))2)
						(nth (vec (nth (vals (run-propagation dominio))5))2)
						(nth (vec (nth (vals (run-propagation dominio))8))2)
						(nth (vec (nth (vals (run-propagation dominio))10))2)
						(nth (vec (nth (vals (run-propagation dominio))11))2)
						(nth (vec (nth (vals (run-propagation dominio))12))2)
						(nth (vec (nth (vals (run-propagation dominio))14))2)
						(nth (vec (nth (vals (run-propagation dominio))16))2)
						(nth (vec (nth (vals (run-propagation dominio))18))2)
						(nth (vec (nth (vals (run-propagation dominio))19))2)
						(nth (vec (nth (vals (run-propagation dominio))20))2)
                                                                                         )12)]

			:lista [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))0)
						(nth (vec (nth (vals (run-propagation dominio))5))0)
						(nth (vec (nth (vals (run-propagation dominio))9))0)
						(nth (vec (nth (vals (run-propagation dominio))10))0)
						(nth (vec (nth (vals (run-propagation dominio))11))0)
						(nth (vec (nth (vals (run-propagation dominio))15))0)
						(nth (vec (nth (vals (run-propagation dominio))16))0)
                                                                                         )8)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))1)
						(nth (vec (nth (vals (run-propagation dominio))5))1)
						(nth (vec (nth (vals (run-propagation dominio))9))1)
						(nth (vec (nth (vals (run-propagation dominio))10))1)
						(nth (vec (nth (vals (run-propagation dominio))11))1)
						(nth (vec (nth (vals (run-propagation dominio))15))1)
						(nth (vec (nth (vals (run-propagation dominio))16))1)
                                                                                         )8)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))2)
						(nth (vec (nth (vals (run-propagation dominio))5))2)
						(nth (vec (nth (vals (run-propagation dominio))9))2)
						(nth (vec (nth (vals (run-propagation dominio))10))2)
						(nth (vec (nth (vals (run-propagation dominio))11))2)
						(nth (vec (nth (vals (run-propagation dominio))15))2)
						(nth (vec (nth (vals (run-propagation dominio))16))2)
                                                                                         )8)]

			:metOrd [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))2))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))7))0)
						(nth (vec (nth (vals (run-propagation dominio))8))0)
						(nth (vec (nth (vals (run-propagation dominio))17))0)
						(nth (vec (nth (vals (run-propagation dominio))18))0)
						(nth (vec (nth (vals (run-propagation dominio))19))0)
                                                                                         )6)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))2))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))7))1)
						(nth (vec (nth (vals (run-propagation dominio))8))1)
						(nth (vec (nth (vals (run-propagation dominio))17))1)
						(nth (vec (nth (vals (run-propagation dominio))18))1)
						(nth (vec (nth (vals (run-propagation dominio))19))1)
                                                                                         )6)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))2))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))7))2)
						(nth (vec (nth (vals (run-propagation dominio))8))2)
						(nth (vec (nth (vals (run-propagation dominio))17))2)
						(nth (vec (nth (vals (run-propagation dominio))18))2)
						(nth (vec (nth (vals (run-propagation dominio))19))2)
                                                                                         )6)]

			:fila [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))0)
						(nth (vec (nth (vals (run-propagation dominio))6))0)
                                                                                         )3)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))1)
						(nth (vec (nth (vals (run-propagation dominio))6))1)
                                                                                         )3)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))2)
						(nth (vec (nth (vals (run-propagation dominio))6))2)
                                                                                         )3)]

			:metPesq [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))2))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))11))0)
						(nth (vec (nth (vals (run-propagation dominio))13))0)
						(nth (vec (nth (vals (run-propagation dominio))14))0)
						(nth (vec (nth (vals (run-propagation dominio))15))0)
						(nth (vec (nth (vals (run-propagation dominio))17))0)
						(nth (vec (nth (vals (run-propagation dominio))19))0)
						(nth (vec (nth (vals (run-propagation dominio))20))0)
                                                                                         )8)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))2))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))11))1)
						(nth (vec (nth (vals (run-propagation dominio))13))1)
						(nth (vec (nth (vals (run-propagation dominio))14))1)
						(nth (vec (nth (vals (run-propagation dominio))15))1)
						(nth (vec (nth (vals (run-propagation dominio))17))1)
						(nth (vec (nth (vals (run-propagation dominio))19))1)
						(nth (vec (nth (vals (run-propagation dominio))20))1)
                                                                                         )8)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))2))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))11))2)
						(nth (vec (nth (vals (run-propagation dominio))13))2)
						(nth (vec (nth (vals (run-propagation dominio))14))2)
						(nth (vec (nth (vals (run-propagation dominio))15))2)
						(nth (vec (nth (vals (run-propagation dominio))17))2)
						(nth (vec (nth (vals (run-propagation dominio))19))2)
						(nth (vec (nth (vals (run-propagation dominio))20))2)
                                                                                         )8)]

			:pilha [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))3))0)
						(nth (vec (nth (vals (run-propagation dominio))6))0)
						(nth (vec (nth (vals (run-propagation dominio))10))0)
						(nth (vec (nth (vals (run-propagation dominio))13))0)
						(nth (vec (nth (vals (run-propagation dominio))15))0)
						(nth (vec (nth (vals (run-propagation dominio))20))0)
                                                                                         )7)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))3))1)
						(nth (vec (nth (vals (run-propagation dominio))6))1)
						(nth (vec (nth (vals (run-propagation dominio))10))1)
						(nth (vec (nth (vals (run-propagation dominio))13))1)
						(nth (vec (nth (vals (run-propagation dominio))15))1)
						(nth (vec (nth (vals (run-propagation dominio))20))1)
                                                                                         )7)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))1))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))3))2)
						(nth (vec (nth (vals (run-propagation dominio))6))2)
						(nth (vec (nth (vals (run-propagation dominio))10))2)
						(nth (vec (nth (vals (run-propagation dominio))13))2)
						(nth (vec (nth (vals (run-propagation dominio))15))2)
						(nth (vec (nth (vals (run-propagation dominio))20))2)
                                                                                         )7)]

			
			:estrutura-dados [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))3))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))0)
						(nth (vec (nth (vals (run-propagation dominio))6))0)
						(nth (vec (nth (vals (run-propagation dominio))13))0)
						(nth (vec (nth (vals (run-propagation dominio))14))0)
						(nth (vec (nth (vals (run-propagation dominio))17))0)
                                                                                         )6)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))3))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))1)
						(nth (vec (nth (vals (run-propagation dominio))6))1)
						(nth (vec (nth (vals (run-propagation dominio))13))1)
						(nth (vec (nth (vals (run-propagation dominio))14))1)
						(nth (vec (nth (vals (run-propagation dominio))17))1)
                                                                                         )6)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio))3))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio))4))2)
						(nth (vec (nth (vals (run-propagation dominio))6))2)
						(nth (vec (nth (vals (run-propagation dominio))13))2)
						(nth (vec (nth (vals (run-propagation dominio))14))2)
						(nth (vec (nth (vals (run-propagation dominio))17))2)
                                                                                         )6)]
	))      
     (atualizar-conteudoAluno chave "estrutura-dados" 	(nth (vec (nth (vals tanara)0))0)  
							(nth (vec (nth (vals tanara)0))1)
							(nth (vec (nth (vals tanara)0))2))
     (atualizar-conteudoAluno chave "arvore" 		(nth (vec (nth (vals tanara)1))0)  
							(nth (vec (nth (vals tanara)1))1)
							(nth (vec (nth (vals tanara)1))2))
     (atualizar-conteudoAluno chave "recursiv" 	(nth (vec (nth (vals tanara)2))0)  
							(nth (vec (nth (vals tanara)2))1)
							(nth (vec (nth (vals tanara)2))2))
     (atualizar-conteudoAluno chave "fila" 		(nth (vec (nth (vals tanara)3))0)  
							(nth (vec (nth (vals tanara)3))1)
							(nth (vec (nth (vals tanara)3))2))
     (atualizar-conteudoAluno chave "metPesq" 		(nth (vec (nth (vals tanara)4))0)  
							(nth (vec (nth (vals tanara)4))1)
							(nth (vec (nth (vals tanara)4))2))
     (atualizar-conteudoAluno chave "metOrd" 		(nth (vec (nth (vals tanara)5))0)  
							(nth (vec (nth (vals tanara)5))1)
							(nth (vec (nth (vals tanara)5))2))
     (atualizar-conteudoAluno chave "lista" 		(nth (vec (nth (vals tanara)6))0)  
							(nth (vec (nth (vals tanara)6))1)
							(nth (vec (nth (vals tanara)6))2))
     (atualizar-conteudoAluno chave "pilha" 		(nth (vec (nth (vals tanara)7))0)  
							(nth (vec (nth (vals tanara)7))1)
							(nth (vec (nth (vals tanara)7))2))
     (atualizar-conteudoAluno chave "alocDin" 		(nth (vec (nth (vals tanara)8))0)  
							(nth (vec (nth (vals tanara)8))1)
							(nth (vec (nth (vals tanara)8))2))
     (atualizar-conteudoAluno chave "vetor" 		(nth (vec (nth (vals tanara)9))0)  
							(nth (vec (nth (vals tanara)9))1)
							(nth (vec (nth (vals tanara)9))2))
	
  )
  ([chave evidencias]
          (def tanara          
		   (assoc tanara :alocDin [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))5))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))9))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))0)
                                                                                         )3)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))5))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))9))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))1)
                                                                                         )3)
 					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))5))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))9))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))2)
                                                                                         )3)]
		      :vetor [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))7))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))9))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))0)
                                                                                         )7)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))7))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))9))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))1)
                                                                                         )7)
 					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))7))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))9))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))2)
                                                                                         )7)]

			:recursiv [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))7))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))0)
                                                                                         )3)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))7))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))1)
                                                                                         )3)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))7))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))2)
                                                                                         )3)]

			:arvore [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))5))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))11))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))0)
                                                                                         )12)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))5))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))11))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))1)
                                                                                         )12)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))0))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))5))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))11))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))12))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))2)
                                                                                         )12)]

			:lista [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))5))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))9))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))11))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))0)
                                                                                         )8)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))5))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))9))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))11))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))1)
                                                                                         )8)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))5))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))9))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))11))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))16))2)
                                                                                         )8)]

			:metOrd [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))7))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))0)
                                                                                         )6)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))7))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))1)
                                                                                         )6)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))7))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))8))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))18))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))2)
                                                                                         )6)]

			:fila [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))0)
                                                                                         )3)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))1)
                                                                                         )3)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))2)
                                                                                         )3)]

			:metPesq [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))11))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))0)
                                                                                         )8)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))11))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))1)
                                                                                         )8)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))2))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))11))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))19))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))2)
                                                                                         )8)]

			:pilha [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))0)
                                                                                         )7)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))1)
                                                                                         )7)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))1))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))10))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))15))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))20))2)
                                                                                         )7)]

			
			:estrutura-dados [(/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))0) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))0)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))0)
                                                                                         )6)
					    (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))1) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))1)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))1)
                                                                                         )6)
					  
					     (/ (+
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))3))2) 
                                            	(nth (vec (nth (vals (run-propagation dominio evidencias))4))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))6))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))13))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))14))2)
						(nth (vec (nth (vals (run-propagation dominio evidencias))17))2)
                                                                                         )6)]
	))
     (atualizar-conteudoAluno chave "estrutura-dados" 	(nth (vec (nth (vals tanara)0))0)  
							(nth (vec (nth (vals tanara)0))1)
							(nth (vec (nth (vals tanara)0))2))
     (atualizar-conteudoAluno chave "arvore" 		(nth (vec (nth (vals tanara)1))0)  
							(nth (vec (nth (vals tanara)1))1)
							(nth (vec (nth (vals tanara)1))2))
     (atualizar-conteudoAluno chave "recursiv" 	(nth (vec (nth (vals tanara)2))0)  
							(nth (vec (nth (vals tanara)2))1)
							(nth (vec (nth (vals tanara)2))2))
     (atualizar-conteudoAluno chave "fila" 		(nth (vec (nth (vals tanara)3))0)  
							(nth (vec (nth (vals tanara)3))1)
							(nth (vec (nth (vals tanara)3))2))
     (atualizar-conteudoAluno chave "metPesq" 		(nth (vec (nth (vals tanara)4))0)  
							(nth (vec (nth (vals tanara)4))1)
							(nth (vec (nth (vals tanara)4))2))
     (atualizar-conteudoAluno chave "metOrd" 		(nth (vec (nth (vals tanara)5))0)  
							(nth (vec (nth (vals tanara)5))1)
							(nth (vec (nth (vals tanara)5))2))
     (atualizar-conteudoAluno chave "lista" 		(nth (vec (nth (vals tanara)6))0)  
							(nth (vec (nth (vals tanara)6))1)
							(nth (vec (nth (vals tanara)6))2))
     (atualizar-conteudoAluno chave "pilha" 		(nth (vec (nth (vals tanara)7))0)  
							(nth (vec (nth (vals tanara)7))1)
							(nth (vec (nth (vals tanara)7))2))
     (atualizar-conteudoAluno chave "alocDin" 		(nth (vec (nth (vals tanara)8))0)  
							(nth (vec (nth (vals tanara)8))1)
							(nth (vec (nth (vals tanara)8))2))
     (atualizar-conteudoAluno chave "vetor" 		(nth (vec (nth (vals tanara)9))0)  
							(nth (vec (nth (vals tanara)9))1)
							(nth (vec (nth (vals tanara)9))2))
  )
)

;ATENCAO! esta funcao nao atualiza no banco. Use as duas quando mudar de exercicio! (esta é util para mudar os valores da estrutura,
;utilizada para calcular o conhecimento geral do estudante. Para alterar no banco, use: atualizar-probs-exercicio  (linha 502)
(defn atualizar-exercicio 
"Atualiza as probabilidades de um exercicio de algum conteudo (nao use aspas!). Ex: (atualizar-exercicio estrutura-dados :ex1 1.0 0.0 0.0)"
[conteudo exercicio bom medio ruim]
        (cond 	   
	   (= conteudo estrutura-dados) (def estrutura-dados
                               (assoc conteudo exercicio [bom medio ruim]))
	   (= conteudo alocDin) (def alocDin
                               (assoc conteudo exercicio [bom medio ruim]))
	   (= conteudo vetor) (def vetor
                               (assoc conteudo exercicio [bom medio ruim]))
           (= conteudo recursiv) (def recursiv
                               (assoc conteudo exercicio [bom medio ruim]))
           (= conteudo lista) (def lista
                               (assoc conteudo exercicio [bom medio ruim]))
           (= conteudo arvore) (def arvore
                               (assoc conteudo exercicio [bom medio ruim]))
           (= conteudo fila) (def fila
                               (assoc conteudo exercicio [bom medio ruim]))
           (= conteudo pilha) (def pilha
                               (assoc conteudo exercicio [bom medio ruim]))
           (= conteudo metOrd) (def metOrd
                               (assoc conteudo exercicio [bom medio ruim]))
	   (= conteudo metPesq) (def metPesq
                               (assoc conteudo exercicio [bom medio ruim]))
         :else "Este conteudo nao eh valido!")
)

(defn carregar-exercicios 
"Carrega os exercicios de um conteudo de um aluno do banco na estrutura."
	[chave conteudo]
   (cond 	   
	   (= conteudo "EstruturasDados") (def estrutura-dados
                                        (assoc estrutura-dados 
                        :ex1 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "EstruturasDados") 0))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "EstruturasDados") 0))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "EstruturasDados") 0))3)]
                        :ex2 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "EstruturasDados") 2))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "EstruturasDados") 2))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "EstruturasDados") 2))3)]
						:ex3 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "EstruturasDados") 3))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "EstruturasDados") 3))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "EstruturasDados") 3))3)]
						:ex4 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "EstruturasDados") 4))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "EstruturasDados") 4))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "EstruturasDados") 4))3)]
						:ex5 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "EstruturasDados") 5))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "EstruturasDados") 5))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "EstruturasDados") 5))3)]
						:ex6 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "EstruturasDados") 6))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "EstruturasDados") 6))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "EstruturasDados")6))3)]
						:ex7 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "EstruturasDados") 7))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "EstruturasDados") 7))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "EstruturasDados") 7))3)]
						:ex8 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "EstruturasDados") 8))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "EstruturasDados") 8))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "EstruturasDados") 8))3)]
						:ex9 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "EstruturasDados") 9))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "EstruturasDados") 9))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "EstruturasDados") 9))3)]
						:ex10 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "EstruturasDados") 1))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "EstruturasDados") 1))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "EstruturasDados") 1))3)] ))
	   (= conteudo "alocDin") (def alocDin
                                (assoc alocDin 
                        :ex1 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "alocDin") 0))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "alocDin") 0))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "alocDin") 0))3)]
                        :ex2 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "alocDin") 2))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "alocDin") 2))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "alocDin") 2))3)]
						:ex3 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "alocDin") 3))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "alocDin") 3))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "alocDin") 3))3)]
						:ex4 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "alocDin") 4))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "alocDin") 4))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "alocDin") 4))3)]
						:ex5 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "alocDin") 5))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "alocDin") 5))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "alocDin") 5))3)]
						:ex6 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "alocDin") 6))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "alocDin") 6))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "alocDin")6))3)]
						:ex7 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "alocDin") 7))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "alocDin") 7))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "alocDin") 7))3)]
						:ex8 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "alocDin") 8))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "alocDin") 8))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "alocDin") 8))3)]
						:ex9 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "alocDin") 9))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "alocDin") 9))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "alocDin") 9))3)]
						:ex10 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "alocDin") 1))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "alocDin") 1))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "alocDin") 1))3)] ))
	   (= conteudo "vetor") (def vetor
                               (assoc vetor 
                        :ex1 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "vetor") 0))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "vetor") 0))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "vetor") 0))3)]
                        :ex2 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "vetor") 2))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "vetor") 2))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "vetor") 2))3)]
						:ex3 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "vetor") 3))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "vetor") 3))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "vetor") 3))3)]
						:ex4 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "vetor") 4))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "vetor") 4))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "vetor") 4))3)]
						:ex5 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "vetor") 5))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "vetor") 5))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "vetor") 5))3)]
						:ex6 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "vetor") 6))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "vetor") 6))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "vetor")6))3)]
						:ex7 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "vetor") 7))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "vetor") 7))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "vetor") 7))3)]
						:ex8 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "vetor") 8))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "vetor") 8))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "vetor") 8))3)]
						:ex9 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "vetor") 9))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "vetor") 9))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "vetor") 9))3)]
						:ex10 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "vetor") 1))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "vetor") 1))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "vetor") 1))3)] ))
           (= conteudo "recursiv") (def recursiv
                                 (assoc recursiv 
                        :ex1 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "recursiv") 0))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "recursiv") 0))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "recursiv") 0))3)]
                        :ex2 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "recursiv") 2))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "recursiv") 2))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "recursiv") 2))3)]
						:ex3 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "recursiv") 3))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "recursiv") 3))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "recursiv") 3))3)]
						:ex4 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "recursiv") 4))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "recursiv") 4))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "recursiv") 4))3)]
						:ex5 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "recursiv") 5))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "recursiv") 5))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "recursiv") 5))3)]
						:ex6 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "recursiv") 6))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "recursiv") 6))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "recursiv")6))3)]
						:ex7 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "recursiv") 7))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "recursiv") 7))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "recursiv") 7))3)]
						:ex8 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "recursiv") 8))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "recursiv") 8))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "recursiv") 8))3)]
						:ex9 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "recursiv") 9))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "recursiv") 9))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "recursiv") 9))3)]
						:ex10 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "recursiv") 1))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "recursiv") 1))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "recursiv") 1))3)] ))
           (= conteudo "lista") (def lista
                               (assoc lista 
                        :ex1 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "lista") 0))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "lista") 0))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "lista") 0))3)]
                        :ex2 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "lista") 2))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "lista") 2))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "lista") 2))3)]
						:ex3 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "lista") 3))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "lista") 3))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "lista") 3))3)]
						:ex4 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "lista") 4))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "lista") 4))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "lista") 4))3)]
						:ex5 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "lista") 5))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "lista") 5))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "lista") 5))3)]
						:ex6 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "lista") 6))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "lista") 6))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "lista")6))3)]
						:ex7 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "lista") 7))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "lista") 7))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "lista") 7))3)]
						:ex8 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "lista") 8))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "lista") 8))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "lista") 8))3)]
						:ex9 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "lista") 9))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "lista") 9))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "lista") 9))3)]
						:ex10 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "lista") 1))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "lista") 1))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "lista") 1))3)] ))
           (= conteudo "arvore") (def arvore
                               (assoc arvore 
                        :ex1 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "arvore") 0))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "arvore") 0))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "arvore") 0))3)]
                        :ex2 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "arvore") 2))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "arvore") 2))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "arvore") 2))3)]
						:ex3 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "arvore") 3))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "arvore") 3))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "arvore") 3))3)]
						:ex4 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "arvore") 4))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "arvore") 4))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "arvore") 4))3)]
						:ex5 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "arvore") 5))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "arvore") 5))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "arvore") 5))3)]
						:ex6 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "arvore") 6))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "arvore") 6))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "arvore")6))3)]
						:ex7 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "arvore") 7))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "arvore") 7))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "arvore") 7))3)]
						:ex8 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "arvore") 8))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "arvore") 8))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "arvore") 8))3)]
						:ex9 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "arvore") 9))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "arvore") 9))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "arvore") 9))3)]
						:ex10 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "arvore") 1))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "arvore") 1))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "arvore") 1))3)] ))
           (= conteudo "fila") (def fila
                             (assoc fila 
                        :ex1 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "fila") 0))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "fila") 0))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "fila") 0))3)]
                        :ex2 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "fila") 2))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "fila") 2))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "fila") 2))3)]
						:ex3 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "fila") 3))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "fila") 3))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "fila") 3))3)]
						:ex4 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "fila") 4))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "fila") 4))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "fila") 4))3)]
						:ex5 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "fila") 5))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "fila") 5))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "fila") 5))3)]
						:ex6 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "fila") 6))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "fila") 6))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "fila")6))3)]
						:ex7 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "fila") 7))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "fila") 7))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "fila") 7))3)]
						:ex8 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "fila") 8))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "fila") 8))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "fila") 8))3)]
						:ex9 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "fila") 9))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "fila") 9))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "fila") 9))3)]
						:ex10 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "fila") 1))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "fila") 1))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "fila") 1))3)] ))
           (= conteudo "pilha") (def pilha
                               (assoc pilha 
                        :ex1 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "pilha") 0))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "pilha") 0))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "pilha") 0))3)]
                        :ex2 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "pilha") 2))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "pilha") 2))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "pilha") 2))3)]
						:ex3 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "pilha") 3))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "pilha") 3))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "pilha") 3))3)]
						:ex4 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "pilha") 4))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "pilha") 4))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "pilha") 4))3)]
						:ex5 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "pilha") 5))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "pilha") 5))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "pilha") 5))3)]
						:ex6 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "pilha") 6))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "pilha") 6))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "pilha")6))3)]
						:ex7 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "pilha") 7))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "pilha") 7))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "pilha") 7))3)]
						:ex8 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "pilha") 8))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "pilha") 8))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "pilha") 8))3)]
						:ex9 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "pilha") 9))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "pilha") 9))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "pilha") 9))3)]
						:ex10 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "pilha") 1))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "pilha") 1))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "pilha") 1))3)] ))
           (= conteudo "metOrd") (def metOrd
                               (assoc metOrd 
                        :ex1 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metOrd") 0))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metOrd") 0))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metOrd") 0))3)]
                        :ex2 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metOrd") 2))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metOrd") 2))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metOrd") 2))3)]
						:ex3 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metOrd") 3))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metOrd") 3))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metOrd") 3))3)]
						:ex4 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metOrd") 4))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metOrd") 4))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metOrd") 4))3)]
						:ex5 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metOrd") 5))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metOrd") 5))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metOrd") 5))3)]
						:ex6 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metOrd") 6))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metOrd") 6))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metOrd")6))3)]
						:ex7 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metOrd") 7))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metOrd") 7))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metOrd") 7))3)]
						:ex8 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metOrd") 8))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metOrd") 8))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metOrd") 8))3)]
						:ex9 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metOrd") 9))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metOrd") 9))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metOrd") 9))3)]
						:ex10 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metOrd") 1))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metOrd") 1))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metOrd") 1))3)] ))
	   (= conteudo "metPesq") (def metPesq
                               (assoc metPesq 
                       :ex1 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metPesq") 0))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metPesq") 0))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metPesq") 0))3)]
                        :ex2 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metPesq") 2))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metPesq") 2))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metPesq") 2))3)]
						:ex3 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metPesq") 3))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metPesq") 3))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metPesq") 3))3)]
						:ex4 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metPesq") 4))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metPesq") 4))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metPesq") 4))3)]
						:ex5 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metPesq") 5))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metPesq") 5))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metPesq") 5))3)]
						:ex6 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metPesq") 6))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metPesq") 6))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metPesq")6))3)]
						:ex7 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metPesq") 7))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metPesq") 7))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metPesq") 7))3)]
						:ex8 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metPesq") 8))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metPesq") 8))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metPesq") 8))3)]
						:ex9 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metPesq") 9))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metPesq") 9))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metPesq") 9))3)]
						:ex10 [(nth (vals (nth (buscar-conteudoAluno "bom" "matricula" chave "conteudo" "metPesq") 1))1)
 						      (nth (vals (nth (buscar-conteudoAluno "medio" "matricula" chave "conteudo" "metPesq") 1))2)
						      (nth (vals (nth (buscar-conteudoAluno "ruim" "matricula" chave "conteudo" "metPesq") 1))3)] ))
         :else "Este conteudo nao eh valido!")

)

(defn evidencias [conteudo bom medio ruim]
"Funcao que insere de forma automatizada as evidencias da arvore de propagacao"
      (cond 	   
	   (= conteudo "estrutura-dados") {:FJH [bom medio ruim] :HJD [bom medio ruim] :HIJ [bom medio ruim] :IJD [bom medio ruim] :IJG [bom medio ruim] :GJE [bom medio ruim]} 
                                         
	   (= conteudo "alocDin") {:ABE [bom medio ruim] :BAD [bom medio ruim] :EAD [bom medio ruim] } 

	   (= conteudo "vetor") {:ABE [bom medio ruim] :DBE [bom medio ruim] :BAD[bom medio ruim] :BDC[bom medio ruim] :BDF [bom medio ruim] :BHF [bom medio ruim] :CBF [bom medio ruim] }
           
	   (= conteudo "recursiv") {:BDC [bom medio ruim] :CBF [bom medio ruim] :CDF [bom medio ruim] }
           
	   (= conteudo "lista") {:ABE [bom medio ruim] :DBE [bom medio ruim] :EAD [bom medio ruim] :GJE [bom medio ruim] :IEG [bom medio ruim] :EHI [bom medio ruim] :EDH [bom medio ruim] :EDI [bom medio ruim]}

           (= conteudo "arvore") {:DBE [bom medio ruim] :BAD [bom medio ruim] :BDC [bom medio ruim] :EAD [bom medio ruim] :BDF [bom medio ruim] :CDF [bom medio ruim] :FDH [bom medio ruim] :HJD [bom medio ruim] :HDI [bom medio ruim] :IJD [bom medio ruim] :EDH [bom medio ruim] :EDI [bom medio ruim]}

           (= conteudo "fila") {:IJG [bom medio ruim] :GJE [bom medio ruim] :IEG [bom medio ruim]}

           (= conteudo "pilha") {:HIJ [bom medio ruim] :HDI [bom medio ruim] :IJD [bom medio ruim] :IJG [bom medio ruim] :EHI [bom medio ruim] :EDI [bom medio ruim]}

           (= conteudo "metOrd") {:BDF [bom medio ruim] :BHF [bom medio ruim] :CBF [bom medio ruim] :CDF [bom medio ruim] :FDH [bom medio ruim] :FJH [bom medio ruim] }

	   (= conteudo "metPesq") {:BHF [bom medio ruim] :FDH [bom medio ruim] :FJH [bom medio ruim] :HJD [bom medio ruim] :HIJ [bom medio ruim] :HDI [bom medio ruim] :EHI [bom medio ruim] :EDH [bom medio ruim] }
         :else "Este conteudo nao eh valido!")

)


