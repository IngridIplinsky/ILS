
function showNameMethod()
	{
alert(this.nome+" ,"+this.dnascimento);
	}

function cadastra()
	{
  var a = document.cad.nome.value;
  var b = document.cad.sobrenome.value;
  var c = document.cad.email.value;
  var d = document.cad.senha.value;
  var e = document.cad.nomeUsuario.value;
  var f = document.cad.senhaUsuario.value;
  
  if(a.length == 0 || b.length == 0|| c.length == 0 || d.length == 0 || e.length == 0 || f.length == 0)
   
   { 
	
	alert("Campo(s) em branco , certifique-se disto");
        return false;
	
   }
   
   
   else

   {
     alert("Cadastro feito com sucesso !!!");
     return true;  
   }
   
   		
 
 }




function teste(){
  alert('Ola');
}








 
