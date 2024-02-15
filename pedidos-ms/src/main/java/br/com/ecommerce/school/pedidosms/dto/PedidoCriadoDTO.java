package br.com.ecommerce.school.pedidosms.dto;

public class PedidoCriadoDTO {

    private String codigo;

    public PedidoCriadoDTO(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
