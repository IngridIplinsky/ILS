(ns ils.models.dominio.BD.busca
    (:use ils.models.dominio.BD.persistence)
    (:require [clojure.java.jdbc :as sql]))
    
;Uma funcao auxiliar de descompressão de CLOBS, usada nas buscas...
(defn clob-to-string [clob]
"Executa a descompressão de um CLOB."
  (with-open [rdr (java.io.BufferedReader. (.getCharacterStream clob))]
    (apply str (line-seq rdr))))


(defn buscar-exercicio
  ([id]
  "Busca o xml de um exercicio atraves do id deste."
 (sql/with-connection ILS-DB
  (sql/transaction
   (sql/with-query-results res
        [(str "SELECT exercicio.xmlexercicio FROM exercicio WHERE exercicio.idEx = '"id"'")]
           (clob-to-string (:xmlexercicio (first res))) ))))
  ([retorno coluna valor]
"Busca outros campos da tabela exercicio, através da coluna e valor contido nela."
(sql/with-connection ILS-DB
  (sql/with-query-results res
     [(str "SELECT exercicio."retorno" FROM exercicio WHERE exercicio."coluna" = '"valor"'")]
     (doall res))))
   ([retorno coluna1 valor1 coluna2 valor2]
"Busca outros campos da tabela exercicio, através da coluna e valor contido nela."
(sql/with-connection ILS-DB
  (sql/with-query-results res
     [(str "SELECT exercicio."retorno" FROM exercicio WHERE exercicio."coluna1" = '"valor1"' AND exercicio."coluna2" = '"valor2"'")]
     (doall res)))))
               
(defn buscar-apresentacao
 ([id]
  "Busca o xml de uma apresentacao atraves do id desta."
 (sql/with-connection ILS-DB
  (sql/transaction
   (sql/with-query-results res
        [(str "SELECT apresentacao.xmlapresentacao FROM apresentacao WHERE apresentacao.idAp = '"id"'")]
           (clob-to-string (:xmlapresentacao (first res))) ))))
  ([retorno coluna valor]
"Busca outros campos da tabela apresentacao, através da coluna e valor contido nela."
(sql/with-connection ILS-DB
   (sql/with-query-results res
       [(str "SELECT apresentacao."retorno" FROM apresentacao WHERE apresentacao."coluna" = '"valor"'")]
       (doall res))))
  ([retorno selecao organizacao utilizacao]
    "Indica apresentacoes de determinado estilo."
    (sql/with-connection ILS-DB
    (sql/transaction
   (sql/with-query-results res
        [(str "SELECT apresentacao."retorno"
FROM apresentacao, estilo
WHERE estilo.idEst = apresentacao.idEst AND
estilo.selecao = '"selecao"' AND estilo.organizacao = '"organizacao"' AND estilo.utilizacao = '"utilizacao"'
")]
           (doall res))))))
     
(defn buscar-catalogoBug
 ([id]
  "Busca o xml do erro de um estudante atraves do id deste."
  (sql/with-connection ILS-DB
    (sql/transaction ;precisa ser dentro de uma transação para funcionar.
      (sql/with-query-results rs
        [(str "SELECT catalogoBug.xmlbug FROM catalogoBug WHERE catalogoBug.idBug = '"id"'")]
        (clob-to-string (:xmlbug (first rs))) ))))
  ([retorno coluna valor]
"Busca outros campos da tabela catalogoBug, através da coluna e valor contido nela."
(sql/with-connection ILS-DB
   (sql/with-query-results res
        [(str "SELECT catalogoBug."retorno" FROM catalogoBug WHERE catalogoBug."coluna" = '"valor"'")]
        (doall res))))
   ([retorno coluna1 valor1 coluna2 valor2]
"Busca outros campos da tabela catalogoBug, através da coluna e valor contido nela."
(sql/with-connection ILS-DB
   (sql/with-query-results res
        [(str "SELECT catalogoBug."retorno" FROM catalogoBug WHERE catalogoBug."coluna1" = '"valor1"'
AND catalogoBug."coluna2" = '"valor2"'")]
        (doall res)))))
                
(defn buscar-disciplina
  ([id]
  "Busca o xml da hierarquia de uma disciplina atraves da sigla desta."
  (sql/with-connection ILS-DB
    (sql/transaction ;precisa ser dentro de uma transação para funcionar.
      (sql/with-query-results rs
        [(str "SELECT disciplina.xmlhierarquia FROM disciplina WHERE disciplina.sigla = '"id"'")]
        (clob-to-string (:xmlhierarquia (first rs))) ))))
  ([retorno coluna valor]
"Busca campos da tabela disciplina, através de uma coluna e valor contido nela."
(sql/with-connection ILS-DB
   (sql/with-query-results res
        [(str "SELECT disciplina."retorno" FROM disciplina WHERE disciplina."coluna" = '"valor"'")]
          (doall res)))))
        
(defn buscar-professor [retorno coluna valor]
"Busca campos da tabela professor, através de uma coluna e valor contido nela."
(sql/with-connection ILS-DB
   (sql/with-query-results res
        [(str "SELECT professor."retorno" FROM professor WHERE professor."coluna" = '"valor"'")]
          (doall res))))
          
(defn buscar-aluno [retorno coluna valor]
"Busca campos da tabela aluno, através de uma coluna e valor contido nela."
(sql/with-connection ILS-DB
   (sql/with-query-results res
        [(str "SELECT aluno."retorno" FROM aluno WHERE aluno."coluna" = '"valor"'")]
          (doall res))))
          
(defn buscar-conteudo
   ([retorno coluna valor]
"Busca campos da tabela conteudo, através de uma coluna e valor contido nela."
(sql/with-connection ILS-DB
   (sql/with-query-results res
        [(str "SELECT conteudo."retorno" FROM conteudo WHERE conteudo."coluna" = '"valor"'")]
          (doall res))))
    ([retorno coluna1 valor1 coluna2 valor2]
"Busca campos da tabela conteudo, através de uma coluna e valor contido nela."
(sql/with-connection ILS-DB
   (sql/with-query-results res
        [(str "SELECT conteudo."retorno" FROM conteudo WHERE conteudo."coluna1" = '"valor1"' AND
conteudo."coluna2" = '"valor2"'")]
          (doall res)))))
          
(defn buscar-ministra [retorno coluna valor]
"Busca campos da tabela ministra, através de uma coluna e valor contido nela."
(sql/with-connection ILS-DB
   (sql/with-query-results res
        [(str "SELECT ministra."retorno" FROM ministra WHERE ministra."coluna" = '"valor"'")]
          (doall res))))
          
          
(defn buscar-estiloEstudante [retorno coluna valor]
"Busca campos da tabela estiloEstudante, através de uma coluna e valor contido nela."
(sql/with-connection ILS-DB
   (sql/with-query-results res
        [(str "SELECT estiloEstudante."retorno" FROM estiloEstudante WHERE estiloEstudante."coluna" = '"valor"'")]
          (doall res))))
          
(defn buscar-exercicioAluno
  ([retorno coluna valor]
"Busca campos da tabela exercicioAluno, através de uma coluna e valor contido nela."
(sql/with-connection ILS-DB
   (sql/with-query-results res
        (if-not (string? valor) [(str "SELECT exercicioAluno."retorno" FROM exercicioAluno WHERE exercicioAluno."coluna" = "valor)]
         [(str "SELECT exercicioAluno."retorno" FROM exercicioAluno WHERE exercicioAluno."coluna" = '"valor"'")])
          (doall res))))
   ([retorno col1 valor1 col2 valor2]
    "Útil para saber exercicios errados, certos. Mais uma coluna e mais um valor na condicao."
     (sql/with-connection ILS-DB
   (sql/with-query-results res
        (cond
           (and (string? valor1) (string? valor2)) [(str "SELECT exercicioAluno."retorno" FROM exercicioAluno WHERE exercicioAluno."col1" = '"valor1"' AND exercicioAluno."col2" = '"valor2"'")]
           (and (not (string? valor1)) (string? valor2)) [(str "SELECT exercicioAluno."retorno" FROM exercicioAluno WHERE exercicioAluno."col1" = "valor1" AND exercicioAluno."col2" = '"valor2"'")]
           (and (string? valor1) (not (string? valor2))) [(str "SELECT exercicioAluno."retorno" FROM exercicioAluno WHERE exercicioAluno."col1" = '"valor1"' AND exercicioAluno."col2" = "valor2)]
           :else [(str "SELECT exercicioAluno."retorno" FROM exercicioAluno WHERE exercicioAluno."col1" = "valor1" AND exercicioAluno."col2" = "valor2)])
          (doall res)))))
          
(defn buscar-conteudoAluno
  ([retorno coluna valor]
"Busca campos da tabela conteudoAluno, através de uma coluna e valor contido nela."
(sql/with-connection ILS-DB
   (sql/with-query-results res
        (if-not (string? valor) [(str "SELECT conteudoAluno."retorno" FROM conteudoAluno WHERE conteudoAluno."coluna" = "valor)]
         [(str "SELECT conteudoAluno."retorno" FROM conteudoAluno WHERE conteudoAluno."coluna" = '"valor"'")])
          (doall res))))
   ([retorno col1 valor1 col2 valor2]
    "Útil para saber exercicios errados, certos."
     (sql/with-connection ILS-DB
   (sql/with-query-results res
        (cond
           (and (string? valor1) (string? valor2)) [(str "SELECT conteudoAluno."retorno" FROM conteudoAluno WHERE conteudoAluno."col1" = '"valor1"' AND conteudoAluno."col2" = '"valor2"'")]
           (and (not (string? valor1)) (string? valor2)) [(str "SELECT conteudoAluno."retorno" FROM conteudoAluno WHERE conteudoAluno."col1" = "valor1" AND conteudoAluno."col2" = '"valor2"'")]
           (and (string? valor1) (not (string? valor2))) [(str "SELECT conteudoAluno."retorno" FROM conteudoAluno WHERE conteudoAluno."col1" = '"valor1"' AND conteudoAluno."col2" = "valor2)]
           :else [(str "SELECT conteudoAluno."retorno" FROM conteudoAluno WHERE conteudoAluno."col1" = "valor1" AND conteudoAluno."col2" = "valor2)])
          (doall res)))))
  
(defn buscar-estilo
 ([retorno coluna valor]
  "Busca campos da tabela estilo, através de uma coluna e valor contidos nela."
  (sql/with-connection ILS-DB
   (sql/with-query-results res
    [(str "SELECT estilo."retorno" FROM estilo WHERE estilo."coluna" = '"valor"'")]
      (doall res))))
 ([retorno selecao organizacao utilizacao]
  "Busca campos da tabela estilo, através de uma coluna e valor contidos nela."
  (sql/with-connection ILS-DB
   (sql/with-query-results res
    [(str "SELECT estilo."retorno" FROM estilo WHERE estilo.selecao = '"selecao"' AND
estilo.organizacao = '"organizacao"' AND estilo.utilizacao = '"utilizacao"'")]
      (doall res)))))
  
(defn buscar-logAluno
 ([matricula]
  "Busca os campos 'sigla', 'conteúdo' e 'idEx' da tabela logAluno através do número de matrícula do estudante."
  (sql/with-connection ILS-DB
   (sql/with-query-results res
    [(str "SELECT logAluno.sigla, logAluno.idCont, logAluno.idEx FROM logAluno WHERE logAluno.matricula = '"matricula"'")]
      (doall res))))
 ([retorno coluna valor]
  "Busca campos na tabela logAluno através de uma coluna e valor contidos nela."
  (sql/with-connection ILS-DB
   (sql/with-query-results res
    [(str "SELECT "retorno" FROM logAluno WHERE logAluno."coluna" = '"valor"'")]
      (doall res)))))
 
(defn buscar-todos-ex [id]
(sql/with-connection ILS-DB
 (sql/transaction
  (sql/with-query-results res
    [(str "SELECT exercicio.xmlexercicio FROM exercicio WHERE exercicio.idEx = '"id"'")]
       (clob-to-string (:xmlexercicio (first res))) ))))
       
 



