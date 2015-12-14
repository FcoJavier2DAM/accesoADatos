import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_Prueba {

	private final static String RUTA = "jdbc:hsqldb:hsql://localhost/xdb";
	private final static String USER="SA";
	private final static String PASSWORD="";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			//Cargamos el driver
			Class.forName("org.hsqldb.jdbcDriver");
	
			//Preparamos la conexion
			Connection conexion = (Connection) DriverManager.getConnection(RUTA,USER,PASSWORD);
		
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
