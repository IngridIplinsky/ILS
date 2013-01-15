(ns estudante.clojurebayes
  (:import [BayesianNetworks DiscreteVariable DiscreteFunction BayesNet]
		   [BayesianInferences Inference Expectation Explanation]))

;EBayes porting to Clojure
;Eduardo Gonçalves Costa



;TODO verificar se está correta.
(defn carregar-rede [network]
"Carrega uma rede bayesiana."
	(use network)
	(println (str "Rede bayesiana " network " carregada.")))

(defn inferir [network variable]
"Calculates the posterior marginal of a variable."
	(let [pv (.get_probability_variable network variable)]
        (let [inf (new Inference network false)]
			(.inference inf variable)
			(let [res (.get_result inf)]
				(println (str "Posterior marginal for " variable ":"))
					(loop [i 0]
						(when (< i (.number_values res))
							(print (str (.get_value res i) " "))
							(recur (+ i 1))))))))


(defn observar [network variable value]
"Set variable as observed (when value isn't nil), or not observed (value is nil)."
	(let [pv (.get_probability_variable network variable)]
		(if (nil? value) (.set_invalid_observed_index pv) (.set_observed_value pv value))))


(defn explanatoria [network variable value]
"Set variable as explanatory (when value isn't nil), or non-explanatory (value is nil)."
	(let [pv (.get_probability_variable network variable)]
		(if (nil? value) (.set_explanation_index pv -1) (.set_explanation_index pv 0))))


(defn valor-esperado [network variable]
"Expected value for variable."
	(let [pv (.get_probability_variable network variable)]
		(let [expec (new Expectation network false)]
			(.expectation expec variable)
			(let [expectation (.get_result expec)]
				(println (str "Posterior expectation for " variable ": " expectation))))))

;TODO as duas funções abaixo possuem um bug ainda não resolvido. Não use elas, por enquanto.

(defn maximo-posteriori-explanatorias [network]
"Maximum a posteriori for explanatory variables."
	(let [expl (new Explanation network)]
		(.explanation expl)
		(let [explanation (.get_explanation expl)]
			(if (nil? explanation) (println "No explanation was produced!")
				(loop [ie 0]
					(when (< ie (.length explanation))
						(if (not (nil? (explanation ie 0)))
								(println (str "Variable " (explanation ie 0) ":" (explanation ie 1))))
						(recur (+ ie 1))))))))

(defn maximo-posteriori-all [network]
"Maximum a posteriori for all variables."
	(let [expl (new Explanation network)]
		(.full_explanation expl)
		(let [explanation (.get_explanation expl)]
			(if (nil? explanation) (println "No explanation was produced!")
				(loop [ie 0]
					(when (< ie (.length explanation))
						(if (not (nil? (explanation ie 0)))
								(println (str "Variable " (explanation ie 0) ":" (explanation ie 1))))
						(recur (+ ie 1))))))))


