package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import modelo.Tipo_Usuario;
import modelo.Usuario;

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
            System.out.println(ex);
            return false;
        }
    }

    public boolean insert(Usuario user) {
        String sql = "insert into usuario values (?,?,?,?)";
        try {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            Tipo_Usuario tipou = user.getTipo_usuario();

            ps.setInt(1, user.getId());
            ps.setString(2, user.getUsuario());
            ps.setString(3, user.getClave());
            ps.setInt(4, tipou.getId());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println("Error " + e);
            return false;
        }
    }

    public boolean update(Usuario user) {
        String sql = "update usuario set usuario = ?, clave = ?, tipo_usuario = ? where id = ?";
        try {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            Tipo_Usuario tipou = user.getTipo_usuario();

            ps.setString(1, user.getUsuario());
            ps.setString(2, user.getClave());
            ps.setInt(3, tipou.getId());
            ps.setInt(4, user.getId());
            ps.executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println("Error " + e);
            return false;
        }
    }

    public List<Usuario> selectAll() {
        String sql = "select * from usuario";
        try {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Usuario user;
            Tipo_Usuario tipou;

            List<Usuario> lista = new LinkedList<>();
            while (rs.next()) {
                tipou = new Tipo_Usuario(rs.getInt("id"));
                user = new Usuario(rs.getInt("id"));
                user.setUsuario("usuario");
                user.setClave("clave");
                user.setTipo_usuario(tipou);
                lista.add(user);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error " + e);
            return null;
        }
    }

    public List<Usuario> selectById(int id) {
        String sql = "select * from usuario where id = ?";
        try {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Usuario user;
            Tipo_Usuario tipou;

            List<Usuario> lista = new LinkedList<>();
            while (rs.next()) {
                tipou = new Tipo_Usuario(rs.getInt("id"));
                user = new Usuario(rs.getInt("id"));
                user.setUsuario("usuario");
                user.setClave("clave");
                user.setTipo_usuario(tipou);
                lista.add(user);
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Error " + e);
            return null;
        }
    }

    public boolean Delete(int id) {
        String sql = "delete * from usuario where id = ?";
        try {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

            return true;
            
        } catch (Exception e) {
            System.out.println("Error " + e);
            return false;
        }
    }
}
