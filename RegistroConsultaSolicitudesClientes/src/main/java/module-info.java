module ni.edu.uam.registroconsultasolicitudesclientes {
    requires javafx.controls;
    requires javafx.fxml;


    opens ni.edu.uam.registroconsultasolicitudesclientes to javafx.fxml;
    exports ni.edu.uam.registroconsultasolicitudesclientes;
}