package com.dio.live.controller;

import java.util.List;

import com.dio.live.model.Ocorrencia;
import com.dio.live.service.OcorrenciaService;

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
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    OcorrenciaService ocorrenciaService;

    @PostMapping
    public Ocorrencia create(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.save(ocorrencia);
    }

    @GetMapping("/list")
    public List<Ocorrencia> getList() {
        return ocorrenciaService.findAll();
    }

    @GetMapping("/{id}")
    public Ocorrencia getById(@PathVariable("id") long id) throws Exception {
        return ocorrenciaService.getById(id).orElseThrow(() -> new Exception("Ocorrência não encontrada."));
    }

    @PutMapping
    public Ocorrencia update(@RequestBody Ocorrencia ocorrencia) {
        return ocorrenciaService.update(ocorrencia);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        ocorrenciaService.delete(id);
    }

}
