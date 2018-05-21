package datos;

import java.util.GregorianCalendar;

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
	
	public boolean verificarViaje(Tarjeta t) {
		boolean habilitado=false;
		GregorianCalendar horaActual=new GregorianCalendar();
		Viaje v=t.traerUltimoViaje();
		
		if (v.getBoletos().get(0).getFechaHora().getTime().getYear() == horaActual.getTime().getYear()) {
		
			if (v.getBoletos().get(0).getFechaHora().getTime().getMonth() == horaActual.getTime().getMonth()) {
			
				if (v.getBoletos().get(0).getFechaHora().getTime().getDay() == horaActual.getTime().getDay()) {
			
					if (v.getBoletos().get(0).getFechaHora().getTime().getHours() <= horaActual.getTime().getHours()) {
				
						if (v.getBoletos().get(0).getFechaHora().getTime().getMinutes()< horaActual.getTime().getHours()) {
							habilitado = true;
						}
					}
				}
			}
		}
		
		if (habilitado==false) {
			Viaje nuevoViaje=new Viaje();
			t.agregarViaje(nuevoViaje);
		}
		
		return habilitado;
	}
}
