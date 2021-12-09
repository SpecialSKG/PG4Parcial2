<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link href="css/materialize.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>-->
        <link href="css/bootstrap.min_1.css" rel="stylesheet" type="text/css"/>
        <link href="css/startmin.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Academia de cursos</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            String usuario;
            if (sesion.getAttribute("usuario") != null && sesion.getAttribute("usuario") != "") {
                usuario = sesion.getAttribute("usuario").toString();

        %>


        <div id="wrapper">
            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <div class="navbar-header">
                    <a class="navbar-brand" href="inicio.html">ACADEMIA DE CURSOS</a>
                </div>

                <ul class="nav navbar-right navbar-top-links">

                    <li class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                            <i class="fa fa-user fa-fw"></i> USUARIO <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu dropdown-user">
                            <li><a href="#"><i class="fa fa-user fa-fw"></i>Ver Perfil</a>
                            </li>
                            <li class="divider"></li>
                            <li><a href="usuario?action=logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- /.navbar-top-links -->

                <div class="navbar-default sidebar" role="navigation">
                    <div class="sidebar-nav navbar-collapse">
                        <ul class="nav" id="side-menu">
                            <!-- /Menu-->
                            <li>
                                <a href="inicio.jsp">Dashboard</a>
                            </li>
                            <li>
                                <a href="notas.jsp">
                                    <i class="fa fa-files-o fa-fw"></i> Notas
                                    <span class="fa arrow"></span>
                                </a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="notas?action=cursos">Ver notas</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-files-o fa-fw"></i> Alumnos
                                    <span class="fa arrow"></span>
                                </a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="Alumno?action=selectAll">Ver alumnos</a>
                                    </li>
                                    <li>
                                        <a href="alumnos.jsp">Agregar alumno</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-files-o fa-fw"></i> Profesores
                                    <span class="fa arrow"></span>
                                </a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="profesor?action=seleccionarTodo">Ver profesores</a>
                                    </li>
                                    <li>
                                        <a href="profesores.jsp">Agregar profesor</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-files-o fa-fw"></i> Cursos
                                    <span class="fa arrow"></span>
                                </a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="curso?action=selectall">Ver cursos</a>
                                    </li>
                                    <li>
                                        <a href="curso?action=insert">Agregar curso</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">
                                    <i class="fa fa-files-o fa-fw"></i> Usuarios
                                    <span class="fa arrow"></span>
                                </a>
                                <ul class="nav nav-second-level">
                                    <li>
                                        <a href="usuario?action=selectAll">Ver Usuarios</a>
                                    </li>
                                    <li>
                                        <a href="usuario?action=goInsert">Agregar Usuarios</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <!-- /Fin Menu-->

            <div id="page-wrapper">
                <div class="container-fluid">

                    <div class="col-12 d-flex justify-content-center">
                        <div><h1></h1></div> 
                    </div>
                    <div class="d-flex flex-row">
                        <a href="notas?action=cursos" class="btn">volver al listado de cursos</a>
                    </div>
                    <div class="col-12 d-flex justify-content-end">
                        <a class="btn" href="notas?action=insertarcc&id=${curso.getId()}">Insertar un Nuevo Estudiante a este Curso</a> 
                    </div>
                    <c:choose>
                        <c:when test="${validacion.equals('true')}">
                            <div class="container">
                                <table class="table">
                                    <thead class="thead-dark">
                                        <tr>
                                            <th>Nombre</th>
                                            <th>Edad</th>
                                            <th>DUI</th>
                                            <th>Telefono</th>
                                            <th>direccion</th>
                                            <th>CIF</th>
                                            <th>Telefo de la empresa</th>
                                            <th>Direccion de la empresa</th>
                                            <th>Nota</th>
                                            <th>Accion</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${lista}" var="c">
                                            <tr>
                                                <td>${c.getAlumno().getNombre()}</td>
                                                <td>${c.getAlumno().getEdad()}</td>
                                                <td>${c.getAlumno().getDui()}</td>
                                                <td>${c.getAlumno().getTelefono()}</td>
                                                <td>${c.getAlumno().getDireccion()}</td>
                                                <td>${c.getAlumno().getCif()}</td>
                                                <td>${c.getAlumno().getTelefono_empresa()}</td>
                                                <td>${c.getAlumno().getDireccion_empresa()}</td>
                                                <td>${c.getNota()}</td>
                                                <td>
                                                    <a href="notas?action=modificar&id=${c.getId()}" class="btn btn-primary">Modificar</a>
                                                    <a href="notas?action=eliminar&id=${c.getId()}&curso=${c.getCurso().getId()}" class="btn btn-danger">Eliminar</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </c:when>    
                        <c:otherwise>
                            <div class="d-flex flex-row justify-content-center">
                                <h2>NO HAY ALUMNOS EN ESTE CURSO</h2>    
                            </div>
                            <br />
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>

        <!-- jQuery -->
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="js/bootstrap.min_1.js" type="text/javascript"></script>
    </body>
</html>
<%    } else {
        response.sendRedirect("index.jsp");
    }

%>
