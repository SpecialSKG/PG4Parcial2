<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
        <link href="css/main.css" rel="stylesheet"/>
        <title>Usuarios</title>
    </head>
    <body>

        <div class="container">
            <div class="row">
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
    </body>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>  
</html>
