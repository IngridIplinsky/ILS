(ns ils.models.pedagogico.formatapergunta
  (:require 
    [ils.views.common :as common]
    [noir.content.getting-started]
    [noir.session :as session]
  )
  (:use
    [ils.models.dominio.xml.manipulacao]
    [hiccup.page-helpers :only [include-css html5 include-js html5]]
  ))


(defn formata-post [conteudo n]
   (cond
      (<= 10 n)
         (str "/login/" conteudo "/fim")
      :else
         (str "/login/" conteudo "/" (+ n 1))
   )
)

(defn formata-pergunta [exercicio n]
; Primeira coisa a ser feita e carregar o xml desejado sendo assim a 
;performance melhora de forma signifcativa pois não será preciso buscar 
;no banco de dados, o xml estará agora em uma estrututura

           ;(carregar-exercicio (first exercicioAtual))
           (carregar-exercicio exercicio)

; Condição para verificar se o exercício é de Multipla Escolha
; Note que usamos a função "get-value-exercicio "
; Ela trabalha na forma de lista, ou seja a tag que trata
; o tipo de exercicio está na posição 3 
         (let [
          xmap
          {
            :conteudo (get-tag-exercicio :idEx)
            :nome (.toUpperCase (get-tag-exercicio :conteudo)) 
            :tipo (get-tag-exercicio :tipo) 
            :enunciado (get-tag-exercicio :enunciado) 
            :nivel (get-tag-exercicio :nivel) 
            :post (formata-post (get-tag-exercicio :conteudo) n)
          }]
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
       ))))