package test;

import java.sql.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestMysqlJDBC {
    public static void main(String[] args) throws SQLException {
        
    String url = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";     
        
    
        try {
           // Class.forName("com.mysql.cj.jdbc.Driver"); /LINEA NO REQUERIDA EN ULTIMAS VERSIONES
           Connection conexion = DriverManager.getConnection(url, "root", "xxxxx");
           Statement instruccion = conexion.createStatement();
           //se da la instruccion
           var sql = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
           ResultSet resultado = instruccion.executeQuery(sql);
           while (resultado.next()) {
               System.out.print("ID persona: " + resultado.getInt("id_persona"));
               System.out.print(", Nombre: " + resultado.getString("nombre") + " ");
               System.out.print(", Apellido: " + resultado.getString("apellido") + " ");
               System.out.println(", email: " + resultado.getString("email") + " ");
               System.out.print(", telefono" + resultado.getString("telefono: ") + " - ");
           }
           resultado.close();
           conexion.close();
           instruccion.close();
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
 
}
 
