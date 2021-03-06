package ups.edu.com.ProyectosExamen.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Persona", schema = "public")
@NamedQueries({
	@NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p ORDER BY p.personaId")
})
public class Persona implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "id_persona_seq", sequenceName = "id_persona_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_persona_seq")
	@Column(name = "persona_id", updatable = false, unique = true, nullable = false)
	private int personaId;
	@Column(name = "persona_nombre")
	private String personaNombre;
	@Column(name = "persona_password")
	private String personaPassword;
	@Column(name = "persona_email")
	private String personaEmail;
	
	public int getPersonaId() {
		return personaId;
	}


	public void setPersonaId(int personaId) {
		this.personaId = personaId;
	}


	public String getPersonaNombre() {
		return personaNombre;
	}


	public void setPersonaNombre(String personaNombre) {
		this.personaNombre = personaNombre;
	}


	public String getPersonaPassword() {
		return personaPassword;
	}


	public void setPersonaPassword(String personaPassword) {
		this.personaPassword = personaPassword;
	}

	public String getPersonaEmail() {
		return personaEmail;
	}


	public void setPersonaEmail(String personaEmail) {
		this.personaEmail = personaEmail;
	}


	@Override
	public String toString() {
		return "Persona [personaId=" + personaId + ", personaNombre=" + personaNombre + ", personaPassword="
				+ personaPassword + ", personaEmail=" + personaEmail + "]";
	}

	
	
	
	
	
	

	
	
	
	
	

}
