package com.projeto.projeto_locadora.cliente;

import com.projeto.projeto_locadora.cliente.DTO.ClienteCreateDTO;
import com.projeto.projeto_locadora.cliente.DTO.ClienteReadDTO;
import com.projeto.projeto_locadora.cliente.DTO.ClienteUpdateDTO;
import com.projeto.projeto_locadora.cliente.Status.ClienteStatus;
import com.projeto.projeto_locadora.cliente.Status.TipoCliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Page<ClienteReadDTO> listarTodos(Pageable pageable) {
        return clienteRepository.findAll(pageable)
                .map(ClienteReadDTO::from);
    }

    public Optional<ClienteReadDTO> buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .map(ClienteReadDTO::from);
    }

    public Optional<ClienteReadDTO> buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email)
                .map(ClienteReadDTO::from);
    }

    public Optional<ClienteReadDTO> buscarPorDocumento(String documento) {
        return clienteRepository.findByDocumento(documento)
                .map(ClienteReadDTO::from);
    }

    public ClienteReadDTO criarCliente(ClienteCreateDTO dto) {

        Cliente cliente = ClienteCreateDTO.mapper(dto);
        if (cliente.getStatus() == null) {
            cliente.setStatus(ClienteStatus.ATIVO);
        }

        Cliente salvo = clienteRepository.save(cliente);
        return ClienteReadDTO.from(salvo);
    }

    public Optional<ClienteReadDTO> atualizarCliente(Long id, ClienteUpdateDTO dto) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (dto.nome() != null)
            cliente.setNome(dto.nome());
        if (dto.email() != null)
            cliente.setEmail(dto.email());
        if (dto.telefone() != null)
            cliente.setTelefone(dto.telefone());
        if (dto.cpf() != null)
            cliente.setCpf(dto.cpf());
        if (dto.documento() != null)
            cliente.setDocumento(dto.documento());
        if (dto.endereco() != null)
            cliente.setEndereco(dto.endereco());
        if (dto.tipo() != null)
            cliente.setTipo(dto.tipo());
        if (dto.status() != null)
            cliente.setStatus(dto.status());

        Cliente atualizado = clienteRepository.save(cliente);
        return Optional.of(ClienteReadDTO.from(atualizado));
    }

    public boolean deletarCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            return false;
        }
        clienteRepository.deleteById(id);
        return true;
    }

    public List<ClienteReadDTO> listarPorStatus(ClienteStatus status) {
        return clienteRepository.findByStatus(status).stream()
                .map(ClienteReadDTO::from)
                .collect(Collectors.toList());
    }

    public List<ClienteReadDTO> listarPorTipo(TipoCliente tipo) {
        return clienteRepository.findByTipo(tipo).stream()
                .map(ClienteReadDTO::from)
                .collect(Collectors.toList());
    }

    public Page<ClienteReadDTO> listarComFiltros(String nome, String email, TipoCliente tipo, ClienteStatus status, Pageable pageable) {
        return clienteRepository.findAll(pageable)
            .map(ClienteReadDTO::from);
    }
}