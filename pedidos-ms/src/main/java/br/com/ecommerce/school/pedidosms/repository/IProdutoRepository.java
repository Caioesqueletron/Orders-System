package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.dto.ProdutoDTO;

import java.util.Optional;

public interface IProdutoRepository {

    Optional<ProdutoDTO> buscar(String produto);
}
