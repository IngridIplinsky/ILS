

function teste()
 {
  alert("Olá marcos");
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
  if ((c.indexOf("@") < 2) || (c.indexOf('.') < 7)){
       alert('Email incorreto');
       return false;
     } 
  
 else { 
   alert("Cadastro feito com sucesso, seja bem-vindo!");
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



function testeVetor(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste de Vetor"; 
}

function testeAlocacao(){
  parent.document.getElementById('ativ-exerc').innerHTML = "Teste Alocação Dinâmica";
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


function alteraVisibilidadeVetorInvisivel()
{
 
 cam = parent.document.getElementById('menuVetor1');
 cam.style.visibility = 'hidden';
}


function alteraVisibilidadeAlocacaoInvisivel()
{
 
 cam = parent.document.getElementById('menuAlocacao');
 cam.style.visibility = 'hidden';
}


function alteraVisibilidadeLista()
{
 
 cam = parent.document.getElementById('menuLista');
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


function alteraVisibilidadePilha()
{
 
cam = parent.document.getElementById('menuPilha');
cam.style.visibility = 'visible';
}


function alteraVisibilidadeArvore()
{
 
 cam = parent.document.getElementById('menuArvore');
cam.style.visibility = 'visible';
}

function alteraVisibilidadeMetOrd()
{
 
cam = parent.document.getElementById('menuMetOrd');
cam.style.visibility = 'visible';
}

function alteraVisibilidadeMetPesq()
{
 
 cam = parent.document.getElementById('menuMetPesq');
cam.style.visibility = 'visible';
}
 
      




function mudaCorLista()
{
   
  parent.document.getElementById('menuLista').style.color = "blue";

}

 
