package datos;

import java.util.GregorianCalendar;

import dao.RedSubeDao;
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
		boolean habilitado=this.verificarViaje(tarjeta);
		Viaje ultimoViaje=tarjeta.traerUltimoViaje();
		Tarifa t=TarifaDao.getIntance().traerTarifa(tramo);
		float cobro=t.getMonto();
		int cantBoletos= 0;
		float descuento=0;
		
		//////////////////////////////verificacion ultimo viaje///////////////////////////////
		if (habilitado==true) {
			Boleto b=ultimoViaje.traerUltimoBoleto();
			
			if ( b.getTransporte().getClass() == this.getClass()) {
				Colectivo c= (Colectivo) b.getTransporte();
				
				if (c.linea == this.linea) {
					Viaje nuevoViaje=new Viaje();
					tarjeta.agregarViaje(nuevoViaje);
				}
				
			}
		}
		///////////////////////////////calcula RedSube/////////////////////////////////////////
		cantBoletos = ultimoViaje.getBoletos().size() -1;
		
		if (cantBoletos==2) {
			RedSube r=RedSubeDao.getIntance().traerRedSube(50);
			descuento=cobro*( r.getPorcentajeDescuento()/100 );
	        cobro-=descuento;
		}
		
		if (cantBoletos>=3) {
			RedSube r=RedSubeDao.getIntance().traerRedSube(75);
			descuento=cobro*( r.getPorcentajeDescuento()/100 );
	        cobro-=descuento;
		}
		//////////////////////////////aplica descuentos////////////////////////////////////////
		
		for (int i=0; i<=tarjeta.getDescuentos().size(); i++) {
			descuento=cobro*( tarjeta.getDescuentos().get(i).getMontoDesc()/100 );
			cobro-=descuento;
		}
        //////////////////////////////crea el boleto nuevo/////////////////////////////////////
        GregorianCalendar horaActual=new GregorianCalendar();
        Boleto boletoActual=new Boleto(horaActual, cobro, this);
        
        tarjeta.traerUltimoViaje().agregarBoleto(boletoActual);
		tarjeta.debitarTarjeta(cobro);
		return true;	
	}
	
}
