(ns tanara.views.welcome
  (:require [tanara.views.common :as common]
            [noir.content.getting-started]
            [noir.session :as session])
  (:use [tanara.models.dominio.corygil dominio]
        [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to tanara"]
           [:button {:onclick "teste();"} "teste"]))

; definindo a pagina / , está é a pagina inicial do site 
; aqui o usuario pode fazer o login ou se cadastrar
; o layout está sendo usando quando colocamos (commnon/layout) 
; todas as tags estão no formato do noir e ele gerá o html das mesmas

;:::::::::::::::::::::::: / :::::::::::::::::::::::::::

(defpage "/" []
	(common/layout
	[:body
        [:div {:id "wrap"}
	[:div {:id "back_header" }]
        [:h1  {:id "e-adapt"} "E-ADAPT"]
        [:form {:action "/login/index" :method "post" :name "form"}
        [:a {:href "/tanara/cadastro"} [:p {:id "menu"} "cadastre-se"]]
        [:p {:id "menu_u"} "usuário: "
        [:input {:type "text" :class "inputStyle1" :name "usuario"}]]
        [:p {:id "menu_s"} "senha: "
        [:input {:type "password" :class "inputStyle2" :name "senha"}]]
        [:button {:class "botaoConfirma" :onclick "return verificaLogin();"} "Entrar"]]
	]]))

; pagina que recebe parametros e retorna uma resposta ao usuario 
; foi definidos os parametros vindo de um post o endereço da pagina é /login/index 
; Note: Este usuario e senha são as keys que vieram da pagina /login

;::::::::::::::::::::::: /login/index ::::::::::::::::::::::::::


(defpage [:post "/login/index"] {:keys [usuario senha]}
(session/remove! :senhaUsuario)
(session/put! :senhaUsuario senha)
(cond (= 1 (compara-usuario usuario senha) 1) 
        (common/layout
         [:body {:id "fundo_index"} 
         [:div {:id "princ_index"}
         [:div {:id "back_recem"}]
         [:div {:id "fundo"}]
         [:div {:id "fundo2"}]
         [:div {:id "back_mini"}]
         [:div {:id "links"} 
         [:iframe {:id "perguntas" :src "/login/ola" :name "principal"}]
         [:h3 {:id "est-dados"} "Estrutura de Dados"]
         [:p {:id "menuRecursi"} [:a {:id "alinhaLink" :href "/login/recursividade" :target "principal"} "Recursividade"]]
         [:p {:id "menuAlocacao"} [:a {:href "/login/alocacao" :target "principal" :id "Aloc" } "Alocação Dinâmica"]] 
         [:p {:id "menuVetor1"} [:a {:href "/login/vetor" :target "principal" :id "vet" } "Vetor"]]
         [:p {:id "menuVetor"} [:a {:href "/login/vetor" :target "principal"} "Vetor"]]        
         [:p {:id "menuLista"} [:a {:href "/login/lista" :target "principal"} "Lista"]]
         [:p {:id "menuFila"} [:a {:href "/login/fila" :target "principal"} "Fila"]]
         [:p {:id "menuPilha"} [:a {:href "/login/pilha" :target "principal"} "Pilha"]]
         [:p {:id "menuArvore"} [:a {:href "/login/arvore" :target "principal"} "Árvore"]]
         [:p {:id "menuMetOrd"} [:a {:href "/login/metOrd" :target "principal"} "Métodos Ordenação"]]
         [:p {:id "menuMetPesq"} [:a {:href "/login/metPesq" :target "principal"} "Métodos Pesquisa"]]]    
         [:p {:class "logocadastro"} "E-ADAPT"]
         [:h4 {:id "ativ"} "Atividades"]
         [:h5 {:id "ativ-exerc"} ""]
         [:p {:class "ilscadastro"} "Olá, " usuario  " | " [:a {:href "/" :id "logout"} "Logout"]]
         ]])
         
  :else
   (common/layout
     [:body
     [:center [:h1 "Login e/ou senha errados"]]])))

(defpage "/login/error" []
 (common/layout
  [:body
  [:center [:h1 "Login e/ou senha errados"]]]))




 ;(defpage "/login" []
  ;       (session/put! :admin true)
   ;      (common/layout
    ;       [:p "Are you loggedin? "]
     ;      [:p (session/get :admin)]))
  


(defpage "/tanara/cadastro" []
	(common/layout
	[:body
	[:h2 {:id "h2"} [:center "Cadastros de Usuários"]]
        [:div {:id "back_cadastro"}]
        [:div {:id "back_cadastro_fim"}]
        [:form {:id "alinhaFormCad" :action "/tanara/cadastro/welcome" :method "post" :name "cad"}
        [:p {:id "cadastrar"} "Digite seu nome: "
        [:input {:type "text" :class "inputStyleCadastro" :name "nome"}]]
        [:p {:id "cadastrar"} "Digite sua matrícula: "
        [:input {:type "integer" :class "inputStyleCadastro" :name "numeromatricula"}]]  
        [:p {:id "cadastrar"} "Digite o Sobrenome: "
        [:input {:type "text" :class "inputStyleCadastro" :name "sobrenome"}]]
        [:p {:id "cadastrar"} "Qual é o seu curso ?"
        [:select {:name "curso"}
        [:option {:value "Ciencia da Computação"} "Ciência da Computação"]
        [:option {:value "Sistemas de Informação"} "Sistemas de Informação"]]]
        [:p {:id "cadastrar"} "Digite seu email:"
        [:input {:type "text" :class "inputStyleCadastro" :name "email"}]]       
        [:p {:id "cadastrar"} "Nome de usuario:"
        [:input {:type "text" :class "inputStyleCadastro" :name "nomeUsuario"}]]
        [:p {:id "cadastrar"} "Digite a senha:"
        [:input {:type "password" :class "inputStyleCadastro" :name "senha"}]]
        [:button {:class "botaoConfirmaCadastro" :onclick "return cadastra();"} "confirmar"] 
        [:a {:class "botaoCancelaCadastro" :href "/"} "cancel"]]]))


(defpage [:post "/tanara/cadastro/welcome"] {:keys [nome numeromatricula  sobrenome curso email nomeUsuario senha]}
 (insere-tabela-aluno numeromatricula nome sobrenome curso email nomeUsuario senha)
 (povoar-tabelas (recupera-id senha))    
  (session/put! :senhaUsuario senha) 
   (common/layout
         [:body {:id "fundo_index"}
         [:div {:id "princ_index"}
         [:div {:id "back_recem"}]
         [:div {:id "fundo"}]
         [:div {:id "fundo2"}]
         [:div {:id "back_mini"}]
         [:div {:id "links"}
         [:iframe {:id "perguntas" :src "/login/ola" :name "principal"}]
         [:h3 {:id "est-dados"} "Estrutura de Dados"]
         [:div {:id "menuAlocacao"} [:a {:href "/login/alocacao" :target "principal" :id "Aloc" } "Alocação Dinâmica"]]  
         [:div {:id "menuVetor"} [:a {:href "/login/vetor" :target "principal"} "Vetor"]]
         [:div {:id "menuMatriz"} [:a {:href "/login/matriz" :target "principal" } "Matriz"]] 
         [:p {:id "menuRecursi"} [:a {:href "/login/recursividade" :target "principal"} "Recursividade"]]       
         [:p {:id "menuLista"} [:a {:href "/login/lista" :target "principal"} "Lista"]]
         [:p {:id "menuFila"} [:a {:href "/login/fila" :target "principal"} "Fila"]]
         [:p {:id "menuPilha"} [:a {:href "/login/pilha" :target "principal"} "Pilha"]]
         [:p {:id "menuArvore"} [:a {:href "/login/arvore" :target "principal"} "Árvore"]]
         [:p {:id "menuGrafo"} [:a {:href "/login/grafo" :target "principal"} "Grafo"]]
         [:p {:id "menuCompressao"} [:a {:href "/login/compressao" :target "principal"} "Comprenssão Dados"]]]    
         [:p {:class "logocadastro"} "E-ADAPT"]
         [:h4 {:id "ativ"} "Atividades"]
         [:h5 {:id "ativ-exerc"} ""]
         [:p {:class "ilscadastro"} "Seja bem-vindo, " nomeUsuario  " | " [:a {:href "/" :id "logout"} "Logout"]]
         ]]))
         
  


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
    




(defpage "/video" []
 (common/layout
   [:body
   [:video {:id "video" :controls "controls"}
   [:source {:src "/videos/aula35.mp4" :type "video/mp4"}]]]))    





