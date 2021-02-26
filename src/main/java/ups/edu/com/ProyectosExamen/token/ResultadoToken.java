package ups.edu.com.ProyectosExamen.token;

import java.io.Serializable;

public class ResultadoToken implements Serializable {
	
	private String codigo;
	private Object resultado;
	
	public ResultadoToken(String codigo, Object resultado) {
		super();
		this.codigo = codigo;
		this.resultado = resultado;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Object getResultado() {
		return resultado;
	}
	public void setResultado(Object resultado) {
		this.resultado = resultado;
	}
	
	
	
	

}
