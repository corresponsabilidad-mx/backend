package mx.org.corresponsabilidadsocial.api.blog.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
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

}