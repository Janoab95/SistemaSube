package negocio;

import java.util.List;
import datos.Boleto;
import dao.BoletoDao;

public class BoletoABM {

    /*-----------------PATRON SINGLETON-----------------*/
	
	private static BoletoABM instancia=null;    
	
	protected BoletoABM(){}
	
	public static BoletoABM getIntance(){
		if(instancia==null)
			instancia=new BoletoABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(Boleto b) throws Exception{
		if (b == null)throw new Exception("ERROR, el Boleto ingresado es nulo.");
		return BoletoDao.getIntance().agregar(b);	
	}
	
	public void actualizar(Boleto b) throws Exception {
		Boleto buscado=BoletoDao.getIntance().traerBoleto(b.getIdBoleto());
		
		if (buscado == null)throw new Exception("ERROR, el Boleto ingresado no existe.");
		BoletoDao.getIntance().actualizar(b);
	}
	
	public void eliminar(Boleto b) throws Exception{
		Boleto buscado=BoletoDao.getIntance().traerBoleto(b.getIdBoleto());
		
		if (buscado == null)throw new Exception("ERROR, el Boleto ingresado no existe.");
		BoletoDao.getIntance().eleminar(b);
	}
	
	public Boleto traerBoleto(int idBoleto) throws Exception{
		Boleto buscado=BoletoDao.getIntance().traerBoleto(idBoleto);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public List<Boleto> traerBoletos() throws Exception{
		List<Boleto> Boletos=BoletoDao.getIntance().traerBoletos();
		
		if (Boletos == null)throw new Exception("ERROR, no se han cargado Boletos.");
		return Boletos;
	}
	
	public Boleto traerBoletoYTransporte(int idBoleto) throws Exception{
		Boleto buscado=BoletoDao.getIntance().traerBoletoYTransporte(idBoleto);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");		
		return buscado;
	}
	
}
