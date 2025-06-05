package com.projeto.projeto_locadora.filmelocal;

import java.io.Serializable;
import java.util.Objects;

public class FilmesLocalId implements Serializable {
    
    private String codFilme;
    private String codLocal;
    
    public FilmesLocalId() {}
    
    public FilmesLocalId(String codFilme, String codLocal) {
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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmesLocalId that = (FilmesLocalId) o;
        return Objects.equals(codFilme, that.codFilme) && 
               Objects.equals(codLocal, that.codLocal);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(codFilme, codLocal);
    }
}