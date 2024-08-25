<%-- 
    Document   : perfil
    Created on : 30 oct 2022, 23:51:10
    Author     : xibar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.*"%>
<%@page import="java.util.*"%>
<%@page session="true" %>
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
<html>
    <head>
          <!-- Customized Bootstrap Stylesheet -->
        <link href="css/styleperfil.css" rel="stylesheet">
    </head>
    <body >
               
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

 <div class="wrapper" style="background: #495057;">
                    

            <div class="sidebar" style="background: #495057;">
                

                <div class="sidebar-text d-flex flex-column h-100 justify-content-center text-center" style="background: #495057;">
                    <br><br><br><br><br><br><br><br><!-- comment -->
                    <h1 class="font-weight-bold text-success"><%out.println(nom); %></h1>
                    <p class="font-weight-bold">
                      <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Codigo</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"><%out.println(codigo); %></p>
              </div>
            </div>
         
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Correo</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"><%out.println(correo); %></p>
              </div>
            </div>
            <hr>
            <div class="row">
              <div class="col-sm-3">
                <p class="mb-0">Distrito</p>
              </div>
              <div class="col-sm-9">
                <p class="text-muted mb-0"><%out.println(distrito); %></p>
              </div>
            </div>
                    </p>
                   
                    <!--  <a href="" class="btn btn-lg btn-block btn-primary mt-auto">Configuración</a>-->
                </div>
                <div class="sidebar-icon d-flex flex-column h-100 justify-content-center text-right">
                    <i class="fas fa-2x fa-angle-double-right text-primary"></i>
                </div>
            </div>
            <div class="content" style="background: #495057;">
                <!-- Navbar Start -->
                <div class="container p-0">
                  
                </div>
                <!-- Navbar End -->
                
                <!-- Carousel Start -->
               
                <!-- Carousel End -->
                
                
                <!-- Blog List Start -->
                <div class="container bg-white pt-5 sidebar-text d-flex flex-column h-100 justify-content-center text-center">
                      <div class="row blog-item px-3 pb-5">
                        <div class="col-md-1">
                          
                        </div>
                        <div class="col-md-11">
                            <h3 class="mt-md-4 px-md-3 mb-2 py-2 bg-white font-weight-bold">Tus Pedidos</h3>
                            
                          
                            
                        </div>
                    </div>
                      <% 
                                  ArrayList<Venta> lista =(ArrayList<Venta>)request.getAttribute("listaventa");
                                  for(Venta v :lista){
                        
                        %>
                    <div class="row blog-item px-3 pb-5">
                        <div class="col-md-1">
                          
                        </div>
                        <div class="col-md-11">
                            <h3 class="mt-md-4 px-md-3 mb-2 py-2 bg-white font-weight-bold">Pedidos : <% if ( v.getEstado()==1 ) {%>Realizado<%}else{%>En espera<%}%>
      
 </h3>
                            <div class="d-flex mb-3">
                                
                                 <small class="mr-3 text-dark"><i class="fa fa-calendar-alt"></i>Fecha generado: <%= v.getFecha()%></small>
                                <small class="mr-2 text-dark"><i class="fa fa-folder"></i>Fecha Reserva: <%= v.getFchreser()%></small>
                                <small class="mr-2 text-dark"><i class="fa fa-comments"></i> Hora Reserva: <%= v.getHrareser()%></small>
                                <small class="mr-2 text-dark"><i class="fa fa-comments"></i> Observaciones: <%= v.getObser()%></small>

                            
                            
                            </div>
                            <p>
                                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed eu suscipit orci velit id libero
                            </p>
                         <!--  <a class="btn btn-link p-0" href="">Read More <i class="fa fa-angle-right"></i></a>-->
                        </div>
                    </div>
                       <% 
                                }
                        
                        %>
                </div>
              
            </div>
        </div>





               
 

                      
                 <!-- end of page footer -->
    <!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <!-- core  -->
    <script src="assets/vendors/jquery/jquery-3.4.1.js"></script>
    <script src="assets/vendors/bootstrap/bootstrap.bundle.js"></script>

    <!-- bootstrap affix -->


    <!-- wow.js -->
    <script src="assets/vendors/wow/wow.js"></script>


    <!-- FoodHut js -->
    <script src="assets/js/foodhut.js"></script>
    </body>
</html>
