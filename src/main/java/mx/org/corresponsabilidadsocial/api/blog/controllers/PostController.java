package mx.org.corresponsabilidadsocial.api.blog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.org.corresponsabilidadsocial.api.blog.exceptions.NotFoundException;
import mx.org.corresponsabilidadsocial.api.blog.services.PostService;

@RestController
@RequestMapping("/blog")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<?> getPosts() throws Exception {

        if (!postService.getPosts().isEmpty()) {
            return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
        }

        throw new NotFoundException();
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<?> getPostById (@PathVariable Integer id){
        
        if (postService.exists(id)){
            return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
        }
        throw new NotFoundException();
    }

    

}