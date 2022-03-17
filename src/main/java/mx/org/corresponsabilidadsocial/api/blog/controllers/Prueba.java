package mx.org.corresponsabilidadsocial.api.blog.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Prueba {

    @GetMapping
    public String Saludo(@RequestParam(required = false, defaultValue = "Mundo") String name){
        return "Hola " + name;
        
    }
    
}