/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador;
import Modelo.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;
import Utils.Conexion;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author xibar
 */
@WebServlet(name = "ServletLogueo", urlPatterns = {"/ServletLogueo"})
public class ServletLogueo extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String accion = request.getParameter("accion");
           if (accion.equals("loguin")) {
          
               String usu=request.getParameter("txtUsu");
                String pas=request.getParameter("txtPass");
                try {
                    CallableStatement cl=Conexion.getConnection().prepareCall("{call sp_loguin(?,?)}");
                    cl.setString(1, usu);
                    cl.setString(2, pas);
                    ResultSet rs=cl.executeQuery();
                    if (rs.next()) {
                        HttpSession sessionOK=request.getSession();
                         sessionOK.setAttribute("codigo", (String)rs.getString(1));
                        sessionOK.setAttribute("perfil", (String)rs.getString(5));
                         sessionOK.setAttribute("nom", (String)rs.getString(3));
                          sessionOK.setAttribute("ape", (String)rs.getString(2));
                            sessionOK.setAttribute("dist", (String)rs.getString(4));
                             sessionOK.setAttribute("corr", (String)rs.getString(6));
                          request.getRequestDispatcher("index.jsp").forward(request, response);
                    }else{
                  request.setAttribute("msg", "Error de Usuario o Contraseña");
                     request.getRequestDispatcher("login.jsp").forward(request, response);
                    }
               } catch (Exception e) { System.out.println(e);
               }
           }else if (accion.equals("cerrar")) {
              HttpSession sessionOK=request.getSession();
               request.getSession().removeAttribute("codigo");
              request.getSession().removeAttribute("perfil");
               request.getSession().removeAttribute("nom");
                request.getSession().removeAttribute("ape");
                 request.getSession().removeAttribute("dist");
                request.getSession().removeAttribute("corr");
                sessionOK.invalidate();
                     request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if (accion.equals("cancelar")) {
              HttpSession sessionOK=request.getSession();
              request.getSession().removeAttribute("carrito");
              
                     request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if (accion.equals("eliminar")) {
        // Obtener el ID del producto a eliminar (debes adaptar esto según tu lógica)
    int idProductoAEliminar = Integer.parseInt(request.getParameter("idProducto"));

    // Obtener el ArrayList de DetalleVenta de la sesión
    HttpSession sesion = request.getSession();
    ArrayList<DetalleVenta> carrito = (ArrayList<DetalleVenta>) sesion.getAttribute("carrito");

    // Verificar si el carrito no es nulo
    if (carrito != null) {
        // Iterar sobre el carrito para encontrar el elemento con el ID específico y eliminarlo
        Iterator<DetalleVenta> iterator = carrito.iterator();
        while (iterator.hasNext()) {
            DetalleVenta item = iterator.next();
            // Supongamos que tienes un método getIdProducto() en DetalleVenta
            if (item.getCodigoProducto()== idProductoAEliminar) {
                iterator.remove();
                break; // Terminar el bucle una vez que se haya eliminado el elemento
            }
        }

        // Actualizar la sesión con el carrito modificado
        sesion.setAttribute("carrito", carrito);
    }

    // Redireccionar a la página principal
    request.getRequestDispatcher("registrarVenta.jsp").forward(request, response);
        }else if (accion.equals("nuevouser")) {
                boolean rpta=false;
                String nom=request.getParameter("Nombre");
                 String usus=request.getParameter("username");
                String distr=request.getParameter("distrito");
                String corr=request.getParameter("email");
                 String calv=request.getParameter("password");
       try {
           
             Connection cn=Conexion.getConnection();
                CallableStatement cl=cn.prepareCall("{call new_procedure(?,?,?,?,?)}");
               cl.setString(1, nom);
               cl.setString(2, usus);
               cl.setString(3, distr);
                cl.setString(4, corr);
                 cl.setString(5, calv);
            
               int i=cl.executeUpdate();
               if (i==1) {
                   rpta=true;
                   correoDB email=new correoDB();

 String de="poo.grupo1.2022@gmail.com";
String clave="hpoz fcah seti absv";
String para=corr;

    String mensaje="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
"<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
"<head>\n" +
"<!--[if gte mso 9]>\n" +
"<xml>\n" +
"  <o:OfficeDocumentSettings>\n" +
"    <o:AllowPNG/>\n" +
"    <o:PixelsPerInch>96</o:PixelsPerInch>\n" +
"  </o:OfficeDocumentSettings>\n" +
"</xml>\n" +
"<![endif]-->\n" +
"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"  <meta name=\"x-apple-disable-message-reformatting\">\n" +
"  <!--[if !mso]><!--><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><!--<![endif]-->\n" +
"  <title></title>\n" +
"  \n" +
"    <style type=\"text/css\">\n" +
"      @media only screen and (min-width: 620px) {\n" +
"  .u-row {\n" +
"    width: 600px !important;\n" +
"  }\n" +
"  .u-row .u-col {\n" +
"    vertical-align: top;\n" +
"  }\n" +
"\n" +
"  .u-row .u-col-33p33 {\n" +
"    width: 199.98px !important;\n" +
"  }\n" +
"\n" +
"  .u-row .u-col-100 {\n" +
"    width: 600px !important;\n" +
"  }\n" +
"\n" +
"}\n" +
"\n" +
"@media (max-width: 620px) {\n" +
"  .u-row-container {\n" +
"    max-width: 100% !important;\n" +
"    padding-left: 0px !important;\n" +
"    padding-right: 0px !important;\n" +
"  }\n" +
"  .u-row .u-col {\n" +
"    min-width: 320px !important;\n" +
"    max-width: 100% !important;\n" +
"    display: block !important;\n" +
"  }\n" +
"  .u-row {\n" +
"    width: 100% !important;\n" +
"  }\n" +
"  .u-col {\n" +
"    width: 100% !important;\n" +
"  }\n" +
"  .u-col > div {\n" +
"    margin: 0 auto;\n" +
"  }\n" +
"}\n" +
"body {\n" +
"  margin: 0;\n" +
"  padding: 0;\n" +
"}\n" +
"\n" +
"table,\n" +
"tr,\n" +
"td {\n" +
"  vertical-align: top;\n" +
"  border-collapse: collapse;\n" +
"}\n" +
"\n" +
"p {\n" +
"  margin: 0;\n" +
"}\n" +
"\n" +
".ie-container table,\n" +
".mso-container table {\n" +
"  table-layout: fixed;\n" +
"}\n" +
"\n" +
"* {\n" +
"  line-height: inherit;\n" +
"}\n" +
"\n" +
"a[x-apple-data-detectors='true'] {\n" +
"  color: inherit !important;\n" +
"  text-decoration: none !important;\n" +
"}\n" +
"\n" +
"table, td { color: #74ba3a; } @media (max-width: 480px) { #u_content_heading_1 .v-font-size { font-size: 44px !important; } #u_content_heading_1 .v-line-height { line-height: 100% !important; } #u_content_text_11 .v-container-padding-padding { padding: 10px 10px 20px !important; } }\n" +
"    </style>\n" +
"  \n" +
"  \n" +
"\n" +
"</head>\n" +
"\n" +
"<body class=\"clean-body u_body\" style=\"margin: 0;padding: 0;-webkit-text-size-adjust: 100%;background-color: #e7e7e7;color: #000000\">\n" +
"  <!--[if IE]><div class=\"ie-container\"><![endif]-->\n" +
"  <!--[if mso]><div class=\"mso-container\"><![endif]-->\n" +
"  <table style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;min-width: 320px;Margin: 0 auto;background-color: #e7e7e7;width:100%\" cellpadding=\"0\" cellspacing=\"0\">\n" +
"  <tbody>\n" +
"  <tr style=\"vertical-align: top\">\n" +
"    <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top\">\n" +
"    <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td align=\"center\" style=\"background-color: #e7e7e7;\"><![endif]-->\n" +
"    \n" +
"  \n" +
"  \n" +
"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
"  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
"    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
"      \n" +
"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #343a40;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\" valign=\"top\"><![endif]-->\n" +
"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
"  <div style=\"background-color: #343a40;height: 100%;width: 100% !important;\">\n" +
"  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;\"><!--<![endif]-->\n" +
"  \n" +
"<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
"  <tbody>\n" +
"    <tr>\n" +
"      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
"        \n" +
"<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"  <tr>\n" +
"    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
"    </td>\n" +
"  </tr>\n" +
"</table>\n" +
"\n" +
"      </td>\n" +
"    </tr>\n" +
"  </tbody>\n" +
"</table>\n" +
"\n" +
"<table id=\"u_content_heading_1\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
"  <tbody>\n" +
"    <tr>\n" +
"      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
"        \n" +
"  <!--[if mso]><table width=\"100%\"><tr><td><![endif]-->\n" +
"    <h1 class=\"v-line-height v-font-size\" style=\"margin: 0px; line-height: 50%; text-align: center; word-wrap: break-word; font-size: 46px; font-weight: 700;\"><span><span><span style=\"line-height: 23px;\"><span style=\"line-height: 23px;\"><span style=\"line-height: 23px;\">Hola "+nom+"</span></span></span></span></span></h1>\n" +
"  <!--[if mso]></td></tr></table><![endif]-->\n" +
"\n" +
"      </td>\n" +
"    </tr>\n" +
"  </tbody>\n" +
"</table>\n" +
"\n" +
"<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
"  <tbody>\n" +
"    <tr>\n" +
"      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
"        \n" +
"\n" +
"      </td>\n" +
"    </tr>\n" +
"  </tbody>\n" +
"</table>\n" +
"\n" +
"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
"  </div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
"    </div>\n" +
"  </div>\n" +
"  </div>\n" +
"  \n" +
"\n" +
"\n" +
"  \n" +
"  \n" +
"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
"  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
"    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
"      \n" +
"<!--[if (mso)|(IE)]><td align=\"center\" width=\"572\" style=\"background-color: #006b75;width: 572px;padding: 0px;border-top: 14px solid #343a40;border-left: 14px solid #343a40;border-right: 14px solid #343a40;border-bottom: 14px solid #343a40;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
"  <div style=\"background-color: #343a40;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
"  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 14px solid #343a40;border-left: 14px solid #343a40;border-right: 14px solid #343a40;border-bottom: 14px solid #343a40;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
"  \n" +
"<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
"  <tbody>\n" +
"    <tr>\n" +
"      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
"        \n" +
"\n" +
"      </td>\n" +
"    </tr>\n" +
"  </tbody>\n" +
"</table>\n" +
"\n" +
"<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
"  <tbody>\n" +
"    <tr>\n" +
"      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
"        \n" +
"\n" +
"      </td>\n" +
"    </tr>\n" +
"  </tbody>\n" +
"</table>\n" +
"\n" +
"<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
"  <tbody>\n" +
"    <tr>\n" +
"      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
"        \n" +
"\n" +
"      </td>\n" +
"    </tr>\n" +
"  </tbody>\n" +
"</table>\n" +
"\n" +
"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
"  </div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
"    </div>\n" +
"  </div>\n" +
"  </div>\n" +
"  \n" +
"\n" +
"\n" +
"  \n" +
"  \n" +
"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
"  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
"    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
"      \n" +
"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #343a40;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
"  <div style=\"background-color: #343a40;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
"  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
"  \n" +
"<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
"  <tbody>\n" +
"    <tr>\n" +
"      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
"        \n" +
"  <div class=\"v-line-height v-font-size\" style=\"font-size: 22px; line-height: 140%; text-align: center; word-wrap: break-word;\">\n" +
"    <p style=\"line-height: 140%;\">BIENVENIDO A LA COMUNIDAD DE CAFENOIR</p>\n" +
"  </div>\n" +
"\n" +
"      </td>\n" +
"    </tr>\n" +
"  </tbody>\n" +
"</table>\n" +
"\n" +
"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
"  </div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
"    </div>\n" +
"  </div>\n" +
"  </div>\n" +
"  \n" +
"\n" +
"\n" +
"  \n" +
"  \n" +
"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
"  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
"    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
"      \n" +
"<!--[if (mso)|(IE)]><td align=\"center\" width=\"184\" style=\"background-color: #61eaf6;width: 184px;padding: 0px;border-top: 8px solid #343a40;border-left: 8px solid #343a40;border-right: 8px solid #343a40;border-bottom: 8px solid #343a40;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
"<div class=\"u-col u-col-33p33\" style=\"max-width: 320px;min-width: 200px;display: table-cell;vertical-align: top;\">\n" +
"  <div style=\"background-color: #343a40;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
"  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 8px solid #343a40;border-left: 8px solid #343a40;border-right: 8px solid #343a40;border-bottom: 8px solid #343a40;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
"  \n" +
"<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
"  <tbody>\n" +
"    <tr>\n" +
"      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
"        \n" +
"<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"  <tr>\n" +
"    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
"    </td>\n" +
"  </tr>\n" +
"</table>\n" +
"\n" +
"      </td>\n" +
"    </tr>\n" +
"  </tbody>\n" +
"</table>\n" +
"\n" +
"\n" +
"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
"  </div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
"<!--[if (mso)|(IE)]><td align=\"center\" width=\"190\" style=\"background-color: #61eaf6;width: 190px;padding: 0px;border-top: 8px solid #343a40;border-left: 2px solid #343a40;border-right: 8px solid #343a40;border-bottom: 8px solid #343a40;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
"<div class=\"u-col u-col-33p33\" style=\"max-width: 320px;min-width: 200px;display: table-cell;vertical-align: top;\">\n" +
"  <div style=\"background-color: #343a40;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
"  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 8px solid #343a40;border-left: 2px solid #343a40;border-right: 8px solid #343a40;border-bottom: 8px solid #343a40;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
"  \n" +

"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
"  </div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
"<!--[if (mso)|(IE)]><td align=\"center\" width=\"190\" style=\"background-color: #61eaf6;width: 190px;padding: 0px;border-top: 8px solid #343a40;border-left: 2px solid #343a40;border-right: 8px solid #343a40;border-bottom: 8px solid #343a40;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
"<div class=\"u-col u-col-33p33\" style=\"max-width: 320px;min-width: 200px;display: table-cell;vertical-align: top;\">\n" +
"  <div style=\"background-color: #343a40;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
"  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 8px solid #343a40;border-left: 2px solid #343a40;border-right: 8px solid #343a40;border-bottom: 8px solid #343a40;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
"  \n" +
"<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
"  <tbody>\n" +
"    <tr>\n" +
"      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
"        \n" +
"<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
"  <tr>\n" +
"    <td style=\"padding-right: 0px;padding-left: 0px;\" align=\"center\">\n" +
"    </td>\n" +
"  </tr>\n" +
"</table>\n" +
"\n" +
"      </td>\n" +
"    </tr>\n" +
"  </tbody>\n" +
"</table>\n" +
"\n" +

"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
"  </div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
"    </div>\n" +
"  </div>\n" +
"  </div>\n" +
"  \n" +
"\n" +
"\n" +
"  \n" +
"  \n" +
"<div class=\"u-row-container\" style=\"padding: 0px;background-color: transparent\">\n" +
"  <div class=\"u-row\" style=\"margin: 0 auto;min-width: 320px;max-width: 600px;overflow-wrap: break-word;word-wrap: break-word;word-break: break-word;background-color: transparent;\">\n" +
"    <div style=\"border-collapse: collapse;display: table;width: 100%;height: 100%;background-color: transparent;\">\n" +
"      <!--[if (mso)|(IE)]><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\"><tr><td style=\"padding: 0px;background-color: transparent;\" align=\"center\"><table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" style=\"width:600px;\"><tr style=\"background-color: transparent;\"><![endif]-->\n" +
"      \n" +
"<!--[if (mso)|(IE)]><td align=\"center\" width=\"600\" style=\"background-color: #006b75;width: 600px;padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\" valign=\"top\"><![endif]-->\n" +
"<div class=\"u-col u-col-100\" style=\"max-width: 320px;min-width: 600px;display: table-cell;vertical-align: top;\">\n" +
"  <div style=\"background-color: #74ba3a;height: 100%;width: 100% !important;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\">\n" +
"  <!--[if (!mso)&(!IE)]><!--><div style=\"box-sizing: border-box; height: 100%; padding: 0px;border-top: 0px solid transparent;border-left: 0px solid transparent;border-right: 0px solid transparent;border-bottom: 0px solid transparent;border-radius: 0px;-webkit-border-radius: 0px; -moz-border-radius: 0px;\"><!--<![endif]-->\n" +
"  \n" +
"<table id=\"u_content_text_11\" style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
"  <tbody>\n" +
"    <tr>\n" +
"      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:10px 100px 30px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
"        \n" +
"  <div class=\"v-line-height v-font-size\" style=\"font-size: 14px; color: #ffffff; line-height: 170%; text-align: center; word-wrap: break-word;\">\n" +
"    <p style=\"line-height: 170%;\">CAFENOIR DESDE LAS RAICEZ HASTA TUS MANOS</p>\n" +
"  </div>\n" +
"\n" +
"      </td>\n" +
"    </tr>\n" +
"  </tbody>\n" +
"</table>\n" +
"\n" +
"<table style=\"font-family:arial,helvetica,sans-serif;\" role=\"presentation\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n" +
"  <tbody>\n" +
"    <tr>\n" +
"      <td class=\"v-container-padding-padding\" style=\"overflow-wrap:break-word;word-break:break-word;padding:0px;font-family:arial,helvetica,sans-serif;\" align=\"left\">\n" +
"        \n" +
"  <table height=\"0px\" align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"border-collapse: collapse;table-layout: fixed;border-spacing: 0;mso-table-lspace: 0pt;mso-table-rspace: 0pt;vertical-align: top;border-top: 1px solid #BBBBBB;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
"    <tbody>\n" +
"      <tr style=\"vertical-align: top\">\n" +
"        <td style=\"word-break: break-word;border-collapse: collapse !important;vertical-align: top;font-size: 0px;line-height: 0px;mso-line-height-rule: exactly;-ms-text-size-adjust: 100%;-webkit-text-size-adjust: 100%\">\n" +
"          <span>&#160;</span>\n" +
"        </td>\n" +
"      </tr>\n" +
"    </tbody>\n" +
"  </table>\n" +
"\n" +
"      </td>\n" +
"    </tr>\n" +
"  </tbody>\n" +
"</table>\n" +
"\n" +
"  <!--[if (!mso)&(!IE)]><!--></div><!--<![endif]-->\n" +
"  </div>\n" +
"</div>\n" +
"<!--[if (mso)|(IE)]></td><![endif]-->\n" +
"      <!--[if (mso)|(IE)]></tr></table></td></tr></table><![endif]-->\n" +
"    </div>\n" +
"  </div>\n" +
"  </div>\n" +
"  \n" +
"\n" +
"\n" +
"    <!--[if (mso)|(IE)]></td></tr></table><![endif]-->\n" +
"    </td>\n" +
"  </tr>\n" +
"  </tbody>\n" +
"  </table>\n" +
"  <!--[if mso]></div><![endif]-->\n" +
"  <!--[if IE]></div><![endif]-->\n" +
"</body>\n" +
"\n" +
"</html>";
 
String asunto="NUEVO INTEGRANTE A LA FAMILIA ";

boolean resultado= email.enviarcorreo(de, clave, para, mensaje, asunto);


                     request.getRequestDispatcher("login.jsp").forward(request, response);
               }else{
                    rpta=false;
               }
                
           } catch (Exception e) {
           }
       
        }
        
        
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
