package com.projeto.projeto_locadora.fita;

import jakarta.persistence.*;
import java.util.Set;

import com.projeto.projeto_locadora.filme.Filme;
import com.projeto.projeto_locadora.filmesfita.FilmesFita;
import com.projeto.projeto_locadora.fitalocacao.FitaLocacao;

@Entity
@Table(name = "fita")
public class Fita {
    
    @Id
    @Column(name = "cod_fita")
    private String codFita;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "diretor")
    private String diretor;
    
    @Column(name = "valor_fita")
    private Double valorFita;

    @ManyToOne
    @JoinColumn(name = "cod_filme")
    private Filme filme;
    
    @OneToMany(mappedBy = "fita", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FilmesFita> filmesFitas;
    
    @OneToMany(mappedBy = "fita", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FitaLocacao> fitasLocacoes;
    
    public Fita() {}
    
    public Fita(String codFita, String nome, String diretor, Double valorFita) {
        this.codFita = codFita;
        this.nome = nome;
        this.diretor = diretor;
        this.valorFita = valorFita;
    }
    
    public String getCodFita() {
        return codFita;
    }
    
    public void setCodFita(String codFita) {
        this.codFita = codFita;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getDiretor() {
        return diretor;
    }
    
    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    
    public Double getValorFita() {
        return valorFita;
    }
    
    public void setValorFita(Double valorFita) {
        this.valorFita = valorFita;
    }
    
    public Set<FilmesFita> getFilmesFitas() {
        return filmesFitas;
    }
    
    public void setFilmesFitas(Set<FilmesFita> filmesFitas) {
        this.filmesFitas = filmesFitas;
    }
    
    public Set<FitaLocacao> getFitasLocacoes() {
        return fitasLocacoes;
    }
    
    public void setFitasLocacoes(Set<FitaLocacao> fitasLocacoes) {
        this.fitasLocacoes = fitasLocacoes;
    }
    
    @Override
    public String toString() {
        return "Fita{" +
                "codFita='" + codFita + '\'' +
                ", nome='" + nome + '\'' +
                ", diretor='" + diretor + '\'' +
                ", valorFita=" + valorFita +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fita)) return false;
        Fita fita = (Fita) o;
        return codFita != null ? codFita.equals(fita.codFita) : fita.codFita == null;
    }
    
    @Override
    public int hashCode() {
        return codFita != null ? codFita.hashCode() : 0;
    }
}
