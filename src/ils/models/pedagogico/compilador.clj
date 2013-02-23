(ns ils.models.pedagogico.compilador
	(:use 
		[clojure.java.shell :only [sh]]
	)
)

(defn gcc [exit]
  (let 
    [
      path "/home/pablo/Documents/CLOJUREE/codigo"
    ]
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
)
