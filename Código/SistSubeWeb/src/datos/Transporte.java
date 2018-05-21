package datos;

import datos.Tarjeta;

public class Transporte {
	private int idTransporte;
	
	public Transporte() {}
	
	/*----------------gets and sets---------------*/

	public int getIdTransporte() {
		return idTransporte;
	}

	protected void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}
	
	/*-----------------METODOS----------------*/
	
	@Override
	public String toString() {
		return "Transporte id=" + idTransporte + "";
	}
	
	public boolean cobrarBoleto(Tarjeta tarjeta, long tramo) {
		return true;
	}
}
