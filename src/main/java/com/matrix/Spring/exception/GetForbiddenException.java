package com.matrix.Spring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class GetForbiddenException extends RuntimeException{

    private HttpStatus status;
    private Integer code;
    private String message;

}
