package mx.org.corresponsabilidadsocial.api.blog.validator;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.repositories.PostRepository;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class TitleValidator implements ConstraintValidator<Title, String> {

    private PostRepository postRepository = new PostRepository();


    @Override
    public void initialize(Title constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String title, ConstraintValidatorContext constraintValidatorContext) {
        boolean isUnique = true;
        for (Post post: postRepository.getPosts()) {
            if(title.equalsIgnoreCase(post.getTitle()))
                isUnique = false;
        }
        return isUnique;
    }
}
