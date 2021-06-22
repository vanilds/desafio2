package com.example.angular.springbootcrudapi.controller;

import com.example.angular.springbootcrudapi.ResourceNotFoundException;
import com.example.angular.springbootcrudapi.model.Lancamento;
import com.example.angular.springbootcrudapi.repository.LancamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.HashMap;
import java.util.List;
//import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LancamentoController {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @PostMapping("/lancamentos")
    public Lancamento addLancamento(@RequestBody Lancamento lancamentos) {
        return lancamentoRepository.save(lancamentos);
    }


    @GetMapping("/lancamentos")
    public ResponseEntity<List<Lancamento>> getAllLancamento() {

        return ResponseEntity.ok(lancamentoRepository.findAll());
    }

    @GetMapping("/lancamentos/{id}")
    public ResponseEntity<Lancamento> getLancamentoById(@PathVariable(value = "id") Integer lancamentosId)
            throws ResourceNotFoundException {
        Lancamento lancamentos = lancamentoRepository.findById(lancamentosId)
                .orElseThrow(() -> new ResourceNotFoundException("Lancamento not found for this id :: " + lancamentosId));
        return ResponseEntity.ok().body(lancamentos);
    }

    
    @GetMapping("/categorias")
    public ResponseEntity<List<Lancamento>> getCategoria() {

        return ResponseEntity.ok(lancamentoRepository.findAll());
    }

    @GetMapping("/categorias/{id}")
    public ResponseEntity<Lancamento> getCategoriaById(@PathVariable(value = "id") Integer categoriasId)
            throws ResourceNotFoundException {
        Lancamento categorias = lancamentoRepository.findById(categoriasId)
                .orElseThrow(() -> new ResourceNotFoundException("Lancamento not found for this id :: " + categoriasId));
        return ResponseEntity.ok().body(categorias);
    }
    
    @GetMapping("/lancamentos/{categoria}")
    public ResponseEntity<Lancamento> getLancamentoByCategoria(@PathVariable(value = "id") Integer lancamentosCategoria)
            throws ResourceNotFoundException {
        Lancamento lancamentos = lancamentoRepository.findById(lancamentosCategoria)
                .orElseThrow(() -> new ResourceNotFoundException("Lancamento not found for this id :: " + lancamentosCategoria));
        return ResponseEntity.ok().body(lancamentos);
    }
    
    

}

