/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Utils.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author xibar
 */
public class usuariobd {
    
     public static ArrayList<Usuario> obtenerusu(int codigo){
    ArrayList<Usuario> lista=new ArrayList<Usuario>(); 
        try {
            CallableStatement cl=Conexion.getConnection().prepareCall("SELECT * FROM usuarios WHERE codUsu = ?");
              cl.setInt(1, codigo);
       ResultSet rs=cl.executeQuery();

            while (rs.next()) {
                Usuario p=new Usuario(rs.getInt(1),rs.getString(2),
                rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
                lista.add(p);
            }
        } catch (Exception e) {}
    return lista;
    }
}
