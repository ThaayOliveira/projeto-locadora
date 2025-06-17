package com.projeto.projeto_locadora.operacaolocacao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    Page<Locacao> findAll (String findAll, Pageable pageable);

    Optional<Locacao> findById (Long id);
    
}
