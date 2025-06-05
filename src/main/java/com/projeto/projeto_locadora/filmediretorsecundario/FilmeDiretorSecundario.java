package com.projeto.projeto_locadora.filmediretorsecundario;

import jakarta.persistence.*;
import com.projeto.projeto_locadora.filme.Filme;
import com.projeto.projeto_locadora.diretorsecundario.DiretorSecundario;

@Entity
@Table(name = "filme_diretorsecundario")
public class FilmeDiretorSecundario {
    
    @EmbeddedId
    private FilmeDiretorSecundarioId id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("codFilme")
    @JoinColumn(name = "cod_filme")
    private Filme filme;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("codDiretorSec")
    @JoinColumn(name = "cod_diretorsec")
    private DiretorSecundario diretorSecundario;
    
    public FilmeDiretorSecundario() {}
    
    public FilmeDiretorSecundario(Filme filme, DiretorSecundario diretorSecundario) {
        this.filme = filme;
        this.diretorSecundario = diretorSecundario;
        this.id = new FilmeDiretorSecundarioId(filme.getCodFilme(), diretorSecundario.getCodDiretorSec());
    }
    
    public FilmeDiretorSecundarioId getId() {
        return id;
    }
    
    public void setId(FilmeDiretorSecundarioId id) {
        this.id = id;
    }
    
    public Filme getFilme() {
        return filme;
    }
    
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    public DiretorSecundario getDiretorSecundario() {
        return diretorSecundario;
    }
    
    public void setDiretorSecundario(DiretorSecundario diretorSecundario) {
        this.diretorSecundario = diretorSecundario;
    }
    
    @Override
    public String toString() {
        return "FilmeDiretorSecundario{" +
                "filme=" + (filme != null ? filme.getCodFilme() : null) +
                ", diretorSecundario=" + (diretorSecundario != null ? diretorSecundario.getCodDiretorSec() : null) +
                '}';
    }
}