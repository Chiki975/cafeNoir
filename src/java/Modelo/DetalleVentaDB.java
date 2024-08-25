/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Utils.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author xibar
 */
public class DetalleVentaDB {
        
    public static ArrayList<consulta> obtenerdetalleVenta(int num){
     ArrayList<consulta> lista =new ArrayList<consulta>();
     
        try {
                          Connection cn=Conexion.getConnection();

             CallableStatement cl=cn.prepareCall("{call sp_detalleVenta(?)}");
             cl.setInt(1, num);
              ResultSet rs=cl.executeQuery();
              while (rs.next()) {                
                consulta v=new consulta(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4));
                lista.add(v);
            }
        } catch (Exception e) {
        }
     
     
     
     return lista;
     }


}
