package conexion;

import dao.AlumnoDao;
import dao.CursoDao;
import dao.NotaDao;
import java.util.List;
import modelo.Alumno;
import modelo.Curso;
import modelo.Nota;

public class TestConexion {

    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.Conectar();
        /*
        Curso curso = new Curso();

        NotaDao n = new NotaDao(c);
        CursoDao cdao = new CursoDao(c);
        if (cdao.insert(new Curso("codigo", "titulo", "09:30:00", "2021-04-20 00:00:00", "2023-04-20 00:00:00", "profe_dui", " nombre", "apellido", "direccion", "telefono"))) {
            for (Curso cs : cdao.selectAll()) {
                System.out.println(cs.getTitulo());
            }
        }
         */
        Alumno alum = new Alumno();
        AlumnoDao ad = new AlumnoDao(c);

        alum.setDui("55555");
        alum.setDireccion("direccion");
        alum.setNombre("nombre");
        alum.setTelefono("telefono");
        alum.setEdad(25);
        alum.setCif("cif");
        alum.setTelefono_empresa("12345678");
        alum.setDireccion_empresa("direccion_empresa");
        alum.setId(1);
        boolean resp = ad.Update(alum);
        if (resp) {
            System.out.println("Registro Guardado con Exito");
            System.out.println("-------------");
        } else {
            System.out.println("Error en Guardado");
            System.out.println("-------------");
        }
    }
}
