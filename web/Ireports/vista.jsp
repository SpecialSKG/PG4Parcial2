<%-- 
    Document   : vista
    Created on : 9/12/2021, 11:50:39 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>Generar reportes por filtros</div>
    <center>
        <form name="form1" action="../reporteNotas.jsp">
            <input type="text" name="param" size="10"/>
            <input type="submit" value="Generar PDf"/>
        </form>
    </center>
</body>
</html>
