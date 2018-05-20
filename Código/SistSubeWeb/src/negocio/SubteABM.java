package negocio;

import java.util.List;

import datos.Subte;
import dao.SubteDao;

public class SubteABM {
	
	/*-----------------PATRON SINGLETON-----------------*/
	
	private static SubteABM instancia=null;    
	
	protected SubteABM(){}
	
	public static SubteABM getIntance(){
		if(instancia==null)
			instancia=new SubteABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(Subte s) throws Exception{
		if (s == null)throw new Exception("ERROR, el Subte ingresado es nulo.");
		return SubteDao.getIntance().agregar(s);	
	}
	
	public void actualizar(Subte s) throws Exception {
		Subte buscado=SubteDao.getIntance().traerSubte(s.getIdSubte());
		
		if (buscado == null)throw new Exception("ERROR, el Subte ingresado no existe.");
		SubteDao.getIntance().actualizar(s);
	}
	
	public void eliminar(Subte s) throws Exception{
		Subte buscado=SubteDao.getIntance().traerSubte(s.getIdSubte());
		
		if (buscado == null)throw new Exception("ERROR, el Subte ingresado no existe.");
		SubteDao.getIntance().eleminar(s);
	}
	
	public Subte traerSubte(int idSubte) throws Exception{
		Subte buscado=SubteDao.getIntance().traerSubte(idSubte);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public Subte traerSubte(char linea) throws Exception{
		Subte buscado=SubteDao.getIntance().traerSubte(linea);
		
		if (buscado == null)throw new Exception("ERROR, la linea ingresada no existe.");
		return buscado;
	}
	
	public List<Subte> traerSubtes() throws Exception{
		List<Subte> Subtes=SubteDao.getIntance().traerSubtes();
		
		if (Subtes == null)throw new Exception("ERROR, no se han cargado Subtes.");
		return Subtes;
	}

}
