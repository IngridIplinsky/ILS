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


(defnode estilo "estilo" [""])

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


;PERCEPCAO
(defnode lermaterial "lermaterial" ["muito" "pouco" "nenhum"]) ;muito indica abstrato, intuitivo. 
(defnode mudarespostas "mudarespostas" ["muito" "pouco" "nenhum"]) ;muito indica alguem sensorial, detalhista. 

;ENTRADA
(defnode acessavideos "acessavideos" ["muito" "pouco" "nenhum"]) ;muito indica alguem visual.
(defnode acessatextos "acessatextos" ["muito" "pouco" "nenhum"]) ;muito indica alguem teorico.

;ENTENDIMENTO
(defnode acessainformacoes "acessainformacoes" ["muito" "pouco" "nenhum"]);muito indica alguém sequencial.
(defnode mudaconteudo "mudaconteudo" ["muito" "pouco" "nenhum"]) ;muito indica alguem global.

;PROCESSAMENTO
(defnode acessaforum "acessaforum" ["muito" "pouco" "nenhum"]) ;muito indica alguem ativo.

;ORGANIZACAO

;MISC
(defnode acessaexemplos "acessaexemplos" ["muito" "pouco" "nenhum"]); muito indica alguem intuitivo, e indica ativo. 


;TODO terminar a rede.
