package negocio;

import java.util.List;

import datos.Descuento;
import dao.DescuentoDao;

public class DescuentoABM {

	/*-----------------PATRON SINGLETON-----------------*/
	
	private static DescuentoABM instancia=null;    
	
	protected DescuentoABM(){}
	
	public static DescuentoABM getIntance(){
		if(instancia==null)
			instancia=new DescuentoABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(Descuento d) throws Exception{
		if (d == null)throw new Exception("ERROR, el Descuento ingresado es nulo.");
		return DescuentoDao.getIntance().agregar(d);	
	}
	
	public void actualizar(Descuento d) throws Exception {
		Descuento buscado=DescuentoDao.getIntance().traerDescuento(d.getIdDesc());
		
		if (buscado == null)throw new Exception("ERROR, el Descuento ingresado no existe.");
		DescuentoDao.getIntance().actualizar(d);
	}
	
	public void eliminar(Descuento d) throws Exception{
		Descuento buscado=DescuentoDao.getIntance().traerDescuento(d.getIdDesc());
		
		if (buscado == null)throw new Exception("ERROR, el Descuento ingresado no existe.");
		DescuentoDao.getIntance().eleminar(d);
	}
	
	public Descuento traerDescuento(int idDescuento) throws Exception{
		Descuento buscado=DescuentoDao.getIntance().traerDescuento(idDescuento);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public Descuento traerDescuento(String nombreDescuento) throws Exception{
		Descuento buscado=DescuentoDao.getIntance().traerDescuento(nombreDescuento);
		
		if (buscado == null)throw new Exception("ERROR, el Nombre ingresado no existe.");
		return buscado;
	}
	
	public List<Descuento> traerDescuentos() throws Exception{
		List<Descuento> Descuentos=DescuentoDao.getIntance().traerDescuentos();
		
		if (Descuentos == null)throw new Exception("ERROR, no se han cargado Descuentos.");
		return Descuentos;
	}
	
}
