package Aplicacion;

import BaseDatos.FachadaBaseDatos;
import GUI.FachadaGUI;

public class FachadaAplicacion {
    private final FachadaGUI fachadaGUI;
    private final FachadaBaseDatos fachadaBD;
    private final GestorUsuario gestUsuario;

    public FachadaAplicacion() {
        this.fachadaBD = new FachadaBaseDatos(this);
        this.fachadaGUI = new FachadaGUI(this);
        this.gestUsuario = new GestorUsuario(fachadaBD);
    }

    public static void main(String[] args) {
        try {
            FachadaAplicacion fachadaAp = new FachadaAplicacion();
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
}