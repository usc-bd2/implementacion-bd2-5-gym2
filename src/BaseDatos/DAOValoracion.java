package BaseDatos;

import Aplicacion.Valoracion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class DAOValoracion extends AbstractDAO {

    public DAOValoracion(Connection conexion) {
        super.setConexion(conexion);
    }

    public int insertarValoracion(Valoracion valoracion) {
        Connection conn = this.getConexion();

        StringBuilder consulta = new StringBuilder(
        """
            INSERT INTO valorar(nombre_clase, id_usuario, opinion, puntuacion)
            VALUES (?, ?, ?, ?)
            RETURNING id_valoracion
        """);

        try (PreparedStatement stm = conn.prepareStatement(consulta.toString())) {
            stm.setString(1, valoracion.consultarNombreClase());
            stm.setInt(2, valoracion.consultarIdUsuario());
            stm.setString(3, valoracion.consultarOpinion());
            stm.setInt(4, valoracion.consultarPuntuacion());

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id_valoracion");
                }
            }

            throw new RuntimeException("La inserción falló, no se obtuvo el ID de la valoración.");

        } catch (SQLException e) {
            throw new RuntimeException("Error al insertar la valoración.", e);
        }
    }

    public List<Valoracion> consultarValoracionesPropias(Integer idUsuario) {
        List<Valoracion> valoraciones = new ArrayList<>();
        Connection conn = this.getConexion();


        StringBuilder consulta = new StringBuilder(
        """
            SELECT id_valoracion, nombre_clase, id_usuario, fecha, opinion, puntuacion
            FROM valorar
            WHERE id_usuario = ?
            ORDER BY fecha DESC, nombre_clase
        """);
    
        try (PreparedStatement stm = conn.prepareStatement(consulta.toString())) {
            stm.setInt(1, idUsuario);

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Valoracion valoracion = new Valoracion();

                    valoracion.modificarIdValoracion(rs.getInt("id_valoracion"));
                    valoracion.modificarNombreClase(rs.getString("nombre_clase"));
                    valoracion.modificarIdUsuario(rs.getInt("id_usuario"));

                    Date fechaSql = rs.getDate("fecha");
                    if (fechaSql != null) {
                        valoracion.modificarFecha(fechaSql.toLocalDate());
                    }
                    valoracion.modificarOpinion(rs.getString("opinion"));
                    valoracion.modificarPuntuacion(rs.getInt("puntuacion"));
                    valoraciones.add(valoracion);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar las valoraciones del usuario: " + e.getMessage(), e);
        }
    return valoraciones;
    }

    public Integer modificarValoracion(Valoracion valoracion) {
        Connection conn = this.getConexion();
        StringBuilder consulta = new StringBuilder(
        """
            UPDATE valorar
            SET opinion = ?,
                puntuacion = ?
            WHERE id_valoracion = ?
            AND id_usuario = ?
        """);

        try (PreparedStatement stm = conn.prepareStatement(consulta.toString())) {
            stm.setString(1, valoracion.consultarOpinion());
            stm.setInt(2, valoracion.consultarPuntuacion());
            stm.setInt(3, valoracion.consultarIdValoracion());
            stm.setInt(4, valoracion.consultarIdUsuario());

            int filasActualizadas = stm.executeUpdate();
            return filasActualizadas;
        } catch (SQLException e) {
            throw new RuntimeException("Error al modificar la valoración: " + e.getMessage(), e);
        }
    }
}