package br.com.ecommerce.school.pedidosms.repository;

import br.com.ecommerce.school.pedidosms.config.custom.WebClientCustomBuilder;
import br.com.ecommerce.school.pedidosms.dto.ClienteDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ClienteRepository implements IClienteRepository {

    @Value("${uri.buscar.cliente}")
    private String uri;

    @Value("${url.server.cliente}")
    private String url;

    @Override
    public Optional<ClienteDTO> buscar(String cliente) {

        final ResponseEntity<ClienteDTO> responseEntity = new WebClientCustomBuilder<ClienteDTO>()
                .withBaseUrlAndUri(url, uri)
                .withGet()
                .withPathParam("cliente", cliente)
                .withToResponseEntity(ClienteDTO.class)
                .build();

        return Optional.ofNullable(responseEntity.getBody());
    }
}
