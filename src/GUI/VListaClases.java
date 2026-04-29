package GUI;

import Aplicacion.FachadaAplicacion;
import Aplicacion.Clase;
import java.util.List;
import javax.swing.SwingUtilities;

public class VListaClases extends javax.swing.JPanel {
    
    private FachadaAplicacion fa;
    private ModeloTablaClases modeloTablaClases;

    public VListaClases(FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();

        this.modeloTablaClases = new ModeloTablaClases();
        tablaClases.setModel(modeloTablaClases);
        tablaClases.setFillsViewportHeight(true);
        tablaClases.setRowSelectionAllowed(true);
        tablaClases.setColumnSelectionAllowed(false);

        btnValorarClase.setEnabled(false);

        tablaClases.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                btnValorarClase.setEnabled(tablaClases.getSelectedRow() != -1);
            }
        });

        mostrarClases();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        cbFiltroDuracion = new javax.swing.JComboBox<>();
        cbFiltroClasificacion = new javax.swing.JComboBox<>();
        lblDuracion = new javax.swing.JLabel();
        lblClasificacion = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        scrollTablaClases = new javax.swing.JScrollPane();
        tablaClases = new javax.swing.JTable();
        btnValorarClase = new javax.swing.JButton();
        btnLimpiarFiltros = new javax.swing.JButton();

        txtBuscar.setText("Buscar clase");

        cbFiltroDuracion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "45", "60", "90" }));

        cbFiltroClasificacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Funcional", "Suelo", "Mente-Cuerpo", "Cardio", "Baile", "Musculacion" }));

        lblDuracion.setText("Duración (min):");

        lblClasificacion.setText("Clasificación:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        tablaClases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Duración", "Clasificación", "Valoración"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tablaClases.setColumnSelectionAllowed(true);
        scrollTablaClases.setViewportView(tablaClases);
        tablaClases.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btnValorarClase.setText("Valorar");
        btnValorarClase.setEnabled(false);
        btnValorarClase.addActionListener(this::btnValorarClaseActionPerformed);

        btnLimpiarFiltros.setText("Limpiar filtros");
        btnLimpiarFiltros.addActionListener(this::btnLimpiarFiltrosActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollTablaClases)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblClasificacion)
                            .addComponent(lblDuracion))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbFiltroClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbFiltroDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiarFiltros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnValorarClase)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDuracion)
                    .addComponent(cbFiltroDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblClasificacion)
                    .addComponent(cbFiltroClasificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnValorarClase)
                    .addComponent(btnLimpiarFiltros))
                .addGap(30, 30, 30)
                .addComponent(scrollTablaClases, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addGap(39, 39, 39))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarFiltrosActionPerformed(java.awt.event.ActionEvent evt) {
        limpiarFiltros();
    }

    private void limpiarFiltros() {
        txtBuscar.setText("Buscar clase");
        cbFiltroDuracion.setSelectedItem("Todas");
        cbFiltroClasificacion.setSelectedItem("Todas");
        mostrarClases();
    }

    private void btnValorarClaseActionPerformed(java.awt.event.ActionEvent evt) {
        int filaVista = tablaClases.getSelectedRow();
        if (filaVista == -1) {
            fa.muestraExcepcion("Debe seleccionar una clase.");
            return;
        }
        int filaModelo = tablaClases.convertRowIndexToModel(filaVista);
        String nombreClase = (String) modeloTablaClases.getValueAt(filaModelo, 0);
        VContenedor contenedor = (VContenedor) SwingUtilities.getWindowAncestor(this);
        contenedor.navegarA(new VInsertarValoracion(fa, nombreClase),"Insertar valoración");
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarClases();
    }

    private void mostrarClases() {
        try {
            // Filtros de búsqueda
            String nombre = txtBuscar.getText();
            if (nombre == null || nombre.isBlank() || nombre.equals("Buscar clase")) {
                nombre = null;
            }

            // Filtro de duración
            Integer duracion = null;
            String duracionSeleccionada = (String) cbFiltroDuracion.getSelectedItem();
            if (duracionSeleccionada != null && !duracionSeleccionada.equals("Todas")) {
                duracion = Integer.parseInt(duracionSeleccionada);
            }

            // Filtro de clasificación
            String clasificacion = (String) cbFiltroClasificacion.getSelectedItem();
            if (clasificacion == null || clasificacion.equals("Todas")) {
                clasificacion = null;
            }

            List<Clase> clases = fa.consultarClases(nombre, duracion, clasificacion);
            modeloTablaClases.setFilas(clases);

        } catch (RuntimeException e) {
            fa.muestraExcepcion(e.getMessage());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiarFiltros;
    private javax.swing.JButton btnValorarClase;
    private javax.swing.JComboBox<String> cbFiltroClasificacion;
    private javax.swing.JComboBox<String> cbFiltroDuracion;
    private javax.swing.JLabel lblClasificacion;
    private javax.swing.JLabel lblDuracion;
    private javax.swing.JScrollPane scrollTablaClases;
    private javax.swing.JTable tablaClases;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
