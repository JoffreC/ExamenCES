package modelo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import javax.persistence.Query;

import modelo.entidades.Persona;
import modelo.jpa.JPAGenericDAO;

public class PersonaDAO extends JPAGenericDAO<Persona, Integer>{
	protected static PersonaDAO personaDAO = new PersonaDAO();
	public PersonaDAO() {
		super(Persona.class);
	}
	public List<Persona> getAll(){
		String JPQL = "Select p FROM Persona p";
		Query consulta = this.em.createQuery(JPQL);
		List<Persona> personas = consulta.getResultList();
		return personas;
	}
	public static PersonaDAO getPersonaDAO() {
		return personaDAO;
	}
	

}
