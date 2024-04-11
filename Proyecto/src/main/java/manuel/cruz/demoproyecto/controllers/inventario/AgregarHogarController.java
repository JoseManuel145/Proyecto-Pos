package manuel.cruz.demoproyecto.controllers.inventario;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.Producto;
import manuel.cruz.demoproyecto.models.ProductoHogar;


public class AgregarHogarController {

    @FXML
    private Button AgregarButton;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtCategoria;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrecio;
    @FXML
    private Button volverButton;

    public void onMouseClickedCrearButton() {
        String name = txtName.getText();
        String cantidadStr = txtCantidad.getText();
        String precioStr = txtPrecio.getText();
        String categoria = txtCategoria.getText();

        if (name.isEmpty() || cantidadStr.isEmpty() || precioStr.isEmpty() || categoria.isEmpty()) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Todos los campos son obligatorios.");
            return;
        }
        int cantidad;
        double precio;
        try {
            cantidad = Integer.parseInt(cantidadStr);
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Cantidad y Precio deben ser números válidos.");
            return;
        }

        if (cantidad <= 0 || precio <= 0) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Cantidad y Precio deben ser mayores que cero.");
            return;
        }

        Producto productoBeta = new Producto();
        String id = productoBeta.genId();
        ProductoHogar hogar = new ProductoHogar(id, name, cantidad, precio, categoria);
        boolean productoAgregado = App.getInventario().addProduct(hogar);

        if (productoAgregado) {
            App.showAlert(Alert.AlertType.INFORMATION, "Producto Creado", "El producto se creó correctamente.");
        }
    }
    public void onMouseClickedVolverButton(MouseEvent event){
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/inventario/agregarP-inventario", "Elige tipo de producto");
    }
}
