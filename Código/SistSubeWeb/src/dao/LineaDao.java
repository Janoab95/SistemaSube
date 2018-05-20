package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Linea;

public class LineaDao {
	private static Session session;
	private Transaction tx;
	
    /*-----------------PATRON SINGLETON-----------------*/
	
	private static LineaDao instancia=null;    
	
	protected LineaDao(){}
	
	public static LineaDao getIntance(){
		if(instancia==null)
			instancia=new LineaDao();
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
	
	public int agregar(Linea objeto){
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
	
	public void actualizar(Linea objeto)throws HibernateException{
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
	
	public void eleminar(Linea objeto)throws HibernateException{
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
	
	public Linea traerLinea(int idLinea)throws HibernateException{
		Linea objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Linea) session.get(Linea.class, idLinea);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	public Linea traerLinea(String nombreLinea)throws HibernateException{
		Linea objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Linea) session.createQuery("from Linea l where l.nombreLinea="+nombreLinea).uniqueResult();
		}finally{
			session.close();
		}
		return objeto;
	}
	
	 @SuppressWarnings("unchecked")
	public List<Linea> traerLineas()throws HibernateException{
		List<Linea> lista = null;
		try{
			iniciaOperacion();
			lista = session.createQuery("from Linea l order by l.idLinea asc l.nombreLinea asc").list();
		}finally{
			session.close();
		}
		return lista;
	}

}
