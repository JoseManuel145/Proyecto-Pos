package manuel.cruz.demoproyecto.models;

public class ProductoAlimento extends Producto{
    private String fechaCaducidad;
    public ProductoAlimento(String id, String nombre, int cantidad, double precio, String fechaCaducidad) {
        super(id, nombre, cantidad, precio);
        this.fechaCaducidad = fechaCaducidad;
    }
    @Override
    public String toString() {
        return id + " " + nombre + " " + cantidad + " " + fechaCaducidad + " $" + precio;
    }
}
