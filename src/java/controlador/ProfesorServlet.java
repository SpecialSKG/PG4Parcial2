package controlador;

import conexion.Conexion;
import dao.ProfesorDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Profesor;

public class ProfesorServlet extends HttpServlet {

    String msg;
    boolean resp;
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    ProfesorDao profeD = new ProfesorDao(conn);
    List<Profesor> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insertar":
                insert(request, response);
                break;
            case "actualizar":
                update(request, response);
                break;
            case "eliminar":
                delete(request, response);
                break;
            case "seleccionarTodo":
                selectAll(request, response);
                break;
            case "seleccionarId":
                selectById(request, response);
                break;
        }
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int dui = Integer.parseInt(request.getParameter("dui"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");
        Profesor p = new Profesor(dui, nombre, apellido, direccion, telefono);
        profeD.insert(p);

        lista = profeD.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/verProfesores.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idprofesor"));
        int dui = Integer.parseInt(request.getParameter("dui"));
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String direccion = request.getParameter("direccion");
        String telefono = request.getParameter("telefono");

        Profesor prof = new Profesor(id);
        prof.setDui(dui);
        prof.setNombre(nombre);
        prof.setApellido(apellido);
        prof.setDireccion(direccion);
        prof.setTelefono(telefono);

        resp = profeD.update(prof);
        if (resp) {
            msg = "Registro Actualizado";
        } else {
            msg = "Registro No Actualizado";
        }

        lista = profeD.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/verProfesores.jsp");
        rd.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        String id = request.getParameter("idprofesor");
        profeD.delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/profesor?action=seleccionarTodo");
    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        lista = profeD.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/verProfesores.jsp");
        rd.forward(request, response);
    }

    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("idprofesor"));
        lista = profeD.selectById(id);
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/editarProfesor.jsp");
        rd.forward(request, response);
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

}
