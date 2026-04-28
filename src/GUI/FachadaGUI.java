package GUI;

import Aplicacion.FachadaAplicacion;
import javax.swing.JOptionPane;

public class FachadaGUI {
    private FachadaAplicacion fachadaAp;
    private VContenedor vContenedor;

    public FachadaGUI(FachadaAplicacion fa) {
        this.fachadaAp = fa;
        this.vContenedor = new VContenedor(this.fachadaAp);    
    }
    
    public void muestraExcepcion(String txtExcepcion) {
        JOptionPane.showMessageDialog(
            vContenedor,
            txtExcepcion,
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    public void iniciarVentanas() {
        VPrincipal vPrincipal = new VPrincipal(fachadaAp);
        vContenedor.navegarA(vPrincipal, "Catálogo de Clases");
        vContenedor.pack();
        vContenedor.setLocationRelativeTo(null);
        vContenedor.setVisible(true);
    }

    public VContenedor getVContenedor() {
        return vContenedor;
    }
}