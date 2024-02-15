package br.com.ecommerce.school.processamentoms.repository;

import br.com.ecommerce.school.processamentoms.dto.ItemPedidoDTO;

public interface IEstoquePedidoRepository {

    void executarBaixa(ItemPedidoDTO produto);
}
