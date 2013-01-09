(ns ils.models.estudante.estudante
  (:use
      [ils.models.estudante.factor-graph]
      [ils.models.estudante.bayes]
      [ils.models.estudante.inf41]
      [ils.models.estudante.gsi002]
      [ils.models.dominio.BD.atualizacao]
      [ils.models.dominio.BD.busca]
	  [ils.models.dominio.BD.insercao]
      ))

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
 ([sigla]
       (cond
       		(= sigla "gsi002") (def bayesGSI002 (let [prop (run-propagation bayesIC)] 
                   (assoc gsi002 :introducao [(/(+ (first (:ABC prop)) (first (:ACF prop)) )2)
                                              (/(+ (nth (:ABC prop)1) (nth (:ACF prop)1) )2)
 					      					  (/(+ (last (:ABC prop)) (last (:ACF prop)) )2)]
								     
								 :estruturasCond [(/(+ (first (:BDC prop)) (first (:ABC prop)) (first (:BDE prop)) )3)
												  (/(+ (nth (:BDC prop)1) (nth (:ABC prop)1) (nth (:BDE prop)1) )3)
												  (/(+ (last (:BDC prop)) (last (:ABC prop)) (last (:BDE prop)) )3)]
				
								:laco [(/(+ (first (:BDC prop)) (first (:ABC prop)) (first (:ACF prop)) )3)
									   (/(+ (nth (:BDC prop)1) (nth (:ABC prop)1) (nth (:ACF prop)1) )3)
									   (/(+ (last (:BDC prop)) (last (:ABC prop)) (last (:ACF prop)) )3)]
			
								:funcao [(/(+ (first (:BDC prop)) (first (:DCE prop)) (first (:BDE prop)) )3)
										 (/(+ (nth (:BDC prop)1) (nth (:DCE prop)1) (nth (:BDE prop)1) )3)
									 	 (/(+ (last (:BDC prop)) (last (:DCE prop)) (last (:BDE prop)) )3)]

								:recursao [(/(+ (first (:BDE prop)) (first (:DCE prop)) )2)
										   (/(+ (nth (:BDE prop)1) (nth (:DCE prop)1) )2)
									   	   (/(+ (last (:BDE prop)) (last (:DCE prop)) )2)]

								:vetor [(/(+ (first (:ACF prop)) (first (:FGI prop)) )2)
										(/(+ (nth (:ACF prop)1) (nth (:FGI prop)1) )2)
										(/(+ (last (:ACF prop)) (last (:FGI prop)) )2)]
						
								:alocDin [(/(+ (first (:GHI prop)) (first (:FGI prop)) )2)
										  (/(+ (nth (:GHI prop)1) (nth (:FGI prop)1) )2)
									  	  (/(+ (last (:GHI prop)) (last (:FGI prop)) )2)]

					 				:strings [(/(+ (first (:GHI prop)) (first (:HJI prop)) )2)
										      (/(+ (nth (:GHI prop)1) (nth (:HJI prop)1) )2)
									  	      (/(+ (last (:GHI prop)) (last (:HJI prop)) )2)]

								:estruturas [(/(+ (first (:FGI prop)) (first (:GHI prop)) (first (:FGI prop)) )3)
											 (/(+ (nth (:FGI prop)1) (nth (:GHI prop)1) (nth (:FGI prop)1) )3)
										 	 (/(+ (last (:FGI prop)) (last (:GHI prop)) (last (:FGI prop)) )3)]

								:arquivo [ (first (:HJI prop)) (nth (:HJI prop)1) (last (:HJI prop)) ])))

       		(= sigla "inf41") (def bayesINF41 (let [prop (run-propagation bayesED)] 
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
												(nth (vec (nth (vals prop)17))2))6)])))
		:else "A sigla nao eh valida!") 
  )
  ([sigla evidencias]
  	(cond
		(= sigla "gsi002") (def bayesGSI002 (let [prop (run-propagation bayesIC evidencias)] 
                   (assoc gsi002  
					:introducao [(/(+ (first (:ABC prop)) (first (:ACF prop)) )2)
		                         (/(+ (nth (:ABC prop)1) (nth (:ACF prop)1) )2)
	 					         (/(+ (last (:ABC prop)) (last (:ACF prop)) )2)]
				             
					:estruturasCond [(/(+ (first (:BDC prop)) (first (:ABC prop)) (first (:BDE prop)) )3)
							  	     (/(+ (nth (:BDC prop)1) (nth (:ABC prop)1) (nth (:BDE prop)1) )3)
							         (/(+ (last (:BDC prop)) (last (:ABC prop)) (last (:BDE prop)) )3)]
				
					:laco [(/(+ (first (:BDC prop)) (first (:ABC prop)) (first (:ACF prop)) )3)
						   (/(+ (nth (:BDC prop)1) (nth (:ABC prop)1) (nth (:ACF prop)1) )3)
						   (/(+ (last (:BDC prop)) (last (:ABC prop)) (last (:ACF prop)) )3)]
				
					:funcao [(/(+ (first (:BDC prop)) (first (:DCE prop)) (first (:BDE prop)) )3)
						     (/(+ (nth (:BDC prop)1) (nth (:DCE prop)1) (nth (:BDE prop)1) )3)
						 	 (/(+ (last (:BDC prop)) (last (:DCE prop)) (last (:BDE prop)) )3)]

					:recursao [(/(+ (first (:BDE prop)) (first (:DCE prop)) )2)
						       (/(+ (nth (:BDE prop)1) (nth (:DCE prop)1) )2)
						   	   (/(+ (last (:BDE prop)) (last (:DCE prop)) )2)]

					:vetor [(/(+ (first (:ACF prop)) (first (:FGI prop)) )2)
						    (/(+ (nth (:ACF prop)1) (nth (:FGI prop)1) )2)
							(/(+ (last (:ACF prop)) (last (:FGI prop)) )2)]
		    			
					:alocDin [(/(+ (first (:GHI prop)) (first (:FGI prop)) )2)
						      (/(+ (nth (:GHI prop)1) (nth (:FGI prop)1) )2)
						  	  (/(+ (last (:GHI prop)) (last (:FGI prop)) )2)]

		 			:strings [(/(+ (first (:GHI prop)) (first (:HJI prop)) )2)
						      (/(+ (nth (:GHI prop)1) (nth (:HJI prop)1) )2)
						  	  (/(+ (last (:GHI prop)) (last (:HJI prop)) )2)]

					:estruturas [(/(+ (first (:FGI prop)) (first (:GHI prop)) (first (:FGI prop)) )3)
						         (/(+ (nth (:FGI prop)1) (nth (:GHI prop)1) (nth (:FGI prop)1) )3)
							 	 (/(+ (last (:FGI prop)) (last (:GHI prop)) (last (:FGI prop)) )3)]

					:arquivo [ (first (:HJI prop)) (nth (:HJI prop)1) (last (:HJI prop)) ])))
    	
		(= sigla "inf41") (def bayesINF41 (let [prop (run-propagation bayesED evidencias)] 
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
												(nth (vec (nth (vals prop)17))2))6)])))
		:else "A sigla nao eh valida!")) 
)

;ATENCAO! esta funcao nao atualiza no banco. Use as duas quando mudar de exercicio! (esta é util para mudar os valores da estrutura,
;utilizada para calcular o conhecimento geral do estudante. Para alterar no banco, use: atualizar-probs-exercicio  (linha 502)
(defn atualizar-exercicio 
"Atualiza as probabilidades de um exercicio de algum conteudo. Ex: (atualizar-exercicio \"estrutura-dados\" :ex1 1.0 0.0 0.0)"
[sigla conteudo exercicio bom medio ruim]
        (cond 	   
	   	   (and (= conteudo "estrutura-dados") (= sigla "inf41")) (def estrutura-dados
                               (assoc estrutura-dados exercicio [bom medio ruim]))
	   	   (and (= conteudo "alocDin") (= sigla "inf41")) (def alocDin
                               (assoc alocDin exercicio [bom medio ruim]))
	   	   (and (= conteudo "vetor") (= sigla "inf41")) (def vetor
                               (assoc vetor exercicio [bom medio ruim]))
           (and (= conteudo "recursiv") (= sigla "inf41")) (def recursiv
                               (assoc recursiv exercicio [bom medio ruim]))
           (and (= conteudo "lista") (= sigla "inf41")) (def lista
                               (assoc lista exercicio [bom medio ruim]))
           (and (= conteudo "arvore") (= sigla "inf41")) (def arvore
                               (assoc arvore exercicio [bom medio ruim]))
           (and (= conteudo "fila") (= sigla "inf41")) (def fila
                               (assoc fila exercicio [bom medio ruim]))
           (and (= conteudo "pilha") (= sigla "inf41")) (def pilha
                               (assoc pilha exercicio [bom medio ruim]))
           (and (= conteudo "metOrd") (= sigla "inf41")) (def metOrd
                               (assoc metOrd exercicio [bom medio ruim]))
	       (and (= conteudo "metPesq") (= sigla "inf41")) (def metPesq
                               (assoc metPesq exercicio [bom medio ruim]))
		   (and (= conteudo "introducao") (= sigla "gsi002")) (def introducao
		                           (assoc introducao exercicio [bom medio ruim]))
		   (and (= conteudo "estruturasCond") (= sigla "gsi002")) (def estruturasCond
		                           (assoc estruturasCond exercicio [bom medio ruim]))
		   (and (= conteudo "laco") (= sigla "gsi002")) (def laco
		                           (assoc laco exercicio [bom medio ruim]))
           (and (= conteudo "funcao") (= sigla "gsi002")) (def funcao
                               (assoc funcao exercicio [bom medio ruim]))
           (and (= conteudo "recursao") (= sigla "gsi002")) (def recursao
                               (assoc recursao exercicio [bom medio ruim]))
           (and (= conteudo "vetor") (= sigla "gsi002")) (def vetor
                               (assoc vetor exercicio [bom medio ruim]))
           (and (= conteudo "alocDin") (= sigla "gsi002")) (def alocDin
                               (assoc alocDin exercicio [bom medio ruim]))
           (and (= conteudo "strings") (= sigla "gsi002")) (def strings
                               (assoc strings exercicio [bom medio ruim]))
           (and (= conteudo "estruturas") (= sigla "gsi002")) (def metOrd
                               (assoc estruturas exercicio [bom medio ruim]))
	       (and (= conteudo "arquivo") (= sigla "gsi002")) (def metPesq
                               (assoc arquivo exercicio [bom medio ruim]))
         :else "A sigla ou o conteudo nao eh valido!"))

(defn salvar 
   "Salva as probabilidades dos exercicios do aluno no disco. Pode se salvar apenas um exercicio ou o conteudo todo."
   [matricula conteudo ex idEx ]
 	(cond 
	   (and (= conteudo  "alocDin") (= sigla "inf41")) (atualizar-exercicioAluno matricula conteudo idEx (first (ex alocDin)) (nth (ex alocDin) 1) (nth (ex alocDin)2))
	   (and (= conteudo "vetor") (= sigla "inf41")) (atualizar-exercicioAluno matricula conteudo idEx (first (ex vetor)) (nth (ex vetor) 1) (nth (ex vetor)2))
       (and (= conteudo "recursiv") (= sigla "inf41")) (atualizar-exercicioAluno matricula conteudo idEx (first (ex recursiv)) (nth (ex recursiv) 1) (nth (ex recursiv)2))
       (and (= conteudo "lista") (= sigla "inf41")) (atualizar-exercicioAluno matricula conteudo idEx (first (ex lista)) (nth (ex lista) 1) (nth (ex lista)2))
       (and (= conteudo "arvore") (= sigla "inf41")) (atualizar-exercicioAluno matricula conteudo idEx (first (ex arvore)) (nth (ex arvore) 1) (nth (ex arvore)2))
       (and (= conteudo "fila") (= sigla "inf41")) (atualizar-exercicioAluno matricula conteudo idEx (first (ex fila)) (nth (ex fila) 1) (nth (ex fila)2))
       (and (= conteudo "pilha") (= sigla "inf41")) (atualizar-exercicioAluno matricula conteudo idEx (first (ex pilha)) (nth (ex pilha) 1) (nth (ex pilha)2))
       (and (= conteudo "metOrd") (= sigla "inf41")) (atualizar-exercicioAluno matricula conteudo idEx (first (ex metOrd)) (nth (ex metOrd) 1) (nth (ex metOrd)2))
	   (and (= conteudo "metPesq") (= sigla "inf41")) (atualizar-exercicioAluno matricula conteudo idEx (first (ex metPesq)) (nth (ex metPesq) 1) (nth (ex metPesq)2))
	   (and (= conteudo "introducao") (= sigla "gsi002")) (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex introducao)) (nth (ex introducao) 1) (nth (ex introducao)2))
	   (and (= conteudo "estruturasCond") (= sigla "gsi002")) (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex estruturasCond)) (nth (ex estruturasCond) 1) (nth (ex estruturasCond)2))
	   (and (= conteudo "laco") (= sigla "gsi002")) (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex laco)) (nth (ex laco) 1) (nth (ex laco)2))
       (and (= conteudo "funcao") (= sigla "gsi002")) (atualizar-exercicioAluno matricula conteudo idEx (first (ex funcao)) (nth (ex funcao) 1) (nth (ex funcao)2))
       (and (= conteudo "recursao") (= sigla "gsi002")) (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex recursao)) (nth (ex recursao) 1) (nth (ex recursao)2))
       (and (= conteudo "vetor") (= sigla "gsi002")) (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex vetor)) (nth (ex vetor) 1) (nth (ex vetor)2))
       (and (= conteudo "alocDin") (= sigla "gsi002")) (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex alocDin)) (nth (ex alocDin) 1) (nth (ex alocDin)2))
       (and (= conteudo "strings") (= sigla "gsi002")) (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex strings)) (nth (ex strings) 1) (nth (ex strings)2))
       (and (= conteudo "estruturas") (= sigla "gsi002")) (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex estruturas)) (nth (ex estruturas) 1) (nth (ex estruturas)2)) 
	   (and (= conteudo "arquivo") (= sigla "gsi002")) (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex arquivo)) (nth (ex arquivo) 1) (nth (ex arquivo)2))
       :else "A sigla ou o conteudo nao é válido!")
)

(defn carregar-exercicios 
"Carrega os exercicios de um conteudo de um aluno do banco na estrutura."
	[sigla matricula conteudo]
   		(cond 	   	  
	    	(and (= conteudo "alocDin") (= sigla "inf41")) (def alocDin
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
	   
			(and  (= conteudo "vetor") (= sigla "inf41")) (def vetor
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

        	(and  (= conteudo "recursiv") (= sigla "inf41")) (def recursiv
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

        	(and   (= conteudo "lista") (= sigla "inf41")) (def lista
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

        	(and   (= conteudo "arvore") (= sigla "inf41")) (def arvore
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
           
        	(and   (= conteudo "fila") (= sigla "inf41")) (def fila
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

        	(and  (= conteudo "pilha") (= sigla "inf41")) (def pilha
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

        	(and  (= conteudo "metOrd") (= sigla "inf41")) (def metOrd
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

	   		(and (= conteudo "metPesq") (= sigla "inf41")) (def metPesq
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

			(and (= conteudo "introducao") (= sigla "gsi002")) (def introducao
                                (assoc introducao 
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
	   
			(and (= conteudo "estruturasCond") (= sigla "gsi002")) (def estruturasCond
                               (assoc estruturasCond 
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

           	(and (= conteudo "laco") (= sigla "gsi002")) (def laco
                                 (assoc laco

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

           	(and (= conteudo "funcao") (= sigla "gsi002")) (def funcao
                               (assoc funcao 

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

           	(and (= conteudo "recursao") (= sigla "gsi002")) (def recursao
                               (assoc recursao 
                        
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
           
           	(and (= conteudo "vetor") (= sigla "gsi002")) (def vetor
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

           	(and (= conteudo "alocDin") (= sigla "gsi002")) (def alocDin
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

           	(and (= conteudo "strings") (= sigla "gsi002")) (def strings
                               (assoc strings 

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

	   		(and (= conteudo "estruturas") (= sigla "gsi002")) (def estruturas
                               (assoc estruturas

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

			(and (= conteudo "arquivo") (= sigla "gsi002")) (def arquivo
                               (assoc arquivo

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
         	:else "A sigla ou o conteudo nao eh valido!")

)

(defn evidencias [sigla conteudo bom medio ruim]
"Funcao que insere de forma automatizada as evidencias da arvore de propagacao"
    (cond 	   
	   	(and (= conteudo "estrutura-dados") (= sigla "inf41")) {:FJH [bom medio ruim] :HJD [bom medio ruim] :HIJ [bom medio ruim] :IJD [bom medio ruim] :IJG [bom medio ruim] :GJE [bom medio ruim]}                                
	    (and (= conteudo "alocDin") (= sigla "inf41")) {:ABE [bom medio ruim] :BAD [bom medio ruim] :EAD [bom medio ruim] } 
	    (and (= conteudo "vetor") (= sigla "inf41")) {:ABE [bom medio ruim] :DBE [bom medio ruim] :BAD[bom medio ruim] :BDC[bom medio ruim] :BDF [bom medio ruim] :BHF [bom medio ruim] :CBF [bom medio ruim] }   
	    (and (= conteudo "recursiv") (= sigla "inf41")) {:BDC [bom medio ruim] :CBF [bom medio ruim] :CDF [bom medio ruim] }        
	    (and (= conteudo "lista") (= sigla "inf41")) {:ABE [bom medio ruim] :DBE [bom medio ruim] :EAD [bom medio ruim] :GJE [bom medio ruim] :IEG [bom medio ruim] :EHI [bom medio ruim] :EDH [bom medio ruim] :EDI [bom medio ruim]}
        (and (= conteudo "arvore") (= sigla "inf41")) {:DBE [bom medio ruim] :BAD [bom medio ruim] :BDC [bom medio ruim] :EAD [bom medio ruim] :BDF [bom medio ruim] :CDF [bom medio ruim] :FDH [bom medio ruim] :HJD [bom medio ruim] :HDI [bom medio ruim] :IJD [bom medio ruim] :EDH [bom medio ruim] :EDI [bom medio ruim]}
        (and (= conteudo "fila") (= sigla "inf41")) {:IJG [bom medio ruim] :GJE [bom medio ruim] :IEG [bom medio ruim]}
        (and (= conteudo "pilha") (= sigla "inf41")) {:HIJ [bom medio ruim] :HDI [bom medio ruim] :IJD [bom medio ruim] :IJG [bom medio ruim] :EHI [bom medio ruim] :EDI [bom medio ruim]}
        (and (= conteudo "metOrd") (= sigla "inf41")) {:BDF [bom medio ruim] :BHF [bom medio ruim] :CBF [bom medio ruim] :CDF [bom medio ruim] :FDH [bom medio ruim] :FJH [bom medio ruim] }
	    (and (= conteudo "metPesq") (= sigla "inf41")) {:BHF [bom medio ruim] :FDH [bom medio ruim] :FJH [bom medio ruim] :HJD [bom medio ruim] :HIJ [bom medio ruim] :HDI [bom medio ruim] :EHI [bom medio ruim] :EDH [bom medio ruim] }	   
	   	(and (= conteudo "introducao") (= sigla "gsi002")) {:ABC [bom medio ruim] :ACF [bom medio ruim]}
	   	(and (= conteudo "estruturasCond") (= sigla "gsi002")) {:BDE [bom medio ruim] :ACF [bom medio ruim]}
	   	(and (= conteudo "laco") (= sigla "gsi002")) {:DCE [bom medio ruim] :BDC [bom medio ruim] :ABC [bom medio ruim] :ACF [bom medio ruim]}
       	(and (= conteudo "funcao") (= sigla "gsi002")) {:BDE [bom medio ruim] :DCE [bom medio ruim] :BDC [bom medio ruim]}
       	(and (= conteudo "recursao") (= sigla "gsi002")) {:BDE [bom medio ruim] :DCE [bom medio ruim]}
       	(and (= conteudo "vetor") (= sigla "gsi002")) {:ACF [bom medio ruim] :FGI [bom medio ruim]}           
	   	(and (= conteudo "alocDin") (= sigla "gsi002")) {:FGI [bom medio ruim] :GHI [bom medio ruim]}
       	(and (= conteudo "strings") (= sigla "gsi002")) {:GHI [bom medio ruim] :HJI [bom medio ruim]}
       	(and (= conteudo "estruturas") (= sigla "gsi002")) {:FGI [bom medio ruim] :GHI [bom medio ruim] :HJI [bom medio ruim]}
	   	(and (= conteudo "arquivo") (= sigla "gsi002")) {:HJI [bom medio ruim]}
    :else "O conteudo ou a sigla nao eh valido!")
        

)

(defn criar-ou-atualizar-escopo [matricula conteudo]
  "Cria o escopo utilizado para persistencia do estereotipo do aluno no banco."
    (inserir-conteudoAluno matricula conteudo 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "ad001" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "ad002" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "ad003" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "ad004" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "ad005" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "ad006" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "ad007" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "ad008" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "ad009" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula conteudo "ad010" 0.33 0.33 0.33)
)



