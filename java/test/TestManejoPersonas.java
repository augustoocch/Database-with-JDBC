package test;

import datos.*;
import domain.*;
import java.util.*;

public class TestManejoPersonas {
    public static void main(String[] args) {
      
        PersonaDAO personaDAO = new PersonaDAO();
        //personaDAO.seleccionar();
        //List<Persona> personas = personaDAO.seleccionar();

        
        //insertando objeto en la base de datos       
        Persona persona1 = new Persona ("Carlos", "Esparza", "carl@gmail.com", "16776235");
        personaDAO.insertar(persona1);
        
        List<Persona> personas = personaDAO.seleccionar();
        personas.forEach (persona -> {
        System.out.println("Persona: " + persona);
        });
}

        /* funcion comun
        personas.forEach (persona -> {
        System.out.println("Persona: " + persona);
        }
        */

        
