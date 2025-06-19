package com.projeto.projeto_locadora.operacaolocacao;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {
    @Query("SELECT l FROM Locacao l WHERE l.dataPrevistaDevolucao < :dataAtual AND l.dataDevolucao IS NULL")
    Page<Locacao> findByLocacoesAtrasadas(@Param("dataAtual") LocalDateTime dataAtual, Pageable pageable);

    Page<Locacao> findByDataDevolucaoIsNull(Pageable pageable);

}
