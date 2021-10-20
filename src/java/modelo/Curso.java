package modelo;

import java.util.Date;

public class Curso {

    private int id;
    private String codigo;
    private String titulo;
    private Date hora_duracion;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String profe_dui;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    public Curso(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getHora_duracion() {
        return hora_duracion;
    }

    public void setHora_duracion(Date hora_duracion) {
        this.hora_duracion = hora_duracion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getProfe_dui() {
        return profe_dui;
    }

    public void setProfe_dui(String profe_dui) {
        this.profe_dui = profe_dui;
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
