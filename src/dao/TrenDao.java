package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Tren;

public class TrenDao {
	private static Session session;
	private Transaction tx;
	
    /*-----------------PATRON SINGLETON-----------------*/
	
	private static TrenDao instancia=null;    
	
	protected TrenDao(){}
	
	public static TrenDao getIntance(){
		if(instancia==null)
			instancia=new TrenDao();
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
	
	public int agregar(Tren objeto){
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
	
	public void actualizar(Tren objeto)throws HibernateException{
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
	
	public void eleminar(Tren objeto)throws HibernateException{
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
	
	public Tren traerTren(int idTren)throws HibernateException{
		Tren objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Tren) session.get(Tren.class, idTren);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	public Tren traerTren(String nombreTren)throws HibernateException{
		Tren objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Tren) session.createQuery("from Tren t where t.nombreTren="+nombreTren).uniqueResult();
		}finally{
			session.close();
		}
		return objeto;
	}
	
	 @SuppressWarnings("unchecked")
	public List<Tren> traerTrenes()throws HibernateException{
		List<Tren> lista = null;
		try{
			iniciaOperacion();
			lista = session.createQuery("from Tren t order by t.idTren asc t.nombreTren asc").list();
		}finally{
			session.close();
		}
		return lista;
	}

}
