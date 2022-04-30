package mx.org.corresponsabilidadsocial.api.blog.controllers;

import mx.org.corresponsabilidadsocial.api.blog.dto.PostDTO;

import java.util.List;

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
    public ResponseEntity<List<PostDTO>> getPosts() throws Exception {
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
        return ResponseEntity.ok(postService.updatePost(id, postDTO));
    }

    @DeleteMapping("/post/delete/{id}")
    public ResponseEntity<?> deletePost(@PathVariable String id) throws Exception {
        postService.deletePostById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/test")
    public ResponseEntity<String> testGetEndpoint(){
        return ResponseEntity.ok("Test get Endpoint is working");
    }
       

}