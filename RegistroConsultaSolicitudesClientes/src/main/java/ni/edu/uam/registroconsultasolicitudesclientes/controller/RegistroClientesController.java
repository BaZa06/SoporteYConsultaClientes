package ni.edu.uam.registroconsultasolicitudesclientes.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class RegistroClientesController {

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtApellido;

    @FXML
    private ComboBox<String> cmbTipoClientes;

    @FXML
    private DatePicker dtpFechaNacimiento;

    @FXML
    private RadioButton rbtnConsultaInformacion;

    @FXML
    private RadioButton rbtnSolicitudCotizacion;

    @FXML
    private RadioButton rbtnContratacionServicio;

    @FXML
    private RadioButton rbtnSoporteTecnico;

    @FXML
    private RadioButton rbtnReclamo;

    @FXML
    private RadioButton rbtnOtro;

    private ToggleGroup grupoOpciones;

    @FXML
    private CheckBox chkInternet;

    @FXML
    private CheckBox chkTelefonia;

    @FXML
    private CheckBox chkTelevision;

    @FXML
    private CheckBox chkSoporteTecnico;

    @FXML
    private CheckBox chkInstalacion;

    @FXML
    private ImageView imgFotografia;

    @FXML
    private Button btnSeleccionarFoto;

    @FXML
    private TextField txtSeleccionarFoto;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnLimpiar;


    @FXML
    private void initialize(){
        cmbTipoClientes.getItems().addAll("Individual", "Empresa", "Institucional");
        txtNombre.setPromptText("Escriba sus nombres");
        txtApellido.setPromptText("Escriba sus apellidos");
        txtSeleccionarFoto.setPromptText("Ruta de la fotografía");

        grupoOpciones = new ToggleGroup();

        rbtnConsultaInformacion.setToggleGroup(grupoOpciones);
        rbtnSolicitudCotizacion.setToggleGroup(grupoOpciones);
        rbtnContratacionServicio.setToggleGroup(grupoOpciones);
        rbtnSoporteTecnico.setToggleGroup(grupoOpciones);
        rbtnReclamo.setToggleGroup(grupoOpciones);
        rbtnOtro.setToggleGroup(grupoOpciones);
    }

    @FXML
    private void seleccionarFoto() {

        FileChooser fc = new FileChooser();

        fc.setTitle("Seleccionar fotografía");

        fc.getExtensionFilters().add(
                new FileChooser.ExtensionFilter(
                        "Imágenes",
                        "*.png",
                        "*.jpg",
                        "*.jpeg",
                        "*.gif"
                )
        );

        File file = fc.showOpenDialog(
                txtSeleccionarFoto.getScene().getWindow()
        );

        if (file != null) {


            txtSeleccionarFoto.setText(file.getAbsolutePath());

            Image imagen = new Image(file.toURI().toString());

            imgFotografia.setImage(imagen);
        }
    }


    @FXML
    private boolean validarFormulario() {

        if (txtNombre.getText().trim().isEmpty()) {

            mostrarAdvertencia(
                    "Campo obligatorio",
                    "Debe ingresar los nombres del cliente."
            );

            txtNombre.requestFocus();

            return false;
        }


        if (txtApellido.getText().trim().isEmpty()) {

            mostrarAdvertencia(
                    "Campo obligatorio",
                    "Debe ingresar los apellidos del cliente."
            );

            txtApellido.requestFocus();

            return false;
        }


        if (cmbTipoClientes.getValue() == null) {

            mostrarAdvertencia(
                    "Campo obligatorio",
                    "Debe seleccionar el tipo de cliente."
            );

            cmbTipoClientes.requestFocus();

            return false;
        }


        if (dtpFechaNacimiento.getValue() == null) {

            mostrarAdvertencia(
                    "Campo obligatorio",
                    "Debe seleccionar la fecha de nacimiento."
            );

            dtpFechaNacimiento.requestFocus();

            return false;
        }


        if (grupoOpciones.getSelectedToggle() == null) {

            mostrarAdvertencia(
                    "Campo obligatorio",
                    "Debe seleccionar un tipo de solicitud."
            );

            return false;
        }


        if (txtSeleccionarFoto.getText().trim().isEmpty()) {

            mostrarAdvertencia(
                    "Campo obligatorio",
                    "Debe seleccionar una fotografía."
            );

            return false;
        }

        return true;
    }

    @FXML
    private void guardarSolicitud() {

        if (!validarFormulario()) {
            return;
        }

        Alert confirmacion = new Alert(
                Alert.AlertType.CONFIRMATION
        );

        confirmacion.setTitle("Confirmación");
        confirmacion.setHeaderText(
                "¿Está seguro de registrar este cliente?"
        );

        confirmacion.setContentText(
                "Nombre: " + txtNombre.getText() +
                        "\nApellido: " + txtApellido.getText() +
                        "\nTipo de cliente: " + cmbTipoClientes.getValue() +
                        "\nFecha de nacimiento: " + dtpFechaNacimiento.getValue()
        );

        Optional<ButtonType> resultado =
                confirmacion.showAndWait();

        if (resultado.isPresent()
                && resultado.get() == ButtonType.OK) {

            System.out.println(
                    "Cliente registrado: "
                            + txtNombre.getText()
            );

            Alert alert = new Alert(
                    Alert.AlertType.INFORMATION
            );

            alert.setTitle("Registro exitoso");
            alert.setHeaderText(
                    "Cliente registrado exitosamente"
            );

            alert.setContentText(
                    "Nombre: " + txtNombre.getText() +
                            "\nApellido: " + txtApellido.getText() +
                            "\nTipo de cliente: " + cmbTipoClientes.getValue() +
                            "\nFecha de nacimiento: " +
                            dtpFechaNacimiento.getValue()
            );

            alert.showAndWait();
        }
    }

    @FXML
    private void limpiarControles(ActionEvent actionEvent) {

        txtNombre.clear();

        txtApellido.clear();

        cmbTipoClientes.getSelectionModel().clearSelection();

        dtpFechaNacimiento.setValue(null);

        txtSeleccionarFoto.clear();

        // Limpiar imagen
        imgFotografia.setImage(null);

        // Quitar RadioButton seleccionado
        grupoOpciones.selectToggle(null);

        // Limpiar CheckBox
        chkInternet.setSelected(false);
        chkTelefonia.setSelected(false);
        chkTelevision.setSelected(false);
        chkSoporteTecnico.setSelected(false);
        chkInstalacion.setSelected(false);

        txtNombre.requestFocus();
    }

    @FXML
    private void cancelarSolicitud() {

        Alert confirmacion = new Alert(
                Alert.AlertType.CONFIRMATION
        );

        confirmacion.setTitle("Cancelar registro");

        confirmacion.setHeaderText(
                "¿Está seguro de cancelar?"
        );

        confirmacion.setContentText(
                "Si cancela, se cerrará el formulario."
        );

        ButtonType btnSi = new ButtonType(
                "Sí"
        );

        ButtonType btnNo = new ButtonType(
                "No"
        );

        confirmacion.getButtonTypes().setAll(
                btnSi,
                btnNo
        );

        Optional<ButtonType> resultado =
                confirmacion.showAndWait();

        if (resultado.isPresent()
                && resultado.get() == btnSi) {

            Stage ventana =
                    (Stage) btnCancelar.getScene().getWindow();

            ventana.close();
        }
    }


    private void mostrarAdvertencia(
            String titulo,
            String mensaje) {

        Alert alert = new Alert(
                Alert.AlertType.WARNING
        );

        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.showAndWait();
    }

}
