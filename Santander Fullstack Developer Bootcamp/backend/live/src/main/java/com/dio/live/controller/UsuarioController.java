package com.dio.live.controller;

import java.util.List;

import com.dio.live.model.Usuario;
import com.dio.live.service.UsuarioService;

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
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @GetMapping("/list")
    public List<Usuario> getList() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable("id") long id) throws Exception {
        return usuarioService.getById(id).orElseThrow(() -> new Exception("Usuário não encontrado."));
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario usuario) {
        return usuarioService.update(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        usuarioService.delete(id);
    }

}
