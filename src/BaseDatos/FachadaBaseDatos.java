package BaseDatos;

import Aplicacion.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;


public class FachadaBaseDatos {
    private Connection conexionBD;
    private DAOUsuario daoUsuario;
    private DAOClases daoClases;

    public FachadaBaseDatos(FachadaAplicacion fa) {
        try {
            FileInputStream docConfig = new FileInputStream("Gym.properties");
            Properties config = new Properties();
            config.load(docConfig);

            String gestor = config.getProperty("gestor");
            String servidor = config.getProperty("servidor");
            String puerto = config.getProperty("puerto");
            String baseDatos = config.getProperty("baseDatos");
            String usuario = config.getProperty("usuario");
            String clave = config.getProperty("clave");

            if (!"postgresql".equalsIgnoreCase(gestor)) {
                throw new IllegalArgumentException(
                    "El gestor configurado no es compatible: " + gestor
                );
            }

            String urlConexion = "jdbc:postgresql://" + servidor + ":" + puerto + "/" + baseDatos;
            this.conexionBD = DriverManager.getConnection(urlConexion, usuario, clave);

            // Inicializar los DAOs
            this.daoUsuario = new DAOUsuario(conexionBD);
            this.daoClases = new DAOClases(conexionBD);

        } catch (IOException | SQLException e) {
            throw new IllegalStateException("No se pudo inicializar la base de datos: " + e.getMessage(), e);
        }
    }

    public Connection getConexionBD() {
        return conexionBD;
    }

    public void cerrarConexion() {
        try {
            if (conexionBD != null && !conexionBD.isClosed()) {
                conexionBD.close();
            }
        } catch (SQLException e) {
            System.err.println("No se ha podido cerrar la conexión: " + e.getMessage());
        }
    }
    
    public Usuario buscarUsuarioPorId(Integer idUsuario) {
        return daoUsuario.buscarPorId(idUsuario);
    }

    public List<Clase> consultarClases(String nombre, Integer duracion, String clasificacion) {
       return daoClases.consultarClases(nombre, duracion, clasificacion);
    }
}