package com.projeto.projeto_locadora.item.DTO;

import com.projeto.projeto_locadora.item.Status.ItemStatus;
import com.projeto.projeto_locadora.item.Status.TipoItem;

public record ItemUpdateDTO(
        String titulo,
        String genero,
        Double precoDiario,
        TipoItem tipo,
        ItemStatus status,
        String imagemUrl
    ) {}
