package br.com.ecommerce.school.processamentoms.repository;

import br.com.ecommerce.school.processamentoms.config.custom.IErroNotificacaoDTO;
import br.com.ecommerce.school.processamentoms.config.custom.INotificarErro;
import br.com.ecommerce.school.processamentoms.config.custom.WebClientCustomBuilder;
import br.com.ecommerce.school.processamentoms.dto.ErroNotificacaoDTO;
import br.com.ecommerce.school.processamentoms.dto.PedidoDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class NotaFiscalRepository implements INotaFiscalRepository {

    @Value("${uri.emissao.nf}")
    private String uri;

    @Value("${url.server.nf}")
    private String url;

    private final INotificarErro notificarErroImp;

    public NotaFiscalRepository(INotificarErro notificarErro) {
        this.notificarErroImp = notificarErro;
    }

    @Override
    public void gerar(PedidoDTO pedido) {

        final IErroNotificacaoDTO notificacaoDTO = new ErroNotificacaoDTO(pedido.getCodigo(), "ERRO_PROCESSAMENTO", "processamento-ms");
        new WebClientCustomBuilder<String>()
                .withBaseUrlAndUri(url, uri)
                .withPost()
                .withBody(pedido)
                .withNotificarError(notificarErroImp, notificacaoDTO)
                .build();
    }

}
