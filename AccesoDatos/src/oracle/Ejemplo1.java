package oracle;
import java.sql.*;

public class Ejemplo1 {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","normal", "soynormal");
			
			//Connection conexion= Uconnection.getConnection();

			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sql = "SELECT * FROM departamentos";
			ResultSet resul = sentencia.executeQuery(sql);
			
			

				// Recorremos el resultado para visualizar cada fila
				// Se hace un bucle mientras haya registros y se van visualizando
		
				while (resul.next()) {
					System.out.printf("%d, %s, %s %n", resul.getInt(1), resul.getString(2), resul.getString(3));
					//
					//otra alternativa, indicando los nombres de los campos
					// System.out.printf("%d, %s, %s %n", resul.getInt("dept_no"), resul.getString("dnombre"), resul.getString("loc"));
					
				}
			

			//una vez finalizado el recorrido, cerramos los recursos
			resul.close(); // Cerrar ResultSet
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexión

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}// fin de main
}// fin de la clase
