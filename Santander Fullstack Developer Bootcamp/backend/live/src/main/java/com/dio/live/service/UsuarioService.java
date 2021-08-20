package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import com.dio.live.model.Usuario;
import com.dio.live.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getById(long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario update(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }
}
