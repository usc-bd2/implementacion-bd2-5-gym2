/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

import Aplicacion.Valoracion;
import Aplicacion.ValoracionResumen;
import java.sql.*;
import java.util.ArrayList;

public class DAOClase extends AbstractDAO {

    public DAOClase(Connection conexion) {
        super.setConexion(conexion);
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