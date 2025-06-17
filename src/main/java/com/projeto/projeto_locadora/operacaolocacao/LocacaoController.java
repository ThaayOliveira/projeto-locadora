package com.projeto.projeto_locadora.operacaolocacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.web.bind.annotation.*;

import com.projeto.projeto_locadora.item.Item;
import com.projeto.projeto_locadora.item.DTO.*;
import com.projeto.projeto_locadora.operacaolocacao.DTO.*;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {
    
    private final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @GetMapping
    public Page<LocacaoReadDTO> listarLocacoes(Pageable pageable) {
        return locacaoService.listarTodos(pageable);
    }

    @GetMapping("/{id}")
    public LocacaoReadDTO findById(@PathVariable Long id) {
        try {
            return LocacaoService.buscarPorId(id);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}/total")
    public ResponseEntity<Double> calcularTotalComMulta(@PathVariable Long id) {
        try {
            double total = locacaoService.calcularTotalComMulta(id);
            return ResponseEntity.ok(total);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocacaoReadDTO criarItem(@RequestBody LocacaoCreateDTO locacaoCreateDTO) {
        try {
            return LocacaoService.criar(locacaoCreateDTO);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}/devolucao")
    public ResponseEntity <LocacaoUpdateDTO> devolucao(@PathVariable Long id) {
        try {
            return locacaoService.devolucao(id);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirItem(@PathVariable Long id) {
        try {
            locacaoService.excluir(id);
        } catch (RuntimeException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
