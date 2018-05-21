package negocio;

import java.util.List;

import datos.Tarifa;
import dao.TarifaDao;

public class TarifaABM {
	
	/*-----------------PATRON SINGLETON-----------------*/
	
	private static TarifaABM instancia=null;    
	
	protected TarifaABM(){}
	
	public static TarifaABM getIntance(){
		if(instancia==null)
			instancia=new TarifaABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(Tarifa t) throws Exception{
		if (t == null)throw new Exception("ERROR, la Tarifa ingresada es nulo.");
		return TarifaDao.getIntance().agregar(t);	
	}
	
	public void actualizar(Tarifa t) throws Exception {
		Tarifa buscado=TarifaDao.getIntance().traerTarifa(t.getIdTarifa());
		
		if (buscado == null)throw new Exception("ERROR, la Tarifa ingresada no existe.");
		TarifaDao.getIntance().actualizar(t);
	}
	
	public void eliminar(Tarifa t) throws Exception{
		Tarifa buscado=TarifaDao.getIntance().traerTarifa(t.getIdTarifa());
		
		if (buscado == null)throw new Exception("ERROR, la Tarifa ingresada no existe.");
		TarifaDao.getIntance().eleminar(t);
	}
	
	public Tarifa traerTarifa(int idTarifa) throws Exception{
		Tarifa buscado=TarifaDao.getIntance().traerTarifa(idTarifa);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public Tarifa traerTarifa(long tramo) throws Exception{
		Tarifa buscado=TarifaDao.getIntance().traerTarifa(tramo);
		
		if (buscado == null)throw new Exception("ERROR, el tramo ingresado no existe.");
		return buscado;
	}
	
	public List<Tarifa> traerTarifas() throws Exception{
		List<Tarifa> Tarifas=TarifaDao.getIntance().traerTarifas();
		
		if (Tarifas == null)throw new Exception("ERROR, no se han cargado Tarifas.");
		return Tarifas;
	}

}
