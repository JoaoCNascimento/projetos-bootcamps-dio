package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import com.dio.live.model.CategoriaUsuario;
import com.dio.live.repository.CategoriaUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaUsuarioService {

    @Autowired
    CategoriaUsuarioRepository categoriaUsuarioRepository;

    public CategoriaUsuario save(CategoriaUsuario categoriaUsuario) {
        return categoriaUsuarioRepository.save(categoriaUsuario);
    }

    public List<CategoriaUsuario> findAll() {
        return categoriaUsuarioRepository.findAll();
    }

    public Optional<CategoriaUsuario> getById(long id) {
        return categoriaUsuarioRepository.findById(id);
    }

    public CategoriaUsuario update(CategoriaUsuario usuario) {
        return categoriaUsuarioRepository.save(usuario);
    }

    public void delete(long id) {
        categoriaUsuarioRepository.deleteById(id);
    }
}
