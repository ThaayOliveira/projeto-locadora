package com.projeto.projeto_locadora.operacaolocacao.DTO;

import java.time.LocalDateTime;

import com.projeto.projeto_locadora.operacaolocacao.Locacao;

public record LocacaoReadDTO(

    Long id,
    LocalDateTime data,
    Double valorTotal
    
) {
    
    public static LocacaoReadDTO from(Locacao locacao) {
        return new LocacaoReadDTO(

        locacao.getId(),
        locacao.getdata(),
        locacao.getvalorTotal()
        
        );

    }
}
