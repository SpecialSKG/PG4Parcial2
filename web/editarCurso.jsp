<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/materialize.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>
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
                            <a class="waves-effect waves-light" href="index.jsp">Inicio</a> / <a class="waves-effect waves-light" href="Curso?action=selectAll">Cursos registrados</a>
                            <br><br><br>
                            <form action="curso?action=update" method="POST">

                                <div class="input-field">
                                    <i class="material-icons prefix">school</i>
                                    <label for="codigo">Código del curso</label>
                                    <input type="text" name="codigo" id="codigo" required value="${Curso.codigo}">
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">edit</i>
                                    <label for="titulo">Título</label>
                                    <input type="text" name="titulo" id="titulo" required value="${Curso.titulo}">
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">access_time</i>
                                    <label for="hora_duracion">Duración</label>
                                    <input type="text" name="hora_duracion" id="hora_duracion" required value="${Curso.hora_duracion}">
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">date_range</i>
                                    <label for="fecha_inicio">Fecha de inicio</label>
                                    <input type="text" name="fecha_inicio" id="fecha_inicio" required value="${Curso.fecha_inicio}">
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">date_range</i>
                                    <label for="fecha_fin">Fecha finalización</label>
                                    <input type="text" name="fecha_fin" id="fecha_fin" required value="${Curso.fecha_fin}">
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">credit_card</i>
                                    <label for="profe_dui">DUI del profesor</label>
                                    <input type="text" name="profe_dui" id="profe_dui" required value="${Curso.profe_dui}">
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">person</i>
                                    <label for="nombre">Nombre del profesor</label>
                                    <input type="text" name="nombre" id="nombre" required value="${Curso.nombre}">
                                </div>

                                <div class="input-field">
                                    <i class="material-icons prefix">person</i>
                                    <label for="apellido">Apellidos</label>
                                    <input type="text" name="apellido" id="apellido" required value="${Curso.apellido}">
                                </div>
                                
                                <div class="input-field">
                                    <i class="material-icons prefix">location_on</i>
                                    <label for="direccion">Dirección</label>
                                    <input type="text" name="direccion" id="direccion" required value="${Curso.direccion}">
                                </div>
                                
                                <div class="input-field">
                                    <i class="material-icons prefix">local_phone</i>
                                    <label for="telefono">Teléfono</label>
                                    <input type="text" name="telefono" id="telefono" required value="${Curso.telefono}">
                                </div>
                                <br><br>     
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