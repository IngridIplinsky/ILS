(ns ils.models.dominio.dominio
  (:require [clojure.xml :as xml]
  	[clojure.zip :as zip] 
	[clojure.contrib.zip-filter.xml :as zf]
))

(defn get-value [xml & tags]
  (apply zf/xml1-> (zip/xml-zip (xml/parse xml)) (conj (vec tags) zf/text)))
