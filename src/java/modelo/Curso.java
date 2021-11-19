package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Curso {

    private int id;
    private String codigo;
    private String titulo;
    private Date hora_duracion;
    private Date fecha_inicio;
    private Date fecha_fin;
    private int profe;

    public Curso() {
    }
    
    public Curso(int id) {
        this.id = id;
    }

    public Curso(String codigo, String titulo, Date hora_duracion, Date fecha_inicio, Date fecha_fin, int profe) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.hora_duracion = hora_duracion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.profe = profe;
    }
    
    public Curso(String codigo, String titulo, String hora_duracion, String fecha_inicio, String fecha_fin, int profe) {
        this.codigo = codigo;
        this.titulo = titulo;
        
        try {
            this.hora_duracion = new SimpleDateFormat("hh:mm").parse(hora_duracion);
            this.fecha_inicio = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_inicio);
            this.fecha_fin = new SimpleDateFormat("yyyy-MM-dd").parse(fecha_fin);
        } catch (Exception e) {
            System.out.println("Error en el paseo de alguno de los tiempos formato de fechas son yyyy-MM-dd hh:mm:ss formato de hora hh:mm:ss: "+ e);
        }
        
        this.profe = profe;
    }

    public Curso(int id, String codigo, String titulo, Date hora_duracion, Date fecha_inicio, Date fecha_fin, int profe) {
        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.hora_duracion = hora_duracion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.profe = profe;
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
    
    public String getHoraDuracionString() {
        return new SimpleDateFormat("hh:mm").format(this.hora_duracion);
    }

    public void setHoraDuracionString(String horaFecha) {
        try {
            this.hora_duracion = new SimpleDateFormat("hh:mm").parse(horaFecha);
        } catch (Exception e) {
            System.out.println("error al parsea, formato valido yyyy-MM-dd' 'hh:mm:ss " + e);
        }
    }

    public void setHora_duracion(Date hora_duracion) {
        this.hora_duracion = hora_duracion;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }
    
    public String getFechaInicioString(){
        return new SimpleDateFormat("yyyy-MM-dd").format(fecha_inicio);
    }

    public void setFechaInicioString(String fecha) {
        try {
            this.fecha_inicio = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (Exception e) {
            System.out.println("error al parsea, formato valido yyyy-MM-dd' 'hh:mm:ss " + e);
        }
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFechaFinString(){
        return new SimpleDateFormat("yyyy-MM-dd").format(fecha_fin);
    }
    
    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFechaFinString(String fecha) {
        try {
            this.fecha_fin = new SimpleDateFormat("yyyy-MM-dd").parse(fecha);
        } catch (Exception e) {
            System.out.println("error al parsea, formato valido yyyy-MM-dd' 'hh:mm : " + e);
        }
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public int getProfe() {
        return profe;
    }

    public void setProfe(int profe) {
        this.profe = profe;
    }
    

}
