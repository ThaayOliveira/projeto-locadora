package com.projeto.projeto_locadora.operacaolocacao.DTO;

import java.time.LocalDateTime;

import com.projeto.projeto_locadora.operacaolocacao.Locacao;


public record LocacaoCreateDTO(

    Long id,
    LocalDateTime data,
    Double valorTotal,
    LocalDateTime dataPrevistaDevolucao,
    LocalDateTime dataDevolucao

){ 
    public static Locacao mapper(LocacaoCreateDTO dto) {
        Locacao locacao = new Locacao();
        
        locacao.setId(dto.id);
        locacao.setData(dto.data);
        locacao.setValorTotal(dto.valorTotal);
        locacao.setDataPrevistaDevolucao(dto.dataPrevistaDevolucao);
        locacao.setDataDevolucao(dto.dataDevolucao);
        return locacao;
    }
}
