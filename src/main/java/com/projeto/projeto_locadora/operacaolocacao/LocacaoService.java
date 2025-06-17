package com.projeto.projeto_locadora.operacaolocacao;

import java.time.temporal.ChronoUnit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projeto.projeto_locadora.operacaolocacao.DTO.*;

@Service
public class LocacaoService {
    private final LocacaoRepository locacaoRepository;

    public LocacaoService(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    public Page<LocacaoReadDTO> listarTodos(Pageable pageable) {
        return locacaoRepository.findAll(pageable)
                .map(this::convertToLocacaoReadDTO);
    }

    public LocacaoReadDTO findById(Long id) {
        return locacaoRepository.findById(id)
                .map(this::convertToLocacaoReadDTO)
                .orElseThrow(() -> new RuntimeException());
    }

    public double calcularTotalComMulta(Long id) {
    Locacao locacao = buscarPorId(id); // Assumindo que esse método já existe

    double multa = 0.0;

    if (locacao.getdataDevolucao() != null && locacao.getdataPrevistaDevolucao() != null) {
        long diasAtraso = ChronoUnit.DAYS.between(
            locacao.getdataPrevistaDevolucao().toLocalDate(),
            locacao.getdataDevolucao().toLocalDate()
        );

        if (diasAtraso > 0) {
            multa = diasAtraso * 5.0; // R$5 por dia
        }

    }
    double total = locacao.getvalorBase() + multa;
    locacao.setvalorBase(total);
    
    return total;
    }

    public LocacaoReadDTO criar(LocacaoCreateDTO dto) {
        Locacao novaLocacao = new Locacao();
        novaLocacao.setCliente(dto.cliente());
        novaLocacao.setItens(dto.itens());
        novaLocacao.setValorTotal(dto.valorTotal());
        novaLocacao.setDataLocacao(dto.dataLocacao());
        novaLocacao.setDataDevolucao(dto.dataDevolucao());

        Locacao salvo = LocacaoRepository.save(novoItem);
        return LocacaoReadDTO.from(salvo);
    }

    public void excluir(Long id) {
        if (!locacaoRepository.existsById(id)) {
            throw new RuntimeException("");
        }
        locacaoRepository.deleteById(id);
    }
}
