package mx.org.corresponsabilidadsocial.api.blog.entities;

import javax.annotation.Generated;

import com.google.cloud.Timestamp;

public class Post {

 
    private String id;
    private String title;
    private String imageUrl;
    private String text;
    private Timestamp date;
    private Status status;

    public Post() {
    }

    public Post(String id, String title, String imageUrl, String text, Timestamp date, Status status) {
        this.id = id;
        this.title = title;
        this.imageUrl = imageUrl;
        this.text = text;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}
