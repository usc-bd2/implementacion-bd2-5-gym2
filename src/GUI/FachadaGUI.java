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
        VAutenticacion vLogin = new VAutenticacion(fachadaAp, vContenedor);
        vLogin.pack();
        vLogin.setLocationRelativeTo(null);
        vLogin.setVisible(true);
    }

    public VContenedor getVContenedor() {
        return vContenedor;
    }
}