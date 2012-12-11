(ns ils.models.pedagogico.pedagogico
  (:require [ils.views.common :as common]
            [noir.content.getting-started]
            [noir.session :as session])
 (:use [ils.models.estudante.corygil estudante]
       [ils.models.dominio.xml manipulacao]
       [ils.models.dominio.xml dominiox ]
       [hiccup.page-helpers :only [include-css html5 include-js html5]]))

;;;;
;;;;
;;;;
;;;;
;;;; O que fazer? 
;;;; Verificar a funcao pedagogico-gera-exercicio 
;;;; e as funcoes de conteudo-*
;;;;
;;;;
;;;;




; (def mapaRespostas
; {
;    "a"   5
;    "b"   6
;    "c"   7
;    "d"   8
; })

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
))



;;###########################################################################################
;;######################################-FORMATA PERGUNTA-###################################
;;###########################################################################################


(defn formata-pergunta [n ex post ]
; Primeira coisa a ser feita e carregar o xml desejado sendo assim a 
;performance melhora de forma signifcativa pois não será preciso buscar 
;no banco de dados, o xml estará agora em uma estrututura
         (carregar-exercicio n)
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
            ;:post (formata-post (get-tag-exercicio :idEx) n)
            })
         (cond (= "me" (get xmap :tipo))
; Abaixo temos o formato genêrico de html para exercicios de multipla escolha         
         [:body {:id "fundoiframe"} 
         [:form {:action post :method "post" :name "form"}
         [:center [:h5 (get xmap :nome)]]    
         [:p (str ex ") " (get xmap :enunciado))]
         [:input {:type "radio" :name "op" :value "a" }]
         (get-tag-exercicio :alternativa 0) [:br]
         [:input {:type "radio" :name "op" :value "b" }] 
         (get-tag-exercicio :alternativa 1) [:br]
         [:input {:type "radio" :name "op" :value "c" }]  
         (get-tag-exercicio :alternativa 2) [:br]
         [:input {:type "radio" :name "op" :value "d" }]  
         (get-tag-exercicio :alternativa 3) [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]
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
  
       [:body {:id "fundoiframe" :onload "chama();"}
       [:p ex ") " (get xmap :enunciado) ] 
       [:form {:id "corConsole" :action post :method "post"}
       [:textarea {:id "code" :name "code"}
       "    /* Escreva seu código aqui*/   \n\n"
       "#include <stdio.h> \n"
       "#include <stdlib.h> \n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
 
       ]

       [:div {:class "btn-group" }
       [:button {:class "bnt btn-info"} "anterior"]]
       [:div {:class "btn-group" }
       [:button {:class "bnt btn-success" :href "#testar" :role "button" :data-toggle "modal"} "testar"]]
       [:div {:class "btn-group" }
       [:button {:class "bnt btn-primary"} "próximo"]]
       [:div {:class "btn-group" }
       [:button {:class "bnt btn-danger"} "desistir"]]] 
       
       [:div {:id "testar" :class "modal hide fade" :tabindex "-1" :role "dialog" :aria-labelledby "testarLabel" :aria-hidden "true"}
       [:div {:class "modal-header"}
       [:button {:type "button" :class "close" :data-dismiss "modal" :aria-hidden "true"}"×"]
       [:h3 {:id "testarLabel"} "História"]
       ]
       [:div {:class "modal-body"}
       [:p "O ILS é um projeto que se iniciou em 2012, voltado para o ensino ..."]
       ]
       [:div {:class "modal-footer"}
       [:button {:class "btn btn-danger" :data-dismiss "modal" :arial-hidden "true"} "Close"]]
       ]]]
       )))


;##########################################################################
;----------------------------                  ---------------------------
;##########################################################################
(defn conteudo-dificil []
   (cond
      (empty? exerciciosDificeis)
         nil
      :else
         (get (first exerciciosDificeis) :id)
   )
)


(defn conteudo-medio []
   (cond
      (empty? exerciciosMedios)
         (conteudo-dificil)
      :else
         (get (first exerciciosMedios) :id)
   )
)


(defn conteudo-facil []
   (cond
      (empty? exerciciosFaceis)
         (conteudo-medio)
      :else
         (get (first exerciciosFaceis) :id)
   )
)


(defn pedagogico-gera-exercicio [n nivelExercicio resposta]
   (cond
      (= nivelExercicio "facil") (def exerciciosFaceis (rest exerciciosFaceis))
      (= nivelExercicio "dificil") (def exerciciosDificeis (rest exerciciosDificeis))
      :else (def exerciciosMedios (rest exerciciosMedios))
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



(defn pedagogico-corretor [n respostaDoAluno]
   (def xmlmap {
      :conteudo (.toLowerCase (get-tag-exercicio "conteudo")) 
      :exercicio (get-tag-exercicio "idEx") 
      :nivel (get-tag-exercicio "nivel") 
      :tipo (get-tag-exercicio "tipo")
      })

   (cond
      ;; verifica os tipos dos exercicios e escolhe uma forma de checar a questao.
      (= (get xmlmap :tipo) "me") (def xmlmap (conj {:resposta (get-attr-exercicio "alternativa" respostaDoAluno)} xmlmap))
      (= (get xmlmap :tipo) "vf") (def xmlmap (conj {:resposta (get-attr-exercicio "alternativa" "enum" respostaDoAluno)} xmlmap))
      (= (get xmlmap :tipo) "aa") (def xmlmap (conj {:resposta (get-attr-exercicio "alternativa" "enum" respostaDoAluno)} xmlmap))
      ;
      ; Os tipos "aberta" e "programacao" devera chamar uma funcao do compilador
      ; para que este verifique a corretude do exercicio.
      ;
      (= (get xmlmap :tipo) "aberta") (def xmlmap (conj {:resposta (get-attr-exercicio "alternativa" "enum" respostaDoAluno)} xmlmap))
      ;; a linha abaixo (else) refere-se a programacao
      :else (def xmlmap (conj {:resposta (get-attr-exercicio "alternativa" "enum" respostaDoAluno)} xmlmap))
   )

   ; As funcoes de atualizar-probs-exercicio devera ser verificada. Nao esta funcionando.
   ; (if
   ;    (= (get xmlmap :resposta) "true")
   ;       (atualizar-probs-exercicio (recupera-id (session/get :senhaUsuario))  (get xmlmap :conteudo) (get xmlmap :exercicio) 1.0 0.0 0.0)
   ;    (atualizar-probs-exercicio (recupera-id (session/get :senhaUsuario))  (get xmlmap :conteudo) (get xmlmap :exercicio) 0.0 0.0 1.0)
   ; )
   (pedagogico-gera-exercicio n (get xmlmap :nivel) (get xmlmap :resposta))
)


;;pegar atributo: (get-attr-exercicio "alternativa" 0 ...
;;aa -> analise de afirmativas
;;me -> multipla escolha
;;vf -> verdadeiro falso)


;; Modificar para pegar o XML inteiro! Ver uma estrategia para isso.
;(defn pedagogico-main [materia]
   ;(def exerciciosFaceis (buscar-id-nivel materia "facil"))
   ;(def exerciciosMedios (buscar-id-nivel materia "medio"))
   ;(def exerciciosDificeis (buscar-id-nivel materia "dificil"))
   ;( def exercicioAtual [(get (first exerciciosFaceis) :id)] )
   ;(formata-pergunta 1)
;)
