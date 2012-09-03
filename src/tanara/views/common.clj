(ns tanara.views.common
  (:use [noir.core :only [defpartial]]
        [hiccup.page-helpers :only [include-css html5 include-js html5]]))

(defpartial layout [& content]
            (html5
              [:head
               [:title "TANARA"]
	      (include-css "/css/myshett.css")
              (include-js "/js/check.js")]
              [:body
               [:div#wrapper
                content]]))
