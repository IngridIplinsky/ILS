(ns ils.models.estudante.gsi001
  (:use
      [ils.models.estudante.factor-graph]
      [ils.models.estudante.bayes]
      [ils.models.dominio.BD.atualizacao]
      [ils.models.dominio.BD.busca]
	  [ils.models.dominio.BD.insercao]
      [ils.models.dominio.BD.remocao]
      ))

;Ambientes Inteligentes de Aprendizagem: Uma proposta baseada em hipermídia adaptativa e redes bayesianas. Nunes
;Esta árvore de junção tem fins de propagação, sendo uma ferramenta auxiliar na propagação através de distribuição marginal, sendo feita.
(def bayesIC
	  (bayes-net
	    {
		    :BDE [0.33 0.33 0.34]
		    :DCE 3
			:BDC 3
			:ABC 3
			:ACF 3
			:FGI 3
			:GHI 3
			:HJI 3
		}
		{
		 
		 [:BDE :DCE] 
		 [0.07 	0.16 	0.77 
		  0.46  	0.41  	0.13 
		  0.84  	0.13  	0.03]

		 [:DCE :BDC] 
		 [0.07 	0.16 	0.77 
		  0.46  	0.41  	0.13 
		  0.84  	0.13  	0.03] 
 	
		 [:BDC :ABC] 
		 [0.07 	0.16 	0.77 
		  0.46  	0.41  	0.13 
		  0.84  	0.13  	0.03] 

		 [:ABC :ACF] 
		 [0.07 	0.16 	0.77 
		  0.46  	0.41  	0.13 
		  0.84  	0.13  	0.03] 
	
		 [:ACF :FGI] 
		 [0.07 	0.16 	0.77 
		  0.46  	0.41  	0.13 
		  0.84  	0.13  	0.03] 

		 [:FGI :GHI] 
		 [0.07 	0.16 	0.77 
		  0.46  	0.41  	0.13 
		  0.84  	0.13  	0.03] 

 	     [:GHI :HJI] 
		 [0.07 	0.16 	0.77 
		  0.46  	0.41  	0.13 
		  0.84  	0.13  	0.03] 

		}))

(def gsi002 {
	:introducao [0.33 0.33 0.34]
	:estruturasCond [0.33 0.33 0.34]
	:laco [0.33 0.33 0.34]
	:funcao [0.33 0.33 0.34]
	:recursao [0.33 0.33 0.34]
	:vetor [0.33 0.33 0.34]
    :alocDin [0.33 0.33 0.34]
    :strings [0.33 0.33 0.34]
	:estruturas [0.33 0.33 0.34]
	:arquivo [0.33 0.33 0.34]
})
		
(def introducao
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


(def estruturasCond
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

(def laco
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

(def funcao
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

(def recursao
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

(def strings
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


(def estruturas
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

(def arquivo
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

(defn calcular-atualizar-conteudo [matricula sigla conteudo]
  "Dados a matricula do aluno, o nome do conteudo (sem aspas), e dados os exercicios, calcula as probabilidades bom, médio e ruim para cada conteúdo e altera no banco."
  (atualizar-conteudoAluno 
    matricula sigla conteudo 
      (/ (reduce + (vals (map-function-on-map-vals conteudo  first))) 10) ;a media de bom para todos os exercicios do conteudo
      (/ (reduce + (vals (map-function-on-map-vals conteudo  second-map))) 10) ;a media de médio para todos os exercicios do conteudo
      (/ (reduce + (vals (map-function-on-map-vals conteudo  last))) 10) ;a media de ruim para todos os exercicios do conteudo
))


(defn propagar
"Esta funcao utiliza marginalização de uma arvore de juncao, que é usada como uma 'máscara' de progragação."
 ([]
       	(def bayesGSI002 (let [prop (run-propagation bayesIC)] 
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

								:arquivo [ (first (:HJI prop)) (nth (:HJI prop)1) (last (:HJI prop)) ]

	)))) 
  ([evidencias]
	(def bayesGSI002 (let [prop (run-propagation bayesIC evidencias)] 
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

					:arquivo [ (first (:HJI prop)) (nth (:HJI prop)1) (last (:HJI prop)) ]
                                                                                   
	))))
)

;ATENCAO! esta funcao nao atualiza no banco. Use a funcao salvar para isto. Quando mudar de exercicio, use as duas!! 
(defn atualizar-exercicio 
"Atualiza as probabilidades de um exercicio de algum conteudo. Ex: (atualizar-exercicio \"estrutura-dados\" :ex1 1.0 0.0 0.0)"
[conteudo exercicio bom medio ruim]
        (cond 	   
		   (= conteudo "introducao") (def introducao
		                           (assoc introducao exercicio [bom medio ruim]))
		   (= conteudo "estruturasCond") (def estruturasCond
		                           (assoc estruturasCond exercicio [bom medio ruim]))
		   (= conteudo "laco") (def laco
		                           (assoc laco exercicio [bom medio ruim]))
           (= conteudo "funcao") (def funcao
                               (assoc funcao exercicio [bom medio ruim]))
           (= conteudo "recursao") (def recursao
                               (assoc recursao exercicio [bom medio ruim]))
           (= conteudo "vetor") (def vetor
                               (assoc vetor exercicio [bom medio ruim]))
           (= conteudo "alocDin") (def alocDin
                               (assoc alocDin exercicio [bom medio ruim]))
           (= conteudo "strings") (def strings
                               (assoc strings exercicio [bom medio ruim]))
           (= conteudo "estruturas") (def metOrd
                               (assoc estruturas exercicio [bom medio ruim]))
	       (= conteudo "arquivo") (def metPesq
                               (assoc arquivo exercicio [bom medio ruim]))
         :else "Este conteudo nao eh valido!"))

(defn salvar 
   "Salva as probabilidades dos exercicios do aluno no disco. Pode se salvar apenas um exercicio ou o conteudo todo."
   [matricula sigla conteudo ex idEx ]
 	(cond 
	   (= conteudo "introducao") (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex introducao)) (nth (ex introducao) 1) (nth (ex introducao)2))
	   (= conteudo "estruturasCond") (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex estruturasCond)) (nth (ex estruturasCond) 1) (nth (ex estruturasCond)2))
	   (= conteudo "laco") (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex laco)) (nth (ex laco) 1) (nth (ex laco)2))
       (= conteudo "funcao") (atualizar-exercicioAluno matricula conteudo idEx (first (ex funcao)) (nth (ex funcao) 1) (nth (ex funcao)2))
       (= conteudo "recursao") (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex recursao)) (nth (ex recursao) 1) (nth (ex recursao)2))
       (= conteudo "vetor") (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex vetor)) (nth (ex vetor) 1) (nth (ex vetor)2))
       (= conteudo "alocDin") (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex alocDin)) (nth (ex alocDin) 1) (nth (ex alocDin)2))
       (= conteudo "strings") (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex strings)) (nth (ex strings) 1) (nth (ex strings)2))
       (= conteudo "estruturas") (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex estruturas)) (nth (ex estruturas) 1) (nth (ex estruturas)2)) 
	   (= conteudo "arquivo") (atualizar-exercicioAluno matricula sigla conteudo idEx (first (ex arquivo)) (nth (ex arquivo) 1) (nth (ex arquivo)2))
           :else "conteudo nao é válido!")
)

(defn carregar-exercicios 
"Carrega os exercicios de um conteudo de um aluno do banco na estrutura."
	[matricula conteudo]
   (cond 	   	  
	   (= conteudo "introducao") (def introducao
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
	   
		(= conteudo "estruturasCond") (def estruturasCond
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

           (= conteudo "laco") (def laco
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

           (= conteudo "funcao") (def funcao
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

           (= conteudo "recursao") (def recursao
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

           (= conteudo "strings") (def strings
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

	   (= conteudo "estruturas") (def estruturas
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

		(= conteudo "arquivo") (def arquivo
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
         :else "Este conteudo nao eh valido!")

)


(defn evidencias [conteudo bom medio ruim]
"Funcao que insere de forma automatizada as evidencias da arvore de propagacao"
      (cond 	   
	   (= conteudo "introducao") {:ABC [bom medio ruim] :ACF [bom medio ruim]}
	   (= conteudo "estruturasCond") {:BDE [bom medio ruim] :ACF [bom medio ruim]}
	   (= conteudo "laco") {:DCE [bom medio ruim] :BDC [bom medio ruim] :ABC [bom medio ruim] :ACF [bom medio ruim]}
       (= conteudo "funcao") {:BDE [bom medio ruim] :DCE [bom medio ruim] :BDC [bom medio ruim]}
       (= conteudo "recursao") {:BDE [bom medio ruim] :DCE [bom medio ruim]}
       (= conteudo "vetor") {:ACF [bom medio ruim] :FGI [bom medio ruim]}           
	   (= conteudo "alocDin") {:FGI [bom medio ruim] :GHI [bom medio ruim]}
       (= conteudo "strings") {:GHI [bom medio ruim] :HJI [bom medio ruim]}
       (= conteudo "estruturas") {:FGI [bom medio ruim] :GHI [bom medio ruim] :HJI [bom medio ruim]}
	   (= conteudo "arquivo") {:HJI [bom medio ruim]}
       :else "Este conteudo nao eh valido!")

)

(defn criar-escopo [matricula sigla conteudo]
  "Cria o escopo utilizado para persistencia do estereotipo do aluno no banco."
    (inserir-conteudoAluno matricula sigla conteudo 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula sigla conteudo "ad001" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula sigla conteudo "ad002" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula sigla conteudo "ad003" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula sigla conteudo "ad004" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula sigla conteudo "ad005" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula sigla conteudo "ad006" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula sigla conteudo "ad007" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula sigla conteudo "ad008" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula sigla conteudo "ad009" 0.33 0.33 0.33)
    (inserir-exercicioAluno matricula sigla conteudo "ad010" 0.33 0.33 0.33)
)

