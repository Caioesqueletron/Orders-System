package br.com.ecommerce.school.produtosms.controller;

import br.com.ecommerce.school.produtosms.dto.QuantidadeDTO;
import br.com.ecommerce.school.produtosms.entity.Produto;
import br.com.ecommerce.school.produtosms.exception.ExceptionResponse;
import br.com.ecommerce.school.produtosms.service.IProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("produtos")
@Slf4j
public class ProdutoController {

    private IProdutoService produtoService;

    public ProdutoController(IProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PutMapping("/{produto}")
    public ResponseEntity atualizar(@PathVariable(required = false, name = "produto") String produto,
                                    @RequestBody QuantidadeDTO quantidade) {

        log.info("Updating product");
        produtoService.processarEstoque(quantidade, produto);

        return ResponseEntity.ok().build();
    }


    @GetMapping("/{produto}")
    public ResponseEntity buscar(@PathVariable(required = false, name = "produto") String pProduto) {

        log.info("Searching product");
        final Optional<Produto> produto = produtoService.buscar(pProduto);

        if (produto.isPresent()) {
            log.info("Product found");
            return new ResponseEntity(produto.get(), HttpStatus.OK);
        } else {
            log.info("Product not found");
            final ExceptionResponse ex = new ExceptionResponse("003", "Produto não encontrado");
            return new ResponseEntity(ex, HttpStatus.NOT_FOUND);
        }

    }
}
