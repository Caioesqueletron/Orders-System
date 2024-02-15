package br.com.ecommerce.school.processamentoms.dto;

import br.com.ecommerce.school.processamentoms.config.custom.IErroNotificacaoDTO;

public class ErroNotificacaoDTO implements IErroNotificacaoDTO {
    public String codigo;
    public String status;
    public String servico;

    public ErroNotificacaoDTO() {
    }

    public ErroNotificacaoDTO(String codigo, String status, String servico) {
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
