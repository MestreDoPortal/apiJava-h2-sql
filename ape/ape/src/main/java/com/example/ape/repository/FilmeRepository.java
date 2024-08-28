package com.example.ape.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ape.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme,Long>{
    
}
