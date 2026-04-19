package Aplicacion;

import BaseDatos.FachadaBaseDatos;


public class GestorUsuario {
    private FachadaBaseDatos fachadaBD;

    public GestorUsuario(FachadaBaseDatos fachadaBD) {
        this.fachadaBD = fachadaBD;
    }
    
    /**
     * Autentica un usuario comprobando sus credenciales.
     * Si la autenticación falla, notifica a la GUI y devuelve null.
     *
     * @return El objeto Usuario autenticado o null si la autenticación falla.
     */
    public Usuario buscarUsuarioPorId(Integer idUsuario) {
        return fachadaBD.buscarUsuarioPorId(idUsuario);
    }
}
