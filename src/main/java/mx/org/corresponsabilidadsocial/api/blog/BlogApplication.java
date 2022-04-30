package mx.org.corresponsabilidadsocial.api.blog;

import java.text.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BlogApplication {

	public static void main(String[] args) throws ParseException {

		SpringApplication.run(BlogApplication.class, args);

	}

}
