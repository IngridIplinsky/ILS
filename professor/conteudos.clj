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
         [:a [:h3 "ED1"]]
	 [:a [:h3 "IPC"]]
         

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
         [:h4 "Adicionar Vídeo"]]

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
         [:body {:id "fundoiframe" :onload "ResizeWH();"} 

         [:div {:align "center"} 
         [:h4 "Adicionar Vídeo"]]

         [:form {:class "form-horizontal" :action "/admin/home/recursividade/multimidia/add/preview" :method "post" :name "form" }
         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "tipoAp"} "Tipo"]
         [:div {:class "controls"} 
         [:input {:type "text":id "tipoAp" :value "Vídeo" :name "tipo" :disabled "disabled"}]]] 

               [:div  {:class "control-group"}
         [:label {:class "control-label" :for "id"} "ID"]
         [:div {:class "controls"} 
         [:input {:type "text" :id "id" :name "id"}]]]  


         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "selecao"} "Seleção"]
         [:div {:class "controls"} 
         [:input {:type "text":id "selecao" :name "selecao"}]]] 

         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "caminho"} "Caminho do Arquivo"]
         [:div {:class "controls"} 
         [:input {:type "text":id "caminho" :name "caminho"}]]] 

   

         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "conteudo"} "Conteudo"]
         [:div {:class "controls"} 
         [:input {:type "text":id "conteudo" :name "conteudo" :value "Recursividade" :disabled "disabled"}]]]  

         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "organizacao"} "Organizaçao"]
         [:div {:class "controls"} 
         [:input {:type "text":id "organizacao" :name "organizacao"}]]]  

         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "utilizacao"} "Utilização"]
         [:div {:class "controls"} 
         [:input {:type "text":id "utilizacao" :name "utilizacao"}]]] 
  
         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "tipo-d"} "Tipo- D"]
         [:div {:class "controls"} 
         [:input {:type "text":id "tipo-d" :name "tipoD"}]]] 

         
         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "dado"} "Dado"]
         [:div {:class "controls"} 
         [:input {:type "text":id "dado" :name "dado"}]]] 

         [:div  {:class "control-group"}
         [:label {:class "control-label" :for "legenda"} "Legenda"]
         [:div {:class "controls"} 
         [:input {:type "text":id "legenda" :name "legenda"}]]]  
          
          


         [:div  {:class "control-group"}
         [:div {:class "controls"} 
         [:button {:class "btn btn-small btn-success" :formaction "/admin/home/recursividade/multimidia/add/preview"} "Enviar"]]]
  
         ]]))


(defpage "/admin/home/recursividade/index" []     
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:id "fundoiframe"} 
         [:div {:align "center"} 
         [:h4 "Aqui você como professor pode inserir exercicios,multimida e textos"]
         ]]))


(defpage [:post "/admin/home/recursividade/multimidia/add/preview"] 
  {:keys [tipo,id,url,selecao,caminho,conteudo,organizacao,utilizacao,tipoD,dado,legenda]}
;(gerar-apresentacao caminho id  conteudo "video" selecao organizacao utilizacao tipoD dado legenda)   
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:id "fundoiframe"} 
         [:div {:align "center"} 
         [:h4 dado] 
         [:h4 id ]   
         [:h4  [:iframe {:width "250" :height "150" :src dado :frameborder "1"
              :onclick "mudaVideo();"}]] 
         ]]))


(defpage "/admin/teste" []     
      (common/layout
         [:head [:script {:type "text/javascript" :src "/js/bootstrap.min.js"}]]
         [:body {:id "fundoiframe"} 
         [:div {:align "center"} 
         [:h4 "Aqui você como professor pode inserir exercicios,multimida e textos"]

  
         [:h4  [:iframe {:width "450" :allowfullscreen "true" :height "320" :src "http://www.youtube.com/embed/wdFZ_LAiiWE?feature=player_detailpage" :frameborder "1"
               :onclick "mudaVideo();"}]




  [:object {:data "http://www.youtube.com/watch?v=wdFZ_LAiiWE" :type "application/x-shockwave-flash" :width "425" :height "350"}
  [:param {:name "quality" :value "high" }]
  [:param {:name "movie" :value "http://www.youtube.com/watch?v=wdFZ_LAiiWE" }]
  [:img {:src "/img/video.png" :alt "Vídeo (Objeto multimídia)"}]
  ]


 
         ]



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



