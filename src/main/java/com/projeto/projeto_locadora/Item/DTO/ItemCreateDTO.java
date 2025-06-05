package com.projeto.projeto_locadora.item.DTO;

import com.projeto.projeto_locadora.item.Item;
import com.projeto.projeto_locadora.item.Status.ItemStatus;
import com.projeto.projeto_locadora.item.Status.TipoItem;

public record ItemCreateDTO(

    String titulo,
    String genero,
    Double precoDiario,
    TipoItem tipo,
    ItemStatus status
)
{
    public static Item mapper(ItemCreateDTO dto) {

        Item item = new Item();

            item.setTitulo(dto.titulo());
            item.setGenero(dto.genero());
            item.setTipo(dto.tipo());
            item.setPrecoDiario(dto.precoDiario());
            item.setStatus(dto.status());
            return item;
    }
}
