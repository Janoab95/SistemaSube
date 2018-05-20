package dao;

import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Boleto;


public class BoletoDao {
	private static Session session;
	private Transaction tx;
	
    /*-----------------PATRON SINGLETON-----------------*/
	
	private static BoletoDao instancia=null;    
	
	protected BoletoDao(){}
	
	public static BoletoDao getIntance(){
		if(instancia==null)
			instancia=new BoletoDao();
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
	
	public int agregar(Boleto objeto){
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
	
	public void actualizar(Boleto objeto)throws HibernateException{
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
	
	public void eleminar(Boleto objeto)throws HibernateException{
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
	
	public Boleto traerBoleto(int idBoleto)throws HibernateException{
		Boleto objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Boleto) session.get(Boleto.class, idBoleto);
		}finally{
			session.close();
		}
		return objeto;
	}
	
	public Boleto traerBoleto(GregorianCalendar fechaHora)throws HibernateException{
		Boleto objeto = null;
		
		try{
			iniciaOperacion();
			objeto = (Boleto) session.createQuery("from Boleto b where b.fechaHora="+fechaHora).uniqueResult();
		}finally{
			session.close();
		}
		return objeto;
	}
	
	 @SuppressWarnings("unchecked")
	public List<Boleto> traerBoletos()throws HibernateException{
		List<Boleto> lista = null;
		try{
			iniciaOperacion();
			lista = session.createQuery("from Boleto b order by b.idBoleto asc b.fechaHora asc").list();
		}finally{
			session.close();
		}
		return lista;
	}
	 
	 public Boleto traerBoletoYTransporte(int idBoleto)throws HibernateException{
		 Boleto objeto=null;
			try{
				iniciaOperacion();
				String hql="from Boleto b where b.idBoleto= "+ idBoleto;
				objeto = (Boleto) session.createQuery(hql).uniqueResult();
				Hibernate.initialize(objeto.getTransporte());
			}finally{
				session.close();
			}
			return objeto;
		}

}
