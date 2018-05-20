package datos;

import datos.Transporte;
import java.util.GregorianCalendar;

public class Boleto {
	private int idBoleto;
	private GregorianCalendar fechaHora;
	private float monto;
	private Transporte transporte;
	private boolean cierreViaje;
	
	public Boleto() {}
	
	public Boleto(GregorianCalendar fechaHora, float monto, Transporte transporte) {
		super();
		this.fechaHora = fechaHora;
		this.monto = monto;
		this.transporte = transporte;
		this.cierreViaje = false;
	}
	
	/*--------------gets and sets----------------*/

	public int getIdBoleto() {
		return idBoleto;
	}

	protected void setIdBoleto(int idBoleto) {
		this.idBoleto = idBoleto;
	}

	public GregorianCalendar getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(GregorianCalendar fechaHora) {
		this.fechaHora = fechaHora;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	public boolean isCierreViaje() {
		return cierreViaje;
	}

	public void setCierreViaje(boolean cierreViaje) {
		this.cierreViaje = cierreViaje;
	}

	/*-------------------METODOS------------------*/
	
	@Override
	public String toString() {
		return "Boleto id=" + idBoleto + ", fechaHora=" + fechaHora + ", monto=" + monto + ", transporte="
				+ transporte + ", cierreViaje=" + cierreViaje + "";
	}
}
