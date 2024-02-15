package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.dto.ClienteDTO;

import java.util.Optional;

public interface IClienteRepository {
    Optional<ClienteDTO> buscar(String cliente);
}
