<%@ page import="java.util.List" %>
<%@ page import="com.google.appengine.api.datastore.Entity" %>
<html>
<head>
  <script type="text/javascript"> 

	</script>
   
    <meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Refresh by Free CSS Templates</title>
<link href="/stylesheets/style.css" rel="stylesheet" type="text/css" media="screen" />
  
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Gusteyker..</title>
    
    
  </head>
<body>


<form  action="/customer/register" method="get" name="formulario" >
		<font face="Comic Sans MS,arial,verdana">
		<br>
			<h2 style="font-weight: bold; color: #086A87;">All Usuarios</h2>
			<br>
	<table border="1">
		<thead>
			<tr>
				<td>Username</td>
				<td>password</td>
				<td>Record date</td>
			</tr>
		</thead>
		<%
		
			List<Entity> Usuario = (List<Entity>)request.getAttribute("UsuarioList");
			List<Entity> Persona = (List<Entity>)request.getAttribute("PersonaList");
			
		    for(Entity e : Usuario ){
		     
		%>
			<tr>
				<td><%=e.getProperty("Username") %></td>
				<td><%=e.getProperty("password") %></td>
				<td><%=e.getProperty("date") %></td>
				
			    <td><a href="update_U/<%=e.getProperty("Username")%>">Update</a> | <a href="delete_U/<%=e.getProperty("Username")%>">Delete</a></td>
			</tr>
		<%
			}
		%>
	</table>
			
			<dd><u><A HREF="/customer/index" TARGET="red"><p>volver..</p></A></u></dd>
			
		</font>
	</form> 
	

</body>
</html>