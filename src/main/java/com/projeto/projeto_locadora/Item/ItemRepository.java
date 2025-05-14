package com.projeto.projeto_locadora.Item;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.projeto_locadora.Item.Status.ItemStatus;
import com.projeto.projeto_locadora.Item.Status.TipoItem;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Page<Item> findByTituloContainingIgnoreCase(String titulo, Pageable pageable);

    Page<Item> findByGenero(String genero, Pageable pageable);

    List<Item> findByTipo(TipoItem tipo);

    Page<Item> findByStatus(ItemStatus status, Pageable pageable);

    Page<Item> findByPrecoDiarioBetween(Double precoMin, Double precoMax, Pageable pageable);


}