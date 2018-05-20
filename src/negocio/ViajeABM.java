package negocio;

import java.util.List;
import datos.Boleto;
import datos.Viaje;
import dao.ViajeDao;

public class ViajeABM {
	
	/*-----------------PATRON SINGLETON-----------------*/
	
	private static ViajeABM instancia=null;    
	
	protected ViajeABM(){}
	
	public static ViajeABM getIntance(){
		if(instancia==null)
			instancia=new ViajeABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(Viaje v) throws Exception{
		if (v == null)throw new Exception("ERROR, el Viaje ingresado es nulo.");
		return ViajeDao.getIntance().agregar(v);	
	}
	
	public void actualizar(Viaje v) throws Exception {
		Viaje buscado=ViajeDao.getIntance().traerViaje(v.getIdViaje());
		
		if (buscado == null)throw new Exception("ERROR, el Viaje ingresada no existe.");
		ViajeDao.getIntance().actualizar(v);
	}
	
	public void eliminar(Viaje v) throws Exception{
		Viaje buscado=ViajeDao.getIntance().traerViaje(v.getIdViaje());
		
		if (buscado == null)throw new Exception("ERROR, el Viaje ingresada no existe.");
		ViajeDao.getIntance().eleminar(v);
	}
	
	public Viaje traerViaje(int idViaje) throws Exception{
		Viaje buscado=ViajeDao.getIntance().traerViaje(idViaje);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public List<Viaje> traerViajes() throws Exception{
		List<Viaje> Viajes=ViajeDao.getIntance().traerViajes();
		
		if (Viajes == null)throw new Exception("ERROR, no se han cargado Viajes.");
		return Viajes;
	}
	
	public Viaje traerViajeYBoletos(int idViaje) throws Exception{
		Viaje buscado=ViajeDao.getIntance().traerViajeYBoletos(idViaje);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public boolean agregarBoleto(Viaje v, Boleto b) throws Exception{
		if (b == null || v == null)throw new Exception("ERROR, ingrese todos los datos.");
		return v.agregarBoleto(b);
	}	

}
