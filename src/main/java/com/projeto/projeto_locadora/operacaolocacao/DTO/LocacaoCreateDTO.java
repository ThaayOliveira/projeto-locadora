package com.projeto.projeto_locadora.operacaolocacao.DTO;

import java.time.LocalDateTime;

import com.projeto.projeto_locadora.operacaolocacao.Locacao;

public record LocacaoCreateDTO(

    Long id,
    LocalDateTime data,
    Double valorTotal

){ 
    public static Locacao mapper(LocacaoCreateDTO dto) {
        Locacao locacao = new Locacao();
        
        locacao.setId(dto.id);
        locacao.setdata(dto.data);
        locacao.setvalorTotal(dto.valorTotal);
        return locacao;
    }
}
