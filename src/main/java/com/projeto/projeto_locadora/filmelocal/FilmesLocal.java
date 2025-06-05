package com.projeto.projeto_locadora.filmelocal;

import jakarta.persistence.*;
import java.util.List;

import com.projeto.projeto_locadora.filme.Filme;
import com.projeto.projeto_locadora.fitalocacao.FitaLocacao;
import com.projeto.projeto_locadora.local.Local;

@Entity
@Table(name = "filmes_local")
@IdClass(FilmesLocalId.class)
public class FilmesLocal {
    
    @Id
    @Column(name = "cod_filme")
    private String codFilme;
    
    @Id
    @Column(name = "cod_local")
    private String codLocal;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_local", insertable = false, updatable = false)
    private Local local;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_filme", insertable = false, updatable = false)
    private Filme filme;
    
    @OneToMany(mappedBy = "filmesLocal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FitaLocacao> fitasLocacao;
    
    public FilmesLocal() {}
    
    public FilmesLocal(String codFilme, String codLocal) {
        this.codFilme = codFilme;
        this.codLocal = codLocal;
    }
    
    public String getCodFilme() {
        return codFilme;
    }
    
    public void setCodFilme(String codFilme) {
        this.codFilme = codFilme;
    }
    
    public String getCodLocal() {
        return codLocal;
    }
    
    public void setCodLocal(String codLocal) {
        this.codLocal = codLocal;
    }
    
    public Local getLocal() {
        return local;
    }
    
    public void setLocal(Local local) {
        this.local = local;
    }
    
    public Filme getFilme() {
        return filme;
    }
    
    public void setFilme(Filme filme) {
        this.filme = filme;
    }
    
    public List<FitaLocacao> getFitasLocacao() {
        return fitasLocacao;
    }
    
    public void setFitasLocacao(List<FitaLocacao> fitasLocacao) {
        this.fitasLocacao = fitasLocacao;
    }
}