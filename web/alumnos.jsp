<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
        <link href="css/main.css" rel="stylesheet"/>
        <title>Alumnos</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Agregar alumno</h1>
                <div class="col-sm-12 col-md-12 col-lg-12">
                    <a class="btn btn-primary mb-5" href="inicio.jsp"><i class="bi bi-house"></i>&nbsp;Inicio</a> <a class="btn btn-info mb-5" href="Alumno?action=selectAll"><i class="bi bi-person-check-fill"></i>&nbsp;Alumnos registrados</a>
                    <form action="Alumno?action=insert" method="POST">

                        <div class="form-group">
                            <label for="dui">DUI</label>
                            <input type="text" name="dui" class="form-control" id="dui">
                        </div>

                        <div class="form-group">
                            <label for="direccion">Dirección</label>
                            <input type="text" name="direccion" class="form-control" id="direccion">
                        </div>

                        <div class="form-group">
                            <label for="nombre">Nombre</label>
                            <input type="text" name="nombre" class="form-control" id="nombre">
                        </div>

                        <div class="form-group">
                            <label for="telefono">Teléfono</label>
                            <input type="text" name="telefono" class="form-control" id="telefono">
                        </div>
                        
                        <div class="form-group">
                            <label for="edad">Edad</label>
                            <input type="number" name="edad" class="form-control" id="edad">
                        </div>
                        
                        <div class="form-group">
                            <label for="cif">CIF</label>
                            <input type="text" name="cif" class="form-control" id="cif">
                        </div>
                        
                        <div class="form-group">
                            <label for="telefono_empresa">Teléfono de la empresa</label>
                            <input type="text" name="telefono_empresa" class="form-control" id="telefono_empresa">
                        </div>
                        
                        <div class="form-group">
                            <label for="direccion_empresa">Teléfono</label>
                            <input type="text" name="direccion_empresa" class="form-control" id="direccion_empresa">
                        </div>
                        <button class="btn btn-success" type="submit">Guardar</button>

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
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>
