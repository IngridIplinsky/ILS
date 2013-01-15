(ns estudante.dogproblem
	(:import [BayesianNetworks DiscreteVariable DiscreteFunction BayesNet]))

(def lighton
	 (new DiscreteVariable "lighton" DiscreteVariable/CHANCE
		       (into-array String ["true" "false"])))

(def bowelproblem
	 (new DiscreteVariable "bowelproblem" DiscreteVariable/CHANCE
		       (into-array String ["true" "false"])))

(def dogout
	 (new DiscreteVariable "dogout" DiscreteVariable/CHANCE
		       (into-array String ["true" "false"])))

(def hearbark
	 (new DiscreteVariable "hearbark" DiscreteVariable/CHANCE
		       (into-array String ["true" "false"])))

(def familyout
	 (new DiscreteVariable "familyout" DiscreteVariable/CHANCE
		       (into-array String ["true" "false"])))

(def p1 
	(new DiscreteFunction
		(into-array DiscreteVariable [lighton])
		(into-array DiscreteVariable [familyout])
		(double-array [0.6 0.05 0.4 0.95])))

(def p2 
	(new DiscreteFunction
		(into-array DiscreteVariable [bowelproblem])
		(into-array DiscreteVariable [])
		(double-array [0.01 0.99])))

(def p3 
	(new DiscreteFunction
		(into-array DiscreteVariable [dogout])
		(into-array DiscreteVariable [bowelproblem familyout])
		(double-array [0.99 0.97 0.9 0.3 0.01 0.03 0.1 0.7])))

(def p4 
	(new DiscreteFunction
		(into-array DiscreteVariable [hearbark])
		(into-array DiscreteVariable [dogout])
		(double-array [0.7 0.01 0.3 0.99])))

(def p5 
	(new DiscreteFunction
		(into-array DiscreteVariable [familyout])
		(into-array DiscreteVariable [])
		(double-array [0.15 0.85])))

(def dogproblem
     (new BayesNet))

(.set_name dogproblem "dogproblem")
(.add dogproblem (into-array DiscreteVariable [lighton hearbark dogout bowelproblem familyout]))
(.add dogproblem (into-array DiscreteFunction [p1 p2 p3 p4 p5]))

