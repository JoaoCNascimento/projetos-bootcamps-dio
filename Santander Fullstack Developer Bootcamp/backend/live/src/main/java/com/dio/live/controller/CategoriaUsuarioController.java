package com.dio.live.controller;

import java.util.List;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.service.CategoriaUsuarioService;

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
@RequestMapping("/categoria-usuario")
public class CategoriaUsuarioController {

    @Autowired
    CategoriaUsuarioService categoriaUsuariosService;

    @PostMapping
    public CategoriaUsuario create(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaUsuariosService.save(categoriaUsuario);
    }

    @GetMapping("/list")
    public List<CategoriaUsuario> getList() {
        return categoriaUsuariosService.findAll();
    }

    @GetMapping("/{id}")
    public CategoriaUsuario getById(@PathVariable("id") long id) throws Exception {
        return categoriaUsuariosService.getById(id).orElseThrow(() -> new Exception("Categoria não encontrada."));
    }

    @PutMapping
    public CategoriaUsuario update(@RequestBody CategoriaUsuario categoriaUsuario) {
        return categoriaUsuariosService.update(categoriaUsuario);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        categoriaUsuariosService.delete(id);
    }

}
