package com.projeto.projeto_locadora.item.DTO;

import com.projeto.projeto_locadora.item.Item;
import com.projeto.projeto_locadora.item.Status.ItemStatus;
import com.projeto.projeto_locadora.item.Status.TipoItem;

public record ItemReadDTO(
        Long id,
        String titulo,
        String genero,
        Double precoDiario,
        TipoItem tipo,
        ItemStatus status
) {

    public static ItemReadDTO from(Item item) {
        return new ItemReadDTO(
                item.getId(),
                item.getTitulo(),
                item.getGenero(),
                item.getPrecoDiario(),
                item.getTipo(),
                item.getStatus());
    }
}
