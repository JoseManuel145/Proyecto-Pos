package manuel.cruz.demoproyecto.models;

import java.util.Random;

public class Producto {
    private Random random = new Random();
    protected String id;
    protected String nombre;
    protected int cantidad;
    protected double precio;

    public Producto() {
    }
    public Producto(String id, String nombre, int cantidad, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String genId(){
        this.id = String.valueOf(1);
        for (int i = 0; i<3; i++){
            this.id += String.valueOf(random.nextInt(10));
        }
        return id;
    }
    public String productosEnVenta(){
        return id + "       " + nombre + "      $" + precio;
    }
}
