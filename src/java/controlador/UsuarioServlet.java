package controlador;

import conexion.Conexion;
import dao.UsuarioDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UsuarioServlet extends HttpServlet {

    boolean respuesta;
    String msj;
    RequestDispatcher rd;
    Conexion conn = new Conexion();
    UsuarioDao userd = new UsuarioDao(conn);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        switch (action) {
            case "login":
                login(request, response);
            case "logout":
                logout(request, response);
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String usuario = request.getParameter("usuario");
        String clave = request.getParameter("clave");
        respuesta = userd.login(usuario, clave);
        if (respuesta) {
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            request.getRequestDispatcher("inicio.jsp").forward(request, response);
        } else {
            msj = "Usuario o clave incorrecta";
            request.setAttribute("msj", msj);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        request.getRequestDispatcher("index.jsp").forward(request, response);

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
