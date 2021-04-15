package stgrupp8.gruppProjekt.controller;

import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import stgrupp8.gruppProjekt.exception.BadRequestException;
import stgrupp8.gruppProjekt.exception.NoContentException;
import stgrupp8.gruppProjekt.exception.NotFoundException;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	@ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> handleBadRequestException(BadRequestException ex) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(NoContentException.class)
    public ResponseEntity<Object> handleNoContentException(NoContentException ex) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NO_CONTENT);
    }
    
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex) {
        return new ResponseEntity<>(ex.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

}
