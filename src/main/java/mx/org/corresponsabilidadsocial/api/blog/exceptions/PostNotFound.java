package mx.org.corresponsabilidadsocial.api.blog.exceptions;

public class PostNotFound extends RuntimeException {

    public PostNotFound(Integer id) {
        super("Post not found with Id: " + id);
    }

}
