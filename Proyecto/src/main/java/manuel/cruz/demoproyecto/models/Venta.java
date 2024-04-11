package manuel.cruz.demoproyecto.models;

import java.util.ArrayList;

public class Venta {

    Inventario inventario;
    double total;
    ArrayList<Producto> productosVender = new ArrayList<>();


    public Venta(Inventario inventario) {
        this.inventario = inventario;
    }
    public ArrayList<Producto> getProductosVender() {
        return productosVender;
    }
    public boolean vacio() {
        return productosVender.isEmpty();
    }
    public double getTotal() {
        return total;
    }
    public boolean agregarProducto(String id) {
        boolean agregado = false;
        Producto productoEnInventario = inventario.getProductoPorId(id);
        if (productoEnInventario != null && productoEnInventario.getCantidad() > 0) {
            productosVender.add(productoEnInventario);
            agregado = true;
            inventario.reducirStock(id);
        }
        return agregado;
    }
    public boolean eliminarProducto(String idDel) {
        boolean eliminado;
        eliminado=productosVender.removeIf(producto -> idDel.equals(producto.getId()));
        inventario.aumentarStock(idDel);
        return eliminado;
    }
    public double calcularTotal() {
        total = 0;
        for (Producto producto : productosVender) {
            total += producto.getPrecio();
        }
        return total;
    }
    public Ticket finalizarVenta() {
        Ticket ticket = new Ticket(total);
        ticket.setProductosVendidos(new ArrayList<>(productosVender));
        productosVender.clear();
        return ticket;
    }
}
