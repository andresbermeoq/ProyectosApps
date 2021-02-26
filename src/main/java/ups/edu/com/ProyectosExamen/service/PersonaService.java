package ups.edu.com.ProyectosExamen.service;

import javax.ws.rs.Produces;

import java.util.List;

import javax.ejb.EJBException;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import ups.edu.com.ProyectosExamen.DAO.PersonaDAO;
import ups.edu.com.ProyectosExamen.modelo.Persona;
import ups.edu.com.ProyectosExamen.token.ResultadoToken;
import ups.edu.com.ProyectosExamen.token.UsuarioToken;

@Path("users")
public class PersonaService {
	
	@Inject
	private PersonaDAO personaDao;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login")
	public ResultadoToken loginUser(UsuarioToken isUsuarioToken) {
		try {
			Persona persona = personaDao.findPersona(isUsuarioToken.getEmail(), isUsuarioToken.getPassword());
			return new ResultadoToken("200", persona);
					
		} catch (EJBException ex) {
			return new ResultadoToken("100", "NO AUTORIZADO");
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public List<Persona> allPersonas() {
		return personaDao.findAllPersons();
	}
	
	
	

	

}
