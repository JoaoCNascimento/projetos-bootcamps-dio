package com.dio.live.controller;

import java.util.List;

import com.dio.live.model.Localidade;
import com.dio.live.service.LocalidadeService;

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
@RequestMapping("/localidade")
public class LocalidadeController {

    @Autowired
    LocalidadeService localidadeService;

    @PostMapping
    public Localidade create(@RequestBody Localidade localidade) {
        return localidadeService.save(localidade);
    }

    @GetMapping("/list")
    public List<Localidade> getList() {
        return localidadeService.findAll();
    }

    @GetMapping("/{id}")
    public Localidade getById(@PathVariable("id") long id) throws Exception {
        return localidadeService.getById(id).orElseThrow(() -> new Exception("Localidade não encontrada."));
    }

    @PutMapping
    public Localidade update(@RequestBody Localidade localidade) {
        return localidadeService.update(localidade);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        localidadeService.delete(id);
    }

}
