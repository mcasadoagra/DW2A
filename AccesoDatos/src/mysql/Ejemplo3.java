package mysql;
import java.sql.*;

public class Ejemplo3 {

	public static void main(String[] args)  {
		
		try{

				//CONEXION A MYSQL  	       
					Class.forName("com.mysql.jdbc.Driver");		 
					Connection conexion = DriverManager.getConnection    
							("jdbc:mysql://localhost/ejemplo","normal", "");   		   
			
					String sql="SELECT * FROM departamentos";
					Statement sentencia = conexion.createStatement();		   
					boolean valor = sentencia.execute(sql);  
					   
				if(valor){
					// si es verdadero, devuelve un conjunto de filas
				 	ResultSet rs = sentencia.getResultSet();
				 	// recorremos todas las filas y las mostramos
					 while (rs.next()){
					    System.out.printf("%d, %s, %s %n",
					    		rs.getInt(1), rs.getString(2), rs.getString(3));
					 }
					 //cerramos el resultse
				 	rs.close();
				} else {
					// si es falso, se ha hecho una operación DML/DDL que no devuelve filas
				 	int afectadas = sentencia.getUpdateCount();
				 	System.out.printf("Filas afectadas:%d %n", afectadas);
				}
					//cerramos los objetos utilizados
					sentencia.close();
					conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}//fin de la clase main
}//
