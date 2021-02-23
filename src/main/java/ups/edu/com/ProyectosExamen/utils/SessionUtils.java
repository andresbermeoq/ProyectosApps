package ups.edu.com.ProyectosExamen.utils;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ups.edu.com.ProyectosExamen.modelo.Persona;

public class SessionUtils {
	
	 public static String INFO_USER = "infoUsuario";

	    public static HttpSession getSession() {
	        return (HttpSession) FacesContext.getCurrentInstance()
	                .getExternalContext().getSession(false);
	    }

	    public static HttpServletRequest getRequest() {
	        return (HttpServletRequest) FacesContext.getCurrentInstance()
	                .getExternalContext().getRequest();
	    }

	    public static HttpServletResponse getResponse() {
	        return (HttpServletResponse) FacesContext.getCurrentInstance()
	                .getExternalContext().getResponse();
	    }

	    public static void setInfoUsuarioLogeado(Persona infoUusario){
	        getSession().setAttribute(INFO_USER, infoUusario);
	    }

	    public static Persona getInfoUsuarioLogeado(){
	        return (Persona) getSession().getAttribute(INFO_USER);
	    }

	    public static long getIdUsuarioLogeado() {
	       return ((Persona) getSession().getAttribute(INFO_USER)).getPersonaId();
	    }

}
