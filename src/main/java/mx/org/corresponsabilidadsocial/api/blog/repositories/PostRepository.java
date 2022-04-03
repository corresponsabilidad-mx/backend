package mx.org.corresponsabilidadsocial.api.blog.repositories;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.entities.Status;
import mx.org.corresponsabilidadsocial.api.blog.exceptions.NotFoundException;

@Repository
public class PostRepository {

    private List<Post> posts = new ArrayList<>();

    public PostRepository() {
        posts.add(new Post(1, "title", "img/image.jpg", "test text", LocalDate.now(), Status.PUBLISHED));
        posts.add(new Post(1, "hi!", "img/otherimage.jpg", "test text 1", LocalDate.now(), Status.PUBLISHED));
        posts.add(new Post(1, "bye", "img/img2.jpg", "test text 2", LocalDate.now(), Status.PUBLISHED));
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public boolean existsById(Integer id) {

        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Post getPostById(Integer id) {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getId().equals(id)) {
                return posts.get(i);
            }
        }
        throw new NotFoundException();
    }

    

}
