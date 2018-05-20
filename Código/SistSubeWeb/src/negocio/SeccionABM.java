package negocio;

import java.util.List;

import datos.Seccion;
import dao.SeccionDao;

public class SeccionABM {
	
	/*-----------------PATRON SINGLETON-----------------*/
	
	private static SeccionABM instancia=null;    
	
	protected SeccionABM(){}
	
	public static SeccionABM getIntance(){
		if(instancia==null)
			instancia=new SeccionABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(Seccion s) throws Exception{
		if (s == null)throw new Exception("ERROR, la Seccion ingresada es nulo.");
		return SeccionDao.getIntance().agregar(s);	
	}
	
	public void actualizar(Seccion s) throws Exception {
		Seccion buscado=SeccionDao.getIntance().traerSeccion(s.getIdSeccion());
		
		if (buscado == null)throw new Exception("ERROR, la Seccion ingresada no existe.");
		SeccionDao.getIntance().actualizar(s);
	}
	
	public void eliminar(Seccion s) throws Exception{
		Seccion buscado=SeccionDao.getIntance().traerSeccion(s.getIdSeccion());
		
		if (buscado == null)throw new Exception("ERROR, la Seccion ingresada no existe.");
		SeccionDao.getIntance().eleminar(s);
	}
	
	public Seccion traerSeccion(int idSeccion) throws Exception{
		Seccion buscado=SeccionDao.getIntance().traerSeccion(idSeccion);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public Seccion traerSeccion(int codEstacion1, int codEstacion2) throws Exception{
		Seccion buscado=SeccionDao.getIntance().traerSeccion(codEstacion1, codEstacion2);
		
		if (buscado == null)throw new Exception("ERROR, las combinacion ingresada no existe.");
		return buscado;
	}
	
	public List<Seccion> traerSecciones() throws Exception{
		List<Seccion> Secciones=SeccionDao.getIntance().traerSecciones();
		
		if (Secciones == null)throw new Exception("ERROR, no se han cargado Secciones.");
		return Secciones;
	}

}
