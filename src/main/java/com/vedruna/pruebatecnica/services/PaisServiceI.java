package com.vedruna.pruebatecnica.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.vedruna.pruebatecnica.DTO.PaisDTO;
import com.vedruna.pruebatecnica.persistance.models.Pais;

@Service
public interface PaisServiceI {

    PaisDTO obtenerPaisPorNombre(String nombre);

    List<Pais> obtenerPaisesAlmacenados();

    void eliminarPais(Long id);

    void almacenarDatos(PaisDTO paisDTO);

    PaisDTO obtenerPais(Long id);

    List<PaisDTO> obtenerPaisesPorRegion(String regionPais);

    List<PaisDTO> obtenerPaisesPorPoblacion(Long poblacion);
}
