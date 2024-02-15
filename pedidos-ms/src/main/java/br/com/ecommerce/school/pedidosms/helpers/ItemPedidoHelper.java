package br.com.ecommerce.school.pedidosms.helpers;

import br.com.ecommerce.school.pedidosms.dto.ItemPedidoDTO;
import br.com.ecommerce.school.pedidosms.entity.ItemPedido;

import java.util.ArrayList;
import java.util.List;

public final class ItemPedidoHelper {

    private ItemPedidoHelper() {
    }

    public static List<ItemPedido> parseItemPedidoDTOS(List<ItemPedido> itemPedidos, List<ItemPedidoDTO> itemPedidoDTOS) {
        if (itemPedidos == null) return new ArrayList<>();
        itemPedidoDTOS.forEach(dto ->
            itemPedidos.add(new ItemPedido(dto.getCodigo(), dto.getQuantidade())));
        return itemPedidos;
    }

    public static List<ItemPedido> parseItemPedidoDTOS(List<ItemPedidoDTO> produtosDto) {
        return parseItemPedidoDTOS(new ArrayList<>(), produtosDto);
    }
}
