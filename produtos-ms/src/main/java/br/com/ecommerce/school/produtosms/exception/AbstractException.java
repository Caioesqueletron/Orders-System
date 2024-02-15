package br.com.ecommerce.school.produtosms.exception;

public abstract class AbstractException extends RuntimeException implements IException {

    public AbstractException(String message) {
        super(message);
    }
}
