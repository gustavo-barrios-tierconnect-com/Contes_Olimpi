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
	<h1>Update Customer</h1>
 
	<%
		Entity Usuario = (Entity)request.getAttribute("Usuario");
	%>
 
	<form method="post" action="../update_U" >
		<input type="hidden" name="originalName" id="originalName" 
			value="<%=Usuario.getProperty("Username") %>" /> 
 
		<table>
			<tr>
				<td>
					Username :
				</td>
				<td>
					<input type="text" style="width: 185px;" 
                                             maxlength="30" name="Username" id="Username" 
						value="<%=Usuario.getProperty("Username") %>" />
				</td>
			</tr>
			<tr>
				<td>
					Email :
				</td>
				<td>
					<input type="text" style="width: 185px;" 
                                            maxlength="30" name="password" id="password" 
						value="<%=Usuario.getProperty("password") %>" />
				</td>
			</tr>
		</table>
		<input type="submit" class="update" title="Update" value="Update" />
	</form>
 
</body>
</html>