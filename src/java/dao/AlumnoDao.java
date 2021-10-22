package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Alumno;

public class AlumnoDao {

    Conexion conn;

    public AlumnoDao(Conexion conn) {
        this.conn = conn;
    }

    public boolean Insert(Alumno alum) {
        try {
            String sql = "Insert into alumno (dui,direccion,nombre,telefono,edad,cif,telefono_empresa,direccion_empresa) values(?,?,?,?,?,?,?,?); ";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setString(1, alum.getDui());
            ps.setString(2, alum.getDireccion());
            ps.setString(3, alum.getNombre());
            ps.setString(4, alum.getTelefono());
            ps.setInt(5, alum.getEdad());
            ps.setString(6, alum.getCif());
            ps.setString(7, alum.getTelefono_empresa());
            ps.setString(8, alum.getDireccion_empresa());
            ps.executeUpdate();
            return true;
        } catch (Exception e) 
        {
            return false;
        }
    }

    public boolean Update(Alumno alum) {
        try {
            String sql = "update alumno set dui=?,direccion=?,nombre=?,telefono=?,edad=?,cif=?,telefono_empresa=?,direccion_empresa=? where id=?; ";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setString(1, alum.getDui());
            ps.setString(2, alum.getDireccion());
            ps.setString(3, alum.getNombre());
            ps.setString(4, alum.getTelefono());
            ps.setInt(5, alum.getEdad());
            ps.setString(6, alum.getCif());
            ps.setString(7, alum.getTelefono_empresa());
            ps.setString(8, alum.getDireccion_empresa());
            ps.setInt(9, alum.getId());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            
            System.out.println(e);
            return false;
        }
    }

    public boolean Delete(int id) {
        try {
            String sql = "delete from alumno where id=?; ";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Alumno> selectAll() {
        try {
            String sql = "select * from alumno;";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            Alumno alum;
            List<Alumno> lista = new LinkedList<>();
            while (rs.next()) {
                alum = new Alumno(rs.getInt("id"));
                alum.setDui(rs.getString("dui"));
                alum.setDireccion(rs.getString("direccion"));
                alum.setNombre(rs.getString("nombre"));
                alum.setTelefono(rs.getString("telefono"));
                alum.setEdad(rs.getInt("edad"));
                alum.setCif(rs.getString("cif"));
                alum.setTelefono_empresa(rs.getString("telefono_empresa"));
                alum.setDireccion_empresa(rs.getString("direccion_empresa"));
                lista.add(alum);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Alumno> selectId(int id) {
        try {
            String sql = "select * from alumno where id = ?;";
            PreparedStatement ps = conn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            Alumno alum;
            List<Alumno> lista = new LinkedList<>();
            while (rs.next()) {
                alum = new Alumno(rs.getInt("id"));
                alum.setDui(rs.getString("dui"));
                alum.setDireccion(rs.getString("direccion"));
                alum.setNombre(rs.getString("nombre"));
                alum.setTelefono(rs.getString("telefono"));
                alum.setEdad(rs.getInt("edad"));
                alum.setCif(rs.getString("cif"));
                alum.setTelefono_empresa(rs.getString("telefono_empresa"));
                alum.setDireccion_empresa(rs.getString("direccion_empresa"));
                lista.add(alum);
            }
            return lista;
        } catch (Exception e) {
            return null;
        }
    }
}
