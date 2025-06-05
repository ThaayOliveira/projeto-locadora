package com.projeto.projeto_locadora.fitalocacao;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FitaLocacaoId implements Serializable {

    @Column(name = "cod_fita")
    private String codFita;

    @Column(name = "cod_locacao")
    private String codLocacao;

    public FitaLocacaoId() {}

    public FitaLocacaoId(String codFita, String codLocacao) {
        this.codFita = codFita;
        this.codLocacao = codLocacao;
    }

    public String getCodFita() {
        return codFita;
    }

    public void setCodFita(String codFita) {
        this.codFita = codFita;
    }

    public String getCodLocacao() {
        return codLocacao;
    }

    public void setCodLocacao(String codLocacao) {
        this.codLocacao = codLocacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FitaLocacaoId)) return false;
        FitaLocacaoId that = (FitaLocacaoId) o;
        return Objects.equals(codFita, that.codFita) &&
               Objects.equals(codLocacao, that.codLocacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codFita, codLocacao);
    }
}