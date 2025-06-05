package com.projeto.projeto_locadora.Cliente;

import com.projeto.projeto_locadora.Cliente.Cliente;
import com.projeto.projeto_locadora.Cliente.DTO.ClienteReadDTO;
import com.projeto.projeto_locadora.Cliente.Status.ClienteStatus;
import com.projeto.projeto_locadora.Cliente.Status.TipoCliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(TipoCliente tipo);
    Optional<Cliente> findByEmail(String email);
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String email);
    Collection<ClienteReadDTO> findByFiltros(String nome, String email, TipoCliente tipo, ClienteStatus status);
    boolean existsByDocumento(String documento);
    Optional<Cliente> findByDocumento(String documento);
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    List<Cliente> findByStatus(ClienteStatus status);
    List<Cliente> findByTipo(TipoCliente tipo);
}