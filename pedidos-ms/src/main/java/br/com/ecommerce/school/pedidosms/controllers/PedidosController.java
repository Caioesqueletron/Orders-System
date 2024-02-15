package br.com.ecommerce.school.pedidosms.controllers;

import br.com.ecommerce.school.pedidosms.dto.PedidoCriadoDTO;
import br.com.ecommerce.school.pedidosms.dto.PedidoDTO;
import br.com.ecommerce.school.pedidosms.exception.ExceptionResponse;
import br.com.ecommerce.school.pedidosms.services.IPedidoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
@Slf4j
public class PedidosController {

    private IPedidoService service;

    public PedidosController(IPedidoService service) {
        this.service = service;
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<br.com.ecommerce.school.pedidosms.dto.consultarPedido.PedidoDTO> consultarPedido(@PathVariable(name = "codigo") String codigo) {

        final Optional<br.com.ecommerce.school.pedidosms.dto.consultarPedido.PedidoDTO> pedido =
                service.consultarPorCodigo(codigo);

        if (!pedido.isPresent()) {
            final ExceptionResponse erro = new ExceptionResponse("004", "Pedido não encontrado");
            return new ResponseEntity(erro, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(pedido, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PedidoCriadoDTO> enviarPedidos(@RequestBody PedidoDTO pedidoDTO) {

        log.info("Creating order");
        final PedidoCriadoDTO pedidoCriado = service.criar(pedidoDTO);
        log.info("Order created");
        return new ResponseEntity(pedidoCriado, HttpStatus.CREATED);
    }
}
