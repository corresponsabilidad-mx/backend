package mx.org.corresponsabilidadsocial.api.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;


import mx.org.corresponsabilidadsocial.api.blog.services.PublicacionService;

@RestController
public class PublicacionController {

    @Autowired
    PublicacionService publicacionService;

    @GetMapping
    public ResponseEntity<?> Post() throws Exception{

        return new ResponseEntity<>(publicacionService.traerListaPublicaciones(), HttpStatus.OK);
    
    }
    
}