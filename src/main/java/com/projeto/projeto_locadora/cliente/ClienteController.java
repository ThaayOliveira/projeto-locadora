package com.projeto.projeto_locadora.cliente;

import com.projeto.projeto_locadora.cliente.DTO.ClienteCreateDTO;
import com.projeto.projeto_locadora.cliente.DTO.ClienteReadDTO;
import com.projeto.projeto_locadora.cliente.DTO.ClienteUpdateDTO;
import com.projeto.projeto_locadora.cliente.Status.ClienteStatus;
import com.projeto.projeto_locadora.cliente.Status.TipoCliente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public Page<ClienteReadDTO> listarClientes(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) TipoCliente tipo,
            @RequestParam(required = false) ClienteStatus status,
            Pageable pageable) {

        if (nome != null || email != null || tipo != null || status != null) {
            return clienteService.listarTodos(pageable);
        }
        return clienteService.listarTodos(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteReadDTO> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ClienteReadDTO> buscarPorEmail(@PathVariable String email) {
        return clienteService.buscarPorEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/documento/{documento}")
    public ResponseEntity<ClienteReadDTO> buscarPorDocumento(@PathVariable String documento) {
        return clienteService.buscarPorDocumento(documento)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ClienteReadDTO>> listarPorStatus(@PathVariable ClienteStatus status) {
        List<ClienteReadDTO> clientes = clienteService.listarPorStatus(status);
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<ClienteReadDTO>> listarPorTipo(@PathVariable TipoCliente tipo) {
        List<ClienteReadDTO> clientes = clienteService.listarPorTipo(tipo);
        return ResponseEntity.ok(clientes);
    }

    @PostMapping
    public ResponseEntity<ClienteReadDTO> criarCliente(@RequestBody ClienteCreateDTO clienteCreateDTO) {
        try {
            ClienteReadDTO novoCliente = clienteService.criarCliente(clienteCreateDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoCliente);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteReadDTO> atualizarCliente(@PathVariable Long id,
            @RequestBody ClienteUpdateDTO dto) {
        try {
            return clienteService.atualizarCliente(id, dto)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        return clienteService.deletarCliente(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    // Endpoint para ver histórico de locações de um cliente
    @GetMapping("/historico-locacoes/{id}")
    public ResponseEntity<String> verHistoricoLocacoes(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(cliente -> ResponseEntity.ok("Histórico de locações do cliente " + cliente.nome() +
                        " (ID: " + id + ") será implementado quando a entidade Locacao for criada."))
                .orElse(ResponseEntity.notFound().build());
    }

}