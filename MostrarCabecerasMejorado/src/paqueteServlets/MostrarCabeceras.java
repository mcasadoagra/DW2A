package paqueteServlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/MostrarCabeceras")
public class MostrarCabeceras extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		try {
			// Línea de solicitud (request)
			out.println("<!doctype html><html>" + "\n" +
					"<head><title>Mostrar cabeceras HTTP</title></head>" + "\n" +
					"<body>" + "\n" +
	                "<h1>Mostrar cabeceras HTTP</h1>" + "\n" +
	                "<b>Request Method:</b> " + request.getMethod() + "<br /> \n" +
	                "<b>Request URI:</b> " + request.getRequestURI() + "<br /> \n" +
	                "<b>Request Protocol:</b> " + request.getProtocol() + "<br /><br /> \n" +
	                "<table border=\"1\">" + "\n" +
	                "<tr>" + "\n" +
	                "<th>Nombre</th>" + "\n" +
	                "<th>Valor" + "\n");

			// Cabeceras de la solicitud (request)
			Enumeration<String> cabeceras = request.getHeaderNames();
			while(cabeceras.hasMoreElements()) {
				String nombre = (String)cabeceras.nextElement();
				out.println("<tr><td>" + nombre + "</td>");
				out.println("    <td>" + request.getHeader(nombre) + "</td>");
				out.println("</tr>");
			}
			out.println("</table> \n </body></html>");
   	     	} finally {
        	    out.close();
        	}
	}
}
