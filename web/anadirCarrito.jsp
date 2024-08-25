
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="Modelo.*"%>
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
    if (sessionOK.getAttribute("perfil")==null) {
%>
<jsp:forward page="login.jsp"/>
<%}else{usu=(String)sessionOK.getAttribute("perfil");}

%>
<% Producto p=ProductoDB.obteneProductos(Integer.parseInt(request.getParameter("id"))); %>
<!DOCTYPE html>
<html lang="en">
  <%@ include file="nav.jsp"%>
    <!-- header -->
    <div id="home" class="header">
        <div class="overlay text-white text-center">
            <section class="py-5" style=" width:100%;">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="img/<%= p.getImagen() %>" alt="..." /></div>
                    <div class="col-md-6">
                        <div class="small mb-1">SKU: <%= p.getCodigoProducto()%></div>
                        <h1 class="display-5 fw-bolder"><%= p.getNombre() %></h1>
                        <div class="fs-5 mb-5">
                     
                            
                            <form action="ServletControlador" method="post">
							
									<span>S/<%= p.getPrecio() %></span>
                                                                         </div>
								<div class="">
                                                                    <input type="hidden" value="<%= p.getCodigoProducto()%>"  name="txtCodigo" />
                                                                     <input type="hidden" value="<%= p.getNombre() %>"  name="txtNombre" />
                                                                    <input type="hidden" value="<%= p.getPrecio() %>"  name="txtPrecio" />
                                                                    <input type="number" value="1" min="0" value="0" id="form-control text-center" name="txtCantidad"style="width: 66px;height: 38px;" /> &nbsp;
                                                                    <input type="submit" value="Añadir" name="btnAnadir" class="btn btn-primary"/>
                                                                     <input type="hidden" value="AnadirCarrito" name="accion"/>
									
							
                            </form><!-- comment id="inputQuantity"  -->
                            
                            
                        
                        </div>
                    </div>
                </div>
            </div>
        </section>
     
        </div>
    </div>
<div class="bg-dark text-light text-center border-top wow fadeIn">
        <p class="mb-0 py-3 text-muted small">&copy; Copyright <script>document.write(new Date().getFullYear())</script> Grupo ?</p>
    </div>
    <!-- end of page footer -->
   <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- core  -->
    <script src="assets/vendors/jquery/jquery-3.4.1.js"></script>
    <script src="assets/vendors/bootstrap/bootstrap.bundle.js"></script>

    <!-- bootstrap affix -->
    <script src="assets/vendors/bootstrap/bootstrap.affix.js"></script>

    <!-- wow.js -->
    <script src="assets/vendors/wow/wow.js"></script>
    

    <!-- FoodHut js -->
    <script src="assets/js/foodhut.js"></script>

</body>
</html>




       
     