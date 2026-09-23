package ni.edu.uam.registroconsultasolicitudesclientes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuRegistroApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("menu-principal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Menú Principal");
        stage.setScene(scene);
        stage.show();
    }
}

