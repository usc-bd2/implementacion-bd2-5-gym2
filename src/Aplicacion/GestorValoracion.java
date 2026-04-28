package Aplicacion;

import java.util.List;

import BaseDatos.FachadaBaseDatos;


public class GestorValoracion {
    private FachadaBaseDatos fachadaBD;

    public GestorValoracion(FachadaBaseDatos fachadaBD) {
        this.fachadaBD = fachadaBD;
    }

    public int registrarValoracion(Valoracion valoracion) {
        validarValoracion(valoracion);
        return fachadaBD.insertarValoracion(valoracion);
    }

    private void validarValoracion(Valoracion valoracion) {
        if (valoracion.consultarNombreClase() == null || valoracion.consultarNombreClase().isBlank()) {
            throw new RuntimeException("Debe seleccionarse una clase.");
        }

        if (valoracion.consultarIdUsuario() == null) {
            throw new RuntimeException("No hay un usuario autenticado.");
        }
    }
    
    public List<Valoracion> consultarValoracionesPropias(Integer idUsuario) {
        return fachadaBD.consultarValoracionesPropias(idUsuario);
    }

    public Integer modificarValoracion(Valoracion valoracion) {
        if (valoracion.consultarIdValoracion() == null) {
            throw new RuntimeException("Debe seleccionarse una valoración.");
        }
        return fachadaBD.modificarValoracion(valoracion);
    }

    public Integer eliminarValoracion(Integer idValoracion, Integer idUsuario) {
        if (idValoracion == null) {
            throw new RuntimeException("Debe seleccionarse una valoración.");
        }
        if (idUsuario == null) {
            throw new RuntimeException("No hay un usuario autenticado.");
        }
        return fachadaBD.eliminarValoracion(idValoracion, idUsuario);
    }
}