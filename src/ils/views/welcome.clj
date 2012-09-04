(ns ils.views.welcome
  (:require [ils.views.common :as common]
            [noir.content.getting-started])
  (:use [noir.core :only [defpage]]
        [hiccup.core :only [html]]))

(defpage "/welcome" []
         (common/layout
           [:p "Welcome to website"]))

(defpage "/teste" []
	(common/layout
	[:center [:h1 "This is my first page!"]]))
