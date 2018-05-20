package datos;

import java.util.List;
import java.util.ArrayList;
import datos.Boleto;

public class Viaje {
	private int idViaje;
	private List<Boleto> boletos;
	
	public Viaje() {
		super();
		this.boletos = null;
	}
	
	/*------------gets and sets---------*/

	public int getIdViaje() {
		return idViaje;
	}

	protected void setIdViaje(int idViaje) {
		this.idViaje = idViaje;
	}

	public List<Boleto> getBoletos() {
		return boletos;
	}

	public void setBoletos(List<Boleto> boletos) {
		this.boletos = boletos;
	}
	
	/*--------------------METODOS------------------*/
	
	@Override
	public String toString() {
		return "Viaje id=" + idViaje + ", boletos=" + boletos + "";
	}
	
	public boolean agregarBoleto(Boleto boleto){
		return true;
	}
	
	public Boleto traerUltimoBoleto() {
		Boleto b=new Boleto();
		return b;
	}
}
