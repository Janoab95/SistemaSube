package datos;
import java.util.ArrayList;
import java.util.List;
import datos.Viaje;

public class Tarjeta {
	private int idTarjeta;
	private long nroTarjeta;
	private float saldo;
	private boolean tarjetaActiva;
	private List<Viaje> viajes;
	
	public Tarjeta() {}
	
	public Tarjeta(long nroTarjeta, float saldo) {
		super();
		this.nroTarjeta = nroTarjeta;
		this.saldo = saldo;
		this.tarjetaActiva = false;
		this.viajes = null;
	}
    /*----------------gets an sets-------------*/
	
	public int getIdTarjeta() {
		return idTarjeta;
	}

	protected void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public long getNroTarjeta() {
		return nroTarjeta;
	}

	public void setNroTarjeta(long nroTarjeta) {
		this.nroTarjeta = nroTarjeta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public boolean isTarjetaActiva() {
		return tarjetaActiva;
	}

	public void setTarjetaActiva(boolean tarjetaActiva) {
		this.tarjetaActiva = tarjetaActiva;
	}

	public List<Viaje> getViajes() {
		return viajes;
	}

	public void setViajes(List<Viaje> viajes) {
		this.viajes = viajes;
	}
	
	/*--------------------METODOS---------------------*/
	
	@Override
	public String toString() {
		return "Tarjeta id=" + idTarjeta + ", nroTarjeta=" + nroTarjeta + ", saldo=" + saldo
				+ ", tarjetaActiva=" + tarjetaActiva + "";
	}
	
	public boolean agregarViaje(Viaje viaje){
		return true;
	}

	public Viaje traerUltimoViaje() {
		Viaje v=new Viaje();
		return v;
	}

}
