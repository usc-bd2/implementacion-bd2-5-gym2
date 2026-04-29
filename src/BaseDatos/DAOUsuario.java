package BaseDatos;

import Aplicacion.Usuario;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DAOUsuario extends AbstractDAO {

    public DAOUsuario(Connection conexion) {
        super.setConexion(conexion);
    }

    private String hashContrasena(String contrasena) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(contrasena.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error al cifrar la contraseña.", e);
        }
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
            stm.setInt(1, idUsuario);

            try (ResultSet rs = stm.executeQuery()) {
                if (!rs.next()) {
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

            try (ResultSet rs = stm.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al comprobar si existe el email del usuario.");
        }
    }

    public boolean insertarUsuario(Usuario u) {
        Connection conn = this.getConexion();

        String consulta =
            """
            INSERT INTO usuario(nombre, ap1, ap2, email, contraseña, tipo_usuario, fecha_nacimiento)
            VALUES (?, ?, ?, ?, ?, ?, ?)
            """;

        try (PreparedStatement stm = conn.prepareStatement(consulta)) {

            stm.setString(1, u.getNombre());
            stm.setString(2, u.getAp1());
            stm.setString(3, u.getAp2());
            stm.setString(4, u.getEmail());

            String hash = hashContrasena(u.getContrasena());
            stm.setString(5, hash);

            stm.setString(6, u.getTipoUsuario());
            stm.setDate(7, Date.valueOf(u.getFechaNacimiento()));

            stm.executeUpdate();
            return true;

        } catch (SQLException e) {
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

            String hash = hashContrasena(u.getContrasena());
            stm.setString(5, hash);

            stm.setDate(6, Date.valueOf(u.getFechaNacimiento()));
            stm.setInt(7, u.getIdUsuario());

            int filas = stm.executeUpdate();
            return filas == 1;

        } catch (SQLException e) {
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

    public Usuario autenticarUsuario(String email, String contrasena) {
        Connection conn = this.getConexion();

        String consulta =
            """
            SELECT id_usuario, nombre, ap1, ap2, email, contrasena, tipo_usuario, fecha_nacimiento
            FROM Usuario
            WHERE email = ?
            AND contrasena = ?
            """;

        try (PreparedStatement stm = conn.prepareStatement(consulta)) {
            stm.setString(1, email);
            stm.setString(2, hashContrasena(contrasena));

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
                u.setContrasena(rs.getString("contrasena"));
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