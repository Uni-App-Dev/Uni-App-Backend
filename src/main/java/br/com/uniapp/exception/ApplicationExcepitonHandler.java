package br.com.uniapp.exception;

import br.com.uniapp.exception.bundle.AuthenticationAppException;
import br.com.uniapp.exception.bundle.UniException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExcepitonHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UniException.class)
    public ResponseEntity handleException(Exception e) {
        DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AuthenticationAppException.class)
    public ResponseEntity handleEmailNotFoundException(Exception e) {
        DefaultError error = new DefaultError(HttpStatus.BAD_REQUEST.toString(), e.getMessage());
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
