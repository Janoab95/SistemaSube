package negocio;

import java.util.List;

import dao.TransporteDao;
import datos.Tarjeta;
import datos.Transporte;

public class TransporteABM {

    /*-----------------PATRON SINGLETON-----------------*/
	
	private static TransporteABM instancia=null;    
	
	protected TransporteABM(){}
	
	public static TransporteABM getIntance(){
		if(instancia==null)
			instancia=new TransporteABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(Transporte t) throws Exception{
		if (t == null)throw new Exception("ERROR, el transporte ingresado es nulo.");
		return TransporteDao.getIntance().agregar(t);
	}
	
	public void actualizar(Transporte t) throws Exception{
		Transporte buscado=TransporteDao.getIntance().traerTransporte(t.getIdTransporte());
		
		if (buscado == null)throw new Exception("ERROR, el transporte ingresado no existe.");
		TransporteDao.getIntance().actualizar(t);
	}
	
	public void eliminar(Transporte t) throws Exception{
		Transporte buscado=TransporteDao.getIntance().traerTransporte(t.getIdTransporte());
		
		if (buscado == null)throw new Exception("ERROR, el transporte ingresado no existe.");
		TransporteDao.getIntance().eleminar(t);
	}
	
	public Transporte traerTransporte(int idTransporte) throws Exception{
		Transporte buscado=TransporteDao.getIntance().traerTransporte(idTransporte);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public List<Transporte> traerTransportes() throws Exception{
		List<Transporte> transportes=TransporteDao.getIntance().traerTransportes();
		
		if (transportes == null)throw new Exception("ERROR, no se han cargado transportes.");
		return transportes;
	}
	
	public boolean cobrarBoleto(Transporte tr, Tarjeta t, long tramo) throws Exception{
		if (t == null || tr == null|| tramo==0)throw new Exception("ERROR, ingrese todos los datos.");
		return tr.cobrarBoleto(t, tramo);
	}
}
