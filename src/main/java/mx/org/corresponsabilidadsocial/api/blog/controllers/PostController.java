package mx.org.corresponsabilidadsocial.api.blog.controllers;

import mx.org.corresponsabilidadsocial.api.blog.dto.PostDTO;
import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.exceptions.NotFoundException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import mx.org.corresponsabilidadsocial.api.blog.services.PostService;

@Validated
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

    @PostMapping("/newPost")
    public ResponseEntity<Post> createPost(@Valid @RequestBody Post post){
        return new ResponseEntity<>(postService.savePost(post), HttpStatus.CREATED);
    }

}