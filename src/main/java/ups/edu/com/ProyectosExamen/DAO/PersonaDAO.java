package ups.edu.com.ProyectosExamen.DAO;

import java.util.List;

import ups.edu.com.ProyectosExamen.modelo.Persona;

public interface PersonaDAO {
	public boolean savePerson(Persona isPersona);
	public List<Persona> findAllPersons();
}
