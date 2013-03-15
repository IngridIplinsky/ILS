(ns ils.views.professor.home
  (:require [ils.views.common :as common]
            [noir.content.getting-started]
            [noir.session :as session]
            )
  (:use [ils.views comunicacao] 
        [ils.models.dominio.BD busca]
        [ils.models.dominio.BD insercao]
        [ils.models.dominio.xml manipulacao] 
        [noir.core :only [defpage]]
        [hiccup.core :only [html]]
        [noir.core :only [defpartial]]
        ;[noir.response :only [redirect]]
        [hiccup.page-helpers :only [include-css html5 include-js html5]]
 ))



;::::::::::::::::::::::::::::::: /login/admin/home/disciplina(s) :::::::::::::::::::::::::::::::



(defpage  "/admin/home/introducao" []     
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
         [:a {:href "/admin/home/estruturas"} [:h3 "ED1"]]
	 [:a {:href "/admin/home/introducao"} [:h3 "IPC"]]
         [:br][:br][:br][:br][:br][:br][:br][:br][:br][:br][:br]
         
         ]]
         
         [:div {:class "span10"} 
         [:div {:class "well sidebar-nav"}
         [:center [:h3 {:style "color:green;"} "Escolher um dos conteúdos da disciplina abaixo ou adicione+ novo"]]
         [:div {:align "center"}
         [:a {:href "/admin/disciplina/recursividade"} [:h4 "Recusividade"]]
	 [:a {:href "/admin/disciplina/vetor"} [:h4 "Vetor"]]
	 [:a {:href "/admin/disciplina/matrizes"}[:h4 "Matrizes"]]
	 [:a {:href "/admin/disciplina/lista"}[:h4 "Lista"]]
	 [:a {:href "/admin/disciplina/fila"}[:h4 "Fila"]]
         [:a {:href "/admin/disciplina/pilha"}[:h4 "Pilha"]]
         [:a {:href "/admin/disciplina/arvore"}[:h4 "Árvore"]]
	 [:a {:href "/admin/disciplina/metord"}[:h4 "Métodos de Ordenação"]]
         [:a {:href "/admin/disciplina/metpesq"}[:h4 "Métodos de Pesquisa"]]
	 [:p [:a {:href "/admin/disciplina/new"} [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]]]]
         ]
	 ]]] ;end (container-fluid,row-fluid,span2,well sidebar-nav)

         [:div {:class "modal-footer" :id "rodape"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]
         
         ])) 




(defpage "/admin/home/estruturas" []     
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
         [:a {:href "/admin/home/estruturas" }[:h3 "ED1"]]
	 [:a {:href "/admin/home/introducao" }[:h3 "IPC"]]
         [:br][:br][:br][:br][:br][:br][:br][:br][:br][:br][:br]
         
         ]]
         [:div {:class "span10"} 
         [:div {:class "well sidebar-nav"}
         [:center [:h3 {:style "color:green;"} "Escolher um dos conteúdos da disciplina abaixo ou adicione+ novo"]]
         [:div {:align "center"}

         [:a {:href "/admin/disciplina/recursividade"} [:h4 "Estrutura de Dados"]]
	 [:a {:href "/admin/disciplina/vetor"} [:h4 "Recursividade"]]
	 [:a {:href "/admin/disciplina/vetor"}[:h4 "Vetor"]]
	 [:a {:href "/admin/disciplina/matrizes"}[:h4 "Matrizes"]]
	 [:a {:href "/admin/disciplina/fila"}[:h4 "Lista"]]
         [:a {:href "/admin/disciplina/pilha"}[:h4 "Fila"]]
         [:a {:href "/admin/disciplina/arvore"}[:h4 "Pilha"]]
	 [:a {:href "/admin/disciplina/metord"}[:h4 "Arvore"]]
         [:a {:href "/admin/disciplina/metpesq"}[:h4 "Métodos de Ordenacao"]]
         [:a {:href "/admin/disciplina/metpesq"}[:h4 "Métodos de Pesquisa"]]
	 [:p [:a {:href "/admin/disciplina/new"} [:img {:src "/img/glyphicons_131_inbox_plus.png"} ]]]]
         ]
	 ]]] ;end (container-fluid,row-fluid,span2,well sidebar-nav)

         [:div {:class "modal-footer" :id "rodape"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]
         
         ])) 


	
(defpage "/admin/disciplina/new" []    
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
         [:a {:class "btn  btn-warning" :id "color-link" :href "/admin" }[:i {:class "icon-user icon-white"}] "Cancelar "]]]         
    
         
         [:div {:class "modal-footer" :id "rodape"}
         [:div {:class "container"}
         [:div   {:class "control-group"} 
         [:center [:h5  "&#169; Copyright 2013 - e-Duca"]]]]]
	 ]))








