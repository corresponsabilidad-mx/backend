package mx.org.corresponsabilidadsocial.api.blog.exceptions;

import java.io.IOException;
import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.validation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

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
                Map<String, String> errors = new LinkedHashMap<>();
                ex.getBindingResult().getAllErrors().forEach((error) -> {
                        String fieldName = ((FieldError) error).getField();
                        String errorMessage = error.getDefaultMessage();
                        errors.put(fieldName, errorMessage);
                });
                return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        }

        @ExceptionHandler(ConstraintViolationException.class)
        public void constraintViolationException(HttpServletResponse response) throws IOException
        {
                response.sendError(HttpStatus.BAD_REQUEST.value());
        }
}
