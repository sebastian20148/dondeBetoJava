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
import java.sql.ResultSet;
import java.net.URLEncoder;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
// RECIBIR DATOS
        String usuarioIngresado =
                request.getParameter("usuario");

        String passwordIngresada =
                request.getParameter("password");
        // DATOS D MYSQL
      
        String url =
                "jdbc:mysql://localhost:3306/donde_beto";

        String usuario = "root";

        String password = "Maxi201.";

        try {

            // Cargar driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Crear conexion
            Connection conexion =
                    DriverManager.getConnection(
                            url,
                            usuario,
                            password
                    );

     // CONSULTA SQL
          

            String sql =
                    "SELECT * FROM empleado "
                    + "WHERE usuario = ? "
                    + "AND password = ?";

            PreparedStatement statement =
                    conexion.prepareStatement(sql);

            statement.setString(
                    1,
                    usuarioIngresado
            );

            statement.setString(
                    2,
                    passwordIngresada
            );

            // Ejecutar consulta
            ResultSet resultado =
                    statement.executeQuery();

            response.setContentType("text/html");

            PrintWriter out =
                    response.getWriter();

 
            // VALIDA LOGIN
        

            if (resultado.next()) {

                // nombre del empleado
              String nombreEmpleado =
                resultado.getString("nombre");

            // redirecionar usando GET
            String nombreCodificado =
        URLEncoder.encode(
                nombreEmpleado,
                "UTF-8"
        );

response.sendRedirect(
        request.getContextPath()
        + "/bienvenido.jsp?nombre="
        + nombreCodificado
);

            } else {

                out.println("<h1>Usuario incorrecto</h1>");
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