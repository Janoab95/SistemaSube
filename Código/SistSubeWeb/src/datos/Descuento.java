package datos;

public class Descuento {
	private int idDesc;
	private String nombreDesc;
	private float montoDesc;
	
	public Descuento() {}
	
	public Descuento(String nombreDesc, float montoDesc) {
		super();
		this.nombreDesc = nombreDesc;
		this.montoDesc = montoDesc;
	}
	
	/*--------------------gets and sets------------*/

	public int getIdDesc() {
		return idDesc;
	}

	protected void setIdDesc(int idDesc) {
		this.idDesc = idDesc;
	}

	public String getNombreDesc() {
		return nombreDesc;
	}

	public void setNombreDesc(String nombreDesc) {
		this.nombreDesc = nombreDesc;
	}

	public float getMontoDesc() {
		return montoDesc;
	}

	public void setMontoDesc(float montoDesc) {
		this.montoDesc = montoDesc;
	}
	
	/*-----------------------METODOS-----------------------*/

	@Override
	public String toString() {
		return "Descuento id=" + idDesc + ", nombre=" + nombreDesc + ", monto=" + montoDesc + "";
	}
}
