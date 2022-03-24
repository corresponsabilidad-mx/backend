package mx.org.corresponsabilidadsocial.api.blog;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import mx.org.corresponsabilidadsocial.api.blog.entities.Publicacion;
import mx.org.corresponsabilidadsocial.api.blog.repositories.PublicacionRepository;




@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {

		
		
		PublicacionRepository.publicaciones.add(new Publicacion(1, "titulo", "imagen", "cuerpoTexto", "fechaPublicacion", true));
		
		SpringApplication.run(BlogApplication.class, args);
		
	}

}
