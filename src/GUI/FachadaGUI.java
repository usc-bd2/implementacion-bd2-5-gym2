package GUI;

import Aplicacion.FachadaAplicacion;
import javax.swing.JOptionPane;

public class FachadaGUI {
    private FachadaAplicacion fachadaAp;
    private VPrincipal vPrincipal; 
    
    public FachadaGUI(FachadaAplicacion fa) {
        this.fachadaAp = fa;
        this.vPrincipal = new VPrincipal(this.fachadaAp);
    }
    
    public void muestraExcepcion(String txtExcepcion) {
        JOptionPane.showMessageDialog(
            vPrincipal,
            txtExcepcion,
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
    
    public void iniciarVentanas() {
        vPrincipal.setVisible(true);
    }
}