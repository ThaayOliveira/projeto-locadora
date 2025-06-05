package com.projeto.projeto_locadora.filmesfita;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FilmesFitaId implements Serializable {
    
    @Column(name = "cod_fita")
    private String codFita;
    
    @Column(name = "cod_filme")
    private String codFilme;
    
    public FilmesFitaId() {}
    
    public FilmesFitaId(String codFita, String codFilme) {
        this.codFita = codFita;
        this.codFilme = codFilme;
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmesFitaId)) return false;
        FilmesFitaId that = (FilmesFitaId) o;
        return Objects.equals(codFita, that.codFita) && 
               Objects.equals(codFilme, that.codFilme);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(codFita, codFilme);
    }
}