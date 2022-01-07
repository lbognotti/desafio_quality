package br.com.desafio.teste.g8.desafioteste.desafioteste.controller;

import br.com.desafio.teste.g8.desafioteste.desafioteste.dto.PropertyDTO;
import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Property;
import br.com.desafio.teste.g8.desafioteste.desafioteste.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

@RestController
public class AppController {

    private PropertyService propertyService;

    @Autowired
    public AppController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> registerProperty(@Valid @RequestBody PropertyDTO propertyDto) throws URISyntaxException {
        Property propertyCreated = this.propertyService.createProperty(PropertyDTO.toProperty(propertyDto));
        PropertyDTO responseDto = PropertyDTO.toPropDto(propertyCreated);
        return ResponseEntity
                .created(new URI("/properties"))
                .body(responseDto);
    }

    @GetMapping("/area/{roomName}")
    public ResponseEntity<Map<String, Double>> getRoomArea(@PathVariable("roomName") String roomName) {
        return ResponseEntity.ok(this.propertyService.getRoomArea(roomName));
    }
}
    