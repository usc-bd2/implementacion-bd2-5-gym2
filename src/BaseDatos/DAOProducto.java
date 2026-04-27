/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BaseDatos;

import Aplicacion.Producto;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author maria
 */
public class DAOProducto extends AbstractDAO { 
    public DAOProducto(Connection conexion) { //conexion con la bd
        super.setConexion(conexion);
    }
    
    public ArrayList<Producto> ensenarProductos() {
        Connection conn = this.getConexion();

        String consulta = 
            """
            SELECT id_producto, nombre, descripcion, precio, stock_disponible
            FROM producto
            ORDER BY nombre
            """;
        
        ArrayList<Producto> productos = new ArrayList<>();
        
        try(PreparedStatement stm = conn.prepareStatement(consulta); 
            ResultSet rs = stm.executeQuery()) {  //bd preparame esta consulta
                while(rs.next()) {
                    Producto p = new Producto();
                    p.setIdProducto(rs.getInt("id_producto"));
                    p.setNombre(rs.getString("nombre"));
                    p.setDescripcion(rs.getString("descripcion"));
                    p.setPrecio(rs.getFloat("precio"));
                    p.setStock(rs.getInt("stock_disponible"));
                    
                    productos.add(p);
                }        
            } catch (SQLException e) {
                throw new RuntimeException("Error al obtener los productos.", e);
        } return productos;
    }  
    
    public boolean pedidoProducto(Integer cantidadPedida, Integer idProducto, Integer idUsuario) {
        Connection conn = this.getConexion();
        
        String consulta = 
            """
            SELECT stock_disponible
            FROM producto
            WHERE id_producto = ?
            FOR UPDATE
            """;
        
        try (PreparedStatement stm = conn.prepareStatement(consulta)) {
            conn.setAutoCommit(false); //no guardes nada automaticamente, lo hago yo al final, por si hay algún error por el medio para que no la guarde a medias¡
            stm.setInt(1, idProducto); //rellenar el ?
            
            ResultSet rs = stm.executeQuery();
            
            if(cantidadPedida <= 0) {
                conn.rollback();
                return false;
            }
            
            if(rs.next()) {
                int stockDisponible = rs.getInt("stock_disponible");
                
                if(cantidadPedida <= stockDisponible) {
                    String consultaPedido =
                        """
                        INSERT INTO pedir_producto(id_usuario, id_producto, fecha, hora, cantidad, entregado)
                        VALUES(?, ?, CURRENT_DATE, CURRENT_TIME, ?, ?)
                        """;
                    
                    PreparedStatement stmInsert = conn.prepareStatement(consultaPedido);
                    stmInsert.setInt(1, idUsuario);
                    stmInsert.setInt(2, idProducto);
                    stmInsert.setInt(3, cantidadPedida);
                    stmInsert.setBoolean(4, false); //entregado
                    
                    stmInsert.executeUpdate();
                    
                    String consultaUpdate = 
                        """
                        UPDATE producto
                        SET stock_disponible = stock_disponible - ?
                        WHERE id_producto = ?
                        """;
                    
                    PreparedStatement stmUpdate = conn.prepareStatement(consultaUpdate);
                    stmUpdate.setInt(1, cantidadPedida);
                    stmUpdate.setInt(2, idProducto);
                   
                    stmUpdate.executeUpdate();
                    
                    conn.commit(); //guardar los cambios
                    return true;
                } else {
                    conn.rollback(); //no guardar nada
                    return false;
                }
            } else {
                conn.rollback();
                return false;
            }
            
        } catch(SQLException e) {
            try {
                conn.rollback(); //tiene q ir en un try-catch porq puede dar error el rollback y si no tiene un catch nadie coge ese error
            } catch(SQLException ex) {
                throw new RuntimeException("Error haciendo rollback", ex);
            } throw new RuntimeException("Error al pedir el producto con id " + idProducto, e);
        } 
    }
}

