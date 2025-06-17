package com.projeto.projeto_locadora.ator;

import jakarta.persistence.*;
import java.util.Set;

<<<<<<< HEAD
import com.projeto.projeto_locadora.atorfilme.model.AtorFilme;
=======
import com.projeto.projeto_locadora.atorfilme.AtorFilme;
>>>>>>> d0e3253 (Salvar progresso antes de mudar para a branch locacao)


@Entity
@Table(name = "ator")
public class Ator {
    
    @Id
    @Column(name = "cod_ator")
    private String codAtor;
    
    @Column(name = "nome")
    private String nome;
    
    @OneToMany(mappedBy = "ator", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<AtorFilme> atoresFilmes;
    
    public Ator() {}
    
    public Ator(String codAtor, String nome) {
        this.codAtor = codAtor;
        this.nome = nome;
    }
    
    public String getCodAtor() {
        return codAtor;
    }
    
    public void setCodAtor(String codAtor) {
        this.codAtor = codAtor;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Set<AtorFilme> getAtoresFilmes() {
        return atoresFilmes;
    }
    
    public void setAtoresFilmes(Set<AtorFilme> atoresFilmes) {
        this.atoresFilmes = atoresFilmes;
    }
    
    @Override
    public String toString() {
        return "Ator{" +
                "codAtor='" + codAtor + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ator)) return false;
        Ator ator = (Ator) o;
        return codAtor != null ? codAtor.equals(ator.codAtor) : ator.codAtor == null;
    }
    
    @Override
    public int hashCode() {
        return codAtor != null ? codAtor.hashCode() : 0;
    }
}