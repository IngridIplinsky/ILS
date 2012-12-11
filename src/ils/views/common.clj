(ns ils.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5 include-js html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "ILS"]
	      (include-css "/css/myshett.css") 
              (include-css "/css/bootstrap.css")                 
              (include-css "/css/carousel.css") 
              (include-css "/css/carousel-style.css")                 
              (include-js "/js/bootstrap.js")
              (include-js "/js/bootstrap.min.js")
              (include-js "/js/check.js")
              (include-js "/js/carousel.js")
              (include-js "https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js")
              ]
              [:body
               [:div#wrapper
                content]]))
