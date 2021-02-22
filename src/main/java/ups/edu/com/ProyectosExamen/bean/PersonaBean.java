package ups.edu.com.ProyectosExamen.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.com.ProyectosExamen.DAO.PersonaDAO;
import ups.edu.com.ProyectosExamen.gestion.GestionComentariosON;
import ups.edu.com.ProyectosExamen.modelo.Comentario;
import ups.edu.com.ProyectosExamen.modelo.Persona;

@Named
@RequestScoped
public class PersonaBean {
	
	@Inject
	private PersonaDAO personaDAO;
	
	private Persona persona;
	private Comentario comentario;
	
	@PostConstruct
	private void Init() {
		persona = new Persona();
		comentario = new Comentario();
	}
	
	
	public Comentario getComentario() {
		return comentario;
	}

	public void setComentario(Comentario comentario) {
		this.comentario = comentario;
	}
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	public PersonaDAO getPersonaDAO() {
		return personaDAO;
	}


	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}
	
	public String saveUser() {
		personaDAO.savePerson(persona);
		return "Persona Guardada";
	}
	
	public List<Persona> allUsers(){
		return personaDAO.findAllPersons();
	}
	
	
	
	
	
	

}
