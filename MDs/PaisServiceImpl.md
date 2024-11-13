import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.pruebatecnica.DTO.PaisDTO;
import com.vedruna.pruebatecnica.persistance.models.Pais;
import com.vedruna.pruebatecnica.persistance.repository.PaisRepositoryI;

@Service
public class PaisServiceImpl implements PaisServiceI {

    @Autowired
    private PaisRepositoryI paisRepo;

    @Override
    public PaisDTO obtenerPaisPorNombre(String nombre) {
        Pais pais = paisRepo.findByNombrePais(nombre);
        return pais != null ? new PaisDTO(pais) : null; // Devuelve PaisDTO
    }

    
    @Override
    public void eliminarPais(Long id) {
        paisRepo.deleteById(id);
    }

    @Override
    public PaisDTO obtenerPais(Long id) {
        Optional<Pais> paisOpt = paisRepo.findById(id);
        return paisOpt.map(PaisDTO::new).orElse(null); // Mapear a PaisDTO si se encuentra
    }

    @Override
    public List<PaisDTO> obtenerPaisesPorRegion(String region) {
        List<Pais> paises = paisRepo.findByRegion(region);
        return paises.stream().map(PaisDTO::new).collect(Collectors.toList()); // Mapear a PaisDTO
    }

    @Override
    public List<PaisDTO> obtenerPaisesPorPoblacion(Long poblacion) {
        List<Pais> paises = paisRepo.findByPoblacion(poblacion);
        return paises.stream().map(PaisDTO::new).collect(Collectors.toList()); // Mapear a PaisDTO
    }


    @Override
    public void almacenarDatos(PaisDTO paisDTO) {
        paisRepo.save(new Pais(paisDTO));
    }


    @Override
    public List<Pais> obtenerPaisesAlmacenados() {
        return paisRepo.findAll();
    }
}