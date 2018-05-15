package controlador;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;

public class ListarUsuarios extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		//recibir datos
		String nombreUsuario = request.getParameter("nombre");
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usuario = new Usuario();
		usuario.setNombre("Jon");
		usuarios.add(usuario);
		usuario = new Usuario();
		usuario.setNombre("Imanol");
		usuarios.add(usuario);
		usuario = new Usuario();
		usuario.setNombre(nombreUsuario);
		usuarios.add(usuario);
		
		//enviar datos
		request.setAttribute("usuarios", usuarios);
		
		RequestDispatcher rd = request.getRequestDispatcher("listarUsuarios.jsp");
		rd.forward(request, response);
	}
}
