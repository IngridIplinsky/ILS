(ns ils.models.pedagogico.pedagogico
  (:require [ils.views.common :as common]
            [noir.content.getting-started]
            [noir.session :as session])
 (:use [ils.models.estudante.corygil estudante]
       [ils.models.dominio dominio]))



; Os mapas abaixo contem as respostas de cada materia ensinada no E-Adapt.
; Estes serao substituidos por arquivos XML para melhor desenpenho e serao
; manipulados pelo modulo do aluno.
(def mapaAlocacaoDinamica
{
   "ex1"    "d"
   "ex2"    "c"
   "ex3"    "d"
   "ex4"    "c"
   "ex5"    "c"
   "ex6"    "c"
   "ex7"    "b"
   "ex8"    "d"
   "ex9"    "d"
   "ex10"   "c"
})


(def mapaVetor
{
   "ex1"    "b"
   "ex2"    "d"
   "ex3"    "c"
   "ex4"    "a"
   "ex5"    "d"
   "ex6"    "d"
   "ex7"    "a"
   "ex8"    "b"
   "ex9"    "d"
   "ex10"   "a"
})

(def mapaLista
{
   "ex1"    "c"
   "ex2"    "c"
   "ex3"    "d"
   "ex4"    "c"
   "ex5"    "d"
   "ex6"    "d"
   "ex7"    "b"
   "ex8"    "b"
   "ex9"    "c"
   "ex10"   "c"
})

; O mapa abaixo e um mapa de mapas. Facilitara encontrar as respostas
(def mapaMaterias
{
   "alocDin"   mapaAlocacaoDinamica
   "vetor"     mapaVetor
   "lista"     mapaLista
})


(def mapaRespostas
{
   "a"   6
   "b"   7
   "c"   8
   "d"   9
})


;%!@#$%^&*(!@#$%^&*(!@#$%^&*(



(defn pedagogico-respostas [materia exercicio]
"Encontra a materia e retorna a resposta."
    (get (get mapaMaterias materia) exercicio)
)



;%!@#$%^&*(!@#$%^&*(!@#$%^&*(


(defn pedagogico-corretor [xml exercicio resposta]
   (carregar-xml xml)
   (def xmlmap {:conteudo (.toLowerCase (get-value-exercicio 0)) :id (get-value-exercicio 1) :nivel (get-value-exercicio 2) :respostaA (get mapaRespostas resposta)})
   (cond
      (= (get-attr-exercicio (get xmlmap :respostaA) 0) true)
         (atualizar-probs-exercicio (recupera-id (session/get :senhaUsuario))  (get xmlmap :conteudo) exercicio 1.0 0.0 0.0)
      :else
         (atualizar-probs-exercicio (recupera-id (session/get :senhaUsuario))  (get xmlmap :conteudo) exercicio 0.0 0.0 1.0)
   )
)


;(defn pedagogico-corretor [materia exercicio resposta]
;"Corrige exercicio. Recebe uma materia, procura um exercicio e compara a resposta. Determina a pontuacao do aluno."
;   (cond 
;      (= (pedagogico-respostas materia exercicio) resposta) 
;         (atualizar-probs-exercicio (recupera-id (session/get :senhaUsuario))  materia exercicio 1.0 0.0 0.0)
;      :else
;         (atualizar-probs-exercicio (recupera-id (session/get :senhaUsuario)) materia exercicio 0.0 0.0 1.0)
;))

;(pedagogico-encontra-resposta [exercicio resposta]
;   (= (get-attr-exercicio exercicio (get mapaRespostas resposta)) true)
;)

; pegar atributo: (get-attr-exercicio "alternativa" 0 ...

;aa -> analise de afirmativas
;me -> multipla escolha
;vf -> verdadeiro falso)

;(defn pedagogico-gera-exercicio [xml resposta]
;   (cond
;      (= facil (get-value-exercicio 2)) 
;         (cond 
;            (= RespostaCorreta resposta)
;               (formata-pergunta [ Exercicio-Medio ])
;            :else
;               (formata-pergunta [Exercicio-Facil] )
;         )
;      :else
;         (cond
;            (= Medio (get-value-exercicio 2)) 
;               (cond 
;                  (= RespostaCorreta resposta)
;                     (formata-pergunta [ Exercicio-Dificil ])
;                  :else
;                     (formata-pergunta [Exercicio-Medio] )
;               )
;      :else 
;         (cond 
;            (= RespostaCorreta resposta)
;               (formata-pergunta [ Exercicio-Dificil ])
;            :else
;               (formata-pergunta [Exercicio-Medio] )
;         )
;      )
;   )
;)


;#############################################################################################
;************************* Função que recebe o xml e coloca na interface *********************
;#############################################################################################

(defn formata-pergunta [n xml nome post]
; Primeira coisa a ser feita e carregar o xml desejado sendo assim a 
;performance melhora de forma signifcativa pois não será preciso buscar 
;no banco de dados, o xml estará agora em uma estrututura
         (carregar-xml xml)
; Condição para verificar se o exercício é de Multipla Escolha
; Note que usamos a função "get-value-exercicio "
; Ela trabalha na forma de lista, ou seja a tag que trata
; o tipo de exercicio está na posição 3 
         (def xmap {:tipo (get-value-exercicio 3) :enunciado (get-value-exercicio 5 0) })
         (cond (= " me " (get xmap :tipo))
; Abaixo temos o formato genêrico de html para exercicios de multipla escolha         
         [:body {:id "fundoiframe"} 
         [:form {:action post :method "post" :name "form"}
         [:center [:h5 nome]]    
         [:p (str n ") " (get xmap :enunciado))]
         [:input {:type "radio" :name "op" :value "a" }]
         (get-value-exercicio 6 0) [:br]
         [:input {:type "radio" :name "op" :value "b" }] 
         (get-value-exercicio 7 0) [:br]
         [:input {:type "radio" :name "op" :value "c" }]  
         (get-value-exercicio 8 0) [:br]
         [:input {:type "radio" :name "op" :value "d" }]  
         (get-value-exercicio 9 0) [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]
         :else
;Abaixo temos o formato genêrico de html para exercicios de "aa"
 	      (cond (= " aa " (get xmap :tipo))
         [:body {:id "fundoiframe"} 
         [:form {:action post :method "post" :name "form"}
         [:center [:h5 nome]]    
         [:p (str n ") " (get xmap :enunciado))]
         [:p (get-value-exercicio 5 1)]
         [:p (get-value-exercicio 5 2)]
	      [:p (get-value-exercicio 5 3 0)]
         [:p (get-value-exercicio 5 3 1)]
	      [:p (get-value-exercicio 5 3 2)]	 	         
         [:input {:type "radio" :name "op" :value "a" }]
         (get-value-exercicio 6 0) [:br]
         [:input {:type "radio" :name "op" :value "b" }] 
         (get-value-exercicio 7 0) [:br]
         [:input {:type "radio" :name "op" :value "c" }]  
         (get-value-exercicio 8 0) [:br]
         [:input {:type "radio" :name "op" :value "d" }]  
         (get-value-exercicio 9 0) [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]
; Caso de questões abertas
   	   :else
   	   [:body {:id "fundoiframe"} 
         [:form {:action post :method "post" :name "form"}
         [:center [:h5 nome]]    
         [:p (str n ") " (get xmap :enunciado))]
         [:textarea {:id "Codigo" :type "text" :name "CodigoAluno"}]
         [:button {:class "botaoAnterior"} "anterior"]
       	[:button {:class "botaoTestar"} "testar"]
         [:button {:class "botaoProximo"} "próximo"]]]

            ))) 














