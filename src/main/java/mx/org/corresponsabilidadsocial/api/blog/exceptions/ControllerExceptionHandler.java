package mx.org.corresponsabilidadsocial.api.blog.exceptions;

import java.util.*;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException.BadRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.validation.ObjectError;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(NotFoundException.class)
        @ResponseStatus(code = HttpStatus.NOT_FOUND)
        @ResponseBody
        public ResponseEntity<ErrorMessage> notFound(NotFoundException ex, WebRequest request) {
                ErrorMessage apiError = new ErrorMessage(
                                true, "Post not found", HttpStatus.NOT_FOUND.value());
                return new ResponseEntity<ErrorMessage>(
                                apiError, new HttpHeaders(), apiError.getCode());
        }

        @ExceptionHandler(Exception.class)
        @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
        @ResponseBody
        public ResponseEntity<ErrorMessage> handleAll(Exception ex, WebRequest request) {
                ErrorMessage apiError = new ErrorMessage(
                                true, "An error occurred during the process",
                                HttpStatus.INTERNAL_SERVER_ERROR.value());
                return new ResponseEntity<ErrorMessage>(
                                apiError, new HttpHeaders(), apiError.getCode());
        }

        @Override
        protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                        HttpHeaders headers, HttpStatus status, WebRequest request) {
                List<String> details = new ArrayList<>();
                for (ObjectError error : ex.getBindingResult().getAllErrors()) {
                        details.add(error.getDefaultMessage());
                }
                ErrorMessage error = new ErrorMessage(details);
                return new ResponseEntity<>(error.getDetails(), HttpStatus.BAD_REQUEST);
        }
}
