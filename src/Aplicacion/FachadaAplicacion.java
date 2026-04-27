package Aplicacion;

import BaseDatos.FachadaBaseDatos;
import GUI.FachadaGUI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

public class FachadaAplicacion {
    private final FachadaGUI fachadaGUI;
    private final FachadaBaseDatos fachadaBD;
    private final GestorUsuario gestUsuario;
    private final GestorProducto gestProducto;
    private final GestorPedido gestPedido;
    private final GestorClase gestClase;

    public FachadaAplicacion() {
        this.fachadaBD = new FachadaBaseDatos(this);
        this.fachadaGUI = new FachadaGUI(this);
        this.gestUsuario = new GestorUsuario(fachadaBD);
        this.gestProducto = new GestorProducto(fachadaBD);
        this.gestPedido = new GestorPedido(fachadaBD);
        this.gestClase = new GestorClase(fachadaBD);
    }

    public static void main(String[] args) {
        FachadaAplicacion fachadaAp = null;
        
        try {
            fachadaAp = new FachadaAplicacion();
            fachadaAp.iniciar();
        } catch (RuntimeException e) {
            System.err.println("Error al iniciar la aplicación: " + e.getMessage());
        }
    }

    public void iniciar() {
        fachadaGUI.iniciarVentanas();
    }
    
    public void muestraExcepcion(String e){
     fachadaGUI.muestraExcepcion(e);
    }

    public void cerrarAplicacion() {
        fachadaBD.cerrarConexion();
    }

    // Usuario
    public Usuario buscarUsuarioPorId(Integer idUsuario) {
        return gestUsuario.buscarUsuarioPorId(idUsuario);
    }
    
    public String registrarUsuario(Usuario u){
        return gestUsuario.registrarUsuario(u);
    }
    
    public String modificarDatos(Usuario u){
        return gestUsuario.modificarDatos(u);
    }
    
    public String eliminarUsuario(Usuario u) {
        return gestUsuario.eliminarUsuario(u);
    }
    
    public ArrayList<Producto> ensenarProductos(){
        return gestProducto.ensenarProductos();
    }
    
    public boolean pedidoProducto(Integer cantidadPedida, Integer idProducto, Integer idUsuario) {
        return gestProducto.pedidoProducto(cantidadPedida, idProducto, idUsuario);
    }
    
    public ArrayList<Pedido> pedidosPendientesEntrega(Integer idUsuario) {
        return gestPedido.pedidosPendientesEntrega(idUsuario);
    }
    
    public boolean cancelarPedido(Integer idUsuario, Integer idProducto, Date fecha, Time hora) {
        return gestPedido.cancelarPedido(idUsuario, idProducto, fecha, hora);
    }
    
    public ArrayList<Valoracion> valoracionesClase(String nombreClase) {
        return gestClase.valoracionesClase(nombreClase);
    }

    public ValoracionResumen resumenValoracionesClase(String nombreClase) {
        return gestClase.resumenValoracionesClase(nombreClase);
    }
    
    public Usuario autenticarUsuario(String email, String contrasena) {
        return gestUsuario.autenticarUsuario(email, contrasena);
    }
}