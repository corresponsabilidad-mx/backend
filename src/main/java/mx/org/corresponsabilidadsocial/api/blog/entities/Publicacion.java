package mx.org.corresponsabilidadsocial.api.blog.entities;




public class Publicacion {

    private Integer Id;
    private String titulo;
    private String imagen;
    private String cuerpoTexto;
    private String fechaPublicacion;
    private Boolean status;

    

    public Publicacion() {
    }

    
    public Publicacion(Integer id, String titulo, String imagen, String cuerpoTexto, String fechaPublicacion,
            Boolean status) {
        Id = id;
        this.titulo = titulo;
        this.imagen = imagen;
        this.cuerpoTexto = cuerpoTexto;
        this.fechaPublicacion = fechaPublicacion;
        this.status = status;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getCuerpoTexto() {
        return cuerpoTexto;
    }

    public void setCuerpoTexto(String cuerpoTexto) {
        this.cuerpoTexto = cuerpoTexto;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public Boolean getStatus() {
        return status;
    }
    
    public void setStatus(Boolean status) {
        this.status = status;
    }

    
    
}
