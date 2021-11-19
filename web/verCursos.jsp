<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
        <link href="css/main.css" rel="stylesheet"/>
        <title>Cursos</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Cursos registrados</h1>
                <div class="col-sm-12 col-md-12 col-lg-12">                            
                    <a class="btn btn-primary mb-5" href="inicio.jsp"><i class="bi bi-house"></i>&nbsp;Inicio</a> <a class="btn btn-info mb-5" href="cursos.jsp"><i class="bi bi-person-plus"></i>&nbsp;Registrar un Curso</a>
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th scope="col">Codigo</th>
                                <th scope="col">Titulo</th>
                                <th scope="col">Hora Duración</th>
                                <th scope="col">Fecha de Inicio</th>
                                <th scope="col">Fecha de Finalizacion</th>
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
                                    <td>
                                        <a class="btn btn-danger" href="curso?action=eliminar&idcurso=${v.id}"><i class="bi bi-trash"></i>&nbsp;Eliminar</a>
                                        <a class="btn btn-info" href="curso?action=seleccionarId&idcurso=${v.id}"><i class="bi bi-pen"></i>&nbsp;Editar</a>
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
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>
