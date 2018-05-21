package datos;

import java.util.List;
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
		this.tarjetas.add(t);
		return true;
	}
	
	public boolean activarTarjeta(long nroTarjeta) {
        Tarjeta buscado=this.traerTarjeta(nroTarjeta);
		
		buscado.setTarjetaActiva(true);
		return true;
	}
	
	public boolean darBajaTarjeta(long nroTarjeta) {
		Tarjeta buscado=this.traerTarjeta(nroTarjeta);
		
		buscado.setTarjetaActiva(false);
		return true;
	}
	
	public Tarjeta traerTarjeta(long nroTarjeta) {
		boolean encontrado=false;
		int i=0;
		Tarjeta buscado=null;
		
		while(encontrado&&i<this.tarjetas.size()) {
			
			if(this.tarjetas.get(i).getNroTarjeta() == nroTarjeta) {
			     buscado=this.tarjetas.get(i);
			     encontrado=true;
			}
		 i++;
		}
		
		return buscado;
	}
	
	public boolean agregarDescuento(Descuento d) {
		this.descuentos.add(d);
		return true;
	}
	
	public boolean eliminarDescuento(Descuento d) {
		this.descuentos.remove(d);
		return true;
	}
	
	public Descuento traerDescuento(int idDescuento) {
		boolean encontrado=false;
		int i=0;
		Descuento buscado=null;
		
		while(encontrado&&i<this.descuentos.size()) {
			
			if(this.tarjetas.get(i).getNroTarjeta() == idDescuento) {
			     buscado=this.descuentos.get(i);
			     encontrado=true;
			}
		 i++;
		}
		
		return buscado;
	}
	
	@Override
	public String toString() {
		return "Cliente id=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni+"";
	}		
}
