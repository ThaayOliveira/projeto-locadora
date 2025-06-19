package com.projeto.projeto_locadora.operacaolocacao;

import java.time.LocalDateTime;
import java.util.List;

import com.projeto.projeto_locadora.cliente.Cliente;
import com.projeto.projeto_locadora.fitalocacao.FitaLocacao;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "locacao")
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data;
    private Double valorTotal;

    private LocalDateTime dataPrevistaDevolucao;
    private LocalDateTime dataDevolucao;
    private Double valorBase;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "locacao", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FitaLocacao> fitasLocacao;

    public Locacao() {}

    public Long getId(){
        return id;
    }

    public void setId( Long id){
        this.id = id;
    }

    public LocalDateTime getData(){
        return data;
    }

    public void setData(LocalDateTime data){
        this.data = data;
    }

    public Double getValorTotal(){
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal){
        this.valorTotal = valorTotal;
    }

    public Double getValorBase() {
        return valorBase;
    }

    public void setValorBase(Double valorBase) {
        this.valorBase = valorBase;
    }

    public LocalDateTime getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public void setDataPrevistaDevolucao(LocalDateTime dataPrevistaDevolucao) {
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<FitaLocacao> getFitasLocacao() {
        return fitasLocacao;
    }

    public void setFitasLocacao(List<FitaLocacao> fitasLocacao) {
        this.fitasLocacao = fitasLocacao;
    }

}
