package controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import conexion.Conexion;
import dao.AlumnoDao;
import dao.CursoDao;
import dao.NotaDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Curso;
import modelo.Nota;

/**
 *
 * @author Angel
 */
public class NotaServlet extends HttpServlet {

    RequestDispatcher rd;
    Conexion cn = new Conexion();

    AlumnoDao ad = new AlumnoDao(cn);
    CursoDao cd = new CursoDao(cn);
    NotaDao nd = new NotaDao(cn);

    List<Nota> ln;
    List<Alumno> la;
    List<Curso> lc;

    Nota n = new Nota();
    Alumno a = new Alumno();
    Curso c = new Curso();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "cursos":
                mostrarCursos(request, response);
                break;
            case "uncurso":
                mostrarUnCurso(request, response);
                break;
            case "insertarcc":
                insertarAlumnoEnCurso(request, response);
                break;
            case "insertar":
                insert(request, response);
                break;
            case "modificar":
                modificar(request, response);
                break;
            case "actualizar":
                actualizar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
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

    private void mostrarCursos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lc = cd.selectAll();
        request.setAttribute("lista", lc);
        rd = request.getRequestDispatcher("notas.jsp");
        rd.forward(request, response);
    }

    private void mostrarUnCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Curso nota = cd.selectById(Integer.parseInt(request.getParameter("id")));
        ln = nd.selectAllWhereCurso(Integer.parseInt(request.getParameter("id")));
        String vali = (ln.size() > 0) ? "true" : "false";
        request.setAttribute("lista", ln);
        request.setAttribute("validacion", vali);
        request.setAttribute("curso", nota);
        rd = request.getRequestDispatcher("notasCursoAlumnos.jsp");
        rd.forward(request, response);
    }

    private void mostrarAlumnoEnCurso(HttpServletRequest request, HttpServletResponse response) {
    }

    private void insertarAlumnoEnCurso(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Curso curso = cd.selectById(Integer.parseInt(request.getParameter("id")));
        la = ad.selectAll();

        request.setAttribute("curso", curso);
        request.setAttribute("alumnos", la);

        rd = request.getRequestDispatcher("notasInsertarAlumnoEnCurso.jsp");
        rd.forward(request, response);

    }

    private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        lc = cd.selectAll();
        Nota notaInserta = new Nota(Integer.parseInt(request.getParameter("curso")), Integer.parseInt(request.getParameter("alumno")), Double.parseDouble(request.getParameter("nota")));// new Nota(curso, alumno, nota);
        nd.insertar(notaInserta);
        Curso nota = cd.selectById(Integer.parseInt(request.getParameter("curso")));
        ln = nd.selectAllWhereCurso(Integer.parseInt(request.getParameter("curso")));
        String vali = (ln.size() > 0) ? "true" : "false";
        request.setAttribute("lista", ln);
        request.setAttribute("validacion", vali);
        request.setAttribute("curso", nota);
        rd = request.getRequestDispatcher("notasCursoAlumnos.jsp");
        rd.forward(request, response);
    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Nota nota = nd.selectById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("nota", nota);
        rd = request.getRequestDispatcher("notasActualizar.jsp");
        rd.forward(request, response);
    }

    private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Nota notaUpdate = new Nota(Integer.parseInt(request.getParameter("id")), Integer.parseInt(request.getParameter("curso")), Integer.parseInt(request.getParameter("alumno")), Double.parseDouble(request.getParameter("nota")));// new Nota(curso, alumno, nota);
        nd.update(notaUpdate);
        Curso nota = cd.selectById(Integer.parseInt(request.getParameter("curso")));
        ln = nd.selectAllWhereCurso(Integer.parseInt(request.getParameter("curso")));
        String vali = (ln.size() > 0) ? "true" : "false";
        request.setAttribute("lista", ln);
        request.setAttribute("validacion", vali);
        request.setAttribute("curso", nota);
        rd = request.getRequestDispatcher("notasCursoAlumnos.jsp");
        rd.forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        nd.delete(Integer.parseInt(request.getParameter("id")));
        Curso nota = cd.selectById(Integer.parseInt(request.getParameter("curso")));
        ln = nd.selectAllWhereCurso(Integer.parseInt(request.getParameter("curso")));
        String vali = (ln.size() > 0) ? "true" : "false";
        request.setAttribute("lista", ln);
        request.setAttribute("validacion", vali);
        request.setAttribute("curso", nota);
        rd = request.getRequestDispatcher("notasCursoAlumnos.jsp");
        rd.forward(request, response);

    }

}
