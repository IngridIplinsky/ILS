(ns ils.views.professor.conteudos
  (:require [ils.views.common :as common]
            [noir.content.getting-started]
            [noir.session :as session]
            )
  (:use [ils.views comunicacao] 
        [ils.models.dominio.BD busca]
        [ils.models.dominio.BD insercao]
        [ils.models.dominio.xml manipulacao] 
        [ils.models.dominio.xml geracao]         
        [noir.core :only [defpage]]
        [hiccup.core :only [html]]
        [noir.core :only [defpartial]]
        ;[noir.response :only [redirect]]
        [hiccup.page-helpers :only [include-css html5 include-js html5]]
 ))



;:::::::::::::::::::::::::::::;;:::::::::::::::::::::::::::::::::::::::::::::
;:::::::::::::::::::::::::::::: IPC :::::::::::::::::::::::::::::::::::::::::
;::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::




;:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
;::::::::::::::::::::::::::::::: RECURSIVIDADE :::::::::::::::::::::::::::::::
;:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::


(defpage "/admin/disciplina/recursividade" []    
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
	  

 

	 [:div {:class "container-fluid" }
         [:div {:class "row-fluid" }
         [:div {:class "span2" :id "link_prof"}
         [:div {:class "well sidebar-nav"}
         [:h5 "CURSOS"]
         [:ul {:class "nav nav-list"}
         [:li [:a [:h3 "ED1"]]]
	 [:li [:a [:h3 "IPC"]]]
         ] 
         

         ]]
         [:div {:class "span10"}
         [:div {:class "navbar" }
         [:div {:class "navbar-inner"}
         [:a {:class "brand" :href "#"} "Recusividade"]  
         [:ul {:class "nav"}



	
         [:li {:class "divider-vertical"}
	 [:ul {:class "nav nav-tabs"}
    	 [:li {:class "dropdown"} 
	 [:a {:target "principal" :class "dropdown-toggle"
    	 :data-toggle "dropdown"} "Exercicios" [:b  {:class "caret"}]]
	 [:ul {:class "dropdown-menu"}
         [:li [:a {:target "principal" :onclick "ResizeWH()" :href "/admin/home/recursividade/exercicios/multiplaescolha" } "Multipla escolha"]]
	 [:li [:a {:target "principal" :onclick "ResizeWH()" :href "/admin/home/recursividade/exercicios/aberta"} "Questão aberta"]]
	 [:li [:a {:target "principal"} "V ou F"]]
	 ]]]]


         [:li {:class "divider-vertical"}
	 [:ul {:class "nav nav-tabs"}
    	 [:li {:class "dropdown"} 
	 [:a {:target "principal" :class "dropdown-toggle"
    	 :data-toggle "dropdown"} "Multimidia" [:b  {:class "caret"}]]
	 [:ul {:class "dropdown-menu"}
         [:li [:a {:target "principal" :href "/admin/home/recursividade/multimidia/add" } "Videos"]]
	 [:li [:a {:target "principal"} "Animações"]]
	 [:li [:a {:target "principal"} "Imagens"]]
	 ]]]]
    
	          
         [:li {:class "divider-vertical"}[:a "Textos" ]]           
         ]]]
         [:iframe {:class "Iframe3" :id "iframe" :src "/admin/home/recursividade/index" :name "principal"}]         
 
           
         ]]]
     
         [:div {:class "modal-footer"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]
     	

         ]))




(defpage "/admin/home/recursividade/exercicios/multiplaescolha" []     
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:id "fundoiframe" :onload "ResizeWH();"}
 
         [:div {:align "center"} 
         [:h4 "Adicionar Exercício - Multipla Escolha"]]
	 [:ul {:class "nav"}
         [:br]

       
         
	 [:form {:class "form-horizontal"}
         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "nivel"} "Nivel"]
         [:div {:class "controls"}	 
         [:input {:type "text"}
                      ;[:select {:id "nivel"}
                      ;[:option "Fácil"]
                      ;[:option "Médio"]
                      ;[:option "Difícil"]

                      ]]
         ]

         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "caminho"} "Caminho do Arquivo"]
         [:div {:class "controls"} 
         [:input {:type "text":id "caminho"}]]] 

         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "conteudo"} "Conteudo"]
         [:div {:class "controls"} 
         [:input {:type "text":id "conteudo"}]]]  

	 [:div  {:class "control-group"}
         [:label {:class "control-label" :for "enunciadoid"} "ID"]
         [:div {:class "controls"} 
         [:input {:type "text":id "enunciadoid"}]]] 

	 [:div  {:class "control-group"}
         [:label {:class "control-label" :for "tipo"} "TIPO"]
         [:div {:class "controls"} 
         [:input {:type "text":id "tipo"}]]] 	
     
         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "pre"} "Pré-Requisito"]
         [:div {:class "controls"} 
         [:input {:type "text":id "pre"}]]] 

         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "enunciadotipo"} "Tipo-Enunciado"]
         [:div {:class "controls"} 
         [:input {:type "text":id "enunciadotipo"}]]] 

         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "enunciado"} "Enunciado"]
         [:div {:class "controls"} 
         [:textarea {:id "enunciado" :rows "2"}]]]
	
         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "alternativa"} "Alternativas"]
         [:div {:class "controls"} 
         [:div {:class "btn-group"}
         [:input {:type "text"} ]]
         [:div {:class "btn-group"} 
         [:a {:href "#" :onclick "reloadPage();" } [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]]]
         [:br][:br] 
         [:div  {:class "control-group"}
         [:button {:class "btn btn-small btn-success" :href "#"} "Enviar"]]

         ]]       
         ]]]))


(defpage "/admin/home/recursividade/exercicios/aberta" []     
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:id "fundoiframe" :onload "ResizeWH();"} 
         [:div {:align "center"} 
         [:h4 "Adicionar questão aberta"]]

         [:form {:class "form-horizontal" :action "/admin/home/recursividade/multimidia/add/preview" :method "post" :name "form" }
         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "tipoAp"} "Tipo"]
         [:div {:class "controls"} 
         [:input {:type "text":id "tipoAp" :value "Aberta" :name "tipo" :disabled "disabled"}]]] 

               [:div  {:class "control-group"}
         [:label {:class "control-label" :for "descricao"} "Descrição *"]
         [:div {:class "controls"} 
         [:textarea {:id "descricao" :name "descricao"}]]]
         ]]))
              


(defpage "/admin/home/recursividade/multimidia/add" []     
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:id "fundoiframe" :onload "ResizeWH();" } 

         [:div {:align "center"} 
         [:div {:class "page-header"}
         [:h4 "Adicionar Vídeo"]]]
         [:br]

         [:div {:class "container-fluid" }
         [:div {:class "row-fluid" }
         [:div {:class "span6"} 
         
         [:form {:class "form-horizontal"  :action "/admin/home/recursividade/multimidia/add/preview" :method "post" :name "form" }
          [:div {:class "modal-body" :id "cadastro_body"}
         ;[:div  {:class "control-group"}
         ;[:label {:class "control-label" :for "tipoAp"} "Tipo"]
         ;[:div {:class "controls"} 
         ;[:input {:type "text":id "tipoAp" :value "Vídeo" :name "tipo" :disabled "disabled"}]]] 

         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "dado"} "URL :"]
         [:div {:class "controls"} 
         [:input {:type "text":id "dado" :name "dado"}]]] 

         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "legenda"} "Legenda :"]
         [:div {:class "controls"}
         [:input {:type "text":id "legenda" :name "legenda"}]]]  
 

         [:div  {:class "control-group"} 
         [:label {:class "control-label" :for "selecao"} "Seleção :"]
         [:div {:class "controls"}  
         [:select {:id "inputDefault" :name "selecao"}
         [:option {:value "sydney"} "Visual"]
         [:option {:value "melbourne"}"Melbourne"]
         ]]
         ]  
    

         ;[:div  {:class "control-group"}
         ;[:label {:class "control-label" :for "conteudo"} "Conteudo"]
         ;[:div {:class "controls"} 
         ;[:input {:type "text":id "conteudo" :name "conteudo" :value "Recursividade" :disabled "disabled"}]]]  

         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "organizacao"} "Organizaçao :"]
         [:div {:class "controls"}
         [:select {:id "inputDefault" :name "organizacao"}
         [:option {:value "sinestesico"} "Sinestesico"]
         [:option {:value "melbourne"}"Melbourne"]
         ]]
         ] 

         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "inputUtiliza"} "Utilização :"]
         [:div {:class "controls"} 
         [:select {:id "inputDefault" :name "utilizacao"}
         [:option {:value "Teorico"} "Teórico"]
         [:option {:value "Prático"} "Prático"]]   
         ]]
 
  
         ;[:div  {:class "control-group"}
         ;[:label {:class "control-label" :for "tipo-d"} "Tipo- D"]
         ;[:div {:class "controls"} 
         ;[:select {:id "tipo-d" :name "tipoD"}
         ;[:option {:value "url"} "URL"]
         ;]         
         ;]] 

         [:div  {:class "control-group"}
         [:div {:class "controls"} 
         [:button {:class "btn btn-default btn-success" :onclick " return youtube_parser();" :formaction "/admin/home/recursividade/multimidia/add/preview"} "Enviar"]]]
         ]]] 
         [:div {:class "row-fluid" }
         [:div {:class "span5"} 
         [:p [:button {:class "btn btn-large btn-primary"} "Ver todos vídeos"]]
         [:br] 
         [:img {:src "/img/tube.jpg"}]
         ]]
         ];end container-fluid
         ]]))


(defpage "/admin/home/recursividade/index" []     
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:id "fundoiframe"} 
         [:div {:align "center"} 
         [:h4 "Aqui você como professor pode inserir exercicios,multimida e textos"]
         ]]))


(defpage [:post "/admin/home/recursividade/multimidia/add/preview"] 
  {:keys [url,selecao,organizacao,utilizacao,dado,legenda]}
;(gerar-apresentacao caminho id  conteudo "video" selecao organizacao utilizacao tipoD dado legenda)   
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:id "fundoiframe" :onload "ResizeWH();"} 
         [:div {:align "center"}
         [:div {:class "modal-header"} 
         [:img {:src "/img/youtube.png"}]]  
         [:h4  [:iframe {:width "840" :height "340" :src (str "http://www.youtube.com/embed/" dado) :frameborder "1"
              :onclick "mudaVideo();"}]
        
         [:p [:div {:class "btn-group"} 
         [:a {:href (str "/admin/teste?tipo=Vídeo" "&url=" url "&selecao=" selecao "&caminho=src/ils/models/dominio/Cursos/IntroducaoProgramacao/recursao/apresentacao/videos/exemplo3.xml"  "&conteudo=Recursividade" 
                         "&organizacao=" organizacao "&utilizacao=" utilizacao "&tipoD=url" "&dado=" dado "&legenda=" legenda) 
                         :rel "tooltip" :title "Confirmar"}[:img {:src "/img/confirm.png"}]]]
             [:div {:class "btn-group"} [:a {:href "#" :rel "tooltip" :title "Excluir"} [:img {:src "/img/delete.png"}]]]     
         ]]
         ]]))




(defpage "/admin/teste" {:keys [tipo,url,selecao,caminho,conteudo,organizacao,utilizacao,tipoD,dado,legenda]}
;(gerar-apresentacao caminho id  conteudo "video" selecao organizacao utilizacao tipoD dado legenda)  
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:id "fundoiframe" :onload "ResizeWH();"} 
         [:div {:align "center"} 
         [:h1 [:img {:src "/img/check.png"}] "Inserção de vídeo feita com sucesso !!!"]
         [:h2 legenda]     
         [:h4  [:iframe {:width "840" :height "340" :src (str "http://www.youtube.com/embed/" dado) :frameborder "1"
              :onclick "mudaVideo();"}]]   
         ]]))


;:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
;::::::::::::::::::::::::::::::::::::::::::::::::: VETORES :::::::::::::::::::::::::::::::::::::
;:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::


(defpage "/admin/disciplina/vetor" []    
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



(defpage "/admin/disciplina/matrizes" []    
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


(defpage "/admin/disciplina/lista" []    
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



(defpage "/admin/disciplina/fila" []    
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



(defpage "/admin/disciplina/pilha" []    
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

(defpage "/disciplina/metord" []    
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


	




;:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
;:::::::::::::::::::::::::::::::::::::::::: END - IPC ::::::::::::::::::::::::::::::::::::
;:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::



