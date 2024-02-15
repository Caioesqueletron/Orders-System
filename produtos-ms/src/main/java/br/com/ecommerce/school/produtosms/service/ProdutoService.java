package br.com.ecommerce.school.produtosms.service;

import br.com.ecommerce.school.produtosms.dto.QuantidadeDTO;
import br.com.ecommerce.school.produtosms.entity.Produto;
import br.com.ecommerce.school.produtosms.exception.ProdutoNaoEncontradoException;
import br.com.ecommerce.school.produtosms.exception.ProdutoSemEstoqueException;
import br.com.ecommerce.school.produtosms.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
@Slf4j
public class ProdutoService implements IProdutoService {

    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void processarEstoque(QuantidadeDTO pProduto, String codigo) {
        final Optional<Produto> produto = produtoRepository.findById(codigo);
        if (produto.isPresent()) {
            produto.get().calcularEstoque(pProduto.getQuantidade());
            log.info("Quantidade do produto: {}",produto.get().getQuantidade());
            if(produto.get().getQuantidade().compareTo(BigDecimal.ZERO) < 0){
                throw new ProdutoSemEstoqueException("Produto sem estoque");
            }
            produtoRepository.save(produto.get());
            log.info("Product updated");
        } else {
            throw new ProdutoNaoEncontradoException("Produto não encontrado");
        }
    }

    @Override
    public Optional<Produto> buscar(String codigo) {
        return produtoRepository.findById(codigo);
    }
}
