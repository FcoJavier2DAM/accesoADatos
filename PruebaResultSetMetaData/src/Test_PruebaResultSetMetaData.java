import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class Test_PruebaResultSetMetaData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			// Cargamos el driver
			Class.forName("com.mysql.jdbc.Driver");

			// Preparamos la conexion
			Connection conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root",
					"root");

			Statement sentencia = conexion.createStatement();
			ResultSet result = sentencia.executeQuery("SELECT * FROM departamenteos");
			ResultSetMetaData resultMetaData = result.getMetaData();

			// Mostramos la informacion de las columnas de la tabla departamentos
			int nColumnas = resultMetaData.getColumnCount();
			String nulo;

			for (int i = 0; i < nColumnas; i++) {

				System.out.println("Columna " + i + ":");
				System.out.println("Nombre: " + resultMetaData.getColumnName(i));
				System.out.println("Tipo: " + resultMetaData.getColumnTypeName(i));

				if (resultMetaData.isNullable(i) == 0) {
					nulo = "No";
				} else {
					nulo = "Si";
				}

				System.out.println("¿Puede ser nulo?: " + nulo);
				System.out.println("Maximo ancho de la columna: " + resultMetaData.getColumnDisplaySize(i));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
