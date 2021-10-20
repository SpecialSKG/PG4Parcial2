/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import modelo.Nota;

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
            ps.setInt(1, nota.getAlumno());
            ps.setInt(2, nota.getCurso());
            ps.setDouble(3, nota.getNota());
            ps.executeUpdate();
            flag = true;
            cn.Desconectar();
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
            ps.setInt(1, nota.getAlumno());
            ps.setInt(2, nota.getCurso());
            ps.setDouble(3, nota.getNota());
            ps.setInt(4, nota.getId());
            ps.executeUpdate();
            flag = true;
            cn.Desconectar();
        } catch (Exception e) {
            System.out.println("error al actualizar: "+ e);
        }
        return flag;
    }
    
    public boolean dalete(int id) {
        boolean flag = false;
        try {
            String sql = "DELETE FROM `pgracademia`.`nota` WHERE (`id` = ?);";
            PreparedStatement ps = cn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            flag = true;
            cn.Desconectar();
        } catch (Exception e) {
            System.out.println("error al actualizar: "+ e);
        }
        return flag;
    }
    
    public Nota selectById(int id){
        Nota nota = new Nota();
        try {
            String sql = "SELECT * FROM pgracademia.nota where id = ?;";
            PreparedStatement ps = cn.Conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                nota = new Nota(
                        rs.getInt("id"),
                        rs.getInt("alumno"),
                        rs.getInt("curso"),
                        rs.getDouble("notas"));
            }
            cn.Desconectar();
            
        } catch (Exception e) {
            System.out.println("error al hacer el select del id "+id + " , en: "+e);
        }
        return nota;
    }
    
    
    public List<Nota> selectAll(){
        List<Nota> ln = new LinkedList<Nota>();
        try {
            String sql = "SELECT * FROM pgracademia.nota;";
            PreparedStatement ps = cn.Conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Nota nota = new Nota(rs.getInt("id"), rs.getInt("alumno"), rs.getInt("curso"), rs.getDouble("notas"));
                ln.add(nota);
            }
            cn.Desconectar();
        } catch (Exception e) {
            System.out.println("error al listar notas: "+e);
        }
        return ln;
    }
}
