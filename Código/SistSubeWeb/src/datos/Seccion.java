package datos;

public class Seccion {
	private int idSeccion;
	private int codEstacion1;
	private int codEstacion2;
	private int tramo;
	
	public Seccion() {}
	
	public Seccion(int codEstacion1, int codEstacion2, int tramo) {
		super();
		this.codEstacion1 = codEstacion1;
		this.codEstacion2 = codEstacion2;
		this.tramo = tramo;
	}
	
    /*-----------------gets an sets----------------*/
	
	public int getIdSeccion() {
		return idSeccion;
	}

	protected void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}

	public int getCodEstacion1() {
		return codEstacion1;
	}

	public void setCodEstacion1(int codEstacion1) {
		this.codEstacion1 = codEstacion1;
	}

	public int getCodEstacion2() {
		return codEstacion2;
	}

	public void setCodEstacion2(int codEstacion2) {
		this.codEstacion2 = codEstacion2;
	}

	public int getTramo() {
		return tramo;
	}

	public void setTramo(int tramo) {
		this.tramo = tramo;
	}
    
	/*-----------------------METODOS-----------------------*/
	
	@Override
	public String toString() {
		return "Seccion id=" + idSeccion + ", codEstacion1=" + codEstacion1 + ", codEstacion2=" + codEstacion2
				+ ", tramo=" + tramo + "";
	}
	
	
}
