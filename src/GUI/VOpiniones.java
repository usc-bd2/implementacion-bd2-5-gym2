package GUI;

import Aplicacion.FachadaAplicacion;
import Aplicacion.Valoracion;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ListSelectionModel;


public class VOpiniones extends javax.swing.JPanel {
    
    private FachadaAplicacion fa;
    private ModeloTablaValoraciones modeloTablaValoraciones;

    public VOpiniones(FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();

        this.modeloTablaValoraciones = new ModeloTablaValoraciones();
        tablaValorar.setModel(modeloTablaValoraciones);
        tablaValorar.setFillsViewportHeight(true);
        tablaValorar.setRowSelectionAllowed(true);
        tablaValorar.setColumnSelectionAllowed(false);

        mostrarValoracionesPropias();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTablaValorar = new javax.swing.JScrollPane();
        tablaValorar = new javax.swing.JTable();
        scrollTaxEditarOpinion = new javax.swing.JScrollPane();
        taxEditarOpinion = new javax.swing.JTextArea();
        lblEditarOpinion = new javax.swing.JLabel();
        cbPuntuacion = new javax.swing.JComboBox<>();
        lblPuntuacion = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        tablaValorar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Clase", "Fecha", "Puntuación", "Opinión"
            }
        ));
        scrollTablaValorar.setViewportView(tablaValorar);

        taxEditarOpinion.setColumns(20);
        taxEditarOpinion.setRows(5);
        scrollTaxEditarOpinion.setViewportView(taxEditarOpinion);

        lblEditarOpinion.setText("Editar opinión");

        cbPuntuacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        lblPuntuacion.setText("Puntuación:");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(this::btnGuardarActionPerformed);

        btnEliminar.setText("Eliminar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPuntuacion)
                        .addGap(18, 18, 18)
                        .addComponent(cbPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblEditarOpinion)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(scrollTaxEditarOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addComponent(scrollTablaValorar, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(scrollTablaValorar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(lblEditarOpinion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTaxEditarOpinion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPuntuacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPuntuacion))
                .addContainerGap(65, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
    
    }

    private void mostrarValoracionesPropias() {
        List<Valoracion> valoraciones = fa.consultarValoracionesPropias();
        modeloTablaValoraciones.setFilas(valoraciones);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbPuntuacion;
    private javax.swing.JLabel lblEditarOpinion;
    private javax.swing.JLabel lblPuntuacion;
    private javax.swing.JScrollPane scrollTablaValorar;
    private javax.swing.JScrollPane scrollTaxEditarOpinion;
    private javax.swing.JTable tablaValorar;
    private javax.swing.JTextArea taxEditarOpinion;
    // End of variables declaration//GEN-END:variables
}
