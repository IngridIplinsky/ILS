(ns ils.views.comunicacao
  (:require [ils.views.common :as common]
            [noir.content.getting-started]
  )
(:use   [ils.models.estudante.corygil estudante]
        [ils.models.dominio.BD busca] 
        [noir.core :only [defpage]]
        [hiccup.core :only [html]]
        [noir.core :only [defpartial]]
        ;[noir.response :only [redirect]]
        [hiccup.page-helpers :only [include-css html5 include-js html5]]
 ))

(defn curso_introducao []
         [:p [:div {:class "btn-group"}  
         [:button {:class "btn btn-large btn-danger" :href "/index" }[:i {:class "icon-user icon-white"}] "Introdução a Programação"]]]
)   

(defn curso_estrutura_dados []
         [:p [:div {:class "btn-group"}  
         [:button {:class "btn btn-large btn-danger" :href "/index"}[:i {:class "icon-user icon-white"}] "Estrutura de Dados"]]]
)   


(defn curso_introducao_professor []
         [:p [:div {:class "btn-group"}  
         [:button {:class "btn btn-large btn-danger" :href "/login/admin/home" }[:i {:class "icon-user icon-white"}] "Introdução a Programação"]]]
)   

(defn curso_estrutura_dados_professor []
         [:p [:div {:class "btn-group"}  
         [:button {:class "btn btn-large btn-danger" :href "/login/admin/home"}[:i {:class "icon-user icon-white"}] "Estrutura de Dados"]]]
)  

