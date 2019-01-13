

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ComAuto
 */
@WebServlet("/ComAuto")
public class ComAuto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComAuto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
    protected void procesaSolicitud(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String[] galicia = {"La coruña","Lugo","Pontevedra","Orense"};
        String[] asturias = {"Asturias"};
        String[] cantabria = {"Cantabria"};
        String[] navarra = {"Navarra"};
        String[] paisVasco = {"Vizcaya","Guipuzcoa","Alava"};
        String[] laRioja = {"La Rioja"};
        String[] aragon = {"Huesca","Zaragoza","Teruel"};
        String[] cataluña = {"Lleida","Girona","Barcelona","Tarragona"};
        String[] castillaLeon = {"Leon","Palencia","Burgos","Soria","Zamora","Valladolid","Segovia","Salamanca","Avila"};
        String[] madrid = {"Madrid"};
        String[] castillaMancha = {"Guadalajara","Toledo","Cuenca","Ciudad Real","Albacete"};
        String[] cValenciana = {"Valencia","Castellon","Alicante",};
        String[] extremadura = {"Caceres","Badajoz"};
        String[] murcia = {"Murcia"};
        String[] andalucia = {"Huelva","Sevilla","Cadiz","Malaga","Jaen","Granada","Almeria"};
        String[] ceuta = {"Ceuta"};
        String[] melilla = {"Melilla"};
        String[] islasBaleares = {"Ibiza","Mallorca","Menorca"};
        String[] islasCanarias = {"La Palma","EL Hierro","La Gomera","Tenerife","Gran Canaria","Fuerteventura","Lanzarote"};
        
        LinkedHashMap<String, String[]> comunidades = new LinkedHashMap<String, String[]>();
        comunidades.put ("Galicia", galicia);
        comunidades.put ("Asturias", asturias);
        comunidades.put ("Cantabria", cantabria);
        comunidades.put ("Navarra", navarra);
        comunidades.put ("Pais Vasco", paisVasco);
        comunidades.put ("La Rioja", laRioja);
        comunidades.put ("Aragon", aragon);
        comunidades.put ("Cataluña", cataluña);
        comunidades.put ("Castilla y Leon", castillaLeon);
        comunidades.put ("Madrid", madrid);
        comunidades.put ("Castilla la Mancha", castillaMancha);
        comunidades.put ("Comunidad Valenciana", cValenciana);
        comunidades.put ("Extremadura", extremadura);
        comunidades.put ("Murcia", murcia);
        comunidades.put ("Andalucia", andalucia);
        comunidades.put ("Ceuta", ceuta);
        comunidades.put ("Melilla", melilla);
        comunidades.put ("Islas Baleares", islasBaleares);
        comunidades.put ("Islas Canarias", islasCanarias);
    	
    	// Comprobar si la petición es mediante Ajax
        Boolean esAjax;
        esAjax="XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With")); // Cabecera X-Requested-With
        if (esAjax) {
        	String com = request.getParameter("com");
        	String[] prov = comunidades.get(com);
        	
        	String provselect="<select name=\"prov\" id=\"prov\">";
        	
        	for(int i=0; i<prov.length; i++) {
        		provselect = provselect +  "<option value='"+prov[i]+"'>"+prov[i]+"</option>";
        	}
        	provselect = provselect + "</select>";
        	out.print(provselect);
        }    
        else {
            out.println("Este servlet solo se puede invocar vía Ajax");
        }    
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesaSolicitud (request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		procesaSolicitud (request, response);
		}

}
