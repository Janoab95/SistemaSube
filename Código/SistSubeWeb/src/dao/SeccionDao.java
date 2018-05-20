package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Seccion;

public class SeccionDao {
	private static Session session;
	private Transaction tx;
	
    /*-----------------PATRON SINGLETON-----------------*/
	
	private static SeccionDao instancia=null;    
	
	protected SeccionDao(){}
	
	public static SeccionDao getIntance(){
		if(instancia==null)
			instancia=new SeccionDao();
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
	
	public int agregar(Seccion objeto){
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
	
	public void actualizar(Seccion objeto)throws HibernateException{
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
	
	public void eleminar(Seccion objeto)throws HibernateException{
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
	
	public Seccion traerSeccion(int idSeccion)throws HibernateException{
		Seccion objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Seccion) session.get(Seccion.class, idSeccion);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	public Seccion traerSeccion(int codEstacion1, int codEstacion2)throws HibernateException{
		Seccion objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Seccion) session.createQuery("from Seccion s where s.codEstacion1="+codEstacion1+"and s.codEstacion2="+codEstacion2).uniqueResult();
		}finally{
			session.close();
		}
		return objeto;
	}
	
	 @SuppressWarnings("unchecked")
	public List<Seccion> traerSecciones()throws HibernateException{
		List<Seccion> lista = null;
		try{
			iniciaOperacion();
			lista = session.createQuery("from Seccion s order by s.idSeccion asc s.codEstacion1 asc s.codEstacion2 asc").list();
		}finally{
			session.close();
		}
		return lista;
	}

}
