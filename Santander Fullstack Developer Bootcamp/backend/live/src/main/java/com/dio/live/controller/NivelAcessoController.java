package com.dio.live.controller;

import java.util.List;

import com.dio.live.model.NivelAcesso;
import com.dio.live.service.NivelAcessoService;

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
@RequestMapping("/nivel-acesso")
public class NivelAcessoController {

    @Autowired
    NivelAcessoService nivelAcessoService;

    @PostMapping
    public NivelAcesso create(@RequestBody NivelAcesso nivelAcesso) {
        return nivelAcessoService.save(nivelAcesso);
    }

    @GetMapping("/list")
    public List<NivelAcesso> getList() {
        return nivelAcessoService.findAll();
    }

    @GetMapping("/{id}")
    public NivelAcesso getById(@PathVariable("id") long id) throws Exception {
        return nivelAcessoService.getById(id).orElseThrow(() -> new Exception("Nível de acesso não encontrado."));
    }

    @PutMapping
    public NivelAcesso update(@RequestBody NivelAcesso nivelAcesso) {
        return nivelAcessoService.update(nivelAcesso);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        nivelAcessoService.delete(id);
    }

}
