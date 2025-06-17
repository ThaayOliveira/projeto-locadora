package com.projeto.projeto_locadora.item;

import com.projeto.projeto_locadora.item.Status.ItemStatus;
import com.projeto.projeto_locadora.item.Status.TipoItem;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String titulo;
    String genero;
    Double precoDiario;
    @Enumerated(EnumType.STRING)
    TipoItem tipo;
    @Enumerated(EnumType.STRING)
    ItemStatus status;
    String imagemUrl;

    // public Item(String titulo, String genero, Double precoDiario, TipoItem tipo) {
    //     this.titulo = titulo;
    //     this.genero = genero;
    //     this.precoDiario = precoDiario;
    //     this.tipo = tipo;
    // }

    public Item() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getPrecoDiario() {
        return precoDiario;
    }

    public void setPrecoDiario(Double precoDiario) {
        this.precoDiario = precoDiario;
    }

    public TipoItem getTipo() {
        return tipo;
    }

    public void setTipo(TipoItem tipo) {
        this.tipo = tipo;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public void setStatus(ItemStatus status) {
        this.status = status;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }


}
