package manuel.cruz.demoproyecto.models;

import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.controllers.venta.VentaController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

    public class Ticket {
        private double total;
        private static int nextId = 0;
        private int id;
        private ArrayList<Producto> productosVendidos;
        private ArrayList<Ticket> tickets = new ArrayList<>();
        private LocalDateTime fechaCreacion;
        public void agregarTicket(Ticket ticket){
            tickets.add(ticket);
        }

        public ArrayList<Ticket> getTickets() {
            return tickets;
        }

        public Ticket() {
        }

        public Ticket(double total) {
            this.total = total;
            this.id = ++nextId;
            this.productosVendidos = new ArrayList<>();
            this.fechaCreacion = LocalDateTime.now();
        }

        public int getId() {
            return id;
        }

        public void setProductosVendidos(ArrayList<Producto> productosVendidos) {
            this.productosVendidos = productosVendidos;
        }

        public String imprimirTicket() {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

            return id + "   " + dtf.format(fechaCreacion) + "    $" + total;
        }
        public String imprimirTicketConPrecio() {
            VentaController ventaController = new VentaController();
            StringBuilder ticketInfo = new StringBuilder();
            ticketInfo.append("Título: Ticket de Venta\n");
            ticketInfo.append("ID del Ticket: ").append(id).append("\n");
            ticketInfo.append("Productos Vendidos:\n");
            for (Producto producto : productosVendidos) {
                ticketInfo.append("- ").append(producto.getNombre()).append(" - Precio: $").append(producto.getPrecio()).append("\n");
            }
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            ticketInfo.append("Fecha de creación: ").append(dtf.format(fechaCreacion)).append("\n");
            ticketInfo.append("Total: $").append(total).append("\n");

            return ticketInfo.toString();
        }



    }


