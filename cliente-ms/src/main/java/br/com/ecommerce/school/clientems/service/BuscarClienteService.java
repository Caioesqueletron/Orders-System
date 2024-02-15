package br.com.ecommerce.school.clientems.service;

import br.com.ecommerce.school.clientems.entity.Cliente;
import br.com.ecommerce.school.clientems.repository.IClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuscarClienteService implements IBuscarClienteService {

    private final IClienteRepository repository;

    public BuscarClienteService(IClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Cliente> buscar(String codigo) {
        return repository.findByCodigo(codigo);
    }
}
