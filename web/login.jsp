<%-- 
    Document   : login
    Created on : 20 oct 2022, 23:42:38
    Author     : xibar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<title> UTP Reservas</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content=" Master  Login Form Widget Tab Form,Login Forms,Sign up Forms,Registration Forms,News letter Forms,Elements"/>
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href="//fonts.googleapis.com/css?family=Cormorant+SC:300,400,500,600,700" rel="stylesheet">
<link href="//fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
</head>

<body>
	<div class="padding-all">
		<div class="header">
			<h1>Café Noir Reservas</h1>
			<h2>Reserva tu Cafe nunca fue tan facil</h2>
		</div>

		<div class="design-w3l">
			<div class="mail-form-agile">
				<form action="ServletLogueo" method="POST">
					<input type="text" name="txtUsu" placeholder="Café Noir tu mejor elección" required=""/>
					<input type="password"  name="txtPass" class="padding" placeholder="Contraseña" required=""/>
					<input type="submit"  name="btn" value="Iniciar">
                                        <input type="hidden"  name="accion" value="loguin">
				</form>
                            
                            <%  if(request.getAttribute("msg")!=null){ %>
                            <a href="#" class="mensaje"><%out.println(request.getAttribute("msg")); %></a>
                                <% }%>
                                <h2> <a href="nuevouser.jsp" class="mensaje" >Registrate</a></h2>
			</div>
		  
		</div>
		
	</div>
</body>
</html>