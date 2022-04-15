package mx.org.corresponsabilidadsocial.api.blog.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ErrorMessage {

    private boolean error;
    private String message;
    private Integer code;
    private List<String> details = new ArrayList<>();

    public ErrorMessage(boolean error, String message, Integer code) {
        super();
        this.error = error;
        this.message = message;
        this.code = code;
    }

    public ErrorMessage(boolean error, Integer code) {
        super();
        this.error = error;
        this.code = code;
    }

    public ErrorMessage(List<String> details) {
        this.details = details;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }

}
