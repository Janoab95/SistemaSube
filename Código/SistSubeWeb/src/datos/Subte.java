package datos;

public class Subte extends Transporte {
	private int idSubte;
	private char linea;
	
	public Subte() {}

	public Subte(char linea) {
		super();
		this.linea = linea;
	}
	
	/*---------------gets and sets----------------*/
    
	public int getIdSubte() {
		return idSubte;
	}

	protected void setIdSubte(int idSubte) {
		this.idSubte = idSubte;
	}

	public char getLinea() {
		return linea;
	}

	public void setLinea(char linea) {
		this.linea = linea;
	}
	
	/*-----------------------METODOS-----------------------*/

	@Override
	public String toString() {
		return "Subte id=" + idSubte + ", linea=" + linea + "";
	}
	
    public boolean cobrarBoleto(Tarjeta tajeta, int tramo) {
		
		return true;
	}
}
