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

public class Logear extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nombre = request.getParameter("nombre");
		String password = request.getParameter("password");

		ModeloUsuario mu = new ModeloUsuario();

		Usuario user;

		if (mu.selectUser(nombre) != null) {
			user = mu.selectUser(nombre);
		} else {
			user = new Usuario();
		}

		if (nombre.equals(user.getNombre()) && password.equals(user.getPassword())) {

			HttpSession session = request.getSession();

			session.setAttribute("usuario", user);

			RequestDispatcher rd = request.getRequestDispatcher("ListarUsuariosBiblioteca");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("adios.html");
			rd.forward(request, response);
		}
	}
}
