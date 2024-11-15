package com.vedruna.pruebatecnica.persistance.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@Entity
@Table(name = "country_population")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(name = "country_name", nullable = false)
    @NotNull(message = "El nombre del país no puede ser nulo")
    @Size(min = 3, max = 100, message = "El nombre del país debe tener entre 3 y 100 caracteres")
    private String nombrePais;

    @Column(name = "population", nullable = false)
    @NotNull(message = "La población no puede ser nula")
    private Long poblacion;

    @Column(name = "region")
    @Size(max = 50, message = "La región no puede tener más de 50 caracteres")
    private String regionPais;

    @Column(name = "area")
    private Double areaPais;

    public Pais(String nombrePais, Long poblacion, String regionPais) {
        this.nombrePais = nombrePais;
        this.poblacion = poblacion;
        this.regionPais = regionPais;
    }
    
    public Pais(String nombrePais, String poblacion, String regionPais) {
        this.nombrePais = nombrePais;
        this.poblacion = Long.parseLong(poblacion);
        this.regionPais = regionPais;
    }
}