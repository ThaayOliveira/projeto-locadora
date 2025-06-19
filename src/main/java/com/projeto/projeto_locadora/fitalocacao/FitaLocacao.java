package com.projeto.projeto_locadora.fitalocacao;

import jakarta.persistence.*;

import com.projeto.projeto_locadora.filmelocal.FilmesLocal;
import com.projeto.projeto_locadora.fita.Fita;
import com.projeto.projeto_locadora.operacaolocacao.Locacao;

@Entity
@Table(name = "fita_locacao")
public class FitaLocacao {

    @Id
    @Column(name = "cod_fita")
    private String codFita;

    @Column(name = "cod_filme")
    private String codFilme;

    @Column(name = "valor_fita")
    private Double valorFita;

    @Column(name = "cod_locacao", length = 50)
    private String codLocacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_locacao")
    private Locacao locacao;
    

    @ManyToOne
    @JoinColumn(name = "cod_fita", insertable = false, updatable = false)
    private Fita fita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "cod_filme", referencedColumnName = "cod_filme", insertable = false, updatable = false),
            @JoinColumn(name = "cod_local", referencedColumnName = "cod_local", insertable = false, updatable = false)
    })
    private FilmesLocal filmesLocal;

    public FitaLocacao() {
    }

    public FitaLocacao(String codFita, String codFilme, Double valorFita) {
        this.codFita = codFita;
        this.codFilme = codFilme;
        this.valorFita = valorFita;
    }

    public String getCodFita() {
        return codFita;
    }

    public void setCodFita(String codFita) {
        this.codFita = codFita;
    }

    public String getCodFilme() {
        return codFilme;
    }

    public void setCodFilme(String codFilme) {
        this.codFilme = codFilme;
    }

    public Double getValorFita() {
        return valorFita;
    }

    public void setValorFita(Double valorFita) {
        this.valorFita = valorFita;
    }

    public FilmesLocal getFilmesLocal() {
        return filmesLocal;
    }

    public void setFilmesLocal(FilmesLocal filmesLocal) {
        this.filmesLocal = filmesLocal;
    }
}
