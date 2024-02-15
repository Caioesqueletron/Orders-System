package br.com.ecommerce.school.produtosms.exception;

import org.springframework.http.HttpStatus;

public class ProdutoNaoEncontradoException extends AbstractException {

    private static final long serialVersionUID = 574992678122876904L;

    public ProdutoNaoEncontradoException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
