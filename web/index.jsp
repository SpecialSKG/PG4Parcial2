
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/materialize.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>GRUPO 2</title>
    </head>
    <body>
        <div class="container">
            <div class="row"></div>
            <div class="row" >

                <div class="col s12 m6 l6">
                    <form action="UsuarioServlet?action=insert" method="POST">

                        <label>Nombre</label>
                        <input type="text" required name="nombre">

                        <label>Apellido</label>
                        <input type="text" required name="apellido">

                        <label>Edad</label>
                        <input type="number" required name="edad">

                        <button class="waves-effect waves-light btn" type="submit">Enviar</button>

                    </form>
                    ${msg}
                </div>

                <div class="col s12 m6 l6">
                    <a class="waves-effect waves-light btn" href="UsuarioServlet?action=selectAll">Listado</a>
                </div>
            </div>
        </div>
        <script src="js/materialize.js" type="text/javascript"></script>
        <script>
            document.addEventListener('DOMContentLoaded', function () {
                M.AutoInit();
            });
        </script>
    </body>
</html>
