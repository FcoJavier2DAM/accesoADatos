import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test_PruebaData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// Cargamos el driver
			Class.forName("com.mysql.jdbc.Driver");

			// Preparamos la conexion
			Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root",
					"root");

			// Creamos el objeto DatabaseMetaData
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet result = null;

			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String user = dbmd.getUserName();

			System.out.println("INFORMACION DE LA BASE DE DATOS");
			System.out.println("===============================");
			System.out.println("Nombre " + nombre);
			System.out.println("Driver " + driver);
			System.out.println("URL " + url);
			System.out.println("Usuario " + user);

			// Obtener informacion de las tablas y vistas que hay
			result = dbmd.getTables(null, "ejemplo", null, null);

			while (result.next()) {

				int id = result.getInt(0);
				String nombreDepart = result.getString(1);
				System.out.println("Departamento: "+id+" "+nombreDepart);
			}
			
			conexion.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
