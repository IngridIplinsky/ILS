(ns ils.models.estudante.inf41
  (:use
      [ils.models.estudante.factor-graph]
      [ils.models.estudante.bayes]
      [ils.models.dominio.BD.atualizacao]
      [ils.models.dominio.BD.busca]
	  [ils.models.dominio.BD.insercao]
      ))

;Árvore de junção do modelo do domínio do artigo:
;Ambientes Inteligentes de Aprendizagem: Uma proposta baseada em hipermídia adaptativa e redes bayesianas. Nunes
;Esta árvore de junção tem fins de propagação, sendo uma ferramenta auxiliar na propagação através de distribuição marginal, sendo feita.
(def bayesED
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


(def inf41 {
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


;Funcao de propagacao muito mais rápida. :D
(defn propagar
"Uma funcao capaz de propagar e salvar no banco de dados do aluno. Esta funcao utiliza marginalização de uma arvore de juncao,
 que é usada como uma 'máscara' de progragação."
 ([]
       	(def bayesINF41 (let [prop (run-propagation bayesED)] 
                   (assoc inf41 :alocDin [(/ (+
                                            	(nth (vec (nth (vals prop)5))0) 
                                            	(nth (vec (nth (vals prop)9))0)
												(nth (vec (nth (vals prop)12))0))3)
					    				  (/ (+
                                            	(nth (vec (nth (vals prop)5))1) 
                                            	(nth (vec (nth (vals prop)9))1)
												(nth (vec (nth (vals prop)12))1))3)
 					    				  (/ (+
                                            	(nth (vec (nth (vals prop)5))2) 
                                            	(nth (vec (nth (vals prop)9))2)
												(nth (vec (nth (vals prop)12))2))3)]
		      					  :vetor [(/ (+
                                            	(nth (vec (nth (vals prop)0))0) 
                                            	(nth (vec (nth (vals prop)2))0)
												(nth (vec (nth (vals prop)7))0)
												(nth (vec (nth (vals prop)8))0)
												(nth (vec (nth (vals prop)9))0)
												(nth (vec (nth (vals prop)12))0)
												(nth (vec (nth (vals prop)16))0))7)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)0))1) 
                                            	(nth (vec (nth (vals prop)2))1)
												(nth (vec (nth (vals prop)7))1)
												(nth (vec (nth (vals prop)8))1)
												(nth (vec (nth (vals prop)9))1)
												(nth (vec (nth (vals prop)12))1)
												(nth (vec (nth (vals prop)16))1))7)
 					    				   (/ (+
                                            	(nth (vec (nth (vals prop)0))2) 
                                            	(nth (vec (nth (vals prop)2))2)
												(nth (vec (nth (vals prop)7))2)
												(nth (vec (nth (vals prop)8))2)
												(nth (vec (nth (vals prop)9))2)
												(nth (vec (nth (vals prop)12))2)
												(nth (vec (nth (vals prop)16))2))7)]

								:recursiv [(/ (+
                                            	(nth (vec (nth (vals prop)0))0) 
                                            	(nth (vec (nth (vals prop)7))0)
												(nth (vec (nth (vals prop)18))0))3)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)0))1) 
                                            	(nth (vec (nth (vals prop)7))1)
												(nth (vec (nth (vals prop)18))1))3)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)0))2) 
                                            	(nth (vec (nth (vals prop)7))2)
												(nth (vec (nth (vals prop)18))2))3)]

								  :arvore [(/ (+
                                            	(nth (vec (nth (vals prop)0))0) 
                                            	(nth (vec (nth (vals prop)3))0)
												(nth (vec (nth (vals prop)5))0)
												(nth (vec (nth (vals prop)8))0)
												(nth (vec (nth (vals prop)10))0)
												(nth (vec (nth (vals prop)11))0)
												(nth (vec (nth (vals prop)12))0)
												(nth (vec (nth (vals prop)14))0)
												(nth (vec (nth (vals prop)16))0)
												(nth (vec (nth (vals prop)18))0)
												(nth (vec (nth (vals prop)19))0)
												(nth (vec (nth (vals prop)20))0))12)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)0))1) 
                                            	(nth (vec (nth (vals prop)3))1)
												(nth (vec (nth (vals prop)5))1)
												(nth (vec (nth (vals prop)8))1)
												(nth (vec (nth (vals prop)10))1)
												(nth (vec (nth (vals prop)11))1)
												(nth (vec (nth (vals prop)12))1)
												(nth (vec (nth (vals prop)14))1)
												(nth (vec (nth (vals prop)16))1)
												(nth (vec (nth (vals prop)18))1)
												(nth (vec (nth (vals prop)19))1)
												(nth (vec (nth (vals prop)20))1))12)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)0))2) 
                                            	(nth (vec (nth (vals prop)3))2)
												(nth (vec (nth (vals prop)5))2)
												(nth (vec (nth (vals prop)8))2)
												(nth (vec (nth (vals prop)10))2)
												(nth (vec (nth (vals prop)11))2)
												(nth (vec (nth (vals prop)12))2)
												(nth (vec (nth (vals prop)14))2)
												(nth (vec (nth (vals prop)16))2)
												(nth (vec (nth (vals prop)18))2)
												(nth (vec (nth (vals prop)19))2)
												(nth (vec (nth (vals prop)20))2))12)]

								   :lista [(/ (+
                                            	(nth (vec (nth (vals prop)1))0) 
                                            	(nth (vec (nth (vals prop)4))0)
												(nth (vec (nth (vals prop)5))0)
												(nth (vec (nth (vals prop)9))0)
												(nth (vec (nth (vals prop)10))0)
												(nth (vec (nth (vals prop)11))0)
												(nth (vec (nth (vals prop)15))0)
												(nth (vec (nth (vals prop)16))0))8)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)1))1) 
                                            	(nth (vec (nth (vals prop)4))1)
												(nth (vec (nth (vals prop)5))1)
												(nth (vec (nth (vals prop)9))1)
												(nth (vec (nth (vals prop)10))1)
												(nth (vec (nth (vals prop)11))1)
												(nth (vec (nth (vals prop)15))1)
												(nth (vec (nth (vals prop)16))1))8)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)1))2) 
                                            	(nth (vec (nth (vals prop)4))2)
												(nth (vec (nth (vals prop)5))2)
												(nth (vec (nth (vals prop)9))2)
												(nth (vec (nth (vals prop)10))2)
												(nth (vec (nth (vals prop)11))2)
												(nth (vec (nth (vals prop)15))2)
												(nth (vec (nth (vals prop)16))2))8)]

								  :metOrd [(/ (+
                                            	(nth (vec (nth (vals prop)2))0) 
                                            	(nth (vec (nth (vals prop)7))0)
												(nth (vec (nth (vals prop)8))0)
												(nth (vec (nth (vals prop)17))0)
												(nth (vec (nth (vals prop)18))0)
												(nth (vec (nth (vals prop)19))0))6)
					   				 	   (/ (+
                                            	(nth (vec (nth (vals prop)2))1) 
                                            	(nth (vec (nth (vals prop)7))1)
												(nth (vec (nth (vals prop)8))1)
												(nth (vec (nth (vals prop)17))1)
												(nth (vec (nth (vals prop)18))1)
												(nth (vec (nth (vals prop)19))1))6)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)2))2) 
                                            	(nth (vec (nth (vals prop)7))2)
												(nth (vec (nth (vals prop)8))2)
												(nth (vec (nth (vals prop)17))2)
												(nth (vec (nth (vals prop)18))2)
												(nth (vec (nth (vals prop)19))2))6)]

									:fila [(/ (+
                                            	(nth (vec (nth (vals prop)1))0) 
                                            	(nth (vec (nth (vals prop)4))0)
												(nth (vec (nth (vals prop)6))0))3)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)1))1) 
                                            	(nth (vec (nth (vals prop)4))1)
												(nth (vec (nth (vals prop)6))1))3)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)1))2) 
                                            	(nth (vec (nth (vals prop)4))2)
												(nth (vec (nth (vals prop)6))2))3)]

								 :metPesq [(/ (+
                                            	(nth (vec (nth (vals prop)2))0) 
                                            	(nth (vec (nth (vals prop)11))0)
												(nth (vec (nth (vals prop)13))0)
												(nth (vec (nth (vals prop)14))0)
												(nth (vec (nth (vals prop)15))0)
												(nth (vec (nth (vals prop)17))0)
												(nth (vec (nth (vals prop)19))0)
												(nth (vec (nth (vals prop)20))0))8)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)2))1) 
                                            	(nth (vec (nth (vals prop)11))1)
												(nth (vec (nth (vals prop)13))1)
												(nth (vec (nth (vals prop)14))1)
												(nth (vec (nth (vals prop)15))1)
												(nth (vec (nth (vals prop)17))1)
												(nth (vec (nth (vals prop)19))1)
												(nth (vec (nth (vals prop)20))1))8)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)2))2) 
                                            	(nth (vec (nth (vals prop)11))2)
												(nth (vec (nth (vals prop)13))2)
												(nth (vec (nth (vals prop)14))2)
												(nth (vec (nth (vals prop)15))2)
												(nth (vec (nth (vals prop)17))2)
												(nth (vec (nth (vals prop)19))2)
												(nth (vec (nth (vals prop)20))2))8)]

								   :pilha [(/ (+
                                            	(nth (vec (nth (vals prop)1))0) 
                                            	(nth (vec (nth (vals prop)3))0)
												(nth (vec (nth (vals prop)6))0)
												(nth (vec (nth (vals prop)10))0)
												(nth (vec (nth (vals prop)13))0)
												(nth (vec (nth (vals prop)15))0)
												(nth (vec (nth (vals prop)20))0))7)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)1))1) 
                                            	(nth (vec (nth (vals prop)3))1)
												(nth (vec (nth (vals prop)6))1)
												(nth (vec (nth (vals prop)10))1)
												(nth (vec (nth (vals prop)13))1)
												(nth (vec (nth (vals prop)15))1)
												(nth (vec (nth (vals prop)20))1))7)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)1))2) 
                                            	(nth (vec (nth (vals prop)3))2)
												(nth (vec (nth (vals prop)6))2)
												(nth (vec (nth (vals prop)10))2)
												(nth (vec (nth (vals prop)13))2)
												(nth (vec (nth (vals prop)15))2)
												(nth (vec (nth (vals prop)20))2))7)]
			
						 :estrutura-dados [(/ (+
                                            	(nth (vec (nth (vals prop)3))0) 
                                            	(nth (vec (nth (vals prop)4))0)
												(nth (vec (nth (vals prop)6))0)
												(nth (vec (nth (vals prop)13))0)
												(nth (vec (nth (vals prop)14))0)
												(nth (vec (nth (vals prop)17))0))6)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)3))1) 
                                            	(nth (vec (nth (vals prop)4))1)
												(nth (vec (nth (vals prop)6))1)
												(nth (vec (nth (vals prop)13))1)
												(nth (vec (nth (vals prop)14))1)
												(nth (vec (nth (vals prop)17))1))6)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)3))2) 
                                            	(nth (vec (nth (vals prop)4))2)
												(nth (vec (nth (vals prop)6))2)
												(nth (vec (nth (vals prop)13))2)
												(nth (vec (nth (vals prop)14))2)
												(nth (vec (nth (vals prop)17))2))6)]
	))) 
  )
  ([evidencias]
	(def bayesINF41 (let [prop (run-propagation bayesED evidencias)] 
                   (assoc inf41 :alocDin [(/ (+
                                            	(nth (vec (nth (vals prop)5))0) 
                                            	(nth (vec (nth (vals prop)9))0)
												(nth (vec (nth (vals prop)12))0))3)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)5))1) 
                                            	(nth (vec (nth (vals prop)9))1)
												(nth (vec (nth (vals prop)12))1))3)
 					    				   (/ (+
                                            	(nth (vec (nth (vals prop)5))2) 
                                            	(nth (vec (nth (vals prop)9))2)
												(nth (vec (nth (vals prop)12))2))3)]
		      					   :vetor [(/ (+
                                            	(nth (vec (nth (vals prop)0))0) 
                                            	(nth (vec (nth (vals prop)2))0)
												(nth (vec (nth (vals prop)7))0)
												(nth (vec (nth (vals prop)8))0)
												(nth (vec (nth (vals prop)9))0)
												(nth (vec (nth (vals prop)12))0)
												(nth (vec (nth (vals prop)16))0))7)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)0))1) 
                                            	(nth (vec (nth (vals prop)2))1)
												(nth (vec (nth (vals prop)7))1)
												(nth (vec (nth (vals prop)8))1)
												(nth (vec (nth (vals prop)9))1)
												(nth (vec (nth (vals prop)12))1)
												(nth (vec (nth (vals prop)16))1))7)
 					    				   (/ (+
                                            	(nth (vec (nth (vals prop)0))2) 
                                            	(nth (vec (nth (vals prop)2))2)
												(nth (vec (nth (vals prop)7))2)
												(nth (vec (nth (vals prop)8))2)
												(nth (vec (nth (vals prop)9))2)
												(nth (vec (nth (vals prop)12))2)
												(nth (vec (nth (vals prop)16))2))7)]

								:recursiv [(/ (+
                                            	(nth (vec (nth (vals prop)0))0) 
                                            	(nth (vec (nth (vals prop)7))0)
												(nth (vec (nth (vals prop)18))0))3)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)0))1) 
                                            	(nth (vec (nth (vals prop)7))1)
												(nth (vec (nth (vals prop)18))1))3)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)0))2) 
                                            	(nth (vec (nth (vals prop)7))2)
												(nth (vec (nth (vals prop)18))2))3)]

								  :arvore [(/ (+
                                            	(nth (vec (nth (vals prop)0))0) 
                                            	(nth (vec (nth (vals prop)3))0)
												(nth (vec (nth (vals prop)5))0)
												(nth (vec (nth (vals prop)8))0)
												(nth (vec (nth (vals prop)10))0)
												(nth (vec (nth (vals prop)11))0)
												(nth (vec (nth (vals prop)12))0)
												(nth (vec (nth (vals prop)14))0)
												(nth (vec (nth (vals prop)16))0)
												(nth (vec (nth (vals prop)18))0)
												(nth (vec (nth (vals prop)19))0)
												(nth (vec (nth (vals prop)20))0))12)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)0))1) 
                                            	(nth (vec (nth (vals prop)3))1)
												(nth (vec (nth (vals prop)5))1)
												(nth (vec (nth (vals prop)8))1)
												(nth (vec (nth (vals prop)10))1)
												(nth (vec (nth (vals prop)11))1)
												(nth (vec (nth (vals prop)12))1)
												(nth (vec (nth (vals prop)14))1)
												(nth (vec (nth (vals prop)16))1)
												(nth (vec (nth (vals prop)18))1)
												(nth (vec (nth (vals prop)19))1)
												(nth (vec (nth (vals prop)20))1))12)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)0))2) 
                                            	(nth (vec (nth (vals prop)3))2)
												(nth (vec (nth (vals prop)5))2)
												(nth (vec (nth (vals prop)8))2)
												(nth (vec (nth (vals prop)10))2)
												(nth (vec (nth (vals prop)11))2)
												(nth (vec (nth (vals prop)12))2)
												(nth (vec (nth (vals prop)14))2)
												(nth (vec (nth (vals prop)16))2)
												(nth (vec (nth (vals prop)18))2)
												(nth (vec (nth (vals prop)19))2)
												(nth (vec (nth (vals prop)20))2))12)]

								   :lista [(/ (+
                                            	(nth (vec (nth (vals prop)1))0) 
                                            	(nth (vec (nth (vals prop)4))0)
												(nth (vec (nth (vals prop)5))0)
												(nth (vec (nth (vals prop)9))0)
												(nth (vec (nth (vals prop)10))0)
												(nth (vec (nth (vals prop)11))0)
												(nth (vec (nth (vals prop)15))0)
												(nth (vec (nth (vals prop)16))0))8)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)1))1) 
                                            	(nth (vec (nth (vals prop)4))1)
												(nth (vec (nth (vals prop)5))1)
												(nth (vec (nth (vals prop)9))1)
												(nth (vec (nth (vals prop)10))1)
												(nth (vec (nth (vals prop)11))1)
												(nth (vec (nth (vals prop)15))1)
												(nth (vec (nth (vals prop)16))1))8)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)1))2) 
                                            	(nth (vec (nth (vals prop)4))2)
												(nth (vec (nth (vals prop)5))2)
												(nth (vec (nth (vals prop)9))2)
												(nth (vec (nth (vals prop)10))2)
												(nth (vec (nth (vals prop)11))2)
												(nth (vec (nth (vals prop)15))2)
												(nth (vec (nth (vals prop)16))2))8)]

								  :metOrd [(/ (+
                                            	(nth (vec (nth (vals prop)2))0) 
                                            	(nth (vec (nth (vals prop)7))0)
												(nth (vec (nth (vals prop)8))0)
												(nth (vec (nth (vals prop)17))0)
												(nth (vec (nth (vals prop)18))0)
												(nth (vec (nth (vals prop)19))0))6)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)2))1) 
                                            	(nth (vec (nth (vals prop)7))1)
												(nth (vec (nth (vals prop)8))1)
												(nth (vec (nth (vals prop)17))1)
												(nth (vec (nth (vals prop)18))1)
												(nth (vec (nth (vals prop)19))1))6)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)2))2) 
                                            	(nth (vec (nth (vals prop)7))2)
												(nth (vec (nth (vals prop)8))2)
												(nth (vec (nth (vals prop)17))2)
												(nth (vec (nth (vals prop)18))2)
												(nth (vec (nth (vals prop)19))2))6)]

									:fila [(/ (+
                                            	(nth (vec (nth (vals prop)1))0) 
                                            	(nth (vec (nth (vals prop)4))0)
												(nth (vec (nth (vals prop)6))0))3)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)1))1) 
                                            	(nth (vec (nth (vals prop)4))1)
												(nth (vec (nth (vals prop)6))1))3)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)1))2) 
                                            	(nth (vec (nth (vals prop)4))2)
												(nth (vec (nth (vals prop)6))2))3)]

								 :metPesq [(/ (+
                                            	(nth (vec (nth (vals prop)2))0) 
                                            	(nth (vec (nth (vals prop)11))0)
												(nth (vec (nth (vals prop)13))0)
												(nth (vec (nth (vals prop)14))0)
												(nth (vec (nth (vals prop)15))0)
												(nth (vec (nth (vals prop)17))0)
												(nth (vec (nth (vals prop)19))0)
												(nth (vec (nth (vals prop)20))0))8)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)2))1) 
                                            	(nth (vec (nth (vals prop)11))1)
												(nth (vec (nth (vals prop)13))1)
												(nth (vec (nth (vals prop)14))1)
												(nth (vec (nth (vals prop)15))1)
												(nth (vec (nth (vals prop)17))1)
												(nth (vec (nth (vals prop)19))1)
												(nth (vec (nth (vals prop)20))1))8)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)2))2) 
                                            	(nth (vec (nth (vals prop)11))2)
												(nth (vec (nth (vals prop)13))2)
												(nth (vec (nth (vals prop)14))2)
												(nth (vec (nth (vals prop)15))2)
												(nth (vec (nth (vals prop)17))2)
												(nth (vec (nth (vals prop)19))2)
												(nth (vec (nth (vals prop)20))2))8)]

								   :pilha [(/ (+
                                            	(nth (vec (nth (vals prop)1))0) 
                                            	(nth (vec (nth (vals prop)3))0)
												(nth (vec (nth (vals prop)6))0)
												(nth (vec (nth (vals prop)10))0)
												(nth (vec (nth (vals prop)13))0)
												(nth (vec (nth (vals prop)15))0)
												(nth (vec (nth (vals prop)20))0))7)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)1))1) 
                                            	(nth (vec (nth (vals prop)3))1)
												(nth (vec (nth (vals prop)6))1)
												(nth (vec (nth (vals prop)10))1)
												(nth (vec (nth (vals prop)13))1)
												(nth (vec (nth (vals prop)15))1)
												(nth (vec (nth (vals prop)20))1))7)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)1))2) 
                                            	(nth (vec (nth (vals prop)3))2)
												(nth (vec (nth (vals prop)6))2)
												(nth (vec (nth (vals prop)10))2)
												(nth (vec (nth (vals prop)13))2)
												(nth (vec (nth (vals prop)15))2)
												(nth (vec (nth (vals prop)20))2))7)]

			
						 :estrutura-dados [(/ (+
                                            	(nth (vec (nth (vals prop)3))0) 
                                            	(nth (vec (nth (vals prop)4))0)
												(nth (vec (nth (vals prop)6))0)
												(nth (vec (nth (vals prop)13))0)
												(nth (vec (nth (vals prop)14))0)
												(nth (vec (nth (vals prop)17))0))6)
					    				   (/ (+
                                            	(nth (vec (nth (vals prop)3))1) 
                                            	(nth (vec (nth (vals prop)4))1)
												(nth (vec (nth (vals prop)6))1)
												(nth (vec (nth (vals prop)13))1)
												(nth (vec (nth (vals prop)14))1)
												(nth (vec (nth (vals prop)17))1))6)
					  
					     				   (/ (+
                                            	(nth (vec (nth (vals prop)3))2) 
                                            	(nth (vec (nth (vals prop)4))2)
												(nth (vec (nth (vals prop)6))2)
												(nth (vec (nth (vals prop)13))2)
												(nth (vec (nth (vals prop)14))2)
												(nth (vec (nth (vals prop)17))2))6)]
	)))) 
)

;ATENCAO! esta funcao nao atualiza no banco. Use as duas quando mudar de exercicio! (esta é util para mudar os valores da estrutura,
;utilizada para calcular o conhecimento geral do estudante. Para alterar no banco, use: atualizar-probs-exercicio  (linha 502)
(defn atualizar-exercicio 
"Atualiza as probabilidades de um exercicio de algum conteudo. Ex: (atualizar-exercicio \"estrutura-dados\" :ex1 1.0 0.0 0.0)"
[conteudo exercicio bom medio ruim]
        (cond 	   
	   		(= conteudo "estrutura-dados") (def estrutura-dados
                               (assoc estrutura-dados exercicio [bom medio ruim]))
	   		(= conteudo "alocDin") (def alocDin
                               (assoc alocDin exercicio [bom medio ruim]))
	   		(= conteudo "vetor") (def vetor
                               (assoc vetor exercicio [bom medio ruim]))
           (= conteudo "recursiv") (def recursiv
                               (assoc recursiv exercicio [bom medio ruim]))
           (= conteudo "lista") (def lista
                               (assoc lista exercicio [bom medio ruim]))
           (= conteudo "arvore") (def arvore
                               (assoc arvore exercicio [bom medio ruim]))
           (= conteudo "fila") (def fila
                               (assoc fila exercicio [bom medio ruim]))
           (= conteudo "pilha") (def pilha
                               (assoc pilha exercicio [bom medio ruim]))
           (= conteudo "metOrd") (def metOrd
                               (assoc metOrd exercicio [bom medio ruim]))
	   (= conteudo "metPesq") (def metPesq
                               (assoc metPesq exercicio [bom medio ruim]))
         :else "Este conteudo nao eh valido!"))

(defn salvar 
   "Salva as probabilidades dos exercicios do aluno no disco. Pode se salvar apenas um exercicio ou o conteudo todo."
   [matricula conteudo ex idEx ]
 	(cond 
	   (= conteudo  "alocDin") (atualizar-exercicioAluno matricula conteudo idEx (first (ex alocDin)) (nth (ex alocDin) 1) (nth (ex alocDin)2))
	   (= conteudo "vetor") (atualizar-exercicioAluno matricula conteudo idEx (first (ex vetor)) (nth (ex vetor) 1) (nth (ex vetor)2))
           (= conteudo "recursiv") (atualizar-exercicioAluno matricula conteudo idEx (first (ex recursiv)) (nth (ex recursiv) 1) (nth (ex recursiv)2))
           (= conteudo "lista") (atualizar-exercicioAluno matricula conteudo idEx (first (ex lista)) (nth (ex lista) 1) (nth (ex lista)2))
           (= conteudo "arvore") (atualizar-exercicioAluno matricula conteudo idEx (first (ex arvore)) (nth (ex arvore) 1) (nth (ex arvore)2))
           (= conteudo "fila") (atualizar-exercicioAluno matricula conteudo idEx (first (ex fila)) (nth (ex fila) 1) (nth (ex fila)2))
           (= conteudo "pilha") (atualizar-exercicioAluno matricula conteudo idEx (first (ex pilha)) (nth (ex pilha) 1) (nth (ex pilha)2))
           (= conteudo "metOrd") (atualizar-exercicioAluno matricula conteudo idEx (first (ex metOrd)) (nth (ex metOrd) 1) (nth (ex metOrd)2))
	   (= conteudo "metPesq") (atualizar-exercicioAluno matricula conteudo idEx (first (ex metPesq)) (nth (ex metPesq) 1) (nth (ex metPesq)2))
           :else "conteudo nao é válido!")
)

(defn carregar-exercicios 
"Carrega os exercicios de um conteudo de um aluno do banco na estrutura."
	[matricula conteudo]
   (cond 	   	  
	   (= conteudo "alocDin") (def alocDin
                                (assoc alocDin 
						(let [exercicios (:bom (first (buscar-exercicioAluno "bom" "medio" "ruim" matricula "98713" "conteudo" conteudo)))]

                        :ex1 [ (:bom (nth exercicios 0)) (:medio (nth exercicios 0)) (:ruim (nth exercicios 0))]       
                        :ex2 [ (:bom (nth exercicios 1)) (:medio (nth exercicios 1)) (:ruim (nth exercicios 1))]
						:ex3 [ (:bom (nth exercicios 2)) (:medio (nth exercicios 2)) (:ruim (nth exercicios 2))]
						:ex4 [ (:bom (nth exercicios 3)) (:medio (nth exercicios 3)) (:ruim (nth exercicios 3))]
						:ex5 [ (:bom (nth exercicios 4)) (:medio (nth exercicios 4)) (:ruim (nth exercicios 4))]
						:ex6 [ (:bom (nth exercicios 5)) (:medio (nth exercicios 5)) (:ruim (nth exercicios 5))]
						:ex7 [ (:bom (nth exercicios 6)) (:medio (nth exercicios 6)) (:ruim (nth exercicios 6))]
						:ex8 [ (:bom (nth exercicios 7)) (:medio (nth exercicios 7)) (:ruim (nth exercicios 7))]
						:ex9 [ (:bom (nth exercicios 8)) (:medio (nth exercicios 8)) (:ruim (nth exercicios 8))]
						:ex10 [ (:bom (nth exercicios 9)) (:medio (nth exercicios 9)) (:ruim (nth exercicios 9))] )))
	   
		(= conteudo "vetor") (def vetor
                               (assoc vetor 
						(let [exercicios (:bom (first (buscar-exercicioAluno "bom" "medio" "ruim" matricula "98713" "conteudo" conteudo)))]
                        
						:ex1 [ (:bom (nth exercicios 0)) (:medio (nth exercicios 0)) (:ruim (nth exercicios 0))]       
                        :ex2 [ (:bom (nth exercicios 1)) (:medio (nth exercicios 1)) (:ruim (nth exercicios 1))]
						:ex3 [ (:bom (nth exercicios 2)) (:medio (nth exercicios 2)) (:ruim (nth exercicios 2))]
						:ex4 [ (:bom (nth exercicios 3)) (:medio (nth exercicios 3)) (:ruim (nth exercicios 3))]
						:ex5 [ (:bom (nth exercicios 4)) (:medio (nth exercicios 4)) (:ruim (nth exercicios 4))]
						:ex6 [ (:bom (nth exercicios 5)) (:medio (nth exercicios 5)) (:ruim (nth exercicios 5))]
						:ex7 [ (:bom (nth exercicios 6)) (:medio (nth exercicios 6)) (:ruim (nth exercicios 6))]
						:ex8 [ (:bom (nth exercicios 7)) (:medio (nth exercicios 7)) (:ruim (nth exercicios 7))]
						:ex9 [ (:bom (nth exercicios 8)) (:medio (nth exercicios 8)) (:ruim (nth exercicios 8))]
						:ex10 [ (:bom (nth exercicios 9)) (:medio (nth exercicios 9)) (:ruim (nth exercicios 9))] )))

           (= conteudo "recursiv") (def recursiv
                                 (assoc recursiv 

                        (let [exercicios (:bom (first (buscar-exercicioAluno "bom" "medio" "ruim" matricula "98713" "conteudo" conteudo)))]
                        
						:ex1 [ (:bom (nth exercicios 0)) (:medio (nth exercicios 0)) (:ruim (nth exercicios 0))]       
                        :ex2 [ (:bom (nth exercicios 1)) (:medio (nth exercicios 1)) (:ruim (nth exercicios 1))]
						:ex3 [ (:bom (nth exercicios 2)) (:medio (nth exercicios 2)) (:ruim (nth exercicios 2))]
						:ex4 [ (:bom (nth exercicios 3)) (:medio (nth exercicios 3)) (:ruim (nth exercicios 3))]
						:ex5 [ (:bom (nth exercicios 4)) (:medio (nth exercicios 4)) (:ruim (nth exercicios 4))]
						:ex6 [ (:bom (nth exercicios 5)) (:medio (nth exercicios 5)) (:ruim (nth exercicios 5))]
						:ex7 [ (:bom (nth exercicios 6)) (:medio (nth exercicios 6)) (:ruim (nth exercicios 6))]
						:ex8 [ (:bom (nth exercicios 7)) (:medio (nth exercicios 7)) (:ruim (nth exercicios 7))]
						:ex9 [ (:bom (nth exercicios 8)) (:medio (nth exercicios 8)) (:ruim (nth exercicios 8))]
						:ex10 [ (:bom (nth exercicios 9)) (:medio (nth exercicios 9)) (:ruim (nth exercicios 9))] )))

           (= conteudo "lista") (def lista
                               (assoc lista 

                        (let [exercicios (:bom (first (buscar-exercicioAluno "bom" "medio" "ruim" matricula "98713" "conteudo" conteudo)))]
                        
						:ex1 [ (:bom (nth exercicios 0)) (:medio (nth exercicios 0)) (:ruim (nth exercicios 0))]       
                        :ex2 [ (:bom (nth exercicios 1)) (:medio (nth exercicios 1)) (:ruim (nth exercicios 1))]
						:ex3 [ (:bom (nth exercicios 2)) (:medio (nth exercicios 2)) (:ruim (nth exercicios 2))]
						:ex4 [ (:bom (nth exercicios 3)) (:medio (nth exercicios 3)) (:ruim (nth exercicios 3))]
						:ex5 [ (:bom (nth exercicios 4)) (:medio (nth exercicios 4)) (:ruim (nth exercicios 4))]
						:ex6 [ (:bom (nth exercicios 5)) (:medio (nth exercicios 5)) (:ruim (nth exercicios 5))]
						:ex7 [ (:bom (nth exercicios 6)) (:medio (nth exercicios 6)) (:ruim (nth exercicios 6))]
						:ex8 [ (:bom (nth exercicios 7)) (:medio (nth exercicios 7)) (:ruim (nth exercicios 7))]
						:ex9 [ (:bom (nth exercicios 8)) (:medio (nth exercicios 8)) (:ruim (nth exercicios 8))]
						:ex10 [ (:bom (nth exercicios 9)) (:medio (nth exercicios 9)) (:ruim (nth exercicios 9))] )))

           (= conteudo "arvore") (def arvore
                               (assoc arvore 
                        
						(let [exercicios (:bom (first (buscar-exercicioAluno "bom" "medio" "ruim" matricula "98713" "conteudo" conteudo)))]
                        
						:ex1 [ (:bom (nth exercicios 0)) (:medio (nth exercicios 0)) (:ruim (nth exercicios 0))]       
                        :ex2 [ (:bom (nth exercicios 1)) (:medio (nth exercicios 1)) (:ruim (nth exercicios 1))]
						:ex3 [ (:bom (nth exercicios 2)) (:medio (nth exercicios 2)) (:ruim (nth exercicios 2))]
						:ex4 [ (:bom (nth exercicios 3)) (:medio (nth exercicios 3)) (:ruim (nth exercicios 3))]
						:ex5 [ (:bom (nth exercicios 4)) (:medio (nth exercicios 4)) (:ruim (nth exercicios 4))]
						:ex6 [ (:bom (nth exercicios 5)) (:medio (nth exercicios 5)) (:ruim (nth exercicios 5))]
						:ex7 [ (:bom (nth exercicios 6)) (:medio (nth exercicios 6)) (:ruim (nth exercicios 6))]
						:ex8 [ (:bom (nth exercicios 7)) (:medio (nth exercicios 7)) (:ruim (nth exercicios 7))]
						:ex9 [ (:bom (nth exercicios 8)) (:medio (nth exercicios 8)) (:ruim (nth exercicios 8))]
						:ex10 [ (:bom (nth exercicios 9)) (:medio (nth exercicios 9)) (:ruim (nth exercicios 9))] )))
           (= conteudo "fila") (def fila
                             (assoc fila 

                        (let [exercicios (:bom (first (buscar-exercicioAluno "bom" "medio" "ruim" matricula "98713" "conteudo" conteudo)))]
                        
						:ex1 [ (:bom (nth exercicios 0)) (:medio (nth exercicios 0)) (:ruim (nth exercicios 0))]       
                        :ex2 [ (:bom (nth exercicios 1)) (:medio (nth exercicios 1)) (:ruim (nth exercicios 1))]
						:ex3 [ (:bom (nth exercicios 2)) (:medio (nth exercicios 2)) (:ruim (nth exercicios 2))]
						:ex4 [ (:bom (nth exercicios 3)) (:medio (nth exercicios 3)) (:ruim (nth exercicios 3))]
						:ex5 [ (:bom (nth exercicios 4)) (:medio (nth exercicios 4)) (:ruim (nth exercicios 4))]
						:ex6 [ (:bom (nth exercicios 5)) (:medio (nth exercicios 5)) (:ruim (nth exercicios 5))]
						:ex7 [ (:bom (nth exercicios 6)) (:medio (nth exercicios 6)) (:ruim (nth exercicios 6))]
						:ex8 [ (:bom (nth exercicios 7)) (:medio (nth exercicios 7)) (:ruim (nth exercicios 7))]
						:ex9 [ (:bom (nth exercicios 8)) (:medio (nth exercicios 8)) (:ruim (nth exercicios 8))]
						:ex10 [ (:bom (nth exercicios 9)) (:medio (nth exercicios 9)) (:ruim (nth exercicios 9))] )))

           (= conteudo "pilha") (def pilha
                               (assoc pilha 

                        (let [exercicios (:bom (first (buscar-exercicioAluno "bom" "medio" "ruim" matricula "98713" "conteudo" conteudo)))]
                        
						:ex1 [ (:bom (nth exercicios 0)) (:medio (nth exercicios 0)) (:ruim (nth exercicios 0))]       
                        :ex2 [ (:bom (nth exercicios 1)) (:medio (nth exercicios 1)) (:ruim (nth exercicios 1))]
						:ex3 [ (:bom (nth exercicios 2)) (:medio (nth exercicios 2)) (:ruim (nth exercicios 2))]
						:ex4 [ (:bom (nth exercicios 3)) (:medio (nth exercicios 3)) (:ruim (nth exercicios 3))]
						:ex5 [ (:bom (nth exercicios 4)) (:medio (nth exercicios 4)) (:ruim (nth exercicios 4))]
						:ex6 [ (:bom (nth exercicios 5)) (:medio (nth exercicios 5)) (:ruim (nth exercicios 5))]
						:ex7 [ (:bom (nth exercicios 6)) (:medio (nth exercicios 6)) (:ruim (nth exercicios 6))]
						:ex8 [ (:bom (nth exercicios 7)) (:medio (nth exercicios 7)) (:ruim (nth exercicios 7))]
						:ex9 [ (:bom (nth exercicios 8)) (:medio (nth exercicios 8)) (:ruim (nth exercicios 8))]
						:ex10 [ (:bom (nth exercicios 9)) (:medio (nth exercicios 9)) (:ruim (nth exercicios 9))] )))

           (= conteudo "metOrd") (def metOrd
                               (assoc metOrd 

                        (let [exercicios (:bom (first (buscar-exercicioAluno "bom" "medio" "ruim" matricula "98713" "conteudo" conteudo)))]
                        
						:ex1 [ (:bom (nth exercicios 0)) (:medio (nth exercicios 0)) (:ruim (nth exercicios 0))]       
                        :ex2 [ (:bom (nth exercicios 1)) (:medio (nth exercicios 1)) (:ruim (nth exercicios 1))]
						:ex3 [ (:bom (nth exercicios 2)) (:medio (nth exercicios 2)) (:ruim (nth exercicios 2))]
						:ex4 [ (:bom (nth exercicios 3)) (:medio (nth exercicios 3)) (:ruim (nth exercicios 3))]
						:ex5 [ (:bom (nth exercicios 4)) (:medio (nth exercicios 4)) (:ruim (nth exercicios 4))]
						:ex6 [ (:bom (nth exercicios 5)) (:medio (nth exercicios 5)) (:ruim (nth exercicios 5))]
						:ex7 [ (:bom (nth exercicios 6)) (:medio (nth exercicios 6)) (:ruim (nth exercicios 6))]
						:ex8 [ (:bom (nth exercicios 7)) (:medio (nth exercicios 7)) (:ruim (nth exercicios 7))]
						:ex9 [ (:bom (nth exercicios 8)) (:medio (nth exercicios 8)) (:ruim (nth exercicios 8))]
						:ex10 [ (:bom (nth exercicios 9)) (:medio (nth exercicios 9)) (:ruim (nth exercicios 9))] )))

	   (= conteudo "metPesq") (def metPesq
                               (assoc metPesq 

                       (let [exercicios (:bom (first (buscar-exercicioAluno "bom" "medio" "ruim" matricula "98713" "conteudo" conteudo)))]
                        
						:ex1 [ (:bom (nth exercicios 0)) (:medio (nth exercicios 0)) (:ruim (nth exercicios 0))]       
                        :ex2 [ (:bom (nth exercicios 1)) (:medio (nth exercicios 1)) (:ruim (nth exercicios 1))]
						:ex3 [ (:bom (nth exercicios 2)) (:medio (nth exercicios 2)) (:ruim (nth exercicios 2))]
						:ex4 [ (:bom (nth exercicios 3)) (:medio (nth exercicios 3)) (:ruim (nth exercicios 3))]
						:ex5 [ (:bom (nth exercicios 4)) (:medio (nth exercicios 4)) (:ruim (nth exercicios 4))]
						:ex6 [ (:bom (nth exercicios 5)) (:medio (nth exercicios 5)) (:ruim (nth exercicios 5))]
						:ex7 [ (:bom (nth exercicios 6)) (:medio (nth exercicios 6)) (:ruim (nth exercicios 6))]
						:ex8 [ (:bom (nth exercicios 7)) (:medio (nth exercicios 7)) (:ruim (nth exercicios 7))]
						:ex9 [ (:bom (nth exercicios 8)) (:medio (nth exercicios 8)) (:ruim (nth exercicios 8))]
						:ex10 [ (:bom (nth exercicios 9)) (:medio (nth exercicios 9)) (:ruim (nth exercicios 9))] )))
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

(defn criar-ou-atualizar-escopo [matricula conteudo]
  "Cria o escopo utilizado para persistencia do estereotipo do aluno no banco."
    (inserir-conteudoAluno matricula conteudo 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "vazio1" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "vazio2" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "vazio3" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "vazio4" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "vazio5" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "vazio6" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "vazio7" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "vazio8" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "vazio9" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "vazio10" 0.33 0.33 0.33)
)
