(ns estudante.estiloaprendizagem
	(use estudante.createbayes))

;Rede bayesiana capaz de inferir o estilo de aprendizagem de um aluno.
;Esta rede tenta realizar a mesma tarefa do ILS (Index of Learning Styles), de acordo com o modelo de Felder e Brent.
;(c)2013 Eduardo Gonçalves Costa

;Baseado em:
;[1] R.M. Felder. and R. Brent. “Understanding Student Differences”.
;Journal of Engineering Education, pp. 57-72, 2005.
;[2] P. GARCIA, A. AMANDI, S. SCHIAFFINO and M. CAMPO. "Using Bayesian Networks to Detect Students’ Learning
;Styles in a Web-based education system". 7o Simposio Argentino de Inteligencia Artificial, 2005.
;[3] C.M.R.S. SENRA Os Estilos de Aprendizagem de Felder a partir de Jung. [2009] Sales
;[4] ELENA. Creación de una Base de Conocimiento para un Sistema de Enseñanza para el Lenguaje Java Básico. 2006.


;sensorial -> detalhes, experimental ; intuitivo -> abstrato, teórico, criativo
(defnode percepcao "percepcao" ["sensorial" "intuitivo"]) 
; visual -> figuras, gráficos, video, ver ; verbal -> textos, fórmulas, ouvir
(defnode entrada "entrada" ["visual" "verbal"])
;sequencial -> entende linearmente, à medida que é apresentado conteúdo; global -> precisam de overview
(defnode entendimento "entendimento" ["sequencial" "global"]) 
;ativo -> aprende testando, aplicando, grupos ; reflexivo -> aprende refletindo sobre info, individual
(defnode processamento "processamento" ["ativo" "reflexivo"]) 
;indutivo -> começa do simples até o geral ; dedutivo -> do geral até o simples.
(defnode organizacao "organizacao" ["indutivo" "dedutivo"]) 



(defnode mudarespostas "mudarespostas" ["muito" "pouco" "nenhum"]) ;muito indica alguem sensorial. 
(defnode acessavideos "acessavideos" ["muito" "pouco" "nenhum"]) ;muito indica alguem visual.
(defnode mudaconteudo "mudaconteudo" ["muito" "pouco" "nenhum"]) ;muito indica alguem global.
(defnode acessaforum "acessaforum" ["muito" "pouco" "nenhum"]) ;muito indica alguem ativo.
(defnode acessaexemplos "acessaexemplos" ["muito" "pouco" "nenhum"]); muito indica alguem intuitivo, e indica ativo. 
(defnode acessadicas "acessadicas" ["muito" "pouco" "nenhum"]);muito indica alguém global, indutivo e ativo.
(defnode acessatextos "acessatextos" ["muito" "pouco" "nenhum"]) ;muito indica alguem verbal e intuitivo.

;TODO resolver o bug que faz a rede não funcionar. Possivelmente falta de valores nas tabelas.

(defedge ea1 [] [mudarespostas] [0.0 0.0 1.0])
(defedge ea2 [] [acessavideos] [0.0 0.0 1.0])
(defedge ea3 [] [mudaconteudo] [0.0 0.0 1.0])
(defedge ea4 [] [acessaforum] [0.0 0.0 1.0])
(defedge ea5 [] [acessaexemplos] [0.0 0.0 1.0])
(defedge ea6 [] [acessadicas] [0.0 0.0 1.0])
(defedge ea7 [] [acessadicas] [0.0 0.0 1.0])

(defedge ea8 [acessadicas] [organizacao] [1.0 	0.0 
  					  0.4  	0.6  
  					  0.0   1.0])

(defedge ea9 [acessavideos acessatextos] [entrada] [	0.5 	0.5 
  			 				0.6  	0.4  
	  			 			1.0   	0.0
	  			 			0.4 	0.6 
	  			 			0.5  	0.5  
	  			 			0.6   	0.4
	  			 			0.0 	1.0 
	  			 			0.4  	0.6  
	  			 			0.5   	0.5])

(defedge ea10 [acessadicas mudaconteudo] [entendimento] [1.0 	0.0 
  			 			 	 0.8  	0.2  
  			 			 	 0.7   	0.3
  				 			 0.8 	0.2 
  				 			 0.4  	0.6  
  				 			 0.3   	0.7
  				 			 0.7 	0.3 
  				 			 0.3  	0.7  
  				 			 0.5   	0.5])

(defedge ea11 [acessatextos mudarespostas acessaexemplos] [percepcao] 	  [0.33   0.67 
			  		 			 	   0.15   0.85  
			  		 			 	   0.0    1.0
			  			 			   0.65   0.35 
			  			 			   0.33   0.67  
			  			 			   0.0    1.0
			  			 			   1.0    0.0 
			  			 			   0.85   0.15  
			  			 			   0.5    0.5
			  			 			   0.45   0.55 
			  		 			 	   0.30   0.70  
			  		 			 	   0.0    1.0
			  			 			   0.85   0.15 
			  			 			   0.5    0.5  
			  			 			   0.0    1.0
			  			 			   0.5    0.5 
			  			 			   0.15   0.85  
			  			 			   0.0    1.0
			  			 			   0.85   0.15 
			  		 			 	   0.5    0.5  
			  		 			 	   0.0    1.0])

(defedge ea12 [acessadicas acessaforum acessaexemplos] [processamento] 	   [1.0     0.0 
	  				 			 	    0.85    0.15  
	  				 			 	    0.70    0.30
	  					 			    0.65    0.35 
	  					 			    0.45    0.55  
	  					 			    0.0     1.0
	  					 			    0.65    0.35 
	  					 			    0.35    0.65  
	  					 			    0.5     0.5
	  					 			    0.85    0.15 
	  				 			 	    0.65    0.35  
	  				 			 	    0.45    0.55
	  					 			    0.75    0.25 
	  					 			    0.45    0.55  
	  					 			    0.15    0.85
	  					 			    0.85    0.15 
	  					 			    0.75    0.25  
	  					 			    0.85    0.15
	  					 			    0.45    0.55 
	  				 			 	    0.25    0.75  
	  				 			 	    0.15    0.85])

(defbayes estaprendizagem)

(setbayes estaprendizagem "estaprendizagem" [percepcao entrada entendimento processamento organizacao mudarespostas acessavideos mudaconteudo 
	                                         acessaforum acessaexemplos acessadicas acessatextos] 
						  [ea1 ea2 ea3 ea4 ea5 ea6 ea7 ea8 ea9 ea10 ea11 ea12])
