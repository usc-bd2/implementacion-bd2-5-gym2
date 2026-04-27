package GUI;

import Aplicacion.FachadaAplicacion;
import Aplicacion.Usuario;

public class VTestUsuario extends javax.swing.JPanel {
    
    private FachadaAplicacion fa;

    public VTestUsuario(FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtId = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lblNombre = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();

        txtId.setText("Buscar usuario por ID");
        txtId.addActionListener(this::txtIdActionPerformed);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        lblNombre.setText("Nombre:");

        lblEmail.setText("Correo electronico:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombre)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 297, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(lblNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmail)
                .addContainerGap(351, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {
        // No hace falta poner nada aquí
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            // 1. Validar y recoger la entrada del usuario
            String idTexto = txtId.getText().trim();
            if (idTexto.isEmpty()) {
                fa.muestraExcepcion("El campo ID no puede estar vacío.");
                return;
            }
            
            Integer id = Integer.parseInt(idTexto);
            
            // 2. Solicitar el usuario a través del flujo de capas
            Usuario u = fa.buscarUsuarioPorId(id);
            
            // 3. Actualizar la interfaz con los datos de la entidad
            if (u != null) {
                lblNombre.setText("Nombre: " + u.getNombre() + " " + u.getAp1());
                lblEmail.setText("Email: " + u.getEmail());
            } else {
                lblNombre.setText("Usuario no encontrado.");
                lblEmail.setText("");
                fa.muestraExcepcion("No existe un usuario con ID: " + id);
            }
            
        } catch (NumberFormatException e) {
            fa.muestraExcepcion("Error: El ID debe ser un número entero.");
        } catch (Exception e) {
            fa.muestraExcepcion("Error inesperado: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
