package com.projeto.projeto_locadora.atorfilme.model;

import jakarta.persistence.*;
import com.projeto.projeto_locadora.ator.Ator;
import com.projeto.projeto_locadora.filme.Filme;

@Entity
@Table(name = "ator_filme")
public class AtorFilme {
    
    @EmbeddedId
    private AtorFilmeId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("codAtor")
    @JoinColumn(name = "cod_ator")
    private Ator ator;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("codFilme")
    @JoinColumn(name = "cod_filme")
    private Filme filme;
    
    public AtorFilme() {}
    
    public AtorFilme(Ator ator, Filme filme) {
        this.ator = ator;
        this.filme = filme;
        this.id = new AtorFilmeId(ator.getCodAtor(), filme.getCodFilme());
    }
    
    public AtorFilmeId getId() {
        return id;
    }
    
    public void setId(AtorFilmeId id) {
        this.id = id;
    }
    
    public Ator getAtor() {
        return ator;
    }
    
    public void setAtor(Ator ator) {
        this.ator = ator;
    }
    
    public Filme getFilme() {
        return filme;
    }
    
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    @Override
    public String toString() {
        return "AtorFilme{" +
                "ator=" + (ator != null ? ator.getCodAtor() : null) +
                ", filme=" + (filme != null ? filme.getCodFilme() : null) +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtorFilme)) return false;
        AtorFilme atorFilme = (AtorFilme) o;
        return id != null ? id.equals(atorFilme.id) : atorFilme.id == null;
    }
    
    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}