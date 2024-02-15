package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPedidoRepository extends JpaRepository<Pedido, String> {

    Optional<Pedido> findByCliente(final String cliente);
}
