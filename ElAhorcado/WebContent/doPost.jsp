<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
HttpSession laSesion = request.getSession();
String palabra = (String)laSesion.getAttribute("palabra");
String palabraLimpia = (String)laSesion.getAttribute("palabraLimpia");
Integer turnos = (Integer)laSesion.getAttribute("turnos");
Integer fallos = (Integer)laSesion.getAttribute("fallos");
String uLetra = (String)laSesion.getAttribute("uLetra");
String lUsadas = (String)laSesion.getAttribute("lUsadas");
String pSplit= (String)laSesion.getAttribute("pSplit");
char[] palabraPA = (char[]) laSesion.getAttribute("palabraPA");
Boolean acabar = (Boolean) laSesion.getAttribute("acabar");
Boolean repeticion = (Boolean) laSesion.getAttribute("repeticion");
String repetido="";
if(repeticion==true){
	repetido="Ya has introducido esta letra";
}else{
	repetido="";
}
String method="";
String mensajeF="";
String type="";
String value="";
if(acabar==true){
	method="get";
	type="hidden";
	value="Jugar otra vez";
	mensajeF="Partida finalizada! Jugar de nuevo?";
}else{
	method="post";
	type="text";
	value="Enviar";
}
String src="";
if(fallos==0){
	src="/ElAhoracado/0fails.PNG";
}else if(fallos==1){
	src="/ElAhoracado/1fails.PNG";
}else if(fallos==2){
	src="/ElAhoracado/2fails.PNG";
}else if(fallos==3){
	src="/ElAhoracado/3fails.PNG";
}else if(fallos==4){
	src="/ElAhoracado/4fails.PNG";
}else if(fallos==5){
	src="/ElAhoracado/5fails.PNG";
}else if(fallos==6){
	src="/ElAhoracado/6fails.PNG";
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>El ahorcado</title>
<style>
	div {
	
	}
	h1 {
		color: red;
		font-family: "Courier New", Courier, monospace;
	}
	h2 {
		color: red;
	}
</style>
</head>
<body>
	<table>
		<tr>
		<td>
			<h1>El ahorcado</h1><br>
			<img src="<%=src %>"><br>
			<%=pSplit %>
			
		</td>
		<td>
			<h2><%=repetido %></h2>
			<form action="Ahorcado" method=<%=method %>>   
        	&nbsp;<input type=<%=type %> name="letra" size="10" maxlength="1" value="" placeholder="Introduce una letra">
			&nbsp;<input type="submit" value=<%=value %>><br>
			&nbsp;Turno: <%=turnos %><br>
			&nbsp;Nº de fallos: <%=fallos %><br>
			&nbsp;Última letra usada: <%=uLetra %><br>
			&nbsp;Letras usadas: <%=lUsadas %><br><br>
			&nbsp;<%=mensajeF %><br><br>
			
        </form>
		</td>
		</tr>
	</table>

</body>
</html>