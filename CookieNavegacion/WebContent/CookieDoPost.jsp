<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     session= "false" %>
<%
	String nombre=(String)request.getAttribute("nombre");
	String clave=(String)request.getAttribute("clave");
	String incorrecto=(String)request.getAttribute("incorrecto");
	String visitas = (String) request.getAttribute("visitas");
	String estado = (String) request.getAttribute("estado");
	String checked = "checked=\"checked\"";
	String inst = "", val = "", mys = "";
	if(estado.equals("mys")){
		mys = checked;
	}else if(estado.equals("val")){
		val = checked;
	}else {
		inst = checked;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Creacion de cookies</title>
</head>
<body>
	<div color><%=incorrecto %></div>
	<form action="CookieNavegacion" method="get">   
        	<input type="radio" name="estado" value="int" <%=inst %> > Instint<br>
			<input type="radio" name="estado" value="val" <%=val %> > Valor<br>
			<input type="radio" name="estado" value="mys" <%=mys %> > Mystic<br>
			<input type="hidden" name="nombre" value="<%=nombre %>">
			<input type="hidden" name="clave" value="<%=clave %>">
			<input type="submit" value="Desconectar">
    </form>
	Veces que has iniciado sesion: <%=visitas %>
</body>
</html>