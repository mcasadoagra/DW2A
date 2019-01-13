import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jugadores {

	public static void main(String[] args) {
		
		Connection conexion1 = Utilidades.crearConexion("jdbc:mysql://localhost:3306/", "alumno", "alumno");
		Utilidades.crearBBDD(conexion1);
		
		Connection conexion2 = Utilidades.crearConexion("jdbc:mysql://localhost:3306/basket", "alumno", "alumno");
		Utilidades.crearTablas(conexion2);
		Utilidades.addJugadoras(conexion2);
		
	}

}
