package modelo;

public class Nota {

    private int id;
    /*    
    private Curso curso;
    private Alumno alumno;
     */
    private int curso;
    private int alumno;
    private double nota;

    public Nota() {
    }

    public Nota(int curso, int alumno, double nota) {
        this.curso = curso;
        this.alumno = alumno;
        this.nota = nota;
    }

    public Nota(int id, int curso, int alumno, double nota) {
        this.id = id;
        this.curso = curso;
        this.alumno = alumno;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    

}
