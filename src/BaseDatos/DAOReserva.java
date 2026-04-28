package BaseDatos;

import Aplicacion.Reserva;
import java.sql.*;


public class DAOReserva extends AbstractDAO {

    public DAOReserva(Connection conexion) {
        super.setConexion(conexion);
    }

    public Integer registrarReserva(Reserva reserva) {
        Connection conn = this.getConexion();
        
        String procedimiento = "CALL pr_registrar_reserva(?, ?, ?)";

        Integer aislamientoOriginal = null;
        boolean autoCommitOriginal = true;

        try {
            autoCommitOriginal = conn.getAutoCommit();
            aislamientoOriginal = conn.getTransactionIsolation();

            // Configurar transacción explícita
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            Integer idReserva;

            try (CallableStatement cs = conn.prepareCall(procedimiento)) {
                cs.setInt(1, reserva.getIdUsuario());
                cs.setInt(2, reserva.getIdSesion());
                cs.setNull(3, Types.INTEGER);
                cs.registerOutParameter(3, Types.INTEGER);

                cs.execute();
                idReserva = cs.getInt(3);
            }

            conn.commit();
            return idReserva;

        } catch (SQLException e) {
            rollback(conn);
            throw new RuntimeException(e.getMessage(), e);

        } finally {
            try {
                conn.setTransactionIsolation(aislamientoOriginal);
                conn.setAutoCommit(autoCommitOriginal);
            } catch (SQLException ignored) {}
        }
    }

    private void rollback(Connection conn) {
        try {
            conn.rollback();
        } catch (SQLException ignored) {}
    }
}