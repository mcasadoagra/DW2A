import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Utilidades {
	
	public static Connection crearConexion(String url, String usuario, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conexion = null;
		try {
			if (conexion == null) {
				conexion = DriverManager.getConnection(url, usuario, pass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	
	public static Connection crearConexion2(String url, String usuario, String pass) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conexion = null;
		try {
			if (conexion == null) {
				conexion = DriverManager.getConnection(url, usuario, pass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conexion;
	}
	
	public static void crearBBDD(Connection conexion) {
		try {
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("CREATE DATABASE IF NOT EXISTS " + "basket");
			sentencia.close();
		} catch (SQLException e) {
			System.err.println("Error en la base de datos");
			e.getMessage();
			e.printStackTrace();
		} 
	}
	
	
	
	public static void crearTablas(Connection conexion) {
		Statement sentencia;
		try {
			sentencia = conexion.createStatement();
			sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS equipos "
									+ "(id int(11) NOT NULL, "
									+ "nombre varchar(50) NOT NULL, "
									+ "ciudad varchar(50) NOT NULL, "
									+ "entrenador varchar(50) NOT NULL, "
									+ "PRIMARY KEY(id))");
			
			sentencia.executeUpdate("CREATE TABLE IF NOT EXISTS jugadoras "
									+ "(id int(11) NOT NULL,  "
									+ "nombre varchar(50) NOT NULL, "
									+ "apellido varchar(50) NOT NULL, "
									+ "edad int(11) NOT NULL, "
									+ "estatura float(11) NOT NULL, "
									+ "posicion varchar(50) NOT NULL, "
									+ "equipo int(11) NOT NULL, "
									+ "PRIMARY KEY(id),"
									+ "FOREIGN KEY(equipo) REFERENCES equipos(id) )");									
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void addJugadoras(Connection conexion) {
		try {
			Statement sentencia = conexion.createStatement();
			sentencia.executeUpdate("INSERT INTO equipos VALUES (1, 'Real Madrid', 'Madrid', 'Pablo Laso')");
			sentencia.executeUpdate("INSERT INTO equipos VALUES (2, 'Barcelona', 'Barcelona', 'Alejandra Martinez')");
			sentencia.executeUpdate("INSERT INTO equipos VALUES (3, 'Unicaja', 'Malaga', 'Paca Pacheco')");
			sentencia.executeUpdate("INSERT INTO jugadoras VALUES (1, 'Pepa', 'Reyes', 23, 1.75, 'base', 1)");
			sentencia.executeUpdate("INSERT INTO jugadoras VALUES (2, 'Marina', 'Cerro', 33, 1.67, 'ala pivot', 2)");	
			sentencia.executeUpdate("INSERT INTO jugadoras VALUES (3, 'Marcelina', 'Rodriguez', 25, 1.77, 'ala delta', 3)");	
			sentencia.executeUpdate("INSERT INTO jugadoras VALUES (4, 'Carla', 'Muñoz', 27, 2.17, 'ala pivot', 1)");	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}

