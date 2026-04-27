/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplicacion;
import BaseDatos.FachadaBaseDatos;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author maria
 */
public class GestorPedido {
    private final FachadaBaseDatos fachadaBD;

    public GestorPedido(FachadaBaseDatos fachadaBD) {
        this.fachadaBD = fachadaBD;
    }
    
    public ArrayList<Pedido> pedidosPendientesEntrega(Integer idUsuario) { //t11
        return fachadaBD.pedidosPendientesEntrega(idUsuario);
    }
    
    public boolean cancelarPedido(Integer idUsuario, Integer idProducto, Date fecha, Time hora) {
        return fachadaBD.cancelarPedido(idUsuario, idProducto, fecha, hora);
    }  
}
