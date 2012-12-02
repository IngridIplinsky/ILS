(ns ils.models.dominio.BD.restore
  (:use [ils.models.dominio.BD.persistence]
        [ils.models.dominio.BD.insercao]
        [ils.models.dominio.xml.geracao]))

;Fins administrativos. Esta função destroi o banco, recria e o preenche. 
;Portanto, é bem custosa, então não a use a menos que saiba o que está fazendo!


(defn reload-banco []
 "Uma funcao para restaurar o banco de dados, e fazer eventuais alterações que envolvam todos os arquivos .xml"
   
    ;ATENÇÃO: os conteudoAluno e exercicioAluno, que medem seu desempenho, devem ser inseridos
	;à medida que o aluno realizar algum exercicio, e não todos os desempenhos, como era feito antes.
	;Muitos dos dados abaixo foram inseridos apenas para testes dentro do domínio, e poderão ser retirados 
	;do banco (assim como desta função) posteriormente.
    
    (println "Destruindo o banco...")
    
 	(destroi-tabelas)
 	
 	(println "Recriando as tabelas...")
 	
 	(criar-tabela-disciplina)
 	(criar-tabela-conteudo)
 	(criar-tabela-aluno)
 	(criar-tabela-estilo)
 	(criar-tabela-apresentacao)
 	(criar-tabela-exercicio)
 	(criar-tabela-professor)
 	(criar-tabela-ministra)
 	(criar-tabela-conteudoAluno)
 	(criar-tabela-exercicioAluno)
 	(criar-tabela-estiloEstudante)
 	(criar-tabela-catalogoBug) 	
 	
 	(println "Inserindo o curso de Estruras de Dados no ILS. Por favor, aguarde...")
 	
 	(inserir-aluno "98713" "Eduardo" "Gonçalves Costa" "Ciência da Computação" "dudugoncalvescosta@hotmail.com"
 	               "eduardo" "123")
 	
 	(inserir-disciplina "src/dominio/Cursos/EstruturasDados/inf41.xml")
 	(inserir-conteudo "INF41" "vetor") ;estudando uma maneira de fazer isso mais automatizado...
 	(inserir-conteudo "INF41" "pilha")
 	(inserir-conteudo "INF41" "metPesq")
 	(inserir-conteudo "INF41" "metOrd")
 	(inserir-conteudo "INF41" "fila")
 	(inserir-conteudo "INF41" "lista")
 	(inserir-conteudo "INF41" "arvore")
 	(inserir-conteudo "INF41" "alocDin")
 	(inserir-conteudo "INF41" "recursiv")
 	
 	(inserir-professor "100200" "Alexsandro" "Santos Soares" "Doutor" "prof.asoares@gmail.com"
 	               "alexsandro" "123")
 	 
 	(inserir-ministra "INF41" "100200")
 	
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/vetor/exercicios/v001.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/vetor/exercicios/v002.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/vetor/exercicios/v003.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/vetor/exercicios/v004.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/vetor/exercicios/v005.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/vetor/exercicios/v006.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/vetor/exercicios/v007.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/vetor/exercicios/v008.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/vetor/exercicios/v009.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/vetor/exercicios/v010.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/vetor/exercicios/v011.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/vetor/exercicios/v012.xml")
	
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/recursiv/exercicios/r001.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/recursiv/exercicios/r002.xml")
	
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l001.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l002.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l003.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l004.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l005.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l006.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l007.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l008.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l009.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l010.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l011.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l012.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l013.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/lista/exercicios/l014.xml")
	
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/fila/exercicios/f001.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/fila/exercicios/f002.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/fila/exercicios/f003.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/fila/exercicios/f004.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/fila/exercicios/f005.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/fila/exercicios/f006.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/fila/exercicios/f007.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/fila/exercicios/f008.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/fila/exercicios/f009.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/fila/exercicios/f010.xml")
	
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad001.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad002.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad003.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad004.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad005.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad006.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad007.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad008.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad009.xml")
	(inserir-exercicio "src/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad010.xml")
	
	(inserir-estilo "est01" "visual" "global" "teorico")
	
	(inserir-apresentacao "src/dominio/Cursos/EstruturasDados/vetor/apresentacao/v001.xml")
	(inserir-apresentacao "src/dominio/Cursos/EstruturasDados/vetor/apresentacao/v002.xml")
	
	(inserir-estiloEstudante "98713" "INF41" "visual" "global" "teorico")
	
	(inserir-conteudoAluno "98713" "vetor" 0.33 0.33 0.34)
	(inserir-conteudoAluno "98713" "fila" 0.33 0.33 0.34)
	
	(inserir-exercicioAluno "98713" "vetor" "v001" 0.33 0.33 0.34)
	(inserir-exercicioAluno "98713" "fila" "f001" 0.33 0.33 0.34)
	
	(println "Gerando alguns logs de erro e inserindo no banco (apenas teste)...")
	
	(gerar-bug "src/dominio/Cursos/EstruturasDados/vetor/erros/98713v001.xml"
	           "e001" "98713" "vetor" "v001" "me" "c" "d") 
	           
	(gerar-bug "src/dominio/Cursos/EstruturasDados/fila/erros/98713f001.xml"
	           "e002" "98713" "fila" "v001" "me" "a" "b") 
	           
	(println "Criando nova disciplina: GSI002 - Introducao à prog. de Computadores...") 
	
	(inserir-disciplina "src/dominio/Cursos/IntroducaoProgramacao/GSI002.xml")	
    
    (inserir-conteudo "GSI002" "introducao")

    (println "Novo conteudo para GSI002! introducao.") 
    (println "Aulas do professor André Backes sendo inseridas. Por favor, aguarde...") 
    
    (inserir-apresentacao "src/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes01.xml")
	(inserir-apresentacao "src/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes02.xml")
	(inserir-apresentacao "src/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes03.xml")
	(inserir-apresentacao "src/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes04.xml")
	(inserir-apresentacao "src/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes05.xml")
	(inserir-apresentacao "src/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes06.xml")
	(inserir-apresentacao "src/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes07.xml")
	(inserir-apresentacao "src/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes08.xml")
	(inserir-apresentacao "src/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes09.xml")
	(inserir-apresentacao "src/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes10.xml")
	(inserir-apresentacao "src/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes11.xml")
    (inserir-apresentacao "src/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes12.xml")
	
	(println "Restauração do banco concluída.")
  )  
