package br.com.ecommerce.school.processamentoms.repository;


import br.com.ecommerce.school.processamentoms.dto.PedidoFinalizadoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoFinalizadoProducer implements IPedidoFinalizadoProducer {

    private String criarPedido;

    private Producer<PedidoFinalizadoDTO> producerPedido;


    public PedidoFinalizadoProducer(@Value("${pedido.finalizado}") String pedidoFinalizado, Producer<PedidoFinalizadoDTO> producerPedido) {
        this.criarPedido = pedidoFinalizado;
        this.producerPedido = producerPedido;
    }

    @Override
    public void finalizarPedido(PedidoFinalizadoDTO pedidoDTO) {
        producerPedido.enviar(criarPedido, pedidoDTO);
    }
}
