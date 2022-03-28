package mx.org.corresponsabilidadsocial.api.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.repositories.PostRepository;

@Service
public class PostService {

    
    public List<Post> getPosts() {
        return PostRepository.posts;
    }
    
}
