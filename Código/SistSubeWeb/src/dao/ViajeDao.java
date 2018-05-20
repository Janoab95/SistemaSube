package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Viaje;

public class ViajeDao {
	private static Session session;
	private Transaction tx;
	
    /*-----------------PATRON SINGLETON-----------------*/
	
	private static ViajeDao instancia=null;    
	
	protected ViajeDao(){}
	
	public static ViajeDao getIntance(){
		if(instancia==null)
			instancia=new ViajeDao();
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
	
	public int agregar(Viaje objeto){
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
	
	public void actualizar(Viaje objeto)throws HibernateException{
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
	
	public void eleminar(Viaje objeto)throws HibernateException{
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
	
	public Viaje traerViaje(int idViaje)throws HibernateException{
		Viaje objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Viaje) session.get(Viaje.class, idViaje);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	 @SuppressWarnings("unchecked")
	public List<Viaje> traerViajes()throws HibernateException{
		List<Viaje> lista = null;
		try{
			iniciaOperacion();
			lista = session.createQuery("from Viaje v order by v.idViaje asc").list();
		}finally{
			session.close();
		}
		return lista;
	}
	 
	 public Viaje traerViajeYBoletos(int idViaje)throws HibernateException{
		 Viaje objeto=null;
			try{
				iniciaOperacion();
				String hql="from Viaje v where v.idViaje= "+ idViaje;
				objeto = (Viaje) session.createQuery(hql).uniqueResult();
				Hibernate.initialize(objeto.getBoletos());
			}finally{
				session.close();
			}
			return objeto;
		} 

}
