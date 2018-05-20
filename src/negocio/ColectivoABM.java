package negocio;

import java.util.List;

import datos.Colectivo;
import dao.ColectivoDao;

public class ColectivoABM {
    
	/*-----------------PATRON SINGLETON-----------------*/
	
	private static ColectivoABM instancia=null;    
	
	protected ColectivoABM(){}
	
	public static ColectivoABM getIntance(){
		if(instancia==null)
			instancia=new ColectivoABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(Colectivo c) throws Exception{
		if (c == null)throw new Exception("ERROR, el Colectivo ingresado es nulo.");
		return ColectivoDao.getIntance().agregar(c);	
	}
	
	public void actualizar(Colectivo c) throws Exception {
		Colectivo buscado=ColectivoDao.getIntance().traerColectivo(c.getIdColectivo());
		
		if (buscado == null)throw new Exception("ERROR, el Colectivo ingresado no existe.");
		ColectivoDao.getIntance().actualizar(c);
	}
	
	public void eliminar(Colectivo c) throws Exception{
		Colectivo buscado=ColectivoDao.getIntance().traerColectivo(c.getIdColectivo());
		
		if (buscado == null)throw new Exception("ERROR, el Colectivo ingresado no existe.");
		ColectivoDao.getIntance().eleminar(c);
	}
	
	public Colectivo traerColectivo(int idColectivo) throws Exception{
		Colectivo buscado=ColectivoDao.getIntance().traerColectivo(idColectivo);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public List<Colectivo> traerColectivos() throws Exception{
		List<Colectivo> Colectivos=ColectivoDao.getIntance().traerColectivos();
		
		if (Colectivos == null)throw new Exception("ERROR, no se han cargado Colectivos.");
		return Colectivos;
	}
	
	public Colectivo traerColectivoYTarifa(int idColectivo) throws Exception{
		Colectivo buscado=ColectivoDao.getIntance().traerColectivoYTarifa(idColectivo);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");	
		return buscado;
	}

}
