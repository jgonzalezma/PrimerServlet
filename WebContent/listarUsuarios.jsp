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
<div><h1>La lista de usuarios</h1></div>
<%
	for(Usuario usuario : usuarios){
		out.println(usuario.getNombre() + "<br>");
	}
%>
<a href="ListarUsuarios?nombre=Juan">Prueba get</a>
<form action="ListarUsuarios" method="Post">
<input type="text" name="nombre"/>
<input type="submit" value="enviar"/>
</form>

<div><h1>La lista de usuarios con jstl</h1></div>
	<c:forEach ${usuarios} var="usuario">
		${usuario.nombre} <br>
	</c:forEach>
	
</body>
</html>