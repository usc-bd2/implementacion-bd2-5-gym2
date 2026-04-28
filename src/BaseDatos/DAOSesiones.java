package BaseDatos;

import Aplicacion.Sesion;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DAOSesiones extends AbstractDAO {

    public DAOSesiones(Connection conexion) {
        super.setConexion(conexion);
    }

    public List<Sesion> consultarSesiones(String nombreClase, LocalDate fechaSesion,
                                        String nombreSala, LocalTime horaInicio) {
        List<Sesion> resultado = new ArrayList<>();
        Connection conn = this.getConexion();

        StringBuilder consulta = new StringBuilder(
        """
            SELECT
                s.id_sesion,
                s.id_sala,
                sa.nombre AS nombre_sala,
                s.nombre_clase,
                s.fecha_sesion,
                s.hora_inicio,
                COUNT(DISTINCT p.id_plaza) AS plazas_totales,
                COUNT(DISTINCT rp.id_plaza) AS plazas_ocupadas,
                COUNT(DISTINCT p.id_plaza) - COUNT(DISTINCT rp.id_plaza) AS plazas_disponibles,
                COALESCE(
                    ROUND(
                        (COUNT(DISTINCT rp.id_plaza)::numeric * 100)
                        / NULLIF(COUNT(DISTINCT p.id_plaza), 0),
                        2
                    ),
                    0.00
                ) AS porcentaje_ocupacion
            FROM sesion s
            JOIN sala sa
                ON s.id_sala = sa.id_sala
            LEFT JOIN plaza p
                ON p.id_sala = s.id_sala
            LEFT JOIN reserva_plaza rp
                ON rp.id_sesion = s.id_sesion
                AND rp.id_sala = p.id_sala
                AND rp.id_plaza = p.id_plaza
            LEFT JOIN reserva r
                ON r.id_reserva = rp.id_reserva
                AND r.id_sesion = s.id_sesion
            WHERE 1 = 1
        """);

        List<Object> parametros = new ArrayList<>();

        if (nombreClase != null && !nombreClase.isBlank()) {
            consulta.append(" AND s.nombre_clase ILIKE ? ");
            parametros.add("%" + nombreClase.trim() + "%");
        }

        if (fechaSesion != null) {
            consulta.append(" AND s.fecha_sesion = ? ");
            parametros.add(Date.valueOf(fechaSesion));
        }

        if (nombreSala != null && !nombreSala.isBlank()) {
            consulta.append(" AND sa.nombre = ? ");
            parametros.add(nombreSala.trim());
        }

        if (horaInicio != null) {
            consulta.append(" AND s.hora_inicio = ? ");
            parametros.add(Time.valueOf(horaInicio));
        }

        consulta.append(
        """
            GROUP BY
                s.id_sesion,
                s.id_sala,
                sa.nombre,
                s.nombre_clase,
                s.fecha_sesion,
                s.hora_inicio
            ORDER BY s.fecha_sesion, s.hora_inicio, s.nombre_clase
        """);

        try (PreparedStatement stm = conn.prepareStatement(consulta.toString())) {

            for (int i = 0; i < parametros.size(); i++) {
                stm.setObject(i + 1, parametros.get(i));
            }

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Sesion sesion = mapearSesion(rs);
                    resultado.add(sesion);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar sesiones.", e);
        }

        return resultado;
    }

    private Sesion mapearSesion(ResultSet rs) throws SQLException {
        Sesion sesion = new Sesion();

        sesion.setIdSesion(rs.getInt("id_sesion"));
        sesion.setIdSala(rs.getInt("id_sala"));
        sesion.setNombreSala(rs.getString("nombre_sala"));
        sesion.setNombreClase(rs.getString("nombre_clase"));

        Date fecha = rs.getDate("fecha_sesion");
        if (fecha != null) {
            sesion.setFechaSesion(fecha.toLocalDate());
        }

        Time hora = rs.getTime("hora_inicio");
        if (hora != null) {
            sesion.setHoraInicio(hora.toLocalTime());
        }

        sesion.setPlazasTotales(rs.getInt("plazas_totales"));
        sesion.setPlazasOcupadas(rs.getInt("plazas_ocupadas"));
        sesion.setPlazasDisponibles(rs.getInt("plazas_disponibles"));
        sesion.setPorcentajeOcupacion(rs.getDouble("porcentaje_ocupacion"));

        return sesion;
    }
}