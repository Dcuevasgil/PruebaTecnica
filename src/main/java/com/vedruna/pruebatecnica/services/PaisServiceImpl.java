package com.vedruna.pruebatecnica.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vedruna.pruebatecnica.DTO.PaisDTO;
import com.vedruna.pruebatecnica.persistance.models.Pais;
import com.vedruna.pruebatecnica.persistance.repository.PaisRepository;

@Service
public class PaisServiceImpl implements PaisServiceI {

    @Autowired
    private PaisRepository paisRepo;

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
    public List<PaisDTO> obtenerPaisesPorRegion(String regionPais) {
        List<Pais> paises = paisRepo.findByRegionPais(regionPais);
        return paises.stream().map(PaisDTO::new).collect(Collectors.toList()); // Mapear a PaisDTO
    }

    @Override
    public List<PaisDTO> obtenerPaisesPorPoblacion(Long poblacion) {
        List<Pais> paises = paisRepo.findByPoblacion(poblacion);
        return paises.stream().map(PaisDTO::new).collect(Collectors.toList()); // Mapear a PaisDTO
    }


    @Override
    public void almacenarDatos(Pais pais) {
        paisRepo.save(pais);
    }


    @Override
    public List<Pais> obtenerPaisesAlmacenados() {
        return paisRepo.findAll();
    }
}