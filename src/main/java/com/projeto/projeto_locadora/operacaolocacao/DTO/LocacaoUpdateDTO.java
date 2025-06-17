package com.projeto.projeto_locadora.operacaolocacao.DTO;

import java.time.LocalDateTime;

public record LocacaoUpdateDTO(

    Long id,
    LocalDateTime data,
    Double valorTotal

) {}
