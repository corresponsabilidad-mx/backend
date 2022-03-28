package mx.org.corresponsabilidadsocial.api.blog.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import mx.org.corresponsabilidadsocial.api.blog.entities.Post;
import mx.org.corresponsabilidadsocial.api.blog.repositories.PostRepository;

@SpringBootTest
public class ServiceTest {

    @Mock
    PostRepository postRepository

    @DisplayName("JUnit test para chequear que se devuelva lsita con publicaciones")
    @Test
    public void givenPostsList_whengetPosts_thenPostsLists(){
        
                     
        List<Post> ListaPublicacion = publicacionService.getPosts();

       
        assertThat(ListaPublicacion).isNotNull();
        assertThat(ListaPublicacion.size()).isEqualTo(2);

    }
    
}
