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

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer consultarIdValoracion() {
        return idValoracion;
    }

    public void modificarIdValoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public String consultarNombreClase() {
        return nombreClase;
    }

    public void modificarNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    public Integer consultarIdUsuario() {
        return idUsuario;
    }

    public void modificarIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDate consultarFecha() {
        return fecha;
    }

    public void modificarFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String consultarOpinion() {
        return opinion;
    }

    public void modificarOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Integer consultarPuntuacion() {
        return puntuacion;
    }

    public void modificarPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }
}
