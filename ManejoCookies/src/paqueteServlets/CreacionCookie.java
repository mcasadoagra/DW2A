package paqueteServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import paqueteAuxiliar.RandomString;


@WebServlet("/CreacionCookie")
public class CreacionCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie[] listaCookiesRecibidas = request.getCookies();
		if (listaCookiesRecibidas != null) {
			out.println("Lista de cookies enviadas por el cliente HTTP" + " <br />");
			boolean existeCookieUid = false;
			for (int i=0; i< listaCookiesRecibidas.length; i++) {
				Cookie unaCookie = listaCookiesRecibidas[i];
				String nombre = unaCookie.getName();
				String valor = unaCookie.getValue();
				out.println(nombre + " = " + valor + " <br />");
				if (nombre.equals("uid")) {
					existeCookieUid = true;
					out.println("Tú has estado antes por aquí, te conozco como <b>" + valor + "</b> <br />");
				}
			}
			if (!existeCookieUid) {
				out.println("No te conocía, pero te recordaré"+ " <br />");
			}
		} else {
			RandomString generadorCadenas = new RandomString(12);  // se instancia un generador de cadenas alfanuméricas de longitud 12
			String cadenaAleatoria = generadorCadenas.nextString();  // se genera una cadena alfanumérica aleatoria 
			Cookie unaCookie = new Cookie("uid",cadenaAleatoria);
		    unaCookie.setPath("/");
		    response.addCookie(unaCookie);
			out.println("No te conocía, pero te recordaré");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	

}
