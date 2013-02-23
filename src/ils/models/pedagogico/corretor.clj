(ns ils.models.pedagogico.corretor
  (:use
    [ils.models.pedagogico.compilador]
    [ils.models.pedagogico.main]
    [ils.models.dominio.xml.manipulacao]
  )
)

(defn chamar-gerador [n nivel resposta]
  (pedagogico-gera-exercicio n nivel resposta)
)

(defn corretor [n respostaDoAluno]
  (let [
    xmlmap {
    :conteudo (.toLowerCase (get-tag-exercicio :conteudo))
    :exercicio (get-tag-exercicio :idEx)
    :nivel (get-tag-exercicio :nivel)
    :tipo (get-tag-exercicio :tipo)
    }
    mapaRespostas {
    "a" 0
    "b" 1
    "c" 2
    "d" 3
    }
  ]
  (cond
    ;; verifica os tipos dos exercicios e escolhe uma forma de checar a questao.
    (= (get xmlmap :tipo) "me") (def xmlmap (conj {:resposta (get-attr-exercicio :alternativa :valor (get mapaRespostas respostaDoAluno))} xmlmap))
    (= (get xmlmap :tipo) "vf") (def xmlmap (conj {:resposta (get-attr-exercicio :alternativa :valor (get mapaRespostas respostaDoAluno))} xmlmap))
    (= (get xmlmap :tipo) "aa") (def xmlmap (conj {:resposta (get-attr-exercicio :alternativa :valor (get mapaRespostas respostaDoAluno))} xmlmap))
    ;
    ; Os tipos "aberta" e "programacao" devera chamar uma funcao do compilador
    ; para que este verifique a corretude do exercicio.
    ;
    (= (get xmlmap :tipo) "programacao") (def xmlmap (conj {:resposta (gcc respostaDoAluno)} xmlmap))
    ;; a linha abaixo (else) refere-se a programacao
    :else (xmlmap (conj {:resposta (get-attr-exercicio :alternativa :valor (get mapaRespostas respostaDoAluno))} xmlmap))
  )

  (cond
    (= (get xmlmap :resposta) "true") (pedagogico-gera-exercicio n (get xmlmap :nivel) (get xmlmap :resposta))
    (= (get xmlmap :resposta) "false") (pedagogico-gera-exercicio n (get xmlmap :nivel) (get xmlmap :resposta))
    :else (println :resposta)
    )
  )
)
