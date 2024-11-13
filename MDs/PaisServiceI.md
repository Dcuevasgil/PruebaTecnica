import java.util.List;

import org.springframework.stereotype.Service;

import com.vedruna.pruebatecnica.DTO.PaisDTO;
import com.vedruna.pruebatecnica.persistance.models.Pais;

@Service
public interface PaisServiceI {

    // Almacenar datos de un país
    void almacenarDatos(PaisDTO paisDTO);

    // Obtener un país por su nombre (devuelve un PaisDTO para separar el modelo y la lógica)
    PaisDTO obtenerPaisPorNombre(String nombre);

    // Almacenar datos de un país
    List<Pais> obtenerPaisesAlmacenados();

    // Eliminar un país por su ID
    void eliminarPais(Long id);

    // Obtener un país por su ID (puede devolver un PaisDTO)
    PaisDTO obtenerPais(Long id);

    // Obtener países por su región (devolver List<PaisDTO> si trabajas con DTOs)
    List<PaisDTO> obtenerPaisesPorRegion(String region);

    // Obtener países por su población (devolver List<PaisDTO> si trabajas con DTOs)
    List<PaisDTO> obtenerPaisesPorPoblacion(Long poblacion);
}