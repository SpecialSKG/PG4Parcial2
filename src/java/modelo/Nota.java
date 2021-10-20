package modelo;

public class Nota {

    private int id;
    private Curso curso;
    private Alumno alumno;
    private double nota;

    public Nota(int id, Curso curso, Alumno alumno, double nota) {
        this.id = id;
        this.curso = curso;
        this.alumno = alumno;
        this.nota = nota;
    }

    public Nota(int curso, int alumno, double nota) {
        this.curso = new Curso(curso);
        this.alumno = new Alumno(alumno);
        this.nota = nota;
    }

    public Nota(int id) {
        this.id = id;
    }

    public Nota() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
}
