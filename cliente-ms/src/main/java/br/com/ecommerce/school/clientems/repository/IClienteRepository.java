package br.com.ecommerce.school.clientems.repository;

import br.com.ecommerce.school.clientems.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IClienteRepository extends JpaRepository<Cliente, String> {
    Optional<Cliente> findByCodigo(final String codigo);
}