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

    public void savePost(PostDTO postDTO){
        ModelMapper modelMapper = new ModelMapper();
        Post newPost = modelMapper.map(postDTO, Post.class);
        newPost.setId(1);
        postRepository.addPost(newPost);
    }

}
