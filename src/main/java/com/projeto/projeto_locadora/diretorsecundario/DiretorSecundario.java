package com.projeto.projeto_locadora.diretorsecundario;

import jakarta.persistence.*;
import java.util.Set;
import com.projeto.projeto_locadora.filmediretorsecundario.FilmeDiretorSecundario;

@Entity
@Table(name = "diretor_secundario")
public class DiretorSecundario {
    
    @Id
    @Column(name = "cod_diretorsec")
    private String codDiretorSec;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "cargo")
    private String cargo;
    
    @OneToMany(mappedBy = "diretorSecundario", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<FilmeDiretorSecundario> filmesDiretorSecundario;
    
    public DiretorSecundario() {}
    
    public DiretorSecundario(String codDiretorSec, String nome, String cargo) {
        this.codDiretorSec = codDiretorSec;
        this.nome = nome;
        this.cargo = cargo;
    }
    
    public String getCodDiretorSec() {
        return codDiretorSec;
    }
    
    public void setCodDiretorSec(String codDiretorSec) {
        this.codDiretorSec = codDiretorSec;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public Set<FilmeDiretorSecundario> getFilmesDiretorSecundario() {
        return filmesDiretorSecundario;
    }
    
    public void setFilmesDiretorSecundario(Set<FilmeDiretorSecundario> filmesDiretorSecundario) {
        this.filmesDiretorSecundario = filmesDiretorSecundario;
    }
    
    @Override
    public String toString() {
        return "DiretorSecundario{" +
                "codDiretorSec='" + codDiretorSec + '\'' +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DiretorSecundario)) return false;
        DiretorSecundario that = (DiretorSecundario) o;
        return codDiretorSec != null ? codDiretorSec.equals(that.codDiretorSec) : that.codDiretorSec == null;
    }
    
    @Override
    public int hashCode() {
        return codDiretorSec != null ? codDiretorSec.hashCode() : 0;
    }
}