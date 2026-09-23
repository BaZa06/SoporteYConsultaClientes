package ni.edu.uam.registroconsultasolicitudesclientes.model;

public class Cliente {


    private String nombre;
    private String apellido;
    private String tipoClientes;
    private String fechaNacimiento;
    private String tipoSolicitud;
    private String servicioInteres;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, String tipoClientes, String fechaNacimiento, String tipoSolicitud, String servicioInteres) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoClientes = tipoClientes;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoSolicitud = tipoSolicitud;
        this.servicioInteres = servicioInteres;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoClientes() {
        return tipoClientes;
    }

    public void setTipoClientes(String tipoClientes) {
        this.tipoClientes = tipoClientes;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSolicitud() {
        return tipoSolicitud;
    }

    public void setTipoSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    public String getServicioInteres() {
        return servicioInteres;
    }

    public void setServicioInteres(String servicioInteres) {
        this.servicioInteres = servicioInteres;
    }
}
