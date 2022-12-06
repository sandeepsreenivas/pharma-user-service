package com.pharmabms.exceptions;

import com.pharmabms.dto.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = MobileNumberExistsException.class)
    public ResponseEntity<Object> handleMobileNumberExistsException(MobileNumberExistsException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), ex.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = EmailExistsException.class)
    public ResponseEntity<Object> handleEmailExistsException(EmailExistsException ex, WebRequest request) {
        ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), ex.getLocalizedMessage());
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
