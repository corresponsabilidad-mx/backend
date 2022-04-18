package mx.org.corresponsabilidadsocial.api.blog.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.filter.Filter;
import mx.org.corresponsabilidadsocial.api.blog.dto.PostDTO;
import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.exceptions.PostNotFound;
import mx.org.corresponsabilidadsocial.api.blog.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<Post> getPosts() {
        return postRepository.getPosts();
    }

    public void savePost(Post post) {
        postRepository.addPost(post);
    }

    public Post getPostById(Integer id) {
        Optional<Post> opt = postRepository.getPosts()
                .stream()
                .filter(post -> post.getId().equals(id))
                .findFirst();

        return opt.orElseThrow(() -> new PostNotFound(id));
    }

    public Post savePost(PostDTO postDTO) {
        Post newPost = modelMapper.map(postDTO, Post.class);
        return postRepository.addPost(newPost);

    }

    public void deletePostById(Integer id) {
        if (!postRepository.deletePostById(id)) {
            throw new PostNotFound(id);
        }
    }

    public Post updatePost(Integer id, PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        return postRepository.updatePostById(id, post);
    }

}
