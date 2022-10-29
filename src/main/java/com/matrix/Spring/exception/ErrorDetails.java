package com.matrix.Spring.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {

    private String message;

    private HttpStatus status;

    private LocalDate localDate;
}
