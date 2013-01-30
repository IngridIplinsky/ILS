(ns ils.models.dominio.BD.remocao
    (:use ils.models.dominio.BD.persistence)
    (:require [clojure.java.jdbc :as sql])
)


(defn remover-aluno
  "Remove um aluno do banco, pela matricula."
   [matricula]
   (sql/with-connection ILS-DB
    (sql/delete-rows :aluno
      [(str "aluno.matricula = '"matricula"'")]
    )))
    
(defn remover-professor
  "Remove um professor do banco, pela matricula."
   [matricula]
   (sql/with-connection ILS-DB
    (sql/delete-rows :professor
      [(str "professor.matricula = '"matricula"'")]
    )))
    
(defn remover-disciplina
  "Remove uma disciplina do banco, pela sigla."
   [sigla]
   (sql/with-connection ILS-DB
    (sql/delete-rows :disciplina
      [(str "disciplina.sigla = '"sigla"'")]
    )))
    
(defn remover-conteudo
  "Remove um conteudo de uma disciplina do banco, pela sigla e pelo nome de conteudo."
   [sigla conteudo]
   (sql/with-connection ILS-DB
    (sql/delete-rows :conteudo
      [(str "conteudo.sigla = '"sigla"' AND conteudo.conteudo = '"conteudo"'")]
    )))
    
(defn remover-ministra
  "Remove uma disciplina ministrada por determinado professor do banco, pela sigla e pelo professor."
   [sigla matricula]
   (sql/with-connection ILS-DB
    (sql/delete-rows :ministra
      [(str "ministra.sigla = '"sigla"' AND ministra.matricula = '"matricula"'")]
    )))

(defn remover-exercicio
  "Remove um exercicio do banco, pelo id."
   [idEx]
   (sql/with-connection ILS-DB
    (sql/delete-rows :exercicio
      [(str "exercicio.idEx = '"idEx"'")]
    )))
    
    
(defn remover-apresentacao
  "Remove uma apresentacao do banco, pelo id."
   [idAp]
   (sql/with-connection ILS-DB
    (sql/delete-rows :apresentacao
      [(str "apresentacao.idAp = '"idAp"'")]
    )))
    
(defn remover-exercicioAluno
  "Remove o aproveitamento de um aluno em um exercicio, entrando com o numero de matricula, nome do conteudo e id do exercicio."
   [matricula conteudo idEx]
   (sql/with-connection ILS-DB
    (sql/delete-rows :exercicioAluno
      [(str "exercicioAluno.matricula = '"matricula"' AND exercicioAluno.conteudo = '"conteudo"' AND exercicioAluno.idEx = '"idEx"'")]
    )))
    
(defn remover-conteudoAluno
  "Remove o aproveitamento de um aluno em um conteudo, entrando com o numero de matricula, nome do conteudo e id do exercicio."
   [matricula conteudo]
   (sql/with-connection ILS-DB
    (sql/delete-rows :conteudoAluno
      [(str "conteudoAluno.matricula = '"matricula"' AND conteudoAluno.conteudo = '"conteudo"'")]
    )))
    
(defn remover-estiloEstudante
  "Remove o aproveitamento de um aluno em um conteudo, entrando com o numero de matricula, nome do conteudo e id do exercicio."
   [matricula sigla]
   (sql/with-connection ILS-DB
    (sql/delete-rows :estiloEstudante
      [(str "estiloEstudante.matricula = '"matricula"' AND estiloEstudante.sigla = '"sigla"'")]
    )))
    
(defn remover-catalogoBug
  "Remove o erro de um aluno do catálogo de bugs, através do id."
   [idBug]
   (sql/with-connection ILS-DB
    (sql/delete-rows :catalogoBug
      [(str "catalogoBug = '"idBug"'")]
    )))    
    
(defn remover-estilo
  "Remove o erro de um aluno do catálogo de bugs, através do id."
   [selecao organizacao utilizacao]
   (sql/with-connection ILS-DB
    (sql/delete-rows :catalogoBug
      [(str "selecao = '"selecao"' AND organizacao = '"organizacao"' AND utilizacao = '"utilizacao"'")]
    )))

(defn remover-logAluno
  "Remove o log de última sessão de um aluno, através do id."
   [idLog]
   (sql/with-connection ILS-DB
    (sql/delete-rows :logAluno
      [(str "idLog = '"idLog"'")]
    )))   
