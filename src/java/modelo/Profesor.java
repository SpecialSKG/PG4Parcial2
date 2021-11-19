package modelo;

public class Profesor {

    private int idprofesor;
    private int dui;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public Profesor() {
    }

    public Profesor(int idprofesor, int dui, String nombre, String apellido, String direccion, String telefono) {
        this.idprofesor = idprofesor;
        this.dui = dui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Profesor(int dui, String nombre, String apellido, String direccion, String telefono) {
        this.dui = dui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Profesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public int getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(int idprofesor) {
        this.idprofesor = idprofesor;
    }

    public int getDui() {
        return dui;
    }

    public void setDui(int dui) {
        this.dui = dui;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    
}
