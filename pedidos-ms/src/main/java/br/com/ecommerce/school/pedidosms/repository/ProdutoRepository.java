package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.config.custom.WebClientCustomBuilder;
import br.com.ecommerce.school.pedidosms.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProdutoRepository implements IProdutoRepository {

    @Value("${uri.buscar.produto}")
    private String uri;

    @Value("${url.server.produto}")
    private String url;

    @Override
    public Optional<ProdutoDTO> buscar(String produto) {

        final ResponseEntity<ProdutoDTO> responseEntity = new WebClientCustomBuilder<ProdutoDTO>()
                .withBaseUrlAndUri(url, uri)
                .withGet()
                .withPathParam("produto", produto)
                .withToResponseEntity(ProdutoDTO.class)
                .build();

        return Optional.ofNullable(responseEntity.getBody());
    }
}
