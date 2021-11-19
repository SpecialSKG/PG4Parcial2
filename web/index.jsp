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
        <form action="usuario?action=login" method="POST" >
            <h3>Academia</h3>

            <label for="username">Usuario</label>
            <input type="text" placeholder="Ingrese un usuario" id="usuario" name="usuario">

            <label for="password">Contraseña</label>
            <input type="password" placeholder="Ingrese una contraseña" id="clave" name="clave">

            <button type="submit">Iniciar Sesión</button>
        </form>
        <a href="inicio.jsp">LLLL</a>
    </body>
</html>
