package GUI;

import Aplicacion.FachadaAplicacion;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Stack;


public class VContenedor extends javax.swing.JFrame {
    
    protected FachadaAplicacion fa;
    private JPanel panelContenido;

    private Stack<Vista> pilaAtras = new Stack<>();
    private Vista vistaActual;

    private static class Vista {
        private JPanel panel;
        private String titulo;

        public Vista(JPanel panel, String titulo) {
            this.panel = panel;
            this.titulo = titulo;
        }
    }

    public VContenedor(FachadaAplicacion fa) {
        this.fa = fa;
        initComponents();
        panelContenido = new JPanel(new BorderLayout());

        getContentPane().removeAll();
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(toolBar, BorderLayout.SOUTH);
        getContentPane().add(panelContenido, BorderLayout.CENTER);
        
        btnIrAtras.setEnabled(false);
        setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        fillerToolBox2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnIrAtras = new javax.swing.JButton();
        menuVentana = new javax.swing.JMenuBar();
        menuItem = new javax.swing.JMenu();
        menuItemInicio = new javax.swing.JMenuItem();
        menuItemPerfil = new javax.swing.JMenuItem();
        menuItemClases = new javax.swing.JMenuItem();
        menuItemSesiones = new javax.swing.JMenuItem();
        menuItemProductos = new javax.swing.JMenuItem();
        menuItemValoraciones = new javax.swing.JMenuItem();
        menuItemTest = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cambiar_nombre_ventana");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/GUI/recursos/logo_1.webp")).getImage());
        setResizable(false);

        toolBar.setBackground(java.awt.SystemColor.window);
        toolBar.setBorder(null);
        toolBar.setRollover(true);
        toolBar.add(fillerToolBox2);

        btnIrAtras.setBackground(java.awt.SystemColor.window);
        btnIrAtras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/recursos/left-arrow.png"))); // NOI18N
        btnIrAtras.setFocusable(false);
        btnIrAtras.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnIrAtras.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnIrAtras.addActionListener(this::btnIrAtrasActionPerformed);
        toolBar.add(btnIrAtras);

        menuVentana.setToolTipText("");

        menuItem.setText("Menu");
        menuItem.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N

        menuItemInicio.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        menuItemInicio.setText("Inicio");
        menuItemInicio.addActionListener(this::menuItemInicioActionPerformed);
        menuItem.add(menuItemInicio);

        menuItemPerfil.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        menuItemPerfil.setText("Perfil");
        menuItemPerfil.addActionListener(this::menuItemPerfilActionPerformed);
        menuItem.add(menuItemPerfil);

        menuItemClases.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        menuItemClases.setText("Clases");
        menuItemClases.addActionListener(this::menuItemClasesActionPerformed);
        menuItem.add(menuItemClases);

        menuItemSesiones.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        menuItemSesiones.setText("Sesiones");
        menuItemSesiones.addActionListener(this::menuItemSesionesActionPerformed);
        menuItem.add(menuItemSesiones);

        menuItemProductos.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        menuItemProductos.setText("Productos");
        menuItemProductos.addActionListener(this::menuItemProductosActionPerformed);
        menuItem.add(menuItemProductos);

        menuItemValoraciones.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        menuItemValoraciones.setText("Valoraciones");
        menuItemValoraciones.addActionListener(this::menuItemValoracionesActionPerformed);
        menuItem.add(menuItemValoraciones);

        menuItemTest.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        menuItemTest.setText("Test");
        menuItemTest.addActionListener(this::menuItemTestActionPerformed);
        menuItem.add(menuItemTest);

        menuVentana.add(menuItem);

        setJMenuBar(menuVentana);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 454, Short.MAX_VALUE)
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void navegarA(JPanel panel, String titulo) {
        if (vistaActual != null) {
            pilaAtras.push(vistaActual);
        }
        vistaActual = new Vista(panel, titulo);
        actualizarPantalla(panel, titulo);
        actualizarBotonAtras();
    }

    private void actualizarPantalla(JPanel panel, String titulo) {
        this.setTitle(titulo);
        panelContenido.removeAll();
        panelContenido.add(panel, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
        this.pack();
    }

    private void menuItemInicioActionPerformed(java.awt.event.ActionEvent evt) {
        navegarA(new VPrincipal(fa), "Proyecto BDII - Gimnasio");
    }

    private void menuItemPerfilActionPerformed(java.awt.event.ActionEvent evt) {
        navegarA(new VPerfil(fa), "Perfil");
    }

    private void menuItemClasesActionPerformed(java.awt.event.ActionEvent evt) {
        navegarA(new VPrincipal(fa), "Catálogo de Clases");
    }

    private void menuItemSesionesActionPerformed(java.awt.event.ActionEvent evt) {
        navegarA(new VCatalogoSesiones(fa), "Sesiones");
    }

    private void menuItemProductosActionPerformed(java.awt.event.ActionEvent evt) {
        navegarA(new VProductos(fa), "Productos");
    }

    private void menuItemValoracionesActionPerformed(java.awt.event.ActionEvent evt) {
        navegarA(new VOpiniones(fa), "Valoraciones");
    }

    private void menuItemTestActionPerformed(java.awt.event.ActionEvent evt) {
        navegarA(new VTestUsuario(fa), "Test");
    }

    private void btnIrAtrasActionPerformed(java.awt.event.ActionEvent evt) {
        if (!pilaAtras.isEmpty()) {
            vistaActual = pilaAtras.pop();
            actualizarPantalla(vistaActual.panel, vistaActual.titulo);
            actualizarBotonAtras();
        }
    }

    private void actualizarBotonAtras() {
        btnIrAtras.setEnabled(!pilaAtras.isEmpty());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIrAtras;
    private javax.swing.Box.Filler fillerToolBox2;
    private javax.swing.JMenu menuItem;
    private javax.swing.JMenuItem menuItemClases;
    private javax.swing.JMenuItem menuItemInicio;
    private javax.swing.JMenuItem menuItemPerfil;
    private javax.swing.JMenuItem menuItemProductos;
    private javax.swing.JMenuItem menuItemSesiones;
    private javax.swing.JMenuItem menuItemTest;
    private javax.swing.JMenuItem menuItemValoraciones;
    private javax.swing.JMenuBar menuVentana;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
