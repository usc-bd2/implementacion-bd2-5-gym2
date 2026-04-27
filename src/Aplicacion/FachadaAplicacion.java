package Aplicacion;

import BaseDatos.FachadaBaseDatos;
import GUI.FachadaGUI;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

public class FachadaAplicacion {

    private final FachadaGUI fachadaGUI;
    private final FachadaBaseDatos fachadaBD;

    private final GestorUsuario gestUsuario;
    private final GestorProducto gestProducto;
    private final GestorPedido gestPedido;
    private final GestorClases gestClases;

    public FachadaAplicacion() {
        this.fachadaBD = new FachadaBaseDatos(this);
        this.fachadaGUI = new FachadaGUI(this);

        this.gestUsuario = new GestorUsuario(fachadaBD);
        this.gestProducto = new GestorProducto(fachadaBD);
        this.gestPedido = new GestorPedido(fachadaBD);
        this.gestClases = new GestorClases(fachadaBD);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                FachadaAplicacion fachadaAp = new FachadaAplicacion();
                fachadaAp.iniciar();
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(
                    null,
                    "Error al iniciar la aplicación:\n" + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    public void iniciar() {
        fachadaGUI.iniciarVentanas();
    }

    public void muestraExcepcion(String e) {
        fachadaGUI.muestraExcepcion(e);
    }

    public void cerrarAplicacion() {
        fachadaBD.cerrarConexion();
    }

    // ---------------- USUARIO ----------------

    public Usuario buscarUsuarioPorId(Integer idUsuario) {
        return gestUsuario.buscarUsuarioPorId(idUsuario);
    }

    public String registrarUsuario(Usuario u) {
        return gestUsuario.registrarUsuario(u);
    }

    public String modificarDatos(Usuario u) {
        return gestUsuario.modificarDatos(u);
    }

    public String eliminarUsuario(Usuario u) {
        return gestUsuario.eliminarUsuario(u);
    }

    public Usuario autenticarUsuario(String email, String contrasena) {
        return gestUsuario.autenticarUsuario(email, contrasena);
    }

    // ---------------- PRODUCTO ----------------

    public ArrayList<Producto> ensenarProductos() {
        return gestProducto.ensenarProductos();
    }

    public boolean pedidoProducto(Integer cantidadPedida, Integer idProducto, Integer idUsuario) {
        return gestProducto.pedidoProducto(cantidadPedida, idProducto, idUsuario);
    }

    // ---------------- PEDIDOS ----------------

    public ArrayList<Pedido> pedidosPendientesEntrega(Integer idUsuario) {
        return gestPedido.pedidosPendientesEntrega(idUsuario);
    }

    public boolean cancelarPedido(Integer idUsuario, Integer idProducto, Date fecha, Time hora) {
        return gestPedido.cancelarPedido(idUsuario, idProducto, fecha, hora);
    }

    // ---------------- CLASES ----------------

    public List<Clase> consultarClases(String nombre, Integer duracion, String clasificacion) {
        return gestClases.consultarClases(nombre, duracion, clasificacion);
    }

    public ArrayList<Valoracion> valoracionesClase(String nombreClase) {
        return gestClases.valoracionesClase(nombreClase);
    }

    public ValoracionResumen resumenValoracionesClase(String nombreClase) {
        return gestClases.resumenValoracionesClase(nombreClase);
    }
}