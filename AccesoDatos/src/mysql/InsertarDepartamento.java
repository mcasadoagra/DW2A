package mysql;
import java.sql.*;
import java.util.Scanner;

public class InsertarDepartamento {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");// Cargar el driver
			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://localhost/ejemplo", "normal", "");
			
			
		
			// pedimos los valores del nuevo departamento con un escáner
			Scanner teclado = new Scanner (System.in);
			System.out.println("Escribe los datos del nuevo departamento");
			System.out.println("Código \n>>>");
			String dep= teclado.nextLine();
			
			System.out.println("Nombre \n>>>");
			String dnombre = teclado.nextLine();
			
			System.out.println("Localidad \n>>>");
			String loc = teclado.nextLine(); // localidad
			
			
			//construir la orden INSERT	 
			// observar que los parámetros que son VARCHAR deben ir entrecomillados
	        String sql = String.format("INSERT INTO departamentos VALUES (%s, '%s', '%s')",
	        		dep,dnombre,loc);
	        
	     
			Statement sentencia = conexion.createStatement();
			int filas=0;
			try {
			  filas = sentencia.executeUpdate(sql.toString());
			  System.out.println("REgistros insertados " + filas);
			} catch (SQLException e) {
				//e.printStackTrace();
				   System.out.printf("HA OCURRIDO UNA EXCEPCIÓN:%n"); 
				   System.out.printf("Mensaje   : %s %n", e.getMessage()); 
				   System.out.printf("SQL estado: %s %n", e.getSQLState()); 
				   System.out.printf("Cód error : %s %n", e.getErrorCode());	    	
			}
			//por último, se cierran los recursos
			finally{
				sentencia.close(); // Cerrar Statement
				conexion.close(); // Cerrar conexión
				teclado.close();
			}
			
			// 

			

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// fin de main
}// fin de la clase