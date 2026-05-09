package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/donde_beto";
    private static final String USER = "root";
    private static final String PASSWORD = "Maxi201.";

    public static Connection conectar() {
        Connection conexion = null;

        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");

        } catch (SQLException e) {
            System.out.println("Error en la conexión");
            e.printStackTrace();
        }

        return conexion;
    }
}