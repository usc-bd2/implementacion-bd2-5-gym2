/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplicacion;
import java.util.Date;
import java.sql.Time;

/**
 *
 * @author maria
 */
public class Pedido {
    private Integer idUsuario;
    private Integer idProducto;
    private String nombre;
    private Date fecha;
    private Time hora;
    private Integer cantidad;
    private boolean entregado;
    
    public Pedido() {
        
    }
    
    //idUsuario
    public Integer getIdUsuario() {
        return idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    //idProducto
    public Integer getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
    
    //nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    //fecha
    public Date getFecha() {
        return fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    //hora
    public Time getHora() {
        return hora;
    }
    
    public void setHora(Time hora) {
        this.hora = hora;
    }
    
    //cantidad
    public Integer getCantidad() {
        return cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    //entregado
    public Boolean getEntregado() {
        return entregado;
    }
    
    public void setEntregado(Boolean entregado) {
        this.entregado = entregado;
    }
}
