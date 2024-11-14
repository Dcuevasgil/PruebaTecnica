package com.vedruna.pruebatecnica.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vedruna.pruebatecnica.DTO.PaisDTO;
import com.vedruna.pruebatecnica.persistance.models.Pais;
import com.vedruna.pruebatecnica.services.PaisServiceI;

@RestController
@RequestMapping("/api/v1/data")
public class PaisController {

    private PaisServiceI paisService;

    public PaisController(PaisServiceI paisService) {
        this.paisService = paisService;
    }
    
    @PostMapping("/country")
    public ResponseEntity<Void> almacenarDatosPoblacionales(@Valid PaisDTO paisDTO, BindingResult result) {
        if(result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            paisService.almacenarDatos(paisDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/country")
    public ResponseEntity<?> obtenerDatosPoblacionales(@RequestParam(required = false) String region, @RequestParam(required = false) Long poblacion) {
        if (region != null && region.length() < 3) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "La región no puede tener menos de 3 caracteres");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); 
        }

        if (poblacion != null && poblacion <= 0) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "La población debe ser un número positivo");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST); 
        }

        
        List<Pais> paises = paisService.obtenerPaisesAlmacenados();

        List<PaisDTO> paisesDTO = paises.stream() 
                                        .map(pais -> new PaisDTO(pais))  
                                        .collect(Collectors.toList());  

        return new ResponseEntity<>(paisesDTO, HttpStatus.OK);
    }

}
