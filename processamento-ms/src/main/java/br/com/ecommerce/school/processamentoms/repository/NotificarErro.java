package br.com.ecommerce.school.processamentoms.repository;


import br.com.ecommerce.school.processamentoms.config.custom.IErroNotificacaoDTO;
import br.com.ecommerce.school.processamentoms.config.custom.INotificarErro;
import br.com.ecommerce.school.processamentoms.dto.ErroNotificacaoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class NotificarErro implements INotificarErro {

    private final Producer<ErroNotificacaoDTO> notificacaoProducer;
    private final String topico;

    public NotificarErro(@Value("${pedido.erro}") String topico, Producer<ErroNotificacaoDTO> notificacaoProducer) {
        this.notificacaoProducer = notificacaoProducer;
        this.topico = topico;
    }

    @Override
    public void notificar(IErroNotificacaoDTO dto) {
        notificacaoProducer.enviar(topico, (ErroNotificacaoDTO) dto);
    }
}
