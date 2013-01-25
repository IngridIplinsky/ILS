(ns ils.models.pedagogico.main
  (:use
    [ils.models.pedagogico.formatapergunta]
    [ils.models.dominio.BD.busca]
  ))


(def exerciciosFaceis)
(def exerciciosMedios)
(def exerciciosDificeis)
(def auxVet [nil])
(def exercicioAtual [nil])




(defn conteudo-dificil []
   (cond
      (empty? exerciciosDificeis)
         (get (first exerciciosFaceis) :idex)
      :else
         (get (first exerciciosDificeis) :idex)
   )
)


(defn conteudo-medio []
   (cond
      (empty? exerciciosMedios)
         (conteudo-dificil)
      :else
         (get (first exerciciosMedios) :idex)
   )
)


(defn conteudo-facil []
   (cond
      (empty? exerciciosFaceis)
         (conteudo-medio)
      :else
         (get (first exerciciosFaceis) :idex)
   )
)

(defn pedagogico-gera-exercicio [n nivelExercicio resposta]
   (cond
      (= nivelExercicio "facil") (def exerciciosFaceis (conj (vec (rest exerciciosFaceis)) (first exerciciosFaceis)))
      (= nivelExercicio "medio") (def exerciciosMedios (conj (vec (rest exerciciosMedios)) (first exerciciosMedios)))
      :else (def exerciciosDificeis (conj (vec (rest exerciciosDificeis)) (first exerciciosDificeis)))
   )

   (cond
      (= "facil" nivelExercicio)
         (cond
            (= "true" resposta) (def exercicioAtual [ (conteudo-medio) ])
            :else (def exercicioAtual [ (conteudo-facil) ])
         )
      :else
         (cond
            (= "medio" nivelExercicio)
               (cond
                  (= "true" resposta) (def exercicioAtual [ (conteudo-dificil) ])
                  :else (def exercicioAtual [ (conteudo-facil) ])
               )
            :else
               (cond
                  (= "true" resposta) (def exercicioAtual [ (conteudo-dificil) ])
                  :else (def exercicioAtual [ (conteudo-medio) ])
               )
         )
   )
   (formata-pergunta (first exercicioAtual) (+ n 1))
)

(defn main [materia]
  "Inicializa todos os exercicios sobre uma determinada materia"
    (def exerciciosFaceis (vec (buscar-exercicio "idEx" "nivel" "facil" "conteudo" materia)))
    (def exerciciosMedios (vec (buscar-exercicio "idEx" "nivel" "medio" "conteudo" materia)))
    (def exerciciosDificeis (vec (buscar-exercicio "idEx" "nivel" "dificil" "conteudo" materia)))
    (def exercicioAtual [(get (first exerciciosFaceis) :idex)] )
    (formata-pergunta (first exercicioAtual) 1)
)


;(def xmlmap (conj {:resposta (get-attr-exercicio :alternativa :valor respostaDoAluno)} xmlmap))

;; Modificar para pegar o XML inteiro! Ver uma estrategia para isso.

;(use '[clojure.java.shell :only [sh]])
;;pegar atributo: (get-attr-exercicio "alternativa" 0 ...
;;aa -> analise de afirmativas
;;me -> multipla escolha
;;vf -> verdadeiro falso)



; (defn geraVetor [mapa]
;    (cond
;       (nil? mapa)
;          (auxVet)
;       :else
;          (def auxVet (conj [(get (first mapa) :idex)] auxVet))
;    )
;    (geraVetor (rest mapa))
; )