package GUI;

import Aplicacion.FachadaAplicacion;
import Aplicacion.Sesion;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import Aplicacion.Reserva;
import javax.swing.JOptionPane;


public class VCatalogoSesiones extends javax.swing.JPanel {
    
    private FachadaAplicacion fa;
    private ModeloTablaSesiones modeloTablaSesiones;
    private boolean filtrarFecha = false;

    public VCatalogoSesiones(FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();

        this.modeloTablaSesiones = new ModeloTablaSesiones();
        tablaSesiones.setModel(modeloTablaSesiones);
        tablaSesiones.setFillsViewportHeight(true);
        tablaSesiones.setRowSelectionAllowed(true);
        tablaSesiones.setColumnSelectionAllowed(false);

        tablaSesiones.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                btnReservar.setEnabled(tablaSesiones.getSelectedRow() >= 0);
            }
        });
        
        spnFecha.addChangeListener(e -> filtrarFecha = true);
        mostrarSesiones();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        cbFiltroSala = new javax.swing.JComboBox<>();
        cbFiltroHora = new javax.swing.JComboBox<>();
        scrollTablaSesiones = new javax.swing.JScrollPane();
        tablaSesiones = new javax.swing.JTable();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblSala = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        spnFecha = new javax.swing.JSpinner();
        btnLimpiarFiltros = new javax.swing.JButton();
        btnReservar = new javax.swing.JButton();

        txtBuscar.setText("Buscar sesión");

        cbFiltroSala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Sala A", "Sala B", "Sala C", "Sala D", "Sala E" }));

        cbFiltroHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00" }));

        tablaSesiones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Clase", "Sala", "Fecha", "Hora", "PT", "PO", "PD", "% Ocupación"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollTablaSesiones.setViewportView(tablaSesiones);

        lblFecha.setText("Fecha:");

        lblHora.setText("Hora:");

        lblSala.setText("Sala:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(this::btnBuscarActionPerformed);

        spnFecha.setModel(new javax.swing.SpinnerDateModel());
        spnFecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        spnFecha.setEditor(new javax.swing.JSpinner.DateEditor(spnFecha, "dd/MM/yy"));

        btnLimpiarFiltros.setText("Limpiar filtros");
        btnLimpiarFiltros.addActionListener(this::btnLimpiarFiltrosActionPerformed);

        btnReservar.setText("Reservar");
        btnReservar.setEnabled(false);
        btnReservar.addActionListener(this::btnReservarActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(scrollTablaSesiones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLimpiarFiltros)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReservar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHora)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFiltroHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSala)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbFiltroSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFiltroSala, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSala)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFecha))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbFiltroHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHora)
                    .addComponent(btnBuscar)
                    .addComponent(btnLimpiarFiltros)
                    .addComponent(btnReservar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(scrollTablaSesiones, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservarActionPerformed(java.awt.event.ActionEvent evt) {
        reservarSesionSeleccionada();
    }

    private void btnLimpiarFiltrosActionPerformed(java.awt.event.ActionEvent evt) {
        limpiarFiltros();
    }

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        mostrarSesiones();
    }

    private void limpiarFiltros() {
        txtBuscar.setText("Buscar sesión");
        cbFiltroSala.setSelectedItem("Todas");
        cbFiltroHora.setSelectedItem("Todas");

        spnFecha.setValue(new Date());
        filtrarFecha = false;

        mostrarSesiones();
    }

    private void mostrarSesiones() {
        try {
            String nombre = txtBuscar.getText();

            if (nombre == null || nombre.isBlank() || nombre.equals("Buscar sesión")) {
                nombre = null;
            }

            String sala = (String) cbFiltroSala.getSelectedItem();

            if (sala == null || sala.equals("Todas")) {
                sala = null;
            }

            LocalDate fechaSesion = null;

            if (filtrarFecha) {
                Object valorFecha = spnFecha.getValue();

                if (valorFecha instanceof Date) {
                    Date fecha = (Date) valorFecha;
                    fechaSesion = fecha.toInstant()
                            .atZone(ZoneId.systemDefault())
                            .toLocalDate();
                }
            }

            LocalTime horaInicio = null;

            String hora = (String) cbFiltroHora.getSelectedItem();

            if (hora != null && !hora.isBlank() && !hora.equals("Todas")) {
                horaInicio = LocalTime.parse(hora.trim(), DateTimeFormatter.ofPattern("H:mm"));
            }

            List<Sesion> sesiones = fa.consultarSesiones(nombre, fechaSesion, sala, horaInicio);
            modeloTablaSesiones.setFilas(sesiones);
            tablaSesiones.clearSelection();
            btnReservar.setEnabled(false);
        } catch (RuntimeException e) {
            fa.muestraExcepcion(e.getMessage());
        }
    }

    private Sesion obtenerSesionSeleccionada() {
        int filaVista = tablaSesiones.getSelectedRow();
        if (filaVista < 0) {
            fa.muestraExcepcion("Debe seleccionar una sesión para reservar.");
            return null;
        }
        int filaModelo = tablaSesiones.convertRowIndexToModel(filaVista);
        return modeloTablaSesiones.obtenerSesion(filaModelo);
    }

    private void reservarSesionSeleccionada() {
        try {
            Sesion sesion = obtenerSesionSeleccionada();
            if (sesion == null) {
                fa.muestraExcepcion("Debe seleccionar una sesión.");
                return;
            }

            Reserva reserva = new Reserva();
            reserva.setIdUsuario(fa.getIdUsuarioAutenticado());
            reserva.setIdSesion(sesion.getIdSesion());

            Integer idReserva = fa.registrarReserva(reserva);

            if (idReserva == null) {
                throw new RuntimeException("No se pudo registrar la reserva.");
            }

            JOptionPane.showMessageDialog(
                this,
                "Reserva realizada correctamente.\nID reserva: " + idReserva,
                "Reserva confirmada",
                JOptionPane.INFORMATION_MESSAGE
            );

            mostrarSesiones();
            btnReservar.setEnabled(false);

        } catch (RuntimeException e) {
            fa.muestraExcepcion(e.getMessage());
            mostrarSesiones();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiarFiltros;
    private javax.swing.JButton btnReservar;
    private javax.swing.JComboBox<String> cbFiltroHora;
    private javax.swing.JComboBox<String> cbFiltroSala;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblSala;
    private javax.swing.JScrollPane scrollTablaSesiones;
    private javax.swing.JSpinner spnFecha;
    private javax.swing.JTable tablaSesiones;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
