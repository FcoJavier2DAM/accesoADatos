import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_PruebaAcces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
		
			//Primero debemos crear el origen de datos de ODBC con la herramienta de Windows
			
			//Cargamos el driver
			Class.forName("com.mysql.jdbc.Driver");
	
			//Preparamos la conexion
			Connection conexion = (Connection) DriverManager.getConnection("jdbc:odbc:EJEMPLO-ACCES");
		
			//Recorremos el resultado para visualizarlo por filas
			Statement sentencia = conexion.createStatement();
			ResultSet resul = sentencia.executeQuery("SELECT * FROM departamentos");
			
			while(resul.next()){
				
					System.out.println(resul.getInt(1)+" "+resul.getString(2));
			}
		
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
