<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/main.css" rel="stylesheet"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <title>Editar curso</title>
    </head>
    <body>
        <div class="valign-wrapper" style="width:100%;height:100%;position: absolute;">
            <div class="valign" style="width:100%;">
                <div class="container">
                    <div class="row">

                        <div class="col s6 offset-s3">
                            <h3>Editar curso</h3>
                            <a class="waves-effect waves-light" href="inicio.jsp">Inicio</a> / <a class="waves-effect waves-light" href="Curso?action=selectAll">Cursos registrados</a>
                            <br><br><br>
                            <form action="curso?action=update" method="POST">

                                <div class="form-group">
                                    <i class="material-icons prefix">school</i>
                                    <label for="codigo">Código del curso</label>
                                    <input class="form-control" type="text" name="codigo" id="codigo" required value="${Curso.codigo}">
                                </div>

                                <div class="form-group">
                                    <i class="material-icons prefix">edit</i>
                                    <label for="titulo">Título</label>
                                    <input class="form-control" type="text" name="titulo" id="titulo" required value="${Curso.titulo}">
                                </div>

                                <div class="form-group">
                                    <i class="material-icons prefix">access_time</i>
                                    <label for="hora_duracion">Duración</label>
                                    <input class="form-control" type="text" placeholder="hh:mm" name="hora_duracion" id="hora_duracion" required value="${Curso.getHoraDuracionString()}">
                                </div>

                                <div class="form-group">
                                    <i class="material-icons prefix">date_range</i>
                                    <label for="fecha_inicio">Fecha de inicio</label>
                                    <input class="form-control" type="date" name="fecha_inicio" id="fecha_inicio" required value="${Curso.fecha_inicio}">
                                </div>

                                <div class="form-group">
                                    <i class="material-icons prefix">date_range</i>
                                    <label for="fecha_fin">Fecha finalización</label>
                                    <input  class="form-control" type="date" name="fecha_fin" id="fecha_fin" required value="${Curso.fecha_fin}">
                                </div>

                                <div class="form-group">
                                    <i class="material-icons prefix">school</i>
                                    <label for="fecha_fin">Fecha finalización</label>
                                    <select class="form-control form-control-sm" name="profesor" id="profesor">
                                        <option value="${Curso.profe.idprofesor}">${Curso.profe.nombre}</option>
                                        <c:forEach var="profe" items="${profes}">
                                            <option value="${profe.idprofesor}">${profe.nombre}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                               
                                <br><br>  
                                <input type="hidden" name="id" id="id" value="${Curso.getId()}">
                                <button class="waves-effect waves-light btn" type="submit">Guardar</button>

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
