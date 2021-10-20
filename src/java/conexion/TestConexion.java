package conexion;

import dao.CursoDao;
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
        CursoDao cdao = new CursoDao(c);
        if (cdao.Insert(new Curso("codigo", "titulo", "09:30:00", "2021-04-20 00:00:00", "2023-04-20 00:00:00", "profe_dui", " nombre", "apellido", "direccion", "telefono"))) {
            for (Curso cs : cdao.selectAll()) {
                System.out.println(cs.getTitulo());
            }
        }

    }
}
