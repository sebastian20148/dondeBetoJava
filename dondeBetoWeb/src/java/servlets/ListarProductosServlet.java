package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listarProductos")
public class ListarProductosServlet extends HttpServlet {

    // Método GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Lista Productos</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Listado de Productos</h1>");

        out.println("<p>Este servlet funciona con método GET.</p>");

        out.println("</body>");
        out.println("</html>");
    }
}