<%-- 
    Document   : notasInsertarAlumnoEnCurso
    Created on : 21/10/2021, 11:55:16 AM
    Author     : Angel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <form action="notas?action=actualizar" method="POST" class="border container col-12 mt-5 p-3">
                <div class="row col-12 form-group pt-4 d-flex flex-row justify-content-center">
                    <div class="col-12 col-md-6 d-flex flex-row justify-content-center">
                        <h2>Insertar Curso</h2>
                    </div>
                </div>
                <div class="row col-12 form-group pt-2">
                    <div class="col-12 col-md-6">
                        Curso:
                    </div>
                    <div class="col-12 col-md-6">
                        ${nota.getCurso().getTitulo()}
                    </div>
                </div>
                <div class="row col-12 form-group">
                    <div class="col-12 col-md-6">
                        Alumno:
                    </div>
                    <div class="col-12 col-md-6 input-field col s12">
                        <div class="col-12 col-md-6">
                            ${nota.getAlumno().getNombre()}
                        </div>
                        <input type="hidden" value="${nota.getCurso().getId()}" name="curso" id="curso"/>
                        <input type="hidden" value="${nota.getAlumno().getId()}" name="alumno" id="alumno"/>
                        <input type="hidden" value="${nota.getId()}" name="id" id="id"/>
                    </div>
                </div>
                <div class="row col-12 form-group pt-2">
                    <div class="col-12 col-md-6">
                        Nota:
                    </div>
                    <div class="col-12 col-md-6">
                        <input class="form-control" type="text" required="true"  placeholder="00.00" value="${nota.getNota()}" name="nota" id="nota" />
                    </div>
                </div>
                <div class="row col-12 form-group d-flex flex-row justify-content-center">
                    <div class="col-6 col-md-6">
                        <input type="submit" value="Insertar" class="btn btn-primary col-12 "/>
                    </div>
                </div>

            </form>
        </div>
    </body>
</html>
