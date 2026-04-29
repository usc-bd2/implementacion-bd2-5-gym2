package BaseDatos;

import Aplicacion.Clase;
import Aplicacion.Valoracion;
import Aplicacion.ValoracionResumen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOClase extends AbstractDAO {

    public DAOClase(Connection conexion) {
        super.setConexion(conexion);
    }

    public List<Clase> consultarClases(String nombre, Integer duracion, String clasificacion) {
        List<Clase> resultado = new ArrayList<>();
        Connection conn = this.getConexion();

        StringBuilder consulta = new StringBuilder(
        """
            SELECT c.nombre,
                c.duracion,
                c.clasificacion,
                COALESCE(ROUND(AVG(v.puntuacion), 2), 0) AS puntuacion_media
            FROM clase c
            LEFT JOIN valorar v
                ON v.nombre_clase = c.nombre
            WHERE 1 = 1
        """);

        List<Object> parametros = new ArrayList<>();

        if (nombre != null && !nombre.isBlank()) {
            consulta.append(" AND nombre ILIKE ? ");
            parametros.add("%" + nombre.trim() + "%");
        }

        if (duracion != null) {
            consulta.append(" AND duracion = ? ");
            parametros.add(duracion);
        }

        if (clasificacion != null && !clasificacion.isBlank()) {
            consulta.append(" AND clasificacion = ? ");
            parametros.add(clasificacion.trim());
        }

        consulta.append(
        """
            GROUP BY c.nombre, c.duracion, c.clasificacion
            ORDER BY c.nombre
        """);

        try (PreparedStatement stm = conn.prepareStatement(consulta.toString())) {

            for (int i = 0; i < parametros.size(); i++) {
                stm.setObject(i + 1, parametros.get(i));
            }

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Clase clase = new Clase();
                    clase.setNombre(rs.getString("nombre"));
                    clase.setDuracion(rs.getInt("duracion"));
                    clase.setClasificacion(rs.getString("clasificacion"));
                    clase.setPuntuacionMedia(rs.getDouble("puntuacion_media"));

                    resultado.add(clase);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar clases.", e);
        }

        return resultado;
    }

    public ArrayList<Valoracion> valoracionesClase(String nombreClase) { //t17
        Connection conn = this.getConexion();

        String consulta =
            """
            SELECT opinion, puntuacion
            FROM valorar
            WHERE nombre_clase = ?
            """;

        ArrayList<Valoracion> valoraciones = new ArrayList<>();

        try (PreparedStatement stm = conn.prepareStatement(consulta)) {
            stm.setString(1, nombreClase);

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Valoracion v = new Valoracion();

                    v.setOpinion(rs.getString("opinion"));
                    v.setPuntuacion(rs.getInt("puntuacion"));

                    valoraciones.add(v);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener las valoraciones de la clase.", e);
        }

        return valoraciones;
    }

    public ValoracionResumen resumenValoracionesClase(String nombreClase) {
        Connection conn = this.getConexion();

        String consulta =
            """
            SELECT COUNT(*) AS numero_valoraciones,
                   COALESCE(AVG(puntuacion), 0) AS media_puntuacion
            FROM valorar
            WHERE nombre_clase = ?
            """;

        ValoracionResumen resumen = new ValoracionResumen();

        try (PreparedStatement stm = conn.prepareStatement(consulta)) {
            stm.setString(1, nombreClase);

            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    resumen.setNumeroValoraciones(rs.getInt("numero_valoraciones"));
                    resumen.setMediaPuntuacion(rs.getDouble("media_puntuacion"));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener el resumen de valoraciones.", e);
        }

        return resumen;
    }

}