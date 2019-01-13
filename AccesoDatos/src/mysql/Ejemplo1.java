package mysql;
import java.sql.*;

public class Ejemplo1 {

	public static void main(String[] args) {
		try {
			// Cargar el driver para MySQL
			Class.forName("com.mysql.jdbc.Driver");

			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/empresa", "alumno", "alumno");
			
			//Connection conexion= Uconnection.getConnection();

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sql = "SELECT asd FROM emp";
			ResultSet resul = sentencia.executeQuery(sql);
			
			//Contamos el n�mero de registros devueltos, situ�ndonos al final del conjunto de registros
			resul.last();
			int num_filas= resul.getRow();
			
			if (num_filas>0){

				// Recorremos el resultado para visualizar cada fila
				// Se hace un bucle mientras haya registros y se van visualizando
				//nos situamos antes del primer registro
				resul.beforeFirst();
				while (resul.next()) {
					System.out.printf("%d, %s, %s %n", resul.getInt(1), resul.getString(2), resul.getString(3));
					//
					//otra alternativa, indicando los nombres de los campos
					// System.out.printf("%d, %s, %s %n", resul.getInt("dept_no"), resul.getString("dnombre"), resul.getString("loc"));
					
				}
			} else {
				System.out.println("La consulta no ha devuelto ning�n resultado");
			}

			//una vez finalizado el recorrido, cerramos los recursos
			resul.close(); // Cerrar ResultSet
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexi�n

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// fin de main
}// fin de la clase
