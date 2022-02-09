package datos;

import static datos.Conexion.*;
import java.util.List;
import domain.*;
import java.sql.*;
import java.util.ArrayList;

public class PersonaDAO {
   
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM test.persona";
    private static final String SQL_INSERT = "INSERT INTO test.persona(nombre, apellido, email, telefono) VALUES (?, ?, ?, ?) ";
    private static final String SQL_UPDATE = "UPDATE test.persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?;";
    private static final String SQL_DELETE = "DELETE FROM test.persona WHERE id_persona= ? ;";

    public List <Persona> seleccionar () {

    Connection con = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Persona persona = null;
    List <Persona> personas = new ArrayList<>();
    
        try {
            con = getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stmt);
                Conexion.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return personas;
    }

public int insertar (Persona persona) {
    
    Connection con = null;
    PreparedStatement stmt = null;
    int registros = 0;
    try {
        //se asignan los valores
        con = getConnection();
        stmt = con.prepareStatement(SQL_INSERT);
        stmt.setString(1, persona.getNombre());
        stmt.setString(2, persona.getApellido());
        stmt.setString(3, persona.getEmail());
        stmt.setString(4, persona.getTelefono());
        //se ejecuta el update de la base de datos 
        registros =stmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
      try {
          Conexion.close(stmt);
          Conexion.close(con);
      }  catch (SQLException ex) {
          ex.printStackTrace();
      }
    }
      return registros;
}

public int actualizar (Persona persona) {
    
    Connection con = null;
    PreparedStatement stmt = null;
    int actualizacion = 0;
    try {
        con = getConnection();
        stmt = con.prepareStatement(SQL_UPDATE);
        stmt.setString(1, persona.getNombre());
        stmt.setString(2, persona.getApellido());
        stmt.setString(3, persona.getEmail());
        stmt.setString(4, persona.getTelefono());
        stmt.setInt(5, persona.getIdPersona());
        
        actualizacion = stmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
    } finally {
        try {
           Conexion.close(stmt);
           Conexion.close(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return actualizacion;
    }
}

public int eliminar (Persona persona) {
    
    Connection con = null;
    PreparedStatement stmt = null;
    int borrar = 0;
    
    try {
        con = getConnection();
        stmt = con.prepareStatement(SQL_DELETE);
        stmt.setInt(1, persona.getIdPersona());
        
        borrar = stmt.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        try { 
            Conexion.close(stmt);
            Conexion.close(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return borrar;
}

}