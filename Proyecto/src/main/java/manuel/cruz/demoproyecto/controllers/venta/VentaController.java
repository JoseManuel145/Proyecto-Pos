package manuel.cruz.demoproyecto.controllers.venta;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.Producto;
import manuel.cruz.demoproyecto.models.Ticket;
import manuel.cruz.demoproyecto.models.Venta;


public class VentaController {
    @FXML
    private TextField txtDineroIngreso;
    @FXML
    private Label cajaTotal;
    @FXML
    private ListView <String> productosVender;
    @FXML
    private Button agregPButton;
    @FXML
    private Button elimPButton;
    @FXML
    private Button venderButton;
    @FXML
    private Button volverButton;
    @FXML
    private Button actualizarButton;
    private Venta venta;
    private double cambio;
    public void onMouseClickedActualizarButton(){
        venta = App.getVenta();
        productosVender.getItems().clear();

        for (Producto productos: venta.getProductosVender()){
            productosVender.getItems().add(productos.productosEnVenta());
        }
        cajaTotal.setText("Total: $" + venta.calcularTotal());
    }
    public void onMouseClickedAgregarButton(MouseEvent event){
        App.nuevaVentana(event,"/manuel/cruz/demoproyecto/venta/agregarP-venta", "Agrega un producto");
    }
    public void onMouseClickedVenderButton() {
        venta = App.getVenta();

        if (venta.vacio()) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "No hay productos agregados para vender.");
            return;
        }

        String input =  txtDineroIngreso.getText();

        if (input.isEmpty()) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Ingrese el dinero primero");
            return;
        }
        try {
            double dinero = Double.parseDouble(input);
            cambio = dinero - venta.getTotal();
            cajaTotal.setText("CAMBIO: $" + cambio);
        } catch (NumberFormatException e) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Ingrese un valor numérico válido para el dinero");
        }
        Ticket nuevoTicket = venta.finalizarVenta();
        App.getTicket().agregarTicket(nuevoTicket);
    }
    public void onMouseClickedEliminarButton(MouseEvent event){
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/venta/eliminarP-venta", "Elimina un producto");
    }
    public void onMouseClickedVolverButton(MouseEvent event){
        App.nuevaVentana(event, "menu-principal", "Menu principal");

    }
}