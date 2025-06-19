package com.projeto.projeto_locadora.operacaolocacao;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projeto.projeto_locadora.operacaolocacao.DTO.*;

@Service
public class LocacaoService {

    private final LocacaoRepository locacaoRepository;
    private static final double VALOR_MULTA_DIARIA = 3.5;

    public LocacaoService(LocacaoRepository locacaoRepository) {
        this.locacaoRepository = locacaoRepository;
    }

    public Page<LocacaoReadDTO> listarTodos(Pageable pageable) {
        return locacaoRepository.findAll(pageable)
                .map(LocacaoReadDTO::from);
    }

    public Page<LocacaoReadDTO> listarLocacoesAtivas(Pageable pageable) {
        return locacaoRepository.findByDataDevolucaoIsNull(pageable)
                .map(LocacaoReadDTO::from);
    }

    public Page<LocacaoReadDTO> listarLocacoesAtrasadas(Pageable pageable) {
    return locacaoRepository.findByLocacoesAtrasadas(LocalDateTime.now(), pageable)
            .map(LocacaoReadDTO::from);
}


    public LocacaoReadDTO findById(Long id) {
        return LocacaoReadDTO.from(buscarOuFalhar(id));
    }

    public double calcularValorTotal(Long id) {
        return calcularValorTotal(buscarOuFalhar(id));
    }

    public double calcularMultaPorAtraso(Long id) {
        return calcularMulta(buscarOuFalhar(id));
    }

    public LocacaoReadDTO registrarDevolucao(Long id) {
        Locacao locacao = buscarOuFalhar(id);

        if (locacao.getDataDevolucao() != null) {
            throw new RuntimeException();
        }

        locacao.setDataDevolucao(LocalDateTime.now());
        locacao.setValorTotal(calcularValorTotal(locacao));

        return LocacaoReadDTO.from(locacaoRepository.save(locacao));
    }

    public LocacaoReadDTO criar(LocacaoCreateDTO dto) {
        Locacao locacao = LocacaoCreateDTO.mapper(dto);
        if (locacao.getData() == null) {
            locacao.setData(LocalDateTime.now());
        }

        return LocacaoReadDTO.from(locacaoRepository.save(locacao));
    }

    public void cancelarLocacao(Long id) {
        Locacao locacao = buscarOuFalhar(id);

        if (locacao.getDataDevolucao() != null) {
            throw new RuntimeException("Locação já devolvida. Não pode ser cancelada.");
        }

        if (locacao.getData().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Locação já iniciada. Cancelamento não permitido.");
        }

        locacaoRepository.deleteById(id);
    }

    private Locacao buscarOuFalhar(Long id) {
        return locacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException());
    }

    private double calcularValorTotal(Locacao locacao) {
        double base = locacao.getValorBase() != null ? locacao.getValorBase() : 0.0;
        return base + calcularMulta(locacao);
    }

    private double calcularMulta(Locacao locacao) {
        if (locacao.getDataPrevistaDevolucao() == null)
            return 0.0;

        LocalDateTime devolucao = locacao.getDataDevolucao() != null
                ? locacao.getDataDevolucao()
                : LocalDateTime.now();

        if (devolucao.isAfter(locacao.getDataPrevistaDevolucao())) {
            long diasAtraso = ChronoUnit.DAYS.between(
                    locacao.getDataPrevistaDevolucao().toLocalDate(),
                    devolucao.toLocalDate());
            return diasAtraso * VALOR_MULTA_DIARIA;
        }

        return 0.0;
    }

    public void excluir(Long id) {
        Locacao locacao = buscarOuFalhar(id);

        if (locacao.getDataDevolucao() != null) {
            throw new RuntimeException();
        }

        locacaoRepository.deleteById(id);
    }

}
