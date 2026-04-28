package Aplicacion;

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
}