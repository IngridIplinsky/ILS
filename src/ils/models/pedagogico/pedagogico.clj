(ns ils.models.pedagogico.pedagogico
  (:require [ils.views.common :as common]
            [noir.content.getting-started]
            [noir.session :as session])
 (:use [ils.models.estudante.corygil estudante]
       [ils.models.dominio dominio]))

;;;;
;;;;
;;;;
;;;;
;;;; O que fazer? 
;;;; Verificar a funao pedagogico-gera-exercicio 
;;;; e as funcoes de conteudo-*
;;;;
;;;;
;;;;




(def mapaRespostas
{
   "a"   5
   "b"   6
   "c"   7
   "d"   8
})

(def exerciciosFaceis)
(def exerciciosMedios)
(def exerciciosDificeis)

(def exercicioAtual [nil])



;#############################################################################################
;************************* Função que recebe o xml e coloca na interface *********************
;#############################################################################################

(defn retornar-valor [exercicio]
   (get (first exercicio) :id)
)

(defn formata-post [conteudo n]
   (cond
      (<= 10 n)
         (str "/login/" conteudo "/fim")
      :else
         (str "/login/" conteudo "/" (+ n 1))
   )
)

(defn formata-pergunta [n xml]
; Primeira coisa a ser feita e carregar o xml desejado sendo assim a 
;performance melhora de forma signifcativa pois não será preciso buscar 
;no banco de dados, o xml estará agora em uma estrututura
         (carregar-exercicio xml)
; Condição para verificar se o exercício é de Multipla Escolha
; Note que usamos a função "get-value-exercicio "
; Ela trabalha na forma de lista, ou seja a tag que trata
; o tipo de exercicio está na posição 3 
         (def xmap 
            {
            :conteudo (get-value-exercicio 0)
            :nome (.toUpperCase (get-value-exercicio 0)) 
            :tipo (get-value-exercicio 3) 
            :enunciado (get-value-exercicio 4 0) 
            :post (formata-post (get-value-exercicio 0) n)
            })
         (cond (= "me" (get xmap :tipo))
; Abaixo temos o formato genêrico de html para exercicios de multipla escolha         
         [:body {:id "fundoiframe"} 
         [:form {:action (get xmap :post) :method "post" :name "form"}
         [:center [:h5 (get xmap :nome)]]    
         [:p (str n ") " (get xmap :enunciado))]
         [:input {:type "radio" :name "op" :value "a" }]
         (get-value-exercicio 5 0) [:br]
         [:input {:type "radio" :name "op" :value "b" }] 
         (get-value-exercicio 6 0) [:br]
         [:input {:type "radio" :name "op" :value "c" }]  
         (get-value-exercicio 7 0) [:br]
         [:input {:type "radio" :name "op" :value "d" }]  
         (get-value-exercicio 8 0) [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]
         :else
;Abaixo temos o formato genêrico de html para exercicios de "aa"
         (cond (= "aa" (get xmap :tipo))
         [:body {:id "fundoiframe"} 
         [:form {:action (get xmap :post) :method "post" :name "form"}
         [:center [:h5 (get xmap :nome)]]    
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
         [:form {:action (get xmap :post) :method "post" :name "form"}
         [:center [:h5 (get xmap :nome)]]    
         [:p (str n ") " (get xmap :enunciado))]
         [:textarea {:id "Codigo" :type "text" :name "CodigoAluno"}]
         [:button {:class "botaoAnterior"} "anterior"]
         [:button {:class "botaoTestar"} "testar"]
         [:button {:class "botaoProximo"} "próximo"]]]

            ))
) 


;##########################################################################
;----------------------------                  ---------------------------
;##########################################################################
(defn conteudo-dificil [vetor]
   (def exerciciosDificeis (vec (rest exerciciosDificeis)))
   (cond
      (empty? exerciciosDificeis)
         nil
      :else
         (first vetor)
   )
)


(defn conteudo-medio [vetor]
   (def exerciciosMedios (vec (rest exerciciosMedios)))
   (cond
      (empty? exerciciosMedios)
         (conteudo-dificil exerciciosDificeis)
      :else
         (first vetor)
   )
)


(defn conteudo-facil [vetor]
   (def exerciciosFaceis (rest exerciciosFaceis))
   (cond
      (empty? exerciciosFaceis)
         (conteudo-medio exerciciosMedios)
      :else
         (first vetor)
   )
)
   ;(if (empty? stackVetor) criaVideo-Termina a aula, chama o video e mostra um conteudo passado- ChecaOutraEstrutura)

(defn pedagogico-gera-exercicio [n nivelExercicio resposta]
   ;(def temp [])
   (cond
      (= "facil" nivelExercicio) 
         (cond 
            (= true resposta) (def exercicioAtual [ (conteudo-medio exerciciosMedios) ])
            :else (def exercicioAtual [ (conteudo-facil exerciciosFaceis) ])
         )
      :else
         (cond
            (= "medio" nivelExercicio) 
               (cond 
                  (= true resposta) (def exercicioAtual [ (conteudo-dificil exerciciosDificeis) ])
                  :else (def exercicioAtual [ (conteudo-medio exerciciosMedios) ])
               )
      :else 
         (cond 
            (= true resposta) (def exercicioAtual [ (conteudo-dificil exerciciosDificeis) ])
            :else (def exercicioAtual [ (conteudo-medio exerciciosMedios) ])
         )
      )
   )
   (formata-pergunta (+ n 1) (get exercicioAtual 0))
)


(defn pedagogico-corretor [n respostaDoAluno]
   (def xmlmap {
      :conteudo (.toLowerCase (get-value-exercicio "conteudo")) 
      :exercicio (get-value-exercicio "idEx") 
      :nivel (get-value-exercicio "nivel") 
      :tipo (get-value-exercicio "tipo")
      })

   (cond
      ; verifica os tipos dos exercicios e escolhe uma forma de checar a questao.
      (= (get xmlmap :tipo) "me") (def xmlmap (conj {:resposta (get-attr-exercicio "alternativa" respostaDoAluno)} xmlmap))
      (= (get xmlmap :tipo) "vf") (def xmlmap (conj {:resposta (get-attr-exercicio "alternativa" "enum" respostaDoAluno)} xmlmap))
      (= (get xmlmap :tipo) "aa") (def xmlmap (conj {:resposta (get-attr-exercicio "alternativa" "enum" respostaDoAluno)} xmlmap))
      ;
      ; Os tipos "aberta" e "programacao" devera chamar uma funcao do compilador
      ; para que este verifique a corretude do exercicio.
      ;
      (= (get xmlmap :tipo) "aberta") (def xmlmap (conj {:resposta (get-attr-exercicio "alternativa" "enum" respostaDoAluno)} xmlmap))
      a linha abaixo (else) refere-se a programacao
      :else (def xmlmap (conj {:resposta (get-attr-exercicio "alternativa" "enum" respostaDoAluno)} xmlmap))
   )

   ;; As funcoes de atualizar-probs-exercicio devera ser verificada. Nao esta funcionando.
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

(defn pedagogico-main [materia]
   (def exerciciosFaceis (buscar-id-nivel materia "facil"))
   (def exerciciosMedios (buscar-id-nivel materia "medio"))
   (def exerciciosDificeis (buscar-id-nivel materia "dificil"))
   ( def exercicioAtual [(get (first exerciciosFaceis) :id)] )
   (formata-pergunta 1 (get exercicioAtual 0))
)