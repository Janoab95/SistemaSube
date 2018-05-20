package datos;

public class Linea {
	private int idLinea;
	private String nombreLinea;
	
	public Linea() {}
	
	public Linea(String nombreLinea) {
		super();
		this.nombreLinea = nombreLinea;
	}
	
	/*---------------gets and sets-----------------*/

	public int getIdLinea() {
		return idLinea;
	}

	protected void setIdLinea(int idLinea) {
		this.idLinea = idLinea;
	}

	public String getNombreLinea() {
		return nombreLinea;
	}

	public void setNombreLinea(String nombreLinea) {
		this.nombreLinea = nombreLinea;
	}
	
	/*-----------------------METODOS-----------------------*/

	@Override
	public String toString() {
		return "Linea id=" + idLinea + ", nombre=" + nombreLinea + "";
	}
}
