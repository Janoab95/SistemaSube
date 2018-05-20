package datos;

import datos.Tarifa;
import datos.Tarjeta;

public class Transporte {
	private int idTransporte;
	private Tarifa tarifa;
	
	public Transporte() {}
	
	public Transporte(Tarifa tarifa) {
		super();
		this.tarifa = tarifa;
	}
	
	/*----------------gets and sets---------------*/

	public int getIdTransporte() {
		return idTransporte;
	}

	protected void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}
	
	public Tarifa getTarifa() {
		return tarifa;
	}

	protected void setTarifa(Tarifa tarifa) {
		this.tarifa = tarifa;
	}
	
	/*-----------------METODOS----------------*/
	
	@Override
	public String toString() {
		return "Transporte id=" + idTransporte + ", tarifa=" + tarifa + "";
	}
	
	public boolean cobrarBoleto(Tarjeta tarjeta, float monto) {
		return true;
	}
}
