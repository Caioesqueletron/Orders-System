package br.com.ecommerce.school.pedidosms.dto;

import java.math.BigDecimal;

public class ProdutoDTO {
    private String codigo;
    private BigDecimal quantidade;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String codigo, BigDecimal quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }
}
