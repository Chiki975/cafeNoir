
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.*"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/stylesventa.css" rel="stylesheet" type="text/css" media="all" />


   <link href="css/sb-admin-2.min.css" rel="stylesheet">
   
       <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    </head>
    <body>
   
        
        
        
        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Nombre</th>
                                          
                                            <th>Cantidad</th>
                                            <th>Descuento</th>
                                            
                                          
                                        </tr>
                                    </thead>
                                 
                                    <tbody>
          <% 
                                  ArrayList<consulta> lista =DetalleVentaDB.obtenerdetalleVenta(Integer.parseInt(request.getParameter("cod")));
                                  for(int i=0;i<lista.size();i++){
                                  consulta d=lista.get(i);
              
                       
                        %>

        
        
                           
                                        
                                                    <tr>
                                            <td><%=d.getNombrepro()%></td>
                                            
                                            <td><%=d.getCantidad()%></td>
                                            <td><%=d.getDescuento()%></td>
                                       
                                       </tr>	
                                       
                           
                         <% 
                             }
                        
                        %>
                          </tbody>
                                </table>
                            </div>
                        </div>
                        
         
    </body>
</html>
