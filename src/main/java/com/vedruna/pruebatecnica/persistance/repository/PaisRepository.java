package com.vedruna.pruebatecnica.persistance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vedruna.pruebatecnica.persistance.models.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Long> {

    Pais findByNombrePais(String nombrePais);

    Optional<Pais> findById(Long id);

    List<Pais> findByPoblacion(Long poblacion); 

    List<Pais> findByRegionPais(String regionPais);

    void deleteById(Long id);
}
