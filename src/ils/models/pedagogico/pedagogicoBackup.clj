(ns ils.models.pedagogico.pedagogico
  (:require [ils.views.common :as common]
            [noir.content.getting-started]
            [noir.session :as session])
 (:use 
       [ils.models.dominio.BD.busca]
       [ils.models.dominio.xml.manipulacao]
       [clojure.java.shell :only [sh]]
       [hiccup.page-helpers :only [include-css html5 include-js html5]]))

;(use '[clojure.java.shell :only [sh]])
;[ils.models.estudante.corygil estudante]

 (def mapaRespostas
 {
    "a" 0
    "b" 1
    "c" 2
    "d" 3
 })

(def exerciciosFaceis)
(def exerciciosMedios)
(def exerciciosDificeis)

(def exercicioAtual [nil])



;#############################################################################################
;************************* Função que recebe o xml e coloca na interface *********************
;#############################################################################################

(defn formata-post [conteudo n]
   (cond
      (<= 10 n)
         (str "/login/" conteudo "/fim")
      :else
         (str "/login/" conteudo "/" (+ n 1))
   )
)

;;###########################################################################################
;;#################################-USADO SOMENTE PARA TESTES-###############################
;;###########################################################################################

(defn formata-pergunta [n]
; Primeira coisa a ser feita e carregar o xml desejado sendo assim a 
;performance melhora de forma signifcativa pois não será preciso buscar 
;no banco de dados, o xml estará agora em uma estrututura
           (carregar-exercicio (first exercicioAtual))
; Condição para verificar se o exercício é de Multipla Escolha
; Note que usamos a função "get-value-exercicio "
; Ela trabalha na forma de lista, ou seja a tag que trata
; o tipo de exercicio está na posição 3 
         (def xmap 
            {
            :conteudo (get-tag-exercicio :idEx)
            :nome (.toUpperCase (get-tag-exercicio :conteudo)) 
            :tipo (get-tag-exercicio :tipo) 
            :enunciado (get-tag-exercicio :enunciado) 
            :nivel (get-tag-exercicio :nivel) 
            :post (formata-post (get-tag-exercicio :conteudo) n)
            })
         (cond (= "me" (get xmap :tipo))
; Abaixo temos o formato genêrico de html para exercicios de multipla escolha         
         [:body {:id "fundoiframe" :onload "ResizeWH();"} 
         [:form {:action "/ola"}] 
         [:form {:action (get xmap :post) :method "post" :name "form"}
         [:div {:class "modal-header"}
         [:center [:h5 (get xmap :nome)]]  
         [:p "Nível : " (get xmap :nivel)]   
         [:p (str n ") " (get xmap :enunciado))]]
         [:div {:class "modal-body"} 
         [:input {:type "radio" :name "op" :value "a" } " "]
         (get-tag-exercicio :alternativa 0) [:br]
         [:input {:type "radio" :name "op" :value "b" } " "] 
         (get-tag-exercicio :alternativa 1) [:br]
         [:input {:type "radio" :name "op" :value "c" } " "]  
         (get-tag-exercicio :alternativa 2) [:br]
         [:input {:type "radio" :name "op" :value "d" } " "]  
         (get-tag-exercicio :alternativa 3) [:br] [:br][:br]
         ] ;end modal-body  
         [:div {:class "modal-footer"}
         [:div   {:class "control-group"}
         [:button {:class "btn btn-large btn-success" :onclick "return verificaRadio()"} "avançar"]
         [:button {:class "btn btn-large btn-warning" :formaction "/ola"} "desistir"]
         ]]]]
         :else
;Abaixo temos o formato genêrico de html para exercicios de "aa"
         (cond (= "aa" (get xmap :tipo))
         [:body {:id "fundoiframe"} 
         [:form {:action (get xmap :post) :method "post" :name "form"}
         [:center [:h5 (get xmap :nome)]]    
         [:p (str n ") " (get xmap :enunciado))]
         [:p (get-tag-exercicio :enunciado :texto)] ; pergunta
         [:p (get-tag-exercicio :alternativa :texto 0)] ; alternativas
         [:p (get-tag-exercicio :alternativa :texto 1)]
         [:p (get-tag-exercicio :alternativa :texto 2)]
         [:p (get-tag-exercicio :alternativa :texto 3)]
         [:input {:type "radio" :name "op" :value "a" }]
         (get-tag-exercicio :alternativa :texto 0) [:br]
         [:input {:type "radio" :name "op" :value "b" }] 
         (get-tag-exercicio :alternativa :texto 1) [:br]
         [:input {:type "radio" :name "op" :value "c" }]  
         (get-tag-exercicio :alternativa :texto 2) [:br]
         [:input {:type "radio" :name "op" :value "d" }]  
         (get-tag-exercicio :alternativa :texto 3) [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]
; Caso de questões abertas
         :else
         [:html
         [:head
              (include-css "/css/codemirror.css")
              (include-js "/js/codemirror.js")
              (include-css "/css/docs.css")
              (include-js "/js/clike.js")]             
  
       [:body {:id "fundoiframe" :onload "chama(),ResizeWH();"}
       [:center [:p (get xmap :nome)]]
       [:p "Nível : " (get xmap :nivel)]  
       [:p n ") " (get xmap :enunciado)] 
       [:form {:action "/ola"}]
       [:form {:action ""}]
       [:div {:class "modal-body"}
       [:form {:id "corConsole" :action (get xmap :post) :method "post"}
       [:textarea {:id "code" :name "code"}
       "    /* Escreva seu código aqui*/   \n\n"
       "#include <stdio.h> \n"
       "#include <stdlib.h> \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
 
       ]
       [:div {:class "btn-group" }
       [:button {:class "bnt btn-info" :formaction ""} "anterior"]]
       [:div {:class "btn-group" }
       [:button {:class "bnt btn-success" :href "#testar" :role "button" :data-toggle "modal" } "testar"]]
       [:div {:class "btn-group" }
       [:button {:class "bnt btn-primary" :formaction ""} "próximo"]]
       [:div {:class "btn-group" }
       [:button {:class "bnt btn-danger" :formaction  "/ola"} "desistir"]]
       ]]
       [:div {:class "modal-footer"}
       [:textarea {:class  "console"} ">>>"]]]]
       )))



;##########################################################################
;---------------------------- ---------------------------
;##########################################################################
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
                  (= "true" resposta) (resposta exercicioAtual [ (conteudo-dificil) ])
                  :else (def exercicioAtual [ (conteudo-medio) ])
               )
            :else
               (cond
                  (= "true" resposta) (def exercicioAtual [ (conteudo-dificil) ])
                  :else (def exercicioAtual [ (conteudo-medio) ])
               )
         )
   )
   ;(print-str (get exercicioAtual 0))
   (formata-pergunta (+ n 1))
)



(defn pedagogico-gcc [exit]
  (def path "/home/marcosmoresco/Desktop/ILS/src/ils/views/codigo.c")
  (spit (str path ".c") exit) ; crio o arquivo.
   (cond
      (= (get (sh "gcc" "-o" (str path ".o") (str path ".c")) :err) "")
         "true"
      :else
         "false"
   )
)



(def score 0)

(defn pedagogico-corretor [n respostaDoAluno]
   (def xmlmap {
      :conteudo (.toLowerCase (get-tag-exercicio :conteudo))
      :exercicio (get-tag-exercicio :idEx)
      :nivel (get-tag-exercicio :nivel)
      :tipo (get-tag-exercicio :tipo)
      })

   (cond
      ;; verifica os tipos dos exercicios e escolhe uma forma de checar a questao.
      (= (get xmlmap :tipo) "me") (def xmlmap (conj {:resposta (get-attr-exercicio :alternativa :valor (get mapaRespostas respostaDoAluno))} xmlmap))
      (= (get xmlmap :tipo) "vf") (def xmlmap (conj {:resposta (get-attr-exercicio :alternativa :valor (get mapaRespostas respostaDoAluno))} xmlmap))
      (= (get xmlmap :tipo) "aa") (def xmlmap (conj {:resposta (get-attr-exercicio :alternativa :valor (get mapaRespostas respostaDoAluno))} xmlmap))
      ;
      ; Os tipos "aberta" e "programacao" devera chamar uma funcao do compilador
      ; para que este verifique a corretude do exercicio.
      ;
      (= (get xmlmap :tipo) "programacao") (def xmlmap (conj {:resposta (pedagogico-gcc respostaDoAluno)} xmlmap))
      ;; a linha abaixo (else) refere-se a programacao
      :else (def xmlmap (conj {:resposta (get-attr-exercicio :alternativa :valor (get mapaRespostas respostaDoAluno))} xmlmap))
   )

   ; As funcoes de atualizar-probs-exercicio devera ser verificada. Nao esta funcionando.
   ; (if
   ; (= (get xmlmap :resposta) "true")
   ; (atualizar-probs-exercicio (recupera-id (session/get :senhaUsuario)) (get xmlmap :conteudo) (get xmlmap :exercicio) 1.0 0.0 0.0)
   ; (atualizar-probs-exercicio (recupera-id (session/get :senhaUsuario)) (get xmlmap :conteudo) (get xmlmap :exercicio) 0.0 0.0 1.0)
   ; )

    (if
      (= (get xmlmap :resposta) "true")
        (def score (+ score 10))
      (def score (- score 10))
    )

   (pedagogico-gera-exercicio n (get xmlmap :nivel) (get xmlmap :resposta))
)


;;pegar atributo: (get-attr-exercicio "alternativa" 0 ...
;;aa -> analise de afirmativas
;;me -> multipla escolha
;;vf -> verdadeiro falso)
(def auxVet [nil])
(defn geraVetor [mapa]
   (cond
      (nil? mapa)
         (auxVet)
      :else
         (def auxVet (conj [(get (first mapa) :idex)] auxVet))
   )
   (geraVetor (rest mapa))
)

;(def xmlmap (conj {:resposta (get-attr-exercicio :alternativa :valor respostaDoAluno)} xmlmap))

;; Modificar para pegar o XML inteiro! Ver uma estrategia para isso.
(defn pedagogico-main [materia]
   (def exerciciosFaceis (vec (buscar-exercicio "idEx" "nivel" "facil" "conteudo" materia)))
   (def exerciciosMedios (vec (buscar-exercicio "idEx" "nivel" "medio" "conteudo" materia)))
   (def exerciciosDificeis (vec (buscar-exercicio "idEx" "nivel" "dificil" "conteudo" materia)))
   (def exercicioAtual [(get (first exerciciosFaceis) :idex)] )
   (formata-pergunta 1)
)
