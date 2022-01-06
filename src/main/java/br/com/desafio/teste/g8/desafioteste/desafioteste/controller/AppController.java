package br.com.desafio.teste.g8.desafioteste.desafioteste.controller;

import br.com.desafio.teste.g8.desafioteste.desafioteste.entity.Property;
import br.com.desafio.teste.g8.desafioteste.desafioteste.test.unit.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity registerProperty(@RequestBody Property property) throws URISyntaxException {
        return ResponseEntity
                .created(new URI("/properties"))
                .body(this.propertyService.createProperty(property));
    }

    @GetMapping("/area/{roomName}")
    public ResponseEntity<Map<String, Double>> getRoomArea(@PathVariable("roomName") String roomName) {
        return ResponseEntity.ok(this.propertyService.getRoomArea(roomName));
    }
}
    