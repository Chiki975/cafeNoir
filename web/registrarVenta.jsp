
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.*"%>
<%@page import="java.util.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page session="true" %>
<%  String perfil = "";
    String nom = "";
    String cod = "";
    String correo = "";
    String distrito = "";
    String codigo = "";
    HttpSession sessionOK = request.getSession();

    if (sessionOK.getAttribute("perfil") != null) {
        nom = (String) sessionOK.getAttribute("ape");
        cod = (String) sessionOK.getAttribute("nom");
        correo = (String) sessionOK.getAttribute("corr");
        distrito = (String) sessionOK.getAttribute("dist");
        perfil = (String) sessionOK.getAttribute("perfil");
        codigo = (String) sessionOK.getAttribute("codigo");
    }
%>
<!DOCTYPE html>
<html lang="en">


    <!-- Navigation-->
    <%@ include file="nav.jsp"%>
    <!-- Header-->
         <%
                        SimpleDateFormat dtf = new SimpleDateFormat("yyyy-MM-dd");
                        Calendar calendar = Calendar.getInstance();

                        Date dateObj = calendar.getTime();
                        String formattedDate = dtf.format(dateObj);

                    %>

 <form action="ServletControlador" method="post">
                     <input type="hidden" value="RegistrarVenta" name="accion"/>
    <div class="container-fluid has-bg-overlay text-center text-light has-height-lg middle-items" id="book-table">
        <div class="">
            <h2 class="section-title mb-5"></h2>
            <div class="row mb-5">
                <div class="col-sm-6 col-md-3 col-xs-12 my-2">
                    <input type="email" id="booktable" class="form-control form-control-lg custom-form-control" value="<% out.println(correo); %>"    name="txtcorreo">
                </div>
                <div class="col-sm-6 col-md-3 col-xs-12 my-2">
                    <input type="text" id="booktable" class="form-control form-control-lg custom-form-control" placeholder="NUMBER OF GUESTS" name="txtobser" value="No tengo observaciones">
                </div>
                <div class="col-sm-6 col-md-3 col-xs-12 my-2">
                    <input type="time" id="booktable" class="form-control form-control-lg custom-form-control" placeholder="EMAIL"  name="txthora">
                </div>
                <div class="col-sm-6 col-md-3 col-xs-12 my-2">
                    <input type="date" id="booktable" class="form-control form-control-lg custom-form-control" placeholder="12/12/12"  name="txtfecha"  min=<%out.println(formattedDate); %>">
                </div>
            </div>

        </div>
    </div>



    <!-- Section-->
    <section class="py-5">
        <div class="container px-4 px-lg-5 mt-5">

      


                <div class="form-group">

                    <input type="hidden" class="form-control form-control-user" id="recipient-name"   
                           name="txtNombre" value="<%if(sessionOK.getAttribute("perfil")!= null){out.println(nom);}%>" readonly="readonly" >

                  
                    <input type="hidden" class="form-control form-control-user" id="recipient-name"   
                           name="txtcod" value=<%
                                                        if (sessionOK.getAttribute("perfil") != null) {
                                                            out.println(codigo);
                                                        }%>

                           " readonly="readonly" >
                  
                  
                   
                </div>

                <br>                        
                <div class="">
                    <div class="cart shopping">
                        <div class="container">

                            <div class=" col-md-offset-2">
                                <div class="block">
                                    <div class="product-list">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>

                                                    <tr>
                                                        <th class=""></th>
                                                        <th class="">Nombre</th>
                                                        <th class="">Precio</th>
                                                        <th class="">Cantidad</th>
                                                        <th class="">Descuento</th>
                                                        <th class="">Sub. Total</th>
                                                        <th class=""></th>
                                                    </tr>

                                                </thead>
                                                <tbody>
                                                    <%
                                                        double total = 0;
                                                        double totapago = 0;
                                                        ArrayList<DetalleVenta> lista = (ArrayList<DetalleVenta>) session.getAttribute("carrito");
                                                        if (lista != null) {
                                                            for (DetalleVenta d : lista) {

                                                    %>   
                                                    <tr class="">
                                                        <td class="">
                                                            <div class="product-info">
                                                                <img width="80" src="img/<%= d.getProducto().getImagen()%>" alt="" />
                                                            </div>
                                                        </td>
                                                        <td class=""><%= d.getProducto().getNombre()%></td>
                                                        <td class=""><%= d.getProducto().getPrecio()%></td>
                                                        <td class=""><%= d.getCantidad()%></td>
                                                        <td class=""><%= String.format("%.2f", d.getDescuento())%></td>
                                                        <td class=""><%= String.format("%.2f", (d.getProducto().getPrecio() * d.getCantidad()) - d.getDescuento())%></td>
                                                        <td class="">

                                                            <a class="product-remove" href="ServletLogueo?accion=eliminar&idProducto=<%= d.getProducto().getCodigoProducto()%>" >Eliminar</a>
                                                        </td>
                                                    </tr>
                                                    <%
                                                                total = total + (d.getProducto().getPrecio() * d.getCantidad()) - d.getDescuento();
                                                                totapago = (total * total) / (total * 3.96);
                                                            }
                                                        }
                                                    %>   


                                                </tbody>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td></td>
                                                <td>Total</td>
                                                <td><%= String.format("%.2f", total)%></td>

                                                <input type="hidden" value="<%=totapago%>" name="totapago"/>
                                                <input type="hidden" value="<%=total%>" name="total"/>
                                                <td>  <input type="submit" value="Registrar Venta" name="btnVenta" class="btn btn-main pull-right"/></td>
                                            </table>

                                            </form>





                                            <br>
                                            <div class="container">
                                                <div class="row">

                                                </div>  
                                            </div>
                                        </div>   <br>
                                        <div class="section-title text-center">
                                            <a class="btn btn-solid-border " href="index.jsp">Seguir Comprando</a>
                                            <a class="btn btn-solid-border " href="ServletLogueo?accion=cancelar">Cancelar Compra</a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>





                </div>
        </div>


    </section>                





    <!-- page footer  -->
    <div class="container-fluid bg-dark text-light has-height-md middle-items border-top text-center wow fadeIn">
        <div class="row">
            <div class="col-sm-4">
                <h3>Correo</h3>
                <P class="text-muted">informe@cafenoir.com</P>
            </div>
            <div class="col-sm-4">
                <h3>Telefono</h3>
                <P class="text-muted">(51) 947757081</P>
            </div>
            <div class="col-sm-4">
                <h3>Encuentranos</h3>
                <P class="text-muted">Av. Nicolás Ayllón con, Ate 15487</P>
            </div>
        </div>
    </div>
    <div class="bg-dark text-light text-center border-top wow fadeIn">
        <p class="mb-0 py-3 text-muted small">&copy; Copyright <script>document.write(new Date().getFullYear())</script> Grupo ?</p>
    </div>

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
