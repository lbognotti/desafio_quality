package br.com.desafio.teste.g8.desafioteste.desafioteste.controller;

import br.com.desafio.teste.g8.desafioteste.desafioteste.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    private PropertyService propertyService;

    @Autowired
    public AppController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }
}
