package controlador;

import conexion.Conexion;
import dao.TipoDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Tipo_Usuario;

public class TipoServlet extends HttpServlet {

    String msg;
    boolean resp;
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    TipoDao tpD = new TipoDao(conn);
    List<Tipo_Usuario> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.setAttribute("usuario", USUARIO);
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

        Tipo_Usuario tp = new Tipo_Usuario(0);
        tp.setTipo(request.getParameter("tipo"));
        resp = tpD.Insert(tp);
        if (resp) {
            msg = "Registro Guardado";
        } else {
            msg = "Registro No Guardado";
        }

        lista = tpD.selectAll();
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/tipoU.jsp");
        rd.forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String tipo = request.getParameter("tipo");

        Tipo_Usuario tp = new Tipo_Usuario(id);
        tp.setTipo(tipo);

        resp = tpD.Update(tp);
        if (resp) {
            msg = "Registro Actualizado";
        } else {
            msg = "Registro No Actualizado";
        }

        lista = tpD.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/verTipoU.jsp");
        rd.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        resp = tpD.Delete(id);
        if (resp) {
            msg = "Registro Eliminado";
        } else {
            msg = "Registro No Eliminado";
        }

        lista = tpD.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        request.setAttribute("msg", msg);
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/verTipoU.jsp");
        rd.forward(request, response);
    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        lista = tpD.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/verTipoU.jsp");
        rd.forward(request, response);
    }

    protected void selectId(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        lista = tpD.selectId(id);
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        request.setAttribute("lista", lista);

        rd = request.getRequestDispatcher("/editarTipoU.jsp");
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
