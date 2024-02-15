package br.com.ecommerce.school.processamentoms.dto;

public class PedidoFinalizadoDTO {

    public String codigo;
    public String status;
    public String observacao;

    public PedidoFinalizadoDTO(String codigo, String status, String observacao) {
        this.codigo = codigo;
        this.status = status;
        this.observacao = observacao;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getStatus() {
        return status;
    }

    public String getObservacao() {
        return observacao;
    }
}
