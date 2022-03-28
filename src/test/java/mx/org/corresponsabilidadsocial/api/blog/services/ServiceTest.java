package mx.org.corresponsabilidadsocial.api.blog.services;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.repositories.PostRepository;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private PostService publicacionService;

    @DisplayName("JUnit test para chequear que se devuelva lsita con publicaciones")
    @Test
    public void givenListaPublicaciones_whenTraerListaPublicaciones_thenListaPublicaciones(){
        
       

        LocalDate localDate = LocalDate.now(ZoneOffset.UTC);
        Post publicacion1 = new Post(1, "titulo", "imagen", "cuerpoTexto", localDate, true);
        Post publicacion2 = new Post(1, "tdsadsa", "idsadsan", "cASDSAto", localDate, true);

        PostRepository.posts.add(publicacion1);
        PostRepository.posts.add(publicacion2);
               
              
        List<Post> ListaPublicacion = publicacionService.getPosts();

       
        assertThat(ListaPublicacion).isNotNull();
        assertThat(ListaPublicacion.size()).isEqualTo(2);

    }
    
}
