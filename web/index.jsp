
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.*"%>

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
    
    <%@ include file="nav.jsp"%>
    <!-- header -->
    <header id="home" class="header">
        <div class="overlay text-white text-center">
            <h1 class="display-2 font-weight-bold my-3">Café Noir</h1>
            <h2 class="display-4 mb-5">¿Qué se te antoja hoy?</h2>
            <a class="btn btn-lg btn-primary" href="#blog">Ver Catalogo</a>
        </div>
    </header>

    <!--  About Section  -->
    <div id="about" class="container-fluid wow fadeIn" id="about"data-wow-duration="1.5s">
        <div class="row">
            <div class="col-lg-6 has-img-bg"></div>
            <div class="col-lg-6">
                <div class="row justify-content-center">
                    <div class="col-sm-8 py-5 my-5">
                        <h2 class="mb-4">Sobre nosotros</h2>
                        <p>Somos una empresa dedicada a la venta de café y productos relacionados. Nuestro objetivo es ofrecer a nuestros clientes la mejor experiencia posible en el mundo del café.

                            Historia

                            Nuestra empresa fue fundada en 2023 por dos amantes del café que estaban cansados de la falta de opciones de café de calidad en su comunidad. Decidieron crear su propia empresa para ofrecer a los clientes una selección de cafés de alta calidad de todo el mundo.

                            Misión

                            Nuestra misión es ofrecer a nuestros clientes la mejor experiencia posible en el mundo del café. Nos comprometemos a ofrecer una selección de cafés de alta calidad de todo el mundo, así como productos y servicios de apoyo de alta calidad.

                            Valores

                            Nuestros valores son:

                            Calidad: Nos comprometemos a ofrecer productos y servicios de alta calidad.
                            Servicio: Nos comprometemos a proporcionar un servicio al cliente excelente.
                            Compromiso: Nos comprometemos a mantenernos comprometidos con nuestros clientes y con la comunidad.
                            Productos y servicios

                            Ofrecemos una amplia gama de productos y servicios relacionados con el café, incluyendo:

                            Café en grano: Café de alta calidad de todo el mundo.
                            Café molido: Café molido listo para preparar.
                            Accesorios para café: Cafeteras, molinillos de café, tazas de café y otros accesorios.
                            Servicio de suscripción: Servicio de suscripción de café que ofrece a los clientes una entrega mensual de café recién tostado.</p>
                    </div>
                </div>
            </div>
        </div>
    </div>




    <!-- BLOG Section  -->
    <div id="blog" class="container-fluid bg-dark text-light py-5 text-center wow fadeIn">
        <h2 class="section-title py-5">ESCOGE TU BEBIDA FAVORITA</h2>
        <div class="row justify-content-center">
            <div class="col-sm-7 col-md-4 mb-5">
                <ul class="nav nav-pills nav-justified mb-3" id="pills-tab" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#foods" role="tab" aria-controls="pills-home" aria-selected="true">Café negro</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#juices" role="tab" aria-controls="pills-profile" aria-selected="false">Café con leche</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#frios" role="tab" aria-controls="pills-profile" aria-selected="false">Café frío</a>
                    </li>

                </ul>
            </div>
        </div>
        <div class="tab-content" id="pills-tabContent">
            <div class="tab-pane fade show active" id="foods" role="tabpanel" aria-labelledby="pills-home-tab">
                <div class="row">


                    <%
                        ArrayList<Producto> lista = ProductoDB.obteneProductos1();
                        for (Producto p : lista) {

                    %>
                    <div class="col-md-4">
                        <div class="card bg-transparent border my-3 my-md-0">
                            <img src="img/<%= p.getImagen()%>" alt="" class="rounded-0 card-img-top mg-responsive">
                            <div class="card-body">
                                  <h1 class="text-center mb-4"><a href="anadirCarrito.jsp?id=<%= p.getCodigoProducto()%>" class="badge badge-primary">Añadir</a></h1>
                                <h4 class="text-center">S/.<%= p.getPrecio()%></h4>
                                <%

                                    if (sessionOK.getAttribute("perfil") != null && sessionOK.getAttribute("perfil").equals("trabajador")) {

                                %>
                                <h1 class="text-center mb-4"><a href="actualizarProducto.jsp?id=<%= p.getCodigoProducto()%>" class="badge badge-primary">Modificar</a></h1>
                                <% }%>

                                <h4 class="pt20 pb20"><%= p.getNombre()%></h4>
                                <p class="text-white"><%= p.getDescrip()%></p>
                            </div>
                        </div>
                    </div>
                    <% } %>

                </div>
            </div>
            <div class="tab-pane fade" id="juices" role="tabpanel" aria-labelledby="pills-profile-tab">
                <div class="row">


                    <%
                        ArrayList<Producto> lista2 = ProductoDB.obteneProductos2();
                        for (Producto p : lista2) {

                    %>
                    <div class="col-md-4 my-3 my-md-0">
                        <div class="card bg-transparent border">
                            <img src="img/<%= p.getImagen()%>" alt="" class="rounded-0 card-img-top mg-responsive">
                            <div class="card-body">
                                  <h1 class="text-center mb-4"><a href="anadirCarrito.jsp?id=<%= p.getCodigoProducto()%>" class="badge badge-primary">Añadir</a></h1>
                                <h4 class="text-center">S/.<%= p.getPrecio()%></h4>
                                <%

                                    if (sessionOK.getAttribute("perfil") != null && sessionOK.getAttribute("perfil").equals("trabajador")) {

                                %>
                                <h1 class="text-center mb-4"><a href="actualizarProducto.jsp?id=<%= p.getCodigoProducto()%>" class="badge badge-primary">Modificar</a></h1>
                                <% }%>

                                <h4 class="pt20 pb20"><%= p.getNombre()%></h4>
                                <p class="text-white"><%= p.getDescrip()%></p>
                            </div>
                        </div>
                    </div>
                    <% } %>


                </div>
            </div>
            <div class="tab-pane fade" id="frios" role="tabpanel" aria-labelledby="pills-profile-tab">
                <div class="row">


                    <%
                        ArrayList<Producto> lista3 = ProductoDB.obteneProductos3();
                        for (Producto p : lista3) {

                    %>
                    <div class="col-md-4 my-3 my-md-0">
                        <div class="card bg-transparent border">
                            <img src="img/<%= p.getImagen()%>" alt="" class="rounded-0 card-img-top mg-responsive">
                           <div class="card-body">
                                  <h1 class="text-center mb-4"><a href="anadirCarrito.jsp?id=<%= p.getCodigoProducto()%>" class="badge badge-primary">Añadir</a></h1>
                                <h4 class="text-center">S/.<%= p.getPrecio()%></h4>
                                <%

                                    if (sessionOK.getAttribute("perfil") != null && sessionOK.getAttribute("perfil").equals("trabajador")) {

                                %>
                                <h1 class="text-center mb-4"><a href="actualizarProducto.jsp?id=<%= p.getCodigoProducto()%>" class="badge badge-primary">Modificar</a></h1>
                                <% }%>

                                <h4 class="pt20 pb20"><%= p.getNombre()%></h4>
                                <p class="text-white"><%= p.getDescrip()%></p>
                            </div>
                        </div>
                    </div>
                    <% }%>


                </div>
            </div>
        </div>
    </div>
    <div id="home" class="header">

        <br>   <br>   <br>

        <!-- CONTACT Section  -->
        <div id="contact" class="container-fluid bg-dark text-light border-top wow fadeIn">
            <div class="row">
                <div class="col-md-6 px-0">

                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d15609.57670074642!2d-76.90746183634035!3d-12.016361558995072!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x9105c3c864ac48f5%3A0xed1bde4c798d786e!2sUTP!5e0!3m2!1ses-419!2spe!4v1697125700012!5m2!1ses-419!2spe" width="100%" height="100%" style="border:0; min-height: 400px;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>

                </div>
                <div class="col-md-6 px-5 has-height-lg middle-items">
                    <h3>CONTACTANOS</h3>
                    <p>Para obtener más información sobre nuestra empresa, visite nuestro sitio web o contáctenos por correo electrónico o teléfono. Estamos disponibles de lunes a viernes de 9:00 a.m. a 5:00 p.m., y los sábados de 9:00 a.m. a 1:00 p.m.</p>

                </div>
            </div>
        </div>

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





