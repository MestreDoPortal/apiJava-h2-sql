package com.example.ape.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Filme {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (Id ^ (Id >>> 32));
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Filme other = (Filme) obj;
        if (Id != other.Id)
            return false;
        return true;
    }
    @Column(nullable = false)
    private String nome;
    private String categoria;


    

    public Filme() {
    }
    public Filme(long id, String nome, String categoria) {
        Id = id;
        this.nome = nome;
        this.categoria = categoria;
    }
    
    public long getId() { 
        return Id;
    }
    public void setId(long id) {
        Id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}

