package GUI;

import Aplicacion.FachadaAplicacion;
import Aplicacion.Valoracion;
import Aplicacion.ValoracionResumen;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class VOpinionesClase extends javax.swing.JPanel {
    
    private FachadaAplicacion fa;

    public VOpinionesClase(FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombreClase = new java.awt.Label();
        txtNombreClase = new javax.swing.JTextField();
        btnBuscarValoraciones = new javax.swing.JButton();
        lblMedia = new java.awt.Label();
        lblNumero = new java.awt.Label();
        tablaValoraciones = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblValorMedia = new java.awt.Label();
        lblValorMedia1 = new java.awt.Label();
        lblValorNum = new java.awt.Label();

        lblNombreClase.setText("Nombre clase:");

        txtNombreClase.setMinimumSize(new java.awt.Dimension(140, 32));
        txtNombreClase.setPreferredSize(new java.awt.Dimension(140, 32));

        btnBuscarValoraciones.setText("Buscar valoraciones");
        btnBuscarValoraciones.addActionListener(this::btnBuscarValoracionesActionPerformed);

        lblMedia.setText("Media:");

        lblNumero.setText("Numero de valoraciones:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Puntuación", "Opinión"
            }
        ));
        tablaValoraciones.setViewportView(jTable1);

        lblValorMedia1.setPreferredSize(new java.awt.Dimension(90, 30));

        lblValorNum.setPreferredSize(new java.awt.Dimension(90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tablaValoraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorMedia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblValorMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblNombreClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscarValoraciones)))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombreClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarValoraciones))
                    .addComponent(lblNombreClase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorMedia1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValorNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablaValoraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarValoracionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarValoracionesActionPerformed
        try {
            String nombreClase = txtNombreClase.getText().trim();

            if (nombreClase.isEmpty()) {
                fa.muestraExcepcion("Introduce el nombre de la clase.");
                return;
            }

            ValoracionResumen resumen = fa.resumenValoracionesClase(nombreClase);
            ArrayList<Valoracion> valoraciones = fa.valoracionesClase(nombreClase);

            lblValorMedia1.setText(String.format("%.2f", resumen.getMediaPuntuacion()));
            lblValorNum.setText(String.valueOf(resumen.getNumeroValoraciones()));

            DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
            modelo.setRowCount(0);

            for (Valoracion v : valoraciones) {
                modelo.addRow(new Object[]{
                    v.getPuntuacion(),
                    v.getOpinion()
                });
            }

        } catch (Exception e) {
            fa.muestraExcepcion("Error al consultar valoraciones: " + e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarValoracionesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarValoraciones;
    private javax.swing.JTable jTable1;
    private java.awt.Label lblMedia;
    private java.awt.Label lblNombreClase;
    private java.awt.Label lblNumero;
    private java.awt.Label lblValorMedia;
    private java.awt.Label lblValorMedia1;
    private java.awt.Label lblValorNum;
    private javax.swing.JScrollPane tablaValoraciones;
    private javax.swing.JTextField txtNombreClase;
    // End of variables declaration//GEN-END:variables
}
