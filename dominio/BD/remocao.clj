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
  "Remove um conteudo de uma disciplina do banco, pela id do conteúdo ou usando a sigla e o nome de conteudo."
   ([idCont]
   (sql/with-connection ILS-DB
    (sql/delete-rows :conteudo
      [(str "conteudo.idCont = '"idCont"'")]
    )))
   ([sigla conteudo]
   (sql/with-connection ILS-DB
    (sql/delete-rows :conteudo
      [(str "conteudo.sigla = '"sigla"' AND conteudo.conteudo = '"conteudo"'")]
    ))))
    
(defn remover-ministra
  "Remove uma disciplina ministrada por determinado professor do banco, pela sigla e pela matricula."
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
  "Remove o aproveitamento de um aluno em um exercicio, entrando com o numero de matricula, id do conteudo e id do exercicio."
   [matricula idCont idEx]
   (sql/with-connection ILS-DB
    (sql/delete-rows :exercicioAluno
      [(str "exercicioAluno.matricula = '"matricula"' AND exercicioAluno.idCont = '"idCont"' AND exercicioAluno.idEx = '"idEx"'")]
    )))
    
(defn remover-conteudoAluno
  "Remove o aproveitamento de um aluno em um conteudo, entrando com o numero de matricula e o id do conteudo."
   [matricula idCont]
   (sql/with-connection ILS-DB
    (sql/delete-rows :conteudoAluno
      [(str "conteudoAluno.matricula = '"matricula"' AND conteudoAluno.idCont = '"idCont"'")]
    )))
    
(defn remover-estiloEstudante
  "Remove o estilo associado a um estudante, entrando com o numero de matricula e a sigla."
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
  "Remove um dado da tabela estilo, através dos valores de selecao, organizacao e utilizacao."
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

(defn remover-matricula
  "Remove a matricula de um aluno em algum curso, através da matricula e da sigla."
   [matricula sigla]
   (sql/with-connection ILS-DB
    (sql/delete-rows :matricula
      [(str "matricula = '"matricula"' AND sigla= '"sigla"'")]
    )))
   
