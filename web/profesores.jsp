<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Notas</title>
        <link href="css/bootstrap.min_1.css" rel="stylesheet" type="text/css" />
        <link href="css/startmin.css" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet" type="text/css" />
    </head>

    <body>
        <div id="wrapper">
            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header"> <a class="navbar-brand" href="index.html">ACADEMIA DE CURSOS</a>
                </div>
                <ul class="nav navbar-nav navbar-left navbar-top-links">
                    <li><a href="#"><i class="fa fa-home fa-fw"></i> INICIO</a></li>
                </ul>
                <ul class="nav navbar-right navbar-top-links">
                    <li class="dropdown"> <a class="dropdown-toggle" data-toggle="dropdown" href="#"> <i
                                class="fa fa-user fa-fw"></i> USUARIO <b class="caret"></b> </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i>Ver Perfil</a> </li>
                            <li class="divider"></li>
                            <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a> </li>
                        </ul>
                    </li>
                </ul> <!-- /.navbar-top-links -->
                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <!-- /Menu-->
                            <li> <a href="inicio.jsp">Dashboard</a> </li>
                            <li> <a href="notas.jsp"><i class="fa fa-files-o fa-fw"></i> Notas<span
                                        class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li> <a href="notas?action=cursos">Ver notas</a> </li>
                                </ul>
                            </li>
                            <li> <a href="alumnos.jsp"><i class="fa fa-files-o fa-fw"></i> Alumnos<span
                                        class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li> <a href="Alumno?action=selectAll">Ver alumnos</a> </li>
                                    <li> <a href="alumnos.jsp">Agregar alumno</a> </li>
                                </ul>
                            </li>
                            <li> <a href="#"><i class="fa fa-files-o fa-fw"></i> Profesores<span
                                        class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li> <a href="profesor?action=seleccionarTodo">Ver profesores</a> </li>
                                    <li> <a href="profesores.jsp">Agregar profesor</a> </li>
                                </ul>
                            </li>
                            <li> <a href="#"><i class="fa fa-files-o fa-fw"></i> Cursos<span
                                        class="fa arrow"></span></a>
                                <ul class="nav nav-second-level">
                                    <li> <a href="curso?action=selectall">Ver cursos</a> </li>
                                    <li> <a href="cursos.jsp">Agregar curso</a> </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav> <!-- /Fin Menu-->
            <div id="page-wrapper">
                <div class="container-fluid">
                    <div class="row">
                        <h1>Agregar profesor</h1>
                        <div class="col-sm-12 col-md-12 col-lg-12">
                            <a class="btn btn-primary mb-5" href="inicio.jsp"><i class="bi bi-house"></i>&nbsp;Inicio</a> <a class="btn btn-info mb-5" href="profesor?action=seleccionarTodo"><i class="bi bi-person-check-fill"></i>&nbsp;Profesores registrados</a>
                            <form action="profesor?action=insertar" method="POST">

                                <div class="form-group">
                                    <label for="dui">DUI</label>
                                    <input type="text" name="dui" class="form-control" id="dui">
                                </div>

                                <div class="form-group">
                                    <label for="nombre">Nombre</label>
                                    <input type="text" name="nombre" class="form-control" id="nombre">
                                </div>

                                <div class="form-group">
                                    <label for="apellido">Apellido</label>
                                    <input type="text" name="apellido" class="form-control" id="apellido">
                                </div>

                                <div class="form-group">
                                    <label for="direccion">Dirección</label>
                                    <input type="text" name="direccion" class="form-control" id="direccion">
                                </div>

                                <div class="form-group">
                                    <label for="telefono">Teléfono</label>
                                    <input type="text" name="telefono" class="form-control" id="telefono">
                                </div>

                                <button class="btn btn-success" type="submit">Guardar</button>
                            </form>
                            <br>
                            <center>${msg}</center>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="js/materialize.js" type="text/javascript"></script>

</html>