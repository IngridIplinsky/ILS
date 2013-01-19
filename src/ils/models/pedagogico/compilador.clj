(ns ils.models.pedagogico.compilador
	(:use 
		[clojure.java.shell :only [sh]]
	)
)

(defn pedagogico-gcc [exit]
  (def path "/home/pablo/Documents/CLOJUREE/codigo")
  (spit (str path ".c") exit) ; crio o arquivo.
   (cond
      (= (get (sh "gcc" "-o" (str path ".o") (str path ".c")) :err) "")
         "true"
      :else
         "false"
   )
)

(defn gcc [exit]
  (def path "/home/pablo/Documents/CLOJUREE/codigo")
  (spit (str path ".c") exit) ; crio o arquivo.
  (let [retorno (get (sh "gcc" "-o" (str path ".o") (str path ".c")) :err) ok "true"]
    (cond
      (= retorno "")
        ok
      :else
        retorno
    )
  )
)