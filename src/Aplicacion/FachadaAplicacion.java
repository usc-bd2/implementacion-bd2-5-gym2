package Aplicacion;

import BaseDatos.FachadaBaseDatos;
import GUI.FachadaGUI;
import java.util.List;

import javax.swing.SwingUtilities;

public class FachadaAplicacion {
    private FachadaGUI fachadaGUI;
    private FachadaBaseDatos fachadaBD;
    private GestorUsuario gestUsuario;
    private GestorClases gestClases;
    private GestorSesiones gestSesiones;

    public FachadaAplicacion() {
        this.fachadaBD = new FachadaBaseDatos(this);
        this.fachadaGUI = new FachadaGUI(this);
        this.gestUsuario = new GestorUsuario(fachadaBD);
        this.gestClases = new GestorClases(fachadaBD);
        this.gestSesiones = new GestorSesiones(fachadaBD);
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

    public List<Clase> consultarClases(String nombre, Integer duracion, String clasificacion) {
        return gestClases.consultarClases(nombre, duracion, clasificacion);
    }

    public List<Sesion> consultarSesiones(String nombreClase, java.time.LocalDate fechaSesion,
                                        String nombreSala, java.time.LocalTime horaInicio) {
        return gestSesiones.consultarSesiones(nombreClase, fechaSesion, nombreSala, horaInicio);
    }
}