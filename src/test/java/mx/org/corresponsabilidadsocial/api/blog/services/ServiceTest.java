package mx.org.corresponsabilidadsocial.api.blog.services;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import mx.org.corresponsabilidadsocial.api.blog.entities.Publicacion;
import mx.org.corresponsabilidadsocial.api.blog.repositories.PublicacionRepository;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private PublicacionService publicacionService;

    @DisplayName("JUnit test para chequear que se devuelva lsita con publicaciones")
    @Test
    public void givenListaPublicaciones_whenTraerListaPublicaciones_thenListaPublicaciones(){
        
       

        Publicacion publicacion1 = new Publicacion(1, "titulo", "imagen", "cuerpoTexto", "fechaPublicacion", true);
        Publicacion publicacion2 = new Publicacion(1, "tdsadsa", "idsadsan", "cASDSAto", "fTREWTRacion", true);

        PublicacionRepository.publicaciones.add(publicacion1);
        PublicacionRepository.publicaciones.add(publicacion2);
               
              
        List<Publicacion> ListaPublicacion = publicacionService.traerListaPublicaciones();

       
        assertThat(ListaPublicacion).isNotNull();
        assertThat(ListaPublicacion.size()).isEqualTo(2);

    }
    
}
