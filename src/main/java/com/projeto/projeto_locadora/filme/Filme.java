package com.projeto.projeto_locadora.filme;

import jakarta.persistence.*;
import java.util.Set;

import com.projeto.projeto_locadora.atorfilme.model.AtorFilme;
import com.projeto.projeto_locadora.fita.Fita;

@Entity
@Table(name = "filme")
public class Filme {
    
    @Id
    @Column(name = "cod_filme")
    private String codFilme;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "diretor")
    private String diretor;
    
    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Fita> fitas;
    
    @OneToMany(mappedBy = "filme", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AtorFilme> atoresFilmes;
    
    public Filme() {}
    
    public Filme(String codFilme, String nome, String diretor) {
        this.codFilme = codFilme;
        this.nome = nome;
        this.diretor = diretor;
    }
    
    public String getCodFilme() {
        return codFilme;
    }
    
    public void setCodFilme(String codFilme) {
        this.codFilme = codFilme;
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
    
    public Set<Fita> getFitas() {
        return fitas;
    }
    
    public void setFitas(Set<Fita> fitas) {
        this.fitas = fitas;
    }
    
    public Set<AtorFilme> getAtoresFilmes() {
        return atoresFilmes;
    }
    
    public void setAtoresFilmes(Set<AtorFilme> atoresFilmes) {
        this.atoresFilmes = atoresFilmes;
    }
    
    @Override
    public String toString() {
        return "Filme{" +
                "codFilme='" + codFilme + '\'' +
                ", nome='" + nome + '\'' +
                ", diretor='" + diretor + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Filme)) return false;
        Filme filme = (Filme) o;
        return codFilme != null ? codFilme.equals(filme.codFilme) : filme.codFilme == null;
    }
    
    @Override
    public int hashCode() {
        return codFilme != null ? codFilme.hashCode() : 0;
    }
}