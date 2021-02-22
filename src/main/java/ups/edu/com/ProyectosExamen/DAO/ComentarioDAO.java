package ups.edu.com.ProyectosExamen.DAO;

import java.util.List;

import ups.edu.com.ProyectosExamen.modelo.Comentario;
import ups.edu.com.ProyectosExamen.modelo.Persona;

public interface ComentarioDAO {
	
	public boolean saveComment(Comentario isComentario);
	public List<Comentario> findAllComments();
	public Comentario findCommentByPerson(Persona isPersona);
	public List<Comentario> findAllCommentsByUser(Persona isPersona);

}
