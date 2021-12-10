package modelo;

public class Usuario {

    private int id;
    private String usuario;
    private String clave;
    private Tipo_Usuario tipo_usuario;

    public Usuario(int id, String usuario, String clave, Tipo_Usuario tipo_usuario) {
        this.id = id;
        this.usuario = usuario;
        this.clave = clave;
        this.tipo_usuario = tipo_usuario;
    }

    public Usuario(String usuario, String clave, Tipo_Usuario tipo_usuario) {
        this.usuario = usuario;
        this.clave = clave;
        this.tipo_usuario = tipo_usuario;
    }

    public Usuario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Tipo_Usuario getTipo_usuario() {
        return tipo_usuario;
    }

    public void setTipo_usuario(Tipo_Usuario tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

}
