package controlador;

import conexion.Conexion;
import dao.CursoDao;
import dao.ProfesorDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Curso;
import modelo.Profesor;

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
            case "insert":
                goInsert(request, response);
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
        int profe = Integer.parseInt(request.getParameter("profe_dui"));
        //Curso c = new Curso(codigo, titulo, hora_duracion, fecha_inicio, fecha_fin, profe_dui, nombre, apellido, direccion, telefono);
        Curso c = new Curso(codigo, titulo, hora_duracion, fecha_inicio, fecha_fin, new Profesor(profe));
        cd.insert(c);

        lista = cd.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/verCursos.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Curso c = new Curso();
        c.setId(Integer.parseInt(request.getParameter("id")));
        c.setCodigo(request.getParameter("codigo"));
        c.setTitulo(request.getParameter("titulo"));
        c.setHoraDuracionString(request.getParameter("hora_duracion"));
        c.setFechaInicioString(request.getParameter("fecha_inicio"));
        c.setFechaFinString(request.getParameter("fecha_fin"));
        c.setProfe(new Profesor(Integer.parseInt(request.getParameter("profe_dui"))));
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
        rd = request.getRequestDispatcher("/verCursos.jsp");
        rd.forward(request, response);

    }

    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Curso c = cd.selectById(id);
        request.setAttribute("Curso", c);
        rd = request.getRequestDispatcher("/editarCurso.jsp");
        rd.forward(request, response);
    }

    private void goInsert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProfesorDao pr = new ProfesorDao(conn);
        List<Profesor> profes = pr.selectAll();
        request.setAttribute("profes", profes);
        rd = request.getRequestDispatcher("/cursos.jsp");
        rd.forward(request, response);
    }

}
