package test;

import datos.*;
import domain.*;
import java.util.*;

public class TestManejoPersonas {
    public static void main(String[] args) {
      
        PersonaDAO personaDAO = new PersonaDAO();
        //personaDAO.seleccionar();
        //List<Persona> personas = personaDAO.seleccionar();

        
              
        Persona persona1 = new Persona (1, "Julia", "Dart", "judar@gmail.com", "16776235");
        personaDAO.actualizar(persona1);
        
        /*
        
        //Insertando objeto en la base de datos       
        Persona persona1 = new Persona ("Carlos", "Esparza", "carl@gmail.com", "16776235");
        personaDAO.insertar(persona1);
        
        //Modificando objeto en la base de datos       
        Persona persona1 = new Persona (11, "Shubert", "Esparza", "carl@gmail.com", "16776235");
        personaDAO.actualizar(persona1);
        
        //Borrando objeto en la base de Datos
        persona1 = new Persona ("1");
        personaDAO.eliminar(persona1);
        */

        
        //List<Persona> personas = personaDAO.seleccionar();
        //personas.forEach (persona -> {
        //System.out.println("Persona: " + persona);
        //});
}

        
