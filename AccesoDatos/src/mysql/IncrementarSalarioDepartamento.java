package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class IncrementarSalarioDepartamento {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");// Cargar el driver
			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://localhost/ejemplo", "normal", "");
			
			
		
			// pedimos los valores del departamento y el incremento
			Scanner teclado = new Scanner (System.in);
			System.out.println("Incrementar el salario de los empleados del departamento");
			System.out.println("Código del departamento\n>>>");
			String dep= teclado.nextLine();
			
			System.out.println("Cantidad en que incrementaremos el sueldo\n>>>");
			String aumento = teclado.nextLine();
			
			
			
			
			//construir la orden UPDATE	 parametrizando los campos que recogemos anteriormente
			
	        String sql = "UPDATE empleados "
	        		+ "SET salario= salario +?"
	        		+ "WHERE dept_no=?";
	        
	        //instanciamos el objeto PreparedStatement
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			//ahora indicamos la correspondencia entre cada comodín y el valor que se guardará en el mismo
			sentencia.setDouble(1, Double.parseDouble(aumento));
			sentencia.setInt(2, Integer.parseInt(dep));
	
			//
			int filas=0;
			try {
			  filas = sentencia.executeUpdate();
			  System.out.println("Empleados a los que aumentamos el sueldo " + filas);
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

}
