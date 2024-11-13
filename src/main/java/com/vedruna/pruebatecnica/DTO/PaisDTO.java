package com.vedruna.pruebatecnica.DTO;

import lombok.Data;
import com.vedruna.pruebatecnica.persistance.models.Pais;
import lombok.NoArgsConstructor;

@Data /* @Data es una anotación de Lombok que genera automáticamente los métodos getter, setter, toString(), equals(), y hashCode() para los campos de la clase. */
@NoArgsConstructor /* La anotación @NoArgsConstructor también es de Lombok y genera un constructor sin argumentos. Esto es útil cuando necesitas crear instancias de la clase sin pasarle parámetros. */
public class PaisDTO {

    private int id;
    private String nombre;
    private String poblacion;
    private String region;

    // Constructor para convertir de Pais a PaisDTO
    public PaisDTO(Pais pais) {
        this.id = pais.getId().intValue();
        this.nombre = pais.getNombrePais();
        this.poblacion = pais.getPoblacion().toString();
        this.region = pais.getRegionPais();
    }
    
}