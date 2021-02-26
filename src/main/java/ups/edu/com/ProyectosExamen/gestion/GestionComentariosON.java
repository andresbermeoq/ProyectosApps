package ups.edu.com.ProyectosExamen.gestion;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.QueryParam;

import ups.edu.com.ProyectosExamen.DAO.ComentarioDAO;
import ups.edu.com.ProyectosExamen.DAO.PersonaDAO;
import ups.edu.com.ProyectosExamen.modelo.Comentario;
import ups.edu.com.ProyectosExamen.modelo.Persona;

@Stateless
public class GestionComentariosON implements PersonaDAO, ComentarioDAO {
	
	@PersistenceContext(name = "ProyectosExamenPersistenceUnit")
	private EntityManager entityManager;

	@Override
	public boolean savePerson(Persona isPersona) {
		entityManager.persist(isPersona);
		entityManager.flush();
		return true;
	}

	@Override
	public List<Persona> findAllPersons() {
		return entityManager.createNamedQuery("Persona.findAll").getResultList();
	}

	@Override
	public boolean saveComment(Comentario isComentario) {
		entityManager.persist(isComentario);
		entityManager.flush();
		return true;
	}

	@Override
	public List<Comentario> findAllComments() {
		return entityManager.createNamedQuery("Comentario.findAll").getResultList();
	}

	@Override
	public Comentario findCommentByPerson(Persona isPersona) {
		Query query = entityManager.createQuery("FROM Comentario c WHERE c.persona = :Persona ");
		query.setParameter("Persona", isPersona);
		return (Comentario) query.getSingleResult();
	}

	@Override
	public List<Comentario> findAllCommentsByUser(Persona isPersona) {
		Query query = entityManager.createQuery("FROM Comentario c WHERE c.persona = :Persona");
		query.setParameter("Persona", isPersona);
		return query.getResultList();
	}

	@Override
	public Persona findPersona(String email, String password) {
		Query query = entityManager.createQuery("FROM Persona p WHERE p.personaEmail = :email AND p.personaPassword = :password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		return (Persona) query.getSingleResult();
	}

	@Override
	public boolean findPersonaClient(String email, String password) {
		Query query = entityManager.createQuery("FROM Persona p WHERE p.personaEmail = :email AND p.personaPassword = :password");
		query.setParameter("email", email);
		query.setParameter("password", password);
		return true;
	}
	
	

}
