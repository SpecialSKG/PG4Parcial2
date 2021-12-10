package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Profesor;

public class ProfesorDao {

    Conexion conn;

    public ProfesorDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Profesor p) {
        try {
            String sql = "insert into profesor values(?,?,?,?,?,?)";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, p.getIdprofesor());
            ps.setInt(2, p.getDui());
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getApellido());
            ps.setString(5, p.getDireccion());
            ps.setString(6, p.getTelefono());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean update(Profesor p) {
        try {
            String sql = "update profesor set dui=?,nombre=?,apellido=?,direccion=?,telefono=? where idprofesor=?; ";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, p.getDui());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getApellido());
            ps.setString(4, p.getDireccion());
            ps.setString(5, p.getTelefono());
            ps.setInt(6, p.getIdprofesor());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {

            System.out.println(e);
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            String sql = "delete from profesor where idprofesor=?; ";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Profesor> selectAll() {
        try {
            String sql = "select * from profesor;";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Profesor pro;
            List<Profesor> lista = new LinkedList<>();
            while (rs.next()) {
                pro = new Profesor(rs.getInt("idprofesor"));
                pro.setDui(rs.getInt("dui"));
                pro.setNombre(rs.getString("nombre"));
                pro.setApellido(rs.getString("apellido"));
                pro.setDireccion(rs.getString("direccion"));
                pro.setTelefono(rs.getString("telefono"));
                lista.add(pro);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Profesor> selectById(int id) {
        try {
            String sql = "select * from profesor where idprofesor = ?;";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Profesor pro;
            List<Profesor> lista = new LinkedList<>();
            while (rs.next()) {
                pro = new Profesor(rs.getInt("idprofesor"));
                pro.setDui(rs.getInt("dui"));
                pro.setNombre(rs.getString("nombre"));
                pro.setApellido(rs.getString("apellido"));
                pro.setDireccion(rs.getString("direccion"));
                pro.setTelefono(rs.getString("telefono"));
                lista.add(pro);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
