package br.com.ecommerce.school.pedidosms.dto;

import java.util.List;

public class PedidoDTO {

    private String codigo;
    private String cliente;
    private List<ItemPedidoDTO> produtos;

    public PedidoDTO(String codigo, String cliente, List<ItemPedidoDTO> produtos) {
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

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setProdutos(List<ItemPedidoDTO> produtos) {
        this.produtos = produtos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void addCodigoGerado(String codigo){
        this.codigo = codigo;

    }
}
