package com.projeto.projeto_locadora.local;

import jakarta.persistence.*;
import java.util.List;

import com.projeto.projeto_locadora.filmelocal.FilmesLocal;

@Entity
@Table(name = "local")
public class Local {
    
    @Id
    @Column(name = "cod_local")
    private String codLocal;
    
    @Column(name = "nome_local")
    private String nomeLocal;
    
    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FilmesLocal> filmesLocais;
    
    public Local() {}
    
    public Local(String codLocal, String nomeLocal) {
        this.codLocal = codLocal;
        this.nomeLocal = nomeLocal;
    }
    
    public String getCodLocal() {
        return codLocal;
    }
    
    public void setCodLocal(String codLocal) {
        this.codLocal = codLocal;
    }
    
    public String getNomeLocal() {
        return nomeLocal;
    }
    
    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }
    
    public List<FilmesLocal> getFilmesLocais() {
        return filmesLocais;
    }
    
    public void setFilmesLocais(List<FilmesLocal> filmesLocais) {
        this.filmesLocais = filmesLocais;
    }
}