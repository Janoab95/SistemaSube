package negocio;

import java.util.List;

import datos.Linea;
import dao.LineaDao;

public class LineaABM {

	/*-----------------PATRON SINGLETON-----------------*/
	
	private static LineaABM instancia=null;    
	
	protected LineaABM(){}
	
	public static LineaABM getIntance(){
		if(instancia==null)
			instancia=new LineaABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(Linea l) throws Exception{
		if (l == null)throw new Exception("ERROR, la Linea ingresada es nulo.");
		return LineaDao.getIntance().agregar(l);	
	}
	
	public void actualizar(Linea l) throws Exception {
		Linea buscado=LineaDao.getIntance().traerLinea(l.getIdLinea());
		
		if (buscado == null)throw new Exception("ERROR, la Linea ingresada no existe.");
		LineaDao.getIntance().actualizar(l);
	}
	
	public void eliminar(Linea l) throws Exception{
		Linea buscado=LineaDao.getIntance().traerLinea(l.getIdLinea());
		
		if (buscado == null)throw new Exception("ERROR, la Linea ingresada no existe.");
		LineaDao.getIntance().eleminar(l);
	}
	
	public Linea traerLinea(int idLinea) throws Exception{
		Linea buscado=LineaDao.getIntance().traerLinea(idLinea);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public Linea traerLinea(String nombreLinea) throws Exception{
		Linea buscado=LineaDao.getIntance().traerLinea(nombreLinea);
		
		if (buscado == null)throw new Exception("ERROR, el Nombre ingresado no existe.");
		return buscado;
	}
	
	public List<Linea> traerLineas() throws Exception{
		List<Linea> Lineas=LineaDao.getIntance().traerLineas();
		
		if (Lineas == null)throw new Exception("ERROR, no se han cargado Lineas.");
		return Lineas;
	}

}
