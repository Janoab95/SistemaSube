package negocio;

import java.util.List;

import datos.Tren;
import dao.TrenDao;

public class TrenABM {
	
	/*-----------------PATRON SINGLETON-----------------*/
	
	private static TrenABM instancia=null;    
	
	protected TrenABM(){}
	
	public static TrenABM getIntance(){
		if(instancia==null)
			instancia=new TrenABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(Tren t) throws Exception{
		if (t == null)throw new Exception("ERROR, el Tren ingresado es nulo.");
		return TrenDao.getIntance().agregar(t);	
	}
	
	public void actualizar(Tren t) throws Exception {
		Tren buscado=TrenDao.getIntance().traerTren(t.getIdTren());
		
		if (buscado == null)throw new Exception("ERROR, el Tren ingresado no existe.");
		TrenDao.getIntance().actualizar(t);
	}
	
	public void eliminar(Tren t) throws Exception{
		Tren buscado=TrenDao.getIntance().traerTren(t.getIdTren());
		
		if (buscado == null)throw new Exception("ERROR, el Tren ingresado no existe.");
		TrenDao.getIntance().eleminar(t);
	}
	
	public Tren traerTren(int idTren) throws Exception{
		Tren buscado=TrenDao.getIntance().traerTren(idTren);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public Tren traerTren(String nombreTren) throws Exception{
		Tren buscado=TrenDao.getIntance().traerTren(nombreTren);
		
		if (buscado == null)throw new Exception("ERROR, el Nombre ingresado no existe.");
		return buscado;
	}
	
	public List<Tren> traerTrenes() throws Exception{
		List<Tren> Trenes=TrenDao.getIntance().traerTrenes();
		
		if (Trenes == null)throw new Exception("ERROR, no se han cargado Trenes.");
		return Trenes;
	}

}
