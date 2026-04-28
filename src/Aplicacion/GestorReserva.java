package Aplicacion;

import BaseDatos.FachadaBaseDatos;

public class GestorReserva {
    private FachadaBaseDatos fachadaBD;

    public GestorReserva(FachadaBaseDatos fachadaBD) {
        this.fachadaBD = fachadaBD;
    }

    public Integer registrarReserva(Reserva reserva) {
        if (reserva == null) {
            throw new RuntimeException("La reserva no puede ser nula.");
        }

        if (reserva.getIdUsuario() == null) {
            throw new RuntimeException("No hay usuario asociado a la reserva.");
        }

        if (reserva.getIdSesion() == null) {
            throw new RuntimeException("Debe seleccionarse una sesión.");
        }

        return fachadaBD.registrarReserva(reserva);
    }
}