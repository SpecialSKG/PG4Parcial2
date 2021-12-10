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
                                    <li> <a href="curso?action=selectAll">Ver cursos</a> </li>
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
                        <div class="col-lg-12">
                            <h1 class="page-header">Notas</h1> 
                        </div> <!-- /.col-lg-12 -->
                    </div> <!-- /.row -->
                    <div class="row">
                        <div class="d-flex flex-wrap align-content-center col-12">
                            <c:forEach items="${lista}" var="o">
                                <div class="col-12 col-md-6 col-lg-4 p-1" style="height: 150px !important; margin-bottom: 100px">
                                    <div class="col-12 m-0">
                                        <div class="panel panel-primary">
                                            <div class="panel-heading" style="padding-left: 50px !important">
                                                <div class="d-flex justify-content-between  text-right">
                                                    <div class="card-title"><h1>${o.getTitulo()}</h1></div>
                                                </div>
                                                <div class="col-12 p-3">
                                                    <div class="row mb-0">
                                                        <div class="col-6"><b>codigo </b>${o.getCodigo()}</div>
                                                    </div>
                                                    <div class="row mb-0">
                                                        <div class="col-6"><b>fecha de inicio </b>${o.getFechaInicioString()}</div>
                                                    </div>
                                                    <div class="row mb-0">
                                                        <div class="col-6"><b>fecha de fin </b>${o.getFechaFinString()}</div>
                                                        <div class="col-6"></div>
                                                    </div>
                                                    <div class="row mb-0">
                                                        <div class="col-6"><b>horas de duracion </b>${o.getHoraDuracionString()}</div>
                                                    </div>
                                                </div>
                                            </div>
                                                    <div class="card-action" style="padding-left:25px; "> <a
                                                    href="notas?action=uncurso&id=${o.getId()}">Ver Alumnos</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
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