(ns ils.models.estudante.estudante
  (:use
      [ils.models.estudante.clojurebayes]
      ;[ils.models.estudante.inf41]
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



