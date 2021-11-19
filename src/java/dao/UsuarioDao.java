package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDao {

    Conexion conn;

    public UsuarioDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean login(String usuario, String clave) {
        String sql = "select usuario, clave from usuario where usuario = ? and clave = ?";
        try {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }
}
