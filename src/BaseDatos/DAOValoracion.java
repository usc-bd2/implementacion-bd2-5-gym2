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
            stm.setString(1, valoracion.getNombreClase());
            stm.setInt(2, valoracion.getIdUsuario());
            stm.setString(3, valoracion.getOpinion());
            stm.setInt(4, valoracion.getPuntuacion());

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

                    valoracion.setIdValoracion(rs.getInt("id_valoracion"));
                    valoracion.setNombreClase(rs.getString("nombre_clase"));
                    valoracion.setIdUsuario(rs.getInt("id_usuario"));

                    Date fechaSql = rs.getDate("fecha");
                    if (fechaSql != null) {
                        valoracion.setFecha(fechaSql.toLocalDate());
                    }
                    valoracion.setOpinion(rs.getString("opinion"));
                    valoracion.setPuntuacion(rs.getInt("puntuacion"));
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
            stm.setString(1, valoracion.getOpinion());
            stm.setInt(2, valoracion.getPuntuacion());
            stm.setInt(3, valoracion.getIdValoracion());
            stm.setInt(4, valoracion.getIdUsuario());

            int filasActualizadas = stm.executeUpdate();
            return filasActualizadas;
        } catch (SQLException e) {
            throw new RuntimeException("Error al modificar la valoración: " + e.getMessage(), e);
        }
    }

    public Integer eliminarValoracion(Integer idValoracion, Integer idUsuario) {
        Connection conn = this.getConexion();

        StringBuilder consulta = new StringBuilder(
        """
            DELETE FROM valorar
            WHERE id_valoracion = ?
            AND id_usuario = ?
        """);

        try (PreparedStatement stm = conn.prepareStatement(consulta.toString())) {
            stm.setInt(1, idValoracion);
            stm.setInt(2, idUsuario);

            int filasEliminadas = stm.executeUpdate();

            return filasEliminadas;

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar la valoración: " + e.getMessage(), e);
        }
    }
}