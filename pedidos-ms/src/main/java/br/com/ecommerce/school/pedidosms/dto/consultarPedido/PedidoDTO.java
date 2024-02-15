package br.com.ecommerce.school.pedidosms.dto.consultarPedido;

import java.util.List;

public class PedidoDTO {
    private String codigo;
    private String status;
    private ClienteDTO cliente;
    private List<ItemPedidoDTO> produtos;

    public PedidoDTO(String codigo, ClienteDTO cliente, List<ItemPedidoDTO> produtos, String status) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.produtos = produtos;
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public List<ItemPedidoDTO> getProdutos() {
        return produtos;
    }

    public String getStatus() {
        return status;
    }
}
