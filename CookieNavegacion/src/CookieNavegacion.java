
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class CookieNavegacion
 */
@WebServlet("/CookieNavegacion")
public class CookieNavegacion extends HttpServlet {
	private static final long serialVersionUID = 2L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CookieNavegacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getCookies() != null) {
			String nombre = request.getParameter("nombre");
			String estado = request.getParameter("estado");
			for (int i = 0; i < request.getCookies().length; i++) {
				if (request.getCookies()[i].getName().equals(nombre)) {
					String[] a = request.getCookies()[i].getValue().split("#");
					Cookie user = new Cookie(nombre, a[0] + "#" + a[1] + "#" + estado);
					response.addCookie(user);
				}
			}
		}
		request.setAttribute("nombre", "");
		request.setAttribute("clave", "");
		request.setAttribute("incorrecto", "");
		String vista = "/CookieDoGet.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> data = new HashMap<String, String>();
		data.put("Candela", "asd");
		data.put("Blanche", "asd");
		data.put("Spark", "asd");
		Cookie user = null;
		String incorrecto = "";
		String visitas = "";
		String estado = "";
		String nombre = request.getParameter("nombre");
		String clave = request.getParameter("clave");
		boolean check = false;
		boolean check2 = false;
		boolean check3 = false;

		for (Map.Entry<String, String> entry : data.entrySet()) {
			if (entry.getKey().equals(nombre) && entry.getValue().equals(clave)) {
				check = true;
				request.setAttribute("nombre", nombre);
				request.setAttribute("clave", clave);
			}
		}

		if (check == true) {
			if (request.getCookies() == null) {
				user = new Cookie(nombre, clave + "#1#none");
				visitas = "1";
				response.addCookie(user);
			} else {
				for (int i = 0; i < request.getCookies().length; i++) {
					if (request.getCookies()[i].getName().equals(nombre)) {
						check2 = true;
						check3 = true;
						String[] a = request.getCookies()[i].getValue().split("#");
						Integer b = Integer.parseInt(a[1]);
						b++;
						visitas = b.toString();
						estado = a[2];
						user = new Cookie(nombre, a[0] + "#" + b.toString() + "#" + a[2]);
						response.addCookie(user);
					}

				}
				if (check3 == false) {
					user = new Cookie(nombre, clave + "#1#none");
					visitas = "1";
					response.addCookie(user);
				}
			}
			if (check2 == false) {
				incorrecto = "Bienvenido, " + nombre;
			} else {
				incorrecto = "Hola de nuevo, " + nombre;
			}
			request.setAttribute("visitas", visitas);
			request.setAttribute("incorrecto", incorrecto);
			request.setAttribute("estado", estado);
			String vista = "/CookieDoPost.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
			dispatcher.forward(request, response);
		} else {
			incorrecto = "Usuario o contraseña incorrecto";
			request.setAttribute("nombre", "");
			request.setAttribute("clave", "");
			request.setAttribute("incorrecto", incorrecto);
			String vista = "/CookieDoGet.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
			dispatcher.forward(request, response);
		}
	}

}
