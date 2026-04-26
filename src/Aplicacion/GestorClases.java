package Aplicacion;

import BaseDatos.FachadaBaseDatos;
import java.util.List;

public class GestorClases {
    private FachadaBaseDatos fachadaBD;

    public GestorClases(FachadaBaseDatos fachadaBD) {
        this.fachadaBD = fachadaBD;
    }

    /**
     * Consulta las clases registradas en el sistema.
     * Los filtros son opcionales: si vienen vacíos o null, no se aplican.
     */
    public List<Clase> consultarClases(String nombre, Integer duracion, String clasificacion) {
        return fachadaBD.consultarClases(nombre, duracion, clasificacion);
    }
}