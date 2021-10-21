package controlador;

import conexion.Conexion;
import dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.*;

public class NotaServlet extends HttpServlet {
    
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    NotaDao nd = new NotaDao(conn);
    List<Nota> lista;
    
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
        int curso = (Integer.parseInt(request.getParameter("curso")));
        int alumno = (Integer.parseInt(request.getParameter("alumno")));
        double nota = (Double.parseDouble(request.getParameter("hora_duracion")));
        Nota n = new Nota(curso, alumno, nota);
        nd.insertar(n);
        
        response.sendRedirect(request.getContextPath() + "/nota?action=selectall");
    }
    
    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /*
        Nota n = new Nota();
        n.setId(Integer.parseInt(request.getParameter("id")));
        n.setCurso(Integer.parseInt(request.getParameter("curso")));
        n.setAlumno(Integer.parseInt(request.getParameter("alumno")));
        n.setNota(Double.parseDouble(request.getParameter("fecha_inicio")));
        */
        Curso c = new Curso();
        Alumno a = new Alumno();
        int id = (Integer.parseInt(request.getParameter("id")));
        c.setId(Integer.parseInt(request.getParameter("curso")));
        a.setId(Integer.parseInt(request.getParameter("alumno")));
        double nota = (Double.parseDouble(request.getParameter("hora_duracion")));
        
        Nota nu = new Nota(id, c, a, nota);
        nd.update(nu);
        response.sendRedirect(request.getContextPath() + "/nota?action=selectall");
    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        nd.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/nota?action=selectall");
    }
    
    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = nd.selectAll();
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/mostrarNota.jsp");
        rd.forward(request, response);
        
    }
    
    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Nota n = nd.selectById(id);
        request.setAttribute("nota", n);
        rd = request.getRequestDispatcher("/updateNota.jsp");
        rd.forward(request, response);
    }
}
