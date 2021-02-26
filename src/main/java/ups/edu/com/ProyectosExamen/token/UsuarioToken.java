package ups.edu.com.ProyectosExamen.token;

import java.io.Serializable;

public class UsuarioToken implements Serializable {
	
	private String email;
	private String password;
	
	public UsuarioToken(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public UsuarioToken() {
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
