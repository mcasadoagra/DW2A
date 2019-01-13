<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    session= "false"
    %>
<%
	String nombre=(String)request.getAttribute("nombre");
	String clave=(String)request.getAttribute("clave");
	String incorrecto=(String)request.getAttribute("incorrecto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creacion de cookies</title>
<style>
			div {
			    color: red;
			}
		</style>
</head>
<body>
	<h1>Introduce tu usuario y contraseña</h1>
		<div color><%=incorrecto %></div>
        <form action="CookieNavegacion" method="post">   
        	Nombre: <input type="text" name=nombre size=20 maxlength=20 value=<%=nombre %>><br>
			Clave: <input type="password" name=clave size=50 maxlength=50 value=<%=clave %>><br>
			<input type="submit" value="Enviar">
        </form>
</body>
</html>