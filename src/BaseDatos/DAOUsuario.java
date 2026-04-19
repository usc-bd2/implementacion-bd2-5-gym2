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
            SELECT id_usuario, nombre, ap1, ap2, email, contrasena, tipo_usuario, fecha_nacimiento
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
                usuario.setContrasena(rs.getString("contrasena"));
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
}