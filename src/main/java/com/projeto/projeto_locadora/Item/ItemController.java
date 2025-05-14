package com.projeto.projeto_locadora.Item;

import com.projeto.projeto_locadora.Item.DTO.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public Page<ItemReadDTO> listarItens(Pageable pageable) {
        return itemService.listarTodos(pageable);
    }

    @GetMapping("/{id}")
    public ItemReadDTO buscarPorId(@PathVariable Long id) {
        try {
            return itemService.buscarPorId(id);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado com ID: " + id);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ItemReadDTO criarItem(@RequestBody ItemCreateDTO itemCreateDTO) {
        try {
            return itemService.criar(itemCreateDTO);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Dados inválidos");
        }
    }

    @PutMapping("/{id}")
    public ItemReadDTO atualizarItem(
            @PathVariable Long id,
            @RequestBody ItemUpdateDTO itemUpdateDTO) {

        return itemService.atualizar(id, itemUpdateDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirItem(@PathVariable Long id) {
        try {
            itemService.excluir(id);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item não encontrado para exclusão");
        }
    }
}