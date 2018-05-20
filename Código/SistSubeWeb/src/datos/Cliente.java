package datos;

import java.util.List;
import java.util.ArrayList;
import datos.Tarjeta;
import datos.Descuento;

public class Cliente {
	private int idCliente;
	private String nombre;
	private String apellido;
	private long dni;
	private List<Descuento> descuentos;
	private List<Tarjeta> tarjetas;
	
	public Cliente() {}
	
	public Cliente(String nombre, String apellido, long dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.descuentos=null;
		this.tarjetas=null;
	}
	
	/*------------------gets and sets------------------*/

	public int getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public List<Descuento> getDescuentos() {
		return descuentos;
	}

	public void setDescuentos(List<Descuento> descuentos) {
		this.descuentos = descuentos;
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	
	/*------------------METODOS----------------*/
	
	public boolean agregarTarjeta(Tarjeta t) {
		return true;
	}
	
	public boolean activarTarjeta(long nroTarjeta) {
		return true;
	}
	
	public boolean darBajaTarjeta(long nroTarjeta) {
		return true;
	}
	
	public Tarjeta traerTarjeta(long nroTarjeta) {
		Tarjeta t=new Tarjeta();
		return t;
	}
	
	public boolean agregarDescuento(Descuento d) {
		return true;
	}
	
	public boolean eliminarDescuento(Descuento d) {
		return true;
	}
	
	public Descuento traerDescuento(int idDEscuento) {
		Descuento d=new Descuento();
		return d;
	}
	
	@Override
	public String toString() {
		return "Cliente id=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni+"";
	}		
}
