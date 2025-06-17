package com.projeto.projeto_locadora.cliente.DTO;

import com.projeto.projeto_locadora.cliente.Status.ClienteStatus;
import com.projeto.projeto_locadora.cliente.Status.TipoCliente;

public record ClienteUpdateDTO (
    String nome,
    String email,
    String telefone,
    String cpf,
    String documento,
    String endereco,
    TipoCliente tipo,
    ClienteStatus status
    
){

}