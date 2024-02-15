package br.com.ecommerce.school.processamentoms.dto;

import java.math.BigDecimal;

public class QuantidadeDTO {

    private BigDecimal quantidade;

    public QuantidadeDTO(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }
}
