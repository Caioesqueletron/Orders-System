package br.com.ecommerce.school.pedidosms.dto;

public class PedidoErroDTO {
    public String codigo;
    public String status;
    public String servico;

    public PedidoErroDTO() {
    }

    public PedidoErroDTO(String codigo, String status, String servico) {
        this.codigo = codigo;
        this.status = status;
        this.servico = servico;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getStatus() {
        return status;
    }

    public String getServico() {
        return servico;
    }
}
