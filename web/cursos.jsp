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

                        <div class="col s6 offset-s3">
                            <h3>Agregar curso</h3>
                            <a class="waves-effect waves-light" href="index.jsp">Inicio</a> / <a class="waves-effect waves-light" href="curso?action=selectAll">Cursos registrados</a>
                            <br><br><br>
                            <form action="curso?action=insertar" method="POST">

                                <div class="input-field">
                                    <i class="material-icons prefix">school</i>
                                    <label for="codigo">Código del curso</label>
                                    <input type="text" name="codigo" id="codigo" required>
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">edit</i>
                                    <label for="titulo">Título</label>
                                    <input type="text" name="titulo" id="titulo" required>
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">access_time</i>
                                    <label for="hora_duracion">Duración</label>
                                    <input type="time" name="hora_duracion" id="hora_duracion" required>
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">date_range</i>
                                    <label for="fecha_inicio">Fecha de inicio</label>
                                    <input type="date" name="fecha_inicio" id="fecha_inicio" required>
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">date_range</i>
                                    <label for="fecha_fin">Fecha finalización</label>
                                    <input type="date" name="fecha_fin" id="fecha_fin" required>
                                </div>

                                <div class="row col-12 form-group">
                                    <div class="col-12 col-md-6">
                                        Profesor:
                                    </div>
                                    <div class="col-12 col-md-6">
                                        <select id="profesor" name="profesor" class="form-control">
                                            <c:forEach items="${profes}" var="p">
                                                <option value="${p.idprofesor}">
                                                    ${p.nombre}
                                                </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <br>       
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
