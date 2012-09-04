(ns ils.views.ils
  (:require [ils.views.common :as common]
            [noir.content.getting-started])
  (:use [ils.models connection]
        [noir.core :only [defpage]]
        [hiccup.core :only [html]]
        [hiccup.page-helpers :only [include-css html5]]))


(defpage "/wel" []
	(common/layout
	[:button {:onclick "teste();"} "Teste"]))


; definindo a pagina / , está é a pagina inicial do site 
; aqui o usuario pode fazer o login ou se cadastrar
; o layout está sendo usando quando colocamos (commnon/layout) 
; todas as tags estão no formato do noir e ele gerá o html das mesmas

;:::::::::::::::::::::::: / :::::::::::::::::::::::::::

(defpage "/" []
        (common/layout
        [:head
        [:script {:type "text/javascript" :src "/js/slideshowfade.js"}]]
	[:body
        [:div {:id "wrap"}
	[:div {:id "back_header" }]
	[:div {:id "back_last" }]
        [:form {:action "/login/welcome/pratica" :method "post"}
        [:a {:href "/login/cadastro"} [:p {:id "menu"} "cadastre-se"]]
        [:p {:id "menu_u"} "usuário: "
        [:input {:type "text" :class "inputStyle1" :name "usuario"}]]
        [:p {:id "menu_s"} "senha: "
        [:input {:type "password" :class "inputStyle2" :name "senha"}]]
        [:button {:class "botaoConfirma"} "Entrar"]]
        [:p {:id "cop"} "&#169; Copyright 2012 - ILS"]]]))
	;[:image {:src "/img/intro.png" :id "alinha"}]]]))


;::::::::::::::::::::::::::::::: /login/welcome/pratica :::::::::::::::::::::::::::::::

;Página que contem a parte prática dos exercícios, com perguntas que são resolvidos
;em códigos de programação. Está também ajuda a definir um modelo do estudante, pois
;poderá obter dados do estudante vindos da interface.

;O NOME DEVE VIR DA PAGINA INICIAL


(defpage [:post "/login/welcome/pratica"] {:keys [usuario senha]}     
      (common/layout
       [:body
       [:div {:id "header_1"}]
       [:div {:id "header_2"}]
       [:div {:id "header_3"}]
       [:div {:id "header_exercicios"}]
       [:div {:id "header_4"}]
       [:div {:id "header_5"}]
       [:image {:src "/img/intro_small.png" :id "header_logo"}]
       [:p {:id "usuariosPratica"} usuario]
       [:p {:id "exerc" :name "exerc"} "Exercícios"]
       [:ul
       [:li {:id "ex1" :name "exerc-1"} [:a {:class "ex" :href "" } " "]]
       [:li {:id "ex2" :name "exerc-2"} [:a {:class "ex" :href "" } " "]]
       [:li {:id "ex3" :name "exerc-3"} [:a {:class "ex" :href "" } " "]]
       [:li {:id "ex4" :name "exerc-4"} [:a {:class "ex" :href "" } " "]]
       [:li {:id "ex5" :name "exerc-5"} [:a {:class "ex" :href "" } " "]]
       [:li {:id "ex6" :name "exerc-6"} [:a {:class "ex" :href "" } " "]]
       [:li {:id "ex7" :name "exerc-7"} [:a {:class "ex" :href "" } " "]]
       [:li {:id "ex8" :name "exerc-8"} [:a {:class "ex" :href "" } " "]]
       [:li {:id "ex9" :name "exerc-9"} [:a {:class "ex" :href "" } " "]]
       [:li {:id "ex10":name "exerc-10"} [:a {:class "ex":href "" } " "]]]
       [:button {:class "botaoConfig"} "Configurações"]
       [:button {:class "botaoSair"} "Sair"]
       [:button {:class "botaoAnterior"} "anterior"]
       [:button {:class "botaoTestar"} "testar"]
       [:button {:class "botaoProximo"} "próximo"]
       [:textarea {:id "Codigo" :type "text" :name "CodigoAluno"}]
       [:p {:id "copyright"} "&#169; Copyright 2012 - ILS"]]))
 






; pagina que recebe parametros e retorna uma resposta ao usuario 
; foi definidos os parametros vindo de um post o endereço da pagina é /login/index 
; Note: Este usuario e senha são as keys que vieram da pagina /login

;::::::::::::::::::::::: /login/index ::::::::::::::::::::::::::


(defpage [:post "/login/index"] {:keys [usuario senha]}
      (common/layout
         [:body
         [:div {:id "back_recem"}]
         [:div {:id "fundo"}]
         [:div {:id "fundo2"}]
         [:div {:id "links"}
         [:iframe {:id "perguntas" :src "/login/ola" :name "principal"}]
         [:p {:id "menuLinks"} [:a {:href "/login/alocacao" :target "principal" } "Alocação Dinâmica"]]  
         [:p {:id "menuLinks"} [:a {:href "/login/vetor" :target "principal" } "Vetor"]] 
         [:p {:id "menuLinks"} [:a {:href "/login/matriz" :target "principal" } "Matriz"]] 
         [:p {:id "menuLinks"} [:a {:href "/login/recursividade" :target "principal"} "Recursividade"]]       
         [:p {:id "menuLinks"} [:a {:href "/login/lista" :target "principal"} "Lista"]]
         [:p {:id "menuLinks"} [:a {:href "/login/fila" :target "principal"} "Fila"]]
         [:p {:id "menuLinks"} [:a {:href "/login/pilha" :target "principal"} "Pilha"]]
         [:p {:id "menuLinks"} [:a {:href "/login/arvore" :target "principal"} "Árvore"]]
         [:p {:id "menuLinks"} [:a {:href "/login/grafo" :target "principal"} "Grafo"]]
         [:p {:id "menuLinks"} [:a {:href "/login/compressao" :target "principal"} "Comprenssão Dados"]]]    
         [:p {:class "logocadastro"} "ILS"]
         [:p {:class "ilscadastro"} "Olá " usuario  "| " [:a {:href "/" :id "logout"} "Logout"]]]))
  

; Pagina responsavel pelo cadastro do usuario, contendo assim 
; todos os inputs e buttons necessarios ..... Está pagina vai 
; passar esses inputs como parametros para uma outra pagina chamada 
; /login/cadastro/welcome que está definida abaixo , fazendo também 
; a inserção no banco de dados H2 . 

;:::::::::::::::::::: /login/cadastro :::::::::::::::::::::::::::


(defpage "/login/cadastro" []
	(common/layout
	[:body
	[:h2 {:id "h2"} [:center "Cadastros de Usuários"]]
        [:div {:id "back_cadastro"}]
        [:form {:id "alinhaFormCad" :action "/login/cadastro/welcome" :method "post" :name "cad"}
        [:p {:id "cad"} "Digite seu nome: "
        [:input {:type "text" :class "inputStyleCadastro" :name "nome"}]]
        [:p {:id "cad"} "Digite sua matrícula: "
        [:input {:type "integer" :class "inputStyleCadastro" :name "numeromatricula"}]]  
        [:p {:id "cad"} "Digite o Sobrenome: "
        [:input {:type "text" :class "inputStyleCadastro" :name "sobrenome"}]]
        [:p {:id "cad"} "Qual é o seu curso ?"
        [:select {:name "curso"}
        [:option {:value "Ciencia da Computação"} "Ciência da Computação"]
        [:option {:value "Sistemas de Informação"} "Sistemas de Informação"]]]
        [:p {:id "cad"} "Digite seu email:"
        [:input {:type "text" :class "inputStyleCadastro" :name "email"}]]       
        [:p {:id "cad"} "Nome de usuario:"
        [:input {:type "text" :class "inputStyleCadastro" :name "nomeUsuario"}]]
        [:p {:id "cad"} "Digite a senha:"
        [:input {:type "text" :class "inputStyleCadastro" :name "senha"}]]
        [:button {:class "botaoConfirmaCadastro" } "confirm"] 
        [:a {:class "botaoCancelaCadastro" :href "/"} "cancel"]]]))




; Está é a pagina que recebeu os inputs como parametros e fez a inserção no 
; banco de dados H2, a função insert foi criada em website/models/conecction.clj e 
; esse conecction.clj está importado em cima :use [website.models connection]
; A função insert pegou os parametros e fez a inserção no banco de dados de 
; nome sti , na tabela ALUNOS.


;:::::::::::::::::::::::::::: /login/cadastro/welcome ::::::::::::::::::::::::::

(defpage [:post "/login/cadastro/welcome"] {:keys [nome numeromatricula  sobrenome curso email nomeUsuario senha]}
  (insere-tabela-aluno numeromatricula nome sobrenome curso email nomeUsuario senha)   
      (common/layout
         [:body
         [:div {:id "back_recem"}]
         [:div {:id "fundo"}]
         [:div {:id "fundo2"}]
         [:div {:id "links"}
         [:iframe {:id "perguntas" :src "/login/ola" :name "principal"}]
         [:p {:id "menuLinks"} [:a {:href "/login/alocacao" :target "principal" } "Alocação Dinâmica"]]  
         [:p {:id "menuLinks"} [:a {:href "/login/vetor" :target "principal" } "Vetor"]] 
         [:p {:id "menuLinks"} [:a {:href "/login/matriz" :target "principal" } "Matriz"]] 
         [:p {:id "menuLinks"} [:a {:href "/login/recursividade" :target "principal"} "Recursividade"]]       
         [:p {:id "menuLinks"} [:a {:href "/login/lista" :target "principal"} "Lista"]]
         [:p {:id "menuLinks"} [:a {:href "/login/fila" :target "principal"} "Fila"]]
         [:p {:id "menuLinks"} [:a {:href "/login/pilha" :target "principal"} "Pilha"]]
         [:p {:id "menuLinks"} [:a {:href "/login/arvore" :target "principal"} "Árvore"]]
         [:p {:id "menuLinks"} [:a {:href "/login/grafo" :target "principal"} "Grafo"]]
         [:p {:id "menuLinks"} [:a {:href "/login/compressao" :target "principal"} "Comprenssão Dados"]]]    
         [:p {:class "logocadastro"} "ILS"]
         [:p {:class "ilscadastro"} "Seja bem - vindo " nome " " sobrenome " | " [:a {:href "/" :id "logout"} "Logout"]]]))







; Pagina que somente o professor/administrador vai poder acessar
;nela ele pode ver o dominio dos alunos e também inserir alunos e
; até mesmo inserir um novo professor/administrador

;::::::::::::::::::::::::::::::: /login/admin :::::::::::::::::::::::::::::::


(defpage "/login/admin" []     
      (common/layout
       [:body {:id "fundoAdmin"}  
       [:div {:id "back_header"}]
       [:div {:id "professoradmin"}
       [:iframe {:id "opcoesadmin" :src "/login/admin/obs" :name "opcoesadmin"}]
       [:h5 {:id "profadm"} "Olá professor/admin  | "]
       [:h5 {:id "adminlogout"} [:a {:href "/" :id "logout"} "Logout"]]
       [:ul
       [:li [:a {:href "/login/admin/1" :target "opcoesadmin"} "Consultar Alunos"]]
       [:li [:a {:href "/login/admin/2" :target "opcoesadmin"} "Cadastrar Professor"]] 
       [:li [:a {:href "/login/admin/3" :target "opcoesadmin"} "Remover Alunos"]] 
       [:li [:a {:href "/login/admin/4" :target "opcoesadmin"} "Alterar Dados"]]]]]))


(defpage "/login/admin/obs" []
 (common/layout
   [:body {:id "fundoiframe"}
   [:h5 "Nesta pagina você pode ver o dominio dos alunos e também inserir 
        um novo professor administrador e até mesmo remover alunos se julgar necessário."]]))    

(defpage "/login/admin/1" []
 (common/layout
   [:body {:id "fundoiframe"}    
   [:h3 [:center "Alunos Cadastrados"]]
   [:table {:border "1"}
   [:tr
   [:td [:h4 "Matricula"]]
   [:td [:h4 "Nome"]]
   [:td [:h4 "Sobrenome"]]
   [:td [:h4 "Curso"]]
   [:td [:h4 "Email"]]
   [:td [:h4 "Usuário"]]
   [:td [:h4 "Senha"]]]
   (tet) 
   ]]))    

 
   
(defpage "/login/admin/2" []
 (common/layout
   [:body {:id "fundoiframe"}
   [:h5 "Cadastrar Professor."]]))    


(defpage "/login/admin/3" []
 (common/layout
   [:body {:id "fundoiframe"}
   [:h5 "Remover Alunos."]]))

(defpage "/login/admin/4" []
 (common/layout
   [:body {:id "fundoiframe"}
   [:h5 "Alterar Dados."]]))    
    



 ; Inserindo video na página

(defpage "/video" []
 (common/layout
   [:body
   [:div {:id "header_1"}]
   [:div {:id "header_2"}]
   [:div {:id "header_3"}]
   [:video {:id "video" :controls "controls"}
   [:source {:src "/videos/Black_Eyed_Peas_-_The_Time_(Dirty_Bit).mp4" :type "video/mp4"}]]]))    

  
       







