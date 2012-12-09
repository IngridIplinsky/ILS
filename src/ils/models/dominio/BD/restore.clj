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
 	
 ;	(println "Inserindo o curso de Estruras de Dados no ILS. Por favor, aguarde...")
 	
 	(inserir-aluno "98713" "Eduardo" "Gonçalves Costa" "Ciência da Computação" "dudugoncalvescosta@hotmail.com"
 	               "eduardo" "123")
 	               
 	(println "Criando nova disciplina: GSI002 - Introducao à prog. de Computadores...") 
	
	(inserir-disciplina "src/dominio/Cursos/IntroducaoProgramacao/GSI002.xml")	
    
    (inserir-conteudo "cont001" "GSI002" "introducao")
    (inserir-conteudo "cont002" "GSI002" "estruturasCond")
    (inserir-conteudo "cont003" "GSI002" "laco")
    (inserir-conteudo "cont004" "GSI002" "vetor")
    (inserir-conteudo "cont005" "GSI002" "struct")
    (inserir-conteudo "cont006" "GSI002" "funcao")
    (inserir-conteudo "cont007" "GSI002" "recursao")
    (inserir-conteudo "cont008" "GSI002" "alocDin")
    (inserir-conteudo "cont009" "GSI002" "string")
    (inserir-conteudo "cont010" "GSI002" "estruturasRepet")
    
 	(println "Criando nova disciplina: INF41 - Estruturas de Dados...")
 	
    (inserir-disciplina "src/dominio/Cursos/EstruturasDados/inf41.xml")
 	(inserir-conteudo "cont011" "INF41" "vetor") ;estudando uma maneira de fazer isso mais automatizado...
 	(inserir-conteudo "cont012" "INF41" "pilha")
 	(inserir-conteudo "cont013" "INF41" "metPesq")
 	(inserir-conteudo "cont014" "INF41" "metOrd")
 	(inserir-conteudo "cont015" "INF41" "fila")
 	(inserir-conteudo "cont016" "INF41" "lista")
 	(inserir-conteudo "cont017" "INF41" "arvore")
 	(inserir-conteudo "cont018" "INF41" "alocDin")
 	(inserir-conteudo "cont019" "INF41" "recursiv")
 	
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad001.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad002.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad003.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad004.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad005.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad006.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad007.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad008.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad009.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/alocDin/exercicios/ad010.xml")
	
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/vetor/exercicios/v001.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/vetor/exercicios/v002.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/vetor/exercicios/v003.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/vetor/exercicios/v004.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/vetor/exercicios/v005.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/vetor/exercicios/v006.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/vetor/exercicios/v007.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/vetor/exercicios/v008.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/vetor/exercicios/v009.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/vetor/exercicios/v010.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/vetor/exercicios/v011.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/vetor/exercicios/v012.xml")
	
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l001.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l002.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l003.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l004.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l005.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l006.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l007.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l008.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l009.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l010.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l011.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l012.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l013.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/lista/exercicios/l014.xml")
	
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/fila/exercicios/f001.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/fila/exercicios/f002.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/fila/exercicios/f003.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/fila/exercicios/f004.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/fila/exercicios/f005.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/fila/exercicios/f006.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/fila/exercicios/f007.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/fila/exercicios/f008.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/fila/exercicios/f009.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/EstruturasDados/fila/exercicios/f010.xml")
	
	(inserir-estilo "est01" "visual" "global" "teorico")
	
	(inserir-apresentacao "src/ils/models/dominio/Cursos/EstruturasDados/vetor/apresentacao/v001.xml")
	(inserir-apresentacao "src/ils/models/dominio/Cursos/EstruturasDados/vetor/apresentacao/v002.xml")
	
	(inserir-estiloEstudante "98713" "GSI002" "visual" "global" "teorico")
	
	(inserir-conteudoAluno "98713" "cont002" 0.33 0.33 0.34)
	(inserir-conteudoAluno "98713" "cont003" 0.33 0.33 0.34)
	
	;(inserir-exercicioAluno "98713" "vetor" "v001" 0.33 0.33 0.34)
	;(inserir-exercicioAluno "98713" "fila" "f001" 0.33 0.33 0.34)
	
	;(println "Gerando alguns logs de erro e inserindo no banco (apenas teste)...")
	
	;(gerar-bug "src/dominio/Cursos/EstruturasDados/vetor/erros/98713v001.xml"
	 ;          "e001" "98713" "vetor" "v001" "me" "c" "d") 
	           
	;(gerar-bug "src/dominio/Cursos/EstruturasDados/fila/erros/98713f001.xml"
	 ;          "e002" "98713" "fila" "v001" "me" "a" "b") 
	           
	
    (inserir-professor "100200" "Alexsandro" "Santos Soares" "Doutor" "prof.asoares@gmail.com"
 	               "alexsandro" "123")
 	 
 	(inserir-ministra "GSI002" "100200") 
 
    (println "Aulas do professor André Backes sendo geradas e inseridas. Por favor, aguarde...") 
    
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes001.xml" "backes001" "GSI002" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/GiCt0Cwcp-U&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Esqueleto de um programa em C - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes002.xml" "backes002" "GSI002" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/q51cHsgRHU4&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Declaração de variáveis - Créditos a André Backes")
                        
     (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes003.xml" "backes003" "GSI002" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/07YPObbEpU8&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Printf - Créditos a André Backes")
                        
     (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes004.xml" "backes004" "GSI002" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/yQx8sD6vK6M&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Printf - Créditos a André Backes")
    
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes010.xml" "backes010" "GSI002" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/x0uEgxYtW-E&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Atribuição - Créditos a André Backes")
                        
     (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes011.xml" "backes011" "GSI002" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/kaivxmdkyTg&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Operadores relacionais - Créditos a André Backes")
                        
     (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes012.xml" "backes012" "GSI002" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/TlIEIMmutQo&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Operadores lógicos - Créditos a André Backes")
     
     (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasCond/apresentacao/backes013.xml" "backes013" "GSI002"  
                         "estruturasCond" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/84mgFRR_ODo&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando if - Créditos a André Backes")
 
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasCond/apresentacao/backes014.xml" "backes014" "GSI002"
                          "estruturasCond" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/YR-ku4OdPJU&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "else - Créditos a André Backes")
                        
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasCond/apresentacao/backes015.xml" "backes015" "GSI002" 
      					"estruturasCond" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/JBFgiNJevqc&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Aninhamento if-else - Créditos a André Backes")
	
	  (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasCond/apresentacao/backes016.xml" "backes016" "GSI002" 							"estruturasCond" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/lWUZWF1Ifbw&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Operador ternário (?) - Créditos a André Backes")
                        
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasCond/apresentacao/backes017.xml" "backes017" "GSI002"
      					"estruturasCond""video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/z395-PmpzlI&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando switch - Créditos a André Backes")
                        
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes018.xml" "backes018"                 
                         "GSI002" "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/3pftIJjsk30&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando while - Créditos a André Backes")
                        
      
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes019.xml" "backes019"                 
                         "GSI002" "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/tlagnwiiIqE&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando for - Créditos a André Backes")
	
	(gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes020.xml" "backes020"                 
                         "GSI002" "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/VH6AycSgjN0&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando do-while - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes021.xml" "backes021"                 
                         "GSI002" "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/LXg3HtMbP8E&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Aninhamentos de repetições - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes022.xml" "backes022"                 
                         "GSI002" "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/QKzIyC5wBxU&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando break - Créditos a André Backes")
                       
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes023.xml" "backes023"                 
                         "GSI002" "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/LK8DbKnImQI&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando continue - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes024.xml" "backes024"                 
                         "GSI002" "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/eTwXo5i-Ygc&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando goto - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/apresentacao/backes025.xml" "backes025"              
                        "GSI002" "vetor" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/CtM7o2rsTic&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Array/vetores - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/apresentacao/backes026.xml" "backes026"              
                        "GSI002" "vetor" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/3TP0e-bfdfw&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Array/vetores - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/apresentacao/backes027.xml" "backes027"              
                        "GSI002" "vetor" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/7YdzpGWTiSM&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Array multidimensional - Créditos a André Backes")
     
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/apresentacao/backes028.xml" "backes028"              
                        "GSI002" "vetor" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/sTYLxyPszWQ&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Inicialização de arrays - Créditos a André Backes")
	
	(gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/apresentacao/backes029.xml" "backes029"              
                        "GSI002" "vetor" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/daq2R-sWy50&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Somando um array - Créditos a André Backes")
                        
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/apresentacao/backes030.xml" "backes030"              
                        "GSI002" "vetor" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/K7cfWrm21hg&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Maior valor de um array - Créditos a André Backes")
    
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/string/apresentacao/backes031.xml" "backes031"              
                        "GSI002" "string" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/5mJZh_ikDaQ&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "String pt1 - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/string/apresentacao/backes032.xml" "backes032"              
                        "GSI002" "string" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/MEkrf1O_CIU&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "String pt2 - Créditos a André Backes")   
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/string/apresentacao/backes033.xml" "backes033"              
                        "GSI002" "string" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/jNQUEpwMd_M&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "String pt3 - Créditos a André Backes")   
                        
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/string/apresentacao/backes034.xml" "backes034"              
                        "GSI002" "string" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/s_V_LZX1eD0&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "String pt4 - Créditos a André Backes")                       
    
	(gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes035.xml" "backes035"              
                        "GSI002" "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/MatsUCe5uZw&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Struct parte 1 - Créditos a André Backes")  
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes036.xml" "backes036"              
                        "GSI002" "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/CAnQ6i8OwJA&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Trabalhando com structs - Créditos a André Backes")  
	
	
	(gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes037.xml" "backes037"              
                        "GSI002" "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/tbvo4QFyzqQ&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Arrays de structs - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes038.xml" "backes038"              
                        "GSI002" "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/34_5n_NkDYU&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Aninhamento de structs - Créditos a André Backes")
	
	(gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes039.xml" "backes039"              
                        "GSI002" "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/iiyjeAPeHN8&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Union parte 1 - Créditos a André Backes")
	
	(gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes040.xml" "backes040"              
                        "GSI002" "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/PvSTq2XHYbs&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Union parte 2 - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes041.xml" "backes041"              
                        "GSI002" "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/53onugS0M0A&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Enum - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes042.xml" "backes042"              
                        "GSI002" "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/JmarMwaT_KQ&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Typedef - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes043.xml" "backes043"              
                        "GSI002" "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/OrF2ydZIELk&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Introdução a funções - Créditos a André Backes")                       
                        
     (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes044.xml" "backes044"              
                        "GSI002" "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/5BBD_IfFUtk&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Parâmetros da função - Créditos a André Backes")
                        
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes045.xml" "backes045"              
                        "GSI002" "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/al6Uq0nnuUE&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Corpo de uma função - Créditos a André Backes")
                        
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes046.xml" "backes046"              
                        "GSI002" "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/E3zGQKc0BX4&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Retorno de uma função - Créditos a André Backes")
                        
       (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes047.xml" "backes047"              
                        "GSI002" "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/4Astcs8IW3s&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Passagem por referência - Créditos a André Backes")
                        
       (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes048.xml" "backes048"              
                        "GSI002" "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/E-r4WkkwbVI&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Passagem por valor - Créditos a André Backes")
                        
       (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes049.xml" "backes049"              
                        "GSI002" "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/SAhR1h3LpDY&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Array cmomo parâmetro - Créditos a André Backes")
                        
        (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes050.xml" "backes050"              
                        "GSI002" "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/QuSHZ2IOYB4&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Struct como parâmetro - Créditos a André Backes")
        
    (println "Inserindo exercicios da disciplina...")                
                        
 	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/exercicios/a001.xml")
 	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/exercicios/a002.xml")
 	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/exercicios/a003.xml")
 	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/exercicios/a004.xml")
 	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/exercicios/a005.xml")
 	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/exercicios/a006.xml")
 	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/exercicios/a007.xml")
 	
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/exercicios/v001.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/exercicios/v002.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/exercicios/v003.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/exercicios/v004.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/exercicios/v005.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/exercicios/v006.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/exercicios/v007.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/exercicios/v008.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/exercicios/v009.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/exercicios/v010.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/exercicios/v011.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/exercicios/v012.xml")
	
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/recursao/exercicios/r001.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/recursao/exercicios/r002.xml")
	
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/alocDin/exercicios/ad001.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/alocDin/exercicios/ad002.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/alocDin/exercicios/ad003.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/alocDin/exercicios/ad004.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/alocDin/exercicios/ad005.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/alocDin/exercicios/ad006.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/alocDin/exercicios/ad007.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/alocDin/exercicios/ad008.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/alocDin/exercicios/ad009.xml")
	(inserir-exercicio "src/ils/models/dominio/Cursos/IntroducaoProgramacao/alocDin/exercicios/ad010.xml")
	
	(println "Restauração do banco concluída.")
  )  
