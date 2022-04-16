package mx.org.corresponsabilidadsocial.api.blog.controllers;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.exceptions.PostNotFound;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException.NotFound;

import mx.org.corresponsabilidadsocial.api.blog.services.PostService;

@RestController
@RequestMapping("/blog")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<?> getPosts() {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @PostMapping("/post")
    public ResponseEntity<?> createPost(@Valid @RequestBody Post post) {
        postService.savePost(post);
        return new ResponseEntity<>("Se ha publicado su post", HttpStatus.CREATED);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<?> getPostById(@PathVariable Integer id) {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

}