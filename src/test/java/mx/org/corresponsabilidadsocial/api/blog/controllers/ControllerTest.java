package mx.org.corresponsabilidadsocial.api.blog.controllers;

import java.time.LocalDate;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.MimeTypeUtils;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.entities.Status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;
/*
    @Test
    void findById() throws Exception {
        Post post = createPost();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/blog/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(post)))
                .andExpect(status().isCreated());
        var findById = mockMvc.perform(
                get("/blog/post/1").accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
        var obj = objectMapper.readValue(findById.getResponse().getContentAsString(), Post.class);
        assert obj.getId().equals(1);
       
    }
*/
    private Post createPost() {
        Post post = new Post("un titulo no muy corto", "img/img.jpg", "un texto de por lo menos 100 caracteres " +
                "porque si no da error y no me gustan las peliculas de star wars", Timestamp.now(), Status.PUBLISHED);

        return post;
    }
}
