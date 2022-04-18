package mx.org.corresponsabilidadsocial.api.blog.exceptions;

public class NotFound extends RuntimeException {

    public NotFound(Integer id) {
        super("Post not found with Id: " + id);
    }

    public NotFound(String message) {
        super();
    }

}
