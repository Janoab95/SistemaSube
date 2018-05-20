package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Subte;

public class SubteDao {
	private static Session session;
	private Transaction tx;
	
    /*-----------------PATRON SINGLETON-----------------*/
	
	private static SubteDao instancia=null;    
	
	protected SubteDao(){}
	
	public static SubteDao getIntance(){
		if(instancia==null)
			instancia=new SubteDao();
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
	
	public int agregar(Subte objeto){
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
	
	public void actualizar(Subte objeto)throws HibernateException{
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
	
	public void eleminar(Subte objeto)throws HibernateException{
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
	
	public Subte traerSubte(int idSubte)throws HibernateException{
		Subte objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Subte) session.get(Subte.class, idSubte);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	public Subte traerSubte(char linea)throws HibernateException{
		Subte objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Subte) session.createQuery("from Subte s where s.linea="+linea).uniqueResult();
		}finally{
			session.close();
		}
		return objeto;
	}
	
	 @SuppressWarnings("unchecked")
	public List<Subte> traerSubtes()throws HibernateException{
		List<Subte> lista = null;
		try{
			iniciaOperacion();
			lista = session.createQuery("from Subte s order by s.idSubte asc s.linea asc").list();
		}finally{
			session.close();
		}
		return lista;
	}

}
