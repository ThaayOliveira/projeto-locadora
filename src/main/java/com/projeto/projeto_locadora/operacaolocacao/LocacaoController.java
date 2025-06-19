package com.projeto.projeto_locadora.operacaolocacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.projeto.projeto_locadora.operacaolocacao.DTO.*;

@RestController
@RequestMapping("/locacoes")
public class LocacaoController {
    
    private final LocacaoService locacaoService;

    public LocacaoController(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @GetMapping
    public Page<LocacaoReadDTO> listarLocacoes(Pageable pageable) {
        return locacaoService.listarTodos(pageable);
    }

    @GetMapping("/ativas")
    public Page<LocacaoReadDTO> listarLocacoesAtivas(Pageable pageable) {
        return locacaoService.listarLocacoesAtivas(pageable);
    }

    @GetMapping("/atrasadas")
    public Page<LocacaoReadDTO> listarLocacoesAtrasadas(Pageable pageable) {
        return locacaoService.listarLocacoesAtrasadas(pageable);
    }

    @GetMapping("/{id}")
    public LocacaoReadDTO findById(@PathVariable Long id) {
        return locacaoService.findById(id);
    }

    @GetMapping("/{id}/total")
    public ResponseEntity<Double> calcularTotalComMulta(@PathVariable Long id) {
        return ResponseEntity.ok(locacaoService.calcularValorTotal(id));
    }

    @GetMapping("/{id}/multa")
    public ResponseEntity<Double> calcularMulta(@PathVariable Long id) {
        return ResponseEntity.ok(locacaoService.calcularMultaPorAtraso(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LocacaoReadDTO criarLocacao(@RequestBody LocacaoCreateDTO dto) {
        return locacaoService.criar(dto);
    }

    @PutMapping("/{id}/devolucao")
    public LocacaoReadDTO registrarDevolucao(@PathVariable Long id) {
        return locacaoService.registrarDevolucao(id);
    }

    @DeleteMapping("/{id}/cancelar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancelarLocacao(@PathVariable Long id) {
        locacaoService.cancelarLocacao(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirLocacao(@PathVariable Long id) {
        locacaoService.excluir(id);
    }
}
