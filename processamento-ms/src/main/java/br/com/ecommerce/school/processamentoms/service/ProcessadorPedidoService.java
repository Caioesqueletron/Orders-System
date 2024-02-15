package br.com.ecommerce.school.processamentoms.service;

import br.com.ecommerce.school.processamentoms.dto.ErroNotificacaoDTO;
import br.com.ecommerce.school.processamentoms.dto.PedidoDTO;
import br.com.ecommerce.school.processamentoms.dto.PedidoFinalizadoDTO;
import br.com.ecommerce.school.processamentoms.repository.IEstoquePedidoRepository;
import br.com.ecommerce.school.processamentoms.repository.INotaFiscalRepository;
import br.com.ecommerce.school.processamentoms.repository.IPedidoFinalizadoProducer;
import br.com.ecommerce.school.processamentoms.repository.NotificarErro;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProcessadorPedidoService implements IProcessadorPedidoService {

    private INotaFiscalRepository notaFiscal;

    private IEstoquePedidoRepository estoque;

    private IPedidoFinalizadoProducer producer;

    private NotificarErro producerErro;

    public ProcessadorPedidoService(INotaFiscalRepository notaFiscal, IEstoquePedidoRepository estoque,
                                    IPedidoFinalizadoProducer producer, NotificarErro producerErro) {
        this.notaFiscal = notaFiscal;
        this.estoque = estoque;
        this.producer = producer;
        this.producerErro = producerErro;
    }

    @Override
    public void processar(PedidoDTO pedido){
        log.info("Processing order in status");

        //produzir messagem de produto finalizado
        try {
            notaFiscal.gerar(pedido);
            pedido.getProdutos().forEach(p -> estoque.executarBaixa(p));
            //baixar estoque
            log.info("Order finished in status");
            producer.finalizarPedido(new PedidoFinalizadoDTO(pedido.getCodigo(), "DISPONIVEL_RETIRADA", "Pronto para retirada"));
        } catch (Exception e) {
            System.out.println("passou");
            producerErro.notificar(new ErroNotificacaoDTO(pedido.getCodigo(), "ERRO_PROCESSAMENTO", "Erro no processamento"));
        }

    }
}
