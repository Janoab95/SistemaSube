package datos;

public class Tren extends Transporte{
	private int idTren;
	private String nombreTren;
	
	public Tren() {}
	
	public Tren(String nombreTren) {
		super();
		this.nombreTren = nombreTren;
	}
	
	/*------------------gets and  sets-------------*/

	public int getIdTren() {
		return idTren;
	}

	protected void setIdTren(int idTren) {
		this.idTren = idTren;
	}

	public String getNombreTren() {
		return nombreTren;
	}

	public void setNombreTren(String nombreTren) {
		this.nombreTren = nombreTren;
	}
	
	/*-----------------METODOS---------------*/
	
	@Override
	public String toString() {
		return "Tren id=" + idTren + ", nombre=" + nombreTren + "";
	}	
	
	public boolean iniciarViaje() {
		return true;
	}
	
	public double calcularDistancia() {
		double total=0;
		return total;
	}
	
    public boolean cobrarBoleto(Tarjeta tajeta, int tramo, float monto) {
		
		return true;	
    }
}
