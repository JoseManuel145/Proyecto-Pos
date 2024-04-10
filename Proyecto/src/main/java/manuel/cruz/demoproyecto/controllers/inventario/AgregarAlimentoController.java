package manuel.cruz.demoproyecto.controllers.inventario;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import manuel.cruz.demoproyecto.App;
import manuel.cruz.demoproyecto.models.Producto;
import manuel.cruz.demoproyecto.models.ProductoAlimento;

public class AgregarAlimentoController {

    @FXML
    private Button AgregarButton;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TextField txtFecha;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtPrecio;
    @FXML
    private Button volverButton;
    public void onMouseClickedVolverButton(MouseEvent event){
        App.nuevaVentana(event, "/manuel/cruz/demoproyecto/inventario/agregarP-inventario", "Elige tipo de producto");
    }
    public void onMouseClickedAgregarButton() {
        String nombre = txtName.getText();
        String cantidadStr = txtCantidad.getText();
        String caducidad = txtFecha.getText();
        String precioStr = txtPrecio.getText();

        // Validar que los campos no estén vacíos
        if (nombre.isEmpty() || cantidadStr.isEmpty() || caducidad.isEmpty() || precioStr.isEmpty()) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Todos los campos son obligatorios.");
            return;
        }

        // Validar que la cantidad y el precio sean números válidos
        int cantidad;
        double precio;
        try {
            cantidad = Integer.parseInt(cantidadStr);
            precio = Double.parseDouble(precioStr);
        } catch (NumberFormatException e) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Cantidad y Precio deben ser números válidos.");
            return;
        }

        // Validar que la cantidad y el precio sean positivos
        if (cantidad <= 0 || precio <= 0) {
            App.showAlert(Alert.AlertType.ERROR, "Error", "Cantidad y Precio deben ser mayores que cero.");
            return;
        }

        // Si todos los campos son válidos, agregar el producto al inventario
        Producto productoBeta = new Producto();
        String id = productoBeta.genId();
        ProductoAlimento alimento = new ProductoAlimento(id, nombre, cantidad, precio, caducidad);
        System.out.println(id);
        boolean productoAgregado = App.getInventario().addProduct(alimento);

        if (productoAgregado) {
            App.showAlert(Alert.AlertType.INFORMATION, "Producto Agregado", "El producto se agregó correctamente.");
        } else {
            App.showAlert(Alert.AlertType.ERROR, "Error", "No se pudo agregar el producto.");
        }
    }

}
