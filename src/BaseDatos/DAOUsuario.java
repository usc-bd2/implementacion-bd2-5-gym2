package BaseDatos;

import Aplicacion.Usuario;
import java.sql.*;


public class DAOUsuario extends AbstractDAO {

    public DAOUsuario(Connection conexion) {
        super.setConexion(conexion);
    }

    public Usuario buscarPorId(Integer idUsuario) {
        Connection conn = this.getConexion();

        String consulta = 
            """
            SELECT id_usuario, nombre, ap1, ap2, email, contraseña, tipo_usuario, fecha_nacimiento
            FROM Usuario 
            WHERE id_usuario = ?                    
            """;

        try (PreparedStatement stm = conn.prepareStatement(consulta)) {
            stm.setInt(1, idUsuario); //rellenar el ?

            try (ResultSet rs = stm.executeQuery()) {
                if (!rs.next()) { //si no encuentra nada devuelve null
                    return null;
                }

                Usuario usuario = new Usuario();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setAp1(rs.getString("ap1"));
                usuario.setAp2(rs.getString("ap2"));
                usuario.setEmail(rs.getString("email"));
                usuario.setContrasena(rs.getString("contraseña"));
                usuario.setTipoUsuario(rs.getString("tipo_usuario"));

                Date fechaSql = rs.getDate("fecha_nacimiento");
                if (fechaSql != null) {
                    usuario.setFechaNacimiento(fechaSql.toLocalDate());
                }
                return usuario;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al buscar usuario con id " + idUsuario, e);
        }
    }
    
    public boolean existeIdUsuario(Integer idUsuario) {
        return buscarPorId(idUsuario) != null;
    }
    
    public boolean existeEmail(String emailUsuario) {
        Connection conn = this.getConexion();
        
        String consulta =
            """
            SELECT email
            FROM Usuario
            WHERE email = ?
            """;
        
        try (PreparedStatement stm = conn.prepareStatement(consulta)) {
            stm.setString(1, emailUsuario);

            try(ResultSet rs = stm.executeQuery()) {
                return rs.next(); //porq si encuentra una fila esq existe el email, si no es q no existe
            }

        } catch(SQLException e) {
           throw new RuntimeException("Error al comprobar si existe el email del usuario.");
        } 
    }
    
    public boolean insertarUsuario(Usuario u) {
        Connection conn = this.getConexion();
        
        String consulta =
            """
            INSERT INTO usuario(id_usuario, nombre, ap1, ap2, email, contraseña, tipo_usuario, fecha_nacimiento)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?)
            """;
        
        try (PreparedStatement stm = conn.prepareStatement(consulta)) {
            stm.setInt(1, u.getIdUsuario());
            stm.setString(2, u.getNombre());
            stm.setString(3, u.getAp1());
            stm.setString(4, u.getAp2());
            stm.setString(5, u.getEmail());
            stm.setString(6, u.getContrasena());
            stm.setString(7, u.getTipoUsuario());
            stm.setDate(8, Date.valueOf(u.getFechaNacimiento())); //porq fecha nacimiento devuelve local date hay q transformarlo
            
            stm.executeUpdate();
            
            return true;
            
        } catch(SQLException e) {
           throw new RuntimeException("Error al añadir al usuario.", e);
        }      
    }
    
     public boolean modificarDatos(Usuario u) {
        Connection conn = this.getConexion();
        
        String consulta =
            """
            UPDATE Usuario
            SET nombre = ?, ap1 = ?, ap2 = ?, email = ?, contraseña = ?, fecha_nacimiento = ?
            WHERE id_usuario = ?
            """;
        
        try (PreparedStatement stm = conn.prepareStatement(consulta)) {
            stm.setString(1, u.getNombre());
            stm.setString(2, u.getAp1());
            stm.setString(3, u.getAp2());
            stm.setString(4, u.getEmail());
            stm.setString(5, u.getContrasena());
            stm.setDate(6, Date.valueOf(u.getFechaNacimiento())); //porq fecha nacimiento devuelve local date hay q transformarlo
            stm.setInt(7, u.getIdUsuario());
      
            int filas = stm.executeUpdate();
            return filas == 1; //devuelve true si se modificó alguna fila
            
        } catch(SQLException e) {
           throw new RuntimeException("Error al modificar los datos del usuario.", e);
        }      
    }
     
     public boolean existeReserva(Integer idUsuario) {
        Connection conn = this.getConexion();
        
        String consulta =
            """
            SELECT 1
            FROM reserva
            WHERE id_usuario = ?
            """;
        
        try (PreparedStatement stm = conn.prepareStatement(consulta)) {
            stm.setInt(1, idUsuario);

            try (ResultSet rs = stm.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al comprobar reservas activas.", e);
        }
    }
     
     public boolean pedidosNoEntregados(Integer idUsuario) {
        Connection conn = this.getConexion();
         
        String consulta =
            """
            SELECT 1
            FROM pedir_producto
            WHERE id_usuario = ?
            AND entregado = false
            """;
        try (PreparedStatement stm = conn.prepareStatement(consulta)) {
            stm.setInt(1, idUsuario);

            try (ResultSet rs = stm.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al comprobar pedidos no entregados.", e);
        }
     }
     
    public boolean eliminarUsuario(Integer idUsuario) {
        Connection conn = this.getConexion();

        String consulta =
           """
           DELETE FROM usuario
           WHERE id_usuario = ?
           """;

        try (PreparedStatement stm = conn.prepareStatement(consulta)) {

           stm.setInt(1, idUsuario);

           int filas = stm.executeUpdate();

           return filas == 1;

        } catch (SQLException e) {
           throw new RuntimeException("Error al eliminar el usuario.", e);
        }
    }
    
    public Usuario autenticarUsuario(String email, String contrasena) { //t1
        Connection conn = this.getConexion();

        String consulta =
            """
            SELECT id_usuario, nombre, ap1, ap2, email, contraseña, tipo_usuario, fecha_nacimiento
            FROM Usuario
            WHERE email = ?
            AND contraseña = ?
            """;

        try (PreparedStatement stm = conn.prepareStatement(consulta)) {
            stm.setString(1, email);
            stm.setString(2, contrasena);

            try (ResultSet rs = stm.executeQuery()) {
                if (!rs.next()) {
                    return null;
                }

                Usuario u = new Usuario();
                u.setIdUsuario(rs.getInt("id_usuario"));
                u.setNombre(rs.getString("nombre"));
                u.setAp1(rs.getString("ap1"));
                u.setAp2(rs.getString("ap2"));
                u.setEmail(rs.getString("email"));
                u.setContrasena(rs.getString("contraseña"));
                u.setTipoUsuario(rs.getString("tipo_usuario"));

                Date fechaSql = rs.getDate("fecha_nacimiento");
                if (fechaSql != null) {
                    u.setFechaNacimiento(fechaSql.toLocalDate());
                }

                return u;
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al autenticar usuario.", e);
        }
    }
}

   