<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Bienvenido</title>
</head>

<body>

    <%

        // Recibir parámetro GET
        String nombre =
                request.getParameter("nombre");

    %>

    <h1>
        Login exitoso
    </h1>

    <h2>
        Bienvenido,
        <%= nombre %>
    </h2>

</body>
</html>