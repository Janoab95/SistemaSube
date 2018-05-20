package funciones;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Funciones {

	public static int traerAnio(GregorianCalendar fecha){
		
		return fecha.get(Calendar.YEAR);
	}
	
	public static String traerFechaCorta(GregorianCalendar fecha){
		
		int dia = Funciones.traerDia(fecha),mes = Funciones.traerMes(fecha),anio = Funciones.traerAnio(fecha);
		String fechaCorta = dia+"/"+mes+"/"+anio;
		
		return fechaCorta;
	}
	
	public static boolean esBisiesto(int anio){
		
		boolean bisiesto = false;
		if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))) bisiesto = true;
		
		return bisiesto;
	}
	
	public static int traerMes(GregorianCalendar fecha){
		return fecha.get(Calendar.MONTH)+1;
	}
	
	public static int traerDia(GregorianCalendar fecha){
		return fecha.get(Calendar.DATE);
	}
	
	public static boolean esFechaValida(int dia, int mes, int anio){
		
		boolean valida = false;
		boolean bisiesto = Funciones.esBisiesto(anio);
		
		if(mes>0 && mes<13){
			switch(mes){
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12: if(dia>0 && dia<32) valida = true;
						 break;
				case 2: if(bisiesto && dia>0 && dia<30) valida = true;
						else if(!bisiesto && dia>0 && dia<29) valida = true;
						break;
				case 4:
				case 6:
				case 9:
				case 11: if(dia>0 && dia<31) valida = true;
			}
		}
		
		return valida;
	}
	
	public static GregorianCalendar traerFecha(int anio, int mes, int dia){
		
		boolean valida = Funciones.esFechaValida(dia, mes, anio);
		GregorianCalendar fecha=new GregorianCalendar();
		
		if(valida) fecha.set(anio, mes-1, dia);
		
		return fecha;
	}
	
	public static GregorianCalendar traerFecha(String fecha){
	
		int dia = Integer.parseInt(fecha.substring(0, 2));
		int mes = Integer.parseInt(fecha.substring(3, 5));
		int anio = Integer.parseInt(fecha.substring(6, 10));
		
		boolean valida = Funciones.esFechaValida(dia, mes, anio);
		GregorianCalendar nuevaFecha=new GregorianCalendar();
		
		if(valida) nuevaFecha=Funciones.traerFecha(anio, mes, dia);
				
		return nuevaFecha;
	}
	
	public static String traerFechaCortaHora(GregorianCalendar fecha){
		
		String fechaYHora="";
		
		fechaYHora=Funciones.traerDia(fecha)+"/"+Funciones.traerMes(fecha)+"/"+Funciones.traerAnio(fecha)+" "+fecha.get(Calendar.HOUR)+":"+fecha.get(Calendar.MINUTE)+":"+fecha.get(Calendar.SECOND);
		
		return fechaYHora;
	}
	
	public static GregorianCalendar traerFechaProximo(GregorianCalendar fecha, int cantDias){
		
		GregorianCalendar fecha2=new GregorianCalendar();
		fecha2=(GregorianCalendar) fecha.clone();
		
		fecha2.add(Calendar.DATE, cantDias);
		
		return fecha2;
	}
	
	public static boolean esDiaHabil(GregorianCalendar fecha){
		
		boolean habil = false;
		int dia = fecha.get(Calendar.DAY_OF_WEEK);
		
		if((dia >= Calendar.MONDAY) && (dia <= Calendar.FRIDAY)) habil=true;
		
		return habil;
	}
	
	public static String traerDiaDeLaSemana(GregorianCalendar fecha) {
		
		String dia="";
		int numDia = fecha.get(Calendar.DAY_OF_WEEK);
		
		switch(numDia) {
			case 1: dia="Domingo";
				break;
			case 2: dia="Lunes";
				break;
			case 3: dia="Martes";
				break;
			case 4: dia="Miércoles";
				break;
			case 5: dia="Jueves";
				break;
			case 6: dia="Viernes";
				break;
			case 7: dia="Sábado";
				break;
		}
		
		return dia;
	}
	
	public static String traerMesEnLetras(GregorianCalendar fecha) {
		
		String mes="";
		int numMes = fecha.get(Calendar.MONTH);
		
		switch(numMes) {
			case 0: mes="Enero";
				break;
			case 1: mes="Febrero";
				break;
			case 2: mes="Marzo";
				break;
			case 3: mes="Abril";
				break;
			case 4: mes="Mayo";
				break;
			case 5: mes="Junio";
				break;
			case 6: mes="Julio";
				break;
			case 7: mes="Agosto";
			break;
			case 8: mes="Septiembre";
				break;
			case 9: mes="Octubre";
				break;
			case 10: mes="Noviembre";
				break;
			case 11: mes="Diciembre";
				break;
		}
		
		return mes;
	}
	
	public static String traerFechaLarga(GregorianCalendar fecha){
		
		String fechaLarga=Funciones.traerDiaDeLaSemana(fecha)+" "+Funciones.traerDia(fecha)+" de "+Funciones.traerMesEnLetras(fecha)+" del "+Funciones.traerAnio(fecha);
		
		return fechaLarga;
	}
	
	public static boolean sonFechasIguales(GregorianCalendar fecha, GregorianCalendar fecha1){
	
		boolean iguales=false;
		
		if(Funciones.traerDia(fecha)==Funciones.traerDia(fecha1)&&Funciones.traerMes(fecha)==Funciones.traerMes(fecha1)&&Funciones.traerAnio(fecha)==Funciones.traerAnio(fecha1)) iguales=true;
		
		return iguales;
	}
	
	public static boolean sonFechasHorasIguales(GregorianCalendar fecha, GregorianCalendar fecha1){
		
		boolean iguales=fecha.equals(fecha1);
		
		return iguales;
	}
	
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		
		int cantDias=0;
		boolean bisiesto=Funciones.esBisiesto(anio);
		
		switch(mes){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: cantDias=31;
					 break;
			case 2: if(bisiesto) cantDias=29;
					else if(!bisiesto) cantDias=28;
					break;
			case 4:
			case 6:
			case 9:
			case 11: cantDias=30;
		}
		return cantDias;
	}
	
	public static double aproximar2Decimal(double valor){
		
		double entero,decimal,segDec,entSegDec,terDec,redondeo;
		
		entero=Math.floor(valor);
		decimal=valor-entero;
		segDec=decimal*100;
		entSegDec=Math.floor(segDec);
		terDec=segDec-entSegDec;
		
		if(terDec>=0.5) redondeo=(entero+(entSegDec+1)/100);
		else redondeo=entero+entSegDec/100;
		
		return redondeo;
		
	}
	
	public static boolean esNumero(char c){
		
		boolean numero=Character.isDigit(c);
		
		return numero;
	}
	
	public static boolean esLetra(char c){
		
		boolean letra=Character.isLetter(c);
		
		return letra;
	}
	
	public static boolean esCadenaNros(String cadena){
		
		boolean cadenaNum=true;
		int i=0;
		
		while(cadenaNum&&i<cadena.length()){
			cadenaNum=Funciones.esNumero(cadena.charAt(i));
			i++;
		}
		
		return cadenaNum;
	}
	
	public static boolean esCadenaLetras(String cadena){
		
		boolean cadenaLetras=true;
		int i=0;
		
		while(cadenaLetras&&i<cadena.length()){
			cadenaLetras=Funciones.esLetra(cadena.charAt(i));
			i++;
		}
		
		return cadenaLetras;
	}
	
	public static double convertirADouble(int n ){
		return (( double) n);
	}
}
