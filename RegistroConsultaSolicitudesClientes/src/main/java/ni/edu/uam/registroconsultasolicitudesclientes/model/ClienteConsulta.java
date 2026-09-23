package ni.edu.uam.registroconsultasolicitudesclientes.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class ClienteConsulta {

    private final StringProperty nombres = new SimpleStringProperty();
    private final StringProperty apellidos = new SimpleStringProperty();
    private final StringProperty nombreCompleto = new SimpleStringProperty();
    private final StringProperty tipoCliente = new SimpleStringProperty();
    private final StringProperty ciudad = new SimpleStringProperty();
    private final StringProperty fechaNacimiento = new SimpleStringProperty();
    private final StringProperty tipoSolicitud = new SimpleStringProperty();
    private final StringProperty serviciosInteres = new SimpleStringProperty();
    private final StringProperty fotografia = new SimpleStringProperty();

    public ClienteConsulta(
            String nombres,
            String apellidos,
            String tipoCliente,
            String ciudad,
            LocalDate fechaNacimiento,
            String tipoSolicitud,
            String serviciosInteres,
            String fotografia
    ) {
        this.nombres.set(nombres);
        this.apellidos.set(apellidos);
        this.nombreCompleto.set(nombres + " " + apellidos);
        this.tipoCliente.set(tipoCliente);
        this.ciudad.set(ciudad);
        this.fechaNacimiento.set(fechaNacimiento.toString());
        this.tipoSolicitud.set(tipoSolicitud);
        this.serviciosInteres.set(serviciosInteres);
        this.fotografia.set(fotografia);
    }

    public String getNombres() {
        return nombres.get();
    }

    public StringProperty nombresProperty() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres.set(nombres);
        actualizarNombreCompleto();
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public StringProperty apellidosProperty() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos.set(apellidos);
        actualizarNombreCompleto();
    }

    public String getNombreCompleto() {
        return nombreCompleto.get();
    }

    public StringProperty nombreCompletoProperty() {
        return nombreCompleto;
    }

    public String getTipoCliente() {
        return tipoCliente.get();
    }

    public StringProperty tipoClienteProperty() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente.set(tipoCliente);
    }

    public String getCiudad() {
        return ciudad.get();
    }

    public StringProperty ciudadProperty() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad.set(ciudad);
    }

    public String getFechaNacimiento() {
        return fechaNacimiento.get();
    }

    public StringProperty fechaNacimientoProperty() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento.set(fechaNacimiento.toString());
    }

    public String getTipoSolicitud() {
        return tipoSolicitud.get();
    }

    public StringProperty tipoSolicitudProperty() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud.set(tipoSolicitud);
    }

    public String getServiciosInteres() {
        return serviciosInteres.get();
    }

    public StringProperty serviciosInteresProperty() {
        return serviciosInteres;
    }

    public void setServiciosInteres(String serviciosInteres) {
        this.serviciosInteres.set(serviciosInteres);
    }

    public String getFotografia() {
        return fotografia.get();
    }

    public StringProperty fotografiaProperty() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia.set(fotografia);
    }

    private void actualizarNombreCompleto() {
        this.nombreCompleto.set(
                nombres.get() + " " + apellidos.get()
        );
    }
}
