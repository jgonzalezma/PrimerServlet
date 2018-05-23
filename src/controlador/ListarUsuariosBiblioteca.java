package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.ModeloUsuario;
import modelo.Usuario;

public class ListarUsuariosBiblioteca extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		if (usuario != null) {
			String nombreUsuario = request.getParameter("nombre");

			ModeloUsuario mu = new ModeloUsuario();
			ArrayList<Usuario> usuarios = mu.selectAll();
			
			Usuario user = new Usuario();
			user.setNombre(nombreUsuario);
			
			usuarios.add(user);

			request.setAttribute("usuarios", usuarios);

			RequestDispatcher rd = request.getRequestDispatcher("listarUsuarios.jsp");
			rd.forward(request, response);
	}else{
		response.sendRedirect("adios.html");
	}
	}
}
