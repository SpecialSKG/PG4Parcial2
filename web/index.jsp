<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/materialize.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>GRUPO 2 - Academia de cursos</title>
    </head>
    <body>
        <div class="valign-wrapper" style="width:100%;height:100%;position: absolute;">
            <div class="valign" style="width:100%;">
                <div class="container">
                    <div class="row">
                        <h1>Academia de cursos</h1>
                        <div class="col s12 m4">
                            <div class="card">
                                <div class="card-image">
                                    <img src="img/alumnos.jpg">
                                    <span class="card-title"><strong>Alumnos</strong></span>
                                </div>
                                <div class="card-action">
                                    <a class="waves-effect waves-light btn-small" href="alumnos.jsp"><i class="material-icons left">add</i>Registrar</a>
                                    <a class="waves-effect waves-light btn-small red" href="Alumno?action=selectAll"><i class="material-icons left">people</i>Ver alumnos</a>
                                </div>
                            </div>
                        </div>
                        <div class="col s12 m4">
                            <div class="card">
                                <div class="card-image">
                                    <img src="img/cursos.jpg">
                                    <span class="card-title"><strong>Cursos</strong></span>
                                </div>
                                <div class="card-action">
                                    <a class="waves-effect waves-light btn-small" href="curso?action=insert"><i class="material-icons left">add</i>Registrar</a>
                                    <a class="waves-effect waves-light btn-small red" href="curso?action=selectall"><i class="material-icons left">school</i>Ver cursos</a>
                                </div>
                            </div>
                        </div>
                        <div class="col s12 m4">
                            <div class="card">
                                <div class="card-image">
                                    <img src="img/notas.jpg">
                                    <span class="card-title"><strong>Notas</strong></span>
                                </div>
                                <div class="card-action">
                                    
                                    <a class="waves-effect waves-light btn-small red" href="notas?action=cursos"><i class="material-icons left">star</i>Ver notas</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/materialize.js" type="text/javascript"></script>
    </body>
</html>
