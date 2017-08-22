package formulariobd;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sergio Cañas
 * @version 1.0
 */
public class BaseD {
    
    /** Establece la conexion*/
    Connection conexion = null;
    
    /** Ejecuta las operaciones*/
    Statement state = null;
    
    /** Cadenas con los argumentos de la conexion*/
    String driver, url, usuario, contra;
    
    /**
     * Constructor. Asigna los argumentos de la conexion
     */
    public BaseD(){
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost/formulario";
        usuario = "root";
        contra = "n0m3l0";
    }
    
    /**
     * @throws Exception 
     */
    public void Conectar() throws Exception{
        Class.forName(driver).newInstance();
        conexion = DriverManager.getConnection(url, usuario, contra);
    }
    
    /**
     * Realiza la operacion insert en la tabla "formulario" de la base de datos
     * 
     * @param nombre Recibe el valor del campo "Nombre"
     * @param app Recibe el valor del campo "Apellido Paterno"
     * @param apm Recibe el valor del campo "Apellido Materno"
     * @param grupo Recibe el valor del campo "Grupo"
     * 
     * @throws SQLException
     */
    public void Agregar(String nombre, String app, String apm, String grupo) throws SQLException{
        state = conexion.createStatement();
        state.execute("INSERT INTO formulario VALUES('" + nombre + "', '" + app + "', '" + apm + "', '" + grupo + "');");
    }
    
    /**
     * @throws SQLException 
     */
    public void Cerrar() throws SQLException{
        conexion.close();
    }
}