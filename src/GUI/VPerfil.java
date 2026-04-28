package GUI;

import Aplicacion.FachadaAplicacion;
import Aplicacion.Usuario;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class VPerfil extends javax.swing.JPanel {
    
    private FachadaAplicacion fa;

    public VPerfil(FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBuscarUsuario1 = new javax.swing.JButton();
        lblIdUsuario = new java.awt.Label();
        txtIdUsuario = new java.awt.TextField();
        lblNombre = new java.awt.Label();
        txtNombre = new java.awt.TextField();
        lblAp1 = new java.awt.Label();
        txtAp1 = new java.awt.TextField();
        lblAp2 = new java.awt.Label();
        txtAp2 = new java.awt.TextField();
        lblEmail = new java.awt.Label();
        txtFechaNacimiento = new java.awt.TextField();
        lblContrasena = new java.awt.Label();
        txtEmail = new java.awt.TextField();
        lblTipoUsuario = new java.awt.Label();
        txtContrasena = new java.awt.TextField();
        lblFechaNacimiento = new java.awt.Label();
        btnBuscarUsuario = new javax.swing.JButton();
        btnCrearUsuario = new javax.swing.JButton();
        btnModificarUsuario = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        cmbTipoUsuario = new javax.swing.JComboBox<>();

        btnBuscarUsuario1.setText("Buscar usuario");

        lblIdUsuario.setText("Id usuario:");

        txtIdUsuario.setMinimumSize(new java.awt.Dimension(90, 30));
        txtIdUsuario.setPreferredSize(new java.awt.Dimension(90, 30));

        lblNombre.setText("Nombre:");

        txtNombre.setPreferredSize(new java.awt.Dimension(140, 32));

        lblAp1.setText("Primer apellido:");

        txtAp1.setPreferredSize(new java.awt.Dimension(140, 32));

        lblAp2.setText("Segundo apellido:");

        txtAp2.setPreferredSize(new java.awt.Dimension(140, 32));

        lblEmail.setText("Email:");

        txtFechaNacimiento.setPreferredSize(new java.awt.Dimension(140, 32));

        lblContrasena.setText("Contraseña:");

        txtEmail.setPreferredSize(new java.awt.Dimension(140, 32));

        lblTipoUsuario.setText("Tipo usuario:");

        txtContrasena.setPreferredSize(new java.awt.Dimension(140, 32));

        lblFechaNacimiento.setText("Fecha nacimiento:");

        btnBuscarUsuario.setText("Buscar ");
        btnBuscarUsuario.addActionListener(this::btnBuscarUsuarioActionPerformed);

        btnCrearUsuario.setText("Nuevo ");
        btnCrearUsuario.addActionListener(this::btnCrearUsuarioActionPerformed);

        btnModificarUsuario.setText("Guardar ");
        btnModificarUsuario.addActionListener(this::btnModificarUsuarioActionPerformed);

        btnEliminarUsuario.setText("Eliminar ");
        btnEliminarUsuario.addActionListener(this::btnEliminarUsuarioActionPerformed);

        cmbTipoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORMAL", "ADMIN" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCrearUsuario)
                        .addGap(52, 52, 52))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnModificarUsuario)
                                .addGap(52, 52, 52)
                                .addComponent(btnEliminarUsuario)))
                        .addContainerGap(17, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTipoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscarUsuario)
                    .addComponent(btnCrearUsuario))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarUsuario)
                    .addComponent(btnEliminarUsuario))
                .addGap(88, 88, 88))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarUsuarioActionPerformed
        try {
            int idUsuario = Integer.parseInt(txtIdUsuario.getText().trim());

            Usuario u = fa.buscarUsuarioPorId(idUsuario);

            if (u == null) {
                fa.muestraExcepcion("No existe ningún usuario con ese ID.");
                return;
            }

            txtNombre.setText(u.getNombre());
            txtAp1.setText(u.getAp1());
            txtAp2.setText(u.getAp2());
            txtFechaNacimiento.setText(u.getEmail());
            txtEmail.setText(u.getContrasena());
            cmbTipoUsuario.setSelectedItem(u.getTipoUsuario());

            if (u.getFechaNacimiento() != null) {
                txtFechaNacimiento.setText(u.getFechaNacimiento().toString());
            }
        } catch (NumberFormatException e) {
            fa.muestraExcepcion("El ID de usuario debe ser un número.");
        } catch (Exception e) {
            fa.muestraExcepcion("Error al buscar usuario: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarUsuarioActionPerformed

    private void btnCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearUsuarioActionPerformed
        try {
            Usuario u = new Usuario();

            // EL ID NO SE PIDE, LO GENERA LA BD
            u.setNombre(txtNombre.getText().trim());
            u.setAp1(txtAp1.getText().trim());
            u.setAp2(txtAp2.getText().trim());
            u.setEmail(txtEmail.getText().trim());
            u.setContrasena(txtContrasena.getText().trim());
            u.setTipoUsuario(cmbTipoUsuario.getSelectedItem().toString());
            u.setFechaNacimiento(LocalDate.parse(txtFechaNacimiento.getText().trim()));

            String resultado = fa.registrarUsuario(u);
            JOptionPane.showMessageDialog(this, resultado);

            // limpiar campos después de crear
            txtIdUsuario.setText("");
            txtNombre.setText("");
            txtAp1.setText("");
            txtAp2.setText("");
            txtFechaNacimiento.setText("");
            txtEmail.setText("");
            txtContrasena.setText("");

        } catch (Exception e) {
            fa.muestraExcepcion("Error al crear usuario: " + e.getMessage());
        }
    }//GEN-LAST:event_btnCrearUsuarioActionPerformed

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        try {
            Usuario u = new Usuario();

            u.setIdUsuario(Integer.parseInt(txtIdUsuario.getText().trim()));
            u.setNombre(txtNombre.getText().trim());
            u.setAp1(txtAp1.getText().trim());
            u.setAp2(txtAp2.getText().trim());
            u.setEmail(txtFechaNacimiento.getText().trim());
            u.setContrasena(txtEmail.getText().trim());
            u.setTipoUsuario(cmbTipoUsuario.getSelectedItem().toString());
            u.setFechaNacimiento(LocalDate.parse(txtFechaNacimiento.getText().trim()));

            String resultado = fa.modificarDatos(u);
            JOptionPane.showMessageDialog(this, resultado);

        } catch (NumberFormatException e) {
            fa.muestraExcepcion("El ID debe ser un número.");
        } catch (Exception e) {
            fa.muestraExcepcion("Error al modificar usuario: " + e.getMessage());
        }
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        try {
            int idUsuario = Integer.parseInt(txtIdUsuario.getText().trim());

            int respuesta = JOptionPane.showConfirmDialog(
                this,
                "¿Seguro que quieres eliminar este usuario?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
            );

            if (respuesta != JOptionPane.YES_OPTION) {
                return;
            }

            Usuario u = new Usuario();
            u.setIdUsuario(idUsuario);
            String resultado = fa.eliminarUsuario(u);
            JOptionPane.showMessageDialog(this, resultado);
            
        } catch (NumberFormatException e) {
            fa.muestraExcepcion("El ID debe ser un número.");
        } catch (Exception e) {
            fa.muestraExcepcion("Error al eliminar usuario: " + e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarUsuario;
    private javax.swing.JButton btnBuscarUsuario1;
    private javax.swing.JButton btnCrearUsuario;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JComboBox<String> cmbTipoUsuario;
    private java.awt.Label lblAp1;
    private java.awt.Label lblAp2;
    private java.awt.Label lblContrasena;
    private java.awt.Label lblEmail;
    private java.awt.Label lblFechaNacimiento;
    private java.awt.Label lblIdUsuario;
    private java.awt.Label lblNombre;
    private java.awt.Label lblTipoUsuario;
    private java.awt.TextField txtAp1;
    private java.awt.TextField txtAp2;
    private java.awt.TextField txtContrasena;
    private java.awt.TextField txtEmail;
    private java.awt.TextField txtFechaNacimiento;
    private java.awt.TextField txtIdUsuario;
    private java.awt.TextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
