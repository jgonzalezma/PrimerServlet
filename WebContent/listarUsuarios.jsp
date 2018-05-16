<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!-- para poder utilizar etiquetas de jstl -->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="modelo.*" %>
    <%
    ArrayList<Usuario> usuarios = (ArrayList)request.getAttribute("usuarios");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div><h1>La lista de usuarios con java</h1></div>
<%
	for(Usuario usuario : usuarios){
		out.println(usuario.getNombre() + "<br>");
	}
%>
<form action="ListarUsuarios">
<input type="text" name="nombre"/>
<input type="submit" value="enviar"/>
</form>

	<h1>La lista de usuarios con jstl</h1>
	<c:forEach items="${usuarios}" var="usuario">
		${usuario.nombre} <br>
	</c:forEach>
	<br>
	<h1>Lista de usuarios de biblioteca</h1>
	<c:forEach items="${usuarios}" var="usuario">
		${usuario.apellido} <br>
	</c:forEach>
	
</body>
</html>