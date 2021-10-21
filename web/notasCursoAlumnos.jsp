
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/materialize.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <div class="col-12 d-flex justify-content-center">
            <div >CURSO ${curso.getTitulo()}</div> 
        </div>
        <div class="d-flex flex-row">
            <a href="notas?action=cursos">volver al listado de cursos</a>
        </div>
        <div class="col-12 d-flex justify-content-end">
            <a href="notas?action=insertarcc&id=${curso.getId()}">Insertar un Nuevo Estudiante a este Curso</a> 
        </div>
        <c:choose>
            <c:when test="${validacion.equals('true')}">
                <div class="container">
                    <table>
                        <thead>
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
                                        <a href="notas?action=modificar&id=${c.getId()}" class="btn">Modificar</a>
                                        <a href="notas?action=eliminar&id=${c.getId()}&curso=${c.getCurso().getId()}" class="btn">Eliminar</a>
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






    </body>
</html>