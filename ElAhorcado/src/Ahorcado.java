

import java.io.IOException;
import java.text.Normalizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ahorcado
 */
@WebServlet("/Ahorcado")
public class Ahorcado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ahorcado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String[] palabras = {"Ajolote","Tiburón","Ornitorrinco","Rinoceronte","Elefante","Cocodrilo","Camaleón",
				"Serpiente","Canguro","Tarántula"};
		String palabra = palabras[(int) (Math.random()*10)].toUpperCase();
		String cadenaNormalize = Normalizer.normalize(palabra, Normalizer.Form.NFD);   
		String palabraLimpia = cadenaNormalize.replaceAll("[^\\p{ASCII}]", "").toUpperCase();
		String uLetra="";
		String lUsadas="";
		Integer fallos=0;
		Integer turnos=1;
		Boolean acabar=false;
		Boolean repeticion=false;
		char[] palabraPA = palabra.toCharArray();
		for(int i=0; i<palabra.length(); i++) {
			palabraPA[i] ='-';
		}
		String pSplit="<table border='2' witdh='20'><tr>";
		for(int i=0; i<palabra.length(); i++) {
			pSplit = pSplit+"<td>"+palabraPA[i];
		}
		pSplit = pSplit + "</tr></table>";
		
		HttpSession laSesion= request.getSession(true);
		laSesion.setAttribute("palabra", palabra);
		laSesion.setAttribute("palabraLimpia", palabraLimpia);
		laSesion.setAttribute("fallos", fallos);
		laSesion.setAttribute("turnos", turnos);
		laSesion.setAttribute("uLetra", uLetra);
		laSesion.setAttribute("lUsadas", lUsadas);
		laSesion.setAttribute("pSplit", pSplit);
		laSesion.setAttribute("palabraPA", palabraPA);
		laSesion.setAttribute("acabar", acabar);
		laSesion.setAttribute("repeticion", repeticion);

		String vista = "/doPost.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
		String letraRecibida = (String) request.getParameter("letra");
		Boolean repeticion = (Boolean) laSesion.getAttribute("repeticion");
		if(letraRecibida==""||letraRecibida==null) {
			letraRecibida=" ";
		}
		letraRecibida = letraRecibida.toUpperCase();
		if(lUsadas.contains(letraRecibida)) {
			repeticion=true;
		}else {
			repeticion=false;
			boolean check = false;
			
			for(int i=0; i<palabra.length(); i++) {
				if(palabraLimpia.charAt(i)==letraRecibida.charAt(0)) {
					palabraPA[i] = palabra.charAt(i);
					check = true;
				}
			}
			pSplit="<table border='2' witdh='20'><tr>";
			for(int i=0; i<palabra.length(); i++) {
				pSplit = pSplit+"<td>"+palabraPA[i];
			}
			pSplit = pSplit + "</tr></table>";
			if(check==false) {
				if(lUsadas.contains(letraRecibida)==false) {
					fallos++;
				}
				
			}
			int aux=0;
			for(int i=0; i<palabraPA.length; i++) {
				if(palabraPA[i]!='-') {
					aux++;
				}
			}
			if(aux>=palabraPA.length) {
				acabar=true;
			}
			if(fallos>=6) {
				acabar=true;
			}
			
			turnos++;
			if(letraRecibida==" ") {
				
			}else {
				lUsadas = lUsadas+letraRecibida+", ";
			}
			uLetra = letraRecibida;
		}
		
		laSesion.setAttribute("palabra", palabra);
		laSesion.setAttribute("palabraLimpia", palabraLimpia);
		laSesion.setAttribute("fallos", fallos);
		laSesion.setAttribute("turnos", turnos);
		laSesion.setAttribute("uLetra", uLetra);
		laSesion.setAttribute("lUsadas", lUsadas);
		laSesion.setAttribute("pSplit", pSplit);
		laSesion.setAttribute("palabraPA", palabraPA);
		laSesion.setAttribute("acabar", acabar);
		laSesion.setAttribute("repeticion", repeticion);
		
		String vista = "/doPost.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
		dispatcher.forward(request, response);
	}

}
