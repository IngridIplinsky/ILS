(ns ils.models.dominio.BD.atualizacao
    (:use [ils.models.dominio.BD.persistence]
          [ils.models.dominio.BD.busca])
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
  [matricula sigla selecao organizacao utilizacao]
    (sql/with-connection ILS-DB
      (sql/update-or-insert-values :estiloEstudante
        [(str "estiloEstudante.matricula ='"matricula"' AND estiloEstudante.sigla = '"sigla"'")]
        {:matricula matricula
         :sigla sigla
         :idEst (first (vals (first (buscar-estilo "idEst" selecao organizacao utilizacao))))})))
        
(defn atualizar-exercicioAluno
"Atualiza os dados da tabela exercicioAluno passando matricula, conteudo, id do exercicio, 
 uma coluna (formato :exemplo) e o valor novo (entre aspas)."
   ([matricula sigla conteudo idEx bom medio ruim]
    "Para atualizar as probabilidades nas tabelas."
     (sql/with-connection ILS-DB
       (sql/update-or-insert-values :exercicioAluno
         [(str "exercicioAluno.matricula ='"matricula"' AND exercicioAluno.conteudo = '"conteudo"' AND exercicioAluno.idEx = '"idEx"'")]
        {:matricula matricula
         :idCont (first (vals (first (buscar-conteudo "idCont" "conteudo" conteudo "sigla" sigla))))
         :idEx idEx
         :bom bom 
         :medio medio 
         :ruim ruim}))))

(defn atualizar-conteudoAluno
"Atualiza os dados pessoais de um aluno a partir da matricula, passando matricula, 
 uma coluna (formato :exemplo) e o valor novo (entre aspas)."
   ([matricula sigla conteudo bom medio ruim]
     (sql/with-connection ILS-DB
       (sql/update-or-insert-values :conteudoAluno
         [(str "exercicioAluno.matricula ='"matricula"' AND exercicioAluno.conteudo = '"conteudo"'")]
        {:matricula matricula
         :idCont (first (vals (first (buscar-conteudo "idCont" "conteudo" conteudo "sigla" sigla))))
         :bom bom 
         :medio medio 
         :ruim ruim}))))

(defn atualizar-logAluno
"Atualiza os dados da tabela logAluno pela passagem da matrícula para a qual os dados serão atualizados, a nova sigla de
 disciplina, o id de conteúdo e o id do exercício, todos entre aspas."
  [idLog matricula sigla idCont idEx]
    (sql/with-connection ILS-DB
      (sql/update-or-insert-values :logAluno
	[(str "logAluno.matricula = '"matricula"'")]
	{:idLog idLog
   :sigla sigla 
   :matricula matricula
	 :idCont idCont 
	 :idEx idEx})))
	 
;(defn atualiza-todo-dominio [alunokey conteudo]
;    (cond (> ( / (count(retorna-exercicio-certos alunokey conteudo)) 10) 1/2) (atualizar-probs-conteudo alunokey conteudo 1.0 0.0 0.0)
;     :else (atualizar-probs-conteudo alunokey conteudo 0.0 0.0 1.0))) 

