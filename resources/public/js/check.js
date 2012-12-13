


function CorVermelhaAloc()
{
   
  parent.document.getElementById('aloc').style.color = "red";

}


function CorAzulAloc()
{
   
  parent.document.getElementById('aloc').style.color = "red";

}

function CorPretaAloc()
{
   
  parent.document.getElementById('aloc').style.color = "red";

}













function exemplo5(link) {
document.getElementById('pagina').innerHTML=document.getElementById(link).innerHTML;
}

function showNameMethod()
	{
alert(this.nome+" ,"+this.dnascimento);
	}



function verificaLogin()
{
      var a = document.form.usuario.value;
      var b = document.form.senha.value;
     
   
   if (a.length > 0 && b.length > 0) return true;
	
   else {
         alert("Campo(s) em brancos!!!");
        return false;
	} 
}



function verificaRadio()
{
for (var i=0; i < document.form.op.length; i++)
   {
   if (document.form.op[i].checked)
      {
      var rad_val = document.form.op[i].value;
      }
   }

 if(rad_val == undefined){
  alert("Escolha uma opção pra prosseguir!!!"); 
  return false;
}

else {
return true;
}

}



function verificaRadioVetor1()
{
for (var i=0; i < document.vetor1.v1.length; i++)
   {
   if (document.vetor1.v1[i].checked)
      {
      var rad_val = document.vetor1.v1[i].value;
      }
   }

 if(rad_val == undefined){
  alert("Escolha uma opção pra prosseguir!!!"); 
  return false;
}

else {
return true;
}

}

function verificaRadioVetor2()
{
for (var i=0; i < document.vetor2.v2.length; i++)
   {
   if (document.vetor2.v2[i].checked)
      {
      var rad_val = document.vetor2.v2[i].value;
      }
   }

 if(rad_val == undefined){
  alert("Escolha uma opção pra prosseguir!!!"); 
  return false;
}

else {
return true;
}

}


function verificaRadioVetor3()
{
for (var i=0; i < document.vetor3.v3.length; i++)
   {
   if (document.vetor3.v3[i].checked)
      {
      var rad_val = document.vetor3.v3[i].value;
      }
   }

 if(rad_val == undefined){
  alert("Escolha uma opção pra prosseguir!!!"); 
  return false;
}

else {
return true;
}

}


function cadastra()
	{
  var a = document.cad.nome.value;
  var b = document.cad.sobrenome.value;
  var c = document.cad.email.value;
  var d = document.cad.senha.value;
  var e = document.cad.nomeUsuario.value;
    
if(!(a.length == 0 || b.length == 0|| c.length == 0 || d.length == 0 || e.length == 0))
   
   { 
  if ((c.indexOf("@") < 2) || (c.indexOf('.') < 2)){
       alert('Email incorreto');
       return false;
     } 
  
 else { 
   return true;
      }   
	
   }
   
   
   else

   {
     alert("Campos em branco, certifique-se disto");
     document.cad.nome.focus();
     return false;  
   }
   
   		
 
 }

function mudaVideo(){
  /*document.getElementById('fp').src = "http://www.youtube.com/embed/GiCt0Cwcp-U";*/
  alert("hi");
 
}




function mudaVideoIntroducao(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Vídeos de Introdução"; 
}



function testeVazio(){
  parent.document.getElementById('ativ-exerc').innerHTML = ""; 
}



function testeVetor(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste de Vetor"; 
}



function testeFuncao(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste de Função"; 
}

function testeEstCond(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste de Est. Condição"; 
}

function testeEstRep(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste de Est. Repetição"; 
}

function testeArquivo(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste de Arquivo"; 
}



function testeAlocacao(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste Aloc. Dinâmica";
}

function testeStruct(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste de Structs"; 
}


function testeString(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste Strings";
}

function testeIntroducao(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste Introdução";
}


function testeLista(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste Lista";
}

function testeFila(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste Fila";
}

function testePilha(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste Pilha";
}

function testeArvore(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste Árvore";
}

function testeMetOrd(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste Métodos Ordenação";
}

function testeMetPesq(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste Métodos Pesquisa";
}

function testeRecursividade(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste Recursividade";
}


function pegaDivPrincipal()
{  
return parent.document.getElementById('princ_index');  
}  


function alteraPosicionamento()
{
   cam = parent.document.getElementById('menuVetor');
   cam.style.top = '70%';

}


function alteraVisibilidadeAlocacao()
{
 
 cam = parent.document.getElementById('menuAlocacao');
 cam.style.visibility = 'visible';
}

function alteraVisibilidadeVetor()
{
 
 cam = parent.document.getElementById('menuVetor');
 cam.style.visibility = 'visible';
}

function alteraVisibilidadeVetor1()
{
 
 cam = parent.document.getElementById('vet');
 cam.style.visibility = 'visible';
}

function alteraVisibilidadeVetor1Inv()
{
 
 cam = parent.document.getElementById('vet');
 cam.style.visibility = 'hidden';
}


function alteraVisibilidadeVetorInvisivel()
{
 
 cam = parent.document.getElementById('menuVetor');
 cam.style.visibility = 'hidden';
}

function alteraVisibilidadeListaInvisivel()
{
 
 cam = parent.document.getElementById('menuLista1');
 cam.style.visibility = 'hidden';
}

function alteraVisibilidadeFilaInvisivel()
{
 
 cam = parent.document.getElementById('menuFila1');
 cam.style.visibility = 'hidden';
}

function alteraVisibilidadePilhaInvisivel()
{
 
 cam = parent.document.getElementById('menuPilha1');
 cam.style.visibility = 'hidden';
}


function alteraVisibilidadeArvoreInvisivel()
{
 
 cam = parent.document.getElementById('menuArvore1');
 cam.style.visibility = 'hidden';
}

function alteraVisibilidadeMetOrdInvisivel()
{
 
 cam = parent.document.getElementById('menuMetOrd1');
 cam.style.visibility = 'hidden';
}

function alteraVisibilidadeMetPesqInvisivel()
{
 
 cam = parent.document.getElementById('menuMetPesq1');
 cam.style.visibility = 'hidden';
}



function alteraVisibilidadeAlocacaoInvisivel()
{
 
 cam = parent.document.getElementById('i');
 cam.style.visibility = 'hidden';
}


function alteraVisibilidadeLista()
{
 
 cam = parent.document.getElementById('menuLista');
 cam.style.visibility = 'visible';
  

}

function alteraVisibilidadeLista1()
{
 
 cam = parent.document.getElementById('list');
 cam.style.visibility = 'visible';
  

}



function alteraVisibilidadeRecursividade()
{
 
cam = parent.document.getElementById('menuRecursi');
cam.style.visibility = 'visible';
}
  

function alteraVisibilidadeRecursividadeInvisivel()
{
 
cam = parent.document.getElementById('menuResursi');
cam.style.visibility = 'hidden';
}


function alteraVisibilidadeFila()
{
 
cam = parent.document.getElementById('menuFila');
cam.style.visibility = 'visible';
}

function alteraVisibilidadeFila1()
{
 
 cam = parent.document.getElementById('fila');
 cam.style.visibility = 'visible';
  

}



function alteraVisibilidadePilha()
{
 
cam = parent.document.getElementById('menuPilha');
cam.style.visibility = 'visible';
}

function alteraVisibilidadePilha1()
{
 
 cam = parent.document.getElementById('pilha');
 cam.style.visibility = 'visible';
  

}



function alteraVisibilidadeArvore()
{
 
 cam = parent.document.getElementById('menuArvore');
cam.style.visibility = 'visible';
}

function alteraVisibilidadeArvore1()
{
 
 cam = parent.document.getElementById('arvore');
 cam.style.visibility = 'visible';
  

}


function alteraVisibilidadeMetOrd()
{
 
cam = parent.document.getElementById('menuMetOrd');
cam.style.visibility = 'visible';
}

function alteraVisibilidadeMetOrd1()
{
 
 cam = parent.document.getElementById('metOrd');
 cam.style.visibility = 'visible';
  

}


function alteraVisibilidadeMetPesq()
{
 
 cam = parent.document.getElementById('menuMetPesq');
cam.style.visibility = 'visible';
}
 
function alteraVisibilidadeMetPesq1()
{
 
 cam = parent.document.getElementById('metPesq');
cam.style.visibility = 'visible';
}
      




function mudaCorAzulLista()
{
   
  parent.document.getElementById('list').style.color = "cadetblue";

}

function mudaCorPretoLista()
{
   
  parent.document.getElementById('list').style.color = "black";

}


function mudaCorAzulFila()
{
   
  parent.document.getElementById('fila').style.color = "cadetblue";

}


function mudaCorPretoFila()
{
   
  parent.document.getElementById('fila').style.color = "black";

}


function mudaCorAzulPilha()
{
   
  parent.document.getElementById('pilha').style.color = "blue";

}

function mudaCorPretoPilha()
{
   
  parent.document.getElementById('pilha').style.color = "black";

}



function mudaCorAzulArvore()
{
   
  parent.document.getElementById('arvore').style.color = "cadetblue";

}


function mudaCorPretoArvore()
{
   
  parent.document.getElementById('arvore').style.color = "black";

}



function mudaCorAzulMetOrd()
{
   
  parent.document.getElementById('metOrd').style.color = "cadetblue";

}


function mudaCorPretoMetOrd()
{
   
  parent.document.getElementById('metOrd').style.color = "black";

}


function mudaCorAzulMetPesq()
{
   
  parent.document.getElementById('metPesq').style.color = "cadetblue";

}

function mudaCorPretoMetPesq()
{
   
  parent.document.getElementById('metPesq').style.color = "black";

}


function mudaCorNegrito()
{
   
  parent.document.getElementById('vet').style.fontWeight = "bold";

}


function mudaCorPreto()
{
   
  parent.document.getElementById('vet').style.fontWeight = "normal";

}


function mudaCor()
{
   
  parent.document.getElementById('vet').style.color = "cadetblue";

}



/*************** CorVerdeIntrodução ****************************/



function corVerdeIntroducao()
{
   
  parent.document.getElementById('intro').style.color = "green";

}

function corVerdeString()
{
   
  parent.document.getElementById('string').style.color = "green";

}


function corVerdeAlocacao()
{
   
  parent.document.getElementById('aloc').style.color = "green";

}


function corVerdeRecusividade()
{
   
  parent.document.getElementById('recursiv').style.color = "green";

}


function corVerdeVetor()
{
   
  parent.document.getElementById('vetor').style.color = "green";

}


function corVerdeFuncao()
{
   
  parent.document.getElementById('func').style.color = "green";

}



function corVerdeStruct()
{
   
  parent.document.getElementById('struct').style.color = "green";

}

function corVerdeEC()
{
   
  parent.document.getElementById('EC').style.color = "green";

}


function corVerdeER()
{
   
  parent.document.getElementById('ER').style.color = "green";

}

function corVerdeArquivo()
{
   
  parent.document.getElementById('arquivo').style.color = "green";

}

/*************************** CorAzulIntrodução *********************/



function corAzulIntroducao()
{
   
  parent.document.getElementById('intro').style.color = "blue";

}

function corAzulString()
{
   
  parent.document.getElementById('string').style.color = "blue";

}


function corAzulAlocacao()
{
   
  parent.document.getElementById('aloc').style.color = "blue";

}


function corAzulRecusividade()
{
   
  parent.document.getElementById('recursiv').style.color = "blue";

}


function corAzulVetor()
{
   
  parent.document.getElementById('vetor').style.color = "blue";

}


function corAzulFuncao()
{
   
  parent.document.getElementById('func').style.color = "blue";

}



function corAzulStruct()
{
   
  parent.document.getElementById('struct').style.color = "blue";

}

function corAzulEC()
{
   
  parent.document.getElementById('EC').style.color = "blue";

}


function corAzulER()
{
   
  parent.document.getElementById('ER').style.color = "blue";

}

function corAzulArquivo()
{
   
  parent.document.getElementById('arquivo').style.color = "blue";

}



/************************ CorVermelhaIntrodução ***************************/


function corVermelhaIntroducao()
{
   
  parent.document.getElementById('intro').style.color = "red";

}

function corVermelhaString()
{
   
  parent.document.getElementById('string').style.color = "red";

}


function corVermelhaAlocacao()
{
   
  parent.document.getElementById('aloc').style.color = "red";

}


function corVermelhaRecusividade()
{
   
  parent.document.getElementById('recursiv').style.color = "red";

}


function corVermelhaVetor()
{
   
  parent.document.getElementById('vetor').style.color = "red";

}


function corVermelhaFuncao()
{
   
  parent.document.getElementById('func').style.color = "red";

}



function corVermelhaStruct()
{
   
  parent.document.getElementById('struct').style.color = "red";

}

function corVermelhaEC()
{
   
  parent.document.getElementById('EC').style.color = "red";

}


function corVermelhaER()
{
   
  parent.document.getElementById('ER').style.color = "red";

}

function corVermelhaArquivo()
{
   
  parent.document.getElementById('arquivo').style.color = "red";

}




function tam() 
{
document.getElementById("page").height = page.document.getElementById("contLoja").scrollHeight + 40; 
//40: Margem Superior e Inferior, somadas
}

function ResizeWH(){
var w;
var h;

w = document.getElementById("fundoiframe").clientWidth;
h = document.getElementById("fundoiframe").clientHeight;
parent.WHFRAME(w,h);
}

function ResizeWHE(){
var w;
var h;

w = document.getElementById("fundoiframe").clientWidth;
h = document.getElementById("fundoiframe").clientHeight;

parent.WHEFRAME(w,h);
}


function WHFRAME(w,h){
var FrameWH = parent.document.getElementById("iframe");
FrameWH.style.height = h+50+"px";
FrameWH.style.overflow = "hidden";

}

function WHEFRAME(w,h){
var FrameWH = parent.document.getElementById("iframe");
FrameWH.style.height = h-10+"px";
}



function videoScroll(){
var FrameWH = parent.document.getElementById("iframe");
FrameWH.style.overflow = "auto";
return true;

}







 
