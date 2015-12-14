import java.sql.*;


public class Test_Prueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			//Cargamos el driver
			Class.forName("com.mysql.jdbc.Driver");
	
			//Preparamos la conexion
			Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo","root","root");
		
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