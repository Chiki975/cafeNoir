/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Utils.Conexion;
 import java.sql.*;
  import java.util.ArrayList;
public class ProductoDB {
     public static ArrayList<Producto> obteneProductos1(){
    ArrayList<Producto> lista=new ArrayList<Producto>(); 
        try {
            CallableStatement cl=Conexion.getConnection().prepareCall("select * from producto where categoria LIKE 'cafe negro'  and stock >0");
            ResultSet rs=cl.executeQuery();
            while (rs.next()) {
                Producto p=new Producto(rs.getInt(1),rs.getString(2),
                rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                lista.add(p);
            }
        } catch (Exception e) {}
    return lista;
    }
       public static ArrayList<Producto> obteneProductos2(){
    ArrayList<Producto> lista=new ArrayList<Producto>(); 
        try {
            CallableStatement cl=Conexion.getConnection().prepareCall("select * from producto where categoria LIKE 'Cafe con leche'  and stock >0");
            ResultSet rs=cl.executeQuery();
            while (rs.next()) {
                Producto p=new Producto(rs.getInt(1),rs.getString(2),
                rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                lista.add(p);
            }
        } catch (Exception e) {}
    return lista;
    }
        public static ArrayList<Producto> obteneProductos3(){
    ArrayList<Producto> lista=new ArrayList<Producto>(); 
        try {
            CallableStatement cl=Conexion.getConnection().prepareCall("select * from producto where categoria LIKE 'Cafe frio'  and stock >0");
            ResultSet rs=cl.executeQuery();
            while (rs.next()) {
                Producto p=new Producto(rs.getInt(1),rs.getString(2),
                rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
                lista.add(p);
            }
        } catch (Exception e) {}
    return lista;
    }
         public static Producto obteneProductos(int codigo){
    Producto p=null;
          try {
           CallableStatement cl=Conexion.getConnection().prepareCall("SELECT * FROM `producto` WHERE `codigoProducto` = ?");
           cl.setInt(1, codigo);
           ResultSet rs=cl.executeQuery();
            while (rs.next()) {
                p=new Producto(rs.getInt(1),rs.getString(2),
                rs.getDouble(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7));
            }
              
          } catch (Exception e) { }
    return p; 
    }
          
         public static boolean insertarProducto(Producto p){
       boolean rpta=false;
       
           try {
               Connection cn=Conexion.getConnection();
                CallableStatement cl=cn.prepareCall("{call sp_insertarPro(?,?,?,?,?,?)}");
               cl.setString(1, p.getNombre());
               cl.setDouble(2, p.getPrecio());
               cl.setString(3, p.getImagen());
                cl.setString(4, p.getDescrip());
                 cl.setString(5, p.getCategoria());
                cl.setInt(6, p.getStock());
               int i=cl.executeUpdate();
               if (i==1) {
                   rpta=true;
               }else{
                    rpta=false;
               }
                
           } catch (Exception e) {
           }
       
       return rpta;
       }
           public static boolean actualizarProductos(Producto varProducto){
       boolean rpta=false;
       
           try {
               Connection cn=Conexion.getConnection();
                CallableStatement cl=cn.prepareCall("{call sp_actualizarPro(?,?,?,?,?,?)}");
               cl.setInt(1, varProducto.getCodigoProducto());
               cl.setString(2, varProducto.getNombre());
               cl.setDouble(3, varProducto.getPrecio());
               cl.setString(4, varProducto.getDescrip());
               cl.setString(5, varProducto.getCategoria());
                cl.setInt(6, varProducto.getStock());
               int i=cl.executeUpdate();
               if (i==1) {
                   rpta=true;
               }else{
                    rpta=false;
               }
                
           } catch (Exception e) {
           }
       
       return rpta;
       }
       

}
