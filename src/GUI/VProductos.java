package GUI;

import Aplicacion.FachadaAplicacion;
import Aplicacion.Producto;
import Aplicacion.Pedido;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VProductos extends javax.swing.JPanel {
    
    private FachadaAplicacion fa;
    
    public VProductos(FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();
        cargarProductos();
    }
    
    private void cargarProductos() {
        try {
            ArrayList<Producto> productos = fa.ensenarProductos();

            DefaultTableModel modelo = (DefaultTableModel) tablaProductos.getModel();
            modelo.setRowCount(0);

            for (Producto p : productos) {
                modelo.addRow(new Object[]{
                    p.getIdProducto(),
                    p.getNombre(),
                    p.getDescripcion(),
                    p.getPrecio(),
                    p.getStock()
                });
            }

        } catch (Exception e) {
            fa.muestraExcepcion("Error al cargar productos: " + e.getMessage());
        }
    }
    
    private void cargarPedidosActivos() {
        try {
            int idUsuario = Integer.parseInt(txtIdUsuario.getText().trim());

            ArrayList<Pedido> pedidos = fa.pedidosPendientesEntrega(idUsuario);
            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);

            for (Pedido p : pedidos) {
                modelo.addRow(new Object[]{
                    p.getIdProducto(),
                    p.getNombre(),
                    p.getFecha(),
                    p.getHora(),
                    p.getCantidad(),
                    p.getEntregado()
                });
            }

        } catch (NumberFormatException e) {
            fa.muestraExcepcion("El ID de usuario debe ser un número.");
        } catch (Exception e) {
            fa.muestraExcepcion("Error al cargar pedidos activos: " + e.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCantidad = new javax.swing.JTextField();
        txtIdProducto = new javax.swing.JTextField();
        txtIdUsuario = new javax.swing.JTextField();
        btnPedir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        lblProductos = new java.awt.Label();
        lblPedidos = new java.awt.Label();
        btnConsultarPedidos = new java.awt.Button();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnCancelarPedido = new java.awt.Button();

        txtCantidad.setPreferredSize(new java.awt.Dimension(90, 30));

        txtIdProducto.setPreferredSize(new java.awt.Dimension(90, 30));

        txtIdUsuario.setPreferredSize(new java.awt.Dimension(90, 30));

        btnPedir.setText("Pedir");
        btnPedir.addActionListener(this::btnPedirActionPerformed);

        jLabel1.setText("Id Usuario");

        jLabel2.setText("Id Producto");

        jLabel3.setText("Cantidad");

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripcion", "Precio", "Stock"
            }
        ));
        jScrollPane1.setViewportView(tablaProductos);

        lblProductos.setText("Productos disponibles");

        lblPedidos.setText("Pedidos activos");

        btnConsultarPedidos.setLabel("Consultar pedidos");
        btnConsultarPedidos.addActionListener(this::btnConsultarPedidosActionPerformed);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Producto", "Producto", "Fecha", "Hora", "Cantidad", "Entregado"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        btnCancelarPedido.setLabel("Cancelar pedido");
        btnCancelarPedido.addActionListener(this::btnCancelarPedidoActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(jLabel2)
                                .addGap(136, 136, 136)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(364, 364, 364)
                                .addComponent(lblPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(112, 112, 112)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(187, 187, 187)
                                .addComponent(btnPedir))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConsultarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnPedir)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedirActionPerformed
        try {
            int idUsuario = Integer.parseInt(txtIdUsuario.getText().trim());
            int idProducto = Integer.parseInt(txtIdProducto.getText().trim());
            int cantidad = Integer.parseInt(txtCantidad.getText().trim());

            boolean ok = fa.pedidoProducto(cantidad, idProducto, idUsuario);

            if (ok) {
                javax.swing.JOptionPane.showMessageDialog(this, "Pedido realizado correctamente.");
                cargarProductos();
                cargarPedidosActivos();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo realizar el pedido. Revisa el stock o los datos.");
            }

        } catch (NumberFormatException e) {
            fa.muestraExcepcion("El ID de usuario, ID de producto y cantidad deben ser números.");
        } catch (Exception e) {
            fa.muestraExcepcion("Error al realizar el pedido: " + e.getMessage());
        }
    }//GEN-LAST:event_btnPedirActionPerformed

    private void btnConsultarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarPedidosActionPerformed
        cargarPedidosActivos();       
    }//GEN-LAST:event_btnConsultarPedidosActionPerformed

    private void btnCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPedidoActionPerformed
        try {
            int fila = jTable1.getSelectedRow();

            if (fila == -1) {
                fa.muestraExcepcion("Selecciona un pedido en la tabla.");
                return;
            }

            int idUsuario = Integer.parseInt(txtIdUsuario.getText().trim());
            int idProducto = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());
            Date fecha = Date.valueOf(jTable1.getValueAt(fila, 2).toString());
            Time hora = Time.valueOf(jTable1.getValueAt(fila, 3).toString());

            boolean ok = fa.cancelarPedido(idUsuario, idProducto, fecha, hora);

            if (ok) {
                javax.swing.JOptionPane.showMessageDialog(this, "Pedido cancelado correctamente.");
                cargarProductos();
                cargarPedidosActivos();
            } else {
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo cancelar el pedido.");
            }

        } catch (NumberFormatException e) {
            fa.muestraExcepcion("El ID de usuario debe ser un número.");
        } catch (Exception e) {
            fa.muestraExcepcion("Error al cancelar pedido: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCancelarPedidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnCancelarPedido;
    private java.awt.Button btnConsultarPedidos;
    private javax.swing.JButton btnPedir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private java.awt.Label lblPedidos;
    private java.awt.Label lblProductos;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIdProducto;
    private javax.swing.JTextField txtIdUsuario;
    // End of variables declaration//GEN-END:variables
}
