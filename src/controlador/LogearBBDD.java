package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ModeloUsuario;
import modelo.Usuario;

public class LogearBBDD extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
	
		ModeloUsuario mu = new ModeloUsuario();
		Usuario usuarioLogeado = mu.selectUser(nombre);
		
		out.println(usuarioLogeado);
		
		if(password.equals(usuarioLogeado.getPassword())){
			//enviar a listar usuario
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
