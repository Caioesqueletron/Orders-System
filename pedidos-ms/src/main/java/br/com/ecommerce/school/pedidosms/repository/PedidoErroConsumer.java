package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.dto.PedidoErroDTO;
import br.com.ecommerce.school.pedidosms.services.IFinalizarPedidoService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoErroConsumer {

    private final IFinalizarPedidoService service;

    public PedidoErroConsumer(IFinalizarPedidoService service) {
        this.service = service;
    }

    @KafkaListener(topics = "${pedido.erro}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final PedidoErroDTO pedidoErroDTO) {
        service.pedidoComErro(pedidoErroDTO);
    }

}
