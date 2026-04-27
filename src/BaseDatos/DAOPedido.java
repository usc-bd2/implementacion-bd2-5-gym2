/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

import Aplicacion.Pedido;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class DAOPedido extends AbstractDAO {
    public DAOPedido(Connection conexion) { //conexion con la bd
        super.setConexion(conexion);
    }

    public ArrayList<Pedido> pedidosPendientesEntrega(Integer idUsuario) {
        Connection conn = this.getConexion();

        String consulta =
            """
            SELECT pp.id_producto, p.nombre, pp.fecha, pp.hora, pp.cantidad, pp.entregado
            FROM pedir_producto pp
            JOIN producto p ON pp.id_producto = p.id_producto
            WHERE pp.id_usuario = ?
            AND pp.entregado = false
            """;

        ArrayList<Pedido> pedidos = new ArrayList<>();

        try (PreparedStatement stm = conn.prepareStatement(consulta)) {
            stm.setInt(1, idUsuario);

            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    Pedido p = new Pedido();

                    p.setIdProducto(rs.getInt("id_producto"));
                    p.setNombre(rs.getString("nombre"));
                    p.setFecha(rs.getDate("fecha"));
                    p.setHora(rs.getTime("hora"));
                    p.setCantidad(rs.getInt("cantidad"));
                    p.setEntregado(rs.getBoolean("entregado"));

                    pedidos.add(p);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener los pedidos.", e);
        }

        return pedidos;
    }
    
    public boolean cancelarPedido(Integer idUsuario, Integer idProducto, Date fecha, Time hora) {
        Connection conn = this.getConexion();

        String consultaPedido =
            """
            SELECT ctid, cantidad, entregado
            FROM pedir_producto
            WHERE id_usuario = ?
            AND id_producto = ?
            AND fecha = ?
            AND entregado = false
            LIMIT 1
            FOR UPDATE
            """;

        try {
            conn.setAutoCommit(false);

            String ctidPedido;
            int cantidad;

            try (PreparedStatement stm = conn.prepareStatement(consultaPedido)) {
                stm.setInt(1, idUsuario);
                stm.setInt(2, idProducto);
                stm.setDate(3, fecha);

                try (ResultSet rs = stm.executeQuery()) {
                    if (!rs.next()) {
                        conn.rollback();
                        return false;
                    }

                    ctidPedido = rs.getString("ctid");
                    cantidad = rs.getInt("cantidad");
                }
            }

            String borrarPedido =
                """
                DELETE FROM pedir_producto
                WHERE ctid = ?::tid
                """;

            try (PreparedStatement stmDelete = conn.prepareStatement(borrarPedido)) {
                stmDelete.setString(1, ctidPedido);
                stmDelete.executeUpdate();
            }

            String reponerStock =
                """
                UPDATE producto
                SET stock_disponible = stock_disponible + ?
                WHERE id_producto = ?
                """;

            try (PreparedStatement stmUpdate = conn.prepareStatement(reponerStock)) {
                stmUpdate.setInt(1, cantidad);
                stmUpdate.setInt(2, idProducto);
                stmUpdate.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException("Error haciendo rollback al cancelar pedido.", ex);
            }

            throw new RuntimeException("Error al cancelar el pedido.", e);

        } finally {
            try {
                conn.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException("Error restaurando autocommit.", e);
            }
        }
    }
}