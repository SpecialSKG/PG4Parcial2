<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
        <link href="css/main.css" rel="stylesheet"/>
        <title>Profesores</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Agregar profesor</h1>
                <div class="col-sm-12 col-md-12 col-lg-12">
                    <a class="btn btn-primary mb-5" href="index.jsp"><i class="bi bi-house"></i>&nbsp;Inicio</a> <a class="btn btn-info mb-5" href="profesor?action=seleccionarTodo"><i class="bi bi-person-check-fill"></i>&nbsp;Profesores registrados</a>
                    <form action="profesor?action=insertar" method="POST">

                        <div class="form-group">
                            <label for="dui">DUI</label>
                            <input type="text" name="dui" class="form-control" id="dui">
                        </div>

                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" name="nombre" class="form-control" id="nombre">
                        </div>
                        
                        <div class="form-group">
                            <label for="apellido">Apellido</label>
                            <input type="text" name="apellido" class="form-control" id="apellido">
                        </div>
                        
                        <div class="form-group">
                            <label for="direccion">Dirección</label>
                            <input type="text" name="direccion" class="form-control" id="direccion">
                        </div>
                        
                        <div class="form-group">
                            <label for="telefono">Teléfono</label>
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
