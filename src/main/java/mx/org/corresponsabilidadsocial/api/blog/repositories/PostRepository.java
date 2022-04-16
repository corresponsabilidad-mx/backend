package mx.org.corresponsabilidadsocial.api.blog.repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Repository;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.entities.Status;
import mx.org.corresponsabilidadsocial.api.blog.exceptions.PostNotFound;

@Repository
public class PostRepository {

    private List<Post> posts = new ArrayList<>();

    public PostRepository() {
        posts.add(new Post(1, "title", "img/image.jpg", "test text", LocalDate.now(), Status.PUBLISHED));
        posts.add(new Post(2, "hi!", "img/otherimage.jpg", "test text 1", LocalDate.now(), Status.PUBLISHED));
        posts.add(new Post(3, "bye", "img/img2.jpg", "test text 2", LocalDate.now(), Status.PUBLISHED));
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }

    public Post getPostById(Integer id) {

        return posts.get(id);
            
        
     
    }
}
