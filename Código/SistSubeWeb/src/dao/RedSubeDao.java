package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.RedSube;

public class RedSubeDao {
	private static Session session;
	private Transaction tx;
	
    /*-----------------PATRON SINGLETON-----------------*/
	
	private static RedSubeDao instancia=null;    
	
	protected RedSubeDao(){}
	
	public static RedSubeDao getIntance(){
		if(instancia==null)
			instancia=new RedSubeDao();
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
	
	public int agregar(RedSube objeto){
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
	
	public void actualizar(RedSube objeto)throws HibernateException{
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
	
	public void eleminar(RedSube objeto)throws HibernateException{
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
	
	public RedSube traerRedSube(int idRedSube)throws HibernateException{
		RedSube objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (RedSube) session.get(RedSube.class, idRedSube);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	public RedSube traerRedSube(float porcentajeDescuento)throws HibernateException{
		RedSube objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (RedSube) session.createQuery("from RedSube r where r.porcentajeDescuento="+porcentajeDescuento).uniqueResult();
		}finally{
			session.close();
		}
		return objeto;
	}
	
	 @SuppressWarnings("unchecked")
	public List<RedSube> traerRedSubes()throws HibernateException{
		List<RedSube> lista = null;
		try{
			iniciaOperacion();
			lista = session.createQuery("from RedSube r order by r.idRedSube asc l.pocentajeDescuento asc").list();
		}finally{
			session.close();
		}
		return lista;
	}

}
