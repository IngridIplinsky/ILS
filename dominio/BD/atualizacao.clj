(ns ils.models.dominio.BD.atualizacao
    (:use ils.models.dominio.BD.persistence)
    (:require [clojure.java.jdbc :as sql]))

(defn atualizar-aluno 
"Atualiza os dados pessoais de um aluno a partir da matricula, passando matricula, 
 uma coluna (formato :exemplo) e o valor novo (entre aspas)."
  [matricula coluna novo]
    (sql/with-connection ILS-DB
      (sql/update-values :aluno
        [(str "aluno.matricula ='"matricula"'")]
        {coluna novo})))

(defn atualizar-professor
"Atualiza os dados pessoais de um professor a partir da matricula, passando matricula, 
 uma coluna (formato :exemplo) e o valor novo (entre aspas)."
  [matricula coluna novo]
    (sql/with-connection ILS-DB
      (sql/update-values :professor
        [(str "professor.matricula ='"matricula"'")]
        {coluna novo})))
        
 (defn atualizar-estiloEstudante 
"Atualiza os dados da tabela estiloEstudante passando matricula, sigla, 
 uma coluna (formato :exemplo) e o valor novo (entre aspas)."
  [matricula sigla coluna novo]
    (sql/with-connection ILS-DB
      (sql/update-values :estiloEstudante
        [(str "estiloEstudante.matricula ='"matricula"' AND estiloEstudante.sigla = '"sigla"'")]
        {coluna novo})))
        
(defn atualizar-exercicioAluno
"Atualiza os dados da tabela exercicioAluno passando matricula, conteudo, id do exercicio, 
 uma coluna (formato :exemplo) e o valor novo (entre aspas)."
  ([matricula conteudo idEx coluna novo]
    (sql/with-connection ILS-DB
      (sql/update-values :exercicioAluno
        [(str "exercicioAluno.matricula ='"matricula"' AND exercicioAluno.conteudo = '"conteudo"' AND exercicioAluno.idEx = '"idEx"'")]
        {coluna novo})))
   ([matricula conteudo idEx bom medio ruim]
    "Para atualizar as probabilidades nas tabelas."
     (sql/with-connection ILS-DB
       (sql/update-values :exercicioAluno
         [(str "exercicioAluno.matricula ='"matricula"' AND exercicioAluno.conteudo = '"conteudo"' AND exercicioAluno.idEx = '"idEx"'")]
        {:bom bom :medio medio :ruim ruim}))))

(defn atualizar-conteudoAluno
"Atualiza os dados pessoais de um aluno a partir da matricula, passando matricula, 
 uma coluna (formato :exemplo) e o valor novo (entre aspas)."
  ([matricula conteudo coluna novo]
    (sql/with-connection ILS-DB
      (sql/update-values :conteudoAluno
        [(str "conteudoAluno.matricula ='"matricula"' AND conteudoAluno.conteudo = '"conteudo"'")]
        {coluna novo})))
   ([matricula conteudo bom medio ruim]
     (sql/with-connection ILS-DB
       (sql/update-values :conteudoAluno
         [(str "exercicioAluno.matricula ='"matricula"' AND exercicioAluno.conteudo = '"conteudo"'")]
        {:bom bom :medio medio :ruim ruim}))))

(defn atualizar-logAluno
"Atualiza os dados da tabela logAluno pela passagem da matrícula para a qual os dados serão atualizados, a nova sigla de
 disciplina, o id de conteúdo e o id do exercício, todos entre aspas."
  [matricula sigla idCont idEx]
    (sql/with-connection ILS-DB
      (sql/update-values :logAluno
	[(str "logAluno.matricula = '"matricula"'")]
	{:sigla sigla 
	 :idCont idCont 
	 :idEx idEx})))
	 
;(defn atualiza-todo-dominio [alunokey conteudo]
;    (cond (> ( / (count(retorna-exercicio-certos alunokey conteudo)) 10) 1/2) (atualizar-probs-conteudo alunokey conteudo 1.0 0.0 0.0)
;     :else (atualizar-probs-conteudo alunokey conteudo 0.0 0.0 1.0))) 

