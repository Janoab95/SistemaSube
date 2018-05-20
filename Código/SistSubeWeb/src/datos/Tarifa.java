package datos;

public class Tarifa {
	private int idTarifa;
	private int tramo;
	private float monto;

	public Tarifa() {}
	
	public Tarifa(int tramo, float monto) {
		super();
		this.tramo = tramo;
		this.monto = monto;
	}

	/*----------------gets and sets--------------*/

	public int getIdTarifa() {
		return idTarifa;
	}

	protected void setIdTarifa(int idTarifa) {
		this.idTarifa = idTarifa;
	}

	public int getTramo() {
		return tramo;
	}

	public void setTramo(int tramo) {
		this.tramo = tramo;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}
	
	/*-----------------------METODOS-----------------------*/
	
	@Override
	public String toString() {
		return "Tarifa id=" + idTarifa + ", tramo=" + tramo + ", monto=" + monto + "";
	}
}
