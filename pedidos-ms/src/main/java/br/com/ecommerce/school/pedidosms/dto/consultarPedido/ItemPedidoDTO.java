package br.com.ecommerce.school.pedidosms.dto.consultarPedido;

import java.math.BigDecimal;

public class ItemPedidoDTO {
    private String codigo;
    private String descricao;
    private BigDecimal quantidade;

    public ItemPedidoDTO(String descricao, BigDecimal quantidade, String codigo) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }
}
