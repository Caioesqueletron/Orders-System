package br.com.ecommerce.school.processamentoms.repository;

import br.com.ecommerce.school.processamentoms.dto.PedidoDTO;
import br.com.ecommerce.school.processamentoms.service.IProcessadorPedidoService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerPedido<T> {

    private IProcessadorPedidoService service;


    public ConsumerPedido(IProcessadorPedidoService service) {
        this.service = service;
    }

    @KafkaListener(topics = "${criar.pedido}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(final PedidoDTO  pedidoDTO) {
        service.processar(pedidoDTO);
    }

}
