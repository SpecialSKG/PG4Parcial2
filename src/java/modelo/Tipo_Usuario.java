package modelo;

public class Tipo_Usuario {

    private int id;
    private String tipo;

    public Tipo_Usuario(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    
    public Tipo_Usuario() {
    }

    public Tipo_Usuario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
