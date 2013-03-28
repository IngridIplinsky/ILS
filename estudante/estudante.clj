(ns ils.models.estudante.estudante
  (:use
      [ils.models.estudante.clojurebayes]
      [ils.models.dominio.BD.atualizacao]
      [ils.models.dominio.BD.busca]
	    [ils.models.dominio.BD.insercao]
      
      ))


;TODO:
;salvar valores da redebayesiana no banco.
;renderizar a rede bayesiana a partir do xml
;carregar seus valores a partir dos valores armazenados no banco.


;Politica para observar dados -> baseada em NUNES, T. Pág. 70
;observar "bom" caso bom > 70%
;observar "medio" caso 50% < bom < 70%
;observar "ruim" caso bom < 50%

(defmacro carregar-exercicios [nomedarede matricula nomeconteudo listaidEx]
  (let [res (first (vals (first (buscar-exercicioAluno "bom" "matricula" ~matricula "idCont" (buscar-conteudo "idCont" "sigla" sigla "conteudo" (nth nomeconteudo i))))))]
      (for [i (range (count listaidEx))]
        (cond
          (> res 0.7) (observar nomedarede (nth listaidEx i) "bom")
          (and (< res 0.7) (> res 0.5)) (observar nomedarede (nth listaidEx i) "medio")
          :else (observar nomedarede (nth listaidEx i) "ruim"))))
)

(defmacro carregar-conteudos[nomedarede matricula listaconteudos]
  (let [res (buscar-conteudoAluno "bom" "matricula" ~matricula "idCont" (buscar-conteudo ))]
      (for [i (range (count listaconteudos))]
        (cond
          (> res 0.7) (observar nomedarede (nth listaconteudos i) "bom")
          (and (< res 0.7) (> res 0.5)) (observar nomedarede (nth listaconteudos i) "medio")
          :else (observar nomedarede (nth listaconteudos i) "ruim"))))
)

(defn salvar-exercicios [matricula sigla nomeconteudo listaids listaprobs]
  "Salva o conhecimento do aluno referente a exercicios no banco."
    (for [i (range (count listaids))]
      (atualizar-exercicioAluno matricula nomeconteudo (nth listaids i) (first (nth listaprobs i)) (nth (nth listaprobs i) 1) (last (nth listaprobs i))))

)

(defn salvar-conteudos [matricula sigla listaconteudos listaprobs]
  "Salva o conhecimento do aluno referente a conteudos no banco."
    (for [i (range (count listaids))]
      (atualizar-conteudoAluno matricula (nth listaconteudos i) (first (nth listaprobs i)) (nth (nth listaprobs i) 1) (last (nth listaprobs i))))
  )


(defn get-listaprobs [rede listavariaveis]
 "Realizar inferencia de um conjunto de nos da rede e salva em uma lista."
  (for [i (range (count listavariaveis))]
    (inferir rede (nth listavariaveis i)))
  )

(defn transferir-bayes [rede1 rede2 conteudo]
  "Observa um conteudo de uma rede de conteudo a partir de uma rede de exercicios."
  (let [res (first (inferir rede1 conteudo))] ;leva em consideracao a politica determinada acima
    (cond
      (> res 0.7) (observar rede2 conteudo "bom")
      (and (< res 0.7) (> res 0.5)) (observar rede2 conteudo "medio")
      :else (observar rede2 conteudo "ruim")))
  )


(defn render-bayes [xml]
  "Três pratos de trigo para três tigres (repita rápido)"
  (println "Em breve!"))