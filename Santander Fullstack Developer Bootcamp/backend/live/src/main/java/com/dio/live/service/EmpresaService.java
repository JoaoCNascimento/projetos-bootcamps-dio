package com.dio.live.service;

import java.util.List;
import java.util.Optional;

import com.dio.live.model.Empresa;
import com.dio.live.repository.EmpresaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

    @Autowired
    EmpresaRepository empresaRepository;

    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public Optional<Empresa> getById(long id) {
        return empresaRepository.findById(id);
    }

    public Empresa update(Empresa empresa) {
        return empresaRepository.save(empresa);
    }

    public void delete(long id) {
        empresaRepository.deleteById(id);
    }
}
