package br.com.ecommerce.school.pedidosms.exception;

public abstract class AbstractException extends RuntimeException implements IException {

    public AbstractException(String message) {
        super(message);
    }
}
