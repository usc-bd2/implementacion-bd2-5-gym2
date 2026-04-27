/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplicacion;

import BaseDatos.FachadaBaseDatos;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class GestorProducto {
    private final FachadaBaseDatos fachadaBD;

    public GestorProducto(FachadaBaseDatos fachadaBD) {
        this.fachadaBD = fachadaBD;
    }
    
    public ArrayList<Producto> ensenarProductos() { //t9
        return fachadaBD.ensenarProductos();
    }
    
    public boolean pedidoProducto(Integer cantidadPedida, Integer idProducto, Integer idUsuario) { //t10
        return fachadaBD.pedidoProducto(cantidadPedida, idProducto, idUsuario);
    }
    
}
