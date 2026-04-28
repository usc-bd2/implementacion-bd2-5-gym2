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
     * @param idUsuario
     * @return El objeto Usuario autenticado o null si la autenticación falla.
     */
    public Usuario buscarUsuarioPorId(Integer idUsuario) {
        return fachadaBD.buscarUsuarioPorId(idUsuario);
    }

    public String registrarUsuario(Usuario u) { //t2
        //NO COMPROBAMOS ID, LO GENERA LA BD
        if (fachadaBD.existeEmail(u.getEmail())) {
            return "Este email ya está registrado.";
        }

        fachadaBD.insertarUsuario(u);
        return "Usuario registrado correctamente.";
    }
    
    public String modificarDatos(Usuario u) { //t3
        if(fachadaBD.modificarDatos(u)) {
            return "Datos modificados correctamente.";
        } else {
            return "No se ha podido modificar los datos";
        }
    }
    
    public String eliminarUsuario(Usuario u) { //t4
        if(fachadaBD.existeReserva(u.getIdUsuario())){
            return "Existen reservas activas por lo que no se puede eliminar el usuario.";
        }
        
        if(fachadaBD.pedidosNoEntregados(u.getIdUsuario())) {
            return "Existen pedidos no entregados por lo que no se puede eliminar el usuario.";
        }
       

        if (fachadaBD.eliminarUsuario(u.getIdUsuario())) {
            return "Usuario eliminado correctamente.";
        } else {
            return "No se pudo eliminar el usuario.";
        }
    }
    
    public Usuario autenticarUsuario(String email, String contrasena) {
        if (email == null || email.isBlank() || contrasena == null || contrasena.isBlank()) {
            return null;
        }

        return fachadaBD.autenticarUsuario(email, contrasena);
    }
}
