(ns ils.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5 include-js html5]]))


;Definido o layout do site, que será utilizado em todas as paginas
;incluído o CSS de nome myshett.css
;titulo da pagina "ILS"

(defpartial layout [& content]
            (html5
              [:head
               [:title "ILS"]
	      (include-css "/css/myshett.css")
              (include-js "/js/check.js")]
              [:body
               [:div#wrapper
                content]]))
