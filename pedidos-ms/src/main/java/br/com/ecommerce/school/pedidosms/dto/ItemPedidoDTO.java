package br.com.ecommerce.school.pedidosms.dto;

import java.math.BigDecimal;

public class ItemPedidoDTO {

    private String codigo;
    private BigDecimal quantidade;

    public ItemPedidoDTO(String codigo, BigDecimal quantidade) {
        this.codigo = codigo;
        this.quantidade = quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedidoDTO{" +
                "produto='" + codigo + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
