package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.entity.Pedido;

public interface IPedidoProducer {

    void enviarPedido(Pedido pedido);

}
