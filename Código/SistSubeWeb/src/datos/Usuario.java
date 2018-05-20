package datos;

public class Usuario{
	
	private int idUsuario;
    private String nombreUsuario; 
    private String clave;
    private String tipoUsuario;
    
    public Usuario() {}

    public Usuario(String nombreUsuario, String clave, String tipoUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.tipoUsuario = tipoUsuario;
	}
    
    /*-------------------gets and sets-------------------*/

	public int getIdUsuario() {
		return idUsuario;
	}

	protected void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	/*----------------METODOS-----------------------*/

	public Usuario traerUsuario(long dni) {
		
		return null;
	}
}
