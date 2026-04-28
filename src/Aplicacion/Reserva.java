package Aplicacion;

import java.time.LocalDate;

public class Reserva {
    private Integer idReserva;
    private Integer idUsuario;
    private Integer idSesion;
    private Integer idPlaza;
    private LocalDate fechaReserva;

    public Reserva() {
    }

    // ID Reserva
    public Integer getIdReserva() {
        return idReserva;
    }
    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    // ID Usuario
    public Integer getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    // ID Sesion
    public Integer getIdSesion() {
        return idSesion;
    }
    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    // ID Plaza
    public Integer getIdPlaza() {
        return idPlaza;
    }
    public void setIdPlaza(Integer idPlaza) {
        this.idPlaza = idPlaza;
    }

    // Fecha Reserva
    public LocalDate getFechaReserva() {
        return fechaReserva;
    }
    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}