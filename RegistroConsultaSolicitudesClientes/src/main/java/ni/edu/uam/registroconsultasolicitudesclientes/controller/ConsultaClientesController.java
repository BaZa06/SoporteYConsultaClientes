package ni.edu.uam.registroconsultasolicitudesclientes.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import ni.edu.uam.registroconsultasolicitudesclientes.model.ClienteConsulta;
import ni.edu.uam.registroconsultasolicitudesclientes.repository.ClienteRepository;

public class ConsultaClientesController {

    private static final ObservableList<ClienteConsulta> listaClientes =
            FXCollections.observableArrayList();

    private final ClienteRepository clienteRepository =
            new ClienteRepository();

    @FXML
    private TableView<ClienteConsulta> tblClientes;

    @FXML
    private TableColumn<ClienteConsulta, String> colNombre;

    @FXML
    private TableColumn<ClienteConsulta, String> colTipoCliente;

    @FXML
    private TableColumn<ClienteConsulta, String> colCiudad;

    @FXML
    private TableColumn<ClienteConsulta, String> colFechaNacimiento;

    @FXML
    private TableColumn<ClienteConsulta, String> colTipoSolicitud;

    @FXML
    public void initialize() {

        configurarColumnas();

        if (listaClientes.isEmpty()) {
            listaClientes.addAll(clienteRepository.findAll());
        }

        tblClientes.setItems(listaClientes);
    }

    private void configurarColumnas() {

        colNombre.setCellValueFactory(
                data -> data.getValue().nombreCompletoProperty()
        );

        colTipoCliente.setCellValueFactory(
                data -> data.getValue().tipoClienteProperty()
        );

        colCiudad.setCellValueFactory(
                data -> data.getValue().ciudadProperty()
        );

        colFechaNacimiento.setCellValueFactory(
                data -> data.getValue().fechaNacimientoProperty()
        );

        colTipoSolicitud.setCellValueFactory(
                data -> data.getValue().tipoSolicitudProperty()
        );
    }

    public static void agregarCliente(ClienteConsulta cliente) {
        listaClientes.add(cliente);
    }

    @FXML
    private void abrirConsultaClientes(MouseEvent event) {

        if (event.getClickCount() == 2) {

            ClienteConsulta seleccionado =
                    tblClientes.getSelectionModel().getSelectedItem();

            if (seleccionado != null) {

                System.out.println(
                        "Cliente seleccionado: "
                                + seleccionado.getNombreCompleto()
                );
            }
        }
    }

    @FXML
    private void cerrarConsulta() {

        Stage stage =
                (Stage) tblClientes.getScene().getWindow();

        stage.close();
    }
}
