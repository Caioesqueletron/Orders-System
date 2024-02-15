package br.com.ecommerce.school.processamentoms.repository;

import br.com.ecommerce.school.processamentoms.dto.PedidoDTO;

public interface INotaFiscalRepository {

    void gerar(PedidoDTO pedido);

}
