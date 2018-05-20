package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Colectivo;

public class ColectivoDao {
	private static Session session;
	private Transaction tx;
	
    /*-----------------PATRON SINGLETON-----------------*/
	
	private static ColectivoDao instancia=null;    
	
	protected ColectivoDao(){}
	
	public static ColectivoDao getIntance(){
		if(instancia==null)
			instancia=new ColectivoDao();
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
	
	public int agregar(Colectivo objeto){
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
	
	public void actualizar(Colectivo objeto)throws HibernateException{
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
	
	public void eleminar(Colectivo objeto)throws HibernateException{
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
	
	public Colectivo traerColectivo(int idColectivo)throws HibernateException{
		Colectivo objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Colectivo) session.get(Colectivo.class, idColectivo);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	public Colectivo traerColectivo(long linea)throws HibernateException{
		Colectivo objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Colectivo) session.createQuery("from Colectivo c where c.linea="+linea).uniqueResult();
		}finally{
			session.close();
		}
		return objeto;
	}
	
	 @SuppressWarnings("unchecked")
	public List<Colectivo> traerColectivos()throws HibernateException{
		List<Colectivo> lista = null;
		try{
			iniciaOperacion();
			lista = session.createQuery("from Colectivo c order by c.idColectivo asc c.nombreColectivo asc").list();
		}finally{
			session.close();
		}
		return lista;
	}
	 
	 public Colectivo traerColectivoYTarifa(int idColectivo)throws HibernateException{
		 Colectivo objeto=null;
			try{
				iniciaOperacion();
				String hql="from Colectivo c where c.idColectivo= "+ idColectivo;
				objeto = (Colectivo) session.createQuery(hql).uniqueResult();
				Hibernate.initialize(objeto.getTarifa());
			}finally{
				session.close();
			}
			return objeto;
		}

}
