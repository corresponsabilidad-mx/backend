package mx.org.corresponsabilidadsocial.api.blog;



import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.repositories.PostRepository;




@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) throws ParseException {

		
		LocalDate localDate = LocalDate.now(ZoneOffset.UTC);
		
		PostRepository.posts.add(new Post(1, "titulo", "imagen", "cuerpoTexto", localDate , true));
		
		SpringApplication.run(BlogApplication.class, args);
		
	}

}
