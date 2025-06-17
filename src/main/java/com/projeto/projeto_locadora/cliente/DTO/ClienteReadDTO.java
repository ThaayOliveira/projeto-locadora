package com.projeto.projeto_locadora.cliente.DTO;

import com.projeto.projeto_locadora.cliente.Cliente;
import com.projeto.projeto_locadora.cliente.Status.ClienteStatus;
import com.projeto.projeto_locadora.cliente.Status.TipoCliente;

public record ClienteReadDTO (
    Long id,
    String nome,
    String email,
    String telefone,
    String cpf,
    String documento,
    String endereco,
    TipoCliente tipo,
    ClienteStatus status
){
    
   public static ClienteReadDTO from(Cliente cliente) {
        return new ClienteReadDTO(
            
            cliente.getId(),
            cliente.getNome(),
            cliente.getEmail(),
            cliente.getTelefone(),
            cliente.getCpf(),
            cliente.getDocumento(),
            cliente.getEndereco(),
            cliente.getTipo(),
            cliente.getStatus());

    }
}