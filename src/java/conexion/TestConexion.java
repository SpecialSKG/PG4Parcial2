package conexion;

import dao.NotaDao;
import java.util.List;
import modelo.Curso;
import modelo.Nota;

public class TestConexion {

    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.Conectar();

        Curso curso = new Curso();
        
        NotaDao n = new NotaDao(c);
        
        for (Nota nota : n.selectAllWhereCurso(2)) {
            System.out.println(nota.getAlumno().getNombre() + " " + nota.getCurso().getTitulo());
        }

    }
}
