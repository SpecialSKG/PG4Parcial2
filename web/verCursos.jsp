<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/materialize.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Cursos</title>
    </head>
    <body>
        <div class="valign-wrapper" style="width:100%;height:100%;position: absolute;">
            <div class="valign" style="width:100%;">
                <div class="container">
                    <div class="row">
                        <h1>Cursos registrados</h1>
                        <div class="col s6 offset-s3">                            
                            <a class="waves-effect waves-light" href="index.jsp">Inicio</a> / <a class="waves-effect waves-light" href="cursos.jsp">Registrar cursos</a>
                            <table class="responsive-table">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>Código</th>
                                        <th>Título</th>
                                        <th>Duración</th>
                                        <th>Fecha de inicio</th>
                                        <th>Fecha finalización</th>
                                        <th>DUI del profesor</th>
                                        <th>Nombre profesor</th>
                                        <th>Apellido profesor</th>
                                        <th>Dirección</th>
                                        <th>Teléfono</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${lista}" var="v">
                                        <tr>
                                            <td><c:out value="${v.id}" /></td>
                                            <td><c:out value="${v.codigo}" /></td>
                                            <td><c:out value="${v.titulo}" /></td>
                                            <td><c:out value="${v.hora_duracion}" /></td>
                                            <td><c:out value="${v.fecha_inicio}" /></td>
                                            <td><c:out value="${v.fecha_fin}" /></td>
                                            <td><c:out value="${v.profe_dui}" /></td>
                                            <td><c:out value="${v.nombre}" /></td>
                                            <td><c:out value="${v.apellido}" /></td>
                                            <td><c:out value="${v.direccion}" /></td>
                                            <td><c:out value="${v.telefono}" /></td>
                                            <td>
                                                <a href="curso?action=delete&id=${v.id}">Eliminar</a>
                                                <a href="curso?action=selectbyid&id=${v.id}">Editar</a>
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
    </body>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="js/materialize.js" type="text/javascript"></script>
</html>
