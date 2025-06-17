package com.projeto.projeto_locadora.cliente;


import com.projeto.projeto_locadora.cliente.Status.ClienteStatus;

import com.projeto.projeto_locadora.cliente.Status.TipoCliente;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;
    String telefone;
    String cpf;
    String documento;
    String endereco;
    @Enumerated(EnumType.STRING)
    TipoCliente tipo;
    @Enumerated(EnumType.STRING)
    ClienteStatus status;
    
    public Cliente() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getDocumento() {
        return documento;
    }
    
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public TipoCliente getTipo() {
        return tipo;
    }
    
    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo;
    }
    
    public ClienteStatus getStatus() {
        return status;
    }
    
    public void setStatus(ClienteStatus status) {
        this.status = status;
    }
}