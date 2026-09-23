package ni.edu.uam.registroconsultasolicitudesclientes.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Optional;

public class InicioSeccionController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField pwdPassword;

    @FXML
    private Button btnIniciarSeccion;

    @FXML
    private Button btnSalir;

    @FXML
    private void iniciarSeccion(ActionEvent event) {

        if (txtUsuario.getText().trim().isEmpty()) {
            mostrarAdvertencia(
                    "Campo obligatorio",
                    "Debe ingresar su nombre de usuario."
            );
            txtUsuario.requestFocus();
            return;
        }

        if (pwdPassword.getText().trim().isEmpty()) {
            mostrarAdvertencia(
                    "Campo obligatorio",
                    "Debe ingresar su contraseña."
            );
            pwdPassword.requestFocus();
            return;
        }

        String usuario = txtUsuario.getText().trim();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Inicio de sesión");
        alert.setHeaderText("Inicio de sesión exitoso");
        alert.setContentText("Bienvenido, " + usuario + ".");
        alert.showAndWait();
    }

    @FXML
    private void salirInicioSeccion(ActionEvent event) {

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);

        confirmacion.setTitle("Salir");
        confirmacion.setHeaderText("¿Está seguro de que desea salir?");
        confirmacion.setContentText(
                "La ventana de inicio de sesión se cerrará."
        );

        ButtonType btnSi = new ButtonType("Sí");
        ButtonType btnNo = new ButtonType("No");

        confirmacion.getButtonTypes().setAll(btnSi, btnNo);

        Optional<ButtonType> resultado = confirmacion.showAndWait();

        if (resultado.isPresent() && resultado.get() == btnSi) {
            Stage ventana = (Stage) btnSalir.getScene().getWindow();
            ventana.close();
        }
    }

    private void mostrarAdvertencia(String titulo, String mensaje) {

        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }
}