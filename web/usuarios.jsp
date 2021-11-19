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
                <h1>Agregar Usuarios</h1>
                <div class="col-sm-12 col-md-12 col-lg-12">
                    <a class="btn btn-primary mb-5" href="inicio.jsp">
                        <i class="bi bi-house"></i>&nbsp;Inicio
                    </a> 
                    <a class="btn btn-info mb-5" href="usuario?action=selectAll">
                        <i class="bi bi-person-check-fill"></i>&nbsp;Usuarios registrados
                    </a>
                    <form action="usuario?action=insert" method="POST">

                        <div class="form-group">
                            <label for="dui">usuario</label>
                            <input type="text" name="usuario" class="form-control" id="usuario">
                        </div>

                        <div class="form-group">
                            <label for="direccion">password</label>
                            <input type="text" name="clave" class="form-control" id="clave">
                        </div>

                        <div class="form-group">
                            <label for="tipo_usuario">Tipo usuario</label>
                            <select class="form-control" id="tipo_usuario" name="tipo_usuario">
                                <c:forEach items="${tipo}" var="tp">
                                    <option value="${tp.id}">
                                        ${tp.tipo}
                                    </option>
                                </c:forEach>
                            </select>
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