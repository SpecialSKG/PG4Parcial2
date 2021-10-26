
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/materialize.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Notas</title>
        <title>JSP Page</title>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="css/materialize.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="center-align" >
            <h1 >CURSOS</h1>
            <a class="waves-effect waves-light" href="index.jsp">Inicio</a>
        </div>
        <div class="d-flex flex-wrap align-content-center col-12">
            <c:forEach items="${lista}" var="o">
                <div class="col-12 col-md-6 col-lg-4 p-1">
                    <div class="col-12 m-0">
                        <div class="card blue-grey darken-1">
                            <div class="card-content white-text">
                                <div class="d-flex justify-content-between">
                                    <div class="card-title">${o.getTitulo()}</div>
                                    <div class="card-title">${o.getId()}</div>
                                </div>
                                <div class="col-12">
                                    <div class="row mb-0">
                                        <div class="col-6">codigo</div>
                                        <div class="col-6">${o.getCodigo()}</div>
                                    </div>
                                    <div class="row mb-0">
                                        <div class="col-6">fecha de inicio</div>
                                        <div class="col-6">${o.getFechaInicioString()}</div>

                                    </div>
                                    <div class="row mb-0">
                                        <div class="col-6">fecha de fin</div>
                                        <div class="col-6">${o.getFechaFinString()}</div>
                                    </div>
                                    <div class="row mb-0">
                                        <div class="col-6">horas de duracion</div>
                                        <div class="col-6">${o.getHoraDuracionString()}</div>
                                    </div>
                                </div>
                            </div>
                            <div class="card-action">
                                <a href="notas?action=uncurso&id=${o.getId()}">Ver Alumnos</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="js/materialize.js" type="text/javascript"></script>
</html>
<!--


-->