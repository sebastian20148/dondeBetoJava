package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AgregarProductoServlet")

public class AgregarProductoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtener datos del formulario
        String nombre = request.getParameter("nombre");

        String categoria = request.getParameter("categoria");

        String precio = request.getParameter("precio");

        // Enviar datos al JSP
        request.setAttribute("nombre", nombre);

        request.setAttribute("categoria", categoria);

        request.setAttribute("precio", precio);

        // Redireccionar al JSP
        request.getRequestDispatcher("resultado.jsp").forward(request, response);
    }
}