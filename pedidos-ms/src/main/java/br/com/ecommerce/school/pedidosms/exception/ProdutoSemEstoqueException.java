package br.com.ecommerce.school.pedidosms.exception;

import org.springframework.http.HttpStatus;

public class ProdutoSemEstoqueException extends AbstractException {

    private static final long serialVersionUID = 574992678122876904L;

    public ProdutoSemEstoqueException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.UNPROCESSABLE_ENTITY;
    }
}
