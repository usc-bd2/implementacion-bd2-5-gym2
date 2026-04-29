package GUI;

import Aplicacion.FachadaAplicacion;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.util.Stack;


/**
 * Ventana contenedora principal de la aplicación.
 *
 * Su responsabilidad es:
 * - mantener una zona central donde se cargan los distintos paneles de la app,
 * - gestionar la navegación entre vistas,
 * - conservar un historial simple para permitir volver a la vista anterior.
 *
 * La navegación se implementa con una pila de vistas previas.
 */
public class VContenedor extends javax.swing.JFrame {
    
    protected FachadaAplicacion fa;

    private Stack<Vista> pilaAtras = new Stack<>();     // Historial de navegación hacia atras
    private Vista vistaActual;

    private static class Vista {    // Representa una vista por su panel y su título
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

        btnIrAtras.setEnabled(false);
        
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                fa.cerrarAplicacion();
            }
        });
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolBar = new javax.swing.JToolBar();
        fillerToolBox2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        btnIrAtras = new javax.swing.JButton();
        panelContenido = new javax.swing.JPanel();
        menuVentana = new javax.swing.JMenuBar();
        menuItem = new javax.swing.JMenu();
        menuItemInicio = new javax.swing.JMenuItem();
        menuItemPerfil = new javax.swing.JMenuItem();
        menuItemClases = new javax.swing.JMenuItem();
        menuItemProductos = new javax.swing.JMenuItem();
        menuItemValoraciones = new javax.swing.JMenuItem();
        menuItemMisOpiniones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cambiar_nombre_ventana");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/GUI/recursos/logo_1.webp")).getImage());
        getContentPane().setLayout(new java.awt.BorderLayout());

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

        getContentPane().add(toolBar, java.awt.BorderLayout.SOUTH);

        panelContenido.setPreferredSize(new java.awt.Dimension(600, 500));
        panelContenido.setLayout(new java.awt.BorderLayout());
        getContentPane().add(panelContenido, java.awt.BorderLayout.CENTER);

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

        menuItemProductos.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        menuItemProductos.setText("Productos");
        menuItemProductos.addActionListener(this::menuItemProductosActionPerformed);
        menuItem.add(menuItemProductos);

        menuItemValoraciones.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        menuItemValoraciones.setText("Valoraciones");
        menuItemValoraciones.addActionListener(this::menuItemValoracionesActionPerformed);
        menuItem.add(menuItemValoraciones);

        menuItemMisOpiniones.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        menuItemMisOpiniones.setText("Mis opiniones");
        menuItemMisOpiniones.addActionListener(this::menuItemMisOpinionesActionPerformed);
        menuItem.add(menuItemMisOpiniones);

        menuVentana.add(menuItem);

        setJMenuBar(menuVentana);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void navegarA(JPanel panel, String titulo) {     // Navega a una nueva vista y guarda la actual en el historial.

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
    }

    // -- HANDLERS --

    private void menuItemInicioActionPerformed(java.awt.event.ActionEvent evt) {
        navegarA(new VPrincipal(fa), "Catálogo de Sesiones");
    }

    private void menuItemPerfilActionPerformed(java.awt.event.ActionEvent evt) {
        navegarA(new VPerfil(fa), "Perfil");
    }

    private void menuItemClasesActionPerformed(java.awt.event.ActionEvent evt) {
        navegarA(new VListaClases(fa), "Catálogo de Clases");
    }

    private void menuItemProductosActionPerformed(java.awt.event.ActionEvent evt) {
        navegarA(new VProductos(fa), "Productos");
    }

    private void menuItemValoracionesActionPerformed(java.awt.event.ActionEvent evt) {
        navegarA(new VOpinionesClase(fa), "Valoraciones clases");
    }

    private void menuItemMisOpinionesActionPerformed(java.awt.event.ActionEvent evt) {
        navegarA(new VOpiniones(fa), "Mis valoraciones");
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
    private javax.swing.JMenuItem menuItemMisOpiniones;
    private javax.swing.JMenuItem menuItemPerfil;
    private javax.swing.JMenuItem menuItemProductos;
    private javax.swing.JMenuItem menuItemValoraciones;
    private javax.swing.JMenuBar menuVentana;
    private javax.swing.JPanel panelContenido;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
