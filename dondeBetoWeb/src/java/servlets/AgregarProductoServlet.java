package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// Ruta del servlet
@WebServlet("/AgregarProductoServlet")

// Clase principal
public class AgregarProductoServlet extends HttpServlet {

    // Método POST
    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // RECIBIR DATOS DEL FORMULARIO

        // Captura nombre
        String nombre =
                request.getParameter("nombre");

        // Captura categoría
        String categoria =
                request.getParameter("categoria");

        // Captura precio como texto
        String precioTexto =
                request.getParameter("precio");

        // Convierte precio a decimal
        double precio =
                Double.parseDouble(precioTexto);

        // Captura stock actual
        int stock_actual =
                Integer.parseInt(
                        request.getParameter("stock_actual")
                );

        // DATOS MYSQL

        String url =
                "jdbc:mysql://localhost:3306/donde_beto";

        String usuario =
                "root";

        // Tu contraseña MySQL
        String password =
                "Maxi201.";

        try {

            // CONEXIÓN MYSQL

            // Cargar driver
            Class.forName(
                    "com.mysql.cj.jdbc.Driver"
            );

            // Crear conexión
            Connection conexion =
                    DriverManager.getConnection(
                            url,
                            usuario,
                            password
                    );

            // CONSULTA SQL

            String sql =
                    "INSERT INTO producto "
                    + "(nombre, categoria, precio, stock_actual, stock_minimo) "
                    + "VALUES (?, ?, ?, ?, 5)";

            // Preparar consulta
            PreparedStatement statement =
                    conexion.prepareStatement(sql);

            // Reemplazar parámetros
            statement.setString(1, nombre);

            statement.setString(2, categoria);

            statement.setDouble(3, precio);

            statement.setInt(4, stock_actual);

            // Ejecutar INSERT
            statement.executeUpdate();

            // RESPUESTA
  
            response.setContentType("text/html");

            PrintWriter out =
                    response.getWriter();

            out.println(
                    "<h1>Producto guardado correctamente 😎</h1>"
            );

            // Cerrar conexión
            conexion.close();

        } catch (Exception e) {

            // Mostrar error
            response.setContentType("text/html");

            PrintWriter out =
                    response.getWriter();

            out.println(
                    "<h1>Error al guardar producto</h1>"
            );

            out.println(
                    "<p>" + e.getMessage() + "</p>"
            );
        }
    }
}