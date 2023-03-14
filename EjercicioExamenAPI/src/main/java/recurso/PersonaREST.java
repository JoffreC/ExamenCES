package recurso;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import modelo.dao.PersonaDAO;
//import modelo.dao.DAOFactory;
import modelo.entidades.Persona;

@Path("/personas")
public class PersonaREST {
	private PersonaDAO personaDAO = new PersonaDAO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Persona> getPersonas(){
		return personaDAO.getAll();
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	//http://localhost:8080/nombre_proyecto/peresonas/3
	public Persona getPersonaByPathParam(@PathParam("id")int id) {
		return personaDAO.getById(id);
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/query")
	//http://localhost:8080/nombre_proyecto/peresonas/query?id=3
	public Persona getPersonaByQueryParam(@QueryParam("id")int id) {
		return personaDAO.getById(id);
	}
	
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/add")
	public boolean crearPersona(Persona p) {
		boolean bandera = true;
		try {			
			personaDAO.create(p);
		}catch(Exception ex) {
			bandera = false;
		}
		return bandera;
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update")
	public boolean actualizarPersona (Persona p) {
		boolean bandera = true;
		try {			
			personaDAO.update(p);
		}catch(Exception ex) {
			bandera = false;
		}
		return bandera;
	}
	
	
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{id}")
	public boolean eliminarPersona (@PathParam("id") int id) {
		boolean bandera = true;
		try {			
			personaDAO.deleteById(id);
		}catch(Exception ex) {
			bandera = false;
		}
		return bandera;
	}
}