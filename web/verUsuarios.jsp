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
        if (sesion.getAttribute("usuario") != null) {
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
                <div class="container">
                    <div class="row" style="padding-top: 50px">
                        <h1>Usuarios registrados</h1>
                        <div class="col-sm-12 col-md-12 col-lg-12">
                            <div class="col s6 offset-s3">
                                <a class="btn btn-primary mb-5" href="inicio.jsp">
                                    <i class="bi bi-house"></i>&nbsp;Inicio
                                </a> 
                                <a class="btn btn-info mb-5" href="usuarios.jsp">
                                    <i class="bi bi-person-plus"></i>&nbsp;Registrar usuarios
                                </a>
                                <table class="table table-hover">
                                    <thead>
                                        <tr>
                                            <th scope="col">ID</th>
                                            <th scope="col">Usuario</th>
                                            <th scope="col">Pass</th>
                                            <th scope="col">Tipo</th>
                                            <th scope="col">Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${lista}" var="v">
                                            <tr>
                                                <td><c:out value="${v.id}" /></td>
                                                <td><c:out value="${v.usuario}" /></td>
                                                <td><c:out value="${v.clave}" /></td>
                                                <td><c:out value="${v.tipo_usuario }" /></td>
                                                <td>
                                                    <a class="btn btn-danger" href="usuario?action=delete&id=${v.id}"><i class="bi bi-trash"></i>&nbsp;Eliminar</a>
                                                    <a class="btn btn-info" href="usuario?action=selectId&id=${v.id}"><i class="bi bi-pen"></i>&nbsp;Editar</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
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