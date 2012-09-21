(ns ils.models.pedagogico.pedagogico
  (:require [ils.views.common :as common]
            [noir.content.getting-started]
            [noir.session :as session])
 (:use [ils.models.estudante.corygil estudante]))



; Os mapas abaixo contem as respostas de cada materia ensinada no E-Adapt.
; Estes serao substituidos por arquivos XML para melhor desenpenho e serao
; manipulados pelo modulo do aluno.
(def mapaAlocacaoDinamica
{
   "ex1"    "al1d"
   "ex2"    "al2c"
   "ex3"    "al3d"
   "ex4"    "al1c"
   "ex5"    "al5c"
   "ex6"    "al6c"
   "ex7"    "al7b"
   "ex8"    "al8d"
   "ex9"    "al9d"
   "ex10"   "al10c"
})


(def mapaVetor
{
   "ex1"    "v1b"
   "ex2"    "v2d"
   "ex3"    "v3c"
   "ex4"    "v4a"
   "ex5"    "v5d"
   "ex6"    "v6d"
   "ex7"    "v7a"
   "ex8"    "v8b"
   "ex9"    "v9d"
   "ex10"   "v10a"
})

(def mapaLista
{
   "ex1"    "l1c"
   "ex2"    "l2c"
   "ex3"    "l3d"
   "ex4"    "l2c"
   "ex5"    "l5d"
   "ex6"    "l6d"
   "ex7"    "l7b"
   "ex8"    "l8b"
   "ex9"    "l9c"
   "ex10"   "l10c"
})



; O mapa abaixo e um mapa de mapas. Facilitara encontrar as respostas
(def mapaMaterias
{
   "alocDin"   mapaAlocacaoDinamica
   "vetor"     mapaVetor
   "lista"     mapaLista
})



;%!@#$%^&*(!@#$%^&*(!@#$%^&*(



(defn pedagogico-respostas [materia exercicio]
"Encontra a materia e retorna a resposta."
    (get (get mapaMaterias materia) exercicio)
)



;%!@#$%^&*(!@#$%^&*(!@#$%^&*(



(defn pedagogico-corretor [materia exercicio resposta]
"Corrige exercicio. Recebe uma materia, procura um exercicio e compara a resposta. Determina a pontuacao do aluno."
   (cond 
      (= (pedagogico-respostas materia exercicio) resposta) 
         (atualizar-probs-exercicio (recupera-id (session/get :senhaUsuario))  materia exercicio 1.0 0.0 0.0)
      :else
         (atualizar-probs-exercicio (recupera-id (session/get :senhaUsuario)) materia exercicio 0.0 0.0 1.0)
))