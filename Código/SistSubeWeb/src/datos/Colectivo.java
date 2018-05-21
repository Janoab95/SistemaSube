package datos;

import dao.TarifaDao;

public class Colectivo extends Transporte {
	private int idColectivo;
	private int linea;
	private int interno;
	private int tramo;
	
	public Colectivo() {}
	
	public Colectivo(int linea, int interno, int tramo) {
		super();
		this.linea = linea;
		this.interno = interno;
		this.tramo = tramo;
	}
	
	/*-------------------gets and sets--------------*/
	
	public int getIdColectivo() {
		return idColectivo;
	}

	protected void setIdColectivo(int idColectivo) {
		this.idColectivo = idColectivo;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	public int getInterno() {
		return interno;
	}

	public void setInterno(int interno) {
		this.interno = interno;
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
		return "Colectivo id=" + idColectivo + ", linea=" + linea + ", interno=" + interno + ", tramo="
				+ tramo + "";
	}
	
	public boolean cobrarBoleto(Tarjeta tarjeta, long tramo) {
		Tarifa t=TarifaDao.getIntance().traerTarifa(tramo);
		float cobro=t.getMonto();
		Viaje v=tarjeta.traerUltimoViaje();
		
		
		
		for (int i=0; i<=tarjeta.getDescuentos().size(); i++) {
			cobro=cobro*tarjeta.getDescuentos().get(i).getMontoDesc()/100;
		}
		
		tarjeta.debitarTarjeta(cobro);
		return true;	
	}
}
