/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplicacion;

import BaseDatos.FachadaBaseDatos;
import java.util.ArrayList;

public class GestorClase {
    private final FachadaBaseDatos fachadaBD;

    public GestorClase(FachadaBaseDatos fachadaBD) {
        this.fachadaBD = fachadaBD;
    }

    public ArrayList<Valoracion> valoracionesClase(String nombreClase) {
        return fachadaBD.valoracionesClase(nombreClase);
    }

    public ValoracionResumen resumenValoracionesClase(String nombreClase) {
        return fachadaBD.resumenValoracionesClase(nombreClase);
    }
}
