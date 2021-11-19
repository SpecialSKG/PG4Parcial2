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
                <h1>Agregar un Curso</h1>
                <div class="col-sm-12 col-md-12 col-lg-12">
                    <a class="btn btn-primary mb-5" href="inicio.jsp"><i class="bi bi-house"></i>&nbsp;Inicio</a> <a class="btn btn-info mb-5" href="cursos?action=seleccionarTodo"><i class="bi bi-person-check-fill"></i>&nbsp;Cursos registrados</a>
                    <form action="curso?action=insertar" method="POST">

                        <div class="form-group">
                            <label for="dui">Codigo</label>
                            <input type="text" name="codigo" class="form-control" id="codigo">
                        </div>

                        <div class="form-group">
                            <label for="nombre">Titulo</label>
                            <input type="text" name="titulo" class="form-control" id="titulo">
                        </div>

                        <div class="form-group">
                            <label for="apellido">Hora de Duración</label>
                            <input type="text" name="hora_duracion" class="form-control" id="hora_duracion">
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

                <div class="form-group">
                    <label for="telefono">Profesor</label>
                    <input type="text" name="telefono" class="form-control" id="telefono">
                </div>

                <button class="btn btn-success" type="submit">Guardar</button>
                </form>
                <br>
                <center>${msg}</center>
            </div>
        </div>
    </div>
</body>
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>
