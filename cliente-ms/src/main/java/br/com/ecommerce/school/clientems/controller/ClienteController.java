package br.com.ecommerce.school.clientems.controller;

import br.com.ecommerce.school.clientems.entity.Cliente;
import br.com.ecommerce.school.clientems.exception.ClientNotFoudException;
import br.com.ecommerce.school.clientems.service.IBuscarClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/clientes")
public class ClienteController {

    private final IBuscarClienteService service;

    public ClienteController(IBuscarClienteService service) {
        this.service = service;
    }

    @GetMapping("/{cliente}")
    public ResponseEntity<Cliente> buscar(@PathVariable(required=false,name="cliente")  String cliente) {
        log.info("Looking for client");
        final Optional<Cliente> buscar = service.buscar(cliente);
        if (buscar.isPresent()) {
            log.info("client found:{}",buscar.get().getPrimeiroNome());
            return ResponseEntity.ok(buscar.get());
        } else {
            log.info("client not found");
            throw new ClientNotFoudException();
        }
    }

}
