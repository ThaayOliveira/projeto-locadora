package com.projeto.projeto_locadora.operacaolocacao;

import java.time.LocalDateTime;

import com.projeto.projeto_locadora.cliente.Cliente;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

public class Locacao {

    Long numId;
    LocalDateTime data;
    Double valorTotal;

    @OneToMany
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    public Long getnumId(){
        return numId;
    }

    public void setnumId(long numId){
        this.numId = numId;
    }

    public LocalDateTime getdata(){
        return data;
    }

    public void setdata(LocalDateTime data){
        this.data = data;
    }

    public Double getvalorTotal(){
        return valorTotal;
    }

    public void setvalorTotal(Double valorTotal){
        this.valorTotal = valorTotal;
    }

}
