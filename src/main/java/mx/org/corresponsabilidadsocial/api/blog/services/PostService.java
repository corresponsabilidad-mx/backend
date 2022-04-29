package mx.org.corresponsabilidadsocial.api.blog.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.org.corresponsabilidadsocial.api.blog.dto.PostDTO;
import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.exceptions.Duplicated;
import mx.org.corresponsabilidadsocial.api.blog.exceptions.NotFound;

import mx.org.corresponsabilidadsocial.api.blog.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;

    ModelMapper modelMapper = new ModelMapper();

    public List<Post> getPosts() throws Exception {
        return postRepository.getPosts();
    }

    public Post getPostById(String id) throws Exception {
        Optional<Post> opt = postRepository.getPosts()
                .stream()
                .filter(post -> post.getId().equals(id))
                .findFirst();

        return opt.orElseThrow(() -> new NotFound(id));
    }

    public String savePost(PostDTO postDTO) throws Exception {
        Post newPost = modelMapper.map(postDTO, Post.class);
        Boolean isDup = postRepository.getPosts().stream()
                .filter(p -> p.getTitle().equals(newPost.getTitle()))
                .findFirst()
                .isPresent();
        if (!isDup) {
            return postRepository.addPost(newPost);
        }
        throw new Duplicated();
    }

    public void deletePostById(String id) throws Exception {
        Optional<Post> opt = postRepository.getPosts()
                .stream()
                .filter(post -> post.getId().equals(id))
                .findFirst();
        if (!opt.isPresent()) {
            throw new NotFound(id);
        }
        postRepository.deletePostById(opt.get().getId());
    }

    public String updatePost(String id, PostDTO postDTO) throws Exception {
        Post post = modelMapper.map(postDTO, Post.class);
        return postRepository.updatePostById(id, post);
    }
}
