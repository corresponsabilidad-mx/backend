package mx.org.corresponsabilidadsocial.api.blog.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.entities.Status;
import mx.org.corresponsabilidadsocial.api.blog.repositories.PostRepository;
import mx.org.corresponsabilidadsocial.api.blog.services.PostService;

@WebMvcTest(PostController.class)
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService service;

    @MockBean
    private PostRepository repo;

    @Test
    public void getAllPosts() throws Exception {

        List<Post> posts = new ArrayList<>();

        posts.add(new Post(1, "title", "img/image.jpg", "test text", LocalDate.now(), Status.PUBLISHED));
        posts.add(new Post(2, "hi!", "img/otherimage.jpg", "test text 1", LocalDate.now(), Status.PUBLISHED));
        posts.add(new Post(3, "bye", "img/img2.jpg", "test text 2", LocalDate.now(), Status.PUBLISHED));

        Mockito.when(service.getPosts()).thenReturn(posts);

        mockMvc.perform(get("/blog/posts")).andExpect(status().isOk());

    }

    @Test
    public void testGetPostById() throws Exception {
        Post post = new Post(1, "title", "img/image.jpg", "test text", LocalDate.now(), Status.PUBLISHED);

        Mockito.when(service.getPostById(1)).thenReturn(post);

        mockMvc.perform(get("/blog/post/{id}", 1)).andExpect(status().isOk());
    }

}
