package Aplicacion;

import BaseDatos.FachadaBaseDatos;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class GestorSesiones {
    private FachadaBaseDatos fachadaBD;

    public GestorSesiones(FachadaBaseDatos fachadaBD) {
        this.fachadaBD = fachadaBD;
    }

    public List<Sesion> consultarSesiones(String nombreClase, LocalDate fechaSesion, String nombreSala, LocalTime horaInicio) {
        return fachadaBD.consultarSesiones(nombreClase, fechaSesion, nombreSala, horaInicio);
    }
}