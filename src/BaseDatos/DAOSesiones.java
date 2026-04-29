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
                id_sesion,
                id_sala,
                nombre_sala,
                nombre_clase,
                duracion,
                fecha_sesion,
                hora_inicio,
                plazas_totales,
                plazas_ocupadas,
                plazas_disponibles,
                porcentaje_ocupacion
            FROM v_sesion_disponibilidad
            WHERE 1 = 1
        """);

        List<Object> parametros = new ArrayList<>();

        if (nombreClase != null && !nombreClase.isBlank()) {
            consulta.append(" AND nombre_clase ILIKE ? ");
            parametros.add("%" + nombreClase.trim() + "%");
        }

        if (fechaSesion != null) {
            consulta.append(" AND fecha_sesion = ? ");
            parametros.add(Date.valueOf(fechaSesion));
        }

        if (nombreSala != null && !nombreSala.isBlank()) {
            consulta.append(" AND nombre_sala = ? ");
            parametros.add(nombreSala.trim());
        }

        if (horaInicio != null) {
            consulta.append(" AND hora_inicio = ? ");
            parametros.add(Time.valueOf(horaInicio));
        }

        consulta.append(
        """
            ORDER BY fecha_sesion, hora_inicio, nombre_clase
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