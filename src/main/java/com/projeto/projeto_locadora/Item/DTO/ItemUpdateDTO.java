package com.projeto.projeto_locadora.Item.DTO;

import com.projeto.projeto_locadora.Item.Status.ItemStatus;
import com.projeto.projeto_locadora.Item.Status.TipoItem;

public record ItemUpdateDTO(
        String titulo,
        String genero,
        Double precoDiario,
        TipoItem tipo,
        ItemStatus status
    ) {}
