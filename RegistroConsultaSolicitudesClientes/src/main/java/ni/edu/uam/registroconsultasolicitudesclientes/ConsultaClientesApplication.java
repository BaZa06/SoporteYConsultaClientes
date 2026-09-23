package ni.edu.uam.registroconsultasolicitudesclientes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ConsultaClientesApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/ni/edu/uam/registro/consulta-clientes.fxml")
        );
        Parent root = loader.load();

        stage.setTitle("Consulta de Clientes");
        stage.setScene(new Scene(root, 650, 450));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}