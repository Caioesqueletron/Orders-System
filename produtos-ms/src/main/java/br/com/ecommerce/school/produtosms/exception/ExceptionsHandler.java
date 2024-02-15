package br.com.ecommerce.school.produtosms.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<ExceptionResponse> handleDefaultException(final ProdutoNaoEncontradoException ex) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse("001", ex.getMessage());

        return new ResponseEntity<>(exceptionResponse
                , new HttpHeaders()
                , ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleDefaultException(final Exception ex) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse("002", "Erro desconhecido" );

        return new ResponseEntity<>(exceptionResponse
                , new HttpHeaders()
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
