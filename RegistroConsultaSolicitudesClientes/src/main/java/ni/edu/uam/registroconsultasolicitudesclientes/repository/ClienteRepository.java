package ni.edu.uam.registroconsultasolicitudesclientes.repository;
import ni.edu.uam.registroconsultasolicitudesclientes.model.ClienteConsulta;
import java.time.LocalDate;
import java.util.List;

public class ClienteRepository {

    public List<ClienteConsulta> findAll() {

        return List.of(

                new ClienteConsulta(
                        "Andy",
                        "Rueda",
                        "Individual",
                        "Managua",
                        LocalDate.of(1998, 5, 14),
                        "Consulta de información",
                        "Internet, Telefonía",
                        "C:\\Users\\denis\\OneDrive\\Pictures\\Screenshots\\Screenshot 2026-08-24 215851.png"
                ),

                new ClienteConsulta(
                        "Joshua",
                        "Donaire",
                        "Empresa",
                        "Matagalpa",
                        LocalDate.of(1992, 7, 22),
                        "Solicitud de cotización",
                        "Internet, Televisión, Instalación",
                        "C:\\Users\\denis\\OneDrive\\Pictures\\Screenshots\\Screenshot 2026-08-24 215851.png"
                ),

                new ClienteConsulta(
                        "Avril",
                        "Quezada",
                        "Institucional",
                        "Managua",
                        LocalDate.of(1989, 8, 22),
                        "Contratación de servicio",
                        "Internet, Telefonía, Soporte técnico",
                        "C:\\Users\\denis\\OneDrive\\Pictures\\Screenshots\\Screenshot 2026-08-24 215851.png"
                ),

                new ClienteConsulta(
                        "Carlos",
                        "Martínez",
                        "Individual",
                        "Masaya",
                        LocalDate.of(2000, 3, 10),
                        "Soporte técnico",
                        "Internet, Soporte técnico",
                        "C:\\Users\\denis\\OneDrive\\Pictures\\Screenshots\\Screenshot 2026-08-24 215851.png"
                ),

                new ClienteConsulta(
                        "María",
                        "López",
                        "Empresa",
                        "Granada",
                        LocalDate.of(1995, 11, 3),
                        "Reclamo",
                        "Telefonía, Televisión",
                        "C:\\Users\\denis\\OneDrive\\Pictures\\Screenshots\\Screenshot 2026-08-24 215851.png"
                )

        );
    }
}

