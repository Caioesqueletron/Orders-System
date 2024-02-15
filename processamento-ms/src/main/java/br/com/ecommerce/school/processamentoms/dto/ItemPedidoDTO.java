package br.com.ecommerce.school.processamentoms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ItemPedidoDTO {

    private String codigo;
    private BigDecimal quantidade;

    public ItemPedidoDTO(@JsonProperty("codigo") String codigo,
                         @JsonProperty("quantidade")BigDecimal quantidade) {
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

    @Override
    public String toString() {
        return "ItemPedidoDTO{" +
                "codigo='" + codigo + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
