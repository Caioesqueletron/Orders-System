package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.dto.PedidoFinalizadoDTO;
import br.com.ecommerce.school.pedidosms.services.IFinalizarPedidoService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoFinalizadoConsumer {

    private final IFinalizarPedidoService service;

    public PedidoFinalizadoConsumer(IFinalizarPedidoService service) {
        this.service = service;
    }

    @KafkaListener(topics = "${pedido.finalizado}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final PedidoFinalizadoDTO pedidoDTO) {
        service.finalizarPedido(pedidoDTO);
    }

}
