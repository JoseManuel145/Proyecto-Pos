package manuel.cruz.demoproyecto.controllers.ticket;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.Ticket;

public class BuscarTicketController {
    @FXML
    private ListView <String> mostrarTicket;
    @FXML
    private Button volverButton;
    @FXML
    private TextField txtIdBuscar;
    @FXML
    private Button buscarButton;
    public void onMouseClickedBuscarButton(){
        String idBuscar = txtIdBuscar.getText();
        Ticket ticketEncontrado = buscarTicket(idBuscar);
        if (ticketEncontrado != null) {
            mostrarTicket.getItems().add(ticketEncontrado.imprimirTicketConPrecio());
        } else {
            mostrarTicket.getItems().add("Ticket no encontrado.");
        }
    }
    public void onMouseClickedVolverButton(MouseEvent event){
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/ticket/menu-ticket", "Elige tipo de producto");
    }
    public Ticket buscarTicket(String id) {
        for (Ticket ticket : App.getTicket().getTickets()) {
            if (id.equals(String.valueOf(ticket.getId()))) {
                return ticket;
            }
        }
        return null;
    }
}
