package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.dto.ItemPedidoDTO;
import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;
import br.com.ecommerce.school.pedidosms.entity.Pedido;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PedidoProducer implements IPedidoProducer {

    private String criarPedido;

    private Producer<PedidoDTO> producerPedido;

    public PedidoProducer(@Value("${criar.pedido}") String criarPedido,
                          Producer<PedidoDTO> producerPedido) {
        this.criarPedido = criarPedido;
        this.producerPedido = producerPedido;
    }

    @Override
    public void enviarPedido(Pedido pedido) {

        final List<ItemPedidoDTO> itensProdutos =
                pedido.getItems().stream().map(p -> new ItemPedidoDTO(p.getCodigo(), p.getQuantidade())).collect(Collectors.toList());

        final PedidoDTO pedidoDTO =
                new PedidoDTO(pedido.getCodigo(), pedido.getCliente(), itensProdutos);
        producerPedido.enviar(criarPedido, pedidoDTO);
    }
}
