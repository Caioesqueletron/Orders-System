package br.com.ecommerce.school.pedidosms.services;

import br.com.ecommerce.school.pedidosms.dto.ClienteDTO;
import br.com.ecommerce.school.pedidosms.dto.EStatusCliente;
import br.com.ecommerce.school.pedidosms.dto.ItemPedidoDTO;
import br.com.ecommerce.school.pedidosms.dto.PedidoCriadoDTO;
import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;
import br.com.ecommerce.school.pedidosms.dto.ProdutoDTO;
import br.com.ecommerce.school.pedidosms.entity.Pedido;
import br.com.ecommerce.school.pedidosms.exception.InvalidOrderException;
import br.com.ecommerce.school.pedidosms.exception.ProdutoSemEstoqueException;
import br.com.ecommerce.school.pedidosms.helpers.ItemPedidoHelper;
import br.com.ecommerce.school.pedidosms.repository.IClienteRepository;
import br.com.ecommerce.school.pedidosms.repository.IPedidoProducer;
import br.com.ecommerce.school.pedidosms.repository.IPedidoRepository;
import br.com.ecommerce.school.pedidosms.repository.IProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PedidoService implements IPedidoService {

    private final IPedidoProducer pedidoProducer;

    private final IClienteRepository clienteRepository;

    private final IPedidoRepository pedidoRepository;

    private final IProdutoRepository produtoRepository;

    public PedidoService(
            IPedidoProducer pedidoProducer,
            IClienteRepository clienteRepository,
            IPedidoRepository repository, IProdutoRepository produtoRepository) {

        this.pedidoProducer = pedidoProducer;
        this.clienteRepository = clienteRepository;
        this.pedidoRepository = repository;
        this.produtoRepository = produtoRepository;
    }

    @Override
    public PedidoCriadoDTO criar(PedidoDTO pedidoDTO) {

        validarCliente(pedidoDTO);
        validarProduto(pedidoDTO);
        log.info("Order validated");

        final Pedido pedido = new Pedido(pedidoDTO.getCliente(),
                ItemPedidoHelper.parseItemPedidoDTOS(pedidoDTO.getProdutos()));

        final Pedido pedidoCriado = pedidoRepository.save(pedido);
        log.info("Order saved in status: {}", pedidoCriado.getStatus());
        pedidoProducer.enviarPedido(pedido);
        log.info("Order sent in status: {}", pedidoCriado.getStatus());
        return new PedidoCriadoDTO(pedidoCriado.getCodigo());
    }

    @Override
    public Optional<br.com.ecommerce.school.pedidosms.dto.consultarPedido.PedidoDTO> consultarPorCodigo(String codigo) {
        // busca o pedido
        final Optional<Pedido> pedido = pedidoRepository.findById(codigo);
        if (pedido.isPresent()) {
            //busca o cliente do pedido
            log.info("Order found in status: {}", pedido.get().getStatus());

            final Optional<ClienteDTO> cliente = clienteRepository.buscar(pedido.get().getCliente());

            List<ProdutoDTO> produtos = new ArrayList<>();

            pedido.get().getItems().stream().forEach(dto -> produtos.add(produtoRepository.buscar(dto.getCodigo()).get()));


            final List<br.com.ecommerce.school.pedidosms.dto.consultarPedido.ItemPedidoDTO> itens =
                    produtos.stream().map(p -> new br.com.ecommerce.school.pedidosms.dto.
                            consultarPedido.ItemPedidoDTO("", pedido.get().getItems().stream().filter(pe -> pe.getCodigo().equals(p.getCodigo())).findFirst().get().getQuantidade(), p.getCodigo())).collect(Collectors.toList());


            final br.com.ecommerce.school.pedidosms.dto.consultarPedido.ClienteDTO clientePedido =
                    new br.com.ecommerce.school.pedidosms.dto.consultarPedido.ClienteDTO(cliente.get().getCodigo(),
                            cliente.get().getPrimeiroNome(), cliente.get().getUltimoNome(), cliente.get().getEmail());

            return Optional.of(new br.com.ecommerce.school.pedidosms.dto.consultarPedido.PedidoDTO(pedido.get().getCodigo(), clientePedido, itens,
                    pedido.get().getStatus().name()));

        }

        return Optional.empty();
    }

    private void validarProduto(PedidoDTO pedidoDTO) {
        Map<String, BigDecimal> items = new HashMap<>();
        for (ItemPedidoDTO item : pedidoDTO.getProdutos()) {
            final Optional<ProdutoDTO> produto = produtoRepository.buscar(item.getCodigo());
            items.merge(item.getCodigo(),item.getQuantidade(), BigDecimal::add);
            BigDecimal quantidadeSolicitada = item.getQuantidade();
            BigDecimal saldoEstoque = produto.get().getQuantidade();
            log.info("Quantity:{}",items.get(produto.get().getCodigo()));

            if (quantidadeSolicitada.compareTo(saldoEstoque) > 0 || items.get(produto.get().getCodigo()).compareTo(saldoEstoque) > 0) {
                throw new ProdutoSemEstoqueException("Produto sem estoque: " + item.getCodigo());
            }


        }
    }

    private void validarCliente(PedidoDTO pedidoDTO) {
        final Optional<ClienteDTO> clienteDTO
                = clienteRepository.buscar(pedidoDTO.getCliente());

        if (clienteDTO.isEmpty()) {
            throw new InvalidOrderException("Cliente não encontrado!");
        } else if (clienteDTO.get().getStatus() == EStatusCliente.BLOQUEADO) {
            throw new InvalidOrderException("Cliente possui conta bloqueada!");
        } else if (clienteDTO.get().getStatus() == EStatusCliente.INATIVO) {
            throw new InvalidOrderException("Cliente existente, porém, não possui ativa!");
        } else if (!pedidoDTO.getCliente().equals(clienteDTO.get().getCodigo())) {
            throw new InvalidOrderException("Código do cliente inválido!");
        }
    }
}
