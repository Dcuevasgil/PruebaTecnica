import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.pruebatecnica.persistance.models.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

    // Se cambia el nombre para ajustarse al campo en el modelo
    Pais findByNombrePais(String nombrePais);  // findByCountryName -> findByNombrePais

    // Método para encontrar un país por su ID (sin cambios)
    Optional<Pais> findById(Long id);

    // Métodos para encontrar países por región y población (sin cambios)
    List<Pais> findByRegionPais(String region);  // findByRegion -> findByRegionPais
    List<Pais> findByPoblacion(Long poblacion);  // findByPoblacion sigue igual

    List<Pais> findByRegion(String region);

    // El método save ya está incluido en JpaRepository, no es necesario declararlo aquí
    // void save(Long id, String nombrePais, String poblacion);   Se elimina esta línea.

    // Eliminar un país por ID, sin necesidad de una query personalizada.
    void deleteById(Long id);  // JpaRepository ya incluye este método por defecto.
}