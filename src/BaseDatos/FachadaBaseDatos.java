package BaseDatos;

import Aplicacion.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Time;


public class FachadaBaseDatos {
    private Connection conexionBD;
    private DAOUsuario daoUsuario;
    private DAOSesiones daoSesiones;
    private DAOClase daoClase;
    private DAOProducto daoProducto;
    private DAOPedido daoPedido;
    private DAOValoracion daoValoracion;

    public FachadaBaseDatos(FachadaAplicacion fa) {
        try {
            FileInputStream docConfig = new FileInputStream("Gym.properties");
            Properties config = new Properties();
            config.load(docConfig);

            String gestor = config.getProperty("gestor");
            String servidor = config.getProperty("servidor");
            String puerto = config.getProperty("puerto");
            String baseDatos = config.getProperty("baseDatos");
            String usuario = config.getProperty("usuario");
            String clave = config.getProperty("clave");

            if (!"postgresql".equalsIgnoreCase(gestor)) {
                throw new IllegalArgumentException(
                    "El gestor configurado no es compatible: " + gestor
                );
            }

            String urlConexion = "jdbc:postgresql://" + servidor + ":" + puerto + "/" + baseDatos;
            this.conexionBD = DriverManager.getConnection(urlConexion, usuario, clave);

            // Inicializar los DAOs
            this.daoUsuario = new DAOUsuario(conexionBD);
            this.daoSesiones = new DAOSesiones(conexionBD);
            this.daoClase = new DAOClase(conexionBD);
            this.daoProducto = new DAOProducto(conexionBD);
            this.daoPedido = new DAOPedido(conexionBD);
            this.daoValoracion = new DAOValoracion(conexionBD);

        } catch (IOException | SQLException e) {
            throw new IllegalStateException("No se pudo inicializar la base de datos: " + e.getMessage(), e);
        }
    }

    public Connection getConexionBD() {
        return conexionBD;
    }

    public void cerrarConexion() {
        try {
            if (conexionBD != null && !conexionBD.isClosed()) {
                conexionBD.close();
            }
        } catch (SQLException e) {
            System.err.println("No se ha podido cerrar la conexión: " + e.getMessage());
        }
    }
    
    public Usuario buscarUsuarioPorId(Integer idUsuario) {
        return daoUsuario.buscarPorId(idUsuario);
    }

    public List<Clase> consultarClases(String nombre, Integer duracion, String clasificacion) {
       return daoClase.consultarClases(nombre, duracion, clasificacion);
    }

    public boolean existeIdUsuario(Integer idUsuario) {
        return daoUsuario.existeIdUsuario(idUsuario);
    }
    
    public boolean existeEmail(String email) {
        return daoUsuario.existeEmail(email);
    }
    
    public boolean insertarUsuario(Usuario u) {
        return daoUsuario.insertarUsuario(u);
    }
    
    public boolean modificarDatos(Usuario u) {
        return daoUsuario.modificarDatos(u);
    }
    
    public boolean existeReserva(Integer idUsuario) {
        return daoUsuario.existeReserva(idUsuario);
    }
    
    public boolean pedidosNoEntregados(Integer idUsuario) {
        return daoUsuario.pedidosNoEntregados(idUsuario);
    }
    
    public boolean eliminarUsuario(Integer idUsuario) {
        return daoUsuario.eliminarUsuario(idUsuario);
    }
    
    public ArrayList<Producto> ensenarProductos() {
        return daoProducto.ensenarProductos();
    }
    
    public boolean pedidoProducto(Integer cantidadPedida, Integer idProducto, Integer idUsuario) {
        return daoProducto.pedidoProducto(cantidadPedida, idProducto, idUsuario);
    }
    
    public ArrayList<Pedido> pedidosPendientesEntrega(Integer idUsuario) {
        return daoPedido.pedidosPendientesEntrega(idUsuario);
    }
    
    public boolean cancelarPedido(Integer idUsuario, Integer idProducto, Date fecha, Time hora) {
        return daoPedido.cancelarPedido(idUsuario, idProducto, fecha, hora);
    }
    
    public ArrayList<Valoracion> valoracionesClase(String nombreClase) {
        return daoClase.valoracionesClase(nombreClase);
    }

    public ValoracionResumen resumenValoracionesClase(String nombreClase) {
        return daoClase.resumenValoracionesClase(nombreClase);
    }
    
    public Usuario autenticarUsuario(String email, String contrasena) {
        return daoUsuario.autenticarUsuario(email, contrasena);
    }

    public List<Sesion> consultarSesiones(String nombreClase, java.time.LocalDate fechaSesion,
                                        String nombreSala, java.time.LocalTime horaInicio) {
        return daoSesiones.consultarSesiones(nombreClase, fechaSesion, nombreSala, horaInicio);
    }

    public int insertarValoracion(Valoracion valoracion) {
        return daoValoracion.insertarValoracion(valoracion);
    }

    public List<Valoracion> consultarValoracionesPropias(Integer idUsuario) {
        return daoValoracion.consultarValoracionesPropias(idUsuario);
    }

    public Integer modificarValoracion(Valoracion valoracion) {
        return daoValoracion.modificarValoracion(valoracion);
    }

    public Integer eliminarValoracion(Integer idValoracion, Integer idUsuario) {
        return daoValoracion.eliminarValoracion(idValoracion, idUsuario);
    }
}