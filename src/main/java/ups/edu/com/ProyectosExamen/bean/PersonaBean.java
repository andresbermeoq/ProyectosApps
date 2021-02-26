package ups.edu.com.ProyectosExamen.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.com.ProyectosExamen.DAO.ComentarioDAO;
import ups.edu.com.ProyectosExamen.DAO.PersonaDAO;
import ups.edu.com.ProyectosExamen.modelo.Comentario;
import ups.edu.com.ProyectosExamen.modelo.Persona;
import ups.edu.com.ProyectosExamen.utils.SessionUtils;

@Named
@RequestScoped
public class PersonaBean {
	
	@Inject
	private PersonaDAO personaDAO;
	
	@Inject
	private ComentarioDAO comentarioDAO;
	
	private Persona persona;
	private Persona personaLogeada;
	private Comentario comentario;
	
	@PostConstruct
	private void Init() {
		personaLogeada = SessionUtils.getInfoUsuarioLogeado();
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

	
	public Persona getPersonaLogeada() {
		return personaLogeada;
	}


	public void setPersonaLogeada(Persona personaLogeada) {
		this.personaLogeada = personaLogeada;
	}
	
	
	public ComentarioDAO getComentarioDAO() {
		return comentarioDAO;
	}


	public void setComentarioDAO(ComentarioDAO comentarioDAO) {
		this.comentarioDAO = comentarioDAO;
	}


	public String saveUser() {
		personaDAO.savePerson(persona);
		return "Persona Guardada";
	}
	
	public List<Persona> allUsers(){
		return personaDAO.findAllPersons();
	}
	
	public String writeComment() {
		comentario.setPersona(personaLogeada);
		comentarioDAO.saveComment(comentario);
		return null;
	}
	
	public List<Comentario> allComentarios() {
		List<Comentario> comentarios = new ArrayList<Comentario>();
		comentarios = comentarioDAO.findAllComments();
		System.out.println("Aqui estan los comentarios" + comentarios);
		return comentarios;
	}

}
