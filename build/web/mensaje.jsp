

<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
<html lang="es">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Reserva-mensaje</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
<link href="css/stylesventa.css" rel="stylesheet" type="text/css" media="all" />
 <link rel="stylesheet" href="css/stylecart.css">
    </head>
    <body>
        
 
        
        <!-- Navigation-->
     <%@ include file="nav.jsp"%>
        <!-- Header-->
      
               
                    
        <!-- Section-->
       

                    
                    
<section class="page-wrapper success-msg">
  <div class="container">
    <div class="row">
      <div class="">
        <div class="block text-center">
     
        	<i class="bi bi-check-circle" width="10" height="10"></i>
          <h2 class="text-center">        
<% if(request.getParameter("men")!=null){
    out.println(request.getParameter("men"));} %></h2>
          <p></p>
          <a href="index.jsp" class="btn btn-main mt-20">Volver al Menu Princiapal</a>
        </div>
      </div>
    </div>
  </div>
</section><!-- /.page-warpper -->


<br><br><br><br><br><br>
     
        <!-- Footer-->
        <footer class="py-5 bg-success">
            <div class="container"><p class="m-0 text-center text-dark">Copyright &copy;  2022</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
      
    </body>
</html>
