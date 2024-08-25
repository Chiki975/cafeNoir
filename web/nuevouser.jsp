<%-- 
    Document   : nuevouser
    Created on : 30 nov. 2023, 20:41:03
    Author     : xibar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Crear nueva cuenta</title>
	<link rel="stylesheet" href="css/estiloslogin.css">
</head>
<body>
	<section>
		
		<div class="box">
			
			 <div class="container">
			 	<div class="form">
			 		<h2>Crear nueva cuenta</h2>
			 		<form  onsubmit="" action="ServletLogueo" method="POST">
			 	
						 <div class="inputBox">
							<input type="text" id="user" name="Nombre" placeholder="Nombre"/>
							
						</div>
                                            <div class="inputBox">
							<input type="text" id="user" name="distrito" placeholder="Distrito"/>
							
						</div>
                                            <div class="inputBox">
							<input type="text" id="user" name="username" placeholder="Usuario"/>
							
						</div>
			 			<div class="inputBox">
			 				<input type="email" id="email" name="email" placeholder="Correo electronico"/>
						
			 			</div>
						
			 			<div class="inputBox">
			 				<input type="password" id="contrasena"  name="password" placeholder="Contraseña"/>
							
			 			</div>
						
					 <input type="hidden"  name="accion" value="nuevouser">
                                         
			 			<div class="inputBox">
			 				<input type="submit" value="Crear Cuenta" />
			 			</div>
			 			
					
			 			<p class="forget">
			 				Ya tienes una cuenta en cafenoir? <a href="login.jsp">Iniciar sesión</a>
			 			</p>
			 		</form>
			 	</div>
			 </div>
		</div>
	</section>
</body>
</html>



