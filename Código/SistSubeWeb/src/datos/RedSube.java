package datos;

public class RedSube {
	private int idRedSube;
	private double porcentajeDescuento;
	
	public RedSube() {}
	
	public RedSube(double porcentajeDescuento) {
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

	public double getPorsentajeDescuento() {
		return porcentajeDescuento;
	}

	public void setPorsentajeDescuento(double porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}
	
	/*-----------------------METODOS-----------------------*/
	
	@Override
	public String toString() {
		return "RedSube id=" + idRedSube + ", Descuento=" + porcentajeDescuento + "";
	}
}
