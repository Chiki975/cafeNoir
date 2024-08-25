/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Utils.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

/**
 *
 * @author xibar
 */
public class VentaDB {
      public static boolean insertarVenta(Venta verVenta,ArrayList<DetalleVenta> d){
     boolean rpta=false;
     
         try {
              Connection cn=Conexion.getConnection();
                CallableStatement cl=cn.prepareCall("{call sp_registrarVenta(?,?,?,?,?,?,0)}");
                cl.registerOutParameter(1, Types.INTEGER);
                cl.setInt(2, verVenta.getCodusu());
                cl.setString(3, verVenta.getCliente());
                  cl.setString(4, verVenta.getFchreser());
                    cl.setString(5, verVenta.getHrareser());
                      cl.setString(6, verVenta.getObser());
                int i=cl.executeUpdate();
                int i2=0;
                verVenta.setCodigoVenta(cl.getInt(1));
                                CallableStatement cl2=cn.prepareCall("{call sp_registrarDetalle(?,?,?,?)}");

                   for (DetalleVenta aux:d) {
                cl2.setInt(1, verVenta.getCodigoVenta());
                 cl2.setInt(2, aux.getCodigoProducto());
                  cl2.setDouble(3, aux.getCantidad());
                   cl2.setDouble(4, aux.getDescuento());
                   i2=cl2.executeUpdate();
                 
                 
             }
                   if (i2==1) {
                 rpta=true;
             }
         } catch (Exception e) {
         }
     
     return rpta;
     
     
     
     }
     
     public static ArrayList<Venta> obtenerventas(){
     ArrayList<Venta> lista =new ArrayList<Venta>();
         try {
              CallableStatement cl=Conexion.getConnection().prepareCall("select * from venta where estado = 0");
              ResultSet rs=cl.executeQuery();
              while (rs.next()) {
                  Venta v=new Venta(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getTimestamp(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                 lista.add(v);
             }
         } catch (Exception e) { System.out.println("ventas"+e);
         }
     return lista;
     
     }
      public static ArrayList<Venta> obtenerventasprepa(){
     ArrayList<Venta> listaprepa =new ArrayList<Venta>();
         try {
              CallableStatement cl=Conexion.getConnection().prepareCall("select * from venta where estado = 1");
              ResultSet rs=cl.executeQuery();
              while (rs.next()) {
                  Venta v=new Venta(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getTimestamp(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                 listaprepa.add(v);
             }
         } catch (Exception e) { System.out.println("ventas"+e);
         }
     return listaprepa;
     
     }
      public static Venta obteneventa(int codigo){
    Venta v=null;
          try {
           CallableStatement cl=Conexion.getConnection().prepareCall("{call sp_ventaCod(?)}");
           cl.setInt(1, codigo);
           ResultSet rs=cl.executeQuery();
            while (rs.next()) {
                v=new Venta(rs.getInt(1), rs.getString(2),rs.getTimestamp(3));
            }
              
          } catch (Exception e) { }
    return v; 
    }
     
      public static boolean realizadoventa(int cod){
     boolean rpta=false;
     
         try {
                Connection cn=Conexion.getConnection();
                CallableStatement cl=Conexion.getConnection().prepareCall("{call sp_realizado(?)}");
           cl.setInt(1, cod);
                int i=cl.executeUpdate();
                 if (i==1) {
                   rpta=true;
               }else{
                    rpta=false;
               }
                 
             }
                
         catch (Exception e) {
         }
     
     return rpta;
     
     
     
     }
      
      
        public static ArrayList<Venta> obteneventacod(int n){
     ArrayList<Venta> lista =new ArrayList<Venta>();
         try {
              CallableStatement cl=Conexion.getConnection().prepareCall("{call sp_compracod(?)}");
               cl.setInt(1, n);
              ResultSet rs=cl.executeQuery();
              while (rs.next()) {
                  Venta v=new Venta(rs.getInt(1),rs.getInt(2), rs.getString(3),rs.getTimestamp(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(8));
                 lista.add(v);
             }
         } catch (Exception e) { System.out.println("ventas"+e);
         }
     return lista;
     
     }
     
        
    
}
