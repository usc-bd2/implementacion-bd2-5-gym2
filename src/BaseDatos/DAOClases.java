package BaseDatos;

import Aplicacion.Clase;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOClases extends AbstractDAO {

    public DAOClases(Connection conexion) {
        super.setConexion(conexion);
    }

    public List<Clase> consultarClases(String nombre, Integer duracion, String clasificacion) {
        List<Clase> resultado = new ArrayList<>();
        Connection conn = this.getConexion();

        StringBuilder consulta = new StringBuilder(
        """
            SELECT nombre, duracion, clasificacion, 0.0 AS puntuacionMedia -- TODO: calcular la puntuación media real
            FROM clase
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

        consulta.append(" ORDER BY nombre ");

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
                    clase.setPuntuacionMedia(rs.getDouble("puntuacionMedia"));

                    resultado.add(clase);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al consultar clases.", e);
        }

        return resultado;
    }
}