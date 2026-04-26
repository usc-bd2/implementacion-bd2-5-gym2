package Aplicacion;


public class Clase {
    private String nombre;
    private Integer duracion;
    private String clasificacion;
    private Double puntuacionMedia;

    public Clase() {
    }

    // Nombre
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Duración
    public Integer getDuracion() {
        return duracion;
    }
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    // Clasificación
    public String getClasificacion() {
        return clasificacion;
    }
    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    // Puntuación media
    public Double getPuntuacionMedia() {
        return puntuacionMedia;
    }
    public void setPuntuacionMedia(Double puntuacionMedia) {
        this.puntuacionMedia = puntuacionMedia;
    }
}