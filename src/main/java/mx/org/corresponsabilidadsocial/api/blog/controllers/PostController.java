package mx.org.corresponsabilidadsocial.api.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import mx.org.corresponsabilidadsocial.api.blog.services.PostService;

@RestController
@RequestMapping("/blog")
public class PostController {

    @Autowired
    PostService PostService;

    @GetMapping("/posts")
    public ResponseEntity<?> getPosts() throws Exception{

        return new ResponseEntity<>(PostService.getPosts(), HttpStatus.OK);
    
    }
    
}