package negocio;

import java.util.List;

import datos.RedSube;
import dao.RedSubeDao;

public class RedSubeABM {

	/*-----------------PATRON SINGLETON-----------------*/
	
	private static RedSubeABM instancia=null;    
	
	protected RedSubeABM(){}
	
	public static RedSubeABM getIntance(){
		if(instancia==null)
			instancia=new RedSubeABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(RedSube r) throws Exception{
		if (r == null)throw new Exception("ERROR, la RedSube ingresada es nulo.");
		return RedSubeDao.getIntance().agregar(r);	
	}
	
	public void actualizar(RedSube r) throws Exception {
		RedSube buscado=RedSubeDao.getIntance().traerRedSube(r.getIdRedSube());
		
		if (buscado == null)throw new Exception("ERROR, la RedSube ingresada no existe.");
		RedSubeDao.getIntance().actualizar(r);
	}
	
	public void eliminar(RedSube r) throws Exception{
		RedSube buscado=RedSubeDao.getIntance().traerRedSube(r.getIdRedSube());
		
		if (buscado == null)throw new Exception("ERROR, la RedSube ingresada no existe.");
		RedSubeDao.getIntance().eleminar(r);
	}
	
	public RedSube traerRedSube(int idRedSube) throws Exception{
		RedSube buscado=RedSubeDao.getIntance().traerRedSube(idRedSube);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public RedSube traerRedSube(double porcentajeDescuento) throws Exception{
		RedSube buscado=RedSubeDao.getIntance().traerRedSube(porcentajeDescuento);
		
		if (buscado == null)throw new Exception("ERROR, el porcentaje ingresado no existe.");
		return buscado;
	}
	
	public List<RedSube> traerRedSubes() throws Exception{
		List<RedSube> RedSubes=RedSubeDao.getIntance().traerRedSubes();
		
		if (RedSubes == null)throw new Exception("ERROR, no se han cargado RedSubes.");
		return RedSubes;
	}
	
}
