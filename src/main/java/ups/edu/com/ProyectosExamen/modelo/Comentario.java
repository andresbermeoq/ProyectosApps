package ups.edu.com.ProyectosExamen.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Comentario", schema = "public")
@NamedQueries({
	@NamedQuery(name = "Comentario.findAll", query = "SELECT c FROM Comentario c ORDER BY c.comentarioId")
})
public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "id_comentario_seq", sequenceName = "id_comentario_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_comentario_seq")
	@Column(name = "comentario_id", updatable = false, unique = true, nullable = false)
	private int comentarioId;
	@Column(name = "comentario_String")
	private String comentarioString;
	
	@ManyToOne
	private Persona persona;

	
	public int getComentarioId() {
		return comentarioId;
	}

	public void setComentarioId(int comentarioId) {
		this.comentarioId = comentarioId;
	}

	public String getComentarioString() {
		return comentarioString;
	}

	public void setComentarioString(String comentarioString) {
		this.comentarioString = comentarioString;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	@Override
	public String toString() {
		return "Comentario [comentarioId=" + comentarioId + ", comentarioString=" + comentarioString + ", persona="
				+ persona + "]";
	}
	
	
	
	

	
}
