<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/materialize.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Alumnos</title>
    </head>
    <body>
        <div class="valign-wrapper" style="width:100%;height:100%;position: absolute;">
            <div class="valign" style="width:100%;">
                <div class="container">
                    <div class="row">
                        <h1>Alumnos registrados</h1>
                        <div class="col s6 offset-s3">                            
                            <a class="waves-effect waves-light" href="index.jsp">Inicio</a> / <a class="waves-effect waves-light" href="alumnos.jsp">Registrar alumnos</a>
                            <table class="responsive-table">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>DUI</th>
                                        <th>Dirección</th>
                                        <th>Nombre</th>
                                        <th>Teléfono</th>
                                        <th>Edad</th>
                                        <th>CIF</th>
                                        <th>Teléfono empresa</th>
                                        <th>Dirección empresa</th>
                                        <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${lista}" var="v">
                                        <tr>
                                            <td><c:out value="${v.id}" /></td>
                                            <td><c:out value="${v.dui}" /></td>
                                            <td><c:out value="${v.direccion}" /></td>
                                            <td><c:out value="${v.nombre}" /></td>
                                            <td><c:out value="${v.telefono}" /></td>
                                            <td><c:out value="${v.edad}" /></td>
                                            <td><c:out value="${v.cif}" /></td>
                                            <td><c:out value="${v.telefono_empresa}" /></td>
                                            <td><c:out value="${v.direccion_empresa}" /></td>
                                            <td>
                                                <a href="Alumno?action=delete&id=${v.id}">Eliminar</a>
                                                <a href="Alumno?action=selectId&id=${v.id}">Editar</a>
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
