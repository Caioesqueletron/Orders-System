package br.com.ecommerce.school.pedidosms.services;

import br.com.ecommerce.school.pedidosms.dto.PedidoCriadoDTO;
import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;

import java.util.Optional;

public interface IPedidoService {

    PedidoCriadoDTO criar(PedidoDTO pedidoDTO);
    Optional<br.com.ecommerce.school.pedidosms.dto.consultarPedido.PedidoDTO> consultarPorCodigo(String codigo);
}
