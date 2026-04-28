package GUI;

import Aplicacion.Sesion;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaSesiones extends AbstractTableModel {
    private List<Sesion> filas;
    private final String[] columnas = {
        "Clase", "Sala", "Fecha", "Hora", "PT", "PO", "PD", "% Ocupación"
    };

    public ModeloTablaSesiones() {
        this.filas = new ArrayList<>();
    }

    public void setFilas(List<Sesion> filas) {
        this.filas = filas;
        fireTableDataChanged();
    }

    public Sesion obtenerSesion(int fila) {
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
    public Object getValueAt(int fila, int columna) {
        Sesion sesion = filas.get(fila);

        switch (columna) {
            case 0:
                return sesion.getNombreClase();
            case 1:
                return sesion.getNombreSala();
            case 2:
                return sesion.getFechaSesion();
            case 3:
                return sesion.getHoraInicio();
            case 4:
                return sesion.getPlazasTotales();
            case 5:
                return sesion.getPlazasOcupadas();
            case 6:
                return sesion.getPlazasDisponibles();
            case 7:
                return sesion.getPorcentajeOcupacion();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columna) {
        switch (columna) {
            case 4:
            case 5:
            case 6:
                return Integer.class;
            case 7:
                return Double.class;
            default:
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int fila, int columna) {
        return false;
    }
}