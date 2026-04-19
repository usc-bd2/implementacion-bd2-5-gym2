package BaseDatos;

import java.sql.Connection;


public abstract class AbstractDAO {
    private Connection conexion;
   
    protected void setConexion(Connection conexion){
        this.conexion=conexion;
    }

   protected Connection getConexion(){
        return this.conexion;
    }
}
