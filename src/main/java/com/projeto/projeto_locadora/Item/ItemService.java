package com.projeto.projeto_locadora.item;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.projeto.projeto_locadora.item.DTO.*;
import com.projeto.projeto_locadora.item.Status.ItemStatus;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public Page<ItemReadDTO> listarTodos(Pageable pageable) {
        return itemRepository.findAll(pageable)
                .map(this::convertToItemReadDTO);
    }

    public ItemReadDTO buscarPorId(Long id) {
        return itemRepository.findById(id)
                .map(this::convertToItemReadDTO)
                .orElseThrow(() -> new RuntimeException("Item não encontrado" + id));
    }

    public ItemReadDTO criar(ItemCreateDTO dto) {
        Item novoItem = new Item();
        novoItem.setTitulo(dto.titulo());
        novoItem.setGenero(dto.genero());
        novoItem.setPrecoDiario(dto.precoDiario());
        novoItem.setTipo(dto.tipo());
        novoItem.setStatus(dto.status() != null ? dto.status() : ItemStatus.DISPONIVEL);
        novoItem.setImagemUrl(dto.imagemUrl());

        Item salvo = itemRepository.save(novoItem);
        return ItemReadDTO.from(salvo);
    }

    public ItemReadDTO atualizar(Long id, ItemUpdateDTO dto) {
        Item item = itemRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    
        if (dto.titulo() != null) item.setTitulo(dto.titulo());
        if (dto.status() != null) item.setStatus(dto.status());
    
        return convertToItemReadDTO(itemRepository.save(item));
    }

    public void excluir(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("");
        }
        itemRepository.deleteById(id);
    }

    private ItemReadDTO convertToItemReadDTO(Item item) {
        return new ItemReadDTO(
                item.getId(),
                item.getTitulo(),
                item.getGenero(),
                item.getPrecoDiario(),
                item.getTipo(),
                item.getStatus(),
                item.getImagemUrl());
    }
}