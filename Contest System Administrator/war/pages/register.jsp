
<html>
<head>

<script type="text/javascript"> 
		function procesa(valor) 
		{ 
			if(valor == 1) 
			{ 

				formulario.n1.checked = false;
				formulario.n1.disabled = false;

				formulario.n2.checked = false;
				formulario.n2.disabled = false; 

				formulario.n3.checked = false;
				formulario.n3.disabled = false;
			} 
			else{
				if(valor == 2){

					formulario.n1.checked = false;
					formulario.n1.disabled = true;

					formulario.n2.checked = false;
					formulario.n2.disabled = false; 

					formulario.n3.checked = false;
					formulario.n3.disabled = false;
				}
				else
				{
					formulario.n1.checked = false;
					formulario.n1.disabled = true;

					formulario.n2.checked = false;
					formulario.n2.disabled = true;

					formulario.n3.checked = false;
					formulario.n3.disabled = false;
				}
			}

		} 
		function hider(valor) {
			alert(valor);
		}

		var jojojo = function(){
			alert("jojojo");
			var form = document.getElementById("formulario")
			form.method ="delete";
			form.action="rest/user/delete";
			form.submit();
		}

		function changeMethod() {
			formulario.method ="delete";
			formulario.action="rest/user/delete";
			formulario.submit();
		}	

		var change = function( changeTo ) {
			var form = document.getElementById( "myPost" );
			form.method = changeTo;
			form.submit();
		}
		var change2 = function ( changeTo ) {
			var form = document.getElementById( "myPost" );
			form.doAction = changeTo;
			form.submit();
		}

		function deleteBook(isbn)
		{
			var xmlHttp = getXmlHttp();



			xmlHttp.open("DELETE", "rest/user/books/" + isbn, true);
			xmlHttp.send(null);
		}

	</script>

<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Refresh by Free CSS Templates</title>
<link href="/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
  
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">

</head>
<body>
	<p><h2 style="font-weight: bold; color: #086A87;">REGISTRO........</h2></p>
	<!--<input name="pregunta8[0]" type="checkbox" id="pregunta8" value="Primer checkbox"  onclick="habilitap8y9(this)">-->
	
	<form  action="add_u" method="post" name="formulario" >
	
	<font face="Comic Sans MS,arial,verdana">
		
		<!--<button type="button" value="Delet User" onClick="jojojo()">eliminar</button>
		<button type="button" value="eli" onClick="changeMethod(this.form)">eli</button>
		-->
		
		<table border="0">
		<thead>
		<tr>
			<td>Username :</td> <td><input type="text" name="Username" /></td>
		</tr>
		</thead>
		<thead>
			<tr>
		<td>password : </td> <td><input type="password" name="password" /></td>
		</tr>
		</thead>
		<thead>
			<tr>
		<td>c.i. :</td> <td> <input type="text" name="ci" /></td>
		</tr>
		</thead>
		<thead>
			<tr>
		<td>Nombres : </td> <td><input type="text" name="nombre" /></td>
		</tr>
		</thead>
		<thead>
			<tr>
		<td>Apellido Paterno : </td> <td><input type="text" name="ap" /></td>
		</tr>
		</thead>
		<thead>
			<tr>
		<td>Apellido Materno :</td> <td> <input type="text" name="am" /></td>
		</tr>
		</thead>
		<thead>
			<tr>
		<td>fecha de nacimiento : </td> <td><input type="text" name="f" ></td>
		</tr>
		</thead>
		<thead>
		
		<thead>
		<tr>
		<td>Selecccione su genero...</td>
		<td>	<input type="radio" name="sexo" value="masculino"checked> Masculino
			<input type="radio" name="sexo" value="femenino"  >Femenino</td>
		</tr>
		</thead>
		
		<thead>
		<tr>
		<td>Elija su categoria :</td>
			<td><input type="radio" name="obs" value="Competidor"checked  onclick = "rd.disabled = true; ru.disabled = false"> Competidor
			<input type="radio" name="obs" value="Profesor"  onclick = "ru.disabled = true; rd.disabled = false">Profesor</td>
		</tr>
		</thead>
		
		<thead>
		<tr>
		<td>RUDE :</td> <td><input type="text" name="ru" disabled="disabled"/></td>
		</tr>
		</thead>
		<thead>
		<tr>
		<td>RDA:</td><td> <input type="text" name="rd"  disabled="disabled" /></td>	
		
		</tr>
		</thead>
		</table>
		<input type="submit" value="Add User" />
		<br>
		<br>
		<br>
		<br>
		<p>RANGO DE EDAD :</p>
		<select name="lista" onChange="procesa(this.form.lista.options[this.form.lista.selectedIndex].value)"> 
			<option value="1" >11 - 13</option>
			<option value="2" >14 - 16</option>
			<option value="3" >16 - 18</option>
		</select> 

		<div > seleccione su nivel :<br>
			<input type="checkbox" name="n1" value='1' >nivel_1<br>
			<input type="checkbox" name="n2" value='2' >nivel_2<br>				
			<input type="checkbox" name="n3" value='3' >nivel_3<br>
			<br>
		</div>

</body>
</html>