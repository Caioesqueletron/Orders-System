package br.com.ecommerce.school.clientems.service;

import br.com.ecommerce.school.clientems.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IBuscarClienteService {
    Optional<Cliente> buscar(String codigo);
}
