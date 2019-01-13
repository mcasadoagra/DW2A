package paqueteServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/MuestraVariablesServidor")
public class MuestraVariablesServidor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {         
            out.println("<!doctype html><html>" + "\n");
            out.println("<head><title>Mostrar Variables</title></head>" + "\n");
            out.println("<body>" + "\n");
            out.println("<h1>Mostrar Variables</h1>" + "\n");
            out.println("Este servlet muestra las variables contenidas en la petición (objeto request) <br/><br />");
            out.println("<table border=\"1\">" + "\n");
            out.println("<tr><td><b>Variable</b></td><td><b>Valor</b></td></tr>" + "\n");
            out.println("<tr><td>Software de SERVIDOR</td><td>" + request.getServletContext().getServerInfo() + "</td></tr>");
            out.println("<tr><td>Directorio de DESPLIEGUE</td><td>" + request.getServletContext().getRealPath("/")+ "</td></tr>");
            out.println("</table>" + "\n");

            out.println("<hr /><br />" + "\n");

            out.println("<table border=\"1\">" + "\n");
            out.println("<tr><td><b>Variable</b></td><td><b>Valor</b></td></tr>" + "\n");
            out.println ("<tr> <td>Dirección remota (request.getRemoteAddress)</td> <td>" + request.getRemoteAddr() + "</td></tr>");
            out.println ("<tr> <td>Puerto remoto (request.getRemotePort)</td> <td>" + request.getRemotePort() + "</td></tr>");
            out.println("<tr><td>URL invocada (request.getRequestURL)</td><td>" + request.getRequestURL() + "</td></tr>");
            out.println ("<tr><td>Método de petición (request.getMethod)</td> <td>" + request.getMethod() + "</td></tr>");
            out.println ("<tr><td>Protocolo (request.getProtocol)</td> <td>" + request.getProtocol() + "</td></tr>");
            
            out.println ("<tr><td>Nombre del Servidor (request.getServerName)</td> <td>" + request.getServerName() + "</td></tr>");
            out.println ("<tr><td>Puerto del Servidor (request.getServerPort)</td> <td>" + request.getServerPort() + "</td></tr>");
            out.println ("<tr><td>Nombre del ServletPath (request.getServletPath)</td> <td>" + request.getServletPath()+ "</td></tr>");
            
            out.println("</table>" + "\n");
            out.println("</body></html>" + "\n");
        } finally {            
            out.close();
        }
    }
}
