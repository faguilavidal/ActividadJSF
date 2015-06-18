
package BLL;

/**
 *
 * @author Matias
 */
import java.io.Serializable;

public class OrdenBean implements Serializable{
    private String item;
    private int cantidad;
    private int precio;

    public OrdenBean(String item, int cantidad, int precio) {
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
}

