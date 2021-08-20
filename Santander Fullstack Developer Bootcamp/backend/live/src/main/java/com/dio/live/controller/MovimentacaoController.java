package com.dio.live.controller;

import java.util.List;

import com.dio.live.model.Movimentacao;
import com.dio.live.service.MovimentacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoService movimentacaoService;

    @PostMapping
    public Movimentacao create(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.save(movimentacao);
    }

    @GetMapping("/list")
    public List<Movimentacao> getList() {
        return movimentacaoService.findAll();
    }

    @GetMapping("/{id}")
    public Movimentacao getById(@PathVariable("id") long id) throws Exception {
        return movimentacaoService.getById(id).orElseThrow(() -> new Exception("Movimentação não encontrada."));
    }

    @PutMapping
    public Movimentacao update(@RequestBody Movimentacao movimentacao) {
        return movimentacaoService.update(movimentacao);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        movimentacaoService.delete(id);
    }

}
