package manuel.cruz.demoproyecto.models;

public class ProductoHogar extends Producto{
    private String categoria;

    public ProductoHogar(String id, String nombre, int cantidad, double precio, String categoria) {
        super(id, nombre, cantidad, precio);
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return id + " " + nombre + " " + cantidad + " " + categoria + " $" + precio;
    }
}
