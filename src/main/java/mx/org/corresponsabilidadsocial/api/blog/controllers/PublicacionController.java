package mx.org.corresponsabilidadsocial.api.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import mx.org.corresponsabilidadsocial.api.blog.services.PublicacionService;

@RestController
@RequestMapping("/blog")
public class PublicacionController {

    @Autowired
    PublicacionService publicacionService;

    @GetMapping
    public ResponseEntity<?> traerListaPublicaciones() throws Exception{

        return new ResponseEntity<>(publicacionService.traerListaPublicaciones(), HttpStatus.OK);
    
    }
    
}