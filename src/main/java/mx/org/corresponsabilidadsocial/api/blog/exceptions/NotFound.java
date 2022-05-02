package mx.org.corresponsabilidadsocial.api.blog.exceptions;

public class NotFound extends RuntimeException {

    public NotFound(String id) {
        super("Post not found with Id: " + id);
    }

    

}
