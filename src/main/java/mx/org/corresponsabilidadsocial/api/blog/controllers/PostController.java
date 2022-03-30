package mx.org.corresponsabilidadsocial.api.blog.controllers;

import mx.org.corresponsabilidadsocial.api.blog.dto.PostDTO;
import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import mx.org.corresponsabilidadsocial.api.blog.services.PostService;

@RestController
@RequestMapping("/blog")
public class PostController {

    @Autowired
    PostService PostService;

    @GetMapping("/posts")
    public ResponseEntity<?> getPosts() throws Exception {

        if (!PostService.getPosts().isEmpty()) {
            return new ResponseEntity<>(PostService.getPosts(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/newPost")
    public ResponseEntity<?> createPost(@RequestBody Post post){
        if(post == null){
            return new ResponseEntity<>("el post esta vacío", HttpStatus.OK);
        }
        PostService.savePost(post);
        return new ResponseEntity<>("Se ha publicado su post", HttpStatus.CREATED);
    }

}