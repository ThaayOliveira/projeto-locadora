package com.projeto.projeto_locadora.filmediretorsecundario;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FilmeDiretorSecundarioId implements Serializable {
    
    @Column(name = "cod_filme")
    private String codFilme;
    
    @Column(name = "cod_diretorsec")
    private String codDiretorSec;
    
    public FilmeDiretorSecundarioId() {}
    
    public FilmeDiretorSecundarioId(String codFilme, String codDiretorSec) {
        this.codFilme = codFilme;
        this.codDiretorSec = codDiretorSec;
    }
    
    public String getCodFilme() {
        return codFilme;
    }
    
    public void setCodFilme(String codFilme) {
        this.codFilme = codFilme;
    }
    
    public String getCodDiretorSec() {
        return codDiretorSec;
    }
    
    public void setCodDiretorSec(String codDiretorSec) {
        this.codDiretorSec = codDiretorSec;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmeDiretorSecundarioId)) return false;
        FilmeDiretorSecundarioId that = (FilmeDiretorSecundarioId) o;
        return Objects.equals(codFilme, that.codFilme) && 
               Objects.equals(codDiretorSec, that.codDiretorSec);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(codFilme, codDiretorSec);
    }
}