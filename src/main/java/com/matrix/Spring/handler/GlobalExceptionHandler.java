package com.matrix.Spring.handler;

import com.matrix.Spring.exception.ErrorDetails;
import com.matrix.Spring.exception.GetBadRequestException;
import com.matrix.Spring.exception.GetForbiddenException;
import com.matrix.Spring.exception.NotFoundException;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDate;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDetails> notDataFound(NotFoundException exception){
     var errorDetails = new ErrorDetails(exception.getStackTrace().toString(),exception.getStatus(), LocalDate.now());
     return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GetBadRequestException.class)
    public ResponseEntity<ErrorDetails> getBadRequest(GetBadRequestException exception){
        var errorDetails = new ErrorDetails(exception.getStackTrace().toString(), exception.getStatus(), LocalDate.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
    @ApiOperation(value = "403 Forbidden exception handled")
    @ExceptionHandler(GetForbiddenException.class)
    public ResponseEntity<ErrorDetails> getForbiddenRequest(GetForbiddenException exception){
        var errorDetails = new ErrorDetails(exception.getStackTrace().toString(),exception.getStatus(), LocalDate.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorDetails> notDataFound(RuntimeException exception){
        var errorDetails = new ErrorDetails(exception.getStackTrace().toString(), HttpStatus.NOT_FOUND, LocalDate.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<ErrorDetails> notDataFound(Exception exception){
            var errorDetails = new ErrorDetails(exception.getStackTrace().toString(), HttpStatus.NOT_FOUND, LocalDate.now());
            return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
        }
    }
