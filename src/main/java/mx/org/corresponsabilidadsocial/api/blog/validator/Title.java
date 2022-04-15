package mx.org.corresponsabilidadsocial.api.blog.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TitleValidator.class )
@Documented
public @interface Title {
    String message() default "The title already exists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
