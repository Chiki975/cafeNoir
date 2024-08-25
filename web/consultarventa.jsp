

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.*"%>
<%@page import="java.util.*"%>
<%  String perfil="";
    String nom="";
    String cod="";
     String correo="";
    String distrito="";
    String codigo="";
   HttpSession sessionOK=request.getSession();
   
if (sessionOK.getAttribute("perfil")!=null) {
        nom=(String)sessionOK.getAttribute("ape");
        cod=(String)sessionOK.getAttribute("nom");
        correo=(String)sessionOK.getAttribute("corr");
        distrito=(String)sessionOK.getAttribute("dist");
        perfil=(String)sessionOK.getAttribute("perfil");
        codigo=(String)sessionOK.getAttribute("codigo");
    }
%>
<!DOCTYPE html>

<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Reserva-consulta</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
<link href="css/stylesventa.css" rel="stylesheet" type="text/css" media="all" />


   <link href="css/sb-admin-2.min.css" rel="stylesheet">
   
   


    <head>
	<meta charset="utf-8">
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
    <nav class="custom-navbar navbar navbar-expand-lg navbar-dark fixed-top affix" data-spy="affix" data-offset-top="10">
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
                  <li class="nav-item">
                    <a class="nav-link" href="ServletControlador?accion=Mostrarpreparacion">Preparacion</a>
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
    
        <!-- End of Sidebar -->
        <br>    <br>    <br>    <br>
        <!-- Content Wrapper -->


            <!-- Main Content -->
            <div id="content">

               
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                 <div class="text-center">
                                        <h1 class="h4 text-gray-900 mb-4">Detalles</h1>
                                    </div>
                <div class="container">
 <iframe class="container embed-responsive" name="detalle" >
                                        
                                    </iframe>
                    
                    
                    <br> <br> <br> <br>
               
                    <div class="row">
                        <% 
                                  ArrayList<Venta> lista =(ArrayList<Venta>)request.getAttribute("lista");
                                  for(Venta v :lista){
                        
                        %>

                            <!-- Collapsable Card Example -->
                            <div class="card shadow mb-4">
                                <!-- Card Header - Accordion -->
                                <a href="#collapseCardExample<%= v.getCodigoVenta()%>" class="d-block card-header py-3" data-toggle="collapse"
                                    role="button" aria-expanded="true" aria-controls="collapseCardExample">
                                      <h6 class="m-0 font-weight-bold text-succes">Estado  &nbsp; PENDIENTE</h6>
                                    <h6 class="m-0 font-weight-bold text-succes">Codigo:  &nbsp; <%= v.getCodigoVenta()%></h6>
                                      <h6 class="m-0 font-weight-bold text-succes">Cliente:  &nbsp; <%= v.getCliente()%></h6>
                                       <h6 class="m-0 font-weight-bold text-succes">Fecha:  &nbsp; <%= v.getFecha()%></h6>
                                        <h6 class="m-0 font-weight-bold text-succes">Fecha Reserva:  &nbsp; <%= v.getFchreser()%></h6>
                                      <h6 class="m-0 font-weight-bold text-succes">Hora Reserva:   &nbsp; <%= v.getHrareser()%></h6>
                                       <h6 class="m-0 font-weight-bold text-succes">observación:  &nbsp; <%= v.getObser()%></h6>
                                </a>
                                <!-- Card Content - Collapse -->
                                <div class="collapse" id="collapseCardExample<%= v.getCodigoVenta()%>">
                                    <div class="card-body">

                                        <a class="dropdown-item" href="obtenerdetalle.jsp?cod=<%= v.getCodigoVenta()%>" target="detalle" onclick="topFunction()">Detalle de Pedido</a>
                                     <a class="dropdown-item" href="pedidorealizado.jsp?cod=<%= v.getCodigoVenta()%>">Pedido Realizado</a>
                                       <a class="dropdown-item" href="correoevi.jsp?cod=<%= v.getCodigoVenta()%>">Eviar correo</a>
                                    
                                    </div>
                                </div>
                            </div>
                             
                            <% 
                                }
                        
                        %>
                            <!-- Large modal -->


                      
                            

                        </div>

                    </div>

                </div>
                <!-- /.container-fluid -->

       
            <!-- End of Main Content -->

             <!-- Footer-->
        
    <!-- Bootstrap core JavaScript-->
    <script src="js/jquery.min.js"></script>
      <script src="js/sb-admin-2.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>

<script>
// Get the button
let mybutton = document.getElementById("myBtn");

// When the user scrolls down 20px from the top of the document, show the button
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    mybutton.style.display = "block";
  } else {
    mybutton.style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0;
  document.documentElement.scrollTop = 0;
}
</script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>