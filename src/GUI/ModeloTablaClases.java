package GUI;

import Aplicacion.Clase;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ModeloTablaClases extends AbstractTableModel {

    private List<Clase> clases;
    private final String[] nombresColumnas = {
        "Nombre", "Duración", "Clasificación", "Valoración"
    };

    public ModeloTablaClases() {
        this.clases = new ArrayList<>();
    }

    @Override
    public int getColumnCount() {
        return nombresColumnas.length;
    }

    @Override
    public int getRowCount() {
        return clases.size();
    }

    @Override
    public String getColumnName(int col) {
        return nombresColumnas[col];
    }

    @Override
    public Class<?> getColumnClass(int col) {
        switch (col) {
            case 0:
                return String.class;
            case 1:
                return Integer.class;
            case 2:
                return String.class;
            case 3: 
                return Double.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Clase clase = clases.get(row);

        switch (col) {
            case 0:
                return clase.getNombre();
            case 1:
                return clase.getDuracion();
            case 2:
                return clase.getClasificacion();
            case 3: 
                if (clase.getPuntuacionMedia() == null) {
                    return "-";
                }
                return clase.getPuntuacionMedia();
            default:
                return null;
        }
    }

    public void setFilas(List<Clase> nuevasClases) {
        this.clases = nuevasClases;
        fireTableDataChanged();
    }

    public Clase obtenerClase(int i) {
        if (i >= 0 && i < clases.size()) {
            return clases.get(i);
        }
        return null;
    }
}