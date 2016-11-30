
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Matias
 */
public class Login 
{
    private Conexion conn;
    
    public Login()
    {
        conn = new Conexion();
    }
    
    public int insertUsuario(BLL.Login l)
    {
        try
        {
            String sql = "insert into usuario values(?,?,?)";
            PreparedStatement insert = conn.crearSentencia(sql);
            
            insert.setString(1, l.getUsername());
            insert.setString(2, l.getPassword());
            insert.setString(3, l.getEmail());
            
            return insert.executeUpdate();
        }
        catch(SQLException e)
        {
            return e.getErrorCode();
        }
    }
    
    public BLL.Login selectUsuario(String nombre,String contraseña)
    {
        try
        {
            String sql = "select * from usuario where username = ? and password = ?";
            PreparedStatement select = conn.crearSentencia(sql);
            
            select.setString(1, nombre);
            select.setString(2, contraseña);
            
            ResultSet usuario = select.executeQuery();
            
            if(usuario.next())
            {
                BLL.Login u = new BLL.Login();
                u.setUsername(usuario.getString(1));
                u.setPassword(usuario.getString(2));
                u.setEmail(usuario.getString(3));
                
                return u;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException e)
        {
            return null;
        }
    }
}
