package mx.org.corresponsabilidadsocial.api.blog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    public List<Post> getPosts() {
        return postRepository.getPosts();
    }

    public boolean exists(Integer id) {
        if (postRepository.existsById(id)) {

            return true;
        }
        return false;
    }

    public Object getPostById(Integer id) {
        return null;
    }

}
