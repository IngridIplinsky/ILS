(ns ils.views.professor.principal
  (:require [ils.views.common :as common]
            [noir.content.getting-started]
            [noir.session :as session]
            )
  (:use [ils.views comunicacao] 
        [ils.models.dominio.BD busca]
        [ils.models.dominio.BD insercao]
        [ils.models.dominio.xml manipulacao] 
	[ils.views.professor home]
        [noir.core :only [defpage]]
        [hiccup.core :only [html]]
        [noir.core :only [defpartial]]
        ;[noir.response :only [redirect]]
        [hiccup.page-helpers :only [include-css html5 include-js html5]]
 ))



;::::::::::::::::::::::::::::::: /admin :::::::::::::::::::::::::::::::


(defpage "/admin" []     
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
         [:div {:class "span4"}
         [:div {:class "well sidebar-nav"}
         [:ul  {:class "nav nav-list"}
         [:li  {:class "nav-header"}""]
         [:h4 "Cursos Disponíveis" ]
         [:p [:div {:class "btn-group"}  
         [:a {:class "btn btn-large btn-info" :href "#" :id "buttonLarge"}[:i {:class "icon-user icon-white"}] "Introdução a Programação"]]]
         [:p [:div {:class "btn-group"} 
         [:a {:class "btn btn-large btn-info" :href "#" :id "buttonLarge"}[:i {:class "icon-user icon-white"}] "Estruturas de Dados "]]
	 [:p [:div {:class "btn-group"} [:a {:href "/admin/new"} [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]]]] 
         ]]]]
	 
         [:div {:class "span4" }
         [:div {:class "well sidebar-nav"}
         [:div {:class "nav nav-list"}      
         [:h4 "Cursos que ministra"]
         [:p {:name "Curso"}]
          (curso_introducao_professor)
          (curso_estrutura_dados_professor)
          [:p [:div {:class "btn-group"} [:a {:href "#"} [:img {:src "/img/glyphicons_192_circle_remove.png"} ]]]]
    
         ]]]]]]]
         [:div {:class "modal-footer" :id "rodape"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]
         ]))	


(defpage "/admin/new" []    
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



;:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::         
;:::::::::::::::::::::::::::::::::::::::::::::::::::::: END ::::::::::::::::::::::::::::::::::::::::::::::::
;:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

