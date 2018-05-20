package negocio;

import java.util.List;

import datos.Usuario;
import dao.UsuarioDao;

public class UsuarioABM {
	
	/*-----------------PATRON SINGLETON-----------------*/
	
	private static UsuarioABM instancia=null;    
	
	protected UsuarioABM(){}
	
	public static UsuarioABM getIntance(){
		if(instancia==null)
			instancia=new UsuarioABM();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	public int agregar(Usuario u) throws Exception{
		if (u == null)throw new Exception("ERROR, el Usuario ingresado es nulo.");
		return UsuarioDao.getIntance().agregar(u);	
	}
	
	public void actualizar(Usuario u) throws Exception {
		Usuario buscado=UsuarioDao.getIntance().traerUsuario(u.getIdUsuario());
		
		if (buscado == null)throw new Exception("ERROR, el Usuario ingresado no existe.");
		UsuarioDao.getIntance().actualizar(u);
	}
	
	public void eliminar(Usuario u) throws Exception{
		Usuario buscado=UsuarioDao.getIntance().traerUsuario(u.getIdUsuario());
		
		if (buscado == null)throw new Exception("ERROR, el Usuario ingresado no existe.");
		UsuarioDao.getIntance().eleminar(u);
	}
	
	public Usuario traerUsuario(int idUsuario) throws Exception{
		Usuario buscado=UsuarioDao.getIntance().traerUsuario(idUsuario);
		
		if (buscado == null)throw new Exception("ERROR, el ID ingresado no existe.");
		return buscado;
	}
	
	public Usuario traerUsuario(String nombreUsuario) throws Exception{
		Usuario buscado=UsuarioDao.getIntance().traerUsuario(nombreUsuario);
		
		if (buscado == null)throw new Exception("ERROR, el Nombre ingresado no existe.");
		return buscado;
	}
	
	public List<Usuario> traerUsuario() throws Exception{
		List<Usuario> Usuarios=UsuarioDao.getIntance().traerUsuarios();
		
		if (Usuarios == null)throw new Exception("ERROR, no se han cargado Usuarios.");
		return Usuarios;
	}
	
}
