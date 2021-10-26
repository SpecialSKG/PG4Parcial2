<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/materialize.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Editar nota</title>
    </head>
    <body>
        <div class="valign-wrapper" style="width:100%;height:100%;position: absolute;">
            <div class="valign" style="width:100%;">
                <div class="container">
                    <div class="row">

                        <div class="col s6 offset-s3">
                            <h3>Editar nota</h3>
                            <a class="waves-effect waves-light" href="index.jsp">Inicio</a> / <a class="waves-effect waves-light" href="Nota?action=selectAll">Notas registradas</a>
                            <br><br><br>
                            <form action="Nota?action=update" method="POST">

                                <div class="input-field">
                                    <i class="material-icons prefix">person</i>
                                    <label for="alumno">Alumno</label>
                                    <input type="text" name="alumno" id="alumno" required value="${Nota.alumno}">
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">school</i>
                                    <label for="curso">Curso</label>
                                    <input type="text" name="curso" id="curso" required value="${Nota.curso}">
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">star</i>
                                    <label for="notas">Nota</label>
                                    <input type="text" name="notas" id="notas" required value="${Nota.notas}">
                                </div>
                                <br><br>
                                <button class="waves-effect waves-light btn" type="submit">Guardar</button>

                            </form>
                            <br>
                            <center>${msg}</center>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="js/materialize.js" type="text/javascript"></script>
</html>
