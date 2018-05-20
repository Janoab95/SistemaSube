package negocio;

import datos.Cliente;
import datos.Descuento;
import datos.Tarjeta;

import java.util.List;

import dao.ClienteDao;

public class ClienteABM {
	
    /*-----------------PATRON SINGLETON-----------------*/
	
	private static ClienteABM instancia=null;    
	
	protected ClienteABM(){}
	
	public static ClienteABM getIntance(){
		if(instancia==null)
			instancia=new ClienteABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(Cliente c) throws Exception{
		if (c == null)throw new Exception("ERROR, el cliente ingresado es nulo.");
		return ClienteDao.getIntance().agregar(c);	
	}
	
	public void actualizar(Cliente c) throws Exception {
		Cliente buscado=ClienteDao.getIntance().traerCliente(c.getDni());
		
		if (buscado == null)throw new Exception("ERROR, el cliente ingresado no existe.");
		ClienteDao.getIntance().actualizar(c);
	}
	
	public void eliminar(Cliente c) throws Exception{
        Cliente buscado=ClienteDao.getIntance().traerCliente(c.getDni());
		
		if (buscado == null)throw new Exception("ERROR, el cliente ingresado no existe.");
		ClienteDao.getIntance().eleminar(c);
	}
	
	public Cliente traerCliente(int idCliente) throws Exception{
		Cliente buscado=ClienteDao.getIntance().traerCliente(idCliente);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public Cliente traerCliente(long dni) throws Exception{
        Cliente buscado=ClienteDao.getIntance().traerCliente(dni);
		
		if (buscado == null)throw new Exception("ERROR, el DNI ingresado no existe.");
		return buscado;	
	}
	
	public List<Cliente> traerClientes() throws Exception{
		List<Cliente> clientes=ClienteDao.getIntance().traerClientes();
		
		if (clientes == null)throw new Exception("ERROR, no se han cargado clientes.");
		return clientes;
	}
	
	public Cliente traerClienteYDescuentos(long dni) throws Exception{
		Cliente buscado=ClienteDao.getIntance().traerClienteYDescuentos(dni);
		
		if (buscado == null)throw new Exception("ERROR, el DNI ingresado no existe.");
		return buscado;
	}
	
	public Cliente traerCLienteYTarjetas(long dni) throws Exception{
		Cliente buscado=ClienteDao.getIntance().traerClienteYTarjetas(dni);
		
		if (buscado == null)throw new Exception("ERROR, el DNI ingresado no existe.");
		return buscado;
	}
	
	public boolean agregarTarjeta(Tarjeta t, Cliente c) throws Exception{
		if (t == null || c == null)throw new Exception("ERROR, ingrese todos los datos.");
		return c.agregarTarjeta(t);
	}
	
	public boolean agregarDescuento(Descuento d, Cliente c) throws Exception{
		if (d == null || c == null)throw new Exception("ERROR, ingrese todos los datos.");
		return c.agregarDescuento(d);
	}	
	
	public boolean darBajaTarjeta(long nroTarjeta, Cliente c) throws Exception{
		if (c == null)throw new Exception("ERROR, ingrese todos los datos.");
		
		Tarjeta t=c.traerTarjeta(nroTarjeta);
		if (t==null)throw new Exception("ERROR, la tarjeta ingresada no existe en el cliente.");
		return c.darBajaTarjeta(nroTarjeta);
	}
	
	public boolean eliminarDescuento(Descuento d, Cliente c) throws Exception{
		if (d == null || c == null)throw new Exception("ERROR, ingrese todos los datos.");
		
		Descuento buscado=c.traerDescuento(d.getIdDesc());
		if (buscado==null)throw new Exception("ERROR, el descuento no existe en el cliente.");
		return c.eliminarDescuento(d);
	}	

}
