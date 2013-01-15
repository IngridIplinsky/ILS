(ns estudante.gsi002
	(:import [BayesianNetworks DiscreteVariable DiscreteFunction BayesNet]))

(def introducao
	 (new DiscreteVariable "introducao" DiscreteVariable/CHANCE
		       (into-array String ["bom" "medio" "ruim"])))

(def estruturasCond
	 (new DiscreteVariable "estruturasCond" DiscreteVariable/CHANCE
		       (into-array String ["bom" "medio" "ruim"])))

(def laco
	 (new DiscreteVariable "laco" DiscreteVariable/CHANCE
		       (into-array String ["bom" "medio" "ruim"])))

(def vetor
	 (new DiscreteVariable "vetor" DiscreteVariable/CHANCE
		       (into-array String ["bom" "medio" "ruim"])))

(def funcao
	 (new DiscreteVariable "funcao" DiscreteVariable/CHANCE
		       (into-array String ["bom" "medio" "ruim"])))

(def recursao
	 (new DiscreteVariable "recursao" DiscreteVariable/CHANCE
		       (into-array String ["bom" "medio" "ruim"])))

(def alocDin
	 (new DiscreteVariable "alocDin" DiscreteVariable/CHANCE
		       (into-array String ["bom" "medio" "ruim"])))

(def strings
	 (new DiscreteVariable "strings" DiscreteVariable/CHANCE
		       (into-array String ["bom" "medio" "ruim"])))

(def estruturas
	 (new DiscreteVariable "estruturas" DiscreteVariable/CHANCE
		       (into-array String ["bom" "medio" "ruim"])))

(def arquivo
	 (new DiscreteVariable "arquivo" DiscreteVariable/CHANCE
		       (into-array String ["bom" "medio" "ruim"])))

(def p1 
	(new DiscreteFunction
		(into-array DiscreteVariable [introducao])
		(into-array DiscreteVariable [])
		(double-array [0.33 0.34 0.33])))

(def p2 
	(new DiscreteFunction
		(into-array DiscreteVariable [estruturasCond])
		(into-array DiscreteVariable [introducao])
		(double-array  [0.07 	0.16 	0.77 
		  				0.46  	0.41  	0.13 
		  				0.84  	0.13  	0.03])))

(def p3 
	(new DiscreteFunction
		(into-array DiscreteVariable [laco])
		(into-array DiscreteVariable [introducao])
		(double-array  [0.07 	0.16 	0.77 
		  				0.46  	0.41  	0.13 
		  				0.84  	0.13  	0.03])))

(def p4 
	(new DiscreteFunction
		(into-array DiscreteVariable [vetor])
		(into-array DiscreteVariable [introducao])
		(double-array  [0.07 	0.16 	0.77 
		  				0.46  	0.41  	0.13 
		  				0.84  	0.13  	0.03])))

(def p5 
	(new DiscreteFunction
		(into-array DiscreteVariable [funcao])
		(into-array DiscreteVariable [laco estruturasCond])
		(double-array  [	1.0 	0.0 	0.0
							0.45 	0.33 	0.22
							0.0 	0.0 	1.0
							0.82 	0.09 	0.09
							0.315 	0.37 	0.315
							0.182 	0.23 	0.545
							1.0 	0.0 	0.0
							0.68 	0.11 	0.21
							0.08 	0.42 	0.5])))

(def p6 
	(new DiscreteFunction
		(into-array DiscreteVariable [recursao])
		(into-array DiscreteVariable [funcao])
		(double-array   [0.07 	0.16 	0.77 
		  				0.46  	0.41  	0.13 
		  				0.84  	0.13  	0.03])))

(def p7 
	(new DiscreteFunction
		(into-array DiscreteVariable [alocDin])
		(into-array DiscreteVariable [vetor])
		(double-array   [0.07 	0.16 	0.77 
		  				0.46  	0.41  	0.13 
		  				0.84  	0.13  	0.03])))

(def p8 
	(new DiscreteFunction
		(into-array DiscreteVariable [strings])
		(into-array DiscreteVariable [alocDin])
		(double-array   [0.07 	0.16 	0.77 
		  				0.46  	0.41  	0.13 
		  				0.84  	0.13  	0.03])))

(def p9
	(new DiscreteFunction
		(into-array DiscreteVariable [arquivo])
		(into-array DiscreteVariable [strings])
		(double-array   [0.07 	0.16 	0.77 
		  				0.46  	0.41  	0.13 
		  				0.84  	0.13  	0.03])))


(def p10 
	(new DiscreteFunction
		(into-array DiscreteVariable [estruturas])
		(into-array DiscreteVariable [alocDin vetor])
		(double-array  [	1.0 	0.0 	0.0
							0.45 	0.33 	0.22
							0.0 	0.0 	1.0
							0.82 	0.09 	0.09
							0.315 	0.37 	0.315
							0.182 	0.23 	0.545
							1.0 	0.0 	0.0
							0.68 	0.11 	0.21
							0.08 	0.42 	0.5])))

(def gsi002
	 (new BayesNet))

(.set_name gsi002 "gsi002")
(.add gsi002 (into-array DiscreteVariable [introducao estruturasCond laco vetor funcao recursao alocDin estruturas strings arquivo]))
(.add gsi002 (into-array DiscreteFunction [p1 p2 p3 p4 p5 p6 p7 p8 p9 p10]))


