package test;

import datos.Cliente;
import negocio.ClienteABM;

public class Test {

	public static void main(String[] args) {

		try{
			Cliente c=ClienteABM.getIntance().traerCliente(1);
			System.out.println(c);
		}
		catch (Exception e){
			System.out.println("Error: "+e);
		}
		
	}

}
