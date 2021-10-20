package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    static String bd = "pgracademia";
    static String user = "root";
    static String pass = "";
    static String url = "jdbc:mysql://localhost:3306/" + bd + "?useSSL=false";

    Connection conn = null;

    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, pass);
            if (conn != null) {
                System.out.println("Conexion Valida");
            }
        } catch (Exception e) {
            System.out.println("Conexion Invalida" + e);
        }
    }

    public Connection Conectar() {
        return conn;
    }

    public void Desconectar() throws Exception {
        conn.close();
    }
}
