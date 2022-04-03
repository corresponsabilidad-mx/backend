package mx.org.corresponsabilidadsocial.api.blog.exceptions;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(NotFoundException.class)
        @ResponseBody
        public ResponseEntity<ErrorMessage> notFound(NotFoundException ex, WebRequest request) {
                ErrorMessage apiError = new ErrorMessage(
                                true, "Post not found", HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<ErrorMessage>(
                                apiError, new HttpHeaders(), apiError.getCode());
        }

        @ExceptionHandler(Exception.class)
        @ResponseBody
        public ResponseEntity<ErrorMessage> handleAll(Exception ex, WebRequest request) {
                ErrorMessage apiError = new ErrorMessage(
                                true, "An error occurred during the process",
                                HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<ErrorMessage>(
                                apiError, new HttpHeaders(), apiError.getCode());
        }

        /*@ResponseStatus(HttpStatus.BAD_REQUEST)
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public Map<String, String> handleValidationExceptions(
                        MethodArgumentNotValidException ex) {
                Map<String, String> errors = new HashMap<>();
                ex.getBindingResult().getAllErrors().forEach((error) -> {
                        String fieldName = ((FieldError) error).getField();
                        String errorMessage = error.getDefaultMessage();
                        errors.put(fieldName, errorMessage);
                });
                return errors;
        }*/

}