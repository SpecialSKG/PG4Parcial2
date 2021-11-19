<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/materialize.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Editar profesor</title>
    </head>
    <body>
        <div class="valign-wrapper" style="width:100%;height:100%;position: absolute;">
            <div class="valign" style="width:100%;">
                <div class="container">
                    <div class="row">

                        <div class="col s6 offset-s3">
                            <h3>Actualizar profesor</h3>
                            <a class="waves-effect waves-light" href="index.jsp">Inicio</a> / <a class="waves-effect waves-light" href="profesor?action=seleccionarTodo">Profesores registrados</a>
                            <br><br><br>
                            <form action="profesor?action=actualizar" method="POST">
                                <c:forEach items="${lista}" var="p">
                                    
                                <div class="input-field">
                                    <i class="material-icons prefix">assignment_ind</i>
                                    <label for="dui">DUI</label>
                                    <input type="text" name="dui" required value="${p.dui}">
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">perm_identity</i>
                                    <label for="nombre">Nombre</label>
                                    <input type="text" name="nombre" required value="${p.nombre}">
                                </div>
                                
                                <div class="input-field">
                                    <i class="material-icons prefix">perm_identity</i>
                                    <label for="apellido">Apellido</label>
                                    <input type="text" name="apellido" required value="${p.apellido}">
                                </div>
                                
                                <div class="input-field">
                                    <i class="material-icons prefix">location_on</i>
                                    <label for="direccion">Dirección</label>
                                    <input type="text" name="direccion" required value="${p.direccion}">
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">phone</i>
                                    <label for="telefono">Teléfono</label>
                                    <input type="text" name="telefono" required value="${p.telefono}">
                                </div>                   
                                <br><br>
                                <input type="hidden" name="idprofesor" value="${p.idprofesor}">
                                </c:forEach>
                                <button class="waves-effect waves-orange btn" type="submit">Guardar</button>

                            </form>
                            <br>
                            <center>${msg}</center>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
    <script src="js/materialize.js" type="text/javascript"></script>
</html>
