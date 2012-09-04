(ns ils.views.questoes
  (:require [ils.views.common :as common]
            [noir.content.getting-started])
  (:use [ils.models connection]
        [noir.core :only [defpage]]
        [hiccup.core :only [html]]
        [hiccup.page-helpers :only [include-css html5]]))




;*********************************************************************/
;****************************** Olá **********************************/
;*********************************************************************/

(defpage "/login/ola" []
      (common/layout
         [:body {:id "fundoiframe"} 
         [:center [:h5 "Questões"]]
         [:h5 "Antes de começarmos as lições eu gostaria de saber um pouquinho sobre seus 
              conhecimentos de Programação de Computadores e Estrutura de Dados. Depois posso 
              lhe dar alguma sugestão para que você possa se sair melhor durante os estudos destas 
              duas disciplinas."]]))




;/********************************************************************/
;/****************************** ALOCAÇÃO DINÂMICA *******************/
;/********************************************************************/

(defpage "/login/alocacao" []
      (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/1" :method "post"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "A alocação dinâmica é o processo que aloca memória em tempo de execução. 
             Ela é utilizada quando não se sabe ao certo quanto de memória será necessário 
             para o armazenamento das informações, podendo ser determinadas em tempo de execução 
             conforme a necessidade do programa. Dessa forma evita-se o desperdício de memória.
             A alocação dinâmica é muito utilizada em problemas de estrutura de dados, por exemplo, 
            listas encadeadas, pilhas, filas, arvores binárias e grafos."]
         [:button {:class "botaoQuestoes"} "Avançar para questões"]]]))



(defpage [:post "/login/alocacao/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/2" :method "post"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "Questão 1 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/alocacao/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/3" :method "post"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "Questão 2 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/alocacao/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/4" :method "post"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "Questão 3 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/alocacao/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/5" :method "post"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "Questão 4 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/alocacao/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/6" :method "post"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "Questão 5 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/alocacao/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/7" :method "post"}
         [:center [:h5 "Alocação Dinâmica"]]  
         [:p "Questão 6 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/alocacao/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/8" :method "post"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "Questão 7 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/alocacao/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/9" :method "post"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "Questão 8 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/alocacao/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/10" :method "post"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "Questão 9 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/alocacao/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao" :method "post"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))



;/********************************************************************/
;/****************************** VETOR ********************/
;/********************************************************************/


(defpage "/login/vetor" []
      (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/1" :method "post"}
         [:center [:h5 "VETOR"]]
         [:p "Um array ou vetor é uma série de objetos de dados, todos 
              eles possuindo o mesmo tipo, estes objetos de dados são 
              chamados de elementos do vetor. Um vetor é declarado fornecendo-se 
             o tipo dos seus elementos, o nome do vetor e o número de elementos. 
             Um vetor nada mais é do que uma matriz unidimensional."]
         [:button {:class "botaoQuestoes"} "Avançar para questões"]]]))



(defpage [:post "/login/vetor/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/2" :method "post"}
         [:center [:h5 "VETOR"]]
         [:p "Questão 1 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/vetor/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/3" :method "post"}
         [:center [:h5 "VETOR"]]
         [:p "Questão 2 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/vetor/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/4" :method "post"}
         [:center [:h5 "VETOR"]]
         [:p "Questão 3 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/vetor/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/5" :method "post"}
         [:center [:h5 "VETOR"]]
         [:p "Questão 4 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/vetor/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/6" :method "post"}
         [:center [:h5 "VETOR"]]
         [:p "Questão 5 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/vetor/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/7" :method "post"}
         [:center [:h5 "VETOR"]]  
         [:p "Questão 6 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/vetor/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/8" :method "post"}
         [:center [:h5 "VETOR"]]
         [:p "Questão 7 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/vetor/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/9" :method "post"}
         [:center [:h5 "VETOR"]]
         [:p "Questão 8 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/vetor/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/10" :method "post"}
         [:center [:h5 "VETOR"]]
         [:p "Questão 9 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/vetor/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor" :method "post"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


;/********************************************************************/
;/****************************** MATRIZ ******************************/
;/********************************************************************/

(defpage "/login/matriz" []
      (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/matriz/1" :method "post"}
         [:center [:h5 "MATRIZ"]]
         [:p "As matrizes em geral são caracterizadas por se tratarem de 
              uma única variável de um determinado tamanho que guarda varias 
              informações do mesmo tipo. Essas informações são gravadas na memória 
              seqüencialmente e são referenciadas através de índices. As matrizes podem 
              ser tanto unidimensionais (vetores) como multidimensionais."]
         [:button {:class "botaoQuestoes"} "Avançar para questões"]]]))



(defpage [:post "/login/matriz/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/matriz/2" :method "post"}
         [:center [:h5 "MATRIZ"]]
         [:p "Questão 1 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/matriz/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/matriz/3" :method "post"}
         [:center [:h5 "MATRIZ"]]
         [:p "Questão 2 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/matriz/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/matriz/4" :method "post"}
         [:center [:h5 "MATRIZ"]]
         [:p "Questão 3 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/matriz/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/matriz/5" :method "post"}
         [:center [:h5 "MATRIZ"]]
         [:p "Questão 4 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/matriz/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/matriz/6" :method "post"}
         [:center [:h5 "MATRIZ"]]
         [:p "Questão 5 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/matriz/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/matriz/7" :method "post"}
         [:center [:h5 "MATRIZ"]]  
         [:p "Questão 6 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/matriz/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/matriz/8" :method "post"}
         [:center [:h5 "MATRIZ"]]
         [:p "Questão 7 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/matriz/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/matriz/9" :method "post"}
         [:center [:h5 "MATRIZ"]]
         [:p "Questão 8 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/matriz/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/matriz/10" :method "post"}
         [:center [:h5 "MATRIZ"]]
         [:p "Questão 9 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/matriz/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/matriz" :method "post"}
         [:center [:h5 "MATRIZ"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))



;/********************************************************************/
;/****************************** RECURSIVIDADE ********************/
;/********************************************************************/


(defpage "/login/recursividade" []
      (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/recursividade/1" :method "post"}
         [:center [:h5 "RECURSIVIDADE"]]
         [:p "Recursividade é um termo usado de maneira mais geral para descrever 
              o processo de repetição de um objeto de um jeito similar ao que já 
              fora mostrado. Um bom exemplo disso são as imagens repetidas que aparecem 
              quando dois espelhos são apontados um para o outro.Um procedimento recursivo 
             deve completar cada um de seus passos. Mesmo se uma nova chamada é feita, cada 
             execução deve passar por cada um dos passos restantes. O que isso quer dizer é que, 
             mesmo a salada sendo ela própria uma refeição inteira de quatro pratos, você ainda 
             deverá comer o prato principal e a sobremesa."]
         [:button {:class "botaoQuestoes"} "Avançar para questões"]]]))



(defpage [:post "/login/recursividade/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/recursividade/2" :method "post"}
         [:center [:h5 "RECURSIVIDADE"]]
         [:p "Questão 1 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/recursividade/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/recursividade/3" :method "post"}
         [:center [:h5 "RECURSIVIDADE"]]
         [:p "Questão 2 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/recursividade/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/recursividade/4" :method "post"}
         [:center [:h5 "RECURSIVIDADE"]]
         [:p "Questão 3 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/recursividade/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/recursividade/5" :method "post"}
         [:center [:h5 "RECURSIVIDADE"]]
         [:p "Questão 4 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/recursividade/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/recursividade/6" :method "post"}
         [:center [:h5 "RECURSIVIDADE"]]
         [:p "Questão 5 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/recursividade/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/recursividade/7" :method "post"}
         [:center [:h5 "RECURSIVIDADE"]]  
         [:p "Questão 6 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/recursividade/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/recursividade/8" :method "post"}
         [:center [:h5 "RECURSIVIDADE"]]
         [:p "Questão 7 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/recursividade/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/recursividade/9" :method "post"}
         [:center [:h5 "RECURSIVIDADE"]]
         [:p "Questão 8 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/recursividade/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/recursividade/10" :method "post"}
         [:center [:h5 "RECURSIVIDADE"]]
         [:p "Questão 9 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/recursividade/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/recursividade" :method "post"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))




;/********************************************************************/
;/******************************* LISTA ******************************/
;/********************************************************************/



(defpage "/login/lista" []
      (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/1" :method "post"}
         [:center [:h5 "LISTA"]]
         [:p "Lista é uma estrutura onde as operações inserir, retirar 
e localizar são definidas. Para criarmos uma Lista, faz-se necessário a 
definição de um conjunto de operações sobre os objetos do tipo Lista. 
Estas operações dependerão de cada aplicação, não existindo um conjunto 
de operações que seja adequado a todas aplicações."]
         [:button {:class "botaoQuestoes"} "Avançar para questões"]]]))



(defpage [:post "/login/lista/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/2" :method "post"}
         [:center [:h5 "LISTA"]]
         [:p "Questão 1 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/lista/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/3" :method "post"}
         [:center [:h5 "LISTA"]]
         [:p "Questão 2 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/lista/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/4" :method "post"}
         [:center [:h5 "LISTA"]]
         [:p "Questão 3 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/lista/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/5" :method "post"}
         [:center [:h5 "LISTA"]]
         [:p "Questão 4 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/lista/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/6" :method "post"}
         [:center [:h5 "LISTA"]]
         [:p "Questão 5 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/lista/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/7" :method "post"}
         [:center [:h5 "LISTA"]]  
         [:p "Questão 6 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/lista/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/8" :method "post"}
         [:center [:h5 "LISTA"]]
         [:p "Questão 7 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/lista/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/9" :method "post"}
         [:center [:h5 "LISTA"]]
         [:p "Questão 8 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/lista/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/10" :method "post"}
         [:center [:h5 "LISTA"]]
         [:p "Questão 9 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/lista/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista" :method "post"}
         [:center [:h5 "LISTA"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


;/*******************************************************************/
;/******************************* FILA ******************************/
;/*******************************************************************/


(defpage "/login/fila" []
      (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/1" :method "post"}
         [:center [:h5 "FILA"]] 
         [:p "As filas, também conhecidas como listas FIFO (First In, First Out, do inglês:
	Primeiro que Entra, Primeiro que Sai) simulam as filas do mundo real. Como
	exemplo podemos citar uma fila de banco. Onde a primeira pessoa que chegar, será
	a primeira pessoa a ser atendida; a segunda pessoa que chegar será a segunda a
	ser atendida e assim por diante.Quando manipulamos dados através de arranjos, os 
        itens inseridos são armazenados em posições contíguas de memória. E esta estrutura 
        deve ser utilizada quando desejamos processar dados de acordo com a ordem de chegada."]
         [:button {:class "botaoQuestoes"} "Avançar para questões"]]]))



(defpage [:post "/login/fila/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/2" :method "post"}
         [:center [:h5 "FILA"]]
         [:p "Questão 1 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/fila/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/3" :method "post"}
         [:center [:h5 "FILA"]]
         [:p "Questão 2 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/fila/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/4" :method "post"}
         [:center [:h5 "FILA"]]
         [:p "Questão 3 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/fila/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/5" :method "post"}
         [:center [:h5 "FILA"]]
         [:p "Questão 4 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/fila/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/6" :method "post"}
         [:center [:h5 "FILA"]]
         [:p "Questão 5 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/fila/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/7" :method "post"}
         [:center [:h5 "FILA"]]  
         [:p "Questão 6 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/fila/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/8" :method "post"}
         [:center [:h5 "FILA"]]
         [:p "Questão 7 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/fila/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/9" :method "post"}
         [:center [:h5 "FILA"]]
         [:p "Questão 8 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/fila/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/10" :method "post"}
         [:center [:h5 "FILA"]]
         [:p "Questão 9 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/fila/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila" :method "post"}
         [:center [:h5 "FILA"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))



;/*******************************************************************/
;/**************************** PILHA ********************************/
;/*******************************************************************/



(defpage "/login/pilha" []
      (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/1" :method "post"}
         [:center [:h5 "PILHA"]]
         [:p "A pilha quando implementada em arranjos, é um conjunto ordenado de 
              itens no qual se aplicam basicamente, duas operações para manutenção 
              dos dados e/ou estruturas nela armazenada.Devido às suas características, 
              na pilha, a operação de inserção e retirada de itens devem ocorrer sempre no topo. 
              A pilha também é conhecida como LIFO (Last In, First Out, do inglês, Último
              que entra é o primeiro que sai). Um exemplo típico para facilitar o entendimento 
              da estrutura Pilha, é o de uma pilha de pratos.Numa pilha de pratos, nunca retiramos 
              o primeiro prato (de baixo para cima) e tampouco qualquer posição do meio da pilha. 
              A retirada ou inserção pratos se dá sempre no topo da pilha."]
         [:button {:class "botaoQuestoes"} "Avançar para questões"]]]))



(defpage [:post "/login/pilha/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/2" :method "post"}
         [:center [:h5 "PILHA"]]
         [:p "Questão 1 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/pilha/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/3" :method "post"}
         [:center [:h5 "PILHA"]]
         [:p "Questão 2 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/pilha/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/4" :method "post"}
         [:center [:h5 "PILHA"]]
         [:p "Questão 3 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/pilha/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/5" :method "post"}
         [:center [:h5 "PILHA"]]
         [:p "Questão 4 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/pilha/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/6" :method "post"}
         [:center [:h5 "PILHA"]]
         [:p "Questão 5 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/pilha/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/7" :method "post"}
         [:center [:h5 "PILHA"]]  
         [:p "Questão 6 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/pilha/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/8" :method "post"}
         [:center [:h5 "PILHA"]]
         [:p "Questão 7 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/pilha/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/9" :method "post"}
         [:center [:h5 "PILHA"]]
         [:p "Questão 8 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/pilha/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/10" :method "post"}
         [:center [:h5 "PILHA"]]
         [:p "Questão 9 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/pilha/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha" :method "post"}
         [:center [:h5 "PILHA"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))




;/********************************************************************/
;/*************************** ÁRVORE *********************************/
;/********************************************************************/


(defpage "/login/arvore" []
      (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/arvore/1" :method "post"}
         [:center [:h5 "ÁRVORE"]] 
         [:p "Árvores de pesquisa são estruturas de dados eficientes para 
             armazenar informação. Uma árvore de pesquisa é particularmente 
             adequada quando existe necessidade de considerar todos ou
             alguma combinação de requisitos, tais como: (i) acesso direto e seqüencial
             eficientes; (ii) facilidade de inserção e retirada de registros; (iii) boa 
             taxa de utilização de memória; (iv) utilização de memória primária e secundária.
             O nível do nodo raiz é 0 (zero). Se um nodo está no nível i, então a raiz de
             suas subárvores estão no nível i + 1. A altura de um nodo é o comprimento do caminho 
             mais longo deste nodo até um nodo folha. A altura de uma árvore é a altura do nodo raiz."]
         [:button {:class "botaoQuestoes"} "Avançar para questões"]]]))



(defpage [:post "/login/arvore/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/arvore/2" :method "post"}
         [:center [:h5 "ÁRVORE"]]
         [:p "Questão 1 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/arvore/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/arvore/3" :method "post"}
         [:center [:h5 "ÁRVORE"]]
         [:p "Questão 2 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/arvore/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/arvore/4" :method "post"}
         [:center [:h5 "ÁRVORE"]]
         [:p "Questão 3 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/arvore/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/arvore/5" :method "post"}
         [:center [:h5 "ÁRVORE"]]
         [:p "Questão 4 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/arvore/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/arvore/6" :method "post"}
         [:center [:h5 "ÁRVORE"]]
         [:p "Questão 5 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/arvore/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/arvore/7" :method "post"}
         [:center [:h5 "ÁRVORE"]]  
         [:p "Questão 6 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/arvore/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/arvore/8" :method "post"}
         [:center [:h5 "ÁRVORE"]]
         [:p "Questão 7 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/arvore/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/arvore/9" :method "post"}
         [:center [:h5 "ÁRVORE"]]
         [:p "Questão 8 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/arvore/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/arvore/10" :method "post"}
         [:center [:h5 "ÁRVORE"]]
         [:p "Questão 9 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/arvore/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/arvore" :method "post"}
         [:center [:h5 "ÁRVORE"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))



;/********************************************************************/
;/****************************** GRAFO *******************************/
;/********************************************************************/



(defpage "/login/grafo" []
      (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/grafo/1" :method "post"}
         [:center [:h5 "GRAFO"]] 
         [:p "Um grafo G = (V, E) é um conjunto não-vazio V de vértices, e 
              um conjunto E de arestas. Cada aresta é um par (vi , v j ), 
              sendo vi e v j elementos de V. Como exemplo de um grafo direcionado, 
              podemos considerar a malha aérea de uma região, de forma que os vértices 
              do grafo representem os aeroportos, que são conectados por vôos."]
         [:button {:class "botaoQuestoes"} "Avançar para questões"]]]))



(defpage [:post "/login/grafo/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/grafo/2" :method "post"}
         [:center [:h5 "GRAFO"]]
         [:p "Questão 1 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/grafo/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/grafo/3" :method "post"}
         [:center [:h5 "GRAFO"]]
         [:p "Questão 2 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/grafo/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/grafo/4" :method "post"}
         [:center [:h5 "GRAFO"]]
         [:p "Questão 3 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/grafo/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/grafo/5" :method "post"}
         [:center [:h5 "GRAFO"]]
         [:p "Questão 4 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/grafo/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/grafo/6" :method "post"}
         [:center [:h5 "GRAFO"]]
         [:p "Questão 5 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/grafo/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/grafo/7" :method "post"}
         [:center [:h5 "GRAFO"]]  
         [:p "Questão 6 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/grafo/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/grafo/8" :method "post"}
         [:center [:h5 "GRAFO"]]
         [:p "Questão 7 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/grafo/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/grafo/9" :method "post"}
         [:center [:h5 "GRAFO"]]
         [:p "Questão 8 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/grafo/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/grafo/10" :method "post"}
         [:center [:h5 "GRAFO"]]
         [:p "Questão 9 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/grafo/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/grafo" :method "post"}
         [:center [:h5 "GRAFO"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))




;/*******************************************************************/
;/*************************** Compressão de Dados *******************/
;/*******************************************************************/



(defpage "/login/compressao" []
      (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/compressao/1" :method "post"}
         [:center [:h5 "Compressão Dados"]] 
         [:p " A compressão de dados é o ato de reduzir o espaço ocupado 
              por dados num determinado dispositivo. Essa operação é realizada 
              através de diversos algoritmos de compressão, reduzindo a quantidade 
              de Bytes para representar um dado, sendo esse dado uma imagem, um texto, 
              ou um arquivo (ficheiro) qualquer. Comprimir dados destina-se também a 
              retirar a redundância, baseando-se que muitos dados contêm informações 
              redundantes que podem ou precisam ser eliminadas de alguma forma. Essa forma 
              é através de uma regra, chamada de código ou protocolo, que, quando seguida, 
             elimina os bits redundantes de informações, de modo a diminuir seu tamanho nos 
             ficheiros. Por exemplo, a sequência AAAAAA que ocupa 6 bytes, poderia ser representada 
             pela sequência 6A, que ocupa 2 bytes, economizando 67% de espaço."]
         [:button {:class "botaoQuestoes"} "Avançar para questões"]]]))



(defpage [:post "/login/compressao/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/compressao/2" :method "post"}
         [:center [:h5 "Compressão Dados"]]
         [:p "Questão 1 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/compressao/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/compressao/3" :method "post"}
         [:center [:h5 "Compressão Dados"]]
         [:p "Questão 2 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/compressao/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/compressao/4" :method "post"}
         [:center [:h5 "Compressão Dados"]]
         [:p "Questão 3 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/compressao/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/compressao/5" :method "post"}
         [:center [:h5 "Compressão Dados"]]
         [:p "Questão 4 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/compressao/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/compressao/6" :method "post"}
         [:center [:h5 "Compressão Dados"]]
         [:p "Questão 5 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/compressao/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/compressao/7" :method "post"}
         [:center [:h5 "Compressão Dados"]]  
         [:p "Questão 6 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/compressao/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/compressao/8" :method "post"}
         [:center [:h5 "Compressão Dados"]]
         [:p "Questão 7 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/compressao/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/compressao/9" :method "post"}
         [:center [:h5 "Compressão Dados"]]
         [:p "Questão 8 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/compressao/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/compressao/10" :method "post"}
         [:center [:h5 "Compressão Dados"]]
         [:p "Questão 9 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/compressao/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/compressao" :method "post"}
         [:center [:h5 "Compressão Dados"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))



;*************************** FIM DAS QUESTÕES *********************************
