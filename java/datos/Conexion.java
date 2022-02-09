package datos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

//SE TOMAN LOS DATOS
public class Conexion {
    
private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
private static final String JDBC_USER = "root";
private static final String JDBC_PASSWORD = "xxxxx";


//SE CONECTA A LA BASE DE DATOS
public static Connection getConnection () throws SQLException{
    

       return DriverManager.getConnection(JDBC_URL, JDBC_URL, JDBC_PASSWORD);
    }


public static void close (ResultSet rs) throws SQLException{
    
    rs.close();
}

public static void close (Statement st) throws SQLException {
    
    st.close();
}

public static void close (PreparedStatement st) throws SQLException {
  
    st.close();
}
public static void close (Connection cn) throws SQLException {
   
    cn.close();
}
    
}
