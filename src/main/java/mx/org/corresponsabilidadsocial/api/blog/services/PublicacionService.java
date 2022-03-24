package mx.org.corresponsabilidadsocial.api.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import mx.org.corresponsabilidadsocial.api.blog.entities.Publicacion;
import mx.org.corresponsabilidadsocial.api.blog.repositories.PublicacionRepository;

@Service
public class PublicacionService {

    
    public List<Publicacion> traerListaPublicaciones() {
        return PublicacionRepository.publicaciones;
    }
    
}
