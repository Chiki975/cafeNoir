<%-- 
    Document   : newjsp
    Created on : 18 oct 2022, 2:01:34
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
    String usu="";
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

<!--
 // WEBSITE: https://themefisher.com
 // TWITTER: https://twitter.com/themefisher
 // FACEBOOK: https://www.facebook.com/themefisher
 // GITHUB: https://github.com/themefisher/
-->

<html lang="en">
<head>

  <!-- Basic Page Needs
  ================================================== -->
  <meta charset="utf-8">
  <title>Reserva-pago</title>

  <!-- Mobile Specific Metas
  ================================================== -->
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="description" content="Construction Html5 Template">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=5.0">
  <meta name="author" content="Themefisher">
  <meta name="generator" content="Themefisher Constra HTML Template v1.0">
   <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Bootstrap icons-->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
        <!-- Core theme CSS (includes Bootstrap)-->
<link href="css/stylesventa.css" rel="stylesheet" type="text/css" media="all" />
<link rel="stylesheet" href="css/stylecart.css">

</head>

<body id="body">
<!-- Start Top Header Bar -->   <!-- Navigation-->
        <%@ include file="nav.jsp"%>

        <!-- Header-->
            
                   
      
</section>
<section class="page-header">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="content">
					<h1 class="page-name">Pago</h1>
					<ol class="breadcrumb">
						
					</ol>
				</div>
			</div>
		</div>
	</div>
</section>
<div class="page-wrapper">
   <div class="checkout shopping">
      <div class="container">
         <div class="row">
            <div class="col-md-8">
               <div class="block billing-details">
                  <h4 class="widget-title">DETALLES</h4>
                  <form class="checkout-form">
                     <div class="form-group">
                        <label for="full_name">Nombre</label>
                        <input type="text" class="form-control"  placeholder="" value="<%out.println(nom);%>" readonly="readonly">
                     </div>
                     <div class="form-group">
                        <label for="user_address">Correo</label>
                        <input type="text" class="form-control" id="user_address" placeholder="" value="<%out.println(correo);  %>" readonly="readonly">
                     </div>
                     <div class="checkout-country-code clearfix">
                        <div class="form-group">
                           <label for="user_post_code">Distrito</label>
                           <input type="text" class="form-control" id="user_post_code" name="zipcode" value="<%out.println(distrito);  %>" readonly="readonly">
                        </div>
                        
                     </div>
                     
                  </form>
               </div>
                
      <%  double totapago= Double.parseDouble(request.getParameter("totapago")); 
double total= Double.parseDouble(request.getParameter("total")); 
%>
                               <form action="https://www.paypal.com/cgi-bin/webscr" method="post" target="_top">
<input type="hidden" name="cmd" value="_ext-enter">
<input type="hidden" name="redirect_cmd" value="_xclick">
<input type="hidden" name="business" value="xibarraprieto2003@gmail.com">
<input type="hidden" name="item_name" value="Productos">
<input type="hidden" name="quantity" value="1">
<input type="hidden" name="amount" value="<%=totapago%>">
<input type="hidden" name="currency_code" value="USD">
<input type="hidden" name="return" value="http://localhost:8080/CarritoPoo/index.jsp">
 <td><input type="image" src="https://www.paypalobjects.com/es_XC/i/btn/btn_buynowCC_LG.gif" border="0" name="submit" alt="PayPal - The safer, easier way to pay online!">
<img alt="" border="0" src="https://www.paypalobjects.com/es_XC/i/scr/pixel.gif" width="1" height="1"> <td>
</form>
    </body>
</html>

               
            </div>
            <div class="col-md-4">
               <div class="product-checkout-details">
                  <div class="block">
                     <h4 class="widget-title">Resumen del pedido</h4>
                     
              
                     </div>
                   
                     <ul class="summary-prices">
                        <li>
                           <span>Precio:</span>
                           <span class="price">S/<%= String.format("%.2f", total) %></span>
                        </li>
                        <li>
                           <span>Otros:</span>
                           <span>0.00</span>
                        </li>
                     </ul>
                     <div class="summary-total">
                        <span>Total</span>
                        <span>$<%= String.format("%.2f", totapago) %></span>
                     </div>
                  
                  </div>
               </div>
            </div>
         </div>
      </div>
   </div>
</div>
    <!-- Footer-->
        <footer class="py-5 bg-success">
            <div class="container"><p class="m-0 text-center text-dark">Copyright &copy;  2022</p></div>
        </footer>
    <!-- 
    Essential Scripts
    =====================================-->
    
    <!-- Main jQuery -->
    <script src="plugins/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap 3.1 -->
    <script src="plugins/bootstrap/js/bootstrap.min.js"></script>
    <!-- Bootstrap Touchpin -->
    <script src="plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js"></script>
    <!-- Instagram Feed Js -->
    <script src="plugins/instafeed/instafeed.min.js"></script>
    <!-- Video Lightbox Plugin -->
    <script src="plugins/ekko-lightbox/dist/ekko-lightbox.min.js"></script>
    <!-- Count Down Js -->
    <script src="plugins/syo-timer/build/jquery.syotimer.min.js"></script>

    <!-- slick Carousel -->
    <script src="plugins/slick/slick.min.js"></script>
    <script src="plugins/slick/slick-animation.min.js"></script>

    <!-- Google Mapl -->
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCC72vZw-6tGqFyRhhg5CkF2fqfILn2Tsw"></script>
    <script type="text/javascript" src="plugins/google-map/gmap.js"></script>

    <!-- Main Js File -->
    <script src="js/script.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    


  </body>
  </html>