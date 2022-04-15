package mx.org.corresponsabilidadsocial.api.blog.dto;

import mx.org.corresponsabilidadsocial.api.blog.entities.Status;
import mx.org.corresponsabilidadsocial.api.blog.validator.Title;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class PostDTO {

    @NotBlank(message = "Title is mandatory")
    @Size(min = 10, max = 50, message = "characters range must be between 10 and 50")
    @Title(message = "please try another title")
    private String title;
    @NotBlank(message = "Image is mandatory")
    private String imageUrl;
    @NotBlank(message = "Text is mandatory")
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
