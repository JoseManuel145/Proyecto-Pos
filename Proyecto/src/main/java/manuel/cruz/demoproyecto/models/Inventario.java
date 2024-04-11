package manuel.cruz.demoproyecto.models;

import java.util.ArrayList;

public class Inventario {
    private ArrayList <Producto> productos = new ArrayList<>();
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public boolean addProduct(Producto producto){
        return productos.add(producto);
    }
    public Boolean delProducto (String id){
        boolean eliminado = false;
        for (int i = 0; i < productos.size(); i++){
            if (id.equals(productos.get(i).getId())){
                productos.remove(i);
                eliminado = true;
                break;
            }
        }
        return eliminado;
    }
    public Producto getProductoPorId(String id) {
        for (Producto producto : productos) {
            if (id.equals(producto.getId())) {
                return producto;
            }
        }
        return null;
    }
    public void reducirStock(String id) {
        Producto producto = getProductoPorId(id);
        if (producto != null && producto.getCantidad() > 0) {
            producto.setCantidad(producto.getCantidad() - 1);
        }
    }
    public void aumentarStock(String id) {
        Producto producto = getProductoPorId(id);
        if (producto != null) {
            producto.setCantidad(producto.getCantidad() + 1);
        }
    }
}
