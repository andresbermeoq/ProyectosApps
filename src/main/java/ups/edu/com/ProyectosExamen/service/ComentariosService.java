package ups.edu.com.ProyectosExamen.service;

import java.util.List;

import javax.inject.Inject;
import javax.json.bind.annotation.JsonbProperty;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ups.edu.com.ProyectosExamen.DAO.ComentarioDAO;
import ups.edu.com.ProyectosExamen.modelo.Comentario;

@Path("comentarios")
public class ComentariosService {
	
	@Inject
	private ComentarioDAO comentarioDAO;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/all")
	public List<Comentario> allComentarios() {
		return comentarioDAO.findAllComments();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response writeComentario(Comentario isComentario) {
		try {
			comentarioDAO.saveComment(isComentario);
			return Response.ok().entity(isComentario).build();
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}

}
