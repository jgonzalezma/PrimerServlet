package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;
public class Logear extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nombre = request.getParameter("nombre");
		String contrasena = request.getParameter("constrasena");
		
		if(nombre.equals("zubiri") && contrasena.equals("manteo")){
			//enviar a listar usuarios
			Usuario usuarioLogeado = new Usuario();
			usuarioLogeado.setNombre("zubiri");
			
			HttpSession session = request.getSession();
			session.setAttribute("usuarioLogeado", usuarioLogeado);
			
			RequestDispatcher rd = request.getRequestDispatcher("ListarUsuarios");
			rd.forward(request, response);
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("adios.html");
			rd.forward(request, response);
		}
	}
}
