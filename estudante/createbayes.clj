(ns ils.models.estudante.createbayes
	(:import [BayesianNetworks DiscreteVariable DiscreteFunction BayesNet]))

;Macros utilizadas na criação de redes bayesianas no módulo do estudante.

(defmacro defnode [nodename labelnode body]
	`(def ~nodename
	 (new DiscreteVariable ~labelnode DiscreteVariable/CHANCE
		       (into-array String ~body))))

(defmacro defedge [edgename causa efeito tabela]
	`(def ~edgename 
		(new DiscreteFunction
			(into-array DiscreteVariable ~efeito)
			(into-array DiscreteVariable ~causa)
			(double-array ~tabela))))

(defmacro defbayes [bayesname]
	`(def ~bayesname
	   	(new BayesNet)))

(defn setbayes [bayesname bayesnameaspa vec1 vec2]
	(.set_name bayesname bayesnameaspa)
	(.add bayesname (into-array DiscreteVariable vec1))
	(.add bayesname (into-array DiscreteFunction vec2)))

