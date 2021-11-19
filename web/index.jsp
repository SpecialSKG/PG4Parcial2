<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="background">
            <div class="shape"></div>
            <div class="shape"></div>
        </div>
        <form action="usuario?action=login" method="POST" >
            <h3>Academia</h3>
            <label for="username">Usuario</label>
            <input type="text" placeholder="Ingrese un usuario" id="usuario" name="usuario">

            <label for="password">Contraseña</label>
            <input type="password" placeholder="Ingrese una contraseña" id="clave" name="clave">

            <button type="submit">Iniciar Sesión</button>
        </form>
        <!-- <a href="inicio.jsp">Home</a> -->
    </body>
</html>
