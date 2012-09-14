(ns ils.views.questoes
  (:require [ils.views.common :as common]
            [noir.content.getting-started]
            [noir.session :as session])
  (:use [ils.models.estudante.corygil estudante]
        [ils.models.pedagogico pedagogico]
        [ils.models.dominio dominio]  
        [noir.core :only [defpage]]
        [hiccup.core :only [html]]))
        



;*********************************************************************/
;****************************** Olá **********************************/
;*********************************************************************/

(defpage "/login/ola" []
      (common/layout   
         [:body {:id "fundoiframe" :onclick "alteraPosicionamento();"} 
         [:center [:h5 "Questões"]]
         [:h3 "Antes de começarmos as lições eu gostaria de saber um pouquinho sobre seus 
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
         [:button {:class "botaoQuestoes" :onclick "testeAlocacao();"} "Avançar para questões"]]]))



(defpage [:post "/login/alocacao/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/2" :method "post" :name "form"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "1) A alocação dinâmica em C é feita com o seguinte comando: "]
         [:input {:type "radio" :name "op" :value "al1a" }]  " (A) allocation(estrutura*)" [:br]
         [:input {:type "radio" :name "op" :value "al1b" }]  " (B) free(estrutura*)" [:br]
         [:input {:type "radio" :name "op" :value "al1c" }]  " (C) sizeof()" [:br]
         [:input {:type "radio" :name "op" :value "al1d" }]  " (D) malloc()" [:br] [:br][:br] 
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/alocacao/2"] {:keys [op]}
(pedagogico-corretor "alocDin" "ex1" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/3" :method "post" :name "form"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "2) Em alguns sistemas computacionais, o gasto de memória é decisivo na produção de um software. Para não haver desperdício de memória:"]
         [:input {:type "radio" :name "op" :value "al2a" }]  " (A) Se faz alocação estática, pois se delimita a quantidade de memória que se quer usar." [:br]
         [:input {:type "radio" :name "op" :value "al2b" }]  " (B) Se faz alocação dinâmica, colocando a quantidade de posições da estrutura que se quer utilizar." [:br]
         [:input {:type "radio" :name "op" :value "al2c" }]  " (C) Se faz alocação dinâmica, não colocando a quantidade de posições." [:br]
         [:input {:type "radio" :name "op" :value "al2d" }]  " (D) Nenhuma das anteriores." [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/alocacao/3"] {:keys [op]}
(pedagogico-corretor "alocDin" "ex2" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/4" :method "post" :name "form"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "3) Marque a alternativa correta para se alocar um vetor inteiro vet de 50 posições na linguagem C: "]
         [:input {:type "radio" :name "op" :value "al3a" }]  " (A)  vet = (int*) malloc (sizeof(int)) " [:br]
         [:input {:type "radio" :name "op" :value "al3b" }]  " (B) *vet = (int*) malloc (sizeof(int)) " [:br]
         [:input {:type "radio" :name "op" :value "al3c" }]  " (C) *vet = (int*) malloc (50*sizeof(int)) " [:br]
         [:input {:type "radio" :name "op" :value "al3d" }]  " (D)  vet = (int*) malloc (50*sizeof(int))" [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/alocacao/4"] {:keys [op]}
(pedagogico-corretor "alocDin" "ex3" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/5" :method "post" :name "form"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "4) Desejo criar a seguinte estrutura em C:"] 
         [:p "Um vetor de 3 posicoes capaz de guardar uma string em cada posição, seguindo o modelo:"]
         [:p "posição 0: Maria"]
         [:p "posição 1: João"]
         [:p "posição 2: Pedro"]
         [:p "Marque a alternativa correta referente à alocação desta estrutura."]
         [:input {:type "radio" :name "op" :value "al1a" }]  " (A) vetS[3] = (char*) malloc(sizeof(char))" [:br]
         [:input {:type "radio" :name "op" :value "al1b" }]  " (B) vetS[2] = (char*) malloc(sizeof(char))" [:br]
         [:input {:type "radio" :name "op" :value "al1c" }]  " (C) vetS = (char*) malloc(3*sizeof(char))" [:br]
         [:input {:type "radio" :name "op" :value "al1d" }]  " (D) Não é possível fazer isto na linguagem C." [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/alocacao/5"] {:keys [op]}
(pedagogico-corretor "alocDin" "ex4" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/6" :method "post" :name "form"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "5) Para alocar memória precisamos saber quanto espaço cada tipo ocupa. "]
         [:p "Qual é esse operador ?"]
         [:input {:type "radio" :name "op" :value "al5a" }]  " (A) allocation()" [:br]
         [:input {:type "radio" :name "op" :value "al5b" }]  " (B) free()" [:br]
         [:input {:type "radio" :name "op" :value "al5c" }]  " (C) sizeof()" [:br]
         [:input {:type "radio" :name "op" :value "al5d" }]  " (D) malloc()" [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))

(defpage [:post "/login/alocacao/6"] {:keys [op]}
(pedagogico-corretor "alocDin" "ex5" op)
        (common/layout 
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/7" :method "post" :name "form"}
         [:center [:h5 "Alocação Dinâmica"]]  
         [:p "6) O que a variavel ptr representa ? ptr = malloc (sizeof (data)); "]
         [:input {:type "radio" :name "op" :value "al6a" }]  " (A) Devolve o endereço" [:br]
         [:input {:type "radio" :name "op" :value "al6b" }]  " (B) Devolve um valor qualquer" [:br]
         [:input {:type "radio" :name "op" :value "al6c" }]  " (C) Devolve NULL" [:br]
         [:input {:type "radio" :name "op" :value "al6d" }]  " (D) Devolve lixo" [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))

(defpage [:post "/login/alocacao/7"] {:keys [op]}
(pedagogico-corretor "alocDin" "ex6" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/8" :method "post" :name "form"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "7) se quisermos alocar espaço para 100 inteiros podemos usar: "]
         [:input {:type "radio" :name "op" :value "al7a" }]  " (A)int &ip; ip = (int &) malloc(100*sizeof(int));" [:br]
         [:input {:type "radio" :name "op" :value "al7b" }]  " (B)int *ip; ip = (int *) malloc(100*sizeof(int));" [:br]
         [:input {:type "radio" :name "op" :value "al7c" }]  " (C)int *ip; &ip = (int *) sizeof(100*malloc(*int));" [:br]
         [:input {:type "radio" :name "op" :value "al7d" }]  " (D)int *ip; ip = (int *) sizeof(100*malloc(int));" [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))

(defpage [:post "/login/alocacao/8"] {:keys [op]}
(pedagogico-corretor "alocDin" "ex7" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/9" :method "post" :name "form"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "8) Marque a alternativa correta para se alocar um vetor inteiro vet de 500 posições na linguagem C: "]
         [:input {:type "radio" :name "op" :value "al8a" }]  " (A)  vet = (int*) malloc (sizeof(int)) " [:br]
         [:input {:type "radio" :name "op" :value "al8b" }]  " (B) *vet = (int*) malloc (sizeof(int)) " [:br]
         [:input {:type "radio" :name "op" :value "al8c" }]  " (C) *vet = (int*) malloc (500*sizeof(int)) " [:br]
         [:input {:type "radio" :name "op" :value "al8d" }]  " (D)  vet = (int*) malloc (500*sizeof(int))" [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/alocacao/9"] {:keys [op]}
(pedagogico-corretor "alocDin" "ex8" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/10" :method "post" :name "form"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "9) Limpar a memoria alocada de um vetor V "]
         [:input {:type "radio" :name "op" :value "al9a" }]  " (A) alloc(V) " [:br]
         [:input {:type "radio" :name "op" :value "al9b" }]  " (B) malloc(V)" [:br]
         [:input {:type "radio" :name "op" :value "al9c" }]  " (C) sizeof(V)" [:br]
         [:input {:type "radio" :name "op" :value "al9d" }]  " (D) free(V)" [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/alocacao/10"] {:keys [op]}
(pedagogico-corretor "alocDin" "ex9" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/alocacao/fim" :method "post" :name "form"}
         [:center [:h5 "Alocação Dinâmica"]]
         [:p "10)  int Func(vet) { vet = (int*) malloc (sizeof(int)); if(vet == NULL) return 0 else return 1 } "]
         [:p "O que o código faz ?"]
         [:input {:type "radio" :name "op" :value "al10a" }]  " (A) aloca um vetor e retorna seu valor " [:br]
         [:input {:type "radio" :name "op" :value "al10b" }]  " (B) aloca e depois limpa a memoria" [:br]
         [:input {:type "radio" :name "op" :value "al10c" }]  " (C) aloca e verifica se deu certo" [:br]
         [:input {:type "radio" :name "op" :value "al10d" }]  " (D) Nenhuma das anteriores" [:br] [:br][:br]   
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/alocacao/fim"] {:keys [op]}
(pedagogico-corretor "alocDin" "ex10" op)
  
(atualiza-todo-dominio (recupera-id (session/get :senhaUsuario)) "alocDin")   
(cond (> (get (nth (retorna-exercicio-certos-dominio (recupera-id (session/get :senhaUsuario)) "alocDin") 0) :bom) 0.5)
  (common/layout
         [:body {:id "fundoiframe" :onload "alteraVisibilidadeAlocacaoInvisivel(); alteraVisibilidadeVetor1(); alteraVisibilidadeVetorInvisivel(); alteraVisibilidadeListaInvisivel(); alteraVisibilidadeFilaInvisivel(); alteraVisibilidadePilhaInvisivel(); alteraVisibilidadeArvoreInvisivel();"} 
         [:center [:h5 "Alocação Dinâmica"]]
         [:center [:h2 "Você terminou as atividades de Alocação Dinâmica! "]]
         [:center [:h4 "Fico feliz, pois você teve um conhecimento acima de 50%"]]
         [:center [:h4 "Sendo assim, pode proseguir a responder as questões."]]])
   :else 
     (common/layout
         [:body {:id "fundoiframe" } 
         [:center [:h5 "Alocação Dinâmica" ]]
         [:center [:h2 "Você terminou as atividades de alocação dinâmica! "]]
         [:center [:h4 "Fico triste, pois você não se saiu bem, sendo assim te indico um vídeo explicativo que está abaixo"]]
         [:center [:h4 [:iframe {:width "560" :height "315" :src "http://www.youtube.com/embed/sTYLxyPszWQ" :frameborder "0" }]]]]  
         )))





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
         [:button {:class "botaoQuestoes" :onclick "testeVetor();" } "Avançar para questões"]]]))



(defpage [:post "/login/vetor/1"] []
    (common/layout
         (formata-pergunta "001v.xml")))



(defpage [:post "/login/vetor/2"] {:keys [op]}
(pedagogico-corretor "vetor" "ex1" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/3" :method "post" :name "form"}
         [:center [:h5 "VETOR"]]
         [:p (str "2) "(get-value "src/ils/models/dominio/exerc-vetor/002v.xml" :exercicio :enunciado))]
         [:input {:type "radio" :name "op" :value "v2a" }]  
         (get-value "src/ils/models/dominio/exerc-vetor/002v.xml" :exercicio :alternativa :idAlt1) [:br]
         [:input {:type "radio" :name "op" :value "v2b" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/002v.xml" :exercicio :alternativa :idAlt2) [:br]
         [:input {:type "radio" :name "op" :value "v2c" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/002v.xml" :exercicio :alternativa :idAlt3) [:br]
         [:input {:type "radio" :name "op" :value "v2d" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/002v.xml" :exercicio :alternativa :idAlt4) [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();" } "Avançar"]]]))


(defpage [:post "/login/vetor/3"] {:keys [op]}
(pedagogico-corretor "vetor" "ex2" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/4" :method "post" :name "form"}
         [:center [:h5 "VETOR"]]
         [:p (str "3) "(get-value "src/ils/models/dominio/exerc-vetor/003v.xml" :exercicio :enunciado)) ]
         [:input {:type "radio" :name "op" :value "v3a" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/003v.xml" :exercicio :alternativa :idAlt1) [:br]
         [:input {:type "radio" :name "op" :value "v3b" }] 
	 (get-value "src/ils/models/dominio/exerc-vetor/003v.xml" :exercicio :alternativa :idAlt2) [:br]
         [:input {:type "radio" :name "op" :value "v3c" }] 
	 (get-value "src/ils/models/dominio/exerc-vetor/003v.xml" :exercicio :alternativa :idAlt3) [:br]
         [:input {:type "radio" :name "op" :value "v3d" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/003v.xml" :exercicio :alternativa :idAlt4) [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/vetor/4"] {:keys [op]}
(pedagogico-corretor "vetor" "ex3" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/5" :method "post" :name "form"}
         [:center [:h5 "VETOR"]]
         [:p (str "4) "(get-value "src/ils/models/dominio/exerc-vetor/004v.xml" :exercicio :enunciado))]
         [:input {:type "radio" :name "op" :value "v4a" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/004v.xml" :exercicio :alternativa :idAlt1) [:br]
         [:input {:type "radio" :name "op" :value "v4b" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/004v.xml" :exercicio :alternativa :idAlt2) [:br]
         [:input {:type "radio" :name "op" :value "v4c" }] 
	 (get-value "src/ils/models/dominio/exerc-vetor/004v.xml" :exercicio :alternativa :idAlt3) [:br]
         [:input {:type "radio" :name "op" :value "v4d" }] 
         (get-value "src/ils/models/dominio/exerc-vetor/004v.xml" :exercicio :alternativa :idAlt4) [:br] [:br][:br] 
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/vetor/5"] {:keys [op]}   
(pedagogico-corretor "vetor" "ex4" op)
 (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/6" :method "post" :name "form"}
         [:center [:h5 "VETOR"]]
         [:p (str "5) "(get-value "src/ils/models/dominio/exerc-vetor/005v.xml" :exercicio :enunciado))]
         [:input {:type "radio" :name "op" :value "v5a" }]  
         (get-value "src/ils/models/dominio/exerc-vetor/005v.xml" :exercicio :alternativa :idAlt1) [:br]
         [:input {:type "radio" :name "op" :value "v5b" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/005v.xml" :exercicio :alternativa :idAlt2) [:br]
         [:input {:type "radio" :name "op" :value "v5c" }] 
	 (get-value "src/ils/models/dominio/exerc-vetor/005v.xml" :exercicio :alternativa :idAlt3) [:br]
         [:input {:type "radio" :name "op" :value "v5d" }] 
	 (get-value "src/ils/models/dominio/exerc-vetor/005v.xml" :exercicio :alternativa :idAlt4) [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))

(defpage [:post "/login/vetor/6"] {:keys [op]}
(pedagogico-corretor "vetor" "ex5" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/7" :method "post" :name "form"}
         [:center [:h5 "VETOR"]]  
         [:p (str "6) "(get-value "src/ils/models/dominio/exerc-vetor/006v.xml" :exercicio :enunciado))]
         [:input {:type "radio" :name "op" :value "v6a" }] 
	 (get-value "src/ils/models/dominio/exerc-vetor/006v.xml" :exercicio :alternativa :idAlt1) [:br]
         [:input {:type "radio" :name "op" :value "v6b" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/006v.xml" :exercicio :alternativa :idAlt2) [:br]
         [:input {:type "radio" :name "op" :value "v6c" }]
	 (get-value "src/ils/models/dominio/exerc-vetor/006v.xml" :exercicio :alternativa :idAlt3) [:br]
         [:input {:type "radio" :name "op" :value "v6d" }] 
	 (get-value "src/ils/models/dominio/exerc-vetor/006v.xml" :exercicio :alternativa :idAlt4) [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))

(defpage [:post "/login/vetor/7"] {:keys [op]}
(pedagogico-corretor "vetor" "ex6" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/8" :method "post" :name "form"}
         [:center [:h5 "VETOR"]]
         [:p (str "7) "(get-value "src/ils/models/dominio/exerc-vetor/007v.xml" :exercicio :enunciado))]
         [:input {:type "radio" :name "op" :value "v7a" }] 
	 (get-value "src/ils/models/dominio/exerc-vetor/007v.xml" :exercicio :alternativa :idAlt1) [:br]
         [:input {:type "radio" :name "op" :value "v7b" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/007v.xml" :exercicio :alternativa :idAlt2) [:br]
         [:input {:type "radio" :name "op" :value "v7c" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/007v.xml" :exercicio :alternativa :idAlt3) [:br]
         [:input {:type "radio" :name "op" :value "v7d" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/007v.xml" :exercicio :alternativa :idAlt4) [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))

(defpage [:post "/login/vetor/8"] {:keys [op]}
(pedagogico-corretor "vetor" "ex7" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/9" :method "post" :name "form"}
         [:center [:h5 "VETOR"]]
         [:p (str "8) "(get-value "src/ils/models/dominio/exerc-vetor/008v.xml" :exercicio :enunciado))]
         [:input {:type "radio" :name "op" :value "v8a" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/008v.xml" :exercicio :alternativa :idAlt1) [:br]
         [:input {:type "radio" :name "op" :value "v8b" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/008v.xml" :exercicio :alternativa :idAlt2) [:br]
         [:input {:type "radio" :name "op" :value "v8c" }] 
	 (get-value "src/ils/models/dominio/exerc-vetor/008v.xml" :exercicio :alternativa :idAlt3) [:br]
         [:input {:type "radio" :name "op" :value "v8d" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/008v.xml" :exercicio :alternativa :idAlt4) [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/vetor/9"] {:keys [op]}
(pedagogico-corretor "vetor" "ex8" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/10" :method "post" :name "form"}
         [:center [:h5 "VETOR"]]
         [:p (str "9) "(get-value "src/ils/models/dominio/exerc-vetor/009v.xml" :exercicio :enunciado))]
         [:input {:type "radio" :name "op" :value "v9a" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/009v.xml" :exercicio :alternativa :idAlt1) [:br]
         [:input {:type "radio" :name "op" :value "v9b" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/009v.xml" :exercicio :alternativa :idAlt2) [:br]
         [:input {:type "radio" :name "op" :value "v9c" }] 
	 (get-value "src/ils/models/dominio/exerc-vetor/009v.xml" :exercicio :alternativa :idAlt3) [:br]
         [:input {:type "radio" :name "op" :value "v9d" }] 
	 (get-value "src/ils/models/dominio/exerc-vetor/009v.xml" :exercicio :alternativa :idAlt4) [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/vetor/10"] {:keys [op]}
(pedagogico-corretor "vetor" "ex9" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/vetor/fim" :method "post" :name "form"}
         [:center [:h5 "VETOR"]]
         [:p (str "10) "(get-value "src/ils/models/dominio/exerc-vetor/010v.xml" :exercicio :enunciado))]
         [:input {:type "radio" :name "op" :value "v10a" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/010v.xml" :exercicio :alternativa :idAlt1) [:br]
                                                                                    
         [:input {:type "radio" :name "op" :value "v10b" }] 
	 (get-value "src/ils/models/dominio/exerc-vetor/010v.xml" :exercicio :alternativa :idAlt2) [:br]
 
         [:input {:type "radio" :name "op" :value "v10c" }] 
	 (get-value "src/ils/models/dominio/exerc-vetor/010v.xml" :exercicio :alternativa :idAlt3) [:br]

         [:input {:type "radio" :name "op" :value "v10d" }]  
	 (get-value "src/ils/models/dominio/exerc-vetor/010v.xml" :exercicio :alternativa :idAlt4) [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))

(defpage [:post "/login/vetor/fim"] {:keys [op]}
(pedagogico-corretor "vetor" "ex10" op)
(atualiza-todo-dominio (recupera-id (session/get :senhaUsuario)) "vetor")   
(cond (> (get (nth (retorna-exercicio-certos-dominio (recupera-id (session/get :senhaUsuario)) "vetor") 0) :bom) 0.5)
  (common/layout
         [:body {:id "fundoiframe" :onload "alteraVisibilidadeLista1(); alteraVisibilidadeVetor1(); alteraVisibilidadeVetorInvisivel(); alteraVisibilidadeAlocacaoInvisivel(); mudaCorAzulLista(); alteraVisibilidadeFilaInvisivel(); alteraVisibilidadePilhaInvisivel(); alteraVisibilidadeArvoreInvisivel();"} 
         [:center [:h5 "VETOR"]]
         [:center [:h2 "Você terminou as atividades de vetores! "]]
         [:center [:h4 "Fico feliz, pois você teve um conhecimento acima de 50%"]]
         [:center [:h4 "Sendo assim, pode proseguir a responder as questões."]]
         [:center [:h4 "Vamos para o centeúdo de Lista, o link apareceu ao lado"]]])
   :else 
     (common/layout
         [:body {:id "fundoiframe" :onload "alteraVisibilidadeAlocacao(); alteraVisibilidadeVetor1Inv(); alteraVisibilidadeVetor();  alteraVisibilidadeListaInvisivel(); alteraVisibilidadeFilaInvisivel();"} 
         [:center [:h5 "VETOR" ]]
         [:center [:h2 "Você terminou as atividades de vetores! "]]
         [:center [:h4 "Fico triste, pois você não se saiu bem"]]
         [:center [:h4 "Sendo assim, não pode prosseguir."]]
         [:center [:h4 "Te indico o conteúdo de alocação dinâmica, que apareceu o link ao lado."]]]  
         )))




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
         [:button {:class "botaoQuestoes" :onclick "testeRecursividade();"} "Avançar para questões"]]]))



(defpage [:post "/login/recursividade/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/recursividade/2" :method "post"}
         [:center [:h5 "RECURSIVIDADE"]]
         [:p "1) A recursão é muito utilizada em diversos algoritmos. Porém, em alguns casos, é recomendado se evitar a recursão."] 
         [:p "Marque a alternativa correta referente ao(s) problema(s) ocasionado(s) pela recursão:"]
         [:input {:type "radio" :name "rec1" :value "rec1a" }]  " (A) segmentation fault" [:br]
         [:input {:type "radio" :name "rec1" :value "rec1b" }]  " (B) stack overflow" [:br]
         [:input {:type "radio" :name "rec1" :value "rec1c" }]  " (C) ineficiência" [:br]
         [:input {:type "radio" :name "rec1" :value "rec1d" }]  " (D) Todas as anteriores." [:br] [:br][:br]
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
         [:form {:action "/login/recursividade/fim" :method "post"}
         [:center [:h5 "RECURSIVIDADE"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/recursividade/fim"] []
     (common/layout
         [:body {:id "fundoiframe" :onload "alteraVisibilidadeRecursividadeInvisivel();"} 
         [:center [:h5 "RECURSIVIDADE"]]
         [:center [:h2 "Você terminou as atividades de recursividade! "]]]
          ))



;/********************************************************************/
;/******************************* LISTA ******************************/
;/********************************************************************/



(defpage "/login/lista" []
      (common/layout
         [:body {:id "fundoiframe" :onclick "alteraVisibilidadeAlocacaoInvisivel();"} 
         [:form {:action "/login/lista/1" :method "post"}
         [:center [:h5 "LISTA"]]
         [:p "Lista é uma estrutura onde as operações inserir, retirar 
e localizar são definidas. Para criarmos uma Lista, faz-se necessário a 
definição de um conjunto de operações sobre os objetos do tipo Lista. 
Estas operações dependerão de cada aplicação, não existindo um conjunto 
de operações que seja adequado a todas aplicações."]
         [:button {:class "botaoQuestoes" :onclick "testeLista();"} "Avançar para questões"]]]))



(defpage [:post "/login/lista/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/2" :method "post" :name "form"}
         [:center [:h5 "LISTA"]]
         [:p "1) Quais são os tipos de lista? "]
         [:input {:type "radio" :name "op" :value "l1a" }]  " (A) encadeada reversa, duplamente encadeada, cíclica e estática "  [:br]
         [:input {:type "radio" :name "op" :value "l1b" }]  " (b) encadeada reversa, encadeada transversa, circular e estática " [:br]
         [:input {:type "radio" :name "op" :value "l1c" }]  " (C) encadeada simples, duplamente encadeada, circular e estática"  [:br]
         [:input {:type "radio" :name "op" :value "l1d" }]  " (D) Nenhuma das alternativas anteriores." [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/lista/2"] {:keys [op]}
(pedagogico-corretor "lista" "ex1" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/3" :method "post" :name "form"}
         [:center [:h5 "LISTA"]]
         [:p "2) Como inicializar uma lista  "]
         [:input {:type "radio" :name "op" :value "l2a" }]  " (A) Lista %L"  [:br]
         [:input {:type "radio" :name "op" :value "l2b" }]  " (b) Lista &L" [:br]
         [:input {:type "radio" :name "op" :value "l2c" }]  " (C) Lista *L"  [:br]
         [:input {:type "radio" :name "op" :value "l2d" }]  " (D) Lista #L" [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/lista/3"] {:keys [op]}
(pedagogico-corretor "lista" "ex2" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/4" :method "post" :name "form"}
         [:center [:h5 "LISTA"]]
         [:p "3) Escolha a afirmativa errada "]
         [:input {:type "radio" :name "op" :value "l3a" }]  " (A) Pode-se ter acesso a qualquer elemento"  [:br]
         [:input {:type "radio" :name "op" :value "l3b" }]  " (b) Se só inserer no fim e remover no inicio, representa uma Fila" [:br]
         [:input {:type "radio" :name "op" :value "l3c" }]  " (C) Não existe restrições em relação a posição dos elementos"  [:br]
         [:input {:type "radio" :name "op" :value "l3d" }]  " (D) Existe restrições em relação a posição dos elementos" [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/lista/4"] {:keys [op]}
(pedagogico-corretor "lista" "ex3" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/5" :method "post" :name "form"}
         [:center [:h5 "LISTA"]]
         [:p "4) Quais são as informações essencias para reproduzir uma lista encadeada "]
         [:input {:type "radio" :name "op" :value "l4a" }]  " (A) tamanho, elemento do meio"  [:br]
         [:input {:type "radio" :name "op" :value "l4b" }]  " (b) primeiro e ultimo elementos" [:br]
         [:input {:type "radio" :name "op" :value "l4c" }]  " (C) primeiro e o proximo"  [:br]
         [:input {:type "radio" :name "op" :value "l4d" }]  " (D) Nenhuma das anteriores" [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/lista/5"] {:keys [op]}
(pedagogico-corretor "lista" "ex2" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/6" :method "post" :name "form"}
         [:center [:h5 "LISTA"]]
         [:p "5) O que este código quer dizer : p = list; list = next(p); x = info(p);"]
         [:input {:type "radio" :name "op" :value "l5a" }]  " (A) Pega o elemento central"  [:br]
         [:input {:type "radio" :name "op" :value "l5b" }]  " (b) Imprime o primeiro elemento" [:br]
         [:input {:type "radio" :name "op" :value "l5c" }]  " (C) Imprime o ultimo elemento"  [:br]
         [:input {:type "radio" :name "op" :value "l5d" }]  " (D) Remove o primeiro elemento" [:br] [:br][:br] 
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))

(defpage [:post "/login/lista/6"] {:keys [op]}
(pedagogico-corretor "lista" "ex5" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/7" :method "post" :name "form"}
         [:center [:h5 "LISTA"]]  
         [:p "6) struct n{ int info; struct node *next;};"]
         [:p "O que a estrutura acima representa ? "]
         [:input {:type "radio" :name "op" :value "l6a" }]  " (A) Um nó para representar uma lista estática"  [:br]
         [:input {:type "radio" :name "op" :value "l6b" }]  " (b) Um nó para representar uma lista dinâmica" [:br]
         [:input {:type "radio" :name "op" :value "l6c" }]  " (C) O maior elemento de uma lista e seu próximo"  [:br]
         [:input {:type "radio" :name "op" :value "l6d" }]  " (D) Remove o primeiro elemento" [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))

(defpage [:post "/login/lista/7"] {:keys [op]}
(pedagogico-corretor "lista" "ex6" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/8" :method "post" :name "form"}
         [:center [:h5 "LISTA"]]
         [:p "7) N getNode(){ N p; p = (N) malloc(sizeof(struct n));return(p);}"]
         [:p "O que esse código faz ?"]
         [:input {:type "radio" :name "op" :value "l7a" }]  " (A) Aloca uma lista estática e retorna a mesma"  [:br]
         [:input {:type "radio" :name "op" :value "l7b" }]  " (b) Aloca uma lista dinâmica e retorna a mesma " [:br]
         [:input {:type "radio" :name "op" :value "l7c" }]  " (C) Aloca uma lista usando outra lista"  [:br]
         [:input {:type "radio" :name "op" :value "l7d" }]  " (D) Nenhuma das anteriores" [:br] [:br][:br] 
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))

(defpage [:post "/login/lista/8"] {:keys [op]}
(pedagogico-corretor "lista" "ex7" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/9" :method "post" :name "form"}
         [:center [:h5 "LISTA"]]
         [:p "8) void Func (TipoLista &Lista) {Lista.Primeiro = InicioArranjo;Lista.Ultimo = InicioArranjo;}"]
         [:p "Qual a alteração que este código faz na Lista"]
         [:input {:type "radio" :name "op" :value "l8a" }]  " (A) Verifica se está cheia"  [:br]
         [:input {:type "radio" :name "op" :value "l8b" }]  " (b) Faz a lista ficar vazia" [:br]
         [:input {:type "radio" :name "op" :value "l8c" }]  " (C) Verifica se está vazia"  [:br]
         [:input {:type "radio" :name "op" :value "l8d" }]  " (D) Nenhuma das anteriores" [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/lista/9"] {:keys [op]}
(pedagogico-corretor "lista" "ex8" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/10" :method "post" :name "form"}
         [:center [:h5 "LISTA"]]
         [:p "9) Para buscar um item em uma lista encadeada ... "]
         [:input {:type "radio" :name "op" :value "l9a" }]  " (A) Busca direto pelo indice"  [:br]
         [:input {:type "radio" :name "op" :value "l9b" }]  " (b) Percorre toda a lista" [:br]
         [:input {:type "radio" :name "op" :value "l9c" }]  " (C) Percorre até achar o item"  [:br]
         [:input {:type "radio" :name "op" :value "l9d" }]  " (D) Nenhuma das anteriores" [:br] [:br][:br] 
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/lista/10"] {:keys [op]}
(pedagogico-corretor "lista" "ex9" op)
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/lista/fim" :method "post" :name "form"}
         [:center [:h5 "LISTA"]]
         [:p "10) Qual tipo de lista esse código representa: struct L {int info; struct L *prox; struct LDE *ante; };  "]
         [:input {:type "radio" :name "op" :value "l10a" }]  " (A) Lista estática"  [:br]
         [:input {:type "radio" :name "op" :value "l10b" }]  " (b) Lista encadeada simples" [:br]
         [:input {:type "radio" :name "op" :value "l10c" }]  " (C) Lista duplamente encadeada"  [:br]
         [:input {:type "radio" :name "op" :value "l10d" }]  " (D) Nenhuma das anteriores" [:br] [:br][:br]
         [:button {:class "botaoQuestoes" :onclick "return verificaRadio();"} "Avançar"]]]))


(defpage [:post "/login/lista/fim"] {:keys [op]}
(pedagogico-corretor "lista" "ex10" op)
(atualiza-todo-dominio (recupera-id (session/get :senhaUsuario)) "lista")   
(cond (> (get (nth (retorna-exercicio-certos-dominio (recupera-id (session/get :senhaUsuario)) "lista") 0) :bom) 0.5)
  (common/layout
         [:body {:id "fundoiframe" :onload "alteraVisibilidadeFila1(); mudaCorPretoLista(); mudaCorAzulFila()"} 
         [:center [:h5 "Lista"]]
         [:center [:h2 "Você terminou as atividades de lista! "]]
         [:center [:h4 "Fico feliz, pois você teve um conhecimento acima de 50%"]]
         [:center [:h4 "Sendo assim, pode proseguir a responder as questões."]]
         [:center [:h4 "Vamos para o centeúdo de Fila, o link apareceu ao lado"]]])
   :else 
     (common/layout
         [:body {:id "fundoiframe" :onload "alteraVisibilidadeAlocacao(); alteraVisibilidadeVetor1Inv();"} 
         [:center [:h5 "VETOR" ]]
         [:center [:h2 "Você terminou as atividades de lista! "]]
         [:center [:h4 "Fico triste, pois você não se saiu bem"]]
         [:center [:h4 "Sendo assim, não pode prosseguir."]]
         [:center [:h4 "Te indico o conteúdo de alocação dinâmica novamente, apareceu o link ao lado."]]]  
         )))


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
         [:button {:class "botaoQuestoes" :onclick "testeFila();"} "Avançar para questões"]]]))



(defpage [:post "/login/fila/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/2" :method "post"}
         [:center [:h5 "FILA"]]
         [:p "1) As estruturas de fila, como o próprio nome diz, são como uma fila em um banco."] 
         [:p "Desconsiderando a possibilidade de prioridades dessa  fila, marque a alternativa correta que define a propriedade de uma fila. "]
         [:input {:type "radio" :name "f1" :value "f1a" }]  " (A) FIFO (first in, first out)"  [:br]
         [:input {:type "radio" :name "f1" :value "f1b" }]  " (b) LIFO (last in, first out) "  [:br]
         [:input {:type "radio" :name "f1" :value "f1c" }]  " (C) FILO (first in, last out)"   [:br]
         [:input {:type "radio" :name "f1" :value "f1d" }]  " (D) LILO (last in, last out)"    [:br] [:br][:br]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/fila/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/3" :method "post" :name "form"}
         [:center [:h5 "FILA"]]
         [:p "2) Como uma fila pode ser representada em C?"]
         [:input {:type "radio" :name "op" :value "f2a" }]  " (A) Vetor, Lista('mudando as propriedades')"  [:br]
         [:input {:type "radio" :name "op" :value "f2b" }]  " (b) Struct, pilha"  [:br]
         [:input {:type "radio" :name "op" :value "f2c" }]  " (C) Só vetor"   [:br]
         [:input {:type "radio" :name "op" :value "f2d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br] 
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/fila/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/4" :method "post" :name "form"}
         [:center [:h5 "FILA"]]
         [:p "3) Três operações primitivas podem ser aplicadas a uma fila "]
         [:input {:type "radio" :name "op" :value "f3a" }]  " (A) Insere, Remove, Empty"  [:br]
         [:input {:type "radio" :name "op" :value "f3b" }]  " (b) Destroi, Remove, Aloca"  [:br]
         [:input {:type "radio" :name "op" :value "f3c" }]  " (C) Procura, Aloca"   [:br]
         [:input {:type "radio" :name "op" :value "f3d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/fila/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/5" :method "post" :name "form"}
         [:center [:h5 "FILA"]]
         [:p "4) Quais são os dois tipos de fila de prioriadade "]
         [:input {:type "radio" :name "op" :value "f4a" }]  " (A) insedente, descendente"  [:br]
         [:input {:type "radio" :name "op" :value "f4b" }]  " (b) comum, alterada"  [:br]
         [:input {:type "radio" :name "op" :value "f4c" }]  " (C) ascedente, descendente"   [:br]
         [:input {:type "radio" :name "op" :value "f4d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br]   
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/fila/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/6" :method "post" :name "form"}
         [:center [:h5 "FILA"]]
         [:p "5) Identifique as afirmativas verdadeiras e falsas "]
         [:p "() Na fila dinâmica, os elementos são encadeados para garantiar a organização"]
         [:p "() A fila estatica tem um numero fixo de elementos, igual o tamanho do vetor"]
         [:p "() Na fila estática os dados removidos também são eliminados do vetor"]
         [:p "() Nunca vai ocorrer Overflow na fila dinâmica"]     
         [:input {:type "radio" :name "op" :value "f5a" }]  " (A) F, F, F, F"  [:br]
         [:input {:type "radio" :name "op" :value "f5b" }]  " (b) F, V, F, V"  [:br]
         [:input {:type "radio" :name "op" :value "f5c" }]  " (C) V, V, F, F"   [:br]
         [:input {:type "radio" :name "op" :value "f5d" }]  " (D) V, V, V, F"    [:br] [:br][:br]           
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/fila/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/7" :method "post" :name "form"}
         [:center [:h5 "FILA"]]  
         [:p "6) Como é representada uma Fila estática "]
         [:input {:type "radio" :name "op" :value "f6a" }]  " (A) Usando estrutura"  [:br]
         [:input {:type "radio" :name "op" :value "f6b" }]  " (b) Usando matriz"  [:br]
         [:input {:type "radio" :name "op" :value "f6c" }]  " (C) Usando vetor"   [:br]
         [:input {:type "radio" :name "op" :value "f6d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/fila/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/8" :method "post" :name "form"}
         [:center [:h5 "FILA"]]
         [:p "7) queue {int items[MAXQUEUE]; int front, rear;};"]
         [:p "Representa Uma fila de que  forma"]
         [:input {:type "radio" :name "op" :value "f7a" }]  " (A) Cheia"  [:br]
         [:input {:type "radio" :name "op" :value "f7b" }]  " (b) Estática"  [:br]
         [:input {:type "radio" :name "op" :value "f7c" }]  " (C) Dinâmica"   [:br]
         [:input {:type "radio" :name "op" :value "f7d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/fila/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/9" :method "post" :name "form"}
         [:center [:h5 "FILA"]]
         [:p "8) Fila* func(void) "]
         [:p "O que isto quer representar"]
         [:input {:type "radio" :name "op" :value "f8a" }]  " (A) Destruição da fila"  [:br]
         [:input {:type "radio" :name "op" :value "f8b" }]  " (b) Criação da Fila"  [:br]
         [:input {:type "radio" :name "op" :value "f8c" }]  " (C) Remoção de um item da Fila"   [:br]
         [:input {:type "radio" :name "op" :value "f8d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))



(defpage [:post "/login/fila/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/10" :method "post" :name "form"}
         [:center [:h5 "FILA"]]
         [:p "9) void func(Fila* f, float v); "]
         [:p "O que essa função representa em uma fila ?"]
         [:input {:type "radio" :name "op" :value "f9a" }]  " (A) Inserção de um item"  [:br]
         [:input {:type "radio" :name "op" :value "f9b" }]  " (b) Criação da Fila"  [:br]
         [:input {:type "radio" :name "op" :value "f9c" }]  " (C) Remoção de um item da Fila"   [:br]
         [:input {:type "radio" :name "op" :value "f9d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br] 
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/fila/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/fila/fim" :method "post" :name "form"}
         [:center [:h5 "FILA"]]
         [:p "10) Fila* f = (Fila*) malloc(sizeof(Fila));f->ini = f->fim = 0; "]
         [:p "Onde essas operações são feitas na modelagem de uma Fila :"]
         [:input {:type "radio" :name "op" :value "f10a" }]  " (A) Inserção"  [:br]
         [:input {:type "radio" :name "op" :value "f10b" }]  " (b) Alteração"  [:br]
         [:input {:type "radio" :name "op" :value "f10c" }]  " (C) Remoção"   [:br]
         [:input {:type "radio" :name "op" :value "f10d" }]  " (D) Criação"    [:br] [:br][:br]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/fila/fim"] []
     (common/layout
         [:body {:id "fundoiframe" :onload "alteraVisibilidadePilha1(); mudaCorPretoFila(); mudaCorAzulPilha()"} 
         [:center [:h5 "FILA"]]
         [:center [:h2 "Você terminou as atividades de Fila! "]]]  
         ))



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
         [:button {:class "botaoQuestoes" :onclick "testePilha();"} "Avançar para questões"]]]))



(defpage [:post "/login/pilha/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/2" :method "post"}
         [:center [:h5 "PILHA"]]
         [:p "As estruturas de pilha, como o próprio nome diz, são como uma pilha de pratos em um restaurante: você sempre pega o prato que está por cima."] 
         [:p "Fazendo esta analogia, as estruturas de pilha são, por definição:"]
         [:input {:type "radio" :name "p1" :value "p1a" }]  " (A) FIFO (first in, first out)"  [:br]
         [:input {:type "radio" :name "p1" :value "p1b" }]  " (b) LIFO (last in, first out) "  [:br]
         [:input {:type "radio" :name "p1" :value "p1c" }]  " (C) FILO (first in, last out)"   [:br]
         [:input {:type "radio" :name "p1" :value "p1d" }]  " (D) LILO (last in, last out)"    [:br] [:br][:br] 
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/pilha/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/3" :method "post" :name "form"}
         [:center [:h5 "PILHA"]]
         [:p "2) Uma pilha os itens podem ser inseridos e eliminados itens em uma extremidade chamada"]
         [:input {:type "radio" :name "op" :value "p2a" }]  " (A) FIRST"  [:br]
         [:input {:type "radio" :name "op" :value "p2b" }]  " (b) TOPO"  [:br]
         [:input {:type "radio" :name "op" :value "p2c" }]  " (C) LAST"   [:br]
         [:input {:type "radio" :name "op" :value "p2d" }]  " (D) REST"    [:br] [:br][:br] 
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/pilha/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/4" :method "post" :name "form"}
         [:center [:h5 "PILHA"]]
         [:p "3) Uma pilha é um objeto dinâmico, constantemente ..."]
         [:input {:type "radio" :name "op" :value "p3a" }]  " (A) Mutável"  [:br]
         [:input {:type "radio" :name "op" :value "p3b" }]  " (b) Imutável"  [:br]
         [:input {:type "radio" :name "op" :value "p3c" }]  " (C) Fixo"   [:br]
         [:input {:type "radio" :name "op" :value "p3d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/pilha/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/5" :method "post" :name "form"}
         [:center [:h5 "PILHA"]]
         [:p "4) As mudanças que podem ser introduzidas numa pilha recebem nomes especiais."]
         [:input {:type "radio" :name "op" :value "p4a" }]  " (A) Insere,move "  [:br]
         [:input {:type "radio" :name "op" :value "p4b" }]  " (b) Insere,modifica"  [:br]
         [:input {:type "radio" :name "op" :value "p4c" }]  " (C) Empiha e Desempilha"   [:br]
         [:input {:type "radio" :name "op" :value "p4d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/pilha/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/6" :method "post"}
         [:center [:h5 "PILHA"]]
         [:p "5) Quais os nomes das operações utilizadas em uma pilha "]
         [:input {:type "radio" :name "op" :value "p5a" }]  " (A) Push, Pop"  [:br]
         [:input {:type "radio" :name "op" :value "p5b" }]  " (b) Pep, Pop"  [:br]
         [:input {:type "radio" :name "op" :value "p5c" }]  " (C) Peek, Push"   [:br]
         [:input {:type "radio" :name "op" :value "p5d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/pilha/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/7" :method "post" :name "form"}
         [:center [:h5 "PILHA"]]  
         [:p "6) Qual problema que pode ocorrer com a operação pop "]
         [:input {:type "radio" :name "op" :value "p6a" }]  " (A) A pilha pode estar cheia"  [:br]
         [:input {:type "radio" :name "op" :value "p6b" }]  " (b) A pilha pode estar vazia"  [:br]
         [:input {:type "radio" :name "op" :value "p6c" }]  " (C) A pilha pode estar desalocada"   [:br]
         [:input {:type "radio" :name "op" :value "p6d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/pilha/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/8" :method "post" :name "form"}
         [:center [:h5 "PILHA"]]
         [:p "7) O que a operação empty(s) em uma pilha determina "]
         [:input {:type "radio" :name "op" :value "p7a" }]  " (A) Se está desalocada"  [:br]
         [:input {:type "radio" :name "op" :value "p7b" }]  " (b) Se está cheia"  [:br]
         [:input {:type "radio" :name "op" :value "p7c" }]  " (C) Se está alocada"   [:br]
         [:input {:type "radio" :name "op" :value "p7d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br]   
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/pilha/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/9" :method "post" :name "form"}
         [:center [:h5 "PILHA"]]
         [:p "8) struct stack *ps;{if (ps->top == -1) return(TRUE); else return(FALSE) ; }"]
         [:p "O que este código quer indicar" ]
         [:input {:type "radio" :name "op" :value "p8a" }]  " (A) Se a pilha tem elemento"  [:br]
         [:input {:type "radio" :name "op" :value "p8b" }]  " (b) Se a pilha está cheia"  [:br]
         [:input {:type "radio" :name "op" :value "p8c" }]  " (C) Se está vazia"   [:br]
         [:input {:type "radio" :name "op" :value "p8d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/pilha/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/10" :method "post" :name "form"}
         [:center [:h5 "PILHA"]]
         [:p "9) func(ps, x) {ps->items[++(ps->top)] = x; return;}"]
         [:p "O que este código faz" ]
         [:input {:type "radio" :name "op" :value "p9a" }]  " (A) Insere um item"  [:br]
         [:input {:type "radio" :name "op" :value "p9b" }]  " (b) Remove um item"  [:br]
         [:input {:type "radio" :name "op" :value "p9c" }]  " (C) Altera um item"   [:br]
         [:input {:type "radio" :name "op" :value "p9d" }]  " (D) Nenhuma das anteriores"    [:br] [:br][:br]  
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/pilha/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/pilha/fim" :method "post" :name "form"}
         [:center [:h5 "PILHA"]]
         [:p "10) O que deve ser feito para evitar um overflow em uma pilha o que deve ser feito "]
         [:input {:type "radio" :name "op" :value "p10a" }]  " (A) Verificar tem item"  [:br]
         [:input {:type "radio" :name "op" :value "p10b" }]  " (b) Verificar se não tem item"  [:br]
         [:input {:type "radio" :name "op" :value "p10c" }]  " (C) Altera um item"   [:br]
         [:input {:type "radio" :name "op" :value "p10d" }]  " (D) Checa se pode alocar mais memoria"    [:br] [:br][:br] 
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/pilha/fim"] []
     (common/layout
         [:body {:id "fundoiframe" :onload "alteraVisibilidadeArvore1(); mudaCorPretoPilha(); mudaCorAzulArvore()"} 
         [:center [:h5 "Pilha"]]
         [:center [:h2 "Você terminou as atividades de pilha! "]]] 
         ))



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
         [:button {:class "botaoQuestoes" :onclick "testeArvore()"} "Avançar para questões"]]]))



(defpage [:post "/login/arvore/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/arvore/2" :method "post"}
         [:center [:h5 "ÁRVORE"]]
         [:p "1) Marque a alternatica correta referente à justificativa de uso de estruturas de árvore: "]
         [:input {:type "radio" :name "arv1" :value "arv1a" }]  " (A) Árvores não requerem algoritmos de busca eficientes."  [:br]
         [:input {:type "radio" :name "arv1" :value "arv1b" }]  " (b) Árvores são estruturas hierárquicas, que facilitam o uso em determinadas aplicações. "  [:br]
         [:input {:type "radio" :name "arv1" :value "arv1c" }]  " (C) Árvores propiciam algoritmos de inserção e remoção em muitos casos."   [:br]
         [:input {:type "radio" :name "arv1" :value "arv1d" }]  " (D) Todas as alternativas anteriores."    [:br] [:br][:br]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/arvore/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/arvore/3" :method "post"}
         [:center [:h5 "ÁRVORE"]]
         [:p "2) Marque a alternativa correta referente a um algoritmo eficiente de busca em grafos: "]
         [:input {:type "radio" :name "arv1" :value "arv1a" }]  " (A) huffman"  [:br]
         [:input {:type "radio" :name "arv1" :value "arv1b" }]  " (b) shellsort "  [:br]
         [:input {:type "radio" :name "arv1" :value "arv1c" }]  " (C) dijkstra"   [:br]
         [:input {:type "radio" :name "arv1" :value "arv1d" }]  " (D) quicksort"    [:br] [:br][:br] 
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
         [:form {:action "/login/arvore/fim" :method "post"}
         [:center [:h5 "ÁRVORE"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/arvore/fim"] []
     (common/layout
         [:body {:id "fundoiframe" :onload "alteraVisibilidadeMetOrd1(); mudaCorPretoArvore(); mudaCorAzulMetOrd()"} 
         [:center [:h5 "ÁRVORE"]]
         [:center [:h2 "Você terminou as atividades de Árvore! "]]
         ]))




;/********************************************************************/
;/****************************** Met-Ord *******************************/
;/********************************************************************/



(defpage "/login/metOrd" []
      (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metOrd/1" :method "post"}
         [:center [:h5 "Metodos de Ordenação"]] 
         [:p "Um grafo G = (V, E) é um conjunto não-vazio V de vértices, e 
              um conjunto E de arestas. Cada aresta é um par (vi , v j ), 
              sendo vi e v j elementos de V. Como exemplo de um grafo direcionado, 
              podemos considerar a malha aérea de uma região, de forma que os vértices 
              do grafo representem os aeroportos, que são conectados por vôos."]
         [:button {:class "botaoQuestoes" :onclick "testeMetOrd();"} "Avançar para questões"]]]))



(defpage [:post "/login/metOrd/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metOrd/2" :method "post"}
         [:center [:h5 "Metodos de Ordenação"]]
         [:p "1) Um grafo direcionado acíclico em alguns casos, pode representar outra estrutura. Marque a alternativa correta: "]
         [:input {:type "radio" :name "g1" :value "g1a" }]  " (A) fila"  [:br]
         [:input {:type "radio" :name "g1" :value "g1b" }]  " (b) pilha"  [:br]
         [:input {:type "radio" :name "g1" :value "g1c" }]  " (C) árvore"   [:br]
         [:input {:type "radio" :name "g1" :value "g1d" }]  " (D) todas as anteriores."    [:br] [:br][:br]   
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/metOrd/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metOrd/3" :method "post"}
         [:center [:h5 "Metodos de Ordenação"]]
         [:p "Questão 2 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/metOrd/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metOrd/4" :method "post"}
         [:center [:h5 "Metodos de Ordenação"]]
         [:p "Questão 3 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/metOrd/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metOrd/5" :method "post"}
         [:center [:h5 "Metodos de Ordenação"]]
         [:p "Questão 4 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/metOrd/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metOrd/6" :method "post"}
         [:center [:h5 "Metodos de Ordenação"]]
         [:p "Questão 5 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/metOrd/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metOrd/7" :method "post"}
         [:center [:h5 "Metodos de Ordenação"]]  
         [:p "Questão 6 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/metOrd/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metOrd/8" :method "post"}
         [:center [:h5 "Metodos de Ordenação"]]
         [:p "Questão 7 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/metOrd/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metOrd/9" :method "post"}
         [:center [:h5 "Metodos de Ordenação"]]
         [:p "Questão 8 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/metOrd/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metOrd/10" :method "post"}
         [:center [:h5 "Metodos de Ordenação"]]
         [:p "Questão 9 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/metOrd/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metOrd/fim" :method "post"}
         [:center [:h5 "Metodos de Ordenação"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/metOrd/fim"] []
     (common/layout
         [:body {:id "fundoiframe" :onload "alteraVisibilidadeMetPesq1(); mudaCorPretoMetOrd(); mudaCorAzulMetPesq()"} 
         [:center [:h5 "Metodos de Ordenação"]]
         [:center [:h2 "Você terminou as atividades de metodos de ordenação! "]]
         ]))



;/*******************************************************************/
;/*************************** Métodos de Pesquisa *******************/
;/*******************************************************************/



(defpage "/login/metPesq" []
      (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metPesq/1" :method "post"}
         [:center [:h5 "Metodos de Pesquisa"]] 
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
         [:button {:class "botaoQuestoes" :onclick "testeMetPesq();"} "Avançar para questões"]]]))



(defpage [:post "/login/metPesq/1"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metPesq/2" :method "post"}
         [:center [:h5 "Metodos de Pesquisa"]]
         [:p "1) O algoritmo de huffman utiliza como estrutura principal: "]
         [:input {:type "radio" :name "c1" :value "c1a" }]  " (A) Uma fila."  [:br]
         [:input {:type "radio" :name "c1" :value "c1b" }]  " (b) Uma pilha."  [:br]
         [:input {:type "radio" :name "c1" :value "c1c" }]  " (C) Uma árvore."   [:br]
         [:input {:type "radio" :name "c1" :value "c1d" }]  " (D) Uma lista."    [:br] [:br][:br]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/metPesq/2"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metPesq/3" :method "post"}
         [:center [:h5 "Metodos de Pesquisa"]]
         [:p "Questão 2 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/metPesq/3"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metPesq/4" :method "post"}
         [:center [:h5 "Metodos de Pesquisa"]]
         [:p "Questão 3 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/metPesq/4"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metPesq/5" :method "post"}
         [:center [:h5 "Metodos de Pesquisa"]]
         [:p "Questão 4 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/metPesq/5"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metPesq/6" :method "post"}
         [:center [:h5 "Metodos de Pesquisa"]]
         [:p "Questão 5 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/metPesq/6"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metPesq/7" :method "post"}
         [:center [:h5 "Metodos de Pesquisa"]]  
         [:p "Questão 6 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/metPesq/7"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metPesq/8" :method "post"}
         [:center [:h5 "Metodos de Pesquisa"]]
         [:p "Questão 7 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/metPesq/8"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metPesq/9" :method "post"}
         [:center [:h5 "Metodos de Pesquisa"]]
         [:p "Questão 8 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/metPesq/9"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metPesq/10" :method "post"}
         [:center [:h5 "Metodos de Pesquisa"]]
         [:p "Questão 9 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))


(defpage [:post "/login/metPesq/10"] []
     (common/layout
         [:body {:id "fundoiframe"} 
         [:form {:action "/login/metPesq/fim" :method "post"}
         [:center [:h5 "Metodos de Pesquisa"]]
         [:p "Questão 10 "]
         [:button {:class "botaoQuestoes"} "Avançar"]]]))

(defpage [:post "/login/metPesq/fim"] []
     (common/layout
         [:body {:id "fundoiframe" :onclick "mudaCorPretoMetPesq();"} 
         [:center [:h5 "Metodos de Pesquisa"]]
         [:center [:h2 "Você terminou as atividades de Métodos de Pesquisa! "]]
         ]))


;*************************** FIM DAS QUESTÕES *********************************
