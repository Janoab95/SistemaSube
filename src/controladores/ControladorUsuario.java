package controladores;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.HibernateException;
import datos.Usuario;
import negocio.UsuarioABM;

public class ControladorUsuario extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		procesarPeticion(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		procesarPeticion(request, response);
	}
	
	private void procesarPeticion(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		response.setContentType("text/html;charset=UTF-8");
		try{
			int dni=Integer.parseInt(request.getParameter("dni"));
			
			//UsuarioAbm.getInstance().traerCliente(dni);
			response.setStatus(200);
			PrintWriter salida=response.getWriter();
			salida.println("");
			salida.println("<!DOCTYPE 4.01 Transitional//EN\">");
			salida.println("<HTML>");
			salida.println(" <HEAD>");
			salida.println(" <TITLE>Sistema Sube</TITLE>");
			salida.println(" </HEAD>");
			salida.println(" <BODY>");/*
			salida.println(" Apellido: "+usuario.getApellido()+"<BR>");
			salida.println(" Nombre : "+usuario.getNombre()+"<BR>");
			salida.println(" DNI : "+usuario.getDocumento()+"<BR>");
			salida.println(" ID : "+usuario.getIdCliente()+"<BR>");*/
			salida.println("<A href=\"/SistemaSube/cliente.html\">Volver...</A>");
			salida.println(" </BODY>");
			salida.println("</HTML>");
		}
		catch(Exception e){
			response.sendError(500,"El DNI ingresado no existe.");
		}
	}
}
