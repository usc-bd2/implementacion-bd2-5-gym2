package GUI;

import javax.swing.JOptionPane;

import Aplicacion.Valoracion;
import Aplicacion.FachadaAplicacion;


public class VInsertarValoracion extends javax.swing.JPanel {
    private FachadaAplicacion fa;
    private String nombreClase;

    public VInsertarValoracion(FachadaAplicacion fa, String nombreClase) {
        this.fa = fa;
        this.nombreClase = nombreClase;
        initComponents();

        lblNombreClase.setText(nombreClase);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTxaOpinion = new javax.swing.JScrollPane();
        txaOpinion = new javax.swing.JTextArea();
        cbPuntuacion = new javax.swing.JComboBox<>();
        lblPuntuacion = new javax.swing.JLabel();
        lblEscribirOpinion = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        lblNombreClase = new javax.swing.JLabel();

        txaOpinion.setColumns(20);
        txaOpinion.setRows(5);
        scrollTxaOpinion.setViewportView(txaOpinion);

        cbPuntuacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        cbPuntuacion.addActionListener(this::cbPuntuacionActionPerformed);

        lblPuntuacion.setText("Puntuación:");

        lblEscribirOpinion.setText("Escribe tu opinión:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        lblNombreClase.setFont(new java.awt.Font("Helvetica Neue", 1, 18)); // NOI18N
        lblNombreClase.setText("{Nombre clase}");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEscribirOpinion)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombreClase)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(scrollTxaOpinion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblPuntuacion)
                                .addGap(19, 19, 19)
                                .addComponent(cbPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                                .addComponent(btnGuardar)))
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(lblNombreClase)
                .addGap(48, 48, 48)
                .addComponent(lblEscribirOpinion)
                .addGap(18, 18, 18)
                .addComponent(scrollTxaOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnGuardar)
                    .addComponent(lblPuntuacion)
                    .addComponent(cbPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbPuntuacionActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        registrarValoracion();
    }

    private void registrarValoracion() {
        try {
            String opinion = txaOpinion.getText();

            if (opinion != null) {
                opinion = opinion.trim();
            }

            Integer puntuacion = Integer.valueOf((String) cbPuntuacion.getSelectedItem());

            Valoracion valoracion = new Valoracion();
            valoracion.modificarNombreClase(nombreClase);
            valoracion.modificarIdUsuario(fa.getIdUsuarioAutenticado());
            valoracion.modificarOpinion(opinion);
            valoracion.modificarPuntuacion(puntuacion);

            fa.registrarValoracion(valoracion);

            JOptionPane.showMessageDialog(
                this,
                "Valoración registrada correctamente.",
                "Operación realizada",
                JOptionPane.INFORMATION_MESSAGE
            );

            txaOpinion.setText("");
            cbPuntuacion.setSelectedIndex(0);

        } catch (RuntimeException e) {
            fa.muestraExcepcion(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbPuntuacion;
    private javax.swing.JLabel lblEscribirOpinion;
    private javax.swing.JLabel lblNombreClase;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JScrollPane scrollTxaOpinion;
    private javax.swing.JTextArea txaOpinion;
    // End of variables declaration//GEN-END:variables
}
