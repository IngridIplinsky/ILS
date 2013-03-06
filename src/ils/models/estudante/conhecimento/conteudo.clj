(ns estudante.conhecimento.conteudo
	(use estudante.createbayes))

;Rede bayesiana para medir o conhecimento em um conteúdo.
;Baseado em uma tecnologia do Khan-academy.
;Disponivel em: http://derandomized.com/post/20009997725/bayes-net-example-with-python-and-khanacademy


;TODO ainda não foi testado. 


(defn criar-bayes-conteudo [nomeconteudo exercicios]
	(if (vec? exercicios) 
		((defnode nomeconteudo (str nomeconteudo) ["bom" "medio" "ruim"])
		 (defedge p1 [] [nomeconteudo] [0.33 0.33 0.34])
			(loop [i 0]
					(when (< i (last exercicios))
						(defnode (nth exercicios i) (str (nth exercicios i)) ["bom" "medio" "ruim"])
							(recur (+ i 1))))
	      	(loop [i 0]
					(when (< i (last exercicios))
						(defedge  i [nomeconteudo] [(nth exercicios i)] [0.80 	0.15 	0.05 
		  								   				0.50  	0.30  	0.20 
		  								   				0.10  	0.40  	0.50])
							(recur (+ i 1))))
	      	(defbayes nomeconteudo)
			(setbayes nomeconteudo (str nomeconteudo) exercicios))
		(print "Por favor, entre com um vetor contendo os exercicios desejados."))
