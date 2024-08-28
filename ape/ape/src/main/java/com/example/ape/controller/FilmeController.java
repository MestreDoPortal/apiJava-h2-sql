package com.example.ape.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ape.model.Filme;
import com.example.ape.repository.FilmeRepository;


    
    @RestController
    @RequestMapping("/filmes")
    public class FilmeController {
    
        @Autowired
        private FilmeRepository filmeRepository;

        @GetMapping
        public List<Filme> listar() {
            return filmeRepository.findAll();
        }
        
    
        @PostMapping
        public Filme adicionar(@RequestBody Filme filme) {
            return filmeRepository.save(filme);
            
        }
    
        @PutMapping("/{id}")
        public Filme atualizarFilme(@PathVariable Long id, @RequestBody Filme filmeAtualizado) {
            return filmeRepository.findById(id)
            .map(filme ->{
                filme.setNome(filmeAtualizado.getNome());
                filme.setCategoria(filmeAtualizado.getCategoria());
                return filmeRepository.save(filme);
            })
            .orElseThrow();
        }
    
        @PatchMapping("/{id}")
        public ResponseEntity<Filme> patchFilme(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return filmeRepository.findById(id)
            .map(filme -> {
                if (updates.containsKey("nome")) {
                    filme.setNome((String) updates.get("nome"));
                }
                if (updates.containsKey("categoria")) {
                    filme.setCategoria((String) updates.get("categoria"));
                }
                Filme atualizado = filmeRepository.save(filme);
                return ResponseEntity.ok(atualizado);
            })
            .orElse(ResponseEntity.notFound().build());
        }
    
        @DeleteMapping("/{id}")
        public void deletarFilme(@PathVariable Long id) {
            filmeRepository.deleteById(id);
        }
    }
    