/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplicacion;

import BaseDatos.FachadaBaseDatos;
import java.util.ArrayList;
import java.util.List;

public class GestorClases {
    private final FachadaBaseDatos fachadaBD;

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
    
    public ArrayList<Valoracion> valoracionesClase(String nombreClase) {
        return fachadaBD.valoracionesClase(nombreClase);
    }

    public ValoracionResumen resumenValoracionesClase(String nombreClase) {
        return fachadaBD.resumenValoracionesClase(nombreClase);
    }
}
