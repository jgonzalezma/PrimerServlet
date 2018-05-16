package controlador;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloUsuario;
import modelo.Usuario;

public class ListarUsuariosBiblioteca extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		ModeloUsuario modeloUsuario = new ModeloUsuario();
		String nombreUsuario = request.getParameter("nombre");
		ArrayList<Usuario> usuarios = modeloUsuario.selectAll();
		Usuario usuario = new Usuario();
		usuario.setNombre(nombreUsuario);
		
		request.setAttribute("usuarios", usuarios);

		RequestDispatcher rd = request.getRequestDispatcher("listarUsuarios.jsp");
		rd.forward(request, response);
	}
}
