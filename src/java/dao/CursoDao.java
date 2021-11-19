package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.*;

public class CursoDao {

    Conexion conn;

    public CursoDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean insert(Curso c) {
        try {
            String sql = "Insert into curso (codigo,titulo,hora_duracion,fecha_inicio,fecha_fin,profesor) values(?,?,?,?,?,?);";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.setString(2, c.getTitulo());
            ps.setString(3, c.getHoraDuracionString());
            ps.setString(4, c.getFechaInicioString());
            ps.setString(5, c.getFechaFinString());
            ps.setInt(6, c.getProfe().getIdprofesor());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("/*/*/*/*/*/*/");
            System.out.println(e);
            System.out.println("/*/*/*/*/*/*/");
            return false;
        }
    }

    public boolean update(Curso c) {
        try {
            String sql = "update curso set codigo=?,titulo=?,hora_duracion=?,fecha_inicio=?,fecha_fin=?,profesor=? where id=?; ";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.setString(2, c.getTitulo());
            ps.setString(3, c.getHoraDuracionString());
            ps.setString(4, c.getFechaInicioString());
            ps.setString(5, c.getFechaFinString());
            ps.setInt(6, c.getProfe().getIdprofesor());
            ps.setInt(7, c.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            String sql = "delete from curso where id=?; ";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List<Curso> selectAll() {
        try {
            String sql = "SELECT * FROM curso c inner join profesor p on c.profesor = p.idprofesor;";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Curso c;
            List<Curso> lista = new LinkedList<>();
            while (rs.next()) {
                c = new Curso(rs.getInt("id"));
                c.setCodigo(rs.getString("codigo"));
                c.setTitulo(rs.getString("titulo"));
                c.setHora_duracion(rs.getTimestamp("hora_duracion"));
                c.setFecha_inicio(rs.getDate("fecha_inicio"));
                c.setFecha_fin(rs.getDate("fecha_fin"));
                c.setProfe(new Profesor(rs.getInt("idprofesor"),rs.getInt("dui"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("direccion"), rs.getString("telefono")));
                lista.add(c);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public Curso selectById(int id) {
        Curso c = new Curso();
        String sql = "SELECT * FROM curso c inner join profesor p on c.profesor = p.idprofesor where c.id = ?;";
        try {
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                c.setId(rs.getInt("id"));
                c.setCodigo(rs.getString("codigo"));
                c.setTitulo(rs.getString("titulo"));
                c.setHora_duracion(rs.getDate("hora_duracion"));
                c.setFecha_inicio(rs.getDate("fecha_inicio"));
                c.setFecha_fin(rs.getDate("fecha_fin"));
                c.setProfe(new Profesor(rs.getInt("idprofesor"),rs.getInt("dui"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("direccion"), rs.getString("telefono")));
            }
        } catch (Exception e) {
            System.out.println("Error " + e);
        }
        return c;
    }
}
