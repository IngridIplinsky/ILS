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
    
 	;(destroi-tabelas)
 	
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
 	               "eduardo" "123" "Introdução a Programação")
 	               
 	(println "Criando nova disciplina: GSI002 - Introducao à prog. de Computadores...") 
        
	
	(inserir-disciplina "src/ils/models/dominio/Cursos/IntroducaoProgramacao/GSI002.xml")	
    
    (inserir-conteudo "GSI002" "introducao")
    (inserir-conteudo "GSI002" "estruturasCond")
    (inserir-conteudo "GSI002" "laco")
    (inserir-conteudo "GSI002" "vetor")
    (inserir-conteudo "GSI002" "struct")
    (inserir-conteudo "GSI002" "funcao")
    (inserir-conteudo "GSI002" "recursao")
    (inserir-conteudo "GSI002" "alocDin")
    
 	
   ; (inserir-disciplina "src/ils/models/dominio/Cursos/EstruturasDados/inf41.xml")
 	;(inserir-conteudo "INF41" "vetor") ;estudando uma maneira de fazer isso mais automatizado...
 	;(inserir-conteudo "INF41" "pilha")
 ;	(inserir-conteudo "INF41" "metPesq")
 ;	(inserir-conteudo "INF41" "metOrd")
 ;	(inserir-conteudo "INF41" "fila")
 ;	(inserir-conteudo "INF41" "lista")
 ;	(inserir-conteudo "INF41" "arvore")
 ;	(inserir-conteudo "INF41" "alocDin")
 ;	(inserir-conteudo "INF41" "recursiv")
 	

	
	(inserir-estilo "est01" "visual" "global" "teorico")
	
	;(inserir-apresentacao "src/ils/models/dominio/Cursos/EstruturasDados/vetor/apresentacao/v001.xml")
	;(inserir-apresentacao "src/ils/models/dominio/Cursos/EstruturasDados/vetor/apresentacao/v002.xml")
	
	(inserir-estiloEstudante "98713" "GSI002" "visual" "global" "teorico")
	
	;(inserir-conteudoAluno "98713" "vetor" 0.33 0.33 0.34)
	;(inserir-conteudoAluno "98713" "fila" 0.33 0.33 0.34)
	
	;(inserir-exercicioAluno "98713" "vetor" "v001" 0.33 0.33 0.34)
	;(inserir-exercicioAluno "98713" "fila" "f001" 0.33 0.33 0.34)
	
	;(println "Gerando alguns logs de erro e inserindo no banco (apenas teste)...")
	
	;(gerar-bug "src/ils/models/dominio/Cursos/EstruturasDados/vetor/erros/98713v001.xml"
	 ;          "e001" "98713" "vetor" "v001" "me" "c" "d") 
	           
	;(gerar-bug "src/ils/models/dominio/Cursos/EstruturasDados/fila/erros/98713f001.xml"
	 ;          "e002" "98713" "fila" "v001" "me" "a" "b") 
	           
	
    (inserir-professor "100200" "Alexsandro" "Santos Soares" "Doutor" "prof.asoares@gmail.com"
 	               "alexsandro" "123")
 	 
 	(inserir-ministra "GSI002" "100200")
 
    (println "Aulas do professor André Backes sendo geradas e inseridas. Por favor, aguarde...") 
    
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes001.xml" "backes001" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/GiCt0Cwcp-U&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Esqueleto de um programa em C - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes002.xml" "backes002" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/q51cHsgRHU4&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Declaração de variáveis - Créditos a André Backes")
                        
     (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes003.xml" "backes003" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/07YPObbEpU8&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Printf - Créditos a André Backes")
                        
     (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes004.xml" "backes004" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/yQx8sD6vK6M&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Printf - Créditos a André Backes")
    
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes010.xml" "backes010" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/x0uEgxYtW-E&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Atribuição - Créditos a André Backes")
                        
     (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes011.xml" "backes011" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/kaivxmdkyTg&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Operadores relacionais - Créditos a André Backes")
                        
     (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/introducao/apresentacao/backes012.xml" "backes012" "introducao"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/TlIEIMmutQo&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Operadores lógicos - Créditos a André Backes")
     
     (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasCond/apresentacao/backes013.xml" "backes013" "estruturasCond"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/84mgFRR_ODo&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando if - Créditos a André Backes")
 
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasCond/apresentacao/backes014.xml" "backes014" "estruturasCond"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/YR-ku4OdPJU&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "else - Créditos a André Backes")
                        
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasCond/apresentacao/backes015.xml" "backes015" "estruturasCond"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/JBFgiNJevqc&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Aninhamento if-else - Créditos a André Backes")
	
	  (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasCond/apresentacao/backes016.xml" "backes016" "estruturasCond"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/lWUZWF1Ifbw&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Operador ternário (?) - Créditos a André Backes")
                        
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasCond/apresentacao/backes017.xml" "backes017" "estruturasCond"
                        "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/z395-PmpzlI&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando switch - Créditos a André Backes")
                        
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes018.xml" "backes018"                 
                          "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/3pftIJjsk30&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando while - Créditos a André Backes")
                        
      
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes019.xml" "backes019"                 
                          "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/tlagnwiiIqE&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando for - Créditos a André Backes")
	
	(gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes020.xml" "backes020"                 
                          "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/VH6AycSgjN0&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando do-while - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes021.xml" "backes021"                 
                          "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/LXg3HtMbP8E&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Aninhamentos de repetições - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes022.xml" "backes022"                 
                          "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/QKzIyC5wBxU&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando break - Créditos a André Backes")
                       
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes023.xml" "backes023"                 
                          "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/LK8DbKnImQI&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando continue - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/estruturasRepet/apresentacao/backes024.xml" "backes024"                 
                          "estruturasRepet" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/eTwXo5i-Ygc&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Comando goto - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/apresentacao/backes025.xml" "backes025"              
                        "vetor" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/CtM7o2rsTic&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Array/vetores - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/apresentacao/backes026.xml" "backes026"              
                        "vetor" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/3TP0e-bfdfw&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Array/vetores - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/apresentacao/backes027.xml" "backes027"              
                        "vetor" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/7YdzpGWTiSM&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Array multidimensional - Créditos a André Backes")
     
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/apresentacao/backes028.xml" "backes028"              
                        "vetor" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/sTYLxyPszWQ&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Inicialização de arrays - Créditos a André Backes")
	
	(gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/apresentacao/backes029.xml" "backes029"              
                        "vetor" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/daq2R-sWy50&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Somando um array - Créditos a André Backes")
                        
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/vetor/apresentacao/backes030.xml" "backes030"              
                        "vetor" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/K7cfWrm21hg&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Maior valor de um array - Créditos a André Backes")
    
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/string/apresentacao/backes031.xml" "backes031"              
                        "string" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/5mJZh_ikDaQ&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "String pt1 - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/string/apresentacao/backes032.xml" "backes032"              
                        "string" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/MEkrf1O_CIU&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "String pt2 - Créditos a André Backes")   
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/string/apresentacao/backes033.xml" "backes033"              
                        "string" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/jNQUEpwMd_M&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "String pt3 - Créditos a André Backes")   
                        
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/string/apresentacao/backes034.xml" "backes034"              
                        "string" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/s_V_LZX1eD0&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "String pt4 - Créditos a André Backes")                       
    
	(gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes035.xml" "backes035"              
                        "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/MatsUCe5uZw&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Struct parte 1 - Créditos a André Backes")  
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes036.xml" "backes036"              
                        "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/CAnQ6i8OwJA&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Trabalhando com structs - Créditos a André Backes")  
	
	
	(gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes037.xml" "backes037"              
                        "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/tbvo4QFyzqQ&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Arrays de structs - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes038.xml" "backes038"              
                        "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/34_5n_NkDYU&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Aninhamento de structs - Créditos a André Backes")
	
	(gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes039.xml" "backes039"              
                        "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/iiyjeAPeHN8&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Union parte 1 - Créditos a André Backes")
	
	(gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes040.xml" "backes040"              
                        "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/PvSTq2XHYbs&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Union parte 2 - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes041.xml" "backes041"              
                        "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/53onugS0M0A&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Enum - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/struct/apresentacao/backes042.xml" "backes042"              
                        "struct" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/JmarMwaT_KQ&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Typedef - Créditos a André Backes")
                        
    (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes043.xml" "backes043"              
                        "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/OrF2ydZIELk&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Introdução a funções - Créditos a André Backes")                       
                        
     (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes044.xml" "backes044"              
                        "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/5BBD_IfFUtk&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Parâmetros da função - Créditos a André Backes")
                        
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes045.xml" "backes045"              
                        "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/al6Uq0nnuUE&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Corpo de uma função - Créditos a André Backes")
                        
      (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes046.xml" "backes046"              
                        "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/E3zGQKc0BX4&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Retorno de uma função - Créditos a André Backes")
                        
       (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes047.xml" "backes047"              
                        "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/4Astcs8IW3s&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Passagem por referência - Créditos a André Backes")
                        
       (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes048.xml" "backes048"              
                        "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/E-r4WkkwbVI&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Passagem por valor - Créditos a André Backes")
                        
       (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes049.xml" "backes049"              
                        "funcao" "video" "visual" "global" "teorico" "embedded"
                        "&lt;iframe width=&quot;560&quot; height=&quot;315&quot; src=&quot;http://www.youtube.com/embed/SAhR1h3LpDY&quot; frameborder=&quot;0&quot; allowfullscreen&gt;&lt;/iframe&gt;"
                        "Array cmomo parâmetro - Créditos a André Backes")
                        
        (gerar-apresentacao "src/ils/models/dominio/Cursos/IntroducaoProgramacao/funcoes/apresentacao/backes050.xml" "backes050"              
                        "funcao" "video" "visual" "global" "teorico" "embedded"
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
