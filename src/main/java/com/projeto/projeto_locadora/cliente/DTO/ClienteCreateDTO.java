package com.projeto.projeto_locadora.cliente.DTO;

import com.projeto.projeto_locadora.cliente.Cliente;
import com.projeto.projeto_locadora.cliente.Status.ClienteStatus;
import com.projeto.projeto_locadora.cliente.Status.TipoCliente;

public record ClienteCreateDTO (
    String nome,
    String email,
    String telefone,
    String cpf,
    String documento,
    String endereco,
    TipoCliente tipo,
    ClienteStatus status
){
    
    public static Cliente mapper(ClienteCreateDTO dto) {
        Cliente cliente = new Cliente();

        cliente.setNome(dto.nome());
        cliente.setEmail(dto.email());
        cliente.setTelefone(dto.telefone());
        cliente.setCpf(dto.cpf());
        cliente.setDocumento(dto.documento());
        cliente.setEndereco(dto.endereco());
        cliente.setTipo(dto.tipo());
        cliente.setStatus(dto.status());
        return cliente;
    }
    
}