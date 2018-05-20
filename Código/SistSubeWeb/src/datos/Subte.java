package datos;

import datos.Tarifa;

public class Subte extends Transporte {
	private int idSubte;
	private char linea;
	
	public Subte() {}

	public Subte(char linea, Tarifa tarifa) {
		super(tarifa);
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
}
