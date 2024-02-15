package br.com.ecommerce.school.produtosms.service;

import br.com.ecommerce.school.produtosms.dto.QuantidadeDTO;
import br.com.ecommerce.school.produtosms.entity.Produto;

import java.util.Optional;

public interface IProdutoService {

    void processarEstoque(QuantidadeDTO quantidade, String codigo);

    Optional<Produto> buscar(String codigo);
}
