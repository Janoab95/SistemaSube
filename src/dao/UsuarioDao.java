package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Usuario;

public class UsuarioDao {
	private static Session session;
	private Transaction tx;
	
    /*-----------------PATRON SINGLETON-----------------*/
	
	private static UsuarioDao instancia=null;    
	
	protected UsuarioDao(){}
	
	public static UsuarioDao getIntance(){
		if(instancia==null)
			instancia=new UsuarioDao();
		return instancia;
	}
	
	/*--------------------------------------------------*/
	
	private void iniciaOperacion()throws HibernateException{
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void manejaExcepcion(HibernateException he)throws HibernateException{
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso de datos", he);
	}
	
	public int agregar(Usuario objeto){
		int id = 0;
		try{
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch(HibernateException he){
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}
	
	public void actualizar(Usuario objeto)throws HibernateException{
		try{
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		}catch (HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
	}
	
	public void eleminar(Usuario objeto)throws HibernateException{
		try{
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		}catch (HibernateException he){
			manejaExcepcion(he);
			throw he;
		}finally{
			session.close();
		}
	}
	
	public Usuario traerUsuario(int idUsuario)throws HibernateException{
		Usuario objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Usuario) session.get(Usuario.class, idUsuario);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	public Usuario traerUsuario(String nombreUsuario)throws HibernateException{
		Usuario objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Usuario) session.createQuery("from Usuario u where u.nombreUsuario="+nombreUsuario).uniqueResult();
		}finally{
			session.close();
		}
		return objeto;
	}
	
	 @SuppressWarnings("unchecked")
	public List<Usuario> traerUsuarios()throws HibernateException{
		List<Usuario> lista = null;
		try{
			iniciaOperacion();
			lista = session.createQuery("from Usuario u order by u.idUsuario asc u.nombreUsuario asc").list();
		}finally{
			session.close();
		}
		return lista;
	}

}
