package com.projeto.projeto_locadora.filmesfita;

import jakarta.persistence.*;
import com.projeto.projeto_locadora.filme.Filme;
import com.projeto.projeto_locadora.fita.Fita;

@Entity
@Table(name = "filmes_fita")
public class FilmesFita {
    
    @EmbeddedId
    private FilmesFitaId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("codFita")
    @JoinColumn(name = "cod_fita")
    private Fita fita;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("codFilme")
    @JoinColumn(name = "cod_filme")
    private Filme filme;
    
    public FilmesFita() {}
    
    public FilmesFita(Fita fita, Filme filme) {
        this.fita = fita;
        this.filme = filme;
        this.id = new FilmesFitaId(fita.getCodFita(), filme.getCodFilme());
    }
    
    public FilmesFitaId getId() {
        return id;
    }
    
    public void setId(FilmesFitaId id) {
        this.id = id;
    }
    
    public Fita getFita() {
        return fita;
    }
    
    public void setFita(Fita fita) {
        this.fita = fita;
    }
    
    public Filme getFilme() {
        return filme;
    }
    
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    @Override
    public String toString() {
        return "FilmesFita{" +
                "fita=" + (fita != null ? fita.getCodFita() : null) +
                ", filme=" + (filme != null ? filme.getCodFilme() : null) +
                '}';
    }
}