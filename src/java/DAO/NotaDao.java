/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;
import modelo.Alumno;
import modelo.Curso;
import modelo.Nota;
import modelo.Profesor;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 *
 * @author Angel
 */
public class NotaDao {

    public Conexion cn;

    public NotaDao(Conexion cn) {
        this.cn = cn;
    }

    public boolean insertar(Nota nota) {
        boolean flag = false;
        try {
            String sql = "INSERT INTO `pgracademia`.`nota` (`alumno`, `curso`, `notas`) VALUES (?, ?, ?);";
            PreparedStatement ps = cn.Conectar().prepareStatement(sql);
            ps.setInt(1, nota.getAlumno().getId());
            ps.setInt(2, nota.getCurso().getId());
            ps.setDouble(3, nota.getNota());
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("error al insertar Nota " + e);
        }
        return flag;
    }

    public boolean update(Nota nota) {
        boolean flag = false;
        try {
            String sql = "UPDATE `pgracademia`.`nota` SET `alumno` = ?, `curso` = ?, `notas` = ? WHERE (`id` = ?);";
            PreparedStatement ps = cn.Conectar().prepareStatement(sql);
            ps.setInt(1, nota.getAlumno().getId());
            ps.setInt(2, nota.getCurso().getId());
            ps.setDouble(3, nota.getNota());
            ps.setInt(4, nota.getId());
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("error al actualizar: " + e);
        }
        return flag;
    }

    public boolean delete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM `pgracademia`.`nota` WHERE (`id` = ?);";
            PreparedStatement ps = cn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            flag = true;
        } catch (Exception e) {
            System.out.println("error al actualizar: " + e);
        }
        return flag;
    }

    public Nota selectById(int id) {
        Nota nota = new Nota();
        try {
            String sql = "SELECT a.id as ida, a.dui as duia, a.direccion as direcciona, a.nombre as nombrea,a.telefono as telefonoa," +
"a.edad as edada, a.cif as cifa, a.telefono_empresa as telefono_empresaa, a.direccion_empresa as direccion_empresaa, " +
"c.id as idc, c.codigo as codigoc, c.titulo as tituloc, c.hora_duracion as hora_duracionc, c.fecha_inicio as fecha_inicioc, " +
"c.fecha_fin as fecha_finc, c.profesor as profesor, n.id as idn, n.alumno as alumnon, n.curso as curson, n.notas as nota, " +
" p.dui as profe_duic, p.nombre as nombrec, p.apellido as apellidoc, p.direccion as direccionc, p.telefono as telefonoc, p.idprofesor as profesor " +
"FROM nota n inner join alumno a on n.alumno = a.id inner join curso c  on n.curso = c.id inner join profesor p on p.idprofesor = c.profesor where n.id = ?";
            PreparedStatement ps = cn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                nota = new Nota(
                        rs.getInt("idn")
                        ,
                        new Curso(
                                rs.getInt("idc"),
                                rs.getString("codigoc"),
                                rs.getString("tituloc"),
                                new SimpleDateFormat("hh:mm:ss").parse(rs.getString("hora_duracionc")),
                                new SimpleDateFormat("yyyy-MM-dd' 'hh:mm:ss").parse(rs.getString("fecha_inicioc")),
                                new SimpleDateFormat("yyyy-MM-dd' 'hh:mm:ss").parse(rs.getString("fecha_finc")),
                                new Profesor(rs.getInt("profesor"), rs.getInt("profe_duic"), rs.getString("nombrec"),rs.getString("apellidoc"),rs.getString("direccionc"),rs.getString("telefonoc"))
                        )
                        ,new Alumno(
                                rs.getInt("ida"),
                                rs.getString("duia"),
                                rs.getString("direcciona"),
                                rs.getString("nombrea"),
                                rs.getString("telefonoa"),
                                rs.getInt("edada"),
                                rs.getString("cifa"),
                                rs.getString("telefono_empresaa"),
                                rs.getString("direccion_empresaa"))
                        ,rs.getDouble("nota"));
            }
        } catch (Exception e) {
            System.out.println("error al hacer el select del id " + id + " , en: " + e);
        }
        return nota;
    }

    public List<Nota> selectAll() {
        List<Nota> ln = new LinkedList<Nota>();
        try {
            String sql = "SELECT "
                    + "a.id as ida, a.dui as duia, a.direccion as direcciona, a.nombre as nombrea, a.telefono as telefonoa, "
                    + "a.edad as edada, a.cif as cifa, a.telefono_empresa as telefono_empresaa, a.direccion_empresa as direccion_empresaa, "
                    + "c.id as idc, c.codigo as codigoc, c.titulo as tituloc, c.hora_duracion as hora_duracionc, c.fecha_inicio as fecha_inicioc, "
                    + "c.fecha_fin as fecha_finc, "
                    + "p.idprofesor as profesor, p.dui as profe_duic, p.nombre as nombrec, p.apellido as apellidoc, p.direccion as direccionc, "
                    + "p.telefono as telefonoc, n.id as idn, n.alumno as alumnon, n.curso as curson, n.notas as nota "
                    + "FROM nota n "
                    + "inner join alumno a on n.alumno = a.id "
                    + "inner join curso c  on n.curso = c.id "
                    + "inner join profesor p on p.idprofesor = c.profesor";
            PreparedStatement ps = cn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Nota nota = new Nota(rs.getInt("idn"),
                        new Curso(
                                rs.getInt("idc"),
                                rs.getString("codigoc"),
                                rs.getString("tituloc"),
                                new SimpleDateFormat("hh:mm:ss").parse(rs.getString("hora_duracionc")),
                                new SimpleDateFormat("yyyy-MM-dd' 'hh:mm:ss").parse(rs.getString("fecha_inicioc")),
                                new SimpleDateFormat("yyyy-MM-dd' 'hh:mm:ss").parse(rs.getString("fecha_finc")),
                                new Profesor(
                                        rs.getInt("profesor"), 
                                        rs.getInt("profe_duic"), 
                                        rs.getString("nombrec"),
                                        rs.getString("apellidoc"),
                                        rs.getString("direccionc"),
                                        rs.getString("telefonoc"))
                        ),
                        new Alumno(
                                rs.getInt("ida"),
                                rs.getString("duia"),
                                rs.getString("direcciona"),
                                rs.getString("nombrea"),
                                rs.getString("telefonoa"),
                                rs.getInt("edada"),
                                rs.getString("cifa"),
                                rs.getString("telefono_empresaa"),
                                rs.getString("direccion_empresaa")),
                        rs.getDouble("nota"));
                ln.add(nota);
            }
        } catch (Exception e) {
            System.out.println("error al listar notas: " + e);
        }
        return ln;
    }
    
    public List<Nota> selectAllWhereCurso(int curso) {
        List<Nota> ln = new LinkedList<Nota>();
        try {
            String sql = "SELECT"
                    + " a.id as ida, a.dui as duia, a.direccion as direcciona, a.nombre as nombrea, a.telefono as telefonoa, "
                    + "a.edad as edada, a.cif as cifa, a.telefono_empresa as telefono_empresaa, a.direccion_empresa as direccion_empresaa,"
                    + " c.id as idc, c.codigo as codigoc, c.titulo as tituloc, c.hora_duracion as hora_duracionc, c.fecha_inicio as fecha_inicioc, "
                    + "c.fecha_fin as fecha_finc, "
                    + "p.idprofesor as profesor, p.dui as  profe_duic, p.nombre as nombrec, p.apellido as apellidoc, p.direccion as  direccionc, "
                    + "p.telefono as telefonoc, n.id as idn, n.alumno as alumnon, n.curso as curson, n.notas as nota "
                    + "FROM nota n "
                    + "inner join alumno a on n.alumno = a.id "
                    + "inner join curso c  on n.curso = c.id "
                    + "inner join profesor p on p.idprofesor  = c.profesor "
                    + "where c.id = "+curso;
            PreparedStatement ps = cn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Nota nota = new Nota(rs.getInt("idn"),
                        new Curso(
                                rs.getInt("idc"),
                                rs.getString("codigoc"),
                                rs.getString("tituloc"),
                                new SimpleDateFormat("hh:mm:ss").parse(rs.getString("hora_duracionc")),
                                new SimpleDateFormat("yyyy-MM-dd' 'hh:mm:ss").parse(rs.getString("fecha_inicioc")),
                                new SimpleDateFormat("yyyy-MM-dd' 'hh:mm:ss").parse(rs.getString("fecha_finc")),
                                new Profesor(
                                        rs.getInt("profesor"), 
                                        rs.getInt("profe_duic"), 
                                        rs.getString("nombrec"),
                                        rs.getString("apellidoc"),
                                        rs.getString("direccionc"),
                                        rs.getString("telefonoc"))),
                        new Alumno(
                                rs.getInt("ida"),
                                rs.getString("duia"),
                                rs.getString("direcciona"),
                                rs.getString("nombrea"),
                                rs.getString("telefonoa"),
                                rs.getInt("edada"),
                                rs.getString("cifa"),
                                rs.getString("telefono_empresaa"),
                                rs.getString("direccion_empresaa")),
                        rs.getDouble("nota"));
                ln.add(nota);
            }
        } catch (Exception e) {
            System.out.println("error al listar notas: " + e);
        }
        return ln;
    }
}
/*

SELECT 
a.id as ida, 
a.dui as duia,
a.direccion as direcciona, 
a.nombre as nombrea, 
a.telefono as telefonoa, 
a.edad as edada, 
a.cif as cifa, 
a.telefono_empresa as telefono_empresaa, 
a.direccion_empresa as direccion_empresaa,
c.id as idc,
c.codigo as codigoc,
c.titulo as tituloc,
c.hora_duracion as hora_duracionc,
c.fecha_inicio as fecha_inicioc,
c.fecha_fin as fecha_finc,
c.profe_dui as profe_duic,
c.nombre as nombrec,
c.apellido as apellidoc,
c.direccion as direccionc,
c.telefono as telefonoc,
n.id as idn,
n.alumno as alumnon,
n.curso as curson,
n.notas as nota
FROM nota n
inner join alumno a on n.alumno = a.id
inner join curso c  on n.curso = c.id
*/
