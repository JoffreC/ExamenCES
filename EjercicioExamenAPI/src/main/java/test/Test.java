package test;

import java.util.List ;

import modelo.dao.PersonaDAO;
import modelo.entidades.Persona;

public class Test {

	public static void main(String[] args) {
		PersonaDAO personaDAO = new PersonaDAO();

		Persona nestor = new Persona();
		nestor.setClave("nestor123");
		nestor.setNombre("Nestor");
		personaDAO.create(nestor);
	
	}

}
