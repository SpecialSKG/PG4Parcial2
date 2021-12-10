<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@page import="net.sf.jasperreports.engine.JasperRunManager" %>
<%@page import="java.util.*" %>
<%@page import="java.io.File" %>
<%@include file="Ireports/vista.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Connection conn;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pgracademia?useSSL=false&characterEncoding=latin1",
                    "angel", "1234");
            File reportFile = new File(application.getRealPath("Ireports/reporteNotas.jasper"));
            Map parametros = new HashMap();
            String valor = request.getParameter("param");
            parametros.put("filtro", new String(valor));
            byte[] bytes = JasperRunManager.runReportToPdf(reportFile.getPath(), parametros, conn);
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            
            ServletOutputStream output = response.getOutputStream();
            response.getOutputStream();
            output.write(bytes, 0, bytes.length);
            output.flush();
            output.close();
        %>
    </body>
</html>
