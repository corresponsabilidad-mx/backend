package mx.org.corresponsabilidadsocial.api.blog.entities;

import java.time.LocalDate;

import javax.validation.constraints.*;

public class Post {

    private Integer Id;

    @NotBlank(message = "Title is mandatory")
    @Size(min = 10, max = 50, message = "characters range must be between 10 and 50 characters")
    private String title;
    @NotBlank(message = "Image is mandatory")
    private String imageUrl;
    @NotBlank(message = "Text is mandatory")
    @Size(min = 100, message = "minimum is set to 100 characters")
    private String text;
    private LocalDate date;
    private Status status;

    public Post() {
    }

    public Post(Integer id, String title, String imageUrl, String text, Status status) {
        Id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.text = text;
        this.status = status;
    }

    public Post(Integer id, String title, String imageUrl, String text, LocalDate date, Status status) {
        Id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.text = text;
        this.date = date;
        this.status = status;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
