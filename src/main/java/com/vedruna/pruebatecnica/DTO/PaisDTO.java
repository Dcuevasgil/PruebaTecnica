package com.vedruna.pruebatecnica.DTO;

import lombok.Data;
import com.vedruna.pruebatecnica.persistance.models.Pais;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PaisDTO {

    private int id;
    private String nombre;
    private String poblacion;
    private String region;

    public PaisDTO(Pais pais) {
        this.id = pais.getId().intValue();
        this.nombre = pais.getNombrePais();
        this.poblacion = pais.getPoblacion().toString();
        this.region = pais.getRegionPais();
    }
    
}