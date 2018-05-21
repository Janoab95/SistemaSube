package datos;

public class RedSube {
	private int idRedSube;
	private float porcentajeDescuento;
	
	public RedSube() {}
	
	public RedSube(float porcentajeDescuento) {
		super();
		this.porcentajeDescuento = porcentajeDescuento;
	}
    
	/*----------------------gets and sets---------------------*/
	
	public int getIdRedSube() {
		return idRedSube;
	}

	protected void setIdResSube(int idRedSube) {
		this.idRedSube = idRedSube;
	}

	public float getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorcentajeDescuento(float porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	/*-----------------------METODOS-----------------------*/
	
	@Override
	public String toString() {
		return "RedSube id=" + idRedSube + ", Descuento=" + porcentajeDescuento + "";
	}
}
