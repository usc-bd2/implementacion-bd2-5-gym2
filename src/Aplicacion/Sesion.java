package Aplicacion;

import java.time.LocalDate;
import java.time.LocalTime;

public class Sesion {
    private Integer idSesion;
    private Integer idSala;
    private String nombreSala;
    private String nombreClase;
    private LocalDate fechaSesion;
    private LocalTime horaInicio;

    public Sesion() {
    }

    // ID
    public Integer getIdSesion() {
        return idSesion;
    }
    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    // ID Sala
    public Integer getIdSala() {
        return idSala;
    }
    public void setIdSala(Integer idSala) {
        this.idSala = idSala;
    }

    // Nombre Sala
    public String getNombreSala() {
        return nombreSala;
    }
    public void setNombreSala(String nombreSala) {
        this.nombreSala = nombreSala;
    }

    // Nombre Clase
    public String getNombreClase() {
        return nombreClase;
    }
    public void setNombreClase(String nombreClase) {
        this.nombreClase = nombreClase;
    }

    // Fecha Sesion
    public LocalDate getFechaSesion() {
        return fechaSesion;
    }
    public void setFechaSesion(LocalDate fechaSesion) {
        this.fechaSesion = fechaSesion;
    }

    // Hora Inicio
    public LocalTime getHoraInicio() {
        return horaInicio;
    }
    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }
}