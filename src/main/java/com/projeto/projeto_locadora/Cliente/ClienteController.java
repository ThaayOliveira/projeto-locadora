package com.projeto.projeto_locadora.Cliente;

import com.projeto.projeto_locadora.Cliente.DTO.ClienteCreateDTO;
import com.projeto.projeto_locadora.Cliente.DTO.ClienteReadDTO;
import com.projeto.projeto_locadora.Cliente.DTO.ClienteUpdateDTO;
import com.projeto.projeto_locadora.Cliente.Status.ClienteStatus;
import com.projeto.projeto_locadora.Cliente.Status.TipoCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;
    
    @GetMapping
    public ResponseEntity<List<ClienteReadDTO>> listarClientes(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) TipoCliente tipo,
            @RequestParam(required = false) ClienteStatus status) {
        
        List<ClienteReadDTO> clientes;
        
        if (nome != null || email != null || tipo != null || status != null) {
            clientes = clienteService.listarComFiltros(nome, email, tipo, status);
        } else {
            clientes = clienteService.listarTodos();
        }
        
        return ResponseEntity.ok(clientes);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ClienteReadDTO> buscarPorId(@PathVariable Long id) {
        Optional<ClienteReadDTO> cliente = clienteService.buscarPorId(id);
        
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<ClienteReadDTO> buscarPorEmail(@PathVariable String email) {
        Optional<ClienteReadDTO> cliente = clienteService.buscarPorEmail(email);
        
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/documento/{documento}")
    public ResponseEntity<ClienteReadDTO> buscarPorDocumento(@PathVariable String documento) {
        Optional<ClienteReadDTO> cliente = clienteService.buscarPorDocumento(documento);
        
        if (cliente.isPresent()) {
            return ResponseEntity.ok(cliente.get());
        } else {
            return ResponseEntity.notFound().build();
        }
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
                                                          @RequestBody ClienteUpdateDTO clienteUpdateDTO) {
        try {
            Optional<ClienteReadDTO> clienteAtualizado = clienteService.atualizarCliente(id, clienteUpdateDTO);
            
            if (clienteAtualizado.isPresent()) {
                return ResponseEntity.ok(clienteAtualizado.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        boolean deletado = clienteService.deletarCliente(id);
        
        if (deletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    // Endpoint para ver histórico de locações de um cliente
    @GetMapping("/{id}/historico-locacoes")
    public ResponseEntity<String> verHistoricoLocacoes(@PathVariable Long id) {
        // Este endpoint retorna uma mensagem indicando que a funcionalidade será implementada
        // quando a entidade Locacao for criada
        Optional<ClienteReadDTO> cliente = clienteService.buscarPorId(id);
        
        if (cliente.isPresent()) {
            return ResponseEntity.ok("Histórico de locações do cliente " + cliente.get().getNome() + 
                                   " (ID: " + id + ") será implementado quando a entidade Locacao for criada.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}