package br.com.ecommerce.school.processamentoms.repository;

import br.com.ecommerce.school.processamentoms.dto.PedidoFinalizadoDTO;

public interface IPedidoFinalizadoProducer {

    void finalizarPedido(PedidoFinalizadoDTO pedidoDTO);

}
