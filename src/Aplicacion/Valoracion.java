package Aplicacion;

import java.time.LocalDate;

public class Valoracion {
    private Integer idValoracion;
    private String nombreClase;
    private Integer idUsuario;
    private LocalDate fecha;
    private String opinion;
    private Integer puntuacion;

    public Valoracion() {
    }

    // Opinion
    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    // Puntuacion
    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    // ID Valoracion
    public Integer getIdValoracion() {
        return idValoracion;
    }
    public void setIdValoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    // Nombre clase
    public String getNombreClase() {
        return nombreClase;
    }
    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    // ID Usuario
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Fecha
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
