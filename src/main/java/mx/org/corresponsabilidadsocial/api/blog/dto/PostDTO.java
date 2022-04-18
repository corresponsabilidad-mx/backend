package mx.org.corresponsabilidadsocial.api.blog.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import mx.org.corresponsabilidadsocial.api.blog.entities.Status;

public class PostDTO {

    @NotBlank(message = "Title is mandatory")
    @Size(min = 10, max = 50, message = "characters range must be between 10 and 50")
    private String title;
    @NotBlank(message = "Image is mandatory")
    private String imageUrl;
    @NotBlank(message = "Text is mandatory")
    @Size(min = 100, message = "The text is too short (minimum 100 characters)")
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