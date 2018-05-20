package negocio;

import java.util.List;

import datos.Tarjeta;
import datos.Viaje;
import dao.TarjetaDao;

public class TarjetaABM {
	
	/*-----------------PATRON SINGLETON-----------------*/
	
	private static TarjetaABM instancia=null;    
	
	protected TarjetaABM(){}
	
	public static TarjetaABM getIntance(){
		if(instancia==null)
			instancia=new TarjetaABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(Tarjeta t) throws Exception{
		if (t == null)throw new Exception("ERROR, la Tarjeta ingresada es nulo.");
		return TarjetaDao.getIntance().agregar(t);	
	}
	
	public void actualizar(Tarjeta t) throws Exception {
		Tarjeta buscado=TarjetaDao.getIntance().traerTarjeta(t.getIdTarjeta());
		
		if (buscado == null)throw new Exception("ERROR, la Tarjeta ingresada no existe.");
		TarjetaDao.getIntance().actualizar(t);
	}
	
	public void eliminar(Tarjeta t) throws Exception{
		Tarjeta buscado=TarjetaDao.getIntance().traerTarjeta(t.getIdTarjeta());
		
		if (buscado == null)throw new Exception("ERROR, la Tarjeta ingresada no existe.");
		TarjetaDao.getIntance().eleminar(t);
	}
	
	public Tarjeta traerTarjeta(int idTarjeta) throws Exception{
		Tarjeta buscado=TarjetaDao.getIntance().traerTarjeta(idTarjeta);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public Tarjeta traerTarjeta(long nroTarjeta) throws Exception{
		Tarjeta buscado=TarjetaDao.getIntance().traerTarjeta(nroTarjeta);
		
		if (buscado == null)throw new Exception("ERROR, el numero de Tarjeta ingresado no existe.");
		return buscado;
	}
	
	public List<Tarjeta> traerTarjetas() throws Exception{
		List<Tarjeta> Tarjetas=TarjetaDao.getIntance().traerTarjetas();
		
		if (Tarjetas == null)throw new Exception("ERROR, no se han cargado Tarjetas.");
		return Tarjetas;
	}
	
	public Tarjeta traerTarjetaYViajes(int idTarjeta) throws Exception{
		Tarjeta buscado=TarjetaDao.getIntance().traerTarjetaYViajes(idTarjeta);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public boolean agregarViaje(Tarjeta t, Viaje v) throws Exception{
		if (t == null || v == null)throw new Exception("ERROR, ingrese todos los datos.");
		return t.agregarViaje(v);
	}	
	
}
