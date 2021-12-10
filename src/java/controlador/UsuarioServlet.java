package controlador;

import conexion.Conexion;
import dao.TipoDao;
import dao.UsuarioDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Tipo_Usuario;
import modelo.Usuario;

public class UsuarioServlet extends HttpServlet {

    boolean respuesta;
    String msj;
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    UsuarioDao userd = new UsuarioDao(conn);
    List<Usuario> lista;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action) {
            case "login":
                login(request, response);
                break;
            case "logout":
                logout(request, response);
                break;
            case "insert":
                insert(request, response);
                break;

            case "selectAll":
                selectAll(request, response);
                break;

            case "selectById":
                selectById(request, response);
                break;

            case "delete":
                delete(request, response);
                break;

            case "update":
                update(request, response);
                break;
            case "goInsert":
                goInsert(request, response);
                break;
        }
    }

    private void goInsert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TipoDao pr = new TipoDao(conn);
        List<Tipo_Usuario> tipo = pr.selectAll();
        request.setAttribute("tipo", tipo);
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        rd = request.getRequestDispatcher("/usuarios.jsp");
        rd.forward(request, response);
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        respuesta = userd.login(usuario, clave);
        if (respuesta) {
            GlobalUsuario.setUSUARIO(usuario);
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            request.getRequestDispatcher("/inicio.jsp").forward(request, response);
        } else {
            msj = "Usuario o clave incorrecta";
            request.setAttribute("msj", msj);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            HttpSession session = request.getSession();
            session.invalidate();
            GlobalUsuario.setUSUARIO("");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int tipo_usuario = Integer.parseInt(request.getParameter("tipo_usuario"));

        Usuario user = new Usuario(0);
        user.setUsuario(request.getParameter("usuario"));
        user.setClave(request.getParameter("clave"));
        //user.setTipo_usuario(tipo_usuario);
        respuesta = userd.insert(user);
        if (respuesta) {
            msj = "registro insertado";
        } else {
            msj = "registro No insertado";
        }
        //lista = userd.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        request.setAttribute("msj", msj);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);

    }

    protected void selectAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        lista = userd.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/verUsuarios.jsp");
        rd.forward(request, response);
    }

    protected void selectById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        lista = userd.selectById(id);
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/actualizr.jsp");
        rd.forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        userd.Delete(Integer.parseInt(id));
        response.sendRedirect(request.getContextPath() + "/usuario?action=selectall");
    }

    protected void update(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int tipo_usuario = Integer.parseInt(request.getParameter("tipo_usuario"));

        Usuario user = new Usuario(Integer.parseInt(request.getParameter("id")));
        user.setUsuario(request.getParameter("usuario"));
        user.setClave(request.getParameter("clave"));
        //user.setTipo_usuario(tipo_usuario);
        respuesta = userd.update(user);
        if (respuesta) {
            msj = "registro actualizado";
        } else {
            msj = "registro No actualizado";
        }
        //lista = userd.selectAll();
        HttpSession session = request.getSession();
        session.setAttribute("usuario", (GlobalUsuario.getUSUARIO() != null && GlobalUsuario.getUSUARIO() != "")?GlobalUsuario.getUSUARIO(): null);
        request.setAttribute("msj", msj);
        request.setAttribute("lista", lista);
        rd = request.getRequestDispatcher("/inicio.jsp");
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
