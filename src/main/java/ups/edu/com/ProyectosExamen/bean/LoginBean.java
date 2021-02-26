package ups.edu.com.ProyectosExamen.bean;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ups.edu.com.ProyectosExamen.DAO.PersonaDAO;
import ups.edu.com.ProyectosExamen.modelo.Persona;
import ups.edu.com.ProyectosExamen.utils.SessionUtils;

@Named
@RequestScoped
public class LoginBean {

	@Inject
	private PersonaDAO personaDAO;
	private Persona persona;
	
	private String password, email;
	
	
	@PostConstruct
	public void init() {
		persona = new Persona();
	}


	public PersonaDAO getPersonaDAO() {
		return personaDAO;
	}


	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String validate() {
		try {
			persona = personaDAO.findPersona(email, password);
			SessionUtils.setInfoUsuarioLogeado(persona);
			return "Comentario.xhtml";
		} catch (Exception e) {
			email = "";
			password = "";
		}
		return null;
	}
	
	public String inValidate() {
		SessionUtils.getSession().invalidate();
		return "Login.xhtml";
	}

}
