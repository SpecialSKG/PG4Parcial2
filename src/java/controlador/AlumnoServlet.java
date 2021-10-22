package controlador;

import conexion.Conexion;
import dao.AlumnoDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;

public class AlumnoServlet extends HttpServlet {

    String msg;
    boolean resp;
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    AlumnoDao alumD = new AlumnoDao(conn);
    List<Alumno> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "insert":
                insert(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "selectAll":
                selectAll(request, response);
                break;
            case "selectId":
                selectId(request, response);
                break;
        };
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
        String dui = request.getParameter("dui");
        String direccion = request.getParameter("direccion");
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String cif = request.getParameter("cif");
        String telefono_empresa = request.getParameter("telefono_empresa");
        String direccion_empresa = request.getParameter("direccion_empresa");

        Alumno alum = new Alumno(0);
        alum.setDui(dui);
        alum.setDireccion(direccion);
        alum.setNombre(nombre);
        alum.setTelefono(telefono);
        alum.setEdad(edad);
        alum.setCif(cif);
        alum.setTelefono_empresa(telefono_empresa);
        alum.setDireccion_empresa(direccion_empresa);
*/
        Alumno alum = new Alumno(0);
        alum.setDui(request.getParameter("dui"));
        alum.setDireccion(request.getParameter("direccion"));
        alum.setNombre(request.getParameter("nombre"));
        alum.setTelefono(request.getParameter("telefono"));
        alum.setEdad(Integer.parseInt(request.getParameter("edad")));
        alum.setCif(request.getParameter("cif"));
        alum.setTelefono_empresa(request.getParameter("telefono_empresa"));
        alum.setDireccion_empresa(request.getParameter("direccion_empresa"));
        resp = alumD.Insert(alum);
        if (resp) {
            msg = "Registro Guardado";
        } else {
            msg = "Registro No Guardado";
        }

        lista = alumD.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/alumnos.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String dui = request.getParameter("dui");
        String direccion = request.getParameter("direccion");
        String nombre = request.getParameter("nombre");
        String telefono = request.getParameter("telefono");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String cif = request.getParameter("cif");
        String telefono_empresa = request.getParameter("telefono_empresa");
        String direccion_empresa = request.getParameter("direccion_empresa");

        Alumno alum = new Alumno(id);
        alum.setDui(dui);
        alum.setDireccion(direccion);
        alum.setNombre(nombre);
        alum.setTelefono(telefono);
        alum.setEdad(edad);
        alum.setCif(cif);
        alum.setTelefono_empresa(telefono_empresa);
        alum.setDireccion_empresa(direccion_empresa);

        resp = alumD.Update(alum);
        if (resp) {
            msg = "Registro Actualizado";
        } else {
            msg = "Registro No Actualizado";
        }

        lista = alumD.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/alumno.jsp");
        rd.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        resp = alumD.Delete(id);
        if (resp) {
            msg = "Registro Eliminado";
        } else {
            msg = "Registro No Eliminado";
        }

        lista = alumD.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/verAlumnos.jsp");
        rd.forward(request, response);
    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = alumD.selectAll();
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/verAlumnos.jsp");
        rd.forward(request, response);
    }

    protected void selectId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        lista = alumD.selectId(id);
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/editarAlumno.jsp");
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
