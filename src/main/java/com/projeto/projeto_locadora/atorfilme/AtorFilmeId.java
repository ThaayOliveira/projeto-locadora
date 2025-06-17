package com.projeto.projeto_locadora.atorfilme;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class AtorFilmeId implements Serializable {
    
    @Column(name = "cod_ator")
    private String codAtor;
    
    @Column(name = "cod_filme")
    private String codFilme;
    
    public AtorFilmeId() {}
    
    public AtorFilmeId(String codAtor, String codFilme) {
        this.codAtor = codAtor;
        this.codFilme = codFilme;
    }
    
    public String getCodAtor() {
        return codAtor;
    }
    
    public void setCodAtor(String codAtor) {
        this.codAtor = codAtor;
    }
    
    public String getCodFilme() {
        return codFilme;
    }
    
    public void setCodFilme(String codFilme) {
        this.codFilme = codFilme;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AtorFilmeId)) return false;
        AtorFilmeId that = (AtorFilmeId) o;
        return Objects.equals(codAtor, that.codAtor) && 
               Objects.equals(codFilme, that.codFilme);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(codAtor, codFilme);
    }
    
    @Override
    public String toString() {
        return "AtorFilmeId{" +
                "codAtor='" + codAtor + '\'' +
                ", codFilme='" + codFilme + '\'' +
                '}';
    }
}