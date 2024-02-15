package br.com.ecommerce.school.pedidosms.exception;

import org.springframework.http.HttpStatus;

public interface IException {
    HttpStatus getStatus();
    String getMessage();
}
