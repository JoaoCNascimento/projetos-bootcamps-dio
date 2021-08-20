package com.dio.live.controller;

import java.util.List;

import com.dio.live.model.Empresa;
import com.dio.live.service.EmpresaService;

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
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public Empresa create(@RequestBody Empresa empresa) {
        return empresaService.save(empresa);
    }

    @GetMapping("/list")
    public List<Empresa> getList() {
        return empresaService.findAll();
    }

    @GetMapping("/{id}")
    public Empresa getById(@PathVariable("id") long id) throws Exception {
        return empresaService.getById(id).orElseThrow(() -> new Exception("Empresa não encontrada."));
    }

    @PutMapping
    public Empresa update(@RequestBody Empresa empresa) {
        return empresaService.update(empresa);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        empresaService.delete(id);
    }

}
