package com.projeto.projeto_locadora.operacaolocacao;

import java.time.LocalDateTime;

import com.projeto.projeto_locadora.cliente.Cliente;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

public class Locacao {

    Long id;
    LocalDateTime data;
    Double valorTotal;

    LocalDateTime dataPrevistaDevolucao;
    LocalDateTime dataDevolucao;
    Double valorBase;

    @OneToMany
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;


    public Long getId(){
        return id;
    }

    public void setId( Long id){
        this.id = id;
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

    public Double getvalorBase() {
        return valorBase;
    }

    public void setvalorBase(Double valorBase) {
        this.valorBase = valorBase;
    }

    public LocalDateTime getdataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setdataPrevistaDevolucao(LocalDateTime dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDateTime getdataDevolucao() {
        return dataDevolucao;
    }


}
