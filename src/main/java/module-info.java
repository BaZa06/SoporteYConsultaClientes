module ni.edu.uam.soporteyconsultaclientes {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.soporteyconsultaclientes to javafx.fxml;
    exports ni.edu.uam.soporteyconsultaclientes;
}