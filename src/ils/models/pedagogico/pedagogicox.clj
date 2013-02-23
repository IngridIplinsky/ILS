(ns ils.models.pedagogico.pedagogicox
	(:use
		[ils.models.pedagogico.formatapergunta] 
		[ils.models.pedagogico.main]
		[ils.models.pedagogico.compilador]
		[ils.models.pedagogico.corretor]
	)
)

(defn iniciarPedagogico [materia]
	(main materia)
)

(defn corrigirExercicio [n op]
	(corretor n op)
)