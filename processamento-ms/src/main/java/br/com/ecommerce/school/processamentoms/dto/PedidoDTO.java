package br.com.ecommerce.school.processamentoms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public class PedidoDTO implements Serializable {

    private String codigo;
    private String cliente;
    private List<ItemPedidoDTO> produtos;

    public PedidoDTO(@JsonProperty("cliente") String cliente,
                     @JsonProperty("produtos")List<ItemPedidoDTO> produtos,
                     @JsonProperty("codigo")String codigo) {
        this.cliente = cliente;
        this.produtos = produtos;
        this.codigo = codigo;
    }

    public String getCliente() {
        return cliente;
    }

    public List<ItemPedidoDTO> getProdutos() {
        return produtos;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return "PedidoDTO{" +
                "cliente=" + cliente +
                ", produtos=" + produtos +
                '}';
    }
}
