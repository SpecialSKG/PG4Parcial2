<%-- 
    Document   : index
    Created on : 17/11/2021, 06:51:15 PM
    Author     : user
--%>

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
        <form>
            <h3>Academia</h3>

            <label for="username">Usuario</label>
            <input type="text" placeholder="Ingrese un usuario" id="username">

            <label for="password">Contraseña</label>
            <input type="password" placeholder="Ingrese una contraseña" id="password">

            <button>Iniciar Sesión</button>
        </form>
    </body>
</html>
