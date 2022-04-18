package mx.org.corresponsabilidadsocial.api.blog.exceptions;

import java.util.*;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.validation.*;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(NotFound.class)
        @ResponseStatus(code = HttpStatus.NOT_FOUND)
        @ResponseBody
        public ResponseEntity<Object> notFound(NotFound ex, WebRequest request) {
                return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(Duplicated.class)
        @ResponseStatus(code = HttpStatus.NOT_FOUND)
        @ResponseBody
        public ResponseEntity<Object> notFound(Duplicated ex, WebRequest request) {
                return new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }

        @ExceptionHandler(Exception.class)
        @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
        @ResponseBody
        public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
                return new ResponseEntity<Object>("An error occurred during the process",
                                HttpStatus.INTERNAL_SERVER_ERROR);
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
}
