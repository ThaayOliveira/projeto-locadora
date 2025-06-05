package com.projeto.projeto_locadora.Cliente;

import com.projeto.projeto_locadora.Cliente.DTO.ClienteCreateDTO;
import com.projeto.projeto_locadora.Cliente.DTO.ClienteReadDTO;
import com.projeto.projeto_locadora.Cliente.DTO.ClienteUpdateDTO;
import com.projeto.projeto_locadora.Cliente.Status.ClienteStatus;
import com.projeto.projeto_locadora.Cliente.Status.TipoCliente;
import com.projeto.projeto_locadora.Cliente.Cliente;
import com.projeto.projeto_locadora.Cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    public List<ClienteReadDTO> listarTodos() {
        return clienteRepository.findAll().stream()
                .map(this::convertToReadDTO)
                .collect(Collectors.toList());
    }
    
    
    public List<ClienteReadDTO> listarComFiltros(String nome, String email, 
                                                TipoCliente tipo, ClienteStatus status) {
        return new java.util.ArrayList<>(clienteRepository.findByFiltros(nome, email, tipo, status));
    }
    
    public Optional<ClienteReadDTO> buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .map(this::convertToReadDTO);
    }
    
    public Optional<ClienteReadDTO> buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email)
                .map(this::convertToReadDTO);
    }
    
    
    public Optional<ClienteReadDTO> buscarPorDocumento(String documento) {
        return clienteRepository.findByDocumento(documento)
            .map(this::convertToReadDTO);
    }
    
    public ClienteReadDTO criarCliente(ClienteCreateDTO clienteCreateDTO) {
        if (clienteRepository.existsByEmail(clienteCreateDTO.getEmail())) {
            throw new RuntimeException("Cliente com este email já existe");
        }
        
        if (clienteRepository.existsByDocumento(clienteCreateDTO.getDocumento())) {
            throw new RuntimeException("Cliente com este documento já existe");
        }
        
        Cliente cliente = convertToEntityFromCreate(clienteCreateDTO);
        Cliente clienteSalvo = clienteRepository.save(cliente);
        return convertToReadDTO(clienteSalvo);
    }
    
    public Optional<ClienteReadDTO> atualizarCliente(Long id, ClienteUpdateDTO clienteUpdateDTO) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    // Verificar se email já existe em outro cliente
                    if (!cliente.getEmail().equals(clienteUpdateDTO.getEmail()) && 
                        clienteRepository.existsByEmail(clienteUpdateDTO.getEmail())) {
                        throw new RuntimeException("Email já está em uso por outro cliente");
                    }
                    
                    // Verificar se documento já existe em outro cliente
                    if (!cliente.getDocumento().equals(clienteUpdateDTO.getDocumento()) && 
                        clienteRepository.existsByDocumento(clienteUpdateDTO.getDocumento())) {
                        throw new RuntimeException("Documento já está em uso por outro cliente");
                    }
                    
                    cliente.setNome(clienteUpdateDTO.getNome());
                    cliente.setEmail(clienteUpdateDTO.getEmail());
                    cliente.setTelefone(clienteUpdateDTO.getTelefone());
                    cliente.setDocumento(clienteUpdateDTO.getDocumento());
                    cliente.setEndereco(clienteUpdateDTO.getEndereco());
                    cliente.setTipo(clienteUpdateDTO.getTipo());
                    cliente.setStatus(clienteUpdateDTO.getStatus());
                    
                    Cliente clienteAtualizado = clienteRepository.save(cliente);
                    return convertToReadDTO(clienteAtualizado);
                });
    }
    
    public boolean deletarCliente(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<ClienteReadDTO> listarPorStatus(ClienteStatus status) {
        return clienteRepository.findByStatus(status).stream()
                .map(this::convertToReadDTO)
                .collect(Collectors.toList());
    }
    
    public List<ClienteReadDTO> listarPorTipo(TipoCliente tipo) {
        return clienteRepository.findByTipo(tipo).stream()
                .map(this::convertToReadDTO)
                .collect(Collectors.toList());
    }
    
    private ClienteReadDTO convertToReadDTO(Cliente cliente) {
        return new ClienteReadDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getDocumento(),
                cliente.getEndereco(),
                cliente.getTipo(),
                cliente.getStatus()
        );
    }
    
    private Cliente convertToEntityFromCreate(ClienteCreateDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setEmail(dto.getEmail());
        cliente.setTelefone(dto.getTelefone());
        cliente.setDocumento(dto.getDocumento());
        cliente.setEndereco(dto.getEndereco());
        cliente.setTipo(dto.getTipo());
        cliente.setStatus(dto.getStatus() != null ? dto.getStatus() : ClienteStatus.ATIVO);
        return cliente;
    }
}