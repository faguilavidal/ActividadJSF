
package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Matias
 */
public class Item 
{
  private Conexion conn;
    
    public Item()
    {
        conn = new Conexion();
    }
    
    public int insertProducto(BLL.Item i)
    {
        try
        {
            String sql = "insert into articulo values(?,?,?)";
            PreparedStatement insert = conn.crearSentencia(sql);
            
            insert.setString(1, i.getItem());
            insert.setInt(2, i.getPrecio());
            insert.setInt(3, i.getCantidad());
            
            return insert.executeUpdate();
        }
        catch(SQLException e)
        {
            return e.getErrorCode();
        }
    }  
    
    public ArrayList<BLL.Item> selectProductos()
    {
        try
        {
            ArrayList<BLL.Item> productos = new ArrayList<>();
            String sql = "select * from articulo";
            PreparedStatement select = conn.crearSentencia(sql);
            ResultSet articulo = select.executeQuery();
            
            while(articulo.next())
            {
                BLL.Item a = new BLL.Item();
                a.setItem(articulo.getString(1));
                a.setPrecio(articulo.getInt(2));
                a.setCantidad(articulo.getInt(3));
                
                productos.add(a);
            }
            
            return productos;
        }
        catch(SQLException e)
        {
            return null;
        }
    }
    
    public int deleteProducto(BLL.Item i)
    {
        try
        {
            String sql = "delete articulo where item = ?";
            PreparedStatement update = conn.crearSentencia(sql);
            
            update.setString(1, i.getItem());
            
            return update.executeUpdate();
        }
        catch(SQLException e)
        {
            return e.getErrorCode();
        }
    }
}
