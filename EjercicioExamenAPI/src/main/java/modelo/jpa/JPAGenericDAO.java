package modelo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class JPAGenericDAO<T, ID> {

	private Class<T> persistentClass;
	protected EntityManager em;
	
	public JPAGenericDAO(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ejercicioapi");
		this.em = emf.createEntityManager();
	} 
	
	public T getById(ID id) {
		return em.find(persistentClass, id);
	}

	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(T entity) {
		em.getTransaction().begin();
		try {			
			em.persist(entity);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Fallo en Create de JPA");
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
		
	}

	public void update(T entity) {
		em.getTransaction().begin();
		try {			
			em.merge(entity);
			em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Fallo en Actualizar de JPA");
			if(em.getTransaction().isActive())
				em.getTransaction().rollback();
		}
		
	}

	public void deleteById(ID id) {
		T entity =  this.getById(id);
		if(entity != null) {
			em.getTransaction().begin();
			try {
				em.remove(entity);
				em.getTransaction().commit();
			}catch(Exception e) {
				System.out.println("Error en Delete JPA");
				if(em.getTransaction().isActive())
					em.getTransaction().rollback();
			}
			
		}
			
		
	}

}