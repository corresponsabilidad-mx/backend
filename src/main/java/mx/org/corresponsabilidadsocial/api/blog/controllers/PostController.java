package mx.org.corresponsabilidadsocial.api.blog.controllers;

import mx.org.corresponsabilidadsocial.api.blog.dto.PostDTO;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import mx.org.corresponsabilidadsocial.api.blog.services.PostService;



@RestController
@RequestMapping("/blog")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<?> getPosts() throws Exception {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<?> getPostById(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
    }

    @PostMapping("/post/create")
    public ResponseEntity<?> createPost(@Valid @RequestBody PostDTO postDTO) throws Exception {
        return new ResponseEntity<>(postService.savePost(postDTO), HttpStatus.CREATED);
    }

    
    @PutMapping("post/update/{id}")
    public ResponseEntity<?> updatePost(@PathVariable String id, @Valid @RequestBody PostDTO postDTO) throws Exception {
        return new ResponseEntity<>(postService.updatePost(id, postDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/post/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable String id) throws Exception {
        postService.deletePostById(id);
        return new ResponseEntity<>("deleted", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint(){
        return new ResponseEntity<>("Test get Endpoint is working", HttpStatus.OK);
    }
       
    @GetMapping(path = "/testtoken")
    public String test(Principal principal) {
        return principal.getName();
    }

}