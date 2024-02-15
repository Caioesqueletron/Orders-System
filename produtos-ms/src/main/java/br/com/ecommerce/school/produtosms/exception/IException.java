package br.com.ecommerce.school.produtosms.exception;

import org.springframework.http.HttpStatus;

public interface IException {
    HttpStatus getStatus();
    String getMessage();
}
