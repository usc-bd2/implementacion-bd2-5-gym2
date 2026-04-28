package BaseDatos;

import Aplicacion.Valoracion;
import java.sql.*;


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
}