package br.com.ecommerce.school.produtosms.dto;

import java.math.BigDecimal;

public class QuantidadeDTO {

    private BigDecimal quantidade;

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }
}
