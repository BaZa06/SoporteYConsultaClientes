package ni.edu.uam.registroconsultasolicitudesclientes.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.stage.Stage;

import java.util.Optional;

public class MenuRegistroController {

    @FXML
    private MenuBar menuBar;

    @FXML
    private void abrirRegistroCliente() {
        abrirVentana("/ni/edu/uam/registroconsultasolicitudesclientes/registro-cliente.fxml", "Registro de Clientes");
    }

    @FXML
    private void abrirSolicitudRegistro() {
        abrirVentana("/ni/edu/uam/registroconsultasolicitudesclientes/consulta-clientes.fxml", "Consulta de Clientes");
    }

    @FXML
    private void salir() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar salida");
        alert.setHeaderText(null);
        alert.setContentText("¿Está seguro que desea salir de la aplicación?");

        Optional<ButtonType> resultado = alert.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            Stage stage = (Stage) menuBar.getScene().getWindow();
            stage.close();
        }
    }

    private void abrirVentana(String rutaFxml, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFxml));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
