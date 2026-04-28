package GUI;

import Aplicacion.Valoracion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaValoraciones extends AbstractTableModel {
    private List<Valoracion> filas;
    private final String[] columnas = {
        "Clase", "Fecha", "Puntuación", "Opinión"
    };

    public ModeloTablaValoraciones() {
        this.filas = new ArrayList<>();
    }

    public void setFilas(List<Valoracion> filas) {
        this.filas = filas;
        fireTableDataChanged();
    }

    public Valoracion getValoracionAt(int fila) {
        if (fila < 0 || fila >= filas.size()) {
            return null;
        }
        return filas.get(fila);
    }

    @Override
    public int getRowCount() {
        return filas.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }

    @Override
    public Class<?> getColumnClass(int columna) {
        switch (columna) {
            case 0:
                return String.class;
            case 1:
                return java.time.LocalDate.class;
            case 2:
                return Integer.class;
            case 3:
                return String.class;
            default:
                return Object.class;
        }
    }

    @Override
    public Object getValueAt(int fila, int columna) {
        Valoracion v = filas.get(fila);

        switch (columna) {
            case 0:
                return v.consultarNombreClase();
            case 1:
                return v.consultarFecha();
            case 2:
                return v.consultarPuntuacion();
            case 3:
                return v.consultarOpinion();
            default:
                return null;
        }
    }

    @Override
    public boolean isCellEditable(int fila, int columna) {
        return false;
    }
}