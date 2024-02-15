package br.com.ecommerce.school.pedidosms.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionsHandler.class);

    @ExceptionHandler(AbstractException.class)
    public ResponseEntity<ExceptionResponse> handleDefaultException(final AbstractException ex) {
        final ExceptionResponse exceptionResponse = montarResponseBasica("001", ex.getMessage());

        return new ResponseEntity<>(exceptionResponse
                , new HttpHeaders()
                , ex.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleDefaultException(final Exception ex) {

        final ExceptionResponse exceptionResponse =
                montarResponseBasica("002", "Erro interno do sistema.");

        return new ResponseEntity<>(exceptionResponse
                , new HttpHeaders()
                , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ExceptionResponse montarResponseBasica(final String codigo, final String mensagem) {
        LOGGER.info("[Erro ocorrido com código: {}, mensagem: {}]", codigo, mensagem);
        return new ExceptionResponse(codigo, mensagem);
    }
}
