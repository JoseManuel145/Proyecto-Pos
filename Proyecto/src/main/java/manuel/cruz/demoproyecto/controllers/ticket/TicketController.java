package manuel.cruz.demoproyecto.controllers.ticket;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.Ticket;
import java.util.ArrayList;

public class TicketController {
    @FXML
    private ListView <String> listTicket;
    @FXML
    private Button mostrarTicketButton;
    @FXML
    private Button volverButton;

    public void onMouseClickedMostrarButton(MouseEvent event){
        App.nuevaVentana(event,"/manuel/cruz/demoproyecto/ticket/buscar-ticket", "Busca un Ticket");
    }
    public void onMouseClickedVolverButton(MouseEvent event){
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/menu-principal", "Menu principal");
    }
    @FXML
    public void initialize() {
        ArrayList<Ticket> tickets = App.getTicket().getTickets();
        for (Ticket ticket: tickets){
            listTicket.getItems().add(ticket.imprimirTicket());
        }
    }
}
