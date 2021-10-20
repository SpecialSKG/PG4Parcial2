package dao;

import conexion.Conexion;
import java.sql.Date;
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

    public boolean Insert(Curso c) {
        try {
            String sql = "Insert into curso (codigo,titulo,hora_duracion,fecha_inicio,fecha_fin,profe_dui,nombre,apellido,direccion,telefono) values(?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.setString(2, c.getTitulo());
            ps.setString(3, c.getHora_duracion());
            ps.setString(4, c.getFecha_inicio());
            ps.setInt(5, c.getFecha_fin());
            ps.setString(6, c.getProfe_dui());
            ps.setString(7, c.getNombre());
            ps.setString(8, c.getApellido());
            ps.setString(9, c.getDireccion());
            ps.setString(10, c.getTelefono());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Update(Curso c) {
        try {
            String sql = "update curso set codigo=?,titulo=?,hora_duracion=?,fecha_inicio=?,fecha_fin=?,profe_dui=?,nombre=?,apellido=?,direccion=?,telefono=? where id=?; ";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setString(1, c.getCodigo());
            ps.setString(2, c.getTitulo());
            ps.setDate(3, c.getHora_duracion());
            ps.setDate(4, c.getFecha_inicio());
            ps.setDate(5, c.getFecha_fin());
            ps.setString(6, c.getProfe_dui());
            ps.setString(7, c.getNombre());
            ps.setString(8, c.getApellido());
            ps.setString(9, c.getDireccion());
            ps.setString(10, c.getTelefono());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean Delete(int id) {
        try {
            String sql = "delete from curso where id=?; ";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Curso> selectAll() {
        try {
            String sql = "select * from curso;";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Curso c;
            List<Curso> lista = new LinkedList<>();
            while (rs.next()) {
                c = new Curso(rs.getInt("id"));
                c.setCodigo(rs.getString("codigo"));
                c.setTitulo(rs.getString("titulo"));
                c.setHora_duracion(rs.getDate("hora_duracion"));
                c.setFecha_inicio(rs.getDate("fecha_inicio"));
                c.setFecha_fin(rs.getDate("fecha_fin"));
                c.setProfe_dui(rs.getString("profe_dui"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setDireccion(rs.getString("direccion"));
                c.setTelefono(rs.getString("telefono"));
                lista.add(c);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Curso> selectId(int id) {
        try {
            String sql = "select * from curso where id = ?;";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Curso c;
            List<Curso> lista = new LinkedList<>();
            while (rs.next()) {
                c = new Curso(rs.getInt("id"));
                c.setCodigo(rs.getString("codigo"));
                c.setTitulo(rs.getString("titulo"));
                c.setHora_duracion(rs.getDate("hora_duracion"));
                c.setFecha_inicio(rs.getDate("fecha_inicio"));
                c.setFecha_fin(rs.getDate("fecha_fin"));
                c.setProfe_dui(rs.getString("profe_dui"));
                c.setNombre(rs.getString("nombre"));
                c.setApellido(rs.getString("apellido"));
                c.setDireccion(rs.getString("direccion"));
                c.setTelefono(rs.getString("telefono"));
                lista.add(c);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

}
