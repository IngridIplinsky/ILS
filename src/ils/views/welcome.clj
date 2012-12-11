(ns ils.views.welcome
  (:require [ils.views.common :as common]
            [noir.content.getting-started]
            [noir.session :as session])
  (:use [ils.models.estudante.corygil estudante]
        [ils.models.dominio.BD insercao]
        [ils.models.dominio.BD busca]
        [ils.models.dominio.xml manipulacao] 
        [noir.core :only [defpage]]
        [hiccup.core :only [html]]
        [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5 include-js html5]]
 ))

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to tanara"]
           [:button {:onclick "teste();"} "teste"]))

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
         [:div {:class "navbar navbar-inverse"}
         [:div {:class "navbar-inner"}
         [:form {:action "/index" :method "post" :name "form" :class "form-inline"}
         [:ul {:class "nav"}
         [:li
         [:a {:href "#myModal" :role "button" :data-toggle "modal"} "Cadastre-se"]]
         [:li [:a {:href "#History" :role "button" :data-toggle "modal"}"História"]]
         [:li [:input {:id "inputUsuario" :class "input-medium" :type "text" :placeholder "Usuário" :name "usuario"}]]
         [:li [:input {:id "inputSenha"   :class "input-medium" :type "password" :placeholder "Senha" :name "senha"}]] 
         [:button {:class "btn btn-info" :id "botaoConfirma" :onclick "return verificaLogin()"} "Entrar"]
         ]]]]

         [:div {:class "container"  } 
         [:div {:id "myCarousel" :class "carousel slide"}
   [:div {:class "carousel-inner"}
   [:div {:class "m-carousel m-fluid m-carousel-photos" }
   [:div {:class "m-carousel-inner"}
   [:div {:class "m-item" :id "links_slide_barra"}
      [:img {:src "/img/ils.jpg" :width "600" :height "350" }]
   ]
   [:div {:class "m-item"}
      [:img {:src"/img/Untitled-1.jpg" :width "600" :height "350" }]
   ]
   [:div {:class "m-item"}
      [:img {:src "/img/Untitled-2.jpg" :width "600" :height "350" }]
   ]]
   [:div {:class "m-carousel-controls m-carousel-bulleted" :id "links_slide_barra"}
    [:a {:href "#" :data-slide "1" :id "links_slide"}"1"]
    [:a {:href "#" :data-slide "2" :id "links_slide"}"2"]
    [:a {:href "#" :data-slide "3" :id "links_slide"}"3"] 
    ]]
     [:a {:id "next" :class "carousel-control right" :href "#myCarousel" :data-slide "next"}"&rsaquo;"]  
     [:a {:id "prev" :class "carousel-control left"  :href "#myCarousel" :data-slide "prev"}"&lsaquo;"]
     ]]
     
    [:script {:type "text/javascript" :src "/js/carousel.js"}]
    [:script "$('.m-carousel').carousel()"]
    [:script "$('.carousel').carousel({
              interval: 2000 })"]
         ];end Div "Container"

 
         ; Definindo o modal do cadastro

         [:div {:id "myModal" :class "modal hide fade" :tabindex "-1" :role "dialog" 
               :aria-labelledby "myModalLabel" :aria-hidden "true"}
         [:div {:class "modal-header"}
         [:button {:type "button" :class "close" :data-dismiss "modal" :aria-hidden "true"}"×"]
         [:h3 {:id "myModalLabel"} "Cadastro de Usuários"]
         ]
         [:div {:class "modal-body"}  
         [:form  {:class "form-horizontal" :method "post" :name "cad" :action "/login/cadastro/welcome"}
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
         ]] 
         [:div   {:class "control-group"}
         [:div {:class "modal-footer"}
         [:button {:class "btn btn-danger" :data-dismiss "modal" :arial-hidden "true"} "Cancelar"]
         [:button {:class "btn btn-primary" :onclick "return cadastra();"} "Confirmar"]
         ]]]]]
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
   [:div {:class "m-carousel m-fluid m-carousel-photos"}
   [:div {:class "m-carousel-inner"}
   [:div {:class "m-item"}
      [:img {:src "/img/ils.jpg" :width "600" :height "350"}]
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
         [:a {:id "next" :class "carousel-control right" :href "#myCarousel" :data-slide "next"}"&rsaquo;"]]]
     
    [:script {:type "text/javascript" :src "/js/carousel.js"}]
    [:script "$('.m-carousel').carousel()"]
    ]]))   


  

; pagina que recebe parametros e retorna uma resposta ao usuario 
; foi definidos os parametros vindo de um post o endereço da pagina é /login/index 
; Note: Este usuario e senha são as keys que vieram da pagina /login

;::::::::::::::::::::::: /index/ ::::::::::::::::::::::::::


(defpage [:post "/index"] {:keys [usuario senha]}
(session/remove! :senhaUsuario)
(session/put! :senhaUsuario senha)
        (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "fundo_index"}
         [:div {:class "container"}
         [:p ""]
         [:div {:class "navbar navbar-inverse"}
         [:div {:class "navbar-inner" :id "ILS"}
         [:ul {:class "nav"}
         [:li
         [:h5 {:id "logo"} "ILS"]]
         ]]]
         [:div {:class "container" :id "fundo_container"}
         [:div {:class "navbar"}
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Olá, " usuario]]]
 

   
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
         [:div {:class "span2"}
         [:div {:id "menu_links"}
         (cond (= "Introdução a Programação" (get (first (buscar-aluno "disciplina" "usuario" usuario)) :disciplina))
         [:div
         [:h5  "Introdução a Programação"]
         [:p {:id ""   } [:a {:href "/login/introdução" :target "principal" :style "text-decoration:none"} "Introdução"]] 
         [:p {:id ""   } [:a {:href "/login/string" :target "principal" :style "text-decoration:none"} "String"]] 
         [:p {:id "" } [:a {:href "/login/alocacao" :target "principal" :id "aloc" :style "text-decoration:none"} "Alocação Dinâmica"]]
         [:p {:id "" } [:a {:href "/login/recursividade" :target "principal" :style "text-decoration:none"} "Recursividade"]] 
         [:p {:id "" } [:a {:href "/login/vetor" :target "principal" :style "text-decoration:none"} "Vetor"]]        
         [:p {:id ""    } [:a {:href "/login/função" :target "principal" :style "text-decoration:none"} "Funções"]]
         [:p {:id ""   } [:a {:href "/login/struct" :target "principal" :style "text-decoration:none"} "Struct"]] 
         [:p {:id "" } [:a {:href "/login/EstruturaCondição" :target "principal" :style "text-decoration:none"}"Estruturas Condição"]]
         [:p {:id "" } [:a {:href "/login/EstruturaRepetição" :target "principal" :style "text-decoration:none"}"Estruturas Repetição"]]
         [:p {:id "" } [:a {:href "/login/arquivo" :target "principal" :style "text-decoration:none"} "Arquivos"]]
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
         ]]
         [:div {:class "span10" :id "menu_iframe"}
         [:iframe {:class "Iframe" :src "/login/ola" :name "principal"}]
         ]]]]  
         [:div {:class "navbar navbar-inverse"}
         [:div {:class "navbar-inner"}
         [:center [:h5  "&#169; Copyright 2013 - ILS"]]
         ]]
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
         ]    
         ]]))


    
(defpage "/login/index" []
;(session/remove! :senhaUsuario)
;(session/put! :senhaUsuario senha)
;(cond (= 1 (compara-usuario usuario senha) 1) 
        (common/layout
         [:head 
          (include-css "/css/drop.css")]
         [:body {:class "auto"} 
         [:div {:id "back_recem"}]
         [:div {:id "fundo"}]
         [:div {:id "fundo2"}]
         [:div {:id "back_index"}]
         [:div {:id "back_mini"}]
         [:div {:id "links"} 
         [:iframe {:id "perguntas" :src "/login/ola" :name "principal"}]
         [:h4 {:id "est-dados"} "Estrutura de Dados"]
         [:p {:id "menuAlocacao" } [:a {:href "/login/alocacao" :target "principal" :id "aloc"} "Alocação Dinâmica"]]
         [:p {:id "menuRecursi"  } [:a {:href "/login/recursividade" :target "principal"} "Recursividade"]] 
         [:p {:id "menuVetor"    } [:a {:href "/login/vetor" :target "principal"} "Vetor"]]        
         [:p {:id "menuLista"    } [:a {:href "/login/lista" :target "principal"} "Lista"]]
         [:p {:id "menuFila"     } [:a {:href "/login/fila" :target "principal"} "Fila"]]
         [:p {:id "menuPilha"    } [:a {:href "/login/pilha" :target "principal"} "Pilha"]]
         [:p {:id "menuArvore"   } [:a {:href "/login/arvore" :target "principal"} "Árvore"]] 
         [:p {:id "menuMetOrd"   } [:a {:href "/login/metOrd" :target "principal"} "Métodos Ordenação"]] 
         [:p {:id "menuMetPesq"  } [:a {:href "/login/metPesq" :target "principal"} "Métodos Pesquisa"]]]    
         [:p {:class "logocadastro"} "ILS"]
         [:h4 {:id "ativ"} "Atividades"]
         [:h5 {:id "ativ-exerc"} ""]
         [:p {:class "ilscadastro"} "Olá, " "Eduardo Gonçalves"  " | " [:a {:href "/" :id "logout"} "Logout"]]
         [:a {:href "/videos/vetor" :id "apresentacao" :target "principal"} "| Configurações"]
         ]))
         
  ;:else
  ; (common/layout
   ;  [:body
    ; [:center [:h1 "Login e/ou senha errados"]]]))



 ;(defpage "/login" []
  ;       (session/put! :admin true)
   ;      (common/layout
    ;       [:p "Are you loggedin? "]
     ;      [:p (session/get :admin)]))
  






(defpage [:post "/login/cadastro/welcome"] {:keys [nome numeromatricula  sobrenome curso email nomeUsuario senha disciplina]}
(inserir-aluno numeromatricula nome sobrenome curso email nomeUsuario senha disciplina)
;(insere-tabela-aluno 
;(povoar-tabelas numeromatricula)
  (session/remove! :senhaUsuario)    
  (session/put! :senhaUsuario senha) 
         (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:class "fundo_index"}
         [:div {:class "container"}
         [:p ""]
         [:div {:class "navbar navbar-inverse"}
         [:div {:class "navbar-inner" :id "ILS"}
         [:ul {:class "nav"}
         [:li
         [:h5 {:id "logo"} "ILS"]]
         ]]]
         [:div {:class "container" :id "fundo_container"}
         [:div {:class "navbar"}
         [:div {:class "navbar-inner"}  
         [:ul {:class "nav"}
         [:li [:h5 "Olá, " nomeUsuario]]]
 

   
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
         [:div {:class "span2"}
         [:div {:id "menu_links"}
         (cond (= "Introdução a Programação" (get (first (buscar-aluno "disciplina" "usuario" nomeUsuario)) :disciplina))
         (common/layout
         [:h5  "Introdução a Programação"]
         [:p {:id ""   } [:a {:href "/login/introdução" :target "principal" :style "text-decoration:none"} "Introdução"]] 
         [:p {:id ""   } [:a {:href "/login/string" :target "principal" :style "text-decoration:none"} "String"]] 
         [:p {:id "" } [:a {:href "/login/alocacao" :target "principal" :id "aloc" :style "text-decoration:none"} "Alocação Dinâmica"]]
         [:p {:id "" } [:a {:href "/login/recursividade" :target "principal" :style "text-decoration:none"} "Recursividade"]] 
         [:p {:id "" } [:a {:href "/login/vetor" :target "principal" :style "text-decoration:none"} "Vetor"]]        
         [:p {:id ""    } [:a {:href "/login/função" :target "principal" :style "text-decoration:none"} "Funções"]]
         [:p {:id ""   } [:a {:href "/login/struct" :target "principal" :style "text-decoration:none"} "Struct"]] 
         [:p {:id "" } [:a {:href "/login/EstruturaCondição" :target "principal" :style "text-decoration:none"}"Estruturas Condição"]]
         [:p {:id "" } [:a {:href "/login/EstruturaRepetição" :target "principal" :style "text-decoration:none"}"Estruturas Repetição"]]
         [:p {:id "" } [:a {:href "/login/arquivo" :target "principal" :style "text-decoration:none"} "Arquivos"]]
         )
         :else 
         (common/layout
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
         ))          

         [:h4 "Atividades"]
         [:ul {:class "nav"}
         [:li [:p {:id "ativ-exerc"}""]]]     
         ]]
         [:div {:class "span10" :id "menu_iframe"}
         [:iframe {:class "Iframe" :src "/login/ola" :name "principal"}]
         ]]]]  
         [:div {:class "navbar navbar-inverse"}
         [:div {:class "navbar-inner"}
         [:center [:h5  "&#169; Copyright 2013 - ILS"]]
         ]]
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
         ]    
         ]]))

 



;::::::::::::::::::::::::::::::: /login/welcome/pratica :::::::::::::::::::::::::::::::

;Página que contem a parte prática dos exercícios, com perguntas que são resolvidos
;em códigos de programação. Está também ajuda a definir um modelo do estudante, pois
;poderá obter dados do estudante vindos da interface.


(defpage  "/login/welcome/pratica" []     
      (common/layout
       [:body
       [:div {:id "header_1"}]
       [:div {:id "header_2"}]
       [:div {:id "header_3"}]
       [:div {:id "header_exercicios"}]
       [:div {:id "header_4"}]
       [:image {:src "/img/intro_small.png" :id "header_logo"}]
       [:p {:id "usuariosPratica"} "Eduardo Gonçalves"]
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
   ;(tet) 
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
 
]]

    
    [:p "Simple mode that tries to handle C-like languages as well as it
    can. Takes two configuration parameters: <code>keywords</code>, an
    object whose property names are the keywords in the language,
    and <code>useCPP</code>, which determines whether C preprocessor
    directives are recognized."]

    
  ]
))

 



