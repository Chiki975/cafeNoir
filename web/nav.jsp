<head>
	<meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Start your development with FoodHut landing page.">
     <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <meta name="author" content="Devcrud">
    <title>Café Noir</title>
   
    <!-- font icons -->
    <link rel="stylesheet" href="assets/vendors/themify-icons/css/themify-icons.css">

    <link rel="stylesheet" href="assets/vendors/animate/animate.css">

    <!-- Bootstrap + FoodHut main styles -->
	<link rel="stylesheet" href="assets/css/foodhut.css">
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="40" id="home">
    
    <!-- Navbar -->
    <nav class="custom-navbar navbar navbar-expand-lg navbar-dark fixed-top" data-spy="affix" data-offset-top="10">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Inicio</a>
                </li>
                  <li class="nav-item">
                  <%  if (sessionOK.getAttribute("perfil")!=null) {%>
                  
                       <form action="ServletControlador?accion=perfil" method="POST">
                     <input type="hidden" class="form-control form-control-user" id="recipient-name"   
                                                    name="codusu" value=<%
                                                     if (sessionOK.getAttribute("perfil")!=null){
                                                     out.println(codigo);  }%>
                                                     
                                                    " readonly="readonly" >
                       
                        
              <input type="submit"  value="Perfil" class="btn btn-danger"/>

                               
                                   
                   
                                   </form>
                  
                   
                </li>
                
                    <%  }%>
                    <% 
   
if (sessionOK.getAttribute("perfil")!=null && sessionOK.getAttribute("perfil").equals("trabajador") ) {
      
%>

                <li class="nav-item">
                    <a class="nav-link" href="registrarproducto.jsp">Registrar Producto</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ServletControlador?accion=MostrarVentas">Ventas</a>
                </li>
                 <% } %>
            </ul>
            <a class="navbar-brand m-auto" href="index.jsp">
                <img src="assets/imgs/logo.png" class="brand-img" alt="">
                <span class="brand-txt">Café Noir</span>
            </a>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#contact">Contactanos</a>
                </li>
                  <%  if (sessionOK.getAttribute("perfil")==null) {%>
                   <a href="login.jsp" class="btn btn-primary ml-xl-4">  Ingresar</a>
                  
                               
                                <%  }%>
                  <%  if (sessionOK.getAttribute("perfil")!=null) {%>
                                 <a href="ServletLogueo?accion=cerrar" class="btn btn-danger ml-xl-4"> Cerrar Sección</a>
                                  <a href="registrarVenta.jsp" class="btn btn-primary ml-xl-4">  <i class="bi-cart-fill me-1"></i> Carrito</a>
                                <%  }%>
               
            </ul>
        </div>
    </nav>