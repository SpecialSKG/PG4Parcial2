package controlador;

import conexion.Conexion;
import dao.CursoDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;

public class CursoServlet extends HttpServlet {

    RequestDispatcher rd;
    Conexion conn = new Conexion();
    CursoDao cd = new CursoDao(conn);
    List<Curso> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action) {
            case "insertar":
                insert(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "selectall":
                selectAll(request, response);
                break;
            case "selectbyid":
                selectById(request, response);
                break;
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String codigo = request.getParameter("codigo");
        String titulo = request.getParameter("titulo");
        String hora_duracion = request.getParameter("hora_duracion");
        String fecha_inicio = request.getParameter("fecha_inicio");
        String fecha_fin = request.getParameter("fecha_fin");
        String profe_dui = request.getParameter("profe_dui");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        Curso c = new Curso(codigo, titulo, hora_duracion, fecha_inicio, fecha_fin, profe_dui, nombre, apellido, direccion, telefono);
        cd.insert(c);

        response.sendRedirect(request.getContextPath() + "/curso?action=selectall");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Curso c = new Curso();
        c.setId(Integer.parseInt(request.getParameter("id")));
        c.setCodigo(request.getParameter("codigo"));
        c.setHoraDuracionString(request.getParameter("hora_duracion"));
        c.setFechaInicioString(request.getParameter("fecha_inicio"));
        c.setFechaFinString(request.getParameter("fecha_fin"));
        c.setProfe_dui(request.getParameter("profe_dui"));
        c.setNombre(request.getParameter("nombre"));
        c.setApellido(request.getParameter("apellido"));
        c.setDireccion(request.getParameter("direccion"));
        c.setTelefono(request.getParameter("telefono"));
        cd.update(c);
        response.sendRedirect(request.getContextPath() + "/curso?action=selectall");
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        cd.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/curso?action=selectall");
    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = cd.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarCurso.jsp");
        rd.forward(request, response);

    }

    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Curso c = cd.selectById(id);
        request.setAttribute("curso", c);
        rd = request.getRequestDispatcher("/updateCurso.jsp");
        rd.forward(request, response);
    }

}
