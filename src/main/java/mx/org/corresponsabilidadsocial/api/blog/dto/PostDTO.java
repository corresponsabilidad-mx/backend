package mx.org.corresponsabilidadsocial.api.blog.dto;

import mx.org.corresponsabilidadsocial.api.blog.entities.Status;

import java.time.LocalDate;

public class PostDTO {

    private String title;
    private String imageUrl;
    private String text;
    private Status status;

    public PostDTO(String title, String imageUrl, String text, Status status) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.text = text;
        this.status = status;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
