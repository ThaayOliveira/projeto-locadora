package com.projeto.projeto_locadora.cliente;

import com.projeto.projeto_locadora.cliente.Status.ClienteStatus;
import com.projeto.projeto_locadora.cliente.Status.TipoCliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(TipoCliente tipo);
    Optional<Cliente> findByEmail(String email);
    Optional<Cliente> findByDocumento(String documento);
    List<Cliente> findByNomeContainingIgnoreCase(String nome);
    List<Cliente> findByStatus(ClienteStatus status);
    List<Cliente> findByTipo(TipoCliente tipo);
}