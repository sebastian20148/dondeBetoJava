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
import java.sql.Statement;
import java.sql.ResultSet;

@WebServlet("/ListarProductosServlet")

public class ListarProductosServlet
        extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        // DATOS MYSQL
        String url =
                "jdbc:mysql://localhost:3306/donde_beto";

        String usuario =
                "root";

        String password =
                "Maxi201.";

        try {

            // DRIVER MYSQL
            Class.forName(
                    "com.mysql.cj.jdbc.Driver"
            );

            // CONEXIÓN
            Connection conexion =
                    DriverManager.getConnection(
                            url,
                            usuario,
                            password
                    );

            // CONSULTA SQL
            String sql =
                    "SELECT * FROM producto";

            Statement statement =
                    conexion.createStatement();

            ResultSet resultado =
                    statement.executeQuery(sql);

            // RESPUESTA HTML
            response.setContentType("text/html");

            PrintWriter out =
                    response.getWriter();

            out.println("<h1>Lista Productos</h1>");

            // RECORRER DATOS
            while (resultado.next()) {

                out.println("<p>");

                out.println(
                        resultado.getString("nombre")
                );

                out.println(" - ");

                out.println(
                        resultado.getString("categoria")
                );

                out.println(" - ");

                out.println(
                        resultado.getDouble("precio")
                );

                out.println(" - ");
                
                out.println(
                        resultado.getDouble("stock_actual")
                );

                out.println("</p>");
            }

            conexion.close();

        } catch (Exception e) {

            response.setContentType("text/html");

            PrintWriter out =
                    response.getWriter();

            out.println("<h1>Error</h1>");

            out.println("<p>"
                    + e.getMessage()
                    + "</p>");
        }
    }
}