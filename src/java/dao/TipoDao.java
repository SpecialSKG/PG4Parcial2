package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Tipo_Usuario;

public class TipoDao {

    Conexion conn;

    public TipoDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean Insert(Tipo_Usuario tp) {
        try {
            String sql = "Insert into tipo_usuario (tipo) values(?); ";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setString(1, tp.getTipo());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Update(Tipo_Usuario tp) {
        try {
            String sql = "update tipo_usuario set tipo=? where id=?; ";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setString(1, tp.getTipo());
            ps.setInt(2, tp.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println(e);
            return false;
        }
    }

    public boolean Delete(int id) {
        try {
            String sql = "delete from tipo_usuario where id=?; ";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Tipo_Usuario> selectAll() {
        try {
            String sql = "select * from tipo_usuario;";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Tipo_Usuario tp;
            List<Tipo_Usuario> lista = new LinkedList<>();
            while (rs.next()) {
                tp = new Tipo_Usuario(rs.getInt("id"));
                tp.setTipo(rs.getString("tipo"));
                lista.add(tp);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Tipo_Usuario> selectId(int id) {
        try {
            String sql = "select * from tipo_usuario where id = ?;";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Tipo_Usuario tp;
            List<Tipo_Usuario> lista = new LinkedList<>();
            while (rs.next()) {
                tp = new Tipo_Usuario(rs.getInt("id"));
                tp.setTipo(rs.getString("tipo"));
                lista.add(tp);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
