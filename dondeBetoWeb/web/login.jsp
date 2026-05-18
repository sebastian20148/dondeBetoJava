<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Donde Beto</title>
</head>

<body>

    <h1>Login Empleado</h1>

    <form action="LoginServlet" method="POST">

        <label>Usuario:</label>
        <input type="text" name="usuario">

        <br><br>

        <label>Contraseña:</label>
        <input type="password" name="password">

        <br><br>

        <button type="submit">
            Ingresar
        </button>

    </form>

</body>
</html>