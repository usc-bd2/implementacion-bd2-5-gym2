package Aplicacion;

import BaseDatos.FachadaBaseDatos;
import GUI.FachadaGUI;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;

import javax.swing.SwingUtilities;

public class FachadaAplicacion {
    private FachadaGUI fachadaGUI;
    private FachadaBaseDatos fachadaBD;
    private GestorUsuario gestUsuario;
    private GestorSesiones gestSesiones;
    private GestorClase gestClase;
    private GestorProducto gestProducto;
    private GestorPedido gestPedido;
    private GestorValoracion gestValoracion;
    private Usuario usuarioAutenticado;

    public FachadaAplicacion() {
        this.fachadaBD = new FachadaBaseDatos(this);
        this.fachadaGUI = new FachadaGUI(this);
        this.gestUsuario = new GestorUsuario(fachadaBD);
        this.gestSesiones = new GestorSesiones(fachadaBD);
        this.gestClase = new GestorClase(fachadaBD);
        this.gestProducto = new GestorProducto(fachadaBD);
        this.gestPedido = new GestorPedido(fachadaBD);
        this.gestValoracion = new GestorValoracion(fachadaBD);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                FachadaAplicacion fachadaAp = new FachadaAplicacion();
                fachadaAp.iniciar();
            } catch (RuntimeException e) {
                javax.swing.JOptionPane.showMessageDialog(
                null,
                "Error al iniciar la aplicación:\n" + e.getMessage(),
                "Error",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            }
        });
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

    public Integer getIdUsuarioAutenticado() {
        return usuarioAutenticado != null ? usuarioAutenticado.getIdUsuario() : null;
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

    // Producto
    public ArrayList<Producto> ensenarProductos(){
        return gestProducto.ensenarProductos();
    }
    
    // Pedido
    public boolean pedidoProducto(Integer cantidadPedida, Integer idProducto, Integer idUsuario) {
        return gestProducto.pedidoProducto(cantidadPedida, idProducto, idUsuario);
    }
    
    public ArrayList<Pedido> pedidosPendientesEntrega(Integer idUsuario) {
        return gestPedido.pedidosPendientesEntrega(idUsuario);
    }
    
    public boolean cancelarPedido(Integer idUsuario, Integer idProducto, Date fecha, Time hora) {
        return gestPedido.cancelarPedido(idUsuario, idProducto, fecha, hora);
    }

    // Clase
    public List<Clase> consultarClases(String nombre, Integer duracion, String clasificacion) {
        return gestClase.consultarClases(nombre, duracion, clasificacion);
    }

    public ArrayList<Valoracion> valoracionesClase(String nombreClase) {
        return gestClase.valoracionesClase(nombreClase);
    }

    public ValoracionResumen resumenValoracionesClase(String nombreClase) {
        return gestClase.resumenValoracionesClase(nombreClase);
    }
    
    public Usuario autenticarUsuario(String email, String contrasena) {
        Usuario usuario = gestUsuario.autenticarUsuario(email, contrasena);
        this.usuarioAutenticado = usuario;
        return usuario;
    }

    public List<Sesion> consultarSesiones(String nombreClase, java.time.LocalDate fechaSesion,
                                        String nombreSala, java.time.LocalTime horaInicio) {
        return gestSesiones.consultarSesiones(nombreClase, fechaSesion, nombreSala, horaInicio);
    }

    public int registrarValoracion(Valoracion valoracion) {
        return gestValoracion.registrarValoracion(valoracion);
    }

    public List<Valoracion> consultarValoracionesPropias() {
        return gestValoracion.consultarValoracionesPropias(getIdUsuarioAutenticado());
    }
}