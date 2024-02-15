package br.com.ecommerce.school.processamentoms.service;

import br.com.ecommerce.school.processamentoms.dto.PedidoDTO;

public interface IProcessadorPedidoService {

    void processar(PedidoDTO pedido);
}
