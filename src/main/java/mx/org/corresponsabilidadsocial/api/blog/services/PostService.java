package mx.org.corresponsabilidadsocial.api.blog.services;

import java.util.List;

import mx.org.corresponsabilidadsocial.api.blog.dto.PostDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<Post> getPosts() {
        return postRepository.getPosts();
    }

    public boolean exists(Integer id) {
        if (postRepository.existsById(id)) {

            return true;
        }
        return false;
    }

    public Post savePost(PostDTO postDTO){
        Post newPost = modelMapper.map(postDTO, Post.class);
        return postRepository.addPost(newPost);
    }

    public void deletePostById(Integer id){
        postRepository.deletePostById(id);
    }

    public Post updatePost(Integer id, PostDTO postDTO){
        Post post = modelMapper.map(postDTO, Post.class);
        return postRepository.updatePostById(id, post);
    }

}
