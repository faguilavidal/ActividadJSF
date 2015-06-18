package DAL;


/**
 *
 * @author Matias
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {
    
    private Connection conn;
    
    public Conexion(){
        verificarControlador();
        conectarse();
    }
    
    private void verificarControlador(){
        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Driver verificado...");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("Driver no encontrado. " + e.getMessage());
        }
    }
    
    private void conectarse(){
        try
        {
            String root = "TrabajoIII";
            String pass = "acmilan29";
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", root, pass);
            System.out.println("Conectado satisfactoriamente...");
        }
        catch(SQLException e)
        {
            System.out.println("NO se logró establecer conexión, " + e.getMessage());
        }
    }
    
    public PreparedStatement crearSentencia(String sql){
        try
        {
            return conn.prepareStatement(sql);
        }
        catch(SQLException e)
        {
            return null;
        }
    }
}
