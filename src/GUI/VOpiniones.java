package GUI;

import Aplicacion.FachadaAplicacion;
import Aplicacion.Valoracion;
import java.util.List;
import javax.swing.JOptionPane;


public class VOpiniones extends javax.swing.JPanel {
    
    private FachadaAplicacion fa;

    public VOpiniones(FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();

        this.modeloTablaValoraciones = new ModeloTablaValoraciones();
        tablaValorar.setModel(modeloTablaValoraciones);
        tablaValorar.setFillsViewportHeight(true);
        tablaValorar.setRowSelectionAllowed(true);
        tablaValorar.setColumnSelectionAllowed(false);

        btnGuardar.setEnabled(false);
        btnEliminar.setEnabled(false);

        tablaValorar.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                cargarValoracionSeleccionada();
            }
        });

        mostrarValoracionesPropias();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        modificarValoracionSeleccionada();
    }

    private void modificarValoracionSeleccionada() {
        try {
            int filaVista = tablaValorar.getSelectedRow();

            if (filaVista == -1) {
                fa.muestraExcepcion("Debe seleccionar una valoración.");
                return;
            }

            int filaModelo = tablaValorar.convertRowIndexToModel(filaVista);
            Valoracion valoracion = modeloTablaValoraciones.getValoracionAt(filaModelo);
            String opinion = taxEditarOpinion.getText();

            if (opinion != null) {
                opinion = opinion.trim();
            }

            Integer puntuacion = Integer.valueOf((String) cbPuntuacion.getSelectedItem());

            valoracion.modificarOpinion(opinion);
            valoracion.modificarPuntuacion(puntuacion);

            Integer success = fa.modificarValoracion(valoracion);

            if (success == null || success <= 0) {
                fa.muestraExcepcion("No se pudo modificar la valoración seleccionada.");
            }
            
            JOptionPane.showMessageDialog(
                this,
                "Valoración modificada correctamente.",
                "Operación realizada",
                JOptionPane.INFORMATION_MESSAGE
            );
            
            mostrarValoracionesPropias();

        } catch (RuntimeException e) {
            fa.muestraExcepcion(e.getMessage());
        }
    }

    private void mostrarValoracionesPropias() {
        List<Valoracion> valoraciones = fa.consultarValoracionesPropias();
        modeloTablaValoraciones.setFilas(valoraciones);
    }

    private void cargarValoracionSeleccionada() {
        int filaVista = tablaValorar.getSelectedRow();

        if (filaVista == -1) {
            taxEditarOpinion.setText("");
            cbPuntuacion.setSelectedIndex(0);
            btnGuardar.setEnabled(false);
            btnEliminar.setEnabled(false);
            return;
        }

        int filaModelo = tablaValorar.convertRowIndexToModel(filaVista);
        Valoracion valoracion = modeloTablaValoraciones.getValoracionAt(filaModelo);

        if (valoracion == null) {
            return;
        }

        taxEditarOpinion.setText(valoracion.consultarOpinion());

        Integer puntuacion = valoracion.consultarPuntuacion();
        if (puntuacion != null) {
            cbPuntuacion.setSelectedItem(String.valueOf(puntuacion));
        }

        btnGuardar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
