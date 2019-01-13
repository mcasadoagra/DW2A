package oracle;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class Uconnection {
	//propiedad estática con la conexión a la base de datos
	private static Connection conn= null;
	
	public static Connection getConnection(){
		try{
			if (conn==null){
				//fichero properties que posee las credneciales de conexión
				String protegida="C:/Users/programacion1/credenciales.properties";
				Properties p= new Properties();
				p.load(new FileReader(protegida));
				//leemos las credenciales
				String servidor=p.getProperty("servidor");
				String base=p.getProperty("base");
				String usuario=p.getProperty("usuario");
				String contrasena=p.getProperty("contrasena");
				Class.forName("com.mysql.jdbc.Driver");// Cargar el driver
				// Establecemos la conexion con la BD
				conn = DriverManager.getConnection
						(servidor+"/"+base, usuario, contrasena);
			}
			
		
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		// en cualquier caso, devolvemos la conexión
					return conn;
	} //fin del método estático

}
