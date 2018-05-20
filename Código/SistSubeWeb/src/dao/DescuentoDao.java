package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Descuento;

public class DescuentoDao {
	private static Session session;
	private Transaction tx;
	
    /*-----------------PATRON SINGLETON-----------------*/
	
	private static DescuentoDao instancia=null;    
	
	protected DescuentoDao(){}
	
	public static DescuentoDao getIntance(){
		if(instancia==null)
			instancia=new DescuentoDao();
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
	
	public int agregar(Descuento objeto){
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
	
	public void actualizar(Descuento objeto)throws HibernateException{
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
	
	public void eleminar(Descuento objeto)throws HibernateException{
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
	
	public Descuento traerDescuento(int idDescuento)throws HibernateException{
		Descuento objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Descuento) session.get(Descuento.class, idDescuento);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	public Descuento traerDescuento(String nombreDescuento)throws HibernateException{
		Descuento objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Descuento) session.createQuery("from Descuento d where d.nombreDescuento="+nombreDescuento).uniqueResult();
		}finally{
			session.close();
		}
		return objeto;
	}
	
	 @SuppressWarnings("unchecked")
	public List<Descuento> traerDescuentos()throws HibernateException{
		List<Descuento> lista = null;
		try{
			iniciaOperacion();
			lista = session.createQuery("from Descuento d order by d.idDescuento asc d.nombreDescuento asc").list();
		}finally{
			session.close();
		}
		return lista;
	}

}
