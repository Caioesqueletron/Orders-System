package br.com.ecommerce.school.clientems.exception;

import org.springframework.http.HttpStatus;

public interface IException {
    HttpStatus getStatus();
    String getMessage();
}
