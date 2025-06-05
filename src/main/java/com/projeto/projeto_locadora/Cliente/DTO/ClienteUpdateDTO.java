package com.projeto.projeto_locadora.Cliente.DTO;

import com.projeto.projeto_locadora.Cliente.Status.ClienteStatus;
import com.projeto.projeto_locadora.Cliente.Status.TipoCliente;

public class ClienteUpdateDTO {
    private String nome;
    private String email;
    private String telefone;
    private String documento;
    private String endereco;
    private TipoCliente tipo;
    private ClienteStatus status;
    
    public ClienteUpdateDTO() {
    }
    
    public ClienteUpdateDTO(String nome, String email, String telefone, 
                           String documento, String endereco, TipoCliente tipo, ClienteStatus status) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.documento = documento;
        this.endereco = endereco;
        this.tipo = tipo;
        this.status = status;
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