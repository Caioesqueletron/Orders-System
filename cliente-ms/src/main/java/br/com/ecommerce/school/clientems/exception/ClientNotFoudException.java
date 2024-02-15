package br.com.ecommerce.school.clientems.exception;

import org.springframework.http.HttpStatus;

public class ClientNotFoudException extends AbstractException {

    private static final long serialVersionUID = 574992678122876904L;

    public ClientNotFoudException() {
        super("Cliente não encontrado!");
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
