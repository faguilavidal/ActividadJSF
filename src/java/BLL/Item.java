package BLL;

/**
 *
 * @author fabian
 */
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

@ManagedBean (name="item")
@SessionScoped

public class Item implements Serializable
{
    private String item;
    private int cantidad;
    private int precio;
    private ArrayList<Item> lista = new ArrayList<>();

    public Item()
    {
    }
    
    public Item(String item, int cantidad, int precio) {
        this.item = item;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    public ArrayList<Item> getOrdenLista()
    {
        lista.clear();
        
        for(Item i : new DAL.Item().selectProductos())
        {
           lista.add(i);
        }
        
        return lista;
    }
    
    public void agregarAccion()
    {
        Item i = new Item(this.item,this.cantidad,this.precio);
        
        new DAL.Item().insertProducto(i);
        
        lista.add(i);
        
        
        this.item="";
        this.cantidad = 0;
        this.precio = 0;
    }
    
    public void editar(RowEditEvent event)
    {
        FacesMessage msg = new FacesMessage("Producto confirmado",((Item) event.getObject()).getItem());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    
    public void cancelar(RowEditEvent event)
    {
        FacesMessage msg = 
        new FacesMessage("Producto cancelado");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        new DAL.Item().deleteProducto((Item)event.getObject());
        lista.remove((Item)event.getObject());
    }
}