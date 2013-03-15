(ns ils.views.welcome
  (:require [ils.views.common :as common]
            [noir.content.getting-started]
            [noir.session :as session]
            )
  (:use [ils.models.estudante.corygil estudante]
        [ils.views comunicacao] 
        [ils.models.dominio.BD busca]
        [ils.models.dominio.BD insercao]
        [ils.models.dominio.xml manipulacao] 
        [noir.core :only [defpage]]
        [hiccup.core :only [html]]
        [noir.core :only [defpartial]]
        ;[noir.response :only [redirect]]
        [hiccup.page-helpers :only [include-css html5 include-js html5]]
 ))



; definindo a pagina / , está é a pagina inicial do site 
; aqui o usuario pode fazer o login ou se cadastrar
; o layout está sendo usando quando colocamos (commnon/layout) 
; todas as tags estão no formato do noir e ele gerá o html das mesmas


(defpage "/" []
       (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]
                [:link {:rel "stylesheet" :href "/css/carousel.css"}]
                [:link {:rel "stylesheet" :href "/css/carousel-style.css"}]]
         [:body  
         [:div {:id "footer"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         ]]]
         [:div {:class "navbar navbar-inverse"}
         [:div {:class "navbar-inner"}
         [:form {:action "/index_init" :method "post" :name "form" :class "form-inline"}
         [:ul {:class "nav"}
         [:li
         [:a {:href "#myModal" :role "button" :data-toggle "modal"} "Cadastre-se"]]
         [:li [:a {:href "#History" :role "button" :data-toggle "modal"}"História"]]
         [:li [:input {:id "inputUsuario" :class "input-medium" :type "text" :placeholder "Usuário" :name "usuario"}]]
         [:li [:input {:id "inputSenha"   :class "input-medium" :type "password" :placeholder "Senha" :name "senha"}]] 
         [:button {:class "btn btn-info" :id "botaoConfirma" :onclick "return verificaLogin()"} "Entrar"]
         ]]]]



         [:div {:class "container" :id "container_slide" } 
         [:div {:id "myCarousel" :class "carousel slide"}
   	 [:div {:class "carousel-inner"}
         [:div {:class "active item"}
      	 ;[:img {:src "/img/educa.png" :width "900" :height "600" }]]
         ;[:div {:class "item"}
      	 ;[:img {:src"/img/Untitled-1.jpg" :width "900" :height "600" }]]
         ;[:div {:class "item"}
         [:img {:src "/img/Untitled-2.jpg" :width "900" :height "600" }]
         ]]
         [:a {:id "next" :class "carousel-control right" :href "#myCarousel" :data-slide "next"}"&rsaquo;"]  
         [:a {:id "prev" :class "carousel-control left"  :href "#myCarousel" :data-slide "prev"}"&lsaquo;"]
         ]] ;end Div "Container"
          [:script "$('.carousel').carousel({
          interval: 7000 })"]
          

 
         ; Definindo o modal do cadastro

         [:div {:id "myModal" :class "modal hide fade" :tabindex "-1" :role "dialog" 
               :aria-labelledby "myModalLabel" :aria-hidden "true"}
         [:div {:class "modal-header"}
         [:button {:type "button" :class "close" :data-dismiss "modal" :aria-hidden "true"}"×"]
         [:h3 {:id "myModalLabel"} "Cadastro de Usuários"]
         ]
         [:form  {:class "form-horizontal" :method "post" :name "cad" :action "/login/cadastro/welcome"}
         [:div {:class "modal-body" :id "cadastro_body"}  
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "inputName"} "Nome:"]
         [:div   {:class "controls"}
         [:input {:type "text" :id "inputNome" :placeholder "Nome" :name "nome"}]
         ]]
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "inputSobrenome"} "Sobrenome:"]
         [:div   {:class "controls"}
         [:input {:type "text" :id "inputNome" :placeholder "Sobrenome" :name "sobrenome"}]
         ]]
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "inputMatricula"} "Matricula:"]
         [:div   {:class "controls"}
         [:input {:type "text" :id "inputNome" :placeholder "N° Matrícula" :name "numeromatricula"}]
         ]] 
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "inputCurso"} "Curso:"]
         [:div   {:class "controls"}
         [:select {:id "inputCurso" :name "curso"}
         [:option {:value "Ciencia da Computação"} "Ciência da Computação"]
         [:option {:value "Sistemas de Informação"} "Sistemas de Informação"]]
         ]]
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "inputEmail"} "Email:"]
         [:div   {:class "controls"}
         [:input {:type "text" :id "inputEmail" :placeholder "Email" :name "email"}]
         ]] 
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "inputUsuario"} "Usuario:"]
         [:div   {:class "controls"}
         [:input {:type "text" :id "inputUsuarioCadastro" :placeholder "Úsuario" :name "nomeUsuario"}]
         ]]
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "inputSenha"} "Senha:"]
         [:div   {:class "controls"}
         [:input {:type "password" :id "inputSenhaCadastro" :placeholder "Senha" :name "senha"}]
         ]]
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "inputDisciplina"} "Disciplina:"]
         [:div   {:class "controls"}
         [:select {:id "inputDisciplina" :name "disciplina"}
         [:option {:value "Estrutura de Dados"} "Estrutura de Dados"]
         [:option {:value "Introdução a Programação"} "Introdução a Programação"]]
         ]]]
         [:div {:class "modal-footer"}
         [:div   {:class "control-group"}
         [:button {:class "btn btn-danger" :data-dismiss "modal" :arial-hidden "true"} "Cancelar"]
         [:button {:class "btn btn-primary" :onclick "return cadastra();" :formaction "/login/cadastro/welcome"} "Confirmar"]
         ]]]]
         ;End modal cadastro
         
         ;Definindo modal da hitória do ILS
         [:div {:id "History" :class "modal hide fade" :tabindex "-1" :role "dialog" :aria-labelledby "HistoryLabel" :aria-hidden "true"}
         [:div {:class "modal-header"}
         [:button {:type "button" :class "close" :data-dismiss "modal" :aria-hidden "true"}"×"]
         [:h3 {:id "HistoryLabel"} "História"]
         ]
         [:div {:class "modal-body"}
         [:p "O ILS é um projeto que se iniciou em 2012, voltado para o ensino ..."]
         ]
         [:div {:class "modal-footer"}
         [:button {:class "btn btn-danger" :data-dismiss "modal" :arial-hidden "true"} "Close"]]
         ]
         ;End modal história do ILS
         [:div {:class "modal-footer"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:a {:href "http://martinbean.co.uk"} "Help "] 
         [:a {:href "#" } " Política de Privacidade"]
         [:center [:h5  "&#169; Copyright 2013 - ILS"]] ]]]
         ]))


(defpage "/carousel" [] 
   (common/layout
   [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]
   [:link {:rel "stylesheet" :href "/css/carousel.css"}]
   [:link {:rel "stylesheet" :href "/css/carousel-style.css"}]]
   [:body {:id "fundo_index"}
   [:div {:class "container"}
   [:div {:id "myCarousel" :class "carousel slide"}
   [:div {:class "carousel-inner"}
   ;[:div {:class "m-carousel m-fluid m-carousel-photos"}
   [:div {:class "m-carousel-inner"}
   [:div {:class "m-item"}
      [:img {:src "/img/ils.jpg" :width "900" :height "600"}]
   ]
   [:div {:class "m-item"}
      [:img {:src"/img/Untitled-1.jpg" :width "900" :height "600"}]
   ]
   [:div {:class "m-item"}
      [:img {:src "/img/Untitled-2.jpg" :width "900" :height "600"}]
   ]]
   [:div {:class "m-carousel-controls m-carousel-bulleted"}
    [:a {:href "#" :data-slide "1" :id "links_slide"}"1"]
    [:a {:href "#" :data-slide "2" :id "links_slide"}"2"]
    [:a {:href "#" :data-slide "3" :id "links_slide"}"3"] 
    ]]
     [:a {:id "prev" :class "carousel-control left"  :href "#myCarousel" :data-slide "prev"}"&lsaquo;"]
         [:a {:id "next" :class "carousel-control right" :href "#myCarousel" :data-slide "next"}"&rsaquo;"]]
     
    [:script {:type "text/javascript" :src "/js/carousel.js"}]
    [:script "$('.m-carousel').carousel()"]
    ]]))   



; Página de erro, ela é invocada se o login não estiver correto


(defpage "/login/erro" []
    (common/layout
     [:body {:class "hero-unit"}
     [:div {:class "container"}
     [:h1 ""]
     [:div {:class "modal-body"}
     [:center [:h1 "Error!"]]
     [:center [:h4 "Úsuario e/ou senha incorreto(s)"]]
     [:center [:h4 "Certifique suas entradas"]]
     [:center [:a {:class "btn btn-large  btn-primary" :id "link_error" :href "/"} "Voltar"]]
     ]]]))   



; Testando o redirect
        
;(defpage "/teste" []
;     (redirect "/login/erro"))   

      

(defpage [:post "/testarConsole"] {:keys [op]}
   (common/layout
     [:body {:id "fundoConsole"}
     [:textarea {:class "consoleTextArea" :id "consoleTextArea"} (str ">>> " op)]]))

(defpage "/testar" []
   (common/layout
     [:body {:id "fundoConsole"}
     [:textarea {:class "consoleTextArea" :id "consoleTextArea"} ">>> "]]))




; Página que mostra os cursos que o estudante está matriculado
; e os cursos que ele ainda pode se matricular

;:::::::::::::::::::::::: /index_init/ :::::::::::::::::::::

(defpage [:post "/index_init"] {:keys [usuario senha]}
(session/remove! :senhaUsuario)
(session/remove! :Usuario)
(session/remove! :Curso)
(session/put! :senhaUsuario senha)
(session/put! :Usuario usuario)
(session/put! :Curso "Introdução a Programação")
(cond (= 1 (compara-usuario usuario senha) 1) 
        (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home"} 
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar"}
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Olá, " (session/get :Usuario)]]]
         [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Editar"]]
         [:li [:a {:href "#"}[:i {:class "icon-trash"}]  "Excluir"]]
         [:li [:a {:href "#"}[:i {:class "icon-ban-circle"}] "Mensagem"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
         
         [:center [:h1 "Explore"]]
         [:center [:h3 "Cadastre-se em todos os cursos e descubra o que o e-Duca tem a oferecer!!!"]]
         [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span3" }]
         [:div {:class "span3"}
         [:div {:class "well sidebar-nav"}
         [:ul  {:class "nav nav-list"}
         [:li  {:class "nav-header"}""]
         [:h4 "Cursos Disponíveis" ]
         [:p [:div {:class "btn-group"}  
         [:button {:class "btn btn-large btn-success" :href "#"}[:i {:class "icon-user icon-white"}] "Introdução a Programação"]]]
         [:p [:div {:class "btn-group"} 
         [:button {:class "btn btn-large btn-warning" :href "#"}[:i {:class "icon-user icon-white"}] "Estruturas de Dados "]]
         ]]]]
         [:div {:class "span3" }
         [:div {:class "well sidebar-nav"}
         [:div {:class "nav nav-list"}      
         [:h4 "Cursos já matriculados"]
         [:form {:action "/index" :method "post" :name "form" :class "form-inline"}
         [:p {:name "Curso"}]
          (curso_introducao)
          (curso_estrutura_dados)
         ]]]]]]
      

         [:div {:class "modal-footer" :id "last_index_init"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - ILS"]] ]]]
         
         ;modal editar

         [:div {:id "Editar" :class "modal hide fade" :tabindex "-1" :role "dialog" :aria-labelledby "EditarLabel" :aria-hidden "true"}
         [:div {:class "modal-header"}
         [:button {:type "button" :class "close" :data-dismiss "modal" :aria-hidden "true"}"×"]
         [:h3 {:id "EditarLabel"} "Editar Usuário"]
         ]
         [:div {:class "modal-body"}
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "inputUsuarioAtual" } "Usuário Atual:"] 
         [:div {:class "controls"}
         [:input {:type "text" :id "usuarioAtual" :name "usuarioatual"}]
         ]]
         [:div  {:class "control-group"}
         [:label{:class "control-label" :for "novoUsuario" } "Novo Usuário:"] 
         [:div {:class "controls"}[:input {:type "text" :id "novoUsuario"}]
         ]] 
         [:div  {:class "control-group"}
         [:label{:class "control-label" :for "senhaAtual" } "Senha Atual:"] 
         [:div {:class "controls"}[:input {:type "text" :id "senhaAtual"}]
         ]]
         [:div  {:class "control-group"}
         [:label{:class "control-label" :for "novoNome" } "Nova Senha:"] 
         [:div {:class "controls"}[:input {:type "text" :id "novaSenha"}]
         ]]
         ]
         [:div {:class "modal-footer"}
         [:button {:class "btn btn-success" :data-dismiss "modal" :arial-hidden "true"} "Confirmar"]
         [:button {:class "btn btn-danger" :data-dismiss "modal" :arial-hidden "true"} "Close"]]
         ] ; end modal    
         ])
         :else
         (common/layout
     	[:body {:class "hero-unit"}
        [:div {:class "container"}
        [:h1 ""]
        [:div {:class "modal-body"}
        [:center [:h1 "Error!"]]
        [:center [:h4 "Úsuario e/ou senha incorreto(s)"]]
        [:center [:h4 "Certifique suas entradas"]]
        [:center [:a {:class "btn btn-large  btn-primary" :id "link_error" :href "/"} "Voltar"]]
        ]]]))
         ) 
         
 



; pagina que recebe parametros e retorna uma resposta ao usuario 
; foi definidos os parametros vindo de um post o endereço da pagina é /login/index 
; Note: Este usuario e senha são as keys que vieram da pagina /login

;::::::::::::::::::::::: /index / ::::::::::::::::::::::::::


(defpage [:post "/index"] []
         (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home"} 
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar"}
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Olá, " (session/get :Usuario)]]]
         [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Editar"]]
         [:li [:a {:href "#"}[:i {:class "icon-trash"}]  "Excluir"]]
         [:li [:a {:href "#"}[:i {:class "icon-ban-circle"}] "Mensagem"]]
         [:li [:a {:href "/index_init"}[:i {:class "icon-ban-circle"}] "Voltar"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
         
      
         [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span3"}
         [:div {:class "well sidebar-nav"}
         [:ul  {:class "nav nav-list"}
         [:li  {:class "nav-header"}""] 
         (cond (= "Introdução a Programação" (session/get :Curso))
         [:div
         [:h5  "Introdução a Programação"]
         [:p {:id "" } [:a {:href "/login/introdução" :target "principal" :style "text-decoration:none" :id "intro"} "Introdução"]] 
         [:p {:id "" } [:a {:href "/login/string" :target "principal" :style "text-decoration:none" :id "string"} "String"]] 
         [:p {:id "" } [:a {:href "/login/alocacao" :target "principal" :style "text-decoration:none" :id "aloc"} "Alocação Dinâmica"]]
         [:p {:id "" } [:a {:href "/login/recursividade" :target "principal" :style "text-decoration:none" :id "recursiv"} "Recursividade"]] 
         [:p {:id "" } [:a {:href "/login/vetor" :target "principal" :style "text-decoration:none" :id "vetor"} "Vetor"]]        
         [:p {:id "" } [:a {:href "/login/função" :target "principal" :style "text-decoration:none" :id "func"} "Funções"]]
         [:p {:id "" } [:a {:href "/login/struct" :target "principal" :style "text-decoration:none" :id "struct"} "Struct"]] 
         [:p {:id "" }[:a {:href "/login/EstruturaCondição" :target "principal" :style "text-decoration:none" :id "EC"}"Estruturas Condição"]]
         [:p {:id "" }[:a {:href "/login/EstruturaRepetição" :target "principal" :style "text-decoration:none" 
                                                                                :id "ER"}"Estruturas Repetição"]]
         [:p {:id "" } [:a {:href "/login/arquivo" :target "principal" :style "text-decoration:none" :id "arquivo"} "Arquivos"]]
         ]
         :else 
         [:div
         [:h5  "Estrutura de Dados"]
         [:p {:id "" } [:a {:href "/login/alocacao" :target "principal" :id "aloc" :style "text-decoration:none"} "Alocação Dinâmica"]]
         [:p {:id ""  } [:a {:href "/login/recursividade" :target "principal" :style "text-decoration:none"} "Recursividade"]] 
         [:p {:id ""    } [:a {:href "/login/vetor" :target "principal" :style "text-decoration:none"} "Vetor"]]
         [:p {:id ""    } [:a {:href "/login/matriz" :target "principal" :style "text-decoration:none"} "Matrizes"]]        
         [:p {:id ""    } [:a {:href "/login/lista" :target "principal" :style "text-decoration:none"} "Lista"]]
         [:p {:id ""     } [:a {:href "/login/fila" :target "principal" :style "text-decoration:none"} "Fila"]]
         [:p {:id ""    } [:a {:href "/login/pilha" :target "principal" :style "text-decoration:none"} "Pilha"]]
         [:p {:id ""   } [:a {:href "/login/arvore" :target "principal" :style "text-decoration:none"} "Árvore"]] 
         [:p {:id ""   } [:a {:href "/login/metOrd" :target "principal" :style "text-decoration:none"} "Métodos Ordenação"]] 
         [:p {:id ""  } [:a {:href "/login/metPesq" :target "principal" :style "text-decoration:none"} "Métodos Pesquisa"]]
         ])          
         [:h4 "Atividades"]
         [:ul {:class "nav"}
         [:li [:p {:id "ativ-exerc"}""]]]     
         ]]]
         [:div {:class "span9" }
         [:div {:class "hero-unit"}

         
 
         [:iframe {:class "Iframe2" :id "iframe" :src "/login/ola" :name "principal"}]
         ]]]]
         [:div {:class "modal-footer" :id "last_index"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - ILS"]] ]]]
         
         ;modal editar

         [:div {:id "Editar" :class "modal hide fade" :tabindex "-1" :role "dialog" :aria-labelledby "EditarLabel" :aria-hidden "true"}
         [:div {:class "modal-header"}
         [:button {:type "button" :class "close" :data-dismiss "modal" :aria-hidden "true"}"×"]
         [:h3 {:id "EditarLabel"} "Editar Usuário"]
         ]
         [:div {:class "modal-body"}
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "inputUsuarioAtual" } "Usuário Atual:"] 
         [:div {:class "controls"}
         [:input {:type "text" :id "usuarioAtual" :name "usuarioatual"}]
         ]]
         [:div  {:class "control-group"}
         [:label{:class "control-label" :for "novoUsuario" } "Novo Usuário:"] 
         [:div {:class "controls"}[:input {:type "text" :id "novoUsuario"}]
         ]] 
         [:div  {:class "control-group"}
         [:label{:class "control-label" :for "senhaAtual" } "Senha Atual:"] 
         [:div {:class "controls"}[:input {:type "text" :id "senhaAtual"}]
         ]]
         [:div  {:class "control-group"}
         [:label{:class "control-label" :for "novoNome" } "Nova Senha:"] 
         [:div {:class "controls"}[:input {:type "text" :id "novaSenha"}]
         ]]
         ]
         [:div {:class "modal-footer"}
         [:button {:class "btn btn-success" :data-dismiss "modal" :arial-hidden "true"} "Confirmar"]
         [:button {:class "btn btn-danger" :data-dismiss "modal" :arial-hidden "true"} "Close"]]
         ] ; end modal    
         ])) 
         





    

 ;(defpage "/login" []
  ;       (session/put! :admin true)
   ;      (common/layout
    ;       [:p "Are you loggedin? "]
     ;      [:p (session/get :admin)]))
  






(defpage [:post "/login/cadastro/welcome"] {:keys [nome numeromatricula  sobrenome curso email nomeUsuario senha disciplina]}
(inserir-aluno numeromatricula nome sobrenome curso email nomeUsuario senha disciplina)
(session/remove! :senhaUsuario)
(session/remove! :Usuario)
(session/put! :senhaUsuario senha)
(session/put! :Usuario nomeUsuario)
        (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home"} 
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "ILS"] 
         ]]]
         [:div {:class "navbar"}
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Olá, " (session/get :Usuario)]]]
         [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Editar"]]
         [:li [:a {:href "#"}[:i {:class "icon-trash"}]  "Excluir"]]
         [:li [:a {:href "#"}[:i {:class "icon-ban-circle"}] "Mensagem"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
         
      
         [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span3"}
         [:div {:class "well sidebar-nav"}
         [:ul  {:class "nav nav-list"}
         [:li  {:class "nav-header"}""] 
         (cond (= "Introdução a Programação" (get (first (buscar-aluno "disciplina" "usuario" nomeUsuario)) :disciplina))
         [:div
         [:h5  "Introdução a Programação"]
         [:p {:id "" } [:a {:href "/login/introdução" :target "principal" :style "text-decoration:none" :id "intro"} "Introdução"]] 
         [:p {:id "" } [:a {:href "/login/string" :target "principal" :style "text-decoration:none" :id "string"} "String"]] 
         [:p {:id "" } [:a {:href "/login/alocacao" :target "principal" :style "text-decoration:none" :id "aloc"} "Alocação Dinâmica"]]
         [:p {:id "" } [:a {:href "/login/recursividade" :target "principal" :style "text-decoration:none" :id "recursiv"} "Recursividade"]] 
         [:p {:id "" } [:a {:href "/login/vetor" :target "principal" :style "text-decoration:none" :id "vetor"} "Vetor"]]        
         [:p {:id "" } [:a {:href "/login/função" :target "principal" :style "text-decoration:none" :id "func"} "Funções"]]
         [:p {:id "" } [:a {:href "/login/struct" :target "principal" :style "text-decoration:none" :id "struct"} "Struct"]] 
         [:p {:id "" }[:a {:href "/login/EstruturaCondição" :target "principal" :style "text-decoration:none" :id "EC"}"Estruturas Condição"]]
         [:p {:id "" }[:a {:href "/login/EstruturaRepetição" :target "principal" :style "text-decoration:none" 
                                                                                :id "ER"}"Estruturas Repetição"]]
         [:p {:id "" } [:a {:href "/login/arquivo" :target "principal" :style "text-decoration:none" :id "arquivo"} "Arquivos"]]
         ]
         :else 
         [:div
         [:h5  "Estrutura de Dados"]
         [:p {:id "" } [:a {:href "/login/alocacao" :target "principal" :id "aloc" :style "text-decoration:none"} "Alocação Dinâmica"]]
         [:p {:id ""  } [:a {:href "/login/recursividade" :target "principal" :style "text-decoration:none"} "Recursividade"]] 
         [:p {:id ""    } [:a {:href "/login/vetor" :target "principal" :style "text-decoration:none"} "Vetor"]]
         [:p {:id ""    } [:a {:href "/login/matriz" :target "principal" :style "text-decoration:none"} "Matrizes"]]        
         [:p {:id ""    } [:a {:href "/login/lista" :target "principal" :style "text-decoration:none"} "Lista"]]
         [:p {:id ""     } [:a {:href "/login/fila" :target "principal" :style "text-decoration:none"} "Fila"]]
         [:p {:id ""    } [:a {:href "/login/pilha" :target "principal" :style "text-decoration:none"} "Pilha"]]
         [:p {:id ""   } [:a {:href "/login/arvore" :target "principal" :style "text-decoration:none"} "Árvore"]] 
         [:p {:id ""   } [:a {:href "/login/metOrd" :target "principal" :style "text-decoration:none"} "Métodos Ordenação"]] 
         [:p {:id ""  } [:a {:href "/login/metPesq" :target "principal" :style "text-decoration:none"} "Métodos Pesquisa"]]
         ])          
         [:h4 "Atividades"]
         [:ul {:class "nav"}
         [:li [:p {:id "ativ-exerc"}""]]]     
         ]]]
         [:div {:class "span9" }
         [:div {:class "hero-unit"}

         
 
         [:iframe {:class "Iframe2" :id "iframe" :src "/login/ola" :name "principal"}]
         ]]]]
         [:div {:class "modal-footer" :id "last_index"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - ILS"]] ]]]
         
         ;modal editar

         [:div {:id "Editar" :class "modal hide fade" :tabindex "-1" :role "dialog" :aria-labelledby "EditarLabel" :aria-hidden "true"}
         [:div {:class "modal-header"}
         [:button {:type "button" :class "close" :data-dismiss "modal" :aria-hidden "true"}"×"]
         [:h3 {:id "EditarLabel"} "Editar Usuário"]
         ]
         [:div {:class "modal-body"}
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "inputUsuarioAtual" } "Usuário Atual:"] 
         [:div {:class "controls"}
         [:input {:type "text" :id "usuarioAtual" :name "usuarioatual"}]
         ]]
         [:div  {:class "control-group"}
         [:label{:class "control-label" :for "novoUsuario" } "Novo Usuário:"] 
         [:div {:class "controls"}[:input {:type "text" :id "novoUsuario"}]
         ]] 
         [:div  {:class "control-group"}
         [:label{:class "control-label" :for "senhaAtual" } "Senha Atual:"] 
         [:div {:class "controls"}[:input {:type "text" :id "senhaAtual"}]
         ]]
         [:div  {:class "control-group"}
         [:label{:class "control-label" :for "novoNome" } "Nova Senha:"] 
         [:div {:class "controls"}[:input {:type "text" :id "novaSenha"}]
         ]]
         ]
         [:div {:class "modal-footer"}
         [:button {:class "btn btn-success" :data-dismiss "modal" :arial-hidden "true"} "Confirmar"]
         [:button {:class "btn btn-danger" :data-dismiss "modal" :arial-hidden "true"} "Close"]]
         ] ; end modal    
         ]))
         


 




; Pagina que somente o professor/administrador vai poder acessar
;nela ele pode ver o dominio dos alunos e também inserir alunos e
; até mesmo inserir um novo professor/administrador

;::::::::::::::::::::::::::::::: /login/admin :::::::::::::::::::::::::::::::


(defpage "/login/admin" []     
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
      
  
         [:body {:class "home"} 
	 [:div 
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Olá, Alexsandro Santos Soares" ]]]
	 ]]
   		
	 [:center [:h3 "Escolha um curso ministrado ou adicione um novo"]]
         [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span3" }]
         [:div {:class "span3"}
         [:div {:class "well sidebar-nav"}
         [:ul  {:class "nav nav-list"}
         [:li  {:class "nav-header"}""]
         [:h4 "Cursos Disponíveis" ]
         [:p [:div {:class "btn-group"}  
         [:button {:class "btn btn-large btn-success" :href "#"}[:i {:class "icon-user icon-white"}] "Introdução a Programação"]]]
         [:p [:div {:class "btn-group"} 
         [:button {:class "btn btn-large btn-warning" :href "#"}[:i {:class "icon-user icon-white"}] "Estruturas de Dados "]]
	 [:p [:div {:class "btn-group"} [:a {:href "/login/admin/new"} [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]]]] 
         ]]]]
	 
         [:div {:class "span3" }
         [:div {:class "well sidebar-nav"}
         [:div {:class "nav nav-list"}      
         [:h4 "Cursos que ministra"]
         [:form {:action "/login/admin/home" :method "post" :name "form" :class "form-inline"}
         [:p {:name "Curso"}]
          (curso_introducao_professor)
          (curso_estrutura_dados_professor)
         ]]]]]]]]
         [:div {:class "modal-footer" :id "rodape"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]
         ]))	
         




(defpage "/login/admin/new" []    
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home"}
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Alexsandro Santos Soares" ]]]
          [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Conta"]]
         [:li [:a {:href "/login/admin"}[:i {:class "icon-trash"}]  "Voltar"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
	  
 
	  
	 [:div {:class "modal-footer" :id "rodape"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]	


         [:div {:class "container" :align "center"}
         [:h3 "Novo Curso" ]
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "nomeCurso" } "Nome"] 
         [:div {:class "controls"}
         [:input {:type "text" :id "nomeCurso" :name "nomeCurso"}]
         ]]
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "siglaCurso" } "Sigla"] 
         [:div {:class "controls"}
         [:input {:type "text" :id "siglaCurso" :name "siglaCurso"}]
         ]]
	 [:div   {:class "control-group"}
         [:label {:class "control-label" :for "hierarquiaCurso" } "Hierarquia(XML)"] 
         [:div {:class "controls"}
         [:textarea {:id "nomeCurso" :name "nomeCurso"}]
         ]]
         
 
         [:div {:class "btn-group"}  
         [:button {:class "btn  btn-success" :href "#"}[:i {:class "icon-user icon-white"}] "Cadastrar"]]
         [:div {:class "btn-group"} 
         [:a {:class "btn  btn-warning" :id "color-link" :href "/login/admin" }[:i {:class "icon-user icon-white"}] "Cancelar "]]         
    
        
         ]]))



(defpage "/login/admin/disciplina/new" []    
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home"}
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Olá, Alexsandro Santos Soares" ]]]
          [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Conta"]]
         [:li [:a {:href "/login/admin/home"}[:i {:class "icon-trash"}]  "Voltar"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
	  
 

         [:div {:class "container" :align "center"}
         [:h3 "Novo Conteúdo" ]
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "nomeConteudo" } "Nome"]
	 [:input {:type "text" :id "nomeConteudo" :name "nomeConteudo"}]
	
         [:div   {:class "control-group"}
         [:label {:class "control-label" :for "nomeConteudo" } "Pré-Requisito(s) (se houver)"]]
	 
	 [:p [:input {:type "checkbox" :value ""} "  Recusividade"]]
	 [:p[:input {:type "checkbox" :value ""} "  Alocação Dinâmica"]]
	 [:p[:input {:type "checkbox" :value ""} "  Vetor"]]
	 [:p[:input {:type "checkbox" :value ""} "  Lista"]]
	 [:p[:input {:type "checkbox" :value ""} "  Fila"]]
         [:p[:input {:type "checkbox" :value ""} "  Pilha"]]
         [:p[:input {:type "checkbox" :value ""} "  Metódos de Ord"]]
         [:p[:input {:type "checkbox" :value ""} "  Métodos de Pesq"]] 
         ]
         
 
         [:div {:class "btn-group"}  
         [:button {:class "btn  btn-success" :href "#"}[:i {:class "icon-user icon-white"}] "Cadastrar"]]
         [:div {:class "btn-group"} 
         [:a {:class "btn  btn-warning" :id "color-link" :href "/login/admin" }[:i {:class "icon-user icon-white"}] "Cancelar "]]]         
    
         
         [:div {:class "modal-footer" :id "rodape"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]
	 ]))



(defpage "/login/admin/home/recursividade/exercicios/add" []     
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:id "fundoiframe"} 
         [:div {:align "center" } 
         [:h4 "Adicionar Exercício"]
	 [:ul {:class "nav"}
	 [:div {:class "modal-body"}


	 [:form {:class "form-horizontal"}
	 [:div {:class "control-group"}

         [:p "TIPO: " 
                      [:select
                      [:option "Multipla Escolha"]
                      [:option "Aberta"]
                      [:option "V ou F"]
                         
                      ]]]

         [:p "Nivel: "[:select
                      [:option "Fácil"]
                      [:option "Médio"]
                      [:option "Difícil"]

 
                      ]]



	 [:div {:class "control-group"}
	 [:div {:class "controls"}
         [:p "Enunciado"  [:textarea ]]]] 
         [:div {:class "control-group"}
	 [:div {:class "controls"}       
         [:p "Alternativa "[:input {:type "text"}]]]]
         [:p "Correta " [:select]]
         [:p [:div  {:class "btn-group"} [:a {:href "#"} [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]]]]
         [:div {:class "btn-group"}  
         [:button {:class "btn  btn-success" :href "#"}[:i {:class "icon-user icon-white"}] "Cadastrar"]]
         [:div {:class "btn-group"} 
         [:a {:class "btn  btn-warning" :id "color-link" :href "/login/admin" }[:i {:class "icon-user icon-white"}] "Cancelar "]]]]         
    
  
         ]]]))

(defpage "/login/admin/home/recursividade/multimidia/add" []     
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:id "fundoiframe"} 
         [:div {:align "center"} 
         [:h4 "Adicionar Exercício"]
        
         
	 [:p "Entre com  a URL do vídeo"]
	 [:p "Url: " [:textarea ]] 
         [:div {:class "btn-group"}  
         [:button {:class "btn  btn-success" :href "#"}[:i {:class "icon-user icon-white"}] "Enviar"]]
         [:div {:class "btn-group"} 
         [:a {:class "btn  btn-warning" :id "color-link" :href "/login/admin" }[:i {:class "icon-user icon-white"}] "Cancelar "]]         
    
  
         ]]))


(defpage "/login/admin/disciplina/recursividade" []    
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home"}
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Alexsandro Santos Soares" ]]]
          [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Conta"]]
         [:li [:a {:href "/login/admin/home"}[:i {:class "icon-trash"}]  "Voltar"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
	  

 

	 [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span2"}
         [:div {:class "well sidebar-nav"}
         [:h5 "CURSOS"]
         [:a [:h3 {:id "ed1"}"ED1"]]
	 [:a {:onclick "corIPC();"}[:h3 {:id "ed1"} "IPC"]]
         

         ]]
         [:div {:class "span10"}
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}
         [:a {:class "brand" :href "#"} "Recusividade"]  
         [:ul {:class "nav"}

         [:li {:class "divider-vertical"} [:a "Exercícios" ]]
         [:li {:class "divider-vertical"}

	 [:ul {:class "nav nav-tabs"}
    	 [:li {:class "dropdown"}
   
	 [:a {:href "/login/admin/home/recursividade/multimidia/add" :target "principal" :class "dropdown-toggle"
    	 :data-toggle "dropdown"} "Multimidia" [:b  {:class "caret"}]]
	 [:ul {:class "dropdown-menu"}
         [:li [:a {:target "principal"} "Videos"]]
	 [:li [:a {:target "principal"} "Animações"]]
	 [:li [:a {:target "principal"} "Imagens"]]
	 ]]]]
    
	          
         [:li {:class "divider-vertical"}[:a "Textos" ]]           
         ]]]
         [:iframe {:class "Iframe3" :id "iframe" :src "/login/admin/home/recursividade/exercicios/add" :name "principal"}]         
 
           
         ]]]
     
         [:div {:class "modal-footer" }
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]

         ]))


(defpage "/login/admin/disciplina/vetor" []    
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home" :onload "corIPC();"}
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Alexsandro Santos Soares" ]]]
          [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Conta"]]
         [:li [:a {:href "/login/admin/home"}[:i {:class "icon-trash"}]  "Voltar"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
	  

 

	 [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span2"}
         [:div {:class "well sidebar-nav"}
         [:h5 "CURSOS"]
         [:a {:id "ed1"}[:h3 {:id "ed1"}"ED1"]]
	 [:a {:id "ipc" :onclick "corIPC"}[:h3 "IPC"]]
         [:button {:type "button" :onclick "corIPC()"} "Set background color"]

         ]]
         [:div {:class "span10"}
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}
         [:a {:class "brand" :href "#"} "Vetor"]  
         [:ul {:class "nav"}
         [:li {:class "active"} [:a "Exercícios" ]]
         [:li {:class "divider-vertical"}[:a "Multimidia" ]]
         [:li {:class "divider-vertical"}[:a "Textos" ]]           
         ]]]
         [:iframe {:class "Iframe3" :id "iframe" :src "/login/admin/home/recursividade/exercicios/add" :name "principal"}]         
 
           
         ]]]
     
         [:div {:class "modal-footer" }
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]

         ]))



(defpage "/login/admin/disciplina/matrizes" []    
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home" :onload "corIPC();"}
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Alexsandro Santos Soares" ]]]
          [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Conta"]]
         [:li [:a {:href "/login/admin/home"}[:i {:class "icon-trash"}]  "Voltar"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
	  

 

	 [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span2"}
         [:div {:class "well sidebar-nav"}
         [:h5 "CURSOS"]
         [:a {:id "ed1"}[:h3 {:id "ed1"}"ED1"]]
	 [:a {:id "ipc" :onclick "corIPC"}[:h3 "IPC"]]
         [:button {:type "button" :onclick "corIPC()"} "Set background color"]

         ]]
         [:div {:class "span10"}
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}
         [:a {:class "brand" :href "#"} "Matrizes"]  
         [:ul {:class "nav"}
         [:li {:class "active"} [:a "Exercícios" ]]
         [:li {:class "divider-vertical"}[:a "Multimidia" ]]
         [:li {:class "divider-vertical"}[:a "Textos" ]]           
         ]]]
         [:iframe {:class "Iframe3" :id "iframe" :src "/login/admin/home/recursividade/exercicios/add" :name "principal"}]         
 
           
         ]]]
     
         [:div {:class "modal-footer" }
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]

         ]))


	(defpage "/login/admin/disciplina/lista" []    
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home" :onload "corIPC();"}
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Alexsandro Santos Soares" ]]]
          [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Conta"]]
         [:li [:a {:href "/login/admin/home"}[:i {:class "icon-trash"}]  "Voltar"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
	  

 

	 [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span2"}
         [:div {:class "well sidebar-nav"}
         [:h5 "CURSOS"]
         [:a {:id "ed1"}[:h3 {:id "ed1"}"ED1"]]
	 [:a {:id "ipc" :onclick "corIPC"}[:h3 "IPC"]]
         [:button {:type "button" :onclick "corIPC()"} "Set background color"]

         ]]
         [:div {:class "span10"}
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}
         [:a {:class "brand" :href "#"} "Lista"]  
         [:ul {:class "nav"}
         [:li {:class "active"} [:a "Exercícios" ]]
         [:li {:class "divider-vertical"}[:a "Multimidia" ]]
         [:li {:class "divider-vertical"}[:a "Textos" ]]           
         ]]]
         [:iframe {:class "Iframe3" :id "iframe" :src "/login/admin/home/recursividade/exercicios/add" :name "principal"}]         
 
           
         ]]]
     
         [:div {:class "modal-footer" }
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]

         ]))



(defpage "/login/admin/disciplina/fila" []    
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home" :onload "corIPC();"}
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Alexsandro Santos Soares" ]]]
          [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Conta"]]
         [:li [:a {:href "/login/admin/home"}[:i {:class "icon-trash"}]  "Voltar"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
	  

 

	 [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span2"}
         [:div {:class "well sidebar-nav"}
         [:h5 "CURSOS"]
         [:a {:id "ed1"}[:h3 {:id "ed1"}"ED1"]]
	 [:a {:id "ipc" :onclick "corIPC"}[:h3 "IPC"]]
         [:button {:type "button" :onclick "corIPC()"} "Set background color"]

         ]]
         [:div {:class "span10"}
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}
         [:a {:class "brand" :href "#"} "Fila"]  
         [:ul {:class "nav"}
         [:li {:class "active"} [:a "Exercícios" ]]
         [:li {:class "divider-vertical"}[:a "Multimidia" ]]
         [:li {:class "divider-vertical"}[:a "Textos" ]]           
         ]]]
         [:iframe {:class "Iframe3" :id "iframe" :src "/login/admin/home/recursividade/exercicios/add" :name "principal"}]         
 
           
         ]]]
     
         [:div {:class "modal-footer" }
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]

         ]))



	(defpage "/login/admin/disciplina/pilha" []    
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home" :onload "corIPC();"}
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Alexsandro Santos Soares" ]]]
          [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Conta"]]
         [:li [:a {:href "/login/admin/home"}[:i {:class "icon-trash"}]  "Voltar"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
	  

 

	 [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span2"}
         [:div {:class "well sidebar-nav"}
         [:h5 "CURSOS"]
         [:a {:id "ed1"}[:h3 {:id "ed1"}"ED1"]]
	 [:a {:id "ipc" :onclick "corIPC"}[:h3 "IPC"]]
         [:button {:type "button" :onclick "corIPC()"} "Set background color"]

         ]]
         [:div {:class "span10"}
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}
         [:a {:class "brand" :href "#"} "Pilha"]  
         [:ul {:class "nav"}
         [:li {:class "active"} [:a "Exercícios" ]]
         [:li {:class "divider-vertical"}[:a "Multimidia" ]]
         [:li {:class "divider-vertical"}[:a "Textos" ]]           
         ]]]
         [:iframe {:class "Iframe3" :id "iframe" :src "/login/admin/home/recursividade/exercicios/add" :name "principal"}]         
 
           
         ]]]
     
         [:div {:class "modal-footer" }
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]

         ]))

	 (defpage "/login/admin/disciplina/metord" []    
	 (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home" :onload "corIPC();"}
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Alexsandro Santos Soares" ]]]
          [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Conta"]]
         [:li [:a {:href "/login/admin/home"}[:i {:class "icon-trash"}]  "Voltar"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
	  

 

	 [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span2"}
         [:div {:class "well sidebar-nav"}
         [:h5 "CURSOS"]
         [:a {:id "ed1"}[:h3 {:id "ed1"}"ED1"]]
	 [:a {:id "ipc" :onclick "corIPC"}[:h3 "IPC"]]
         [:button {:type "button" :onclick "corIPC()"} "Set background color"]

         ]]
         [:div {:class "span10"}
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}
         [:a {:class "brand" :href "#"} "Met - Ordenação"]  
         [:ul {:class "nav"}
         [:li {:class "active"} [:a "Exercícios" ]]
         [:li {:class "divider-vertical"}[:a "Multimidia" ]]
         [:li {:class "divider-vertical"}[:a "Textos" ]]           
         ]]]
         [:iframe {:class "Iframe3" :id "iframe" :src "/login/admin/home/recursividade/exercicios/add" :name "principal"}]         
 
           
         ]]]
     
         [:div {:class "modal-footer" }
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]

         ]))


	(defpage "/login/admin/disciplina/metpesq" []    
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home" :onload "corIPC();"}
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Alexsandro Santos Soares" ]]]
          [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Conta"]]
         [:li [:a {:href "/login/admin/home"}[:i {:class "icon-trash"}]  "Voltar"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
	  

 

	 [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span2"}
         [:div {:class "well sidebar-nav"}
         [:h5 "CURSOS"]
         [:a {:id "ed1"}[:h3 {:id "ed1"}"ED1"]]
	 [:a {:id "ipc" :onclick "corIPC"}[:h3 "IPC"]]
         [:button {:type "button" :onclick "corIPC()"} "Set background color"]

         ]]
         [:div {:class "span10"}
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}
         [:a {:class "brand" :href "#"} "Met - Pesquisa"]  
         [:ul {:class "nav"}
         [:li {:class "active"} [:a "Exercícios" ]]
         [:li {:class "divider-vertical"}[:a "Multimidia" ]]
         [:li {:class "divider-vertical"}[:a "Textos" ]]           
         ]]]
         [:iframe {:class "Iframe3" :id "iframe" :src "/login/admin/home/recursividade/exercicios/add" :name "principal"}]         
 
           
         ]]]
     
         [:div {:class "modal-footer" }
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]

         ]))


	


;::::::::::::::::::::::::::::::: /login/admin/home :::::::::::::::::::::::::::::::


(defpage [:post"/login/admin/home"] []     
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home"} 
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Alexsandro Santos Soares" ]]]
         ]]
         
         [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span2"}
         [:div {:class "well sidebar-nav"}
         [:h5 "CURSOS"]
         [:a {:href "/login/admin/home/estruturas"} [:h3 {:id "ed1"}"ED1"]]
	 [:a {:href "/login/admin/home/introducao"} [:h3 {:id "ed1"} "IPC"]]
         
         ]]
         [:div {:class "span10"} 
         [:div {:class "well sidebar-nav"}
         [:center [:h3 {:style "color:green;"} "Escolher um dos conteúdos da disciplina abaixo ou adicione+ novo"]]
         [:div {:align "center"}
         [:a {:href "/login/admin/disciplina/recursividade"} [:h4 "Recusividade"]]
	 [:a {:href "/login/admin/disciplina/vetor"} [:h4 "Vetor"]]
	 [:a {:href "/login/admin/disciplina/matrizes"}[:h4 "Matrizes"]]
	 [:a {:href "/login/admin/disciplina/lista"}[:h4 "Lista"]]
	 [:a {:href "/login/admin/disciplina/fila"}[:h4 "Fila"]]
         [:a {:href "/login/admin/disciplina/pilha"}[:h4 "Pilha"]]
         [:a {:href "/login/admin/disciplina/arvore"}[:h4 "Árvore"]]
	 [:a {:href "/login/admin/disciplina/metord"}[:h4 "Métodos de Ordenação"]]
         [:a {:href "/login/admin/disciplina/metpesq"}[:h4 "Métodos de Pesquisa"]]
	 [:p [:a {:href "/login/admin/disciplina/new"} [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]]]]
         ]
	 ]]] ;end (container-fluid,row-fluid,span2,well sidebar-nav)

         [:div {:class "modal-footer" :id "rodape"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]
         
         ])) 





(defpage  "/login/admin/home/introducao" []     
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home"} 
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Alexsandro Santos Soares" ]]]
         ]]
         
         [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span2"}
         [:div {:class "well sidebar-nav"}
         [:h5 "CURSOS"]
         [:a {:href "/login/admin/home/estruturas"} [:h3 {:id "ed1"}"ED1"]]
	 [:a {:href "/login/admin/home/introducao"} {:onclick "corIPC();"}[:h3 {:id "ed1"} "IPC"]]
         
         ]]
         [:div {:class "span10"} 
         [:div {:class "well sidebar-nav"}
         [:center [:h3 {:style "color:green;"} "Escolher um dos conteúdos da disciplina abaixo ou adicione+ novo"]]
         [:div {:align "center"}
         [:a {:href "/login/admin/disciplina/recursividade"} [:h4 "Recusividade"]]
	 [:a {:href "/login/admin/disciplina/vetor"} [:h4 "Vetor"]]
	 [:a {:href "/login/admin/disciplina/matrizes"}[:h4 "Matrizes"]]
	 [:a {:href "/login/admin/disciplina/lista"}[:h4 "Lista"]]
	 [:a {:href "/login/admin/disciplina/fila"}[:h4 "Fila"]]
         [:a {:href "/login/admin/disciplina/pilha"}[:h4 "Pilha"]]
         [:a {:href "/login/admin/disciplina/arvore"}[:h4 "Árvore"]]
	 [:a {:href "/login/admin/disciplina/metord"}[:h4 "Métodos de Ordenação"]]
         [:a {:href "/login/admin/disciplina/metpesq"}[:h4 "Métodos de Pesquisa"]]
	 [:p [:a {:href "/login/admin/disciplina/new"} [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]]]]
         ]
	 ]]] ;end (container-fluid,row-fluid,span2,well sidebar-nav)

         [:div {:class "modal-footer" :id "rodape"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]
         
         ])) 




(defpage "/login/admin/home/estruturas" []     
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home"} 
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Alexsandro Santos Soares" ]]]
         ]]
         
         [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span2"}
         [:div {:class "well sidebar-nav"}
         [:h5 "CURSOS"]
         [:a {:href "/login/admin/home/estrutura" :target "principal"}[:h3 {:id "ed1"}"ED1"]]
	 [:a {:href "/login/admin/home/introducao" :target "principal"}[:h3 {:id "ed1"} "IPC"]]
         
         ]]
         [:div {:class "span10"} 
         [:div {:class "well sidebar-nav"}
         [:center [:h3 {:style "color:green;"} "Escolher um dos conteúdos da disciplina abaixo ou adicione+ novo"]]
         [:div {:align "center"}

         [:a {:href "/login/admin/disciplina/recursividade"} [:h4 "Estrutura de Dados"]]
	 [:a {:href "/login/admin/disciplina/vetor"} [:h4 "Recursividade"]]
	 [:a {:href "/login/admin/disciplina/vetor"}[:h4 "Vetor"]]
	 [:a {:href "/login/admin/disciplina/matrizes"}[:h4 "Matrizes"]]
	 [:a {:href "/login/admin/disciplina/fila"}[:h4 "Lista"]]
         [:a {:href "/login/admin/disciplina/pilha"}[:h4 "Fila"]]
         [:a {:href "/login/admin/disciplina/arvore"}[:h4 "Pilha"]]
	 [:a {:href "/login/admin/disciplina/metord"}[:h4 "Arvore"]]
         [:a {:href "/login/admin/disciplina/metpesq"}[:h4 "Métodos de Ordenacao"]]
         [:a {:href "/login/admin/disciplina/metpesq"}[:h4 "Métodos de Pesquisa"]]
	 [:p [:a {:href "/login/admin/disciplina/new"} [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]]]]
         ]
	 ]]] ;end (container-fluid,row-fluid,span2,well sidebar-nav)

         [:div {:class "modal-footer" :id "rodape"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]
         
         ])) 





(defpage [:post "/login/admin/homes/2"] []     
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "home"} 
         [:div {:class "navbar navbar-inverse navbar-fixed-top"}
         [:div {:class "navbar-inner"}
         [:div {:class "container-fluid"}
         [:h3 "e-duca"] 
         ]]]
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Olá, Alexsandro Santos Soares" ]]]
         
   
         [:div {:class "btn-group" :id "config"}  
         [:p {:class "btn btn-primary" :href "#"}[:i {:class "icon-user icon-white"}] "Configurações"]
         [:a {:class "btn btn-primary dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "Editar"]]
         [:li [:a {:href "#"}[:i {:class "icon-trash"}]  "Excluir"]]
         [:li [:a {:href "#"}[:i {:class "icon-ban-circle"}] "Mensagem"]]
         [:li [:a {:href "/index_init"}[:i {:class "icon-ban-circle"}] "Voltar"]]
         [:li {:class "divider"}]
         [:li [:a {:href "/"} [:i {:class "i"}] "Logout"]]
         ]]]]
         [:div {:class "container-fluid"}
         [:div {:class "row-fluid"}
         [:div {:class "span2"}
         [:div {:class "well sidebar-nav"}
         [:ul  {:class "nav nav-list"}
         [:li  {:class "nav-header"}
         [:div {:class "btn-group"}  
         [:p {:class "btn btn-mini  btn-success" :href "#"}[:i {:class "icon-user icon-white"}] "CURSOS"]
         [:a {:class "btn btn-mini btn-success dropdown-toggle" :data-toggle "dropdown" :href "#"}
         [:span {:class "caret"}]]
         [:ul {:class "dropdown-menu"}
         [:li [:a {:href "#Editar" :role "button" :data-toggle "modal"} [:i {:class "icon-pencil"}] "CC1"]]
         [:li [:a {:href "#"}[:i {:class "icon-trash"}]  "ED"]]]]
         ] 
         [:div
         [:h2  "CC1"]
         [:h5 [:a {:href "/login/admin/1" :target "principal"}"String"]]
         [:h5 [:a {:href "/login/admin/2" :target "principal"} "Alocação Dinâmica"]]
         [:h5 [:a {:href "/login/admin/2" :target "principal"} "Recursividade"]]
         [:h5 [:a {:href "/login/admin/2" :target "principal"} "Vetor"]]
         [:h5 [:a {:href "/login/admin/2" :target "principal"} "Funções"]]
         [:h5 [:a {:href "/login/admin/2" :target "principal"} "Struct"]]
         [:h5 [:a {:href "/login/admin/2" :target "principal"} "Est. Cond"]]
         [:h5 [:a {:href "/login/admin/2" :target "principal"} "Est. Rep"]]
         [:h5 [:a {:href "/login/admin/2" :target "principal"} "Arquivos"]]
         ]]]]
         [:div {:class "span2"} 
         [:iframe {:class "Iframe3" :id "" :src "/login/admin/obs" :name "principal"}]
         ]]]
   
         
          
         [:div {:class "modal-footer" :id "last_index"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - ILS"]]]]]
         
         ;modals
         ;modal editar
         [:div {:id "Editar" :class "modal hide fade" :tabindex "-1" :role "dialog" :aria-labelledby "EditarLabel" :aria-hidden "true"}
         [:div {:class "modal-header"}
         [:button {:type "button" :class "close" :data-dismiss "modal" :aria-hidden "true"}"×"]
         [:h3 {:id "EditarLabel"} "Editar Exercício"]]
         [:div {:class "modal-body"}]
         [:div {:class "modal-footer"} 
         [:button {:class "btn btn-success"} "Salvar"]] 
         ]
         ;modal ver exercício
         [:div {:id "VerExercicio" :class "modal hide fade" :tabindex "-1" :role "dialog" :aria-labelledby "EditarLabel" :aria-hidden "true"}
         [:div {:class "modal-header"}
         [:button {:type "button" :class "close" :data-dismiss "modal" :aria-hidden "true"}"×"]
         [:h3 {:id "VerLabel"} "Exercício"]]
       
         [:div {:class "modal-body"}]

         [:div {:class "modal-footer"} 
         [:button {:class "btn btn-success"} "Salvar"]]
         ] 
         ]))



(defpage "/login/admin/obs" []
 (common/layout
   [:body {:id "fundoiframe"}
   [:h5 "Nesta pagina você pode ver o dominio dos alunos e também inserir 
        um novo professor administrador e até mesmo remover alunos se julgar necessário."]]))    


(defpage "/login/admin/1" []
 (common/layout
         [:body {:id "fundoiframe"}    
         [:ul  {:class "nav nav-list"}   
         [:center [:h3 "Strings"]]]]
         [:div {:class "nav"} 
         [:div {:class "span1"}] 
         [:div {:class "span3"}
         [:h4 "Exercícios"]
         [:div {:class "well sidebar-nav"}
         [:p [:a  {:href "#VerExercicio" :role "button" :data-toggle "modal" }  "Exerc - 01"] [:a {:class "delete-icon"} [:img {:src "/img/glyphicons_016_bin.png" :class "icon-trash"} ]]
         [:a {:class "edit-icon" :href "#Editar" :role "button" :data-toggle "modal"} [:img {:src "/img/glyphicons_030_pencil.png" :class "icon-trash"} ]]     
         ]
         [:p [:a [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]] 
         ]]
         ]]))
 
   
(defpage "/login/admin/2" []
    (common/layout     
         [:body {:id "fundoiframe"}    
         [:ul  {:class "nav nav-list"}   
         [:center [:h3 "Alocação Dinâmica"]]]]
         [:div {:class "nav"} 
         [:div {:class "span1"}] 
         [:div {:class "span3"}
         [:h4 "Exercícios"]
         [:div {:class "well sidebar-nav"}
         [:p [:a  {:href "#VerExercicio" :role "button" :data-toggle "modal" }  "Exerc - 01"] [:a {:class "delete-icon"} [:img {:src "/img/glyphicons_016_bin.png" :class "icon-trash"} ]]
         [:a {:class "edit-icon" :href "#Editar" :role "button" :data-toggle "modal"} [:img {:src "/img/glyphicons_030_pencil.png" :class "icon-trash"} ]]     
         ]
         [:p [:a [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]] 
         ]]
         ]]))
 

(defpage "/login/admin/3" []
 (common/layout
   [:body {:id "fundoiframe"}    
         [:ul  {:class "nav nav-list"}   
         [:center [:h3 "Recursividade"]]]]
         [:div {:class "nav"} 
         [:div {:class "span1"}] 
         [:div {:class "span3"}
         [:h4 "Exercícios"]
         [:div {:class "well sidebar-nav"}
         [:p [:a  {:href "#VerExercicio" :role "button" :data-toggle "modal" }  "Exerc - 01"] [:a {:class "delete-icon"} [:img {:src "/img/glyphicons_016_bin.png" :class "icon-trash"} ]]
         [:a {:class "edit-icon" :href "#Editar" :role "button" :data-toggle "modal"} [:img {:src "/img/glyphicons_030_pencil.png" :class "icon-trash"} ]]     
         ]
         [:p [:a [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]] 
         ]]
         ]]))
 
(defpage "/login/admin/4" []
 (common/layout
   [:body {:id "fundoiframe"}    
         [:ul  {:class "nav nav-list"}   
         [:center [:h3 "Vetor"]]]]
         [:div {:class "nav"} 
         [:div {:class "span1"}] 
         [:div {:class "span3"}
         [:h4 "Exercícios"]
         [:div {:class "well sidebar-nav"}
         [:p [:a  {:href "#VerExercicio" :role "button" :data-toggle "modal" }  "Exerc - 01"] [:a {:class "delete-icon"} [:img {:src "/img/glyphicons_016_bin.png" :class "icon-trash"} ]]
         [:a {:class "edit-icon" :href "#Editar" :role "button" :data-toggle "modal"} [:img {:src "/img/glyphicons_030_pencil.png" :class "icon-trash"} ]]     
         ]
         [:p [:a [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]] 
         ]]
         ]]))
  


(defpage "/login/admin/5" []
 (common/layout
   [:body {:id "fundoiframe"}    
         [:ul  {:class "nav nav-list"}   
         [:center [:h3 "Funcoes"]]]]
         [:div {:class "nav"} 
         [:div {:class "span1"}] 
         [:div {:class "span3"}
         [:h4 "Exercícios"]
         [:div {:class "well sidebar-nav"}
         [:p [:a  {:href "#VerExercicio" :role "button" :data-toggle "modal" }  "Exerc - 01"] [:a {:class "delete-icon"} [:img {:src "/img/glyphicons_016_bin.png" :class "icon-trash"} ]]
         [:a {:class "edit-icon" :href "#Editar" :role "button" :data-toggle "modal"} [:img {:src "/img/glyphicons_030_pencil.png" :class "icon-trash"} ]]     
         ]
         [:p [:a [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]] 
         ]]
         ]]))
  


(defpage "/login/struct/6" []
 (common/layout
   [:body {:id "fundoiframe"}    
         [:ul  {:class "nav nav-list"}   
         [:center [:h3 "Vetor"]]]]
         [:div {:class "nav"} 
         [:div {:class "span1"}] 
         [:div {:class "span3"}
         [:h4 "Exercícios"]
         [:div {:class "well sidebar-nav"}
         [:p [:a  {:href "#VerExercicio" :role "button" :data-toggle "modal" }  "Exerc - 01"] [:a {:class "delete-icon"} [:img {:src "/img/glyphicons_016_bin.png" :class "icon-trash"} ]]
         [:a {:class "edit-icon" :href "#Editar" :role "button" :data-toggle "modal"} [:img {:src "/img/glyphicons_030_pencil.png" :class "icon-trash"} ]]     
         ]
         [:p [:a [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]] 
         ]]
         ]]))
  

(defpage "/video" []
 (common/layout
   [:body
   [:video {:id "video" :controls "controls"}
   [:source {:src "http://www.youtube.com/embed/GiCt0Cwcp-U"}]]]))    


(defpage "/codigo" []
 (common/layout
  [:head [:title "teste"]      
  (include-css "/css/codemirror.css")
  (include-js "/js/codemirror.js")
  (include-css "/css/docs.css")
  (include-js "/js/clike.js") 
  ]
  [:body {:onload "chama();"}
  [:form [:textarea {:id "code" :name "code"}
"/* Escreva seu código aqui*/\n"
   "#include <stdio.h>\n"
   "#include <stdlib.h>\n"
 
][:p [:button {:class "btn btn-primary" :onclick "return resultado();"} "Avançar" ]]
[:textarea {:id "console"} ]]

    
    [:p "Simple mode that tries to handle C-like languages as well as it
    can. Takes two configuration parameters: <code>keywords</code>, an
    object whose property names are the keywords in the language,
    and <code>useCPP</code>, which determines whether C preprocessor
    directives are recognized."]

    
  ]
))

 



