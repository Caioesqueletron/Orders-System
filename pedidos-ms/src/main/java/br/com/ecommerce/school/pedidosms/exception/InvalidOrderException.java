package br.com.ecommerce.school.pedidosms.exception;

import org.springframework.http.HttpStatus;

public class InvalidOrderException extends AbstractException {

    private static final long serialVersionUID = 574992678122876904L;

    public InvalidOrderException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNAUTHORIZED;
    }
}
