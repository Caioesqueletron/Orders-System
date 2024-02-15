package br.com.ecommerce.school.pedidosms.services;


import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;
import br.com.ecommerce.school.pedidosms.dto.PedidoErroDTO;
import br.com.ecommerce.school.pedidosms.dto.PedidoFinalizadoDTO;
import br.com.ecommerce.school.pedidosms.entity.EStatusPedido;
import br.com.ecommerce.school.pedidosms.entity.Pedido;
import br.com.ecommerce.school.pedidosms.exception.InvalidOrderException;
import br.com.ecommerce.school.pedidosms.repository.IPedidoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class FinalizarPedidoService implements IFinalizarPedidoService {

    private final IPedidoRepository pedidoRepository;

    public FinalizarPedidoService(IPedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public void finalizarPedido(PedidoFinalizadoDTO pedidoDTO) {

        final Optional<Pedido> clienteEncontrado = pedidoRepository.findById(pedidoDTO.getCodigo());

        if (clienteEncontrado.isEmpty()) {
            throw new InvalidOrderException("Pedido não encontrado!");
        }
        log.info("Order finished in status: {}", pedidoDTO.status);
        Pedido pedido = clienteEncontrado.get();
        pedido.disponivelParaRetirada();
        log.info("Order saved in status: {}", pedidoDTO.status);
        pedidoRepository.save(pedido);
    }

    @Override
    public void pedidoComErro(PedidoErroDTO pedidoErroDTO) {
        final Optional<Pedido> pedido = pedidoRepository.findById(pedidoErroDTO.getCodigo());

        if (pedido.isEmpty()) {
            throw new InvalidOrderException("Pedido não encontrado!");
        }
        pedido.get().comErro();

        pedidoRepository.save(pedido.get());
    }

    public void pedidoCancelado(PedidoDTO pedidoErroDTO) {
        final Optional<Pedido> pedido = pedidoRepository.findById(pedidoErroDTO.getCodigo());

        if (pedido.isEmpty()) {
            throw new InvalidOrderException("Pedido não encontrado!");
        }
        pedido.get().setStatus(EStatusPedido.FINALIZADO);

        pedidoRepository.save(pedido.get());
    }
}
