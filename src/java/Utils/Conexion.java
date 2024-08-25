/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Utils;
import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    
  public static Connection getConnection(){
        Connection cn=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdventa?useUnicode=true&characterEncoding=UTF-8", "root", "");
         System.out.println("conexion correcta");
        } catch (Exception e) {
            System.out.println("Error de conexion"+e);
        }
        return cn;
    }
  

}
